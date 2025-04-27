pipeline {
    agent any

    stages {
        stage('pull') {
            steps {
                git 'https://github.com/mayurmwagh/angular-java.git'
            }
        }
        stage('build') {
            steps {
                script {
                    sh 'mvn clean package'
                }
            }
        stage('deploy') {
            steps {
                script {
                    sh 'docker build -t jaylikhare316/angular-java:latest .'
                    sh 'docker run -d -p 8080:8080 mayurmwagh/angular-java:latest'
                }
            }
        }
    }
}
