pipeline {
    agent any
    
    environment {
        GIT_REPO = 'https://github.com/eugenio-sanchez/demo_api-'
        EMAIL_RECIPIENT = 'cesa7954@gmail.com'
    }
    
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: GIT_REPO
            }
        }
        stage('Run Integration Tests') {
            steps {
                // Use Maven to run integration tests
                sh 'mvn test'
            }
        }
        stage('Run JMeter Test Plan') {
            steps {
                // Ensure JMeter is installed and in your PATH
                sh 'jmeter -n -t get_name_test_plan.jmx -l results.jtl'
            }
        }
    }
    post {
        always {
            // Send email with the results
            script {
                def jmeterResults = readFile('results.jtl')
                emailext (
                    to: EMAIL_RECIPIENT,
                    subject: "Jenkins Build ${env.BUILD_NUMBER}: Test Results",
                    body: "Check the test results:\n\n${jmeterResults}",
                    attachLog: true // Attach the console output
                )
            }
        }
    }
}

