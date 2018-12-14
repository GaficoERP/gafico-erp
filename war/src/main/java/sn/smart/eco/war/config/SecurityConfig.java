// package sn.smart.eco.war.config;
//
// import sn.smart.eco.auth.service.TokenHandler;
// import sn.smart.eco.auth.service.impl.JwtAuthenticationEntryPoint;
// import sn.smart.eco.auth.service.impl.StatelessAuthenticationFilter;
// import sn.smart.eco.auth.service.impl.UserDetailsServiceImpl;
// import sn.smart.eco.war.filters.CorsHeaderFilter;
//
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.http.HttpMethod;
// import org.springframework.security.authentication.AuthenticationManager;
// import
// org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import
// org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
// import
// org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import
// org.springframework.security.config.annotation.web.builders.WebSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import
// org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
// import org.springframework.security.web.session.ConcurrentSessionFilter;
//
// @Configuration
// @EnableWebSecurity
// @EnableGlobalMethodSecurity(prePostEnabled = true)
// public class SecurityConfig extends WebSecurityConfigurerAdapter {
// @Autowired
// private UserDetailsServiceImpl userService;
//
// @Autowired
// private JwtAuthenticationEntryPoint unauthorizedHandler;
//
// @Autowired
// private TokenHandler tokenHandler;
//
// @Value("${app.jwt.header}")
// private String tokenHeader;
//
// @Bean
// public BCryptPasswordEncoder bCryptPasswordEncoder() {
// // le mot de passe sera crypté 12fois (cryptage du cryptage du cryptage ...)
// return new BCryptPasswordEncoder(12);
// }
//
// @Autowired
// public void configureGlobal(AuthenticationManagerBuilder auth) throws
// Exception {
// auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());
// }
//
// @Bean
// @Override
// public AuthenticationManager authenticationManagerBean() throws Exception {
// return super.authenticationManagerBean();
// }
//
// @Override
// protected void configure(HttpSecurity http) throws Exception {
// http.csrf().disable();
// http.exceptionHandling().and().anonymous().and().servletApi().and().headers().cacheControl();
// http.authorizeRequests().antMatchers("/api/auth/**").anonymous().antMatchers("/rest/**")
// .authenticated().anyRequest().permitAll().and().exceptionHandling()
// .accessDeniedHandler(unauthorizedHandler).and().sessionManagement()
// .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
// http.addFilterBefore(new StatelessAuthenticationFilter(tokenHeader,
// tokenHandler),
// UsernamePasswordAuthenticationFilter.class);
// http.addFilterBefore(new CorsHeaderFilter(), ConcurrentSessionFilter.class);
// }
//
// @Override
// public void configure(WebSecurity web) throws Exception {
// web.ignoring().antMatchers(HttpMethod.POST,
// "/api/auth/**").and().ignoring().antMatchers(
// HttpMethod.GET, "/", "/*.html", "/favicon.ico", "/**/*.html", "/**/*.css",
// "/assets/**",
// "/**/*.js");
// }
//
// // @Bean
// // public CorsFilter corsFilter() {
// // UrlBasedCorsConfigurationSource source = new
// UrlBasedCorsConfigurationSource();
// // CorsConfiguration config = new CorsConfiguration();
// // config.setAllowCredentials(true);
// // config.addAllowedOrigin("*");
// // config.addAllowedHeader("*");
// // config.addAllowedMethod("OPTIONS");
// // config.addAllowedMethod("GET");
// // config.addAllowedMethod("POST");
// // config.addAllowedMethod("PUT");
// // config.addAllowedMethod("DELETE");
// // source.registerCorsConfiguration("/**", config);
// // return new CorsFilter((CorsConfigurationSource) source);
// // }
//
// }
