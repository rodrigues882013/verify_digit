package br.com.puc.tecgraf.application.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class HandleFileService {

    private static final Logger logger = LogManager.getLogger(HandleFileService.class.getName());

    private static HandleFileService service;

    private HandleFileService(){

    }

    public static HandleFileService getInstance(){

        if(service == null){
            service = new HandleFileService();
        }
        return service;
    }


    public List<String> read(String path) throws IOException {
        logger.info("Read file from source");

        File file = new File(path);
        try(Stream<String> stream = Files.lines(file.toPath())){
            return stream.collect(Collectors.toList());
        }

    }

    public void write(String line, String path, Boolean method) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path, method));
        writer.write(line);

        if (!line.equals("")){
            writer.write("\n");
        }
        writer.close();

    }

    public void clean(String path) throws IOException {
        write("", path, false);
    }
}
