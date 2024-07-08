package org.projeto.desafio.exceptions;

public class RecordNotFoundException extends RuntimeException{

    public RecordNotFoundException(String message){
        super(message);
    }
}
