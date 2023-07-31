### 1. Prerequisitos:
- Maquina local con el sistema operativo Windows 10
- Intellij 
- Gradle 8.2.1
- Serenity version 2.1.13
- Junit4 version 4.14.2

```
 defaultTasks 'clean','test','aggregate'

repositories {
    mavenCentral()
}

buildscript {
    repositories {
        mavenLocal()
        jcenter()
    }
    dependencies {
        classpath("net.serenity-bdd:serenity-gradle-plugin:2.1.13")
    }
}

apply plugin: 'java'
apply plugin: 'eclipse'
apply plugin: 'idea'
apply plugin: 'net.serenity-bdd.aggregator'
apply from: "$rootDir/gradle/libraries.gradle"


sourceCompatibility = 1.8
targetCompatibility = 1.8


configurations.all {
    resolutionStrategy {
        force "io.cucumber:cucumber-core:${cucumberVersion}"
    }
}
dependencies {
//    compile libs.logback

    testImplementation libs.test.cucumber.java,
            libs.test.cucumber.junit,
            libs.test.serenity.core,
            libs.test.serenity.screenplay,
            libs.test.serenity.junit,
            libs.test.serenity.screenplayWebdriver,
            libs.test.serenity.cucumber,
            libs.test.junit,
            libs.test.assertj
//    implementation 'ch.qos.logback:logback-classic:1.2.9'
}

test {
    testLogging.showStandardStreams = true
    systemProperties System.getProperties()
}

gradle.startParameter.continueOnFailure = true

test.finalizedBy(aggregate)
```

### 2. Comandos de instalación
```
gradle wrapper --gradle-version 8.2.1

```
```
 gradle clean test  
```
```
 gradle --version
```

### 3. Instrucciones para ejecutar los test
Para abrir el reporte del test seguir los siguientes pasos:
- Ejecutar el proyecto: click derecho sobre el proyecto y click en Run "nombre del proyecto"
- Ir a la carpeta target\site\serenity\testcases.qatestcase_pruebadeweb.html

### Referencia: 
https://serenity-bdd.github.io/docs/guide/driver_config