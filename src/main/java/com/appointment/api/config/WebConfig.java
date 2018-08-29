package com.appointment.api.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Value("${admin-ui-url}")
    private String dashboardUrl;

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        for (int i = 0; i < converters.size(); ++i) {
            if (converters.get(i) instanceof MappingJackson2HttpMessageConverter) {
                ObjectMapper mapper = objectMapper();
                converters.set(i, new MappingJackson2HttpMessageConverter(mapper));
                break;
            }
        }
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(dashboardUrl)
                .allowedMethods("OPTIONS", "POST", "GET");
    }

    private ObjectMapper objectMapper() {
        ObjectMapper mapper = new Jackson2ObjectMapperBuilder().
                serializerByType(LocalDateTime.class, new LocalDateTimeSerializer()).
                build();
        mapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        return mapper;
    }
}
