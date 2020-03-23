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
class CampCoordinateControllerTest extends Specification {

    @Autowired
    private MockMvc mockMvc

    @Test
    def "GetCampCoordinateByFid"() {
        given: 'expected Result'
        def expected = new File('src/test/resources/CampCoordinateControllerTest/camp-coordinate-FID00014.txt').getText()

        when: "REST Controller is called"
        def result = mockMvc.perform(get("/camp-coordinate/{fid}", "FID00014")).andReturn().response

        then: 'status is 200 OK'
        result.status == HttpStatus.OK.value()

        then: 'result is not empty'
        result.contentAsString != null

        and: 'contains expected json string'
        result.contentAsString == expected
    }
}
