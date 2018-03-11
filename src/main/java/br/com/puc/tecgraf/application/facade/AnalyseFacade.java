package br.com.puc.tecgraf.application.facade;

import br.com.puc.tecgraf.application.service.HandleFileService;
import br.com.puc.tecgraf.application.service.RegisterService;
import br.com.puc.tecgraf.application.utils.Constants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;


public class AnalyseFacade {

    private static final Logger logger = LogManager.getLogger(AnalyseFacade.class.getName());

    private RegisterService registerService;
    private HandleFileService handleFileService;

    public AnalyseFacade(){
        registerService = RegisterService.getInstance();
        handleFileService = HandleFileService.getInstance();
    }

    private void classifyAndWrite(List<String> lines){
        try {
            for (String line : lines) {
                handleFileService.write(registerService.checkRegister(line),
                        Constants.FILE_REGISTER_WITH_DV, true);
            }
        } catch (IOException e){
            logger.error("Error: ", e.getMessage());
        }
    }

    private void verifyAndWrite(List<String> lines){
        try {
            for (String line : lines) {
                handleFileService.write(registerService.checkDigit(line),
                        Constants.FILE_REGISTER_VERIFIED, true);
            }
        } catch (IOException e){
            logger.error("Error: ", e.getMessage());
        }
    }

    public void beginAnalyse(){
        try {
            logger.info("Starting verification...");

            handleFileService.clean(Constants.FILE_REGISTER_VERIFIED);
            handleFileService.clean(Constants.FILE_REGISTER_WITH_DV);

            List<String> lines = handleFileService.read(Constants.FILE_REGISTER_WITHOUT_DV);
            classifyAndWrite(lines);

            lines = handleFileService.read(Constants.FILE_REGISTER_FOR_VERIFY);
            verifyAndWrite(lines);

            logger.info("Finishing verification.");

        } catch (IOException e) {
            logger.error("Error: ", e.getMessage());
        }

    }
}
