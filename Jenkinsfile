pipeline {
  agent { label 'slave-240' }
  stages {
    stage('SonarQube Scan'){
      steps{
        withSonarQubeEnv(installationName: 'SonarQube server'){
                    sh 'mvn clean package sonar:sonar'
        }
      }
    }
  }
}
