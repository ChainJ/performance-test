package configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by 01083446 on 2017/8/10.
 */
@Configuration
@EnableWebMvc
@ComponentScan("")
public class WebAppConfig extends WebMvcConfigurerAdapter {
}
