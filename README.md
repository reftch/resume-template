## Resume in PDF application

Resume in PDF application is a Java template application, based on the Lowagie iText library.     

#### Résumé

You can see [PDF](https://github.com/reftch/resume-template/blob/main/Taras%20Chornyi%2C%20CV.pdf)

## How to use

#### Requirements

A Java and Gradle distributions are assumed. For Gradle it's highly recommended to use one of the installers:

- [**SDLMAN**](https://sdkman.io) 
- [**Homebrew**](https://brew.sh) (brew install gradle)     

As a last resort, if neither of these tools suit your needs, you can download the binaries from [**www.gradle.org**](http://www.gradle.org/downloads). 
Only the binaries are required, so look for the link to gradle-version-bin.zip. (You can also choose gradle-version-all.zip to get the sources and documentation as well as the binaries.)

Unzip the file to your computer, and add the bin folder to your path.

To test the Gradle installation, run Gradle from the command-line:
    
    gradle
    
If all goes well, you see a welcome message:
    
    Starting a Gradle Daemon (subsequent builds will be faster)
    
    > Task :help
    
    Welcome to Gradle 4.8.1.
    
    To run a build, run gradle <task> ...
    
    To see a list of available tasks, run gradle tasks
    
    To see a list of command-line options, run gradle --help
    
    To see more detail about a task, run gradle help --task <task>
    
    For troubleshooting, visit https://help.gradle.org
    
    BUILD SUCCESSFUL in 2s
    1 actionable task: 1 executed
    
You now have a Gradle installed.

#### Building Java code

You’ll use the gradle build task frequently. 
This task compiles, tests, and runs the code after a JAR file generating. 
You can run it like this:

    gradle run
    
Or you can run the project with Gradle Wrapper:

    ./gradlew run
 
After a few seconds, "BUILD SUCCESSFUL" indicates that the build has completed and file Resume.pdf will be generated.    

#### Summary

Congratulations! You have now generated resume Pdf file using a Gradle build file for building Java project.
