import com.tavella.frontend.Android
import com.tavella.utils.Log

def call(Map args) {
    def android = new Android()
    def log = new Log()

    def flavor = args.flavor
    // def keyStoreId = pipelineArgs.keyStoreId
    // def keyAlias = pipelineArgs.keyAlias

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
                        log.info 'config!!!'
                    }
                }
            }
            stage("Building") {
                steps {
                    script {
                        android.build()
                        log.info 'build!!!'
                    }
                }
            }
            stage("Signing") {
                steps {
                    script {
                        android.sign()
                        log.warning 'sign!!!'
                    }
                }
            }
            stage("Publishing") {
                steps {
                    script {
                        android.publish()
                        log.info 'publish!!!'
                    }
                }
            }
        }
    }
}