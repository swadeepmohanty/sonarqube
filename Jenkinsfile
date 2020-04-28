pipeline {
    agent any
     tools {
            maven 'Maven'
            jdk 'Java11'
        }
    stages {
            stage ('Build') {
                steps {
                        bat 'mvn clean install'
                }
            }
            stage ('SonarQube analysis') {
               withSonarQubeEnv(credentialsId: '6ddb79e8fdddd102ac644fb3a7ab125cd7fce2a1', installationName: 'SonarServer') { // You can override the credential to be used
                 bat 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.6.0.1398:sonar'
               }
             }
    }
}