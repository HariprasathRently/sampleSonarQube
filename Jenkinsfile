pipeline {
    agent any

    // tools {
    //     // Make sure this matches the name of your SonarScanner tool in Jenkins Global Tool Config
    //     sonarQubeScanner 'Sonarqube Scanner'
    // }

    environment {
        SONAR_TOKEN = credentials('SONARQUBE') // This must be a Jenkins "Secret Text" credential
    }

    stages {
        stage('Checkout Code') {
            steps {
                checkout scm
            }
        }

        stage('Compile Java') {
            steps {
                sh 'mkdir -p out && javac -d out $(find src -name "*.java")'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('MySonarQubeServer') { // This should match the name of your SonarQube server config in Jenkins
                    sh '''
                        sonar-scanner \
                          -Dsonar.projectKey=JENKINS \
                          -Dsonar.projectName="JENKINS" \
                          -Dsonar.sources=src \
                          -Dsonar.java.binaries=out \
                          -Dsonar.host.url=http://localhost:9000 \
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
