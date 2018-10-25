package sn.smart.eco.budget.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@Import(BudgetConfigTest.class)
@ComponentScan("sn.smart.eco.budget")
@EnableWebMvc
public class BudgetConfigRestTest {
}
