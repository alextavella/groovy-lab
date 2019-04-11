import com.tavella.frontend.Android

def call(Map args) {
    def android = new Android()

    pipeline {
        agent {
            label "slave"
        }

        enviroment {
            branch = "${BRANCH_NAME}"
        }

        stages {
            stage("Config") {
                steps {
                    script {
                        android.clean()
                    }
                }
            }
            stage("Building") {
                steps {
                    script {
                        android.build()
                    }
                }
            }
            stage("Signing") {
                steps {
                    script {
                        android.sign()
                    }
                }
            }
            stage("Publishing") {
                steps {
                    script {
                        android.publish()
                    }
                }
            }
        }
    }
}