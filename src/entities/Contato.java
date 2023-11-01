package entities;

public class Contato {
    private String nome;
    private String telefone;
    private int id;
    private static int proximoId = 1;

    public Contato(String nome, String telefone) {
        if (nome == null || nome.trim().isEmpty() || telefone == null || telefone.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome e telefone são obrigatórios.");
        }

        this.nome = nome;
        this.telefone = telefone;
        this.id = proximoId;
        proximoId++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
