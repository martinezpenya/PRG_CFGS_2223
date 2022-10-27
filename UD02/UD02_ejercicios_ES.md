---
title: Ejercicios de la UD02 
language: ES
author: David Martínez Peña [www.martinezpenya.es]
subject: Programación de Servicios y Procesos
keywords: [PSP, 2022, Programacion, servicios, procesos, multihilo, Java]
IES: IES Eduardo Primo Marqués (Carlet) [www.ieseduardoprimo.es]
header: ${title} - ${subject} (ver. ${today}) 
footer:${currentFileName}.pdf - ${author} - ${IES} - ${pageNo}/${pageCount}
typora-root-url:${filename}/../
typora-copy-images-to:${filename}/../assets
imgcover:/media/DADES/NextCloud/DOCENCIA/PSP_2223/PSP-CFGS-2223/UD01/assets/cover.png
---
[toc]

# Ejercicios

1. Crea dos clases (hilos) Java que extiendan la clase `Thread`. Uno de los hilos debe mostrar en pantalla en un bucle infinito la palabra PING y el otro la palabra PONG. Dentro del bucle utiliza el método `sleep()` para que nos de tiempo a ver las palabras que se visualizan cuando lo ejecutemos, tendrás que añadir un bloque `try-catch` (para capturar la excepción `InterruptedException`). Crea después la función `main()` que haga uso de los hilos anteriores. ¿Se visualizan los textos PING y PONG de forma ordenada (es decir PING PONG PING PONG ...)?

2. Transforma el ejercicio anterior pero usando la interfaz Runnable para declarar el hilo. 

3. Realiza una aplicación que ejecute 4 hilos de forma que se ejecuten de forma ordenada uno detrás de otro esperando cada uno a que termine el anterior para ejecutarse

4. Crea una clase Java que utilice 5 hilos para contar el número de vocales que hay en un determinado texto. Cada hilo se encargará de contar una vocal diferente, actualizando todos los hilos la misma variable común que representa el número de vocales totales. Para evitar condiciones de carrera se deben utilizar métodos sincronizados.

5. Crea un programa Java que lance cinco hilos, cada uno incrementará una variable contador (entera y compartida por todos) 5000 veces y luego saldrá. Comprueba el resultado final de la variable. ¿Se obtiene el resultado correcto?

   Ahora sincroniza el acceso a dicha variable. Lanza los hilos primero mediante `Thread` y luego mediante la interfaz `Runnable`. Comprueba los resultados realizando una tabla comparativa entre los tres apartados.

6. Planificación de ejercicios de estiramiento
   Crea una aplicación que, utilizando las clases `Timer` y `TimerTask` recuerde al usuario que hay que levantarse para estirar las piernas cada 30 minutos.
   Aunque está fuera del ámbito de este libro, puedes hacer que se muestre el aviso mediante una notificación del sistema operativo utilizando las clases `SystemTray` y `Traylcon` del paquete `java.awt`. Puedes encontrar múltiples ejemplos en la web.

7. Hilos durmientes

   - Crea una aplicación en Java que construya 5 hilos a partir de una única clase que herede de `Thread`.
   - Cada hilo tiene un nombre.
   - Cada hilo, en su método `run`, tiene un bucle infinito. Dentro del bucle:
     - Escribe el texto: «Soy el bucle *nombre* y estoy trabajando».
     - Detiene la ejecución durante un período de tiempo aleatorio entre 1 y 10 segundos.

8. Implemente un programa que reciba a través de sus argumentos una lista de ficheros de texto y cuente el número de caracteres que hay en cada fichero. Modifica el programa para que se cree un hilo por cada fichero a contar. Muestra lo que se tarda en contar cada fichero en la primera tarea secuencial y luego usando hilos. Para calcular el tiempo que tarda en ejecutarse un proceso podemos usar el método `System.currentTimeMilis()` de la siguiente manera:

   ```java
   long t_start, t_finish;
   t_start = System.currentTimeMilis();
   Process(); //work
   t_finish = System.currentTimeMilis();
   long t_total = t_finish - t_start;
   System.out.println("The work lasted: " + t_total + " miliseconds");
   ```

9. Haz un programa Java que reciba a través de sus argumentos una lista de ficheros de texto y cuente el número de palabras que hay en cada fichero. Se debe crear un hilo por cada fichero a contar. Muestra el número de palabras de cada fichero y lo que tarda en contar las palabras.

10. Resolución de error de concurrencia con clases de `java.util.concurrent`
   El siguiente código produce errores de concurrencia. Resuelve el problema utilizando las clases del paquete `java.util.concurrent`.

    ```java
    package UD02;
    
    import java.util.ArrayList;
    import java.util.List;
    
    public class PageManager extends Thread {
    
        private static List<String> list = new ArrayList<String>();
    
        @Override
        public void run() {
            while (true) {
                if (list.size() >= 10) {
                    list.remove(0);
                } else if (list.size() < 10) {
                    list.add("Text");
                }
                for (String s : list) {
                    //going through the list
                }
            }
        }
    
        public static void main(String[] args) {
            for (int i = 0; i < 10; i++) {
                list.add("Texto");
            }
            for (int i = 0; i < 100; i++) {
                new PageManager().start();
            }
        }
    }
    ```
    
11. Uso de semáforos
    Programa un sistema multihilo compuesto dos métodos. El código de cada uno de los métodos solo puede ser ejecutado por dos hilos simultáneamente, por lo que podrían estar en ejecución concurrente cuatro hilos, dos en cada método. Implementa la solución utilizando semáforos.

12. Se trata de simular el juego para adivinar un número. Se crearán varios hilos, los hilos son los jugadores que tienen que adivinar el número. Habrá un árbitro que generará el número a adivinar, comprobará la jugada del jugador y averiguará a qué jugador le toca jugar. El número tiene que estar comprendido entre 1 y 10, usa la siguiente fórmula para generar el nuero: `1 + (int)(10*Math.random());`

    Se definen 3 clases:

    - `Arbitro`: Contiene el número a adivinar, el turno y muestra el resultado. Se definen los siguientes atributos: el número total de jugadores, el turno, el número a adivinar y si el juego acabó o no. En el constructor se recibe el número de jugadores que participan y se inicializan el número a adivinar y el turno. Tiene varios métodos: uno que devuelve el turno, otro que indica si el juego se acabó o no y el tercer método que comprueba la jugada del jugador y averigua a quien le toca a continuación, este método recibirá el identificador de jugador y el número que ha jugado; deberá definirse como `synchronized`, así cuando un jugador está haciendo la jugada, ningún otro podrá interferir. En este método se indicará cual es el siguiente turno y si el juego ha finalizado porque algún jugador ha acertado el número.
    - `Jugador`: Extiende `Thread`. Su constructor recibe un identificador de jugador y el árbitro, todos los hilos comparten el árbitro. El jugador dentro del método `run` comprobará si es su turno, en ese caso generará un número aleatorio entre 1 y 10 y creará la jugada usando el método correspondiente del árbitro. Este proceso se repetirá hasta que el juego se acabe.
    - `Main`: Esta clase inicializa el árbitro indicándole el número de jugadores y lanza los hilos de los jugadores, asignando un identificador a cada hilo y enviándoles el objeto árbitro que tienen que compartir.

    Ejemplo de salida al ejecutar el programa:

    ```sh
    NUMBER TO GUESS: 3
    Player1 says: 9
         It's Player2 turn
    Player2 says: 9
         It's Player3 turn
    Player3 says: 10
         It's Player1 turn
    Player1 says: 4
         It's Player2 turn
    Player2 says: 7
         It's Player3 turn
    Player3 says: 7
         It's Player1 turn
    Player1 says: 6
         It's Player2 turn
    Player2 says: 3
      Player2 wins!
    ```

# Actividades

1. ¿Qué es un thread o hilo?
   a) Un pequeño proceso que se ejecuta en su propio espacio de memoria.
   b) Una pequeña unidad de computación que se ejecuta de manera independiente.
   c) Una pequeña unidad de computación que se ejecuta dentro del contexto de un proceso.
   d) Un método sincronizado que se ejecuta de manera excluyente.

2. ¿Cuál de las siguientes no es una característica de los hilos de ejecución?
   a) Se puede ejecutar de manera independiente a los procesos del sistema.
   b) Aprovecha los núcleos del procesador generando un paralelismo real.
   c) No se puede ejecutar de manera independiente, siempre depende de un proceso.
   d) Comparten espacio de memoria.

3. ¿Qué clase permite crear hilos de ejecución en Java?
   a) La clase `Runnable`.
   b) La clase `Thread`.
   e) La clase `Exception`.
   d) La clase `Process`.

4. ¿Qué método permite iniciar la ejecución de un hilo en Java?
   a) `run`.
   b) `start`.
   e) `init`.
   d) `go`.

5. ¿Qué interfaz permite crear hilos de ejecución?
   a) La interfaz `Runnable`.
   b) La interfaz `Thread`.
   e) La interfaz `Exception`.
   d) La interfaz `Process`.

6. ¿Qué permite Runnable que no permite Thread?
   a) Crear un hilo.
   b) Implementar el método `run`.
   c) Crear múltiples hilos basándose en un único objeto.
   d) Compartir información entre hilos.

7. Qué clase del paquete `java.lang` representa una tarea programable?
   a) `Thread`.
   b) `Timer`.
   e) `TimerTask`.
   d) `Runnable`.

8. ¿Qué descripción es la correcta para la interfaz `ExecutorService`?
   a) Subinterface de `Executor`, permite gestionar tareas asíncronas.
   b) Permite la planificación de la ejecución de tareas asíncronas.
   e) Fábrica de objetos `Executor` y `Callable`.
   d) Proporciona representaciones de unidades de tiempo.

9. ¿Qué clase permite limitar el número de hilos que acceden a una sección crítica?
   a) `Thread`.
   b) `Synchronized`.
   c) `Semaphore`.
   d) `Phaser`.

10. ¿Qué clase proporciona una estructura de datos sincronizada equivalente a un ArrayList?
    a) `ConcurrentHashMap`.
    b) `ConcurrentSkipListMap`.
    e) `CopyOnWriteArrayList`.
    d) `CopyOnWriteArraySet`.

11. ¿Qué método permite detener un hilo hasta que otro termine su trabajo?
    a) `run`.
    b) `join`.
    e) `sleep`.
    d) `yield`.

12. Dados dos segmentos de código cuyas salidas se asignan a las mismas variables. ¿Qué tipo de dependencia se estaría produciendo?
    a) Dependencia de flujo.
    b) Antidependencia.
    c) Dependencia de salida.
    d) No genera ninguna dependencia.

13. ¿Qué tipo de problema de concurrencia sucede cuando dos hilos tienen diferentes valores para una misma variable?
    a) Condición deslizante.
    b) Condición de carrera.
    e) Inconsistencia de memoria.
    d) Interbloqueo.

14. ¿Cómo se puede recuperar la ejecución de un hilo detenido con el método `wait`?
    a) Con el método `sleep`.
    b) Con el método `start`.
    c) Con el método `notifyAll`.
    d) Con el método `yield`.

15. Cuando varios hilos acceden a datos compartidos, y el resultado de la ejecución depende del orden concreto en que se accede a los datos compartidos se dice que:
    a) Hay una sección crítica.
    b) Hay una condición de carrera.
    c) Eso no puede suceder, los hilos no pueden compartir datos.
    d) Ninguna de las anteriores.

16. Cualquier solución al problema de la sección crítica debe cumplir las condiciones de:

    a) Exclusión mutua, progreso y espera limitada.
    b) Exclusión mutua, espera limitada y retención.
    c) Envejecimiento e inanición.
    d) Exclusión mutua, aislamiento y espera limitada.

17. Indica cuál las siguientes afirmaciones sobre los monitores es de FALSA:
    a) Permiten resolver el problema de la sección crítica.
    b) Pueden ser binarios o contadores.
    c) Se pueden utilizar para garantizar el orden de ejecución entre procesos.
    d) Son un mecanismo de sincronización. 

18. Dado el siguiente fragmento de código sobre un Objeto en particular para realizar una sección crítica:

    ```java
    notify();
    //Critical section
    wait();
    ```

    ¿Cuál de las siguientes afirmaciones es cierta?
    a) El código mostrado no asegura retención.
    b) El código mostrado no asegura exclusión mutua.
    c) Es una solución valida para el problema de la sección crítica cuando el código se ejecuta en un único procesador.
    d) El código mostrado permite resolver el problema de la sección crítica.

19. Indica cuál de las siguientes afirmaciones sobre los semáforos es FALSA:
    a) Permiten resolver el problema de la sección crítica.
    b) Pueden ser binarios o contadores.
    c) No se pueden utilizar para garantizar el orden de ejecución entre procesos.
    d) Son un mecanismo de sincronización.

20. Dado el siguiente fragmento de código, y suponiendo que el el objeto `Semaphore S` tiene como valor inicial 2:

    ```java
    S.release(S);
    Funcion();
    S.acquire(S);
    ```

    ¿Cuántos procesos pueden ejecutar al mismo tiempo la tarea Función?
    a) 0
    b) 2
    c) 3
    d) Ninguna de los anteriores. Depende de la ejecución.

21. Dado el siguiente fragmento de código ejecutado por un hilo:

    ```java
    syncronyzhed(Object){
    ...
    if (<<se cumple condicion>>)
    	wait();
    FUNCIÓN
    }
    ```

    ¿Cuál de las siguientes afirmaciones es cierta?
    a) El thread solo ejecutará FUNCIÓN cuando no se cumpla la condición.
    b) El thread podría ejecutar FUNCIÓN aunque esta se cumpla, debido a la espera del hilo por
    conseguir el monitor. 
    c) El thread podría ejecutar FUNCIÓN aunque esta se cumpla, debido que es un problema inherente al uso paralelo de threads.
    d) El thread nunca conseguirá ejecutar FUNCIÓN.

22. Una condición de carrera:
    a) Sucede por permitir que varios procesos manipulen variables compartidas de forma concurrente.
    b) Existe cuando varios procesos acceden a los mismos datos en memoria y el resultado de la
    ejecución depende del orden concreto en que se realicen los accesos.
    c) No necesita de mecanismos software para ser impedida, ya que siempre que se ejecuta el código de procesos concurrentes con los mismos argumentos, estos se ejecutarán de la misma forma.
    d) a y b son correctas.

23. Dado el siguiente fragmento de código, y suponiendo que el el objeto `Semaphore sem` tiene como valor inicial 2:

    ```java
    sem.acquire();
    ```

    ¿Qué sucederá?
    a) El proceso que ejecuta la operación se bloquea hasta que otro ejecute una operación `sem.release();`
    b) El proceso continuará adelante sin bloquearse, y si previamente existían procesos bloqueados a
    causa del semáforo, se desbloqueará uno de ellos.
    c) Tras hacer la operación, el proceso continuará adelante sin bloquearse.
    d) Un semáforo jamás podrá tener el valor 2, si su valor inicial era 0 (cero) y se ha operado correctamente con él.

24. Si se usa un bloque sincronizado para lograr la sincronización de procesos:
    a) Siempre se deben incluir variables de condición, pues el bloque únicamente proporciona exclusión mutua.
    b) Las operaciones `wait` y `notify` se utilizan dentro de un mismo objeto.
    c) Las operaciones `wait` y `notify` se utilizan en objetos separados.
    d) La variable de condición se especifica siempre con una condición `if`.

# Actividades de aplicación

1. Explica en qué se diferencia la programación secuencial de la programación concurrente.
2. Enumera y explica los estados y las transiciones por los que pasa un hilo.
3. Explica por qué con el mismo código se pueden producir ejecuciones correctas o errores de concurrencia.
4. Explica qué función tiene la interfaz `Runnable` en la programación multihilo en Java.
5. Explica qué aporta crear un hilo a partir de la interfaz `Runnable` frente a hacerlo heredando de `Thread` desde el punto de vista de la herencia.
6. Elige dos clases que representan estructuras de datos del paquete `java.util.concurrent` y explica en qué se diferencian de sus equivalentes del paquete `java.util`.
7. Indica para qué sirve el método `sleep`, cómo se puede invocar y qué excepciones puede provocar su llamada.
8. Explica qué son las interrupciones en computación.
9. Enumera y explica los mecanismos más importantes para compartir información entre hilos.
10. Explica qué garantizan las variables declaradas como `volatile`.
11. Indica cómo se utiliza el método `join` para sincronizar hilos.
12. Describe la utilidad de los semáforos en la programación concurrente.

# Actividades de ampliación

1. La clase `Thread` de Java tiene el método `stop` que está marcado como obsoleto (deprecated). Averigua la razón.

2. Averigua en qué consiste un pool de hilos. Aprende a crearlos en Java.

3. Profundiza en el conocimiento de las interrupciones en los sistemas operativos. Averigua cuáles son las principales razones por las que se provocan.

4. Averigua si existen los semáforos como herramienta de sincronización en el lenguaje Python. Aunque no sepas programar en este lenguaje, comprueba si los métodos de reserva y liberación de bloqueos es similar a Java.

5. Profundiza en el conocimiento de la computación en tarjetas de vídeo y de la arquitectura CUDA. Averigua en qué lenguajes de programación se puede trabajar con esta tecnología.

6. En computación, existe un problema clásico conocido como «La cena de los filósofos». Averigua en qué consiste y estudia alguna de las soluciones disponibles en internet.

7. En este caso práctico se va a desarrollar una solución multitarea al problema clásico de la cena de filósofos. En una mesa redonda hay N filósofos sentados. En total tiene N palillos para comer arroz, estando cada palillo compartido por dos filósofos, uno a la izquierda y otro a la derecha. Como buenos filósofos, se dedican a pensar, aunque de vez en cuando les entra hambre y quieren comer. Para poder comer, un filósofo necesita utilizar los dos palillos que hay a sus lados.

   Para implementar este problema se debe crear un programa principal que cree N hilos ejecutando el mismo código. Cada hilo representa un filósofo. Una vez creado, se realiza un bucle infinito de espera. Cada una de los hilos tendrá que realizar los siguientes pasos:

   1. Imprimir un mensaje por pantalla “Filósofo i pensando”, siendo i el identificador del filósofo.
   2. Pensar durante un cierto tiempo aleatorio.
   3. Imprimir un mensaje por pantalla “Filósofo i quiere comer”.
   4. Intentar coger los palillos que necesita para comer. El filósofo 0 necesitará los palillos 0 y 1, el filósofo 1, los palillos 1 y 2, y así sucesivamente.
   5. Cuando tenga el control de los palillos, imprimirá un mensaje en pantalla “Filósofo i comiendo”.
   6. El filósofo estará comiendo durante un tiempo aleatorio.
   7. Una vez que ha finalizado de comer, dejará los palillos en su sitio.
   8. Volver al paso 1.

   Sin embargo, se pueden producir interbloqueos si por ejemplo todos los filósofos quieren comer a la vez. Si todos consiguen coger el palillo de su izquierda ninguno podrá coger el de su derecha. Para ello se plantean varias soluciones:

   - Permitir que como máximo haya N−1 filósofos sentados a la mesa.
   - Permitir a cada filósofo coger sus palillos solamente si ambos palillos están libres.
   - Solución asimétrica: un filósofo impar coge primero el palillo de la izquierda y luego el de la derecha. Un filósofo par los coge en el orden inverso.

   Implementar una solución al problema de los filósofos, solución que no presente un problema de interbloqueo. Por sencillez, se recomienda utilizar el método propuesto de solución asimétrica.

# Ejercicios propuestos

1. Escribe una clase llamada Orden que cree dos hilos y fuerce que la escritura del segundo sea siempre anterior a la escritura por pantalla del primero.

   Ejemplo de ejecución:

   ```sh
   Hola, soy el thread número 2
   Hola, soy el thread número 1
   ```

2. Escribe una clase llamada Relevos que simule una carrera de relevos de la siguiente forma:

   - Cree 4 threads, que se quedarán a la espera de recibir alguna señal para comenzar a correr. Una vez creados los threads, se indicará que comience la carrera, con lo que uno de los threads deberá empezar a correr.
   - Cuando un thread termina de correr pone algún mensaje en pantalla y espera un par de segundos, pasando el testigo a otro de los hilos para que comience a correr, y terminando su ejecución (la suya propia).
   - Cuando el último thread termine de correr, el padre mostrará un mensaje indicando que todos los hijos han terminado.

   Ejemplo de ejecución:

   ```sh
   Todos los hilos creados.
   Doy la salida!
   Soy el thread 1, corriendo . . .
   Terminé. Paso el testigo al hijo 2
   Soy el thread 2, corriendo . . .
   Terminé. Paso el testigo al hijo 3
   Soy el thread 3, corriendo . . .
   Terminé. Paso el testigo al hijo 4
   Soy el thread 4, corriendo . . .
   Terminé!
   Todos los hilos terminaron.
   ```

3. Escribe una clase llamada `SuperMarket` que implemente el funcionamiento de `N` cajas de un supermercado. Los `M` clientes del supermercado estarán un tiempo aleatorio comprando y con posterioridad seleccionarán de forma aleatoria en qué caja posicionarse para situarse en su cola correspondiente. Cuando les toque el turno serán atendidos procediendo al pago correspondiente e ingresando en la variable Resultados del supermercado. Se deben crear tantos threads como clientes haya y los parámetros `M` y `N` se deben pasar como argumentos al programa. Para simplificar la implementación, el valor de pago de cada cliente puede ser aleatorio en el momento de su pago.

4. Escribe una clase llamada `Parking` que reciba el número de plazas del parking y el número de co-
   ches existentes en el sistema. Se deben crear tantos threads como coches haya. El parking dispondrá de una única entrada y una única salida. En la entrada de vehículos habrá un dispositivo de control que permita o impida el acceso de los mismos al parking, dependiendo del estado actual del mismo (plazas de aparcamiento disponibles). Los tiempos de espera de los vehículos dentro del parking son aleatorios. En el momento en el que un vehículo sale del parking, notifica al dispositivo de control el número de la plaza que tenía asignada y se libera la plaza que estuviera
   ocupando, quedando así estas nuevamente disponibles. Un vehículo que ha salido del parking esperará un tiempo aleatorio para volver a entrar nuevamente en el mismo. Por tanto, los vehículos estarán entrando y saliendo indefinidamente del parking. Es importante que se diseñe el programa de tal forma que se asegure que, antes o después, un vehículo que permanece esperando a la entrada del parking entrará en el mismo (no se produzca inanición).

   Ejemplo de ejecución:

   ```sh
   ENTRADA: Coche 1 aparca en 0.
   Plazas libre: 5
   Parking: [1] [2] [3] [0] [0] [0]
   ENTRADA: Coche 2 aparca en 1.
   Plazas libre: 4
   Parking: [1] [2] [3] [0] [0] [0]
   ENTRADA: Coche 3 aparca en 2.
   Plazas libre: 3
   Parking: [1] [2] [3] [0] [0] [0]
   ENTRADA: Coche 4 aparca en 3.
   Plazas libre: 2
   Parking: [1] [2] [3] [4] [0] [0]
   ENTRADA: Coche 5 aparca en 4.
   Plazas libre: 1
   Parking: [1] [2] [3] [4] [5] [0]
   SALIDA: Coche 2 saliendo.
   Plazas libre: 2
   ```

   

# Fuentes de información

- [Wikipedia](https://en.wikipedia.org)
- [Programación de servicios y procesos - FERNANDO PANIAGUA MARTÍN [Paraninfo]](https://www.paraninfo.es/catalogo/9788413665269/programacion-de-servicios-y-procesos)
- [Programación de Servicios y Procesos - ALBERTO SÁNCHEZ CAMPOS [Ra-ma]](https://www.ra-ma.es/libro/programacion-de-servicios-y-procesos-grado-superior_49240/)
- [Programación de Servicios y Procesos - Mª JESÚS RAMOS MARTÍN - [Garceta] (1ª y 2ª Edición)](https://www.garceta.es)
- [Programación de servicios y procesos - CARLOS ALBERTO CORTIJO BON [Sintesis]](https://www.sintesis.com/desarrollo%20de%20aplicaciones%20multiplataforma-341/programaci%C3%B3n%20de%20servicios%20y%20procesos-ebook-2910.html)
- [Programació de serveis i processos - JOAR ARNEDO MORENO, JOSEP CAÑELLAS BORNAS i JOSÉ ANTONIO LEO MEGÍAS [IOC]](https://ioc.xtec.cat/materials/FP/Recursos/fp_dam_m09_/web/fp_dam_m09_htmlindex/index.html)
- GitHub repositories:
  - https://github.com/ajcpro/psp
  - https://oscarmaestre.github.io/servicios/index.html
  - https://github.com/juanro49/DAM/tree/master/DAM2/PSP
  - https://github.com/pablohs1986/dam_psp2021
  - https://github.com/Perju/DAM
  - https://github.com/eldiegoch/DAM
  - https://github.com/eldiegoch/2dam-psp-public
  - https://github.com/franlu/DAM-PSP
  - https://github.com/ProgProcesosYServicios
  - https://github.com/joseluisgs
  - https://github.com/oscarnovillo/dam2_2122
  - https://github.com/PacoPortillo/DAM_PSP_Tarea02_La-Cena-de-los-Filosofos

