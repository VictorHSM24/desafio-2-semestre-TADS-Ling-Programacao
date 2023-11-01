package entities;

import entities.Contato;
import exceptions.AgendaCheiaException;
import exceptions.ContatoNaoExisteException;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<Contato> contatos;
    private static int limite = 10;
    private static int contador = 0;

   public Agenda() {
       contatos = new ArrayList<>();
   }

    public void addContato(Contato contato) throws AgendaCheiaException, ContatoNaoExisteException {
        try {
            if (contador < limite) {
                contatos.add(contato);
                contador++;
            } else {
                throw new AgendaCheiaException();
            }
        } catch (AgendaCheiaException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public int buscarContato(String termo) throws ContatoNaoExisteException {
        for (int i = 0; i < contatos.size(); i++) {
            Contato contato = contatos.get(i);
            if (contato.getNome().equals(termo.toLowerCase()) || contato.getTelefone().equals(termo)) {
                return i;
            }
        }
        throw new ContatoNaoExisteException();
    }

    public boolean estaVazia() {
        return contatos.isEmpty();
    }
}
