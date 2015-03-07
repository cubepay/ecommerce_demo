package com.company.config;

import com.company.web.Util;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by tsagita on 6/3/15.
 */
@Configuration
public class AppConfig {
    private @Value("#{appProperties.paymentLoggingUrl}") String paymentLoggingUrl;

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/pages/");
        resolver.setSuffix(".jsp");

        return resolver;
    }

    @Bean
    public Util util() {
        Util util = new Util();
        util.setPaymentLoggingUrl(paymentLoggingUrl);
        return util;
    }


}
