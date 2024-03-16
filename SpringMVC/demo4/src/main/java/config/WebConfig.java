package config;

import controller.MyController;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * @author Lemon
 * @create 2022-11-16-21:25
 */
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SMConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter cf=new CharacterEncodingFilter();
        cf.setEncoding("UTF-8");
        cf.setForceResponseEncoding(true);
        HiddenHttpMethodFilter hm=new HiddenHttpMethodFilter();
        return new Filter[]{cf,hm};
    }
}
