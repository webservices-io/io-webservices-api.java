package io.webservices.test;

import io.webservices.api.WebservicesConfiguration;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.inject.Inject;

/**
 * @author Rintcius Blok
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class,
        classes = {Configurations.ProdConfig.class, Configurations.TestConfig.class, Configurations.DevConfig.class})
@ActiveProfiles("test")
abstract public class AbstractClientTest {

    @Inject
    protected WebservicesConfiguration cfg;

}
