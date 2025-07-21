pipeline {
  agent any

  stages {
    stage('Checkout Code') {
      steps {
        checkout scm
      }
    }

    stage('Run Tests') {
      steps {
        sh 'mvn clean test'
      }
    }

    stage('Publish Reports') {
      steps {
        junit 'target/surefire-reports/*.xml'   // for JUnit/TestNG reports
      }
    }
  }
}
