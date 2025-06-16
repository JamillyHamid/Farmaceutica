package sistema;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NegocioEmAndamento {
    private String idNegocio;
    private String tipo; // "Venda" ou "Compra"
    private List<Funcionario> participantesVenda; // Vendedores
    private List<Funcionario> participantesCompra; // Pessoal do almoxarifado
    private LocalDate dataInicio;
    private String status; // Ex: "Em negociação", "Aguardando pagamento", "Concluído", "Cancelado"
    private Map<Produto, Integer> produtosEnvolvidos; // Produto e quantidade

    public NegocioEmAndamento(String idNegocio, String tipo, LocalDate dataInicio,  Map<Produto, Integer> produtosEnvolvidos) {
        this.idNegocio = idNegocio;
        this.tipo = tipo;
        this.dataInicio = dataInicio;
        this.status = "Em negociação";
        this.participantesVenda = new ArrayList<>();
        this.participantesCompra = new ArrayList<>();
        this.produtosEnvolvidos = produtosEnvolvidos;
    } 

    public void addParticipantesVenda(List<Funcionario> participantesVenda) {
        this.participantesVenda = participantesVenda;
    }

    public void addParticipantesCompra(List<Funcionario> participantesCompra) {
        this.participantesCompra = participantesCompra;
    }

    // --- Getters e Setters ---
    public String getIdNegocio() { return idNegocio; }
    public String getTipo() { return tipo; }
    public List<Funcionario> getParticipantesVenda() { return participantesVenda; }
    public List<Funcionario> getParticipantesCompra() { return participantesCompra; }
    public LocalDate getDataInicio() { return dataInicio; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Map<Produto, Integer> getProdutosEnvolvidos() { return produtosEnvolvidos; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID do Negócio: ").append(idNegocio)
                .append(", Tipo: ").append(tipo)
                .append(", Status: ").append(status)
                .append(", Data Início: ").append(dataInicio)
                .append("\n  Produtos Envolvidos:\n");
        produtosEnvolvidos.forEach((produto, qtd) ->
                sb.append("    - ").append(produto.getNome()).append(" (").append(qtd).append(" unidades)\n")
        );
        if (!participantesVenda.isEmpty()) {
            sb.append("  Vendedores: ");
            participantesVenda.forEach(f -> sb.append(f.getNomeCompleto()).append(" "));
            sb.append("\n");
        }
        if (!participantesCompra.isEmpty()) {
            sb.append("  Almoxarifado: ");
            participantesCompra.forEach(f -> sb.append(f.getNomeCompleto()).append(" "));
            sb.append("\n");
        }
        return sb.toString();
    }
}
