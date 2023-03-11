---
title: EXTRAORDINARY
language: EN
author: David Martínez Peña [www.martinezpenya.es]
subject: Services and Processes coding
keywords: [PSP, 2022, coding, services, processes, multithread, Java]
IES: IES Eduardo Primo Marqués (Carlet) [www.ieseduardoprimo.es]
header: ${title} - ${subject} (ver. ${today}) 
footer:${currentFileName}.pdf - ${author} - ${IES} - ${pageNo}/${pageCount}
typora-root-url:${filename}/../
typora-copy-images-to:${filename}/../assets
imgcover:/media/DADES/NextCloud/DOCENCIA/PSP_2223/PSP-CFGS-2223/UD01/assets/cover.png
---
[toc]

# Introduction

The purpose of this document is to guide the student in the process of recovery of the module "Programming of services and processes" of 2^nd^ of DAM.

The student must follow the teacher's instructions and attend the follow-up sessions that are called. It will not serve to carry out this project completely but without attending the proposed follow-up.

This project intends to evaluate the practical part of the subject, while during the examination period of the extraordinary call the student must take an exam belonging to the theoretical part. The final grade for the course will be the average grade between the grade for the project and the grade for the exam. It will be necessary to obtain at least a 4 in each of the parts.

# Style

The style to be used in the document to be delivered will follow the following indications:

- It will not contain misspellings.

- In general, it will be written with reflexive pronouns. Example: "it was done" instead of "performed".

- On the cover will appear:

  - At the top the logos of the institute, GVA, ministry and European Social Fund (provided by the teacher)

  - In the bottom right the following text:
    - Student's name
    - Final Memory Programming of Services and processes
    - IES Eduardo Primo Marqués. Course 20XX/XX

- On each page:

- - The name of the subject will appear in the header of the page.
  - At the bottom of the page: student's name and page number.

- Font type: Helvetica or similar (eg Arial).

- Size: 11 points.

- Alignment: justified.

- Line spacing: 1.15 lines.

- Image captions / table: size 9.

- In code snippets, console outputs, etc.: font type monospace, size 10.

- Titles:

- - The epigraphs of chapters, sections and subsections must appear hierarchical by typography and with Arabic numerals subdivided by points (for example):

    1. CHAPTER

       1.1. Section

       ​	1.1.1 Subsection

  - Heading size level 1: 16 points.

  - Title level 2 size: 14 points.

  - Title level 3 size: 12 points.

- Margins:

  - Upper (includes headboard) and left: 3 cm.
  - Lower and right: 2 cm.

- If annexes are included, they will be identified by consecutive capital letters. Example: Annex A, Annex B...

# Project

It will consist of different phases:

- **PHASE1**: Preparation of the environment
  - AWS Academy (Cloud9)
  - Github
  - Simple socket server on AWS - Local Client
- **PHASE2**: We start with the `chatBot`. Multi-threaded application.
  - Prepare the server to support more than one simultaneous client.
  - The clients will access the server and will be able to send messages simultaneously and will also receive the information sent by other clients.
- **PHASE3**: Securing `chatBot` . Public/private key certificates.
  - The server will have an asymmetric key certificate configured.
  - Clients (they will continue to be more than one and may act simultaneously) need to establish secure connections with the server.
- **PHASE4**: Implement Bot functions.
  - The server and the client will share a common interface of methods (bot actions or commands).
  - The client will be able to list this list of functions, when the user decides to invoke a command (for example `!hora` ) the call to the server will be made.
  - When the server receives the request from the client, it will perform the task associated with the command (for example, return the system time) and return the information to the client that requested it or to all clients (depending on the type of command).
- **PHASE5**: Expansion of the student.
  - The student will add at least two individual commands and two group commands.
  - In addition, any idea that the student adds to the project will be valued.

# Content

The project aims to compile not only the content of the subject, but that of other subjects that should be assimilated from the previous course.

The student must:

- Create a repository on GitHub (or similar), and share it with the teacher to be able to follow up on each of the phases.
- You will not be able to advance to the next phase, if you have not validated the previous one.
- You must document in the memory (it is recommended to generate an online document that allows revisions and annotations) the resolution process of each phase, as well as the parts that have been easier and/or more difficult.

The teacher by his side:

- Will keep track of the GitHub repository and memory for the duration of the project
- Will suggest changes and modifications to the student through notes or emails, as well as comments in person during face-to-face or online follow-up sessions.

# Important dates

The recovery process will begin on March 13 with the first follow-up session in which this document will be explained, access will be given to the AWS academy, and students will be advised on the creation of the Git repository or the online document for the memory. .

The delivery of the document will be made at least 10 days before the date of the exam scheduled in the extraordinary call.

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

