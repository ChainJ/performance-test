package configuration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


/**
 * Created by 01083446 on 2017/8/10.
 */
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{WebAppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/", "/*"};
    }
//    @Override
//    public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {
//        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
//        servletContext.addListener(new ContextLoaderListener(context));
//
//        context.setConfigLocation("configuration");
//        context.register(WebAppConfig.class);
//        context.setServletContext(servletContext);
//
//        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
//        ServletRegistration.Dynamic servlet = servletContext.addServlet("mvc-dispatcher", dispatcherServlet);
//        servlet.addMapping("/");
//        servlet.setAsyncSupported(true);
//        servlet.setLoadOnStartup(1);
//    }
}
