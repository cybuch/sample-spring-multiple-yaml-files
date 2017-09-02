package ovh.cybuch.sample.yaml;

import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Map;

import static com.google.common.collect.ImmutableMap.of;

class YamlFileApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    private static final Map<String, String> RESOURCE_LOCATIONS = of("myConfig", "classpath:myConfig.yml");

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        RESOURCE_LOCATIONS.forEach((key, value) ->
                addYamlPropertiesToSpringEnvironment(applicationContext, key, value)
        );
    }

    private void addYamlPropertiesToSpringEnvironment(
            ConfigurableApplicationContext applicationContext,
            String resourceName,
            String resourceLocation) {
        try {
            Resource resource = applicationContext.getResource(resourceLocation);
            YamlPropertySourceLoader yamlPropertySourceLoader = new YamlPropertySourceLoader();
            PropertySource<?> yamlProperties = yamlPropertySourceLoader.load(resourceName, resource, null);
            applicationContext.getEnvironment()
                    .getPropertySources()
                    .addLast(yamlProperties);
        } catch (IOException e) {
            throw new RuntimeException("Unable to load resource file", e);
        }
    }
}
