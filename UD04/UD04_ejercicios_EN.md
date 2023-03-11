---
title: Exercises UD04
language: EN
author: David Martínez Peña [www.martinezpenya.es]
subject: Services and Processes coding
keywords: [PSP, 2022, coding, services, processes, multithread, Java]
IES: IES Eduardo Primo Marqués (Carlet) [www.ieseduardoprimo.es]
header: ${title} - ${subject} (ver. ${today}) 
footer:${currentFileName}.pdf - ${author} - ${IES} - ${pageNo}/${pageCount}
typora-root-url:${filename}/../
typora-copy-images-to:${filename}/../assets
imgcover:/media/DADES/NextCloud/DOCENCIA/PSP_2223/PSP-CFGS-2223/UD04/assets/cover.png
---
[toc]

# Training

1. Use the knowledge gained in the unit to download a `json` file and display the correctly formatted content.

   To do this, search for and study the operation of a free web service that provides information in JSON format.

   Search and investigate how to read information from a JSON file (you can rely on the API or look for a library).

   Develop an application that accesses it, retrieves information and displays it on the screen. You can't show the JSON as you download it, but showing the information it contains already debugged.

   Some suggestions for web services that meet these requirements are the following (you can use another if you prefer):

   - Open Movie Database - http://www.omdbapi.com/
   - El País Christmas Lottery prize consultation - https://servicios.elpais.com/sorteos/loteria-navidad/api/
   - Data from the State Meteorological Agency - https://opendata.aemet.es/centrode-descargas/inicio

2. Create an FTP client that will ask for the `host`, `port`, `username` and `password` on the screen to connect to an FTP server. If the connection is successful, it will ask for the `path of a local file` to upload to FTP. Once uploaded it will download it again with your `first and last name` and the `psp` extension.

3. Create an email client that, aided by gmail's SMTP, asks the user for the `address of the recipient`, the `sender`, the `password`, the `subject`, the `text`, and the `path of a local file` that will be attached to the email.

4. Create an email client that accesses a gmail account through IMAP. It will ask the user for the `email address`, the `password`. Once correctly connected, the application will show a list with all the folders (labels) available in the email account. The user will be able to choose one of them and then the program will display the `sender`, `recipient`, `subject`, `text` or a `message indicating whether it contains attachments` of all the emails contained in said folder chosen by the user.

5. Make a distributed application, using JAVA RMI so that the client requests an addition, subtraction, multiplication or division operation to the user, and this instead of being processed by the client, is sent to a server that will perform the operation and will return the correct result.

6. Develop a distributed application in which the server provides a service for obtaining definitions of terms related to any discipline.

   For example, if you ask for the definition of the term "fuselage" related to parts of airplanes, the server should respond something similar to "Central part of the airplane. It is the cabin where people and transported belongings go. The client will request the term to obtain, and the server will provide it by accessing a local database, a file, or a data structure in memory.

# Verification

1. What is the protocol on which the web is based?
   a) FTP
   b) SMTP.
   e) DNS.
   d) HTTP.
2. What is the HTTP response code that indicates that the page was not found?
   a) 204.
   b) 304.
   c) 404.
   d) 504.
3. What is the HTTP response code that indicates that the request has been served correctly?
   a) 200.
   b) 300.
   i) 400.
   d) 500.
4. What is the protocol specifically designed for file transfer?
   a) FTP.
   b) SMTP.
   e) DHCP.
   d) Telnet.
5. What is the protocol specifically designed for sending emails?
   a) SMTP.
   b) IMAP.
   e) POP3.
   d) FTP.
6. What protocol is used to read emails without deleting them from the server?
   a) SMTP.
   b) IMAP.
   e) POP3.
   d) FTP.
7. What is the protocol on which the Internet service that translates domain names to your IP address is based?
   a) SMTP
   b) Telnet.
   c) DNS.
   d) DHCP.
8. What is the protocol to remotely connect to a server to manage it securely from a terminal?
   a) Telnet.
   b) HTTPS.
   c) NFS.
   d) SSH.
9. What port does the HTTP protocol use by default?
   a) 80.
   b) 443.
   c) 21.
   d) 25.
10. What is the Java class that represents an HTTP connection?
    a) `java.net.URL`.
    b) `java.netHttpURLConnection`.
    c) `java.net.http.HttpClient`.
    d) `java.net.HttpRequest`.
11. What is the Java API called for sending and receiving emails?
    a) Apache Commons.
    b) Java Email API.
    c) JavaMail.
    d) Java Message API.
12. What is the name of the program provided by the Java JDK to perform object registration in RMI applications?
    a) by registrars.
    b) rmiregistry.
    e) lookup.
    d) bindobjectservice.

# Application Activities

1. List and describe the return code groups of the HTTP protocol.
2. Tell how the HTTP and HTTPS protocols differ.
3. Describe the role of the SMTP protocol in the email service.
4. Explain how the IMAP and POP3 protocols differ in the email service.
5. Compare the SSH and Telnet protocol. Indicate which one should be used today and explain why.
6. Describes the steps to make an HTTP request in Java with version 1.8.
7. Indicates how to program an HTTP request in Java as of version 1.8.
8. List the libraries provided by Apache Commons for developing network services in Java.
9. Explain how you can download a file using the FTP protocol from Java.
10. Describe the process of sending emails from Java when they only contain plain text.
11. Indicates how the emails of an account are downloaded from Java.
12. Explain the role of the rmiregistry program in programming distributed applications with RMI in Java.

# Extension

1. Find out what an Apache web server is.
2. Find out what a packet analyzer or sniffer is. What relationship do these systems have with the HTTP and HTTPS protocols?
3. Get information regarding the following HTTP codes: 202, 401, 402, 403, and 501.
4. Find three FTP client programs for the operating system of the computer on which you usually work.
5. Discover how to upload a file to an FTP server from an operating system terminal.
6. Learn how to SSH into a server.

# Information sources

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

