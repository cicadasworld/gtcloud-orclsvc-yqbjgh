package gtcloud.yqbjgh.controllers

import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post

@SpringBootTest
@AutoConfigureMockMvc
class CampLocationControllerTest extends Specification {

    @Autowired
    private MockMvc mockMvc

    @Test
    def "GetVCampLocationForManagedCampByBdnm"() {
        given: 'expected Result'
        def expected = new File('src/test/resources/CampLocationControllerTest/v-camp-location-managed-camp-000000001.txt').getText()

        when: "REST Controller is called"
        def result = mockMvc.perform(get("/v-camp-location/managed-camp/{bdnm}", "000000001")).andReturn().response

        then: 'status is 200 OK'
        result.status == HttpStatus.OK.value()

        then: 'result is not empty'
        result.contentAsString != null

        and: 'contains expected json string'
        result.contentAsString == expected
    }

    @Test
    def "GetVCampLocationForUsingCampByBdnm"() {
        given: 'expected Result'
        def expected = new File('src/test/resources/CampLocationControllerTest/v-camp-location-using-camp-0801010101.txt').getText()

        when: "REST Controller is called"
        def result = mockMvc.perform(get("/v-camp-location/using-camp/{bdnm}", "0801010101")).andReturn().response

        then: 'status is 200 OK'
        result.status == HttpStatus.OK.value()

        then: 'result is not empty'
        result.contentAsString != null

        and: 'contains expected json string'
        result.contentAsString == expected
    }

    @Test
    def "GetVCampLocationByDknm"() {
        given: 'expected Result'
        def expected = new File('src/test/resources/CampLocationControllerTest/v-camp-location-dknm-FID00001.txt').getText()

        when: "REST Controller is called"
        def result = mockMvc.perform(get("/v-camp-location/dknm/{dknm}", "FID00001")).andReturn().response

        then: 'status is 200 OK'
        result.status == HttpStatus.OK.value()

        then: 'result is not empty'
        result.contentAsString != null

        and: 'contains expected json string'
        result.contentAsString == expected
    }

    @Test
    def "QueryVCampLocationByCustomFields"() {
        given: 'expected Result'
        def expected = new File('src/test/resources/CampLocationControllerTest/v-camp-location-customquery.txt').getText()

        when: "REST Controller is called"
        String body = new File('src/test/resources/CampLocationControllerTest/customquery-body.txt').getText()
        def result = mockMvc.perform(post("/v-camp-location/customquery").
                header("Content-Type", "application/json").
                content(body)).
                andReturn().response

        then: 'status is 200 OK'
        result.status == HttpStatus.OK.value()

        then: 'result is not empty'
        result.contentAsString != null

        and: 'contains expected json string'
        result.contentAsString == expected
    }

    @Test
    def "QueryCampLocationByPolygon"() {
        given: 'expected Result'
        def expected = new File('src/test/resources/CampLocationControllerTest/v-camp-location-polygonquery.txt').getText()

        when: "REST Controller is called"
        String body = new File('src/test/resources/CampLocationControllerTest/polygonquery-body.txt').getText()
        def result = mockMvc.perform(post("/v-camp-location/polygonquery").
                header("Content-Type", "application/json").
                content(body)).
                andReturn().response

        then: 'status is 200 OK'
        result.status == HttpStatus.OK.value()

        then: 'result is not empty'
        result.contentAsString != null

        and: 'contains expected json string'
        result.contentAsString == expected
    }

    @Test
    def "QueryCampLocationByCircle"() {
        given: 'expected Result'
        def expected = new File('src/test/resources/CampLocationControllerTest/v-camp-location-circlequery.txt').getText()

        when: "REST Controller is called"
        def result = mockMvc.perform(get("/v-camp-location/circlequery").
                param("lat", "116.23").
                param("lng", "39.55").
                param("radius", "0.05")).
                andReturn().response

        then: 'status is 200 OK'
        result.status == HttpStatus.OK.value()

        then: 'result is not empty'
        result.contentAsString != null

        and: 'contains expected json string'
        result.contentAsString == expected
    }
}
