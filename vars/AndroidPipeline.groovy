import com.tavella.frontend.Android;
import com.tavella.utils.Log;

def call(Map args) {
    def android = new Android()
    def log = new Log()

    def flavor = args.flavor
    // def keyStoreId = pipelineArgs.keyStoreId
    // def keyAlias = pipelineArgs.keyAlias

    pipeline {
        agent none

        stages {
            stage("Config") {
                steps {
                    script {
                        log.info 'config!!!'
                        android.clean()
                    }
                }
            }
            stage("Building") {
                steps {
                    script {
                        log.info 'build!!!'
                        android.build()
                    }
                }
            }
            stage("Signing") {
                steps {
                    script {
                        log.warning 'sign!!!'
                        android.sign()
                    }
                }
            }
            stage("Publishing") {
                steps {
                    script {
                        log.info 'publish!!!'
                        android.publish()
                    }
                }
            }
        }
    }
}