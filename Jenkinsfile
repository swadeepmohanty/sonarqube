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
             steps {
               withSonarQubeEnv(installationName: 'SonarServer') { // You can override the credential to be used
                 bat 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.6.0.1398:sonar'
               }
               }
             }
    }
}