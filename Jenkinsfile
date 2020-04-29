pipeline {
    agent any
     tools {
            maven 'Maven'
            jdk 'Java11'
        }
    stages {

           stage('SonarQube analysis') {
            steps{
               withSonarQubeEnv('SonarServer') {
                   bat 'mvn clean package sonar:sonar'
               } // SonarQube taskId is automatically attached to the pipeline context
             }
             }


    }
}