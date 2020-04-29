pipeline {
    agent any
     tools {
            maven 'Maven'
            jdk 'Java11'
        }
    stages {

           stage('SonarQube analysis') {
               withSonarQubeEnv('SonarServer') {
                   bat 'mvn clean package sonar:sonar'
               } // SonarQube taskId is automatically attached to the pipeline context
             }
           }
           stage("Quality Gate"){
               timeout(time: 1, unit: 'MINUTES') { // Just in case something goes wrong, pipeline will be killed after a timeout
               def qg = waitForQualityGate() // Reuse taskId previously collected by withSonarQubeEnv
               if (qg.status != 'OK') {
                   error "Pipeline aborted due to quality gate failure: ${qg.status}"
               }
             }
           }
    }
}