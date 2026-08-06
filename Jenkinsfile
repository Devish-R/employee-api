pipeline {
    agent any

    triggers {
        githubPush()
    }

    stages {

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t employee-api:v1 .'
            }
        }

        stage('Stop Old Container') {
            steps {
                sh 'docker stop employee-api || true'
            }
        }

        stage('Remove Old Container') {
            steps {
                sh 'docker rm employee-api || true'
            }
        }

        stage('Run Container') {
            steps {
                sh 'docker run -d -p 8081:8080 --name employee-api employee-api:v1'
            }
        }
    }
}