buildscript {

    repositories {
        mavenLocal()
        maven("https://maven.aliyun.com/repository/public/") {
            isAllowInsecureProtocol = true
        }
        mavenCentral()
    }
}

//全局变量
//two ways to declaration variables
//extra["springBootVersion"] = "3.0.0"
val springBootVersion by extra("3.1.1")
val springCloudVersion by extra("2022.0.3")
val lombokVersion by extra("1.18.28")

subprojects {
    if (this.name == "bom") {
        return@subprojects
    }

    repositories {
        mavenLocal()
        maven("https://maven.aliyun.com/repository/public/") {
            isAllowInsecureProtocol = true
        }
        mavenCentral()
    }

}