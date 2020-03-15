package gtcloud.yqbjgh.config

import org.locationtech.jts.geom.GeometryFactory
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@Component
class GeometryFactoryConf {

    @Bean
    GeometryFactory geometryFactory() {
        return new GeometryFactory()
    }
}
