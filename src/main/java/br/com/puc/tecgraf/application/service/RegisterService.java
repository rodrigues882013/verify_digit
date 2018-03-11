package br.com.puc.tecgraf.application.service;

public class RegisterService {

    private static RegisterService instance;

    private RegisterService(){
    }

    public static RegisterService getInstance(){

        if(instance == null){
            instance = new RegisterService();
        }
        return instance;
    }

    private String convert(Integer sum){
       return Integer.toString(Integer.parseInt(String.format("%d", sum % 16)), 16).toUpperCase();
    }


    public String checkDigit(String line){
        return checkRegister(line.split("-")[0]).equals(line) ?
                String.format("%s verdadeiro", line) : String.format("%s falso", line);

    }

    public String checkRegister(String register){

        Integer sum = Integer.parseInt(register.substring(0, 1)) * 5 +
                Integer.parseInt(register.substring(1, 2)) * 4 +
                Integer.parseInt(register.substring(2, 3)) * 3 +
                Integer.parseInt(register.substring(3, 4)) * 2;

        return String.format("%s-%s", register, convert(sum));

    }
}
