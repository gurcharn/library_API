package app

import com.github.fakemongo.Fongo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.test.web.client.TestRestTemplate
import spock.lang.Specification

@EnableAutoConfiguration
class BaseIntegrationTest extends Specification {

    @Autowired
    TestRestTemplate restTemplate

    @Autowired
    Fongo fongo

    def cleanup () {
        fongo.getDatabaseNames().each { databaseName ->
            fongo.dropDatabase(databaseName)
        }
    }
}
