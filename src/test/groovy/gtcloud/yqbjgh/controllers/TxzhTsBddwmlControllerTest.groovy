package gtcloud.yqbjgh.controllers

import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get

@SpringBootTest
@AutoConfigureMockMvc
class TxzhTsBddwmlControllerTest extends Specification {

    @Autowired
    private MockMvc mockMvc

    @Test
    def "GetTxzhTsBddwml"() {
        given: 'expected Result'
        def expected = new File('src/test/resources/TxzhTsBddwmlControllerTest/bddwml-000000001.txt').getText()

        when: "REST Controller is called"
        def result = mockMvc.perform(get("/bddwml/{nm}", "000000001")).andReturn().response

        then: 'status is 200 OK'
        result.status == HttpStatus.OK.value()

        then: 'result is not empty'
        result.contentAsString != null

        and: 'contains expected json string'
        result.contentAsString == expected
    }

    @Test
    def "GetRootWithZbgc"() {
        given: 'expected Result'
        def expected = new File('src/test/resources/TxzhTsBddwmlControllerTest/managed-tree.txt').getText()

        when: "REST Controller is called"
        def result = mockMvc.perform(get("/bddwml-zbgc/catalogue")).andReturn().response

        then: 'status is 200 OK'
        result.status == HttpStatus.OK.value()

        then: 'result is not empty'
        result.contentAsString != null
//        new File('src/test/resources/TxzhTsBddwmlControllerTest/managed-tree.txt').write(result.contentAsString)

        and: 'contains expected json string'
        result.contentAsString == expected
    }

    @Test
    def "GetRootWithCampApartUseclass"() {
        given: 'expected Result'
        def expected = new File('src/test/resources/TxzhTsBddwmlControllerTest/using-tree.txt').getText()

        when: "REST Controller is called"
        def result = mockMvc.perform(get("/bddwml-resident-unit/catalogue")).andReturn().response

        then: 'status is 200 OK'
        result.status == HttpStatus.OK.value()

        then: 'result is not empty'
        result.contentAsString != null
//        new File('src/test/resources/TxzhTsBddwmlControllerTest/using-tree.txt').write(result.contentAsString)

        and: 'contains expected json string'
        result.contentAsString == expected
    }
}
