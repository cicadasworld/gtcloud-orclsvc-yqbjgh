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
class UnitInforControllerTest extends Specification {

    @Autowired
    private MockMvc mockMvc

    @Test
    def "GetVUnitInforBybdnm"() {
        given: 'expected Result'
        def expected = new File('src/test/resources/UnitInforControllerTest/v-unit-infor-bdnm-000000001.txt').getText()

        when: "REST Controller is called"
        def result = mockMvc.perform(get("/v-unit-infor/bdnm/{bdnm}", "000000001")).andReturn().response

        then: 'status is 200 OK'
        result.status == HttpStatus.OK.value()

        then: 'result is not empty'
        result.contentAsString != null

        and: 'contains expected json string'
        result.contentAsString == expected
    }

    @Test
    def "GetVUnitInforByCampId"() {
        given: 'expected Result'
        def expected = new File('src/test/resources/UnitInforControllerTest/v-unit-infor-campid-FID00001.txt').getText()

        when: "REST Controller is called"
        def result = mockMvc.perform(get("/v-unit-infor/campid/{campId}", "FID00001")).andReturn().response

        then: 'status is 200 OK'
        result.status == HttpStatus.OK.value()

        then: 'result is not empty'
        result.contentAsString != null

        and: 'contains expected json string'
        result.contentAsString == expected
    }

    @Test
    def "GetVUnitInforByApartNum"() {
        given: 'expected Result'
        def expected = new File('src/test/resources/UnitInforControllerTest/v-unit-infor-apartnum-1.txt').getText()

        when: "REST Controller is called"
        def result = mockMvc.perform(get("/v-unit-infor/apartnum/{apartNum}", "1")).andReturn().response

        then: 'status is 200 OK'
        result.status == HttpStatus.OK.value()

        then: 'result is not empty'
        result.contentAsString != null

        and: 'contains expected json string'
        result.contentAsString == expected
    }
}
