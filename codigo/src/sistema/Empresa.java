package sistema;

import java.time.LocalDate;
import java.util.*;

public class Empresa {
    private double caixaTotal;
    private Map<String, Setor> setores;
    private Map<String, Produto> produtos;
    private List<Transportadora> transportadoras;
    private List<NegocioEmAndamento> negociosEmAndamento;
    private Scanner scanner;

    public Empresa() {
        this.caixaTotal = 200000.00;
        this.setores = new HashMap<>();
        this.produtos = new HashMap<>();
        this.transportadoras = new ArrayList<>();
        this.negociosEmAndamento = new ArrayList<>();
        this.scanner = new Scanner(System.in);

        setores.put("Gerente de Filial", new Setor("Gerente de Filial"));
        setores.put("Atendimento ao Cliente", new Setor("Atendimento ao Cliente"));
        setores.put("Gestão de Pessoas", new Setor("Gestão de Pessoas"));
        setores.put("Financeiro", new Setor("Financeiro"));
        setores.put("Vendas", new Setor("Vendas"));
        setores.put("Almoxarifado", new Setor("Almoxarifado"));
        setores.put("Transportadoras", new Setor("Transportadoras"));

        adicionarFuncionario(
                new Funcionario("Ana Paula Silva", "EMP001", 45, "Feminino", "Gerente de Filial", 10000.00),
                "Gerente de Filial");
        adicionarFuncionario(new Funcionario("Carlos Alberto Mendes", "EMP002", 28, "Masculino", "Atendente", 2500.00),
                "Atendimento ao Cliente");
        adicionarFuncionario(new Funcionario("Beatriz Costa Lima", "EMP003", 32, "Feminino", "Atendente", 2600.00),
                "Atendimento ao Cliente");
        adicionarFuncionario(new Funcionario("Fernando Santos", "EMP004", 25, "Masculino", "Atendente", 2400.00),
                "Atendimento ao Cliente");
        adicionarFuncionario(
                new Funcionario("Gabriela Oliveira", "EMP005", 30, "Feminino", "Atendente Sênior", 2800.00),
                "Atendimento ao Cliente");
        adicionarFuncionario(new Funcionario("Heloísa Dantas", "EMP006", 38, "Feminino", "Analista RH", 4000.00),
                "Gestão de Pessoas");
        adicionarFuncionario(new Funcionario("Igor Rodrigues", "EMP007", 35, "Masculino", "Assistente RH", 3200.00),
                "Gestão de Pessoas");
        adicionarFuncionario(new Funcionario("Juliana Alves", "EMP008", 40, "Feminino", "Gerente RH", 6000.00),
                "Gestão de Pessoas");
        adicionarFuncionario(new Funcionario("Leandro Gomes", "EMP009", 29, "Masculino", "Recrutador", 3500.00),
                "Gestão de Pessoas");
        adicionarFuncionario(new Funcionario("Márcia Fernandes", "EMP010", 42, "Feminino", "Contador", 5500.00),
                "Financeiro");
        adicionarFuncionario(
                new Funcionario("Nelson Pereira", "EMP011", 33, "Masculino", "Analista Financeiro", 4500.00),
                "Financeiro");
        adicionarFuncionario(new Funcionario("Olívia Souza", "EMP012", 27, "Feminino", "Auxiliar Financeiro", 3000.00),
                "Financeiro");
        adicionarFuncionario(new Funcionario("Paulo Roberto", "EMP013", 31, "Masculino", "Vendedor", 3500.00),
                "Vendas");
        adicionarFuncionario(new Funcionario("Quiteria Barbosa", "EMP014", 36, "Feminino", "Vendedor Sênior", 4000.00),
                "Vendas");
        adicionarFuncionario(new Funcionario("Ricardo Dutra", "EMP015", 29, "Masculino", "Vendedor", 3400.00),
                "Vendas");
        adicionarFuncionario(new Funcionario("Sara Vieira", "EMP016", 30, "Feminino", "Vendedor", 3600.00), "Vendas");
        adicionarFuncionario(new Funcionario("Thiago Martins", "EMP017", 40, "Masculino", "Gerente de Vendas", 7000.00),
                "Vendas");
        adicionarFuncionario(
                new Funcionario("Úrsula Costa", "EMP018", 34, "Feminino", "Encarregado Almoxarifado", 3800.00),
                "Almoxarifado");
        adicionarFuncionario(
                new Funcionario("Vitor Hugo", "EMP019", 26, "Masculino", "Assistente Almoxarifado", 2800.00),
                "Almoxarifado");
        adicionarFuncionario(new Funcionario("Xavier Antunes", "EMP020", 29, "Masculino", "Conferente", 3000.00),
                "Almoxarifado");

        adicionarProduto(new Produto("Paracetamol 500mg (Cx c/20", 5.00, 12.50, 1000));
        adicionarProduto(new Produto("Dipirona Sódica 1g (Cx c/10)", 7.50, 18.00, 800));
        adicionarProduto(new Produto("Amoxicilina 500mg (Cx c/21)", 15.00, 35.00, 500));
        adicionarProduto(new Produto("Omeprazol 20mg (Cx c/30)", 9.00, 22.00, 700));
        adicionarProduto(new Produto("Soro Fisiológico 0.9% (500ml)", 3.00, 7.50, 1500));
        adicionarProduto(new Produto("Vitamina C 1g (Cx c/10)", 6.00, 15.00, 900));
        adicionarProduto(new Produto("Ibuprofeno 600mg (Cx c/10)", 10.00, 25.00, 600));
        adicionarProduto(new Produto("Curativo Adesivo (Cx c/50)", 2.50, 6.00, 2000));
        adicionarProduto(new Produto("Álcool 70% Líquido (1 Litro)", 4.00, 9.50, 1200));
        adicionarProduto(new Produto("Máscara Cirúrgica Descartável (Cx c/50)", 10.00, 25.00, 3000));
        adicionarProduto(new Produto("Luva de Procedimento (Cx c/100)", 15.00, 35.00, 1000));
        adicionarProduto(new Produto("Buscopan Duo (Cx c/20)", 8.50, 20.00, 750));
        adicionarProduto(new Produto("Neosaldina (Cx c/20)", 7.00, 16.50, 900));
        adicionarProduto(new Produto("Dorflex (Cx c/10)", 5.50, 13.00, 1100));
        adicionarProduto(new Produto("Losartana Potássica 50mg (Cx c/30)", 12.00, 28.00, 600));
        adicionarProduto(new Produto("Sinvastatina 20mg (Cx c/30)", 18.00, 42.00, 450));
        adicionarProduto(new Produto("Cloridrato de Fluoxetina 20mg (Cx c/30)", 20.00, 48.00, 300));
        adicionarProduto(new Produto("Cloridrato de Ranitidina 150mg (Cx c/30)", 9.50, 23.00, 650));
        adicionarProduto(new Produto("Acetilcisteína 600mg (Cx c/16)", 11.00, 26.00, 550));
        adicionarProduto(new Produto("Shampoo Anticaspa (200ml)", 8.00, 19.00, 800));
        adicionarProduto(new Produto("Condicionador Hidratante (200ml)", 7.00, 17.00, 850));
        adicionarProduto(new Produto("Sabonete Líquido Antibacteriano (250ml)", 6.00, 14.00, 1000));
        adicionarProduto(new Produto("Escova de Dente Macia", 2.00, 5.00, 1500));
        adicionarProduto(new Produto("Creme Dental Flúor (90g)", 3.50, 8.50, 1300));
        adicionarProduto(new Produto("Termômetro Digital Infravermelho", 25.00, 60.00, 200));
        adicionarProduto(new Produto("Band-aid Clássico (Cx c/10)", 2.00, 4.50, 2500));
        adicionarProduto(new Produto("Algodão Hidrófilo (50g)", 1.50, 3.50, 3000));
        adicionarProduto(new Produto("Gaze Esterilizada (Cx c/10)", 4.00, 9.00, 1800));
        adicionarProduto(new Produto("Fralda Geriátrica G (Cx c/10)", 30.00, 70.00, 250));
        adicionarProduto(new Produto("Protetor Solar FPS 30 (120ml)", 15.00, 35.00, 400));

        Transportadora t1 = new Transportadora("Transportes Veloz", 15.00);
        String[] locaist1 = { "Londrina - PR", "Cambé - PR", "Rolândia - PR", "Ibiporâ - PR" };
        for (String local : locaist1) {
            t1.addLocalAtendimento(local);
        }
        adicionarTransportadora(t1);

        Transportadora t2 = new Transportadora("Entrega Nacional LTDA", 25.00);
        String[] locaist2 = { "Curitiba - PR", "Maringá - PR", "Cascavel - PR", "Ponta Grossa - PR" };
        for (String local : locaist2) {
            t2.addLocalAtendimento(local);
        }
        adicionarTransportadora(t2);

        Transportadora t3 = new Transportadora("Logística Ágil Brasil", 35.00);
        String[] locaist3 = { "São Paulo - SP", "Ourinhos - SP", "Assis - SP", "Marilha - SP" };
        for (String local : locaist3) {
            t3.addLocalAtendimento(local);
        }
        adicionarTransportadora(t3);
    }

    public void adicionarFuncionario(Funcionario funcionario, String nomeSetor) {
        Setor setor = setores.get(nomeSetor);
        setor.addFuncionario(funcionario);

    }

    public void atualizarFuncionario(String idFuncionario, String nome, String senha, int idade, String genero,
            String setor, double salario, String cargo) {
        Funcionario funcParaAtualizar = null;
        String setorDoFuncionario = null;

        for (Map.Entry<String, Setor> entry : setores.entrySet()) {
            Setor procSetor = entry.getValue();
            funcParaAtualizar = procSetor.buscarFuncionario(idFuncionario);
            if (funcParaAtualizar != null) {
                setorDoFuncionario = entry.getKey();
                break;
            }
        }

        funcParaAtualizar.setNomeCompleto(nome);
        funcParaAtualizar.setIdade(idade);
        funcParaAtualizar.mudarSenha(senha);
        funcParaAtualizar.setGenero(genero);
        funcParaAtualizar.setSalarioBase(salario);
        funcParaAtualizar.setCargo(cargo);

        setores.get(setorDoFuncionario).removerFuncionario(idFuncionario);
        setores.get(setor).addFuncionario(funcParaAtualizar);
    }

    public void removerFuncionario(String idFuncionario) {
        for (Setor setor : setores.values()) {
            setor.removerFuncionario(idFuncionario);
            break;
        }
    }

    public double[] calcularFolhaDePagamentoDetalhada() {
        double totalSalariosLiquidos = 0;
        double totalImpostosRetidos = 0;
        double totalCustosBeneficiosEmpresa = 0;

        for (Setor setor : setores.values()) {
            for (Funcionario func : setor.getFuncionarios()) {
                func.calcularImpostoRenda();
                func.calcularSalarioLiquido();

                totalSalariosLiquidos += func.getSalarioLiquido();
                totalImpostosRetidos += func.getImpostoRenda();
                totalCustosBeneficiosEmpresa += (func.getValeTransporte() + func.getValeRefeicao() +
                        func.getValeAlimentacao() + func.getPlanoSaude() + func.getPlanoOdontologico());
            }
        }

        double custoTotal = calcularCustoMensalComPessoal();

        return new double[] {
                totalSalariosLiquidos,
                totalImpostosRetidos,
                totalCustosBeneficiosEmpresa,
                custoTotal
        };
    }

    public void registrarEntradaCaixa(double valor) {
        this.caixaTotal += valor;
    }

    public void registrarSaidaCaixa(double valor) {
        this.caixaTotal -= valor;
    }

    public void estimarLucros(double vendasProgramadasMensais) {
        double custoMensalPessoal = calcularCustoMensalComPessoal();
        double lucroMensalEstimado = vendasProgramadasMensais - custoMensalPessoal;
        double lucroAnualEstimado = lucroMensalEstimado * 12;

        System.out.println("\n--- Estimativa de Lucros ---");
        System.out.println("Vendas Programadas Mensais: R$" + String.format("%.2f", vendasProgramadasMensais));
        System.out.println("Custo Mensal Estimado com Pessoal: R$" + String.format("%.2f", custoMensalPessoal));
        System.out.println("Lucro Mensal Estimado: R$" + String.format("%.2f", lucroMensalEstimado));
        System.out.println("Lucro Anual Estimado: R$" + String.format("%.2f", lucroAnualEstimado));
    }

    private double calcularCustoMensalComPessoal() {
        double custoTotalPessoal = 0;
        for (Setor setor : setores.values()) {
            for (Funcionario func : setor.getFuncionarios()) {
                custoTotalPessoal += func.getSalarioBase() + func.getBonificacaoLucros() +
                        func.getValeTransporte() + func.getValeRefeicao() +
                        func.getValeAlimentacao() + func.getPlanoSaude() +
                        func.getPlanoOdontologico();
            }
        }
        return custoTotalPessoal;
    }

    public void adicionarProduto(Produto produto) {
        produtos.put(produto.getCodigo(), produto);
    }

    public void atualizarProduto(String nome, String codigoProduto, Double compra, Double venda) {
        for (Produto prod : produtos.values()) {
            if (prod.getCodigo().equals(codigoProduto)) {
                prod.setNome(nome);
                prod.setValorCompra(compra);
                prod.setValorVenda(venda);
                break;
            }
        }
    }

    public void removerProduto(String codigoProduto) {
        produtos.remove(codigoProduto);

    }

    public void registrarVenda(Map<Produto, Integer> mapQtd, List<String> funcionarios, String transportadora,
            String local, Double valorVenda) {

        List<Funcionario> vendedoresEnvolvidos = new ArrayList<>();
        for (String id : funcionarios) {
            Funcionario vendedor = buscarFuncionarioPorId(id);
            vendedoresEnvolvidos.add(vendedor);
        }

        for (Map.Entry<Produto, Integer> entrada : mapQtd.entrySet()) {
            entrada.getKey().setQuantidadeEstoque(entrada.getKey().getQuantidadeEstoque() - entrada.getValue());
        }

        registrarEntradaCaixa(valorVenda);
        System.out.println(getCaixaTotal());

        String idNegocio = "VENDA-" + UUID.randomUUID().toString().substring(0, 8);
        NegocioEmAndamento novaVenda = new NegocioEmAndamento(idNegocio, "Venda",
                LocalDate.now(), mapQtd);

        novaVenda.addParticipantesVenda(vendedoresEnvolvidos);

        negociosEmAndamento.add(novaVenda);

    }

    public void registrarCompra() {
        System.out.print("Digite o código do produto a ser comprado/reabastecido: ");
        String codigoProduto = scanner.nextLine();
        Produto produto = produtos.get(codigoProduto);

        if (produto == null) {
            System.out
                    .println("Produto com código " + codigoProduto + " não encontrado. Deseja cadastrá-lo? (sim/não)");
            String resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("sim")) {
                System.out.print("Nome do novo produto: ");
                String nome = scanner.nextLine();
                System.out.print("Valor de Compra: ");
                double valorCompra = scanner.nextDouble();
                System.out.print("Valor de Venda: ");
                double valorVenda = scanner.nextDouble();
                System.out.print("Quantidade inicial: ");
                int quantidadeInicial = scanner.nextInt();
                scanner.nextLine();
                produto = new Produto(nome, valorCompra, valorVenda, quantidadeInicial);
                adicionarProduto(produto);
                System.out.println("Novo produto cadastrado e estoque inicial adicionado.");
                return;
            } else {
                return;
            }
        }

        System.out.print("Digite a quantidade a ser comprada/reabastecida: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        if (quantidade <= 0) {
            System.out.println("Quantidade de compra inválida.");
            return;
        }

        List<Funcionario> almoxarifesEnvolvidos = new ArrayList<>();
        System.out.print(
                "Digite os IDs dos funcionários do almoxarifado envolvidos (separados por vírgula, ex: EMP018,EMP019): ");
        String idsAlmoxarifes = scanner.nextLine();
        String[] ids = idsAlmoxarifes.split(",");
        for (String id : ids) {
            String trimmedId = id.trim();
            Funcionario almoxarife = buscarFuncionarioPorId(trimmedId);
            if (almoxarife != null && almoxarife.getCargo().contains("Almoxarifado")
                    || almoxarife.getCargo().equals("Conferente")) {
                almoxarifesEnvolvidos.add(almoxarife);
            } else {
                System.out.println("ID de funcionário do almoxarifado inválido ou não encontrado: " + trimmedId);
            }
        }
        if (almoxarifesEnvolvidos.isEmpty()) {
            System.out.println("Nenhum funcionário do almoxarifado válido encontrado para registrar a compra.");
            return;
        }

        // double valorTotalCompra = produto.getValorCompra() * quantidade;
        // produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() + quantidade);
        // registrarSaidaCaixa(valorTotalCompra);

        // // Criar um novo negócio em andamento para a compra
        // String idNegocio = "COMPRA-" + UUID.randomUUID().toString().substring(0, 8);
        // NegocioEmAndamento novaCompra = new NegocioEmAndamento(idNegocio, "Compra",
        // LocalDate.now());
        // novaCompra.addProduto(produto, quantidade);
        // almoxarifesEnvolvidos.forEach(novaCompra::addParticipanteCompra);
        // novaCompra.setStatus("Concluído"); // Uma compra de reabastecimento pode ser
        // marcada como concluída
        // // imediatamente

        // negociosEmAndamento.add(novaCompra);
        // System.out
        // .println("Compra de " + quantidade + " unidades de " + produto.getNome() + "
        // registrada com sucesso.");
    }

    public void adicionarTransportadora(Transportadora transportadora) {
        transportadoras.add(transportadora);
    }

    public void removerTransportadora(String nome) {
        for (Transportadora transp : transportadoras) {
            if (transp.getNome().equals(nome)) {
                transportadoras.remove(transp);
                break;
            }
        }
    }

    public void atualizarTransportadora(String nomeFixo, String nome, Double frete, List<String> locais) {
        for (Transportadora transp : transportadoras) {
            if (transp.getNome().equals(nomeFixo)) {
                transp.setNome(nome);
                transp.setValorFreteFixo(frete);
                transp.setLocaisAtendimento(locais);
                break;
            }
        }
    }

    public void atualizarStatusNegocio(String idNegocio, String novoStatus) {
        for (NegocioEmAndamento negocio : negociosEmAndamento) {
            if (negocio.getIdNegocio().equals(idNegocio)) {
                negocio.setStatus(novoStatus);
                return;
            }
        }
    }

    public Funcionario buscarFuncionarioPorId(String id) {
        for (Setor setor : setores.values()) {
            Funcionario func = setor.buscarFuncionario(id);
            if (func != null) {
                return func;
            }
        }
        return null;
    }

    public Produto buscarProdutoPorCodigo(String codigo) {
        return produtos.get(codigo);
    }

    public double getCaixaTotal() {
        return caixaTotal;
    }

    public Map<String, Setor> getSetores() {
        return setores;
    }

    public Map<String, Produto> getProdutos() {
        return produtos;
    }

    public List<NegocioEmAndamento> getNegociosEmAndamento() {
        return negociosEmAndamento;
    }

    public List<Transportadora> getTransportadoras() {
        return transportadoras;
    }
}
