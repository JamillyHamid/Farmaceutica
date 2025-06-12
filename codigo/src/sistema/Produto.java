package sistema;

public class Produto {
    private String nome;
    private String codigo;
    private static int count;
    private double valorCompra;
    private double valorVenda;
    private int quantidadeEstoque;


    public Produto(String nome, double valorCompra, double valorVenda, int quantidadeEstoque) {
        this.nome = nome;
        this.codigo = gerarId();
        count++;
        this.valorCompra = valorCompra;
        this.valorVenda = valorVenda;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    private String gerarId() {
        // Padrão PROD00001
        String valor = Integer.toString(count);
        String idNumber = "";
        for (int i = 0; i < (5 - valor.length()); i++) {
            idNumber += "0";
        }
        return String.format("PROD".concat(idNumber).concat(valor));
    }

    // --- Getters e Setters ---
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    @Override
    public String toString() {
        return "Cód: " + codigo +
                ", Nome: " + nome +
                ", Compra: R$" + String.format("%.2f", valorCompra) +
                ", Venda: R$" + String.format("%.2f", valorVenda) +
                ", Estoque: " + quantidadeEstoque + " un.";
    }
}
