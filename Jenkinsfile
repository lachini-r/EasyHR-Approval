pipeline {
    agent any
    environment {
        DOCKER_IMAGE = 'easyhr_approval'
        DOCKER_TAG = 'latest'
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/lachini-r/EasyHR-Approval'
            }
        }
        stage('Build') {
            steps {
                script {
                    sh './build.sh'
                }
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    sh 'docker build -t $DOCKER_IMAGE:$DOCKER_TAG .'
                }
            }
        }
        stage('Run Docker Container') {
            steps {
                script {
                    sh 'docker run -d -p 8081:8080 --name easyhr_approval_container $DOCKER_IMAGE:$DOCKER_TAG'
                }
            }
        }
    }
    post {
        always {
            echo 'Cleaning up...'
            script {
                    sh 'docker stop easyhr_approval_container || true'

                    sh 'docker rm easyhr_approval_container || true'
                    sh 'docker rmi $DOCKER_IMAGE:$DOCKER_TAG || true'
            }
        }
    }
}