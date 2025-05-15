node {
  stage('SCM') {
    checkout scm
  }
  stage('SonarQube Analysis') {
    def scannerHome = tool 'Sonarqube Scanner';
    withSonarQubeEnv() {
      sh "${scannerHome}/bin/sonar-scanner"
    }
  }
}

pipeline {
    agent any

    tools {
        maven 'Maven 3.8.8'
        sonarQubeScanner 'SonarScanner'
    }

    environment {
        SONAR_TOKEN = credentials('sonar-token-id')
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('MySonarQube') {
                    sh """
                        mvn sonar:sonar \
                        -Dsonar.projectKey=my-project \
                        -Dsonar.host.url=https://sonarqube.example.com \
                        -Dsonar.login=$SONAR_TOKEN
                    """
                }
            }
        }

        stage('Quality Gate') {
            steps {
                timeout(time: 1, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
    }
}
