package sistema;

import java.util.ArrayList;
import java.util.List;

class Transportadora {
    private String nome;
    private List<String> locaisAtendimento;
    private double valorFreteFixo; // Novo: Valor de frete único para a transportadora

    public Transportadora(String nome, double valorFreteFixo) { // Construtor modificado
        this.nome = nome;
        this.valorFreteFixo = valorFreteFixo;
        this.locaisAtendimento = new ArrayList<>();
    }

    public void addLocalAtendimento(String local) {
        this.locaisAtendimento.add(local);
    }

    // Método para verificar se a transportadora atende um local
    public boolean atendeLocal(String local) {
        return locaisAtendimento.stream().anyMatch(l -> l.equalsIgnoreCase(local.trim()));
    }

    // --- Getters ---
    public String getNome() { return nome; }
    public List<String> getLocaisAtendimento() { return locaisAtendimento; }
    public double getValorFreteFixo() { return valorFreteFixo; } // Novo getter
    // Opcional: Setter para valorFreteFixo se precisar mudar dinamicamente
    public void setValorFreteFixo(double valorFreteFixo) {
        this.valorFreteFixo = valorFreteFixo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transportadora: ").append(nome)
          .append(" (Frete Fixo: R$").append(String.format("%.2f", valorFreteFixo)).append(")")
          .append("\n  Locais de Atendimento: ");
        if (locaisAtendimento.isEmpty()) {
            sb.append("Nenhum");
        } else {
            sb.append(String.join(", ", locaisAtendimento));
        }
        return sb.toString();
    }
}
