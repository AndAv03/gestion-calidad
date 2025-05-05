pipeline {
    agent any
    tools {
        maven "Maven"
    }

    stages {
        stage('Clone Repository') {
            steps {
                git branch: 'main', url: 'https://github.com/AndAv03/gestion-calidad.git'
            }   
        }
        stage('Clean and Package') {
            steps {
                bat 'mvn clean package'
            }
        }
        /*
        stage('Deploy to Tomcat') {
            steps {
                deploy adapters: [
                    tomcat9(
                        credentialsId: 'TOMCATDEPLOYER',
                        path: '',
                        url: 'http://localhost:8085'
                    )
                ], contextPath: 'gestion-calidad', war: 'target/*.war'
            }
        }
        */

    }
}