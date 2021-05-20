import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot


version = "2020.2"

project {

    vcsRoot(HttpsGithubComDaticahealthJavaTomcatMavenExample)

    buildType(Build)
}

object Build : BuildType({
    name = "Build"
    description = "SCM Check Out"

    vcs {
        root(DslContext.settingsRoot)
        root(HttpsGithubComDaticahealthJavaTomcatMavenExample)
    }

    steps {
        maven {
            name = "Build Code"
            goals = "clean install"
        }
        maven {
            name = "Test Cases"
            goals = "clean test"
            mavenVersion = defaultProvidedVersion()
        }
    }

    triggers {
        vcs {
        }
    }
})

object HttpsGithubComDaticahealthJavaTomcatMavenExample : GitVcsRoot({
    name = "https://github.com/daticahealth/java-tomcat-maven-example"
    url = "https://github.com/daticahealth/java-tomcat-maven-example"
    branch = "refs/heads/master"
})