package testtransaction

import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Specification

@Integration
@Rollback
class ExampleServiceSpec extends Specification{

    @Autowired
    ExampleService exampleService

    void "test saveTest"() {
        when:
        5.times{
            exampleService.saveTest()
        }

        List<Example> exampleList
        Example.withTransaction {
            exampleList= Example.findAll()
        }

        then:
        exampleList.size()==1
    }
}
