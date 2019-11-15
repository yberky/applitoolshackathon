**Before Run**
You will need to create folders for store, some of the assets you need in order to run the automated script.
By Default you can see the location of file under src/main/java/utilities.AIHackathon/Constants_AIHackathon.java with parameters as below;
1- public static final String Excel_File_Path = "/Users/byavuz/Automation/ExcelSheets/";
2- public static final String directoryForScreenShots = "/Users/byavuz/Automation/ScreenShots/";
3- public static final String ExtentReport_File_Path = "/Users/byavuz/Automation/ExtentReports/";

I put the whole folders as *.zip file you can unzip them to specific folder and set the values above for this location. 

**Note**= The location has be seen set for MAC. For WINDOW it could be something like;
public static final String Excel_File_Path = "C:\\Users\\byavuz\\Automation\\ExcelSheets\\";

For creating file another location, you will need to reset the location under Constants_AIHackathon.java

----------------------------------------------------------------------------------------------------
**About Automation**
- Automation Test Cases created as Maven Project for better manage libraries. 
- Test Case written in Page Factory Model with TestNG Framework.

Some of the prerequisites are;
- Must Have JDK,JRE,IDE for Java (Eclipse),Maven Install

Steps for Having These Prerequisites;
- Have Java v10 or higher installed https://www.java.com/en/download/help/download_options.xml
- Install Eclipse or IntelliJ editor
- You must set the location as mentioned above under "**Before Run***
- Install Maven (Maven binary Zip file) from https://maven.apache.org/download.cgi
Follow the installation instructions from https://maven.apache.org/install.html to add it to the PATH.
Note: Maven is for install all dependencies that needed for test suite.

Test Automation case you will see under src/test/java as;
* "TraditionalTests.java"
* "VisualAITests.java"

Other classes that support automation is under src/main/java; 
- utilities.Base package includes utilities for Excel Read, Page Events and ScreenShot Taken general functions,
- utilities.AIHackathon package includes Constants that you can manage location and some sys settings, 
SearchPage Factory classes for manage page elements and methods, Page Initialize that support Before and After Class settings,
Extent Settings for taking Extend Reports
----------------------------------------------------------------------------------------------------
**RUN Automation in CLI**
You can run scripts directly on CLI;
* Before Run go to directory that Project Located, in my case I give examp. as below;

For WINDOW;
* go to cmd,
* Write and Enter to go that specific file,
>cd C:\Users\berk.yavuz\My Work Folder\Automation\Workspace\AIHackathon
* For Maven get started run test maven;
>mvn test
* Fon run test case, run *.xml (this was set under pom.xml under profiles section);
>mvn test -PAIHackathonTests

For MAC;
* Do the same as in WINDOW platform but do them in "terminal"

For any question do not hesitate to contact me,
yberky85@hotmail.com



