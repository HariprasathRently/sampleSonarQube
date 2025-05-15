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

    environment {
        SONAR_TOKEN = credentials('SONARQUBE INTERGRATION WITH JENKINS')
    }

    stages {
        stage('Compile Java') {
            steps {
                sh 'mkdir -p out && javac -d out $(find src -name "*.java")'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('MySonarQubeServer') {
                    sh '''
                        sonar-scanner \
                          -Dsonar.projectKey=my-java-project \
                          -Dsonar.sources=src \
                          -Dsonar.java.binaries=out \
                          -Dsonar.host.url=https://your-sonarqube-server \
                          -Dsonar.login=$SONAR_TOKEN
                    '''
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
