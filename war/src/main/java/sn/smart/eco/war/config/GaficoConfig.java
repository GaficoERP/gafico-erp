package sn.smart.eco.war.config;

import sn.smart.eco.common.jpa.config.CommonConfigRest;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({CommonConfigRest.class})
public class GaficoConfig {

}
