package group.msg.at.cloud.cloudtrain.adapter.rest;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

/**
 * Adds a {@link CommonsRequestLoggingFilter} logging all inbound requests and outbound responses.
 */
@Configuration
public class RequestTracingFilterConfiguration {

    @Bean
    public FilterRegistrationBean<CommonsRequestLoggingFilter> requestLoggingFilter() {
        FilterRegistrationBean<CommonsRequestLoggingFilter> result = new FilterRegistrationBean<>();
        CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
        filter.setIncludeClientInfo(true);
        filter.setIncludeHeaders(true);
        filter.setIncludePayload(false);
        result.setFilter(filter);
        result.addUrlPatterns("/api/*");
        return result;
    }
}
