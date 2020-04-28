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
    }
}