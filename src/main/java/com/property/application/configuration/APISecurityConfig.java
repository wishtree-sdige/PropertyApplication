package com.property.application.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.property.application.constant.StatusConstants;
import com.property.application.controller.PropertyController;
import com.property.application.exception.UnAuthorizedException;

@Configuration
@EnableWebSecurity
@EnableWebMvc
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class APISecurityConfig extends WebSecurityConfigurerAdapter {
    @Value("${api-key.name}")
    private String name;

    @Value("${api-key.value}")
    private String value;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ApiKeyFilter filter = new ApiKeyFilter(name);
        filter.setAuthenticationManager(new AuthenticationManager() {

            @Override
            public Authentication authenticate(Authentication authentication) {
                String principal = (String) authentication.getPrincipal();
                if(principal == null) {
                	throw new UnAuthorizedException(StatusConstants.HttpConstants.UNAUTHORIZED);
                }
                if (!value.equals(principal))
                {
                	throw new UnAuthorizedException(StatusConstants.HttpConstants.UNAUTHORIZED);
                }
                authentication.setAuthenticated(true);
                return authentication;
            }
        });
        http.antMatcher("/**").
        csrf().
        disable().
        sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).
        and()
            .addFilter(filter)
            .authorizeRequests()
            .anyRequest()
            .authenticated();
    }

    @Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
			}
		};
	}
}
