pipeline {
  agent { label 'slave-240' }
  stages {
    stage('SonarQube Scan'){
      steps{
        withSonarQubeEnv(installationName: 'SonarQube server'){
                    sh './mvnw clean org.sonarsource.scanner.maven:sonar-maven-plugin:3.9.0.2155:sonar'
        }
      }
    }
  }
}
