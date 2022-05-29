// plugins {
// 	kotlin("kapt")
// }
//
// apply(plugin = "org.jetbrains.kotlin.plugin.spring")
// apply(plugin = "kotlin-kapt")
//
// allOpen {
// 	annotation("javax.persistence.Entity")
// 	annotation("javax.persistence.Table")
// }

dependencies {
    implementation("com.h2database:h2:1.3.148")
    runtimeOnly("com.microsoft.sqlserver:mssql-jdbc")
    // infraはドメインに依存
    implementation(project(":domain"))

    // https://mvnrepository.com/artifact/javax.persistence/javax.persistence-api
    implementation("javax.persistence:javax.persistence-api:2.2")

    // https://mvnrepository.com/artifact/org.springframework.data/spring-data-jpa
    implementation("org.springframework.data:spring-data-jpa:2.6.1")
    // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.6.6")
    // https://mvnrepository.com/artifact/org.hibernate/hibernate-core
    implementation("org.hibernate:hibernate-core:5.6.0.Final")
    implementation("org.springframework.data:spring-data-commons")
    implementation("com.h2database:h2:1.4.200")
}
