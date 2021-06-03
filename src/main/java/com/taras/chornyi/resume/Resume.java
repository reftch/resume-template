package com.taras.chornyi.resume;

import lombok.val;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Resume, CV
 *
 * @author Taras Chornyi
 */
public class Resume {

    private static final String SUMMARY =
            "More than twenty years of professional experience in various fields and platforms including " +
                    "summary project leading, system analysis, design and application development, " +
                    "testing and launching products. Understanding of OOP, OO Design Patterns, " +
                    "SOA, Microservices. Deep knowledge of Java Core, Experience of using Spring Boot and Spring Cloud, " +
                    "Knowledge of JDBC Template/JPA, Javascript/Typescript, Experience of using Docker, Podman and Minikube, " +
                    "Technical documentation writing skills.";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        val builder = new ResumeBuilder("Taras Chornyi, CV.pdf", "Resume", "Taras Chornyi", "Resume, CV");

        val links = new LinkedHashMap<String, String>();
        links.put("GitHub © 2021: ", "https://github.com/reftch");
        links.put("LinkedIn: ", "https://www.linkedin.com/in/taras-chornyi-696148152");
        links.put("Xing.com: ", "https://www.xing.com/profile/Taras_Chornyi");

        builder
                .addPageNumber("1")
                .addHeader("RESUME")
                .addTitle("Taras Chornyi", "taras.chornyi@gmail.com", "taras.chornyi","src/main/resources/images/TC.jpg", links)
                .addChapter("Objective", "Seeking an interesting projects with Typescript/Node.js technologies.", 0)
                .addChapter("Professional Summary", SUMMARY, 20)
                .addChapter("Employment History", 110)

                .addCompanyExperience("12/2018 - present now:", "Compart AG",
                        "http://compart.com",
                        "Böblingen, Germany", 0)

                .addProjectExperience("12/2020 - present now",
                        "Frameworkless WCL Library",
                        "Senior Full Stack Developer",
                                "Based on the custom HTML elements Web User Interface (WUI) library is a development tool, which allows " +
                                "to decrease a development time and application complexity. This library offers all modern framework's feature, " +
                                "like reconciliation of the Virtual DOM, text and attributes interpolations, " +
                                "components composition, conditional rendering, state management and lazy loading " +
                                "routing without any external dependencies.",
                        "Typescript, Lit, Nx, Jest, Cypress.", 10)

                .addProjectExperience("12/2019 - present now", "DocBridge© - Pilot User Interface",
                        "Senior Full Stack Developer",
                        "For managing and monitoring the processing steps, DocBridge Pilot provides a browser interface, " +
                                "DocBridge Pilot - Web UI. Development backend prototype based on NestJS, TypeORM and GraphQL.",
                        "VueJS 2-3, Lit, Nx, NestJS, Vite, Vue CLI, Composition API, Vuex, Vue Routing, Typescript, " +
                                "Ngnix, Jest, Cypress, RESTFul, GraphQL, Docker/Podman.",
                        30)

                .addProjectExperience("12/2018 - 12/2019", "DocBridge© - Pilot Project",
                        "Senior Java Developer",
                                "Create a Central Document Distribution Hub for all Physical and Electronic Channels " +
                                "Implementation of the RESTful API, implementation of various customer's requirements, " +
                                "code maintenance, encryption vault subsystem." ,
                        "Java 8-11, Spring Framework Ecosystem " +
                                "RESTful API, Maven, Apache Tomcat, H2, MSSQL, Oracle, MariaDB., Docker/Podman.",
                        50)

                .addNewPage()
                .addPageNumber("2")
                .addHeader("RESUME")

                .addExperience("09/2017 - 07/2018:",
                        "Full Stack Java Developer",
                        "SINOVO business solutions",
                        "http://business.sinovo.de",
                        "Frankfurt am Main, Germany - Kyiv, Ukraine",
                        "Roche Personalized Diabetes Management Tool." +
                                "\nThe integrated PDM tool based on microservices architecture helps doctors comply with processes " +
                                "in the context of diabetes therapy. " +
                                "It is used to locate and to correct deviations in the therapy process. " +
                                "Besides that, the tool is used for the documentation of the data acquisition. " +
                                "The quality-relevant processes are described and modeled in the BPEL XML-based language. " +
                                "Apache ODE is used on the server side as a BPEL engine and contains separated process modules for control," +
                                " diagnostic, metabolic, adipositas, fat metabolism and hypertension.",
                        "Java 8, Spring Boot, Spring Cloud, Spring Eureka, Spring Configuration, " +
                                "Spring Microservices, RESTful API, Angular 4-6, Maven, Gradle, Apache Tomcat, BPEL ODE, MariaDB.",
                        25)

                .addExperience("11/2012 - 08/2017:",
                        "Senior Java Developer",
                        "HHS Tech Group (EngagePoint)",
                        "http://hhstechgroup.com",
                        "Kyiv, Ukraine",
                        "Audit System for event accumulation in the Hadoop HBase Cluster." +
                                "\nThis is a ready-to-use fully encapsulated, service-oriented architecture (SOA) solution designed to help organizations manage a wide range of audit-related processes on a single integrated platform.",
                        "Cloudera Hadoop, Elasticsearch, Solr, Ember Framework, BPEL ActiveVOS, Maven, " +
                                "WebSphere 6,7,8, J2EE Design Patterns.",
                        20)
                .addExperience("10/2010 - 10/2012:",
                        "Java Developer",
                        "Codeminders",
                        "http://www.codeminders.com",
                        "Kyiv, Ukraine",
                        "Vidder Application VPN Solution." +
                                "\nApplication VPN solutions put application owners in control of all aspects of network security.",
                        "Hibernate, Servlets, Ajax, JSON, JavaScript, Maven, Derby SQL, Apache Tomcat, " +
                                "Jetty, J2EE Design Patterns.",
                        20)

                .addExperience("08/2008 - 09/2010:",
                        "Java Developer",
                        "Miratech",
                        "http://www.miratechgroup.com",
                        "Kyiv, Ukraine",
                        "Miratech Technical Assessment System." +
                                "\nThis is the system where each employee (SWE, VVE, PL, TL, IT Engineers, TS Engineers, " +
                                "Team Manages and Others) have own sets technical characteristics, " +
                                "which allow access technical level of employee. These data are framework skills, domain skills, " +
                                "database skills, swtools skills, technology skills and other. Base on these assesstments, " +
                                "Direct Manager can more efficiently control their SWE and VVE units and improve process of software development.",
                        "Spring MVC, Servlets, ExtJS, Ajax, JSON, HTML, CSS, JavaScript, Maven, JDBC, MS SQL," +
                                " Tomcat, Jetty, J2EE Design Patterns.",
                        20)

                .addNewPage()
                .addPageNumber("3")
                .addHeader("RESUME")

                .addExperience("04/2008 - 08/2008:",
                        "Java Developer",
                        "Dexton Software",
                        "http://www.dexton-software.com",
                        "Kyiv-Odessa, Ukraine",
                        "The Dexton Integrator facilitates data manipulation." +
                                "\nThis manipulation can be done with or without user interaction. Business processes are " +
                                "broken down into separate steps and based on certain rules, these steps will be carried out. " +
                                "A process can take the parameters to run. These parameters can come from a data source but can also be " +
                                "manually typed in by a user or triggered by another application or process.",
                        "Spring MVC, Servlets, ExtJS, Ajax, JSON, HTML, CSS, JavaScript, Maven, JDBC, MS SQL, Tomcat, " +
                                "Jetty, J2EE Design Patterns.",
                        25)
                .addExperience("07/2005 - 03/2008:",
                        "Java Developer",
                        "Genesys Telecommunications Laboratories",
                        "https://www.genesys.com",
                        "Kyiv, Ukraine",
                        "Genesys Desktop Supervision. " +
                                "This is an application that allows online communication between customers and companies.",
                        "Struts 1, JSP, Servlets, HTML, CSS, JavaScript, ant, JDBC, MS SQL, Tomcat, Web Sphere and Web Logic.",
                        25)

                .addExperience("06/1997 - 06/2005:",
                        "Software Developer",
                        "State Kyiv Design Bureau Luch",
                        "http://www.luch.kiev.ua/en",
                        "Kyiv, Ukraine",
                        "Embedded software development for the control systems based on the x86-processors; " +
                                "embedded software development for the control systems based on the DSP-processors " +
                                "(TMS320C5000, TMS320C2000); software development for the automatic control " +
                                "and diagnostic systems for the high-precision guided weapons; " +
                                "software development for the telemetry system.",
                        "Code Composer Studio™ (CCStudio) IDE, C, C++, Assembler.",
                        25)


                .addNewPage()
                .addPageNumber("4")
                .addHeader("RESUME")

                .addChapter("Total Experience", "23 years", 30)
                .addChapter("Programming Languages", "Typescript, JavaScript, Java, PHP, CSS, HTML, C, C++, Assembler.", 30)
                .addChapter("Operating Systems", "MacOS X, Linux, FreeBSD, QNX, MS-DOS.", 40)
                .addChapter("Software Technologies", "Lit, Nx, React, VueJS, SvelteJS, Angular, NestJS, Rollup, Webpack, Podman, Docker, Minikube, J2EE, J2EE Design Patterns, Spring Boot, Spring Cloud, " +
                                "Spring Microservice, Cloudera Hadoop, Elastisearch, Solr, BPEL ODE, BPEL ActiveVOS, Ajax, Angular, " +
                                "Ember, ExtJS, JQuery, CSS, " +
                                "Adobe Flex, JSP and Servlets, maven, ant, Springframework MVC and WebServices, Struts, JSON, XML, XSD, JMS, " +
                                "Hibernate, iText, LaTEX, Tomcat, Jetty, Web Logic, Sun GlassFish, Apache HTTP Server.",
                        30)
                .addChapter("Education", "University: National Technical University 'Kyiv Politechnical Institute' " +
                        "(Kyiv, Ukraine). Faculty of Aerospace Systems. Attended from 09/1990 to 02/1997. " +
                        "Degree: Metrology and measuring technology. Information measuring technologies and systems. " +
                        "(eq. MSs); conferred 02/1997.", 120)

                .addChapter("Additional Information", "Spoken and written English, German (A2), Ukrainian, Russian.", 80)

                .addChapter("Awards", "" +
                        "2020, Award to the DEV colleague who displayed the best initiative of the year: creating a new Pilot UI, Compart AG" +
                        "\n2014, Employee Awards Software Development, Engagepoint, Inc." +
                        "\n2013, Certificate of Appreciation, Engagepoint, Inc." +
                        "\n2004, Employee Awards Software Development, State Kiev Design Bureau 'Luch'", 50)

                .addChapter("Interests", "Typescript/Javascript technologies, Linux OS, Video processing (post production & color grading with ffmpeg, " +
                        "ffprobe, and Final Cut Pro X), Football, Autos, Fishing, Table Tennis, F1.", 90)
                .build();

    }
}
