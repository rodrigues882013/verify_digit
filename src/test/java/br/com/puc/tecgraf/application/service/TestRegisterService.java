package br.com.puc.tecgraf.application.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestRegisterService {

    private RegisterService service;

    @Before
    public void setUp(){
        service = RegisterService.getInstance();
    }

    @Test
    public void testClassExists() {
        try {
            Class.forName("br.com.puc.tecgraf.application.service.RegisterService");
        } catch (ClassNotFoundException e) {
            Assert.fail("should have a class called RegisterService");
        }
    }

    @Test
    public void testCheckRegister(){
        String result = service.checkRegister("9876");
        Assert.assertEquals(result, "9876-E");

        result = service.checkRegister("9992");
        Assert.assertEquals(result, "9992-0");
    }

    @Test
    public void testDigitOK(){
        String result = service.checkDigit("9876-E");
        Assert.assertEquals(result, "9876-E verdadeiro");

        result = service.checkDigit("9992-2");
        Assert.assertEquals(result, "9992-2 falso");
    }
}
