package sistema;
class Produto {
    private String nome;
    private String codigo;
    private double valorCompra;
    private double valorVenda;
    private int quantidadeEstoque;

    public Produto(String nome, String codigo, double valorCompra, double valorVenda, int quantidadeEstoque) {
        this.nome = nome;
        this.codigo = codigo;
        this.valorCompra = valorCompra;
        this.valorVenda = valorVenda;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    // --- Getters e Setters ---
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCodigo() { return codigo; }

    public double getValorCompra() { return valorCompra; }
    public void setValorCompra(double valorCompra) { this.valorCompra = valorCompra; }

    public double getValorVenda() { return valorVenda; }
    public void setValorVenda(double valorVenda) { this.valorVenda = valorVenda; }

    public int getQuantidadeEstoque() { return quantidadeEstoque; }
    public void setQuantidadeEstoque(int quantidadeEstoque) { this.quantidadeEstoque = quantidadeEstoque; }

    @Override
    public String toString() {
        return "Cód: " + codigo +
                ", Nome: " + nome +
                ", Compra: R$" + String.format("%.2f", valorCompra) +
                ", Venda: R$" + String.format("%.2f", valorVenda) +
                ", Estoque: " + quantidadeEstoque + " un.";
    }
}
