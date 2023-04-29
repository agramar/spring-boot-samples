description = "kafka"

dependencies {
    implementation("org.springframework.kafka:spring-kafka")
    implementation("org.apache.kafka:kafka-streams")
    testImplementation("org.springframework.kafka:spring-kafka-test")
}