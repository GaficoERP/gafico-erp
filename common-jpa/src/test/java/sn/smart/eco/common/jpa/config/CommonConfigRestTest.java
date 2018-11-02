package sn.smart.eco.common.jpa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@Import(CommonConfigTest.class)
// @ComponentScan("sn.smart.eco.common.jpa")
@EnableWebMvc
@Profile("test")
public class CommonConfigRestTest {
}
