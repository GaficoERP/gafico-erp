package sn.smart.eco.clients.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@Import(ClientInfoConfigTest.class)
@EnableWebMvc
public class ClientInfoConfigRestTest {

}
