---
title: Ejercicios de la UD04
language: ES
author: David Martínez Peña [www.martinezpenya.es]
subject: Programación de Servicios y Procesos
keywords: [PSP, 2022, Programacion, servicios, procesos, multihilo, Java]
IES: IES Eduardo Primo Marqués (Carlet) [www.ieseduardoprimo.es]
header: ${title} - ${subject} (ver. ${today}) 
footer:${currentFileName}.pdf - ${author} - ${IES} - ${pageNo}/${pageCount}
typora-root-url:${filename}/../
typora-copy-images-to:${filename}/../assets
imgcover:/media/DADES/NextCloud/DOCENCIA/PSP_2223/PSP-CFGS-2223/UD04/assets/cover.png
---
[toc]

# Ejercicios

1. Usa los conocimientos adquiridos en la unidad para descargar un archivo `json`  y muestre el contenido correctamente formateado.

   Para ello busca y estudia el funcionamiento de algún servicio web gratuito que proporcione información en formato JSON. 

   Busca e investiga sobre como leer información de un fichero en JSON (puedes apoyarte en el API o buscar alguna libreria).

   Desarrolla una aplicación que acceda al mismo, recupere información y la muestre por pantalla. No puedes mostrar el JSON tal y como lo descargas, sino mostrando la información que contiene ya depurada.

   Algunas sugerencias de servicios web que cumplen con estos estos requisitos son las siguiente (puedes usar otra si lo prefieres):

   - Open Movie Database - http://www.omdbapi.com/
   - Consulta de premios de la Lotería de Navidad de El País - https://servicios.elpais.com/sorteos/loteria-navidad/api/
   - Datos de la Agencia estatal de Meteorología - https://opendata.aemet.es/centrode-descargas/inicio

2. Realiza un cliente FTP que pedirá por pantalla el host, puerto, usuario y contraseña para conectar a un servidor FTP. Si la conexión es satisfactoria, pedira la ruta de un archivo local para subirlo al FTP. Una vez subido lo descargará de nuevo con tu nombre y apellido y la extensión `psp`.

3. Realiza un cliente de correo electrónico, que ayudado por el SMTP de gmail pida al usuario la dirección del destinatario, del remitente, la constraseña, el asunto, el texto, y la ruta de un archivo local que se adjuntará al correo electrónico.

4. Realiza un cliente de correo electrónico, que acceda a una cuenta de gmail por IMAP. Solicitará al usuario la dirección de correo electrónico, la contraseña. Una vez correctamente conectado la aplicación mostrará un listado con todas las carpetas (etiquetas) disponibles en la cuenta de correo electrónico. El usuario podrá elegir una de ellas y a continuación se mostrará el remitente, destinatario, asunto, texto o un mensaje que indique si contiene adjuntos de todos los correos contenidos en dicha carpeta elegida por el usuario.

5. Realiza una aplicación distribuida, usando JAVA RMI de manera que el cliente solicite una operación de suma, resta, multiplicación o división al usuario, y esta en lugar de ser procesada por el cliente, sea enviada a un servidor que realizará la operación y devolverá el resultado correcto.

6. Desarrolla una aplicación distribuida en la que el servidor proporcione un servicio de obtención de definiciones de términos relacionados con cualquier disciplina.

   Por ejemplo, si se solicita la definición del término «fuselaje» relativo a las partes de los aviones, el servidor debe responder algo similar a «Parte central del avión. Es el habitáculo donde van las personas y los enseres transportados». El cliente solicitará el termino a obtener, y será el servidor quien lo proporcionará accediendo a una base de datos local, un archivo, o una estructura de datos en memoria.

# Comprobación

1. ¿Cuál es el protocolo en el que se basa la web?
   a) FTP
   b) SMTP.
   e) DNS.
   d) HTTP.
2. ¿Cuál es el código de respuesta de HTTP que indica que la página no ha sido encontrada?
   a) 204.
   b) 304.
   c) 404.
   d) 504.
3. ¿Cuál es el código de respuesta de HTTP que indica que la petición se ha atendido correctamente?
   a) 200.
   b) 300.
   e) 400.
   d) 500.
4. ¿Cuál es el protocolo específicamente diseñado para la transferencia de ficheros?
   a) FTP.
   b) SMTP.
   e) DHCP.
   d) Telnet.
5. ¿Cuál es el protocolo específicamente diseñado para el envío de correos electrónicos?
   a) SMTP.
   b) IMAP.
   e) POP3.
   d) FTP.
6. ¿Qué protocolo se utiliza para la lectura de los correos electrónicos sin que estos se eliminen del servidor?
   a) SMTP.
   b) IMAP.
   e) POP3.
   d) FTP.
7. ¿Cuál es el protocolo en el que se basa el servicio de internet que traduce los nombres de dominio a su dirección IP?
   a) SMTP
   b) Telnet.
   c) DNS.
   d) DHCP.
8.  ¿Cuál es el protocolo para conectarse remotamente a un servidor para administrarlo de manera segura desde un terminal?
   a) Telnet.
   b) HTTPS.
   c) NFS.
   d) SSH.
9. ¿Qué puerto utiliza por defecto el protocolo HTTP?
   a) 80.
   b) 443.
   c) 21.
   d) 25.
10. ¿Cuál es la clase de Java que representa una conexión HTTP?
    a) `java.net.URL`.
    b) `java.netHttpURLConnection`.
    c) `java.net.http.HttpClient`.
    d) `java.net.HttpRequest`.
11. ¿Cómo se llama el API de Java para el envío y recepción de correos?
    a) Apache Commons.
    b) Java Email API.
    c) JavaMail.
    d) Java Message API.
12. ¿Cómo se llama el programa proporcionado por el JDK de Java para arrancar el registro de objetos en aplicaciones RMI?
    a) registryrmi.
    b) rmiregistry.
    e) lookup.
    d) bindobjectservice.

# Actividades de aplicación

1. Enumera y describe los grupos de código de retorno del protocolo HTTP.
2. Indica en qué se diferencian los protocolos HTTP y HTTPS.
3. Describe el papel del protocolo SMTP en el servicio de correo electrónico.
4. Explica en qué se diferencian los protocolos IMAP y POP3 en el servicio de correo electrónico.
5. Compara el protocolo SSH y Telnet. Indica cuál se debe utilizar en la actualidad y explica las razones. 
6. Describe los pasos para realizar una petición HTTP en Java con la versión 1.8.
7. Indica cómo se debe programar una petición HTTP en Java a partir de la versión 1.8.
8.  Enumera las librerías que proporciona Apache Commons para el desarrollo de servicios en red en Java.
9. Explica cómo se puede realizar la descarga de un fichero mediante el protocolo FTP desde Java.
10. Describe el proceso de envío de correos electrónicos desde Java cuando estos solo contienen texto plano.
11. Indica cómo se realiza la descarga de los correos electrónicos de una cuenta desde Java.
12. Explica qué función tiene el programa rmiregistry en la programación de aplicaciones distribuidas con RMI en Java.

# Ampliación

1.  Descubre qué es un servidor web Apache.
2. Averigua qué es un analizador de paquetes o sniffer. ¿Qué relación tienen estos sistemas con los protocolos HTTP y HTTPS?
3. Obtén información referente a los códigos de HTTP siguientes: 202, 401, 402, 403 y 501.
4. Busca tres programas clientes de FTP para el sistema operativo del ordenador en el que trabajas habitualmente.
5. Descubre cómo subir un fichero a un servidor FTP desde una terminal del sistema operativo.
6. Aprende a conectarte por SSH con un servidor.
7. Busca información referente a CORBA (Common Object Request Broker Architecture). Averigua para qué se utiliza y en qué se diferencia de RMI.

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

