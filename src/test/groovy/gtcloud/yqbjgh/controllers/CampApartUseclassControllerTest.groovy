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
class CampApartUseclassControllerTest extends Specification {

    @Autowired
    private MockMvc mockMvc

    @Test
    def "GetCampApartUseclass"() {
        given: 'expected Result'
        def expected = new File('src/test/resources/CampApartUseclassControllerTest/camp-apart-useclass-FD006509.txt').getText()

        when: "REST Controller is called"
        def result = mockMvc.perform(get("/camp-apart-useclass/{apartId}", "FD006509")).andReturn().response

        then: 'status is 200 OK'
        result.status == HttpStatus.OK.value()

        then: 'result is not empty'
        result.contentAsString != null

        and: 'contains expected json string'
        result.contentAsString == expected
    }

    @Test
    def "getAreaStatistics"() {
        given: 'expected Result'
        def expected = '{"1003":466583.0,"1002":459036.0,"1001":451503.0}'

        when: 'REST Controller is called'
        def result = mockMvc.perform(get("/camp-apart-useclass/area-statistics/{campId}", "FID00011")).andReturn().response

        then: 'status is 200 OK'
        result.status == HttpStatus.OK.value()

        then: 'result is not empty'
        result.contentAsString != null

        and: 'contains expected json string'
        result.contentAsString == expected
    }
}
