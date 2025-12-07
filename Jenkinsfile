pipeline {
    agent any

    tools {
        jdk 'JDK17'
        maven 'Maven3'
    }

    options {
        timestamps()
        ansiColor('xterm')
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'master',
                    url: 'https://github.com/Shubham3588/cucumber-framework-selenium.git'
            }
        }

        stage('Build & Test') {
            parallel {
                stage('Maven Test') {
                    steps {
                        sh "mvn clean test -DskipTests=false"
                    }
                }
                stage('Static Checks (Optional)') {
                    when { expression { false } } // enable later if needed
                    steps {
                        echo 'Run static analysis tools here (SpotBugs, Checkstyle, etc)'
                    }
                }
            }
        }

        stage('Generate Reports') {
            steps {
                // Allure Report Generation (local folder)
                sh "mvn allure:report || true"
            }
        }

        stage('Publish Reports in Jenkins') {
            steps {
                // JUnit
                junit 'target/surefire-reports/*.xml'

                // Cucumber JSON plugin
                cucumber fileIncludePattern: 'target/cucumber-reports/*.json'

                // HTML Report for Allure
                publishHTML(target: [
                    reportDir: 'target/allure-report',
                    reportFiles: 'index.html',
                    reportName: 'Allure Report',
                    keepAll: true,
                    alwaysLinkToLastBuild: true,
                    allowMissing: true
                ])
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'target/**/*.*', fingerprint: true
        }
        failure {
            echo 'Build failed – please check console logs and reports.'
        }
        success {
            echo 'Build passed – all tests green!'
        }
    }
}
