package ovh.cybuch.sample.yaml;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import ovh.cybuch.sample.yaml.MyConfiguration.MyConfigurationProperties;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class MyConfigurationTest {

    @Autowired
    private MyConfigurationProperties myConfigurationProperties;

    @Test
    public void shouldHaveBeenInitializedWithAllProperties() {
        assertEquals(myConfigurationProperties.getFoo(), "bar");
        assertEquals(myConfigurationProperties.getBar(), "foo");
        assertEquals(myConfigurationProperties.getCustom(), "foo bar");
    }
}
