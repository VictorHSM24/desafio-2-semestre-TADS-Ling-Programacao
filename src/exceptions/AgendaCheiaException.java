package exceptions;

public class AgendaCheiaException extends Exception {
    public AgendaCheiaException() {
        super("Não foi possível adicionar o contato pois a agenda está cheia!");
    }
}
