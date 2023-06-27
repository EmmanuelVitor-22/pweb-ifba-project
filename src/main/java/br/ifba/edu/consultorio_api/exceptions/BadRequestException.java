package br.ifba.edu.consultorio_api.exceptions;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String mensagemPersonalizada){
        super(mensagemPersonalizada);
    }
}
