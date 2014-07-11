package com.epam.electricalappliance.exeptions;

public class TechnicalException extends Exception{

    public TechnicalException() {
    }

    public TechnicalException(String error) {
        super(error);
    }

    public TechnicalException(String error, Exception e) {
        super(error,e);
    }


}
