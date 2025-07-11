package sistema;

public class Funcionario {
    private String nomeCompleto;
    private String id;
    private static int count = 1;
    private String senha;
    private int idade;
    private String genero;
    private String cargo;
    private double salarioBase;
    private double valeTransporte;
    private double valeRefeicao;
    private double valeAlimentacao;
    private double planoSaude;
    private double planoOdontologico;
    private double bonificacaoLucros;
    private double impostoRenda;
    private double salarioLiquido;

    public Funcionario(String nomeCompleto, String senha, int idade, String genero, String cargo, double salarioBase) {
        this.nomeCompleto = nomeCompleto;
        this.id = gerarId();
        count++;
        this.senha = senha;
        this.idade = idade;
        this.genero = genero;
        this.cargo = cargo;
        this.salarioBase = salarioBase;
        this.bonificacaoLucros = 0.0;
        this.valeRefeicao = 300.0;
        this.valeAlimentacao = 300.0;
        this.planoSaude = 0.0;
        this.planoOdontologico = 0.0;

        ajustarBeneficiosPorCargo();
        this.valeTransporte = calcularValeTransporte();
        calcularImpostoRenda();
        calcularSalarioLiquido();
    }

    private String gerarId() {
        String valor = Integer.toString(count);
        String idNumber = "";
        for (int i = 0; i < (5 - valor.length()); i++) {
            idNumber += "0";
        }
        return String.format("EMP".concat(idNumber).concat(valor));
    }

    private void ajustarBeneficiosPorCargo() {
        switch (this.cargo) {
            case "Gerente de Filial":
                this.valeRefeicao = 500.0;
                this.valeAlimentacao = 500.0;
                this.planoSaude = 5000.0;
                break;
            case "Vendas":
                this.valeRefeicao = 350.0;
                this.valeAlimentacao = 350.0;
                break;
        }
    }

    private double calcularValeTransporte() {
        // Exemplo: 6% do salário base é descontado do funcionário para o VT
        // Aqui estamos considerando o custo para a empresa, ou seja, o valor que a
        // empresa "paga" ao funcionário
        // Se o funcionário paga uma parte, essa lógica precisa ser mais detalhada.
        // Para este exercício, vamos considerar que o VT é um custo da empresa e entra
        // no custo total de pessoal.
        return this.salarioBase * 0.06; // Um percentual como benefício ou custo da empresa
    }

    public void calcularImpostoRenda() {
        double baseCalculo = salarioBase + bonificacaoLucros;

        if (baseCalculo <= 2428.80) {
            this.impostoRenda = 0;
        } else if (baseCalculo <= 2826.65) {
            this.impostoRenda = (baseCalculo * 0.075) - 182.16;
        } else if (baseCalculo <= 3751.05) {
            this.impostoRenda = (baseCalculo * 0.15) - 394.16;
        } else if (baseCalculo <= 4664.68) {
            this.impostoRenda = (baseCalculo * 0.225) - 675.49;
        } else {
            this.impostoRenda = (baseCalculo * 0.275) - 908.75;
        }
        if (this.impostoRenda < 0)
            this.impostoRenda = 0;
    }

    public void calcularSalarioLiquido() {
        // Salário líquido = Salário Base + Bonificação - Imposto de Renda - Vale
        // Transporte (se for um desconto)
        // Para este exercício, vamos considerar VT como um custo da empresa, não um
        // desconto do salário base para o cálculo do líquido
        // Se o VT fosse um desconto, seria: salarioBase + bonificacaoLucros -
        // impostoRenda - valeTransporte;
        this.salarioLiquido = salarioBase + bonificacaoLucros - impostoRenda;
    }

    public void mudarSenha(String novaSenha) {
        this.senha = novaSenha;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getId() {
        return id;
    }

    public String getSenha() {
        return senha;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
        ajustarBeneficiosPorCargo();
        calcularValeTransporte();
        calcularImpostoRenda();
        calcularSalarioLiquido();
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
        calcularValeTransporte();
        calcularImpostoRenda();
        calcularSalarioLiquido();
    }

    public double getValeTransporte() {
        return valeTransporte;
    }

    public double getValeRefeicao() {
        return valeRefeicao;
    }

    public double getValeAlimentacao() {
        return valeAlimentacao;
    }

    public double getPlanoSaude() {
        return planoSaude;
    }

    public double getPlanoOdontologico() {
        return planoOdontologico;
    }

    public double getBonificacaoLucros() {
        return bonificacaoLucros;
    }

    public void setBonificacaoLucros(double bonificacaoLucros) {
        this.bonificacaoLucros = bonificacaoLucros;
        calcularImpostoRenda();
        calcularSalarioLiquido();
    }

    public double getImpostoRenda() {
        return impostoRenda;
    }

    public double getSalarioLiquido() {
        return salarioLiquido;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Nome: " + nomeCompleto +
                ", Idade: " + idade +
                ", Gênero: " + genero +
                ", Cargo: " + cargo +
                ", Salário Base: R$" + String.format("%.2f", salarioBase) +
                ", IR: R$" + String.format("%.2f", impostoRenda) +
                ", VT: R$" + String.format("%.2f", valeTransporte) +
                ", VR: R$" + String.format("%.2f", valeRefeicao) +
                ", VA: R$" + String.format("%.2f", valeAlimentacao) +
                ", PS: R$" + String.format("%.2f", planoSaude) +
                ", PO: R$" + String.format("%.2f", planoOdontologico) +
                ", Bonificação: R$" + String.format("%.2f", bonificacaoLucros) +
                ", Salário Líquido: R$" + String.format("%.2f", salarioLiquido);
    }
}
