#EasyHR-Approval Project with Jenkins and Docker

##Prerequisites
-Java JDK 21 or higher installed.
-Apache Maven for running unit tests.
-Docker (optional) for containerization.
-Jenkins for continuous integration and deployment.

## Build and Test
To compile, test, and package the application, run the following command:
```bash
./build.sh

##Jenkins Setup Instructions
    ###Create a New Jenkins Item:
        Open Jenkins in your web browser.(http://localhost:8080)
        Click on "New Item" on the left-hand menu.
        Enter a name for your project (e.g., "EasyHR-Approval").
        Select "Pipeline" as the item type.
        Click "OK".

    ###Configure the Pipeline:
        In the project configuration page, scroll down to the "Pipeline" section.
        Set the "Definition" field to "Pipeline script from SCM".
        For "SCM", choose "Git".
        In the "Repository URL" field, enter the URL of your Git repository (e.g., https://github.com/lachini-r/EasyHR-Approval).
        Set the "Branch Specifier" to main.
        Under "Script Path", ensure it points to the location of your Jenkinsfile (default is Jenkinsfile in the root of the repository).

    ###Save and Build:
        Click "Save" to apply the configuration.
        To run the pipeline, click "Build Now" in the project dashboard.

    ###Monitor Builds:
        Monitor build progress and view from the Build History of Jenkins.
        Check for any build issues and review the console output for details.

    Note:Ensure Jenkins has the necessary permissions to access your Git repository.
