# default-web-applikation
## Startkode på 2. semester forår 2022

Der er med vilje ikke refaktoreret i bund, og der er ikke lavet design, 
men applikationen indeholder:

- Strukturering i passende packages for overblik. Noget af strukturen er også givet af Maven, og kan ikke laves om. F.eks. opdelingen i `/java` og `/webapp`.
- Javaservlets
- JSP sider. De som ligger i WEB-INF kan kun tilgås via en servlet.
- En super skrabet css-fil til styling
- Datamappere, som anvender en connection pool.
- Fejlhåndtering med exceptions
- Integrationstest af datamappere.

Funtionelt kan applikationen:

- Vise en forside med links til undersider, som endnu ikke er lavet
- Logge en user på. Der findes to brugere i databasen.
  1. `user` med password: `1234` (rolle: `user`)
  2. `admin` med password: `1234` (rolle: `admin`)
  - Man kan se på index.jsp hvordan man kan udnytte om en user er logget på eller ej.
  - Hvis man indtaster ugyldige data under indlogning, bliver man sendt til en en fejlside.

## Du skal gøre følgende for at få webapplikationen i luften:

1. Først skal du clone projektet eller downloade en zip-fil med projektet til din arbejdsstation.
2. Beslut dig for hvad projektets database skal hedde. Det skal du bruge i næste punkt.
3. Åbn Workbench og kør en tilpasset (med dit databasenavn i stedet for `startcode`) version af sql-filen `startcode.sql`, som ligger i mappen `resources`. Den opretter en database med en user-tabel og en test-database.
4. Du skal evt. ændre kodeord til databasen i projektet. Det gøres i filerne: `/persistence/ConnectionPool` i linie 14 og 15. Du skal også ændre i UserMapperTest.
5. Til sidst skal du lave en Tomcat konfiguration. Dvs, 
   1. klik på "Add Configuration ..."
   2. Klik på "+" og vælg "Tomcat Server Local".
   3. Klik på "Fix knappen"
   4. Vælg war-exploded som deployment type
   5. Nu kan du klikke på den grønne play-knap for at bygge og køre projektet.
