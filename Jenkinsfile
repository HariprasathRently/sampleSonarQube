pipeline {
    agent any

//      tools { 
//         maven 'Maven'
// }

    environment {
        SONAR_TOKEN = credentials('Testing') // This must be a Jenkins "Secret Text" credential
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
                withSonarQubeEnv('Sonarqube') { // This should match the name of your SonarQube server config in Jenkins
                    // sh '''
                    // mvn clean package sonar:sonar

                    //  sonar-scanner \
                    //       -Dsonar.projectKey=JENKINS \
                    //       -Dsonar.projectName="JENKINS" \
                    //       -Dsonar.sources=src \
                    //       -Dsonar.java.binaries=out \
                    //       -Dsonar.host.url="http://localhost:9000" \
                    //       -Dsonar.login=$SONAR_TOKEN
                    // '''

                    sh 'mvn clean verify sonar:sonar'

                }
            }
        }
    }
}
