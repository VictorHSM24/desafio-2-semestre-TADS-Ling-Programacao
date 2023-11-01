package exceptions;

public class ContatoNaoExisteException extends Exception {
    public ContatoNaoExisteException() {
        super("O contato procurado não existe!");
    }
}
