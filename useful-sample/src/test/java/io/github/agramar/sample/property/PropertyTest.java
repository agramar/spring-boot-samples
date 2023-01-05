package io.github.agramar.sample.property;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(initializers = ConfigDataApplicationContextInitializer.class)
@EnableConfigurationProperties(value = {SampleProperties.class, RecordProperties.class})
@TestPropertySource("classpath:application.yml")
public class PropertyTest {

    @Autowired
    SampleProperties sampleProperties;

    @Autowired
    RecordProperties recordProperties;

    @Test
    void testSampleProperties() {
        assertNotNull(sampleProperties.getName());
        assertTrue(sampleProperties.getCount() > 0);
        assertEquals(2, sampleProperties.getOptions().size());
        assertNotNull(sampleProperties.getProps().get("foo"));
    }

    @Test
    void testRecordProperties() {
        assertNotNull(recordProperties.name());
        assertTrue(recordProperties.count() > 0);
        assertEquals(2, recordProperties.options().size());
    }
}