plugins {
    id("java-platform")
    id("maven-publish")
}


group = "com.learn.bom"
version = "0.1.kotlin"


repositories {
    mavenCentral()
}

dependencies {

    val springBootVersion: String by rootProject.extra
    val springCloudVersion: String by rootProject.extra

    api(platform("org.springframework.boot:spring-boot-dependencies:${springBootVersion}"))
    api(platform("org.springframework.cloud:spring-cloud-dependencies:${springCloudVersion}"))
    //在constraints块中定义依赖版本约束
    constraints {
        api("com.github.johnrengelman.shadow:com.github.johnrengelman.shadow.gradle.plugin:7.1.2")
        api("org.projectlombok:lombok:1.18.26")
        api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.2")

    }
}


// 默认为防止用户错误地引入依赖，而不是引入依赖约束，如果引入依赖会报错失败
// 通过这个配置可以让Gradle允许引入依赖
javaPlatform {
    allowDependencies()
}

publishing {
    publications {
        //以下maven并非关键字，可自定义
        create<MavenPublication>("bom") {
            from(components["javaPlatform"])
        }
    }

//    repositories {
//
//        maven {
//            isAllowInsecureProtocol = true
//
//            url = URI.create("")
//            credentials {
//                username = ""
//                password = ""
//            }
//        }
//    }
}