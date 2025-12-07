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

        stage('Build') {
            steps {
                withEnv([
                    "JAVA_HOME=${tool name: 'JDK17'}",
                    "PATH+JDK=${tool name: 'JDK17'}/bin"
                ]) {
                    bat "java -version"           // For verification
                    bat "mvn clean install -DskipTests"
                }
            }
        }

        stage('Run Tests') {
            steps {
                withEnv([
                    "JAVA_HOME=${tool name: 'JDK17'}",
                    "PATH+JDK=${tool name: 'JDK17'}/bin"
                ]) {
                    bat "mvn test"
                }
            }
        }

        stage('Cucumber Report') {
            steps {
                cucumber fileIncludePattern: 'target/cucumber-reports/*.json'
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
            archiveArtifacts artifacts: 'target/**/*.*'
        }
    }
}
