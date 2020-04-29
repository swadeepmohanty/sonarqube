pipeline {
     environment {
        PROJECT_KEY = 'sq:MCRoomBook'
        PROJECT_NAME = 'sq:MCRoomBook'
     }
     agent {
            label 'any'
     }
     tools {
            maven 'Maven'
            jdk 'Java11'
        }
    stages {
        stage('clean-workspace'){
            steps{
                cleanWs()
            }
        }

           stage('SonarQube analysis') {
            steps{
               withSonarQubeEnv('SonarServer') {
                   bat 'mvn clean package sonar:sonar'
               } // SonarQube taskId is automatically attached to the pipeline context
             }
             }


    }
}