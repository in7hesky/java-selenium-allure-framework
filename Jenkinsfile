pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh  "mvn clean test -Dheadless=true"
            }
        }
    }

    post {
        always {
            script {
                allure([
                    includeProperties: false,
                    jdk: '',
                    properties: [],
                    reportBuildPolicy: 'ALWAYS',
                    results: [[path: 'target/allure-results']]
            ])
            }
        }
    }
}