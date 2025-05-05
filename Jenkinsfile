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
        stage('Deploy to Jenkins Workspace') {
    steps {
        script {
            def jarFile = 'target/gestion-calidad-0.0.1-SNAPSHOT.jar'
            // Ejecutar el JAR en segundo plano
            bat "start java -jar ${jarFile}"

            // Verificar que el servicio está disponible (en el puerto 8080)
            waitUntil {
                script {
                    return bat(script: 'curl -s http://localhost:8081', returnStatus: true) == 0
                }
            }
        }
    }
}


    }
}