# train-app

Below are the steps to build and execute the project.

* To build the project, cd into the current project directory and run the following command.
  > *mvn clean install -DskipTests -q assembly:single*
* This will create a geektrust.jar inside the target folder.
NOTE: Make sure you are in the correct project directory (src level) before running the above command.

* To execute this jar file, run the following command.
  > *java -jar <path_to>/geektrust.jar <absolute_path_to_input_file>*
* For example,
  > *java -jar target\geektrust.jar C:\Users\ab69463\Documents\workspace-spring-tool-suite-4-4.15.2.RELEASE\train-app\sample-input2.txt*


## Unit Testing

* Run the following commands to execute unit tests and to generate jacoco report
  > *mvn clean test*

  > *mvn jacoco:report*

* Go to target-> site-> jacoco and open index.html in the browser to check the code coverage report.
