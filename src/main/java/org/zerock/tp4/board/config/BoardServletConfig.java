package org.zerock.tp4.board.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc //webvc사용하기위해
@ComponentScan(basePackages = "org.zerock.tp4.board.controller")
public class BoardServletConfig implements WebMvcConfigurer {


}
