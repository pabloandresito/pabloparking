pipeline{
	
		agent {
		label 'Slave5'
		}
	
        
		triggers {
        pollSCM('@hourly')
		}
	
		tools {
		jdk 'JDK8_Centos' 
		gradle 'Gradle5.0_Centos' 
		}
	
		options {
			// Mantener artefactos y salida de consola para el # espec�fico de ejecuciones recientes del Pipeline.
			buildDiscarder(logRotator(numToKeepStr: '5'))
			// No permitir ejecuciones concurrentes de Pipeline
			disableConcurrentBuilds()
		}
		
		environment {
        PROJECT_PATH_BACK = 'pabloparking'
		}
		parameters{
			booleanParam defaultValue: false, description: 'Push a registry AWS', name: 'pushdeploy'
		}
		
		stages{
		
			stage('Checkout') {
				steps {
                echo '------------>Checkout desde Git Microservicio<------------'
                checkout([$class: 'GitSCM', branches: [[name: '${BRANCH_NAME}']], doGenerateSubmoduleConfigurations: false, extensions: [[$class: 'RelativeTargetDirectory', relativeTargetDir: 'Microservicio']], gitTool: 'Git_Centos', submoduleCfg: [], userRemoteConfigs: [[credentialsId: '7fe28495-6f45-4577-8c7b-dce727e78f14', url: 'pabloparkingurl']]])
				}
			}
				
			stage('Compile'){
				parallel {
					stage('Compile backend'){
						steps{
							echo "------------>Compilación backend<------------"
							dir("${PROJECT_PATH_BACK}"){
								sh 'gradle build -x test'
							}
						}
					
					}
				}
			}
			stage('Test Unitarios -Cobertura'){
				parallel {
					stage('Test- Cobertura backend'){
						steps {
							echo '------------>test backend<------------'
							dir("${PROJECT_PATH_BACK}"){
								sh 'gradle --stacktrace test'
								
							}
						}
					}
				}
			}
			
			stage('Sonar Analysis'){
				steps{
					echo '------------>Analisis de código estático<------------'
					  withSonarQubeEnv('Sonar') {
                        sh "${tool name: 'SonarScanner', type: 'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner -Dsonar.projectKey=pabloparking.${BRANCH_NAME} -Dsonar.projectName=pabloparking.${BRANCH_NAME} -Dproject.settings=./sonar-project.properties"
                     }
				}
			}
		
		

		}
		post {
			failure {
				mail(to: 'pablo.robles@ceiba.com.co',
				body:"Build failed in Jenkins: Project: ${env.JOB_NAME} Build /n Number: ${env.BUILD_NUMBER} URL de build: ${env.BUILD_NUMBER}/n/nPlease go to ${env.BUILD_URL} and verify the build",
				subject: "ERROR CI: ${env.JOB_NAME}")
			}
		}	
			
}