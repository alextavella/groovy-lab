package com.tavella.frontend;

def clean() {
    wrap([$class: 'AnsiColorBuildWrapper', colorMapName: 'xterm']) {
        sh "gradle drink"
    }
}

def build() {
}

def sign() {
}

def publish() {
}

return this