package br.com.puc.tecgraf.application.facade;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class TestAnalyseFacade {

    @Test
    public void testClassExists() {
        try {
            Class.forName("br.com.puc.tecgraf.application.facade.AnalyseFacade");
        } catch (ClassNotFoundException e) {
            Assert.fail("should have a class called AnalyseFacade");
        }
    }

    @Test
    public void testBeginStart() {
        AnalyseFacade facade = new AnalyseFacade();
        //facade.beginAnalyse();
    }
}
