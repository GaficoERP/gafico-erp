package sn.smart.eco.common.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@Import(CommonConfigTest.class)
@ComponentScan("sn.smart.eco.common")
@EnableWebMvc
public class CommonConfigRestTest {
}
