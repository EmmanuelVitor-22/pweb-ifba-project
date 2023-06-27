package br.ifba.edu.consultorio_api.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String mensagemPersonalizada) {
        super(mensagemPersonalizada);
    }
    public NotFoundException() {
    }
}
