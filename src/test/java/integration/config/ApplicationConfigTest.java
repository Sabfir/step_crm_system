package integration.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"org.itstep.j2_16", "integration.helper"})
//@PropertySource(value = "classpath:application-test.properties")
public class ApplicationConfigTest {
}
