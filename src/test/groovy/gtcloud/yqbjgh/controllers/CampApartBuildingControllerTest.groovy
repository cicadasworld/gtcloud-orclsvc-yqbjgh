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
class CampApartBuildingControllerTest extends Specification {

    @Autowired
    private MockMvc mockMvc

    @Test
    def "GetCampApartBuilding"() {
        given: 'expected Result'
        def expected = new File('src/test/resources/CampApartBuildingController/camp-apart-building-FD006701.txt').getText()

        when: "REST Controller is called"
        def result = mockMvc.perform(get("/camp-apart-building/{jlbm}", "FD006701")).andReturn().response

        then: 'status is 200 OK'
        result.status == HttpStatus.OK.value()

        then: 'result is not empty'
        result.contentAsString != null

        and: 'contains expected json string'
        result.contentAsString == expected
    }

    @Test
    def "GetCampApartBuildingByCampId"() {
        given: 'expected Result'
        def expected = new File('src/test/resources/CampApartBuildingController/camp-apart-building-campid-FID01701.txt').getText()

        when: "REST Controller is called"
        def result = mockMvc.perform(get("/camp-apart-building/campid/{campId}", "FID01701")).andReturn().response

        then: 'status is 200 OK'
        result.status == HttpStatus.OK.value()

        then: 'result is not empty'
        result.contentAsString != null

        and: 'contains expected json string'
        result.contentAsString == expected
    }
}
