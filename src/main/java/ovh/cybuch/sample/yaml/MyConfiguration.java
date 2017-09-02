package ovh.cybuch.sample.yaml;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static ovh.cybuch.sample.yaml.MyConfiguration.MyConfigurationProperties;

@Configuration
@EnableConfigurationProperties(MyConfigurationProperties.class)
class MyConfiguration {

    @Bean
    MyConfigurationProperties myConfigurationProperties() {
        return new MyConfigurationProperties();
    }

    @Data
    @ConfigurationProperties(prefix = "myConfig")
    @Getter
    static class MyConfigurationProperties {
        private String bar;
        private String foo;
        private String custom;
    }
}
