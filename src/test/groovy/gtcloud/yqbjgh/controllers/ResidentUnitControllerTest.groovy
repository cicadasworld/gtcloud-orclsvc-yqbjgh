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
class ResidentUnitControllerTest extends Specification {

    @Autowired
    private MockMvc mockMvc

    @Test
    def "GetResidentUnit"() {
        given: 'expected Result'
        def expected = new File('src/test/resources/ResidentUnitControllerTest/resident-unit-020204.txt').getText()

        when: "REST Controller is called"
        def result = mockMvc.perform(get("/resident-unit/bdnm/{bdnm}", "020204")).andReturn().response

        then: 'status is 200 OK'
        result.status == HttpStatus.OK.value()

        then: 'result is not empty'
        result.contentAsString != null

        and: 'contains expected json string'
        result.contentAsString == expected
    }

    @Test
    def "GetResidentUnitByCampId"() {
        given: 'expected Result'
        def expected = new File('src/test/resources/ResidentUnitControllerTest/resident-unit-campid-FID00610.txt').getText()

        when: "REST Controller is called"
        def result = mockMvc.perform(get("/resident-unit/campid/{campId}", "FID00610")).andReturn().response

        then: 'status is 200 OK'
        result.status == HttpStatus.OK.value()

        then: 'result is not empty'
        result.contentAsString != null

        and: 'contains expected json string'
        result.contentAsString == expected
    }
}
