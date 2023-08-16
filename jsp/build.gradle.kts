description = "jsp"

plugins {
    war
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-hateoas")
//    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-web-services")
    implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.2")
//    implementation("org.springframework.session:spring-session-core")
    implementation("org.apache.tomcat.embed:tomcat-embed-jasper")
    compileOnly("jakarta.servlet:jakarta.servlet-api:6.0.0")
    implementation("jakarta.servlet.jsp.jstl:jakarta.servlet.jsp.jstl-api:3.0.0")
    implementation("org.glassfish.web:jakarta.servlet.jsp.jstl:3.0.1")
//    implementation("org.flywaydb:flyway-core")
//    implementation("org.flywaydb:flyway-mysql")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
//    developmentOnly("org.springframework.boot:spring-boot-docker-compose")
    runtimeOnly("com.mysql:mysql-connector-j")
    testImplementation("org.mybatis.spring.boot:mybatis-spring-boot-starter-test:3.0.2")
    testImplementation("org.springframework.security:spring-security-test")
}