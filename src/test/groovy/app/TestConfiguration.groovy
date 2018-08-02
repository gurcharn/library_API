package app

import com.github.fakemongo.Fongo
import com.mongodb.Mongo
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractMongoConfiguration
import org.springframework.web.client.RestTemplate

@Configuration
class TestConfiguration extends AbstractMongoConfiguration {

    @Override
    Mongo mongo() throws Exception {
        this.fongo().getMongo()
    }

    @Bean
    Fongo fongo() throws Exception {
        new Fongo(getDatabaseName())
    }

    @Bean
    RestTemplate restTemplate() {
        return new TestRestTemplate()
    }

    @Override
    protected String getDatabaseName() {
        "test"
    }
}
