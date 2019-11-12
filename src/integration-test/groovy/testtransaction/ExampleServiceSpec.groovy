package testtransaction

import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Specification

@Integration
@Rollback
class ExampleServiceSpec extends Specification {

    ExampleService exampleService

    void "test saveTest"() {
        when:
        List<Example> exampleListProcessed
        List<Example> exampleList
        Example.withNewSession {
            exampleListProcessed = (1..5).collect {
                exampleService.saveTest()
            }

            exampleList = Example.findAll()
        }

        then:
        exampleListProcessed.unique { it.id }.size() == 1
        exampleList.size() == 1
    }

    void "test saveTest2"() {
        when:
        List<Example> exampleListProcessed
        List<Example> exampleList
        Example.withNewSession {
            exampleListProcessed = (1..5).collect {
                exampleService.saveTest()
            }

            exampleList = Example.findAll()
        }

        then:
        exampleListProcessed.unique { it.id }.size() == 1
        exampleList.size() == 1
    }
}
