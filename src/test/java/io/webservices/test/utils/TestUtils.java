package io.webservices.test.utils;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

/**
 * @author Rintcius Blok
 */
public class TestUtils {

    public static byte[] resourcePathToBytes(String path) {
        try {
            return IOUtils.toByteArray(new ClassPathResource(path).getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
