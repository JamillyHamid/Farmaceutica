import java.util.ArrayList;
import java.util.List;

class Transportadora {
    private String nome;
    private List<String> locaisAtendimento;

    public Transportadora(String nome) {
        this.nome = nome;
        this.locaisAtendimento = new ArrayList<>();
    }

    public void addLocalAtendimento(String local) {
        this.locaisAtendimento.add(local);
    }

    // --- Getters ---
    public String getNome() { return nome; }
    public List<String> getLocaisAtendimento() { return locaisAtendimento; }

    @Override
    public String toString() {
        return "Transportadora: " + nome +
                ", Locais de Atendimento: " + String.join(", ", locaisAtendimento);
    }
}
