package org.zerock.tp4.common.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.zerock.tp4.board.config.BoardRootConfig;
import org.zerock.tp4.board.config.BoardServletConfig;
import org.zerock.tp4.security.config.SecurityConfig;
import org.zerock.tp4.security.config.SecurityServletConfig;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.MultipartConfig;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {

        logger.info("1----------------------------------");
        logger.info("1----------------------------------");

        return new Class[] {RootConfig.class, SecurityConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        logger.info("2----------------------------------");
        logger.info("2----------------------------------");

        return new Class[] {ServletConfig.class, SecurityServletConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() { //post방식만 가능
        CharacterEncodingFilter utf8Filter = new CharacterEncodingFilter();
        utf8Filter.setEncoding("UTF-8");
        utf8Filter.setForceEncoding(true);

        return new Filter[]{utf8Filter};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");

        MultipartConfigElement multipartConfigElement
                =new MultipartConfigElement("/Users/hhwanseung/upload/temp", 1024*1024*10,1024*1024*20,1024*1024*1); //얼마까지 올리냐/얼마까지 받냐/임시저장사이즈
        registration.setMultipartConfig(multipartConfigElement);
    }
}