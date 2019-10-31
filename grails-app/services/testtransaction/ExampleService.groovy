package testtransaction

import grails.gorm.transactions.Transactional

class ExampleService {

    @Transactional
    Example saveTest() {
        Example example = Example.findOrCreateWhere(name: 'NAME')
        example.save()
        example
    }
}
