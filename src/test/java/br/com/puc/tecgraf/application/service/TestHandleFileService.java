package br.com.puc.tecgraf.application.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.List;

public class TestHandleFileService {

    private HandleFileService service;

    @Before
    public void setUp(){
        service = HandleFileService.getInstance();
    }

    @Test
    public void testClassExists() {
        try {
            Class.forName("br.com.puc.tecgraf.application.service.HandleFileService");
        } catch (ClassNotFoundException e) {
            Assert.fail("should have a class called HandleFileService");
        }
    }

    @Test
    public void testRead() throws IOException {
        List<String> lines = service.read("test_file_empty.txt");
        Assert.assertEquals(lines.isEmpty(), true);

        lines = service.read("test_file.txt");
        Assert.assertEquals(lines.isEmpty(), false);
        Assert.assertEquals(lines.size(), 4);

    }

    @Test(expected = NoSuchFileException.class)
    public void testReadWithoutFile() throws IOException {
        service.read("without.txt");
    }

    @Test
    public void testWrite() throws IOException {
        service.write("Hello World", "test_new_file.txt", true);
        List<String> lines = service.read("test_new_file.txt");

        Assert.assertEquals("Hello World", lines.get(0));
    }

    @Test
    public void testClean() throws IOException {
        List<String> lines = service.read("test_cleanup_file.txt");

        Assert.assertEquals(false, lines.isEmpty());

        service.clean("cleanup_file.txt");
        lines = service.read("cleanup_file.txt");

        Assert.assertEquals(true, lines.isEmpty());
    }

}
