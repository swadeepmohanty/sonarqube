pipeline {
     environment {
        PROJECT_KEY = 'sq:MCRoomBook'
        PROJECT_NAME = 'sq:MCRoomBook'
     }

     agent any

     tools {
            maven 'Maven'
            jdk 'Java11'
        }
    stages {
        stage('Compile'){
            steps{
                bat 'mvn clean package'
            }
        }

        stage('SonarQube analysis') {
            steps{
               withSonarQubeEnv('SonarServer') {
                   bat 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.6.0.1398:sonar'
                    }
                 }
             }
        }
    }