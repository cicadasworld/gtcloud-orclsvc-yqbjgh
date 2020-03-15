package gtcloud.yqbjgh.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport

@Configuration
class WebConfig extends WebMvcConfigurationSupport {

    @Override
    void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
    }
}
