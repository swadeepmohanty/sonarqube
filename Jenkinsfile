pipeline {
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
                         waitForQualityGate abortPipeline: true
                       }
                     }
                   }
            }
    }