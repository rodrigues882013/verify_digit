package br.com.puc.tecgraf.application;

import org.junit.Assert;
import org.junit.Test;

public class TestApplication {

    @Test
    public void testClassExists() {
        try {
            Class.forName("br.com.puc.tecgraf.application.Application");
        } catch (ClassNotFoundException e) {
            Assert.fail("should have a class called Application");
        }
    }
}
