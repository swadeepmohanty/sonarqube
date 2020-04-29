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
                   bat 'mvn sonar:sonar'
                    }
                 }
             }
            stage("Quality Gate") {
                     steps {
                       timeout(time: 1, unit: 'MINUTES') {
                        def qg = waitForQualityGate()
                                   if (qg.status != 'OK') {
                                     error "Pipeline aborted due to quality gate failure: ${qg.status}"
                                   }
                       }
                     }
                   }
            }
    }