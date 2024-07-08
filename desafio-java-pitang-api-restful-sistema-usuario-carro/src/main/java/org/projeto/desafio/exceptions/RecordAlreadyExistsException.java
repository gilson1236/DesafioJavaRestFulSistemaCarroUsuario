package org.projeto.desafio.exceptions;

public class RecordAlreadyExistsException extends RuntimeException{
    public RecordAlreadyExistsException(String message){
        super(message);
    }
}
