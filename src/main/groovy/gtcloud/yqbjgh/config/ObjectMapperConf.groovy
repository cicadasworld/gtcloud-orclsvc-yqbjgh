package gtcloud.yqbjgh.config

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ObjectMapperConf {

    @Bean
    ObjectMapper objectMapper() {
        return new ObjectMapper()
    }
}
