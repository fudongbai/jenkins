job('seed_job') {
  scm {
    git {
      remote {
        url('https://github.com/fudongbai/jenkins.git')
      }
      branch('master')
    }
  }
  steps {
    dsl {
      external('adduser.groovy')
    }
  }
}
