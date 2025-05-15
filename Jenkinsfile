  node {
    stage('SCM') {
        checkout scm
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
                          -Dsonar.projectKey=JENKINS \
                          -Dsonar.sources=src \
                          -Dsonar.java.binaries=out \
                          -Dsonar.host.url=http://localhost:9000/ \
                          -Dsonar.login=$SONAR_TOKEN
                    '''
                  def scannerHome = tool 'SonarScanner';
    withSonarQubeEnv() {
      sh "${scannerHome}/bin/sonar-scanner"
    }
  }

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
