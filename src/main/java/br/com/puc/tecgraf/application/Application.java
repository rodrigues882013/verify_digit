package br.com.puc.tecgraf.application;


import br.com.puc.tecgraf.application.facade.AnalyseFacade;

public class Application {

    public static void main(String[] args){

        AnalyseFacade facade = new AnalyseFacade();
        facade.beginAnalyse();
    }
}
