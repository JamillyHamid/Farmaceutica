package sistema;

import java.util.ArrayList;
import java.util.List;

public class Transportadora {
    private String nome;
    private List<String> locaisAtendimento;
    private double valorFreteFixo;

    public Transportadora(String nome, double valorFreteFixo) {
        this.nome = nome;
        this.valorFreteFixo = valorFreteFixo;
        this.locaisAtendimento = new ArrayList<>();
    }

    public void addLocalAtendimento(String local) {
        this.locaisAtendimento.add(local);
    }

    public boolean atendeLocal(String local) {
        return locaisAtendimento.stream().anyMatch(l -> l.equalsIgnoreCase(local.trim()));
    }

    public String getNome() {
        return nome;
    }

    public List<String> getLocaisAtendimento() {
        return locaisAtendimento;
    }

    public double getValorFreteFixo() {
        return valorFreteFixo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValorFreteFixo(double valorFreteFixo) {
        this.valorFreteFixo = valorFreteFixo;
    }

    public void setLocaisAtendimento(List<String> locaisAtendimento) {
        this.locaisAtendimento = locaisAtendimento;
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
