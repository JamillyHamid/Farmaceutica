import java.time.LocalDate;
import java.util.*;

class Empresa {
    private double caixaTotal;
    private Map<String, Setor> setores;
    private Map<String, Produto> produtos;
    private List<Transportadora> transportadoras;
    private List<NegocioEmAndamento> negociosEmAndamento;
    private Scanner scanner; // Para entrada de dados do usuário

    public Empresa() {
        this.caixaTotal = 200000.00;
        this.setores = new HashMap<>();
        this.produtos = new HashMap<>();
        this.transportadoras = new ArrayList<>();
        this.negociosEmAndamento = new ArrayList<>();
        this.scanner = new Scanner(System.in);

        // Inicializar setores
        setores.put("Gerente de Filial", new Setor("Gerente de Filial")); // 1 funcionário
        setores.put("Atendimento ao Cliente", new Setor("Atendimento ao Cliente")); // 4 funcionários
        setores.put("Gestão de Pessoas", new Setor("Gestão de Pessoas")); // 4 funcionários
        setores.put("Financeiro", new Setor("Financeiro")); // 3 funcionários
        setores.put("Vendas", new Setor("Vendas")); // 5 funcionários
        setores.put("Almoxarifado", new Setor("Almoxarifado")); // 3 funcionários
        setores.put("Transportadoras", new Setor("Transportadoras")); // 0 funcionários (este é o setor interno que gerencia as transportadoras externas)

        // Adicionar funcionários iniciais (total 20)
        // Gerente de Filial (1)
        adicionarFuncionario(new Funcionario("Ana Paula Silva", "EMP001", 45, "Feminino", "Gerente de Filial", 10000.00), "Gerente de Filial");
        // Atendimento ao Cliente (4)
        adicionarFuncionario(new Funcionario("Carlos Alberto Mendes", "EMP002", 28, "Masculino", "Atendente", 2500.00), "Atendimento ao Cliente");
        adicionarFuncionario(new Funcionario("Beatriz Costa Lima", "EMP003", 32, "Feminino", "Atendente", 2600.00), "Atendimento ao Cliente");
        adicionarFuncionario(new Funcionario("Fernando Santos", "EMP004", 25, "Masculino", "Atendente", 2400.00), "Atendimento ao Cliente");
        adicionarFuncionario(new Funcionario("Gabriela Oliveira", "EMP005", 30, "Feminino", "Atendente Sênior", 2800.00), "Atendimento ao Cliente");
        // Gestão de Pessoas (4)
        adicionarFuncionario(new Funcionario("Heloísa Dantas", "EMP006", 38, "Feminino", "Analista RH", 4000.00), "Gestão de Pessoas");
        adicionarFuncionario(new Funcionario("Igor Rodrigues", "EMP007", 35, "Masculino", "Assistente RH", 3200.00), "Gestão de Pessoas");
        adicionarFuncionario(new Funcionario("Juliana Alves", "EMP008", 40, "Feminino", "Gerente RH", 6000.00), "Gestão de Pessoas");
        adicionarFuncionario(new Funcionario("Leandro Gomes", "EMP009", 29, "Masculino", "Recrutador", 3500.00), "Gestão de Pessoas");
        // Financeiro (3)
        adicionarFuncionario(new Funcionario("Márcia Fernandes", "EMP010", 42, "Feminino", "Contador", 5500.00), "Financeiro");
        adicionarFuncionario(new Funcionario("Nelson Pereira", "EMP011", 33, "Masculino", "Analista Financeiro", 4500.00), "Financeiro");
        adicionarFuncionario(new Funcionario("Olívia Souza", "EMP012", 27, "Feminino", "Auxiliar Financeiro", 3000.00), "Financeiro");
        // Vendas (5)
        adicionarFuncionario(new Funcionario("Paulo Roberto", "EMP013", 31, "Masculino", "Vendedor", 3500.00), "Vendas");
        adicionarFuncionario(new Funcionario("Quiteria Barbosa", "EMP014", 36, "Feminino", "Vendedor Sênior", 4000.00), "Vendas");
        adicionarFuncionario(new Funcionario("Ricardo Dutra", "EMP015", 29, "Masculino", "Vendedor", 3400.00), "Vendas");
        adicionarFuncionario(new Funcionario("Sara Vieira", "EMP016", 30, "Feminino", "Vendedor", 3600.00), "Vendas");
        adicionarFuncionario(new Funcionario("Thiago Martins", "EMP017", 40, "Masculino", "Gerente de Vendas", 7000.00), "Vendas");
        // Almoxarifado (3)
        adicionarFuncionario(new Funcionario("Úrsula Costa", "EMP018", 34, "Feminino", "Encarregado Almoxarifado", 3800.00), "Almoxarifado");
        adicionarFuncionario(new Funcionario("Vitor Hugo", "EMP019", 26, "Masculino", "Assistente Almoxarifado", 2800.00), "Almoxarifado");
        adicionarFuncionario(new Funcionario("Xavier Antunes", "EMP020", 29, "Masculino", "Conferente", 3000.00), "Almoxarifado");


        // Adicionar produtos (pelo menos 10)
        adicionarProduto(new Produto("Paracetamol 500mg (Cx c/20)", "PROD001", 5.00, 12.50, 1000));
        adicionarProduto(new Produto("Dipirona Sódica 1g (Cx c/10)", "PROD002", 7.50, 18.00, 800));
        adicionarProduto(new Produto("Amoxicilina 500mg (Cx c/21)", "PROD003", 15.00, 35.00, 500));
        adicionarProduto(new Produto("Omeprazol 20mg (Cx c/30)", "PROD004", 9.00, 22.00, 700));
        adicionarProduto(new Produto("Soro Fisiológico 0.9% (500ml)", "PROD005", 3.00, 7.50, 1500));
        adicionarProduto(new Produto("Vitamina C 1g (Cx c/10)", "PROD006", 6.00, 15.00, 900));
        adicionarProduto(new Produto("Ibuprofeno 600mg (Cx c/10)", "PROD007", 10.00, 25.00, 600));
        adicionarProduto(new Produto("Curativo Adesivo (Cx c/50)", "PROD008", 2.50, 6.00, 2000));
        adicionarProduto(new Produto("Álcool 70% Líquido (1 Litro)", "PROD009", 4.00, 9.50, 1200));
        adicionarProduto(new Produto("Máscara Cirúrgica Descartável (Cx c/50)", "PROD010", 10.00, 25.00, 3000));
        adicionarProduto(new Produto("Luva de Procedimento (Cx c/100)", "PROD011", 15.00, 35.00, 1000));

        // Adicionar transportadoras (pelo menos 3)
        Transportadora t1 = new Transportadora("Transportes Veloz");
        t1.addLocalAtendimento("São Paulo - SP");
        t1.addLocalAtendimento("Rio de Janeiro - RJ");
        t1.addLocalAtendimento("Belo Horizonte - MG");
        adicionarTransportadora(t1);

        Transportadora t2 = new Transportadora("Entrega Nacional LTDA");
        t2.addLocalAtendimento("Curitiba - PR");
        t2.addLocalAtendimento("Porto Alegre - RS");
        t2.addLocalAtendimento("Florianópolis - SC");
        adicionarTransportadora(t2);

        Transportadora t3 = new Transportadora("Logística Ágil Brasil");
        t3.addLocalAtendimento("Recife - PE");
        t3.addLocalAtendimento("Salvador - BA");
        t3.addLocalAtendimento("Fortaleza - CE");
        adicionarTransportadora(t3);
    }

    // --- Métodos de Gerenciamento ---

    // Gerenciamento de Funcionários
    public void adicionarFuncionario(Funcionario funcionario, String nomeSetor) {
        Setor setor = setores.get(nomeSetor);
        if (setor != null) {
            setor.addFuncionario(funcionario);
            System.out.println("Funcionário " + funcionario.getNomeCompleto() + " (ID: " + funcionario.getId() + ") adicionado ao setor " + nomeSetor + ".");
        } else {
            System.out.println("Erro: Setor '" + nomeSetor + "' não encontrado.");
        }
    }

    public void atualizarFuncionario(String idFuncionario) {
        Funcionario funcParaAtualizar = null;
        String setorDoFuncionario = null;

        // Procura o funcionário em todos os setores
        for (Map.Entry<String, Setor> entry : setores.entrySet()) {
            Setor setor = entry.getValue();
            funcParaAtualizar = setor.buscarFuncionario(idFuncionario);
            if (funcParaAtualizar != null) {
                setorDoFuncionario = entry.getKey();
                break;
            }
        }

        if (funcParaAtualizar != null) {
            System.out.println("\n--- Atualizar Dados do Funcionário: " + funcParaAtualizar.getNomeCompleto() + " ---");
            System.out.println("1. Nome Completo (Atual: " + funcParaAtualizar.getNomeCompleto() + ")");
            System.out.println("2. Idade (Atual: " + funcParaAtualizar.getIdade() + ")");
            System.out.println("3. Gênero (Atual: " + funcParaAtualizar.getGenero() + ")");
            System.out.println("4. Cargo (Atual: " + funcParaAtualizar.getCargo() + ")");
            System.out.println("5. Salário Base (Atual: R$" + String.format("%.2f", funcParaAtualizar.getSalarioBase()) + ")");
            System.out.println("6. Bonificação por Lucros (Atual: R$" + String.format("%.2f", funcParaAtualizar.getBonificacaoLucros()) + ")");
            System.out.println("7. Mudar Setor (Atual: " + setorDoFuncionario + ")");
            System.out.println("0. Cancelar");

            System.out.print("Escolha uma opção para atualizar: ");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (escolha) {
                case 1:
                    System.out.print("Novo Nome Completo: ");
                    funcParaAtualizar.setNomeCompleto(scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Nova Idade: ");
                    funcParaAtualizar.setIdade(scanner.nextInt());
                    scanner.nextLine();
                    break;
                case 3:
                    System.out.print("Novo Gênero: ");
                    funcParaAtualizar.setGenero(scanner.nextLine());
                    break;
                case 4:
                    System.out.print("Novo Cargo: ");
                    funcParaAtualizar.setCargo(scanner.nextLine());
                    break;
                case 5:
                    System.out.print("Novo Salário Base: ");
                    funcParaAtualizar.setSalarioBase(scanner.nextDouble());
                    scanner.nextLine();
                    break;
                case 6:
                    System.out.print("Nova Bonificação por Lucros: ");
                    funcParaAtualizar.setBonificacaoLucros(scanner.nextDouble());
                    scanner.nextLine();
                    break;
                case 7:
                    System.out.print("Novo Setor (Gerente de Filial, Atendimento ao Cliente, Gestão de Pessoas, Financeiro, Vendas, Almoxarifado, Transportadoras): ");
                    String novoSetorNome = scanner.nextLine();
                    if (setores.containsKey(novoSetorNome)) {
                        // Remove do setor antigo
                        setores.get(setorDoFuncionario).removerFuncionario(idFuncionario);
                        // Adiciona ao novo setor
                        setores.get(novoSetorNome).addFuncionario(funcParaAtualizar);
                        System.out.println("Funcionário movido para o setor: " + novoSetorNome);
                    } else {
                        System.out.println("Setor inválido. Funcionário permaneceu no setor atual.");
                    }
                    break;
                case 0:
                    System.out.println("Atualização cancelada.");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
            System.out.println("Dados do funcionário atualizados com sucesso!");
            funcParaAtualizar.calcularImpostoRenda(); // Recalcula após atualizações
            funcParaAtualizar.calcularSalarioLiquido(); // Recalcula após atualizações

        } else {
            System.out.println("Funcionário com ID " + idFuncionario + " não encontrado.");
        }
    }


    public void removerFuncionario(String idFuncionario) {
        boolean removido = false;
        for (Setor setor : setores.values()) {
            Funcionario func = setor.buscarFuncionario(idFuncionario);
            if (func != null) {
                setor.removerFuncionario(idFuncionario);
                removido = true;
                System.out.println("Funcionário com ID " + idFuncionario + " removido com sucesso.");
                break;
            }
        }
        if (!removido) {
            System.out.println("Funcionário com ID " + idFuncionario + " não encontrado.");
        }
    }

    public void listarFuncionariosPorSetor(String nomeSetor) {
        Setor setor = setores.get(nomeSetor);
        if (setor != null) {
            System.out.println("\n--- Funcionários do Setor: " + nomeSetor + " (" + setor.getQuantidadeFuncionarios() + ") ---");
            setor.listarFuncionarios();
        } else {
            System.out.println("Setor '" + nomeSetor + "' não encontrado.");
        }
    }

    public void listarTodosFuncionarios() {
        System.out.println("\n--- Lista de Todos os Funcionários por Setor ---");
        setores.forEach((nomeSetor, setor) -> {
            System.out.println("\nSetor: " + nomeSetor + " (Total: " + setor.getQuantidadeFuncionarios() + ")");
            if (setor.getQuantidadeFuncionarios() > 0) {
                setor.getFuncionarios().forEach(System.out::println);
            } else {
                System.out.println("  Nenhum funcionário neste setor.");
            }
        });
    }

    public void calcularFolhaDePagamento() {
        double totalSalariosLiquidos = 0;
        double totalImpostosRetidos = 0;
        double totalCustosBeneficiosEmpresa = 0; // Custos da empresa com benefícios

        System.out.println("\n--- Detalhamento da Folha de Pagamento ---");
        for (Setor setor : setores.values()) {
            System.out.println("\nSetor: " + setor.getNomeSetor());
            if (setor.getFuncionarios().isEmpty()) {
                System.out.println("  Nenhum funcionário.");
                continue;
            }
            for (Funcionario func : setor.getFuncionarios()) {
                func.calcularImpostoRenda();
                func.calcularSalarioLiquido();

                System.out.println("  - " + func.getNomeCompleto() + " (ID: " + func.getId() + ", Cargo: " + func.getCargo() + ")");
                System.out.println("    Salário Base: R$" + String.format("%.2f", func.getSalarioBase()));
                System.out.println("    Bonificação: R$" + String.format("%.2f", func.getBonificacaoLucros()));
                System.out.println("    IR Retido: R$" + String.format("%.2f", func.getImpostoRenda()));
                System.out.println("    Salário Líquido: R$" + String.format("%.2f", func.getSalarioLiquido()));
                System.out.println("    Custo Benefícios Empresa:");
                System.out.println("      VT: R$" + String.format("%.2f", func.getValeTransporte()));
                System.out.println("      VR: R$" + String.format("%.2f", func.getValeRefeicao()));
                System.out.println("      VA: R$" + String.format("%.2f", func.getValeAlimentacao()));
                System.out.println("      Plano Saúde: R$" + String.format("%.2f", func.getPlanoSaude()));
                System.out.println("      Plano Odontológico: R$" + String.format("%.2f", func.getPlanoOdontologico()));

                totalSalariosLiquidos += func.getSalarioLiquido();
                totalImpostosRetidos += func.getImpostoRenda();
                totalCustosBeneficiosEmpresa += (func.getValeTransporte() + func.getValeRefeicao() +
                        func.getValeAlimentacao() + func.getPlanoSaude() + func.getPlanoOdontologico());
            }
        }
        System.out.println("\n--- Resumo da Folha de Pagamento ---");
        System.out.println("Total de Salários Líquidos Pagos: R$" + String.format("%.2f", totalSalariosLiquidos));
        System.out.println("Total de Impostos de Renda Retidos: R$" + String.format("%.2f", totalImpostosRetidos));
        System.out.println("Total de Custos com Benefícios (Empresa): R$" + String.format("%.2f", totalCustosBeneficiosEmpresa));
        System.out.println("Custo Total Estimado com Pessoal (Salário Base + Benefícios + Bonificação): R$" + String.format("%.2f", calcularCustoMensalComPessoal()));
    }


    // Gerenciamento Financeiro
    public void registrarEntradaCaixa(double valor, String descricao) {
        if (valor > 0) {
            this.caixaTotal += valor;
            System.out.println("Entrada de caixa registrada: R$" + String.format("%.2f", valor) + " - " + descricao + ". Novo caixa total: R$" + String.format("%.2f", caixaTotal));
        } else {
            System.out.println("Erro: Valor da entrada deve ser positivo.");
        }
    }

    public void registrarSaidaCaixa(double valor, String descricao) {
        if (valor > 0) {
            if (this.caixaTotal >= valor) {
                this.caixaTotal -= valor;
                System.out.println("Saída de caixa registrada: R$" + String.format("%.2f", valor) + " - " + descricao + ". Novo caixa total: R$" + String.format("%.2f", caixaTotal));
            } else {
                System.out.println("Erro: Saldo de caixa insuficiente para a saída de R$" + String.format("%.2f", valor) + " - " + descricao);
            }
        } else {
            System.out.println("Erro: Valor da saída deve ser positivo.");
        }
    }

    public double getCaixaTotal() {
        return caixaTotal;
    }

    public void estimarLucros(double vendasProgramadasMensais) {
        // Para uma estimativa mais precisa, precisaríamos de mais detalhes sobre custos fixos e variáveis
        // além do custo com pessoal.

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
                // Custo para a empresa inclui Salário Base + Bonificação + todos os benefícios (VT, VR, VA, PS, PO)
                // O IR é uma retenção do salário do funcionário, não um custo adicional para a empresa (neste contexto simplificado)
                custoTotalPessoal += func.getSalarioBase() + func.getBonificacaoLucros() +
                        func.getValeTransporte() + func.getValeRefeicao() +
                        func.getValeAlimentacao() + func.getPlanoSaude() +
                        func.getPlanoOdontologico();
            }
        }
        return custoTotalPessoal;
    }

    // Gerenciamento de Estoque/Produtos
    public void adicionarProduto(Produto produto) {
        if (!produtos.containsKey(produto.getCodigo())) {
            produtos.put(produto.getCodigo(), produto);
            System.out.println("Produto '" + produto.getNome() + "' (Cód: " + produto.getCodigo() + ") adicionado ao catálogo.");
        } else {
            System.out.println("Erro: Produto com código '" + produto.getCodigo() + "' já existe.");
        }
    }

    public void atualizarProduto(String codigoProduto) {
        Produto produto = produtos.get(codigoProduto);
        if (produto != null) {
            System.out.println("\n--- Atualizar Dados do Produto: " + produto.getNome() + " ---");
            System.out.println("1. Nome (Atual: " + produto.getNome() + ")");
            System.out.println("2. Valor de Compra (Atual: R$" + String.format("%.2f", produto.getValorCompra()) + ")");
            System.out.println("3. Valor de Venda (Atual: R$" + String.format("%.2f", produto.getValorVenda()) + ")");
            System.out.println("4. Quantidade em Estoque (Atual: " + produto.getQuantidadeEstoque() + ")");
            System.out.println("0. Cancelar");

            System.out.print("Escolha uma opção para atualizar: ");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    System.out.print("Novo Nome: ");
                    produto.setNome(scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Novo Valor de Compra: ");
                    produto.setValorCompra(scanner.nextDouble());
                    scanner.nextLine();
                    break;
                case 3:
                    System.out.print("Novo Valor de Venda: ");
                    produto.setValorVenda(scanner.nextDouble());
                    scanner.nextLine();
                    break;
                case 4:
                    System.out.print("Nova Quantidade em Estoque: ");
                    produto.setQuantidadeEstoque(scanner.nextInt());
                    scanner.nextLine();
                    break;
                case 0:
                    System.out.println("Atualização cancelada.");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
            System.out.println("Dados do produto atualizados com sucesso!");
        } else {
            System.out.println("Produto com código " + codigoProduto + " não encontrado.");
        }
    }


    public void removerProduto(String codigoProduto) {
        if (produtos.remove(codigoProduto) != null) {
            System.out.println("Produto com código " + codigoProduto + " removido do catálogo.");
        } else {
            System.out.println("Produto com código " + codigoProduto + " não encontrado.");
        }
    }

    public void listarProdutosEmEstoque() {
        System.out.println("\n--- Produtos em Estoque ---");
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado no estoque.");
            return;
        }
        produtos.values().forEach(System.out::println);
    }

    public void registrarVenda() {
        System.out.print("Digite o código do produto a ser vendido: ");
        String codigoProduto = scanner.nextLine();
        Produto produto = produtos.get(codigoProduto);

        if (produto == null) {
            System.out.println("Produto com código " + codigoProduto + " não encontrado.");
            return;
        }

        System.out.print("Digite a quantidade a ser vendida: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        if (quantidade <= 0) {
            System.out.println("Quantidade de venda inválida.");
            return;
        }

        if (produto.getQuantidadeEstoque() < quantidade) {
            System.out.println("Estoque insuficiente. Disponível: " + produto.getQuantidadeEstoque() + " unidades.");
            return;
        }

        List<Funcionario> vendedoresEnvolvidos = new ArrayList<>();
        System.out.print("Digite os IDs dos vendedores envolvidos (separados por vírgula, ex: EMP013,EMP014): ");
        String idsVendedores = scanner.nextLine();
        String[] ids = idsVendedores.split(",");
        for (String id : ids) {
            String trimmedId = id.trim();
            Funcionario vendedor = buscarFuncionarioPorId(trimmedId);
            if (vendedor != null && vendedor.getCargo().equals("Vendedor") || vendedor.getCargo().equals("Gerente de Vendas")) { // Confere se é vendedor
                vendedoresEnvolvidos.add(vendedor);
            } else {
                System.out.println("ID de vendedor inválido ou não encontrado: " + trimmedId);
            }
        }
        if (vendedoresEnvolvidos.isEmpty()) {
            System.out.println("Nenhum vendedor válido encontrado para registrar a venda.");
            return;
        }

        double valorTotalVenda = produto.getValorVenda() * quantidade;
        produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - quantidade);
        registrarEntradaCaixa(valorTotalVenda, "Venda de " + quantidade + " unidades de " + produto.getNome());

        // Criar um novo negócio em andamento para a venda
        String idNegocio = "VENDA-" + UUID.randomUUID().toString().substring(0, 8); // ID único
        NegocioEmAndamento novaVenda = new NegocioEmAndamento(idNegocio, "Venda", LocalDate.now());
        novaVenda.addProduto(produto, quantidade);
        vendedoresEnvolvidos.forEach(novaVenda::addParticipanteVenda);
        novaVenda.setStatus("Concluído"); // Uma venda direta pode ser marcada como concluída imediatamente

        negociosEmAndamento.add(novaVenda);
        System.out.println("Venda de " + quantidade + " unidades de " + produto.getNome() + " registrada com sucesso.");
    }

    public void registrarCompra() {
        System.out.print("Digite o código do produto a ser comprado/reabastecido: ");
        String codigoProduto = scanner.nextLine();
        Produto produto = produtos.get(codigoProduto);

        if (produto == null) {
            System.out.println("Produto com código " + codigoProduto + " não encontrado. Deseja cadastrá-lo? (sim/não)");
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
                scanner.nextLine(); // Consumir nova linha
                produto = new Produto(nome, codigoProduto, valorCompra, valorVenda, quantidadeInicial);
                adicionarProduto(produto);
                System.out.println("Novo produto cadastrado e estoque inicial adicionado.");
                return; // Compra inicial já foi a adição ao estoque
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
        System.out.print("Digite os IDs dos funcionários do almoxarifado envolvidos (separados por vírgula, ex: EMP018,EMP019): ");
        String idsAlmoxarifes = scanner.nextLine();
        String[] ids = idsAlmoxarifes.split(",");
        for (String id : ids) {
            String trimmedId = id.trim();
            Funcionario almoxarife = buscarFuncionarioPorId(trimmedId);
            if (almoxarife != null && almoxarife.getCargo().contains("Almoxarifado") || almoxarife.getCargo().equals("Conferente")) { // Confere se é do almoxarifado
                almoxarifesEnvolvidos.add(almoxarife);
            } else {
                System.out.println("ID de funcionário do almoxarifado inválido ou não encontrado: " + trimmedId);
            }
        }
        if (almoxarifesEnvolvidos.isEmpty()) {
            System.out.println("Nenhum funcionário do almoxarifado válido encontrado para registrar a compra.");
            return;
        }

        double valorTotalCompra = produto.getValorCompra() * quantidade;
        produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() + quantidade);
        registrarSaidaCaixa(valorTotalCompra, "Compra de " + quantidade + " unidades de " + produto.getNome());

        // Criar um novo negócio em andamento para a compra
        String idNegocio = "COMPRA-" + UUID.randomUUID().toString().substring(0, 8);
        NegocioEmAndamento novaCompra = new NegocioEmAndamento(idNegocio, "Compra", LocalDate.now());
        novaCompra.addProduto(produto, quantidade);
        almoxarifesEnvolvidos.forEach(novaCompra::addParticipanteCompra);
        novaCompra.setStatus("Concluído"); // Uma compra de reabastecimento pode ser marcada como concluída imediatamente

        negociosEmAndamento.add(novaCompra);
        System.out.println("Compra de " + quantidade + " unidades de " + produto.getNome() + " registrada com sucesso.");
    }


    // Gerenciamento de Transportadoras
    public void adicionarTransportadora(Transportadora transportadora) {
        this.transportadoras.add(transportadora);
        System.out.println("Transportadora '" + transportadora.getNome() + "' adicionada.");
    }

    public void listarTransportadoras() {
        System.out.println("\n--- Transportadoras Parceiras ---");
        if (transportadoras.isEmpty()) {
            System.out.println("Nenhuma transportadora cadastrada.");
            return;
        }
        transportadoras.forEach(System.out::println);
    }

    // Gerenciamento de Negócios em Andamento
    public void listarNegociosEmAndamento() {
        System.out.println("\n--- Negócios em Andamento ---");
        if (negociosEmAndamento.isEmpty()) {
            System.out.println("Nenhum negócio em andamento.");
            return;
        }
        negociosEmAndamento.forEach(System.out::println);
    }

    public void atualizarStatusNegocio(String idNegocio, String novoStatus) {
        for (NegocioEmAndamento negocio : negociosEmAndamento) {
            if (negocio.getIdNegocio().equals(idNegocio)) {
                negocio.setStatus(novoStatus);
                System.out.println("Status do negócio " + idNegocio + " atualizado para: " + novoStatus);
                return;
            }
        }
        System.out.println("Negócio com ID " + idNegocio + " não encontrado.");
    }

    // Métodos Auxiliares
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

    // --- Menu e Interação com o Usuário ---
    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n========== MENU PRINCIPAL ==========");
            System.out.println("1. Gerenciar Funcionários");
            System.out.println("2. Gerenciar Produtos/Estoque");
            System.out.println("3. Gerenciar Transportadoras");
            System.out.println("4. Gerenciar Fluxo de Caixa");
            System.out.println("5. Gerenciar Negócios em Andamento");
            System.out.println("6. Relatórios");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    menuFuncionarios();
                    break;
                case 2:
                    menuProdutosEstoque();
                    break;
                case 3:
                    menuTransportadoras();
                    break;
                case 4:
                    menuFluxoCaixa();
                    break;
                case 5:
                    menuNegociosEmAndamento();
                    break;
                case 6:
                    menuRelatorios();
                    break;
                case 0:
                    System.out.println("Saindo do sistema. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void menuFuncionarios() {
        int opcao;
        do {
            System.out.println("\n--- Gerenciar Funcionários ---");
            System.out.println("1. Adicionar Funcionário");
            System.out.println("2. Atualizar Dados do Funcionário");
            System.out.println("3. Remover Funcionário");
            System.out.println("4. Listar Funcionários por Setor");
            System.out.println("5. Listar Todos os Funcionários");
            System.out.println("6. Calcular Folha de Pagamento");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome Completo: ");
                    String nome = scanner.nextLine();
                    System.out.print("ID (ex: EMP021): ");
                    String id = scanner.nextLine();
                    System.out.print("Idade: ");
                    int idade = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Gênero: ");
                    String genero = scanner.nextLine();
                    System.out.print("Cargo: ");
                    String cargo = scanner.nextLine();
                    System.out.print("Salário Base: ");
                    double salario = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Setor (Gerente de Filial, Atendimento ao Cliente, Gestão de Pessoas, Financeiro, Vendas, Almoxarifado, Transportadoras): ");
                    String setorNome = scanner.nextLine();
                    adicionarFuncionario(new Funcionario(nome, id, idade, genero, cargo, salario), setorNome);
                    break;
                case 2:
                    System.out.print("Digite o ID do funcionário para atualizar: ");
                    String idAtualizar = scanner.nextLine();
                    atualizarFuncionario(idAtualizar);
                    break;
                case 3:
                    System.out.print("Digite o ID do funcionário para remover: ");
                    String idRemover = scanner.nextLine();
                    removerFuncionario(idRemover);
                    break;
                case 4:
                    System.out.print("Digite o nome do setor para listar funcionários: ");
                    String setorListar = scanner.nextLine();
                    listarFuncionariosPorSetor(setorListar);
                    break;
                case 5:
                    listarTodosFuncionarios();
                    break;
                case 6:
                    calcularFolhaDePagamento();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private void menuProdutosEstoque() {
        int opcao;
        do {
            System.out.println("\n--- Gerenciar Produtos/Estoque ---");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Atualizar Produto");
            System.out.println("3. Remover Produto");
            System.out.println("4. Listar Produtos em Estoque");
            System.out.println("5. Registrar Venda");
            System.out.println("6. Registrar Compra/Reabastecimento");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do Produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Código do Produto: ");
                    String codigo = scanner.nextLine();
                    System.out.print("Valor de Compra: ");
                    double vCompra = scanner.nextDouble();
                    System.out.print("Valor de Venda: ");
                    double vVenda = scanner.nextDouble();
                    System.out.print("Quantidade Inicial em Estoque: ");
                    int qtd = scanner.nextInt();
                    scanner.nextLine();
                    adicionarProduto(new Produto(nome, codigo, vCompra, vVenda, qtd));
                    break;
                case 2:
                    System.out.print("Digite o código do produto para atualizar: ");
                    String codAtualizar = scanner.nextLine();
                    atualizarProduto(codAtualizar);
                    break;
                case 3:
                    System.out.print("Digite o código do produto para remover: ");
                    String codRemover = scanner.nextLine();
                    removerProduto(codRemover);
                    break;
                case 4:
                    listarProdutosEmEstoque();
                    break;
                case 5:
                    registrarVenda();
                    break;
                case 6:
                    registrarCompra();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private void menuTransportadoras() {
        int opcao;
        do {
            System.out.println("\n--- Gerenciar Transportadoras ---");
            System.out.println("1. Adicionar Transportadora");
            System.out.println("2. Listar Transportadoras Parceiras");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome da Transportadora: ");
                    String nomeTransp = scanner.nextLine();
                    Transportadora novaTransp = new Transportadora(nomeTransp);
                    System.out.print("Adicionar locais de atendimento (separados por vírgula): ");
                    String locais = scanner.nextLine();
                    String[] arrayLocais = locais.split(",");
                    for (String local : arrayLocais) {
                        novaTransp.addLocalAtendimento(local.trim());
                    }
                    adicionarTransportadora(novaTransp);
                    break;
                case 2:
                    listarTransportadoras();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private void menuFluxoCaixa() {
        int opcao;
        do {
            System.out.println("\n--- Gerenciar Fluxo de Caixa ---");
            System.out.println("1. Registrar Entrada de Caixa");
            System.out.println("2. Registrar Saída de Caixa");
            System.out.println("3. Ver Caixa Total");
            System.out.println("4. Estimar Lucros Anuais");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Valor da Entrada: ");
                    double valorEntrada = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Descrição da Entrada: ");
                    String descEntrada = scanner.nextLine();
                    registrarEntradaCaixa(valorEntrada, descEntrada);
                    break;
                case 2:
                    System.out.print("Valor da Saída: ");
                    double valorSaida = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Descrição da Saída: ");
                    String descSaida = scanner.nextLine();
                    registrarSaidaCaixa(valorSaida, descSaida);
                    break;
                case 3:
                    System.out.println("Caixa Total Atual: R$" + String.format("%.2f", getCaixaTotal()));
                    break;
                case 4:
                    System.out.print("Digite o valor das vendas programadas mensais para estimativa de lucros: R$");
                    double vendasProj = scanner.nextDouble();
                    scanner.nextLine();
                    estimarLucros(vendasProj);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private void menuNegociosEmAndamento() {
        int opcao;
        do {
            System.out.println("\n--- Gerenciar Negócios em Andamento ---");
            System.out.println("1. Listar Negócios em Andamento");
            System.out.println("2. Atualizar Status de Negócio");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    listarNegociosEmAndamento();
                    break;
                case 2:
                    System.out.print("Digite o ID do negócio para atualizar o status: ");
                    String idNegocio = scanner.nextLine();
                    System.out.print("Digite o novo status (Ex: Concluído, Cancelado, Em negociação): ");
                    String novoStatus = scanner.nextLine();
                    atualizarStatusNegocio(idNegocio, novoStatus);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private void menuRelatorios() {
        int opcao;
        do {
            System.out.println("\n--- Relatórios ---");
            System.out.println("1. Relatório Financeiro (Caixa)");
            System.out.println("2. Relatório de Estoque");
            System.out.println("3. Relatório de Funcionários");
            System.out.println("4. Folha de Pagamento Detalhada");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\n--- Relatório Financeiro ---");
                    System.out.println("Caixa Total Atual: R$" + String.format("%.2f", getCaixaTotal()));
                    // Aqui poderíamos adicionar histórico de entradas e saídas
                    break;
                case 2:
                    listarProdutosEmEstoque();
                    break;
                case 3:
                    listarTodosFuncionarios();
                    break;
                case 4:
                    calcularFolhaDePagamento();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
}

