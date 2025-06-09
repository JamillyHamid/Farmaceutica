package views;

import javax.swing.*;
import java.awt.*;

public class MenuGDF {

    // Acesso geral

    // "1. Gerenciar Funcionários");
    // 1. Adicionar Funcionário
    // 2. Atualizar Dados do Funcionário
    // 3. Remover Funcionário
    // 4. Listar Funcionários por Setor
    // 5. Listar Todos os Funcionários
    // 6. Calcular Folha de Pagamento

    // "2. Gerenciar Produtos/Estoque");
    // 1. Adicionar Produto
    // 2. Atualizar Produto
    // 3. Remover Produto
    // 4. Listar Produtos em Estoque
    // 5. Registrar Venda
    // 6. Registrar Compra/Reabastecimento

    // "3. Gerenciar Transportadoras");
    // 1. Adicionar Transportadora
    // 2. Listar Transportadoras Parceiras

    // "4. Gerenciar Fluxo de Caixa");
    // 1. Registrar Entrada de Caixa
    // 2. Registrar Saída de Caixa
    // 3. Ver Caixa Total
    // 4. Estimar Lucros Anuais

    // "5. Gerenciar Negócios em Andamento");
    // 1. Listar Negócios em Andamento
    // 2. Atualizar Status de Negócio

    // "6. Relatórios");
    // 1. Relatório Financeiro (Caixa)
    // 2. Relatório de Estoque
    // 3. Relatório de Funcionários
    // 4. Folha de Pagamento Detalhada

    public MenuGDF() {
        JFrame frame = new JFrame("Sistema Farmacêutico");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label = new JLabel("MENU GERAL");
        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setBounds(300, 30, 200, 20);
        panel.add(label);

        int larguraBotao = 250;
        int alturaBotao = 30;
        int margemLateral = 225;

        JButton botao1 = new JButton("Gerenciar Funcionários");
        botao1.setBounds(margemLateral, 85, larguraBotao, alturaBotao);
        panel.add(botao1);

        JButton botao2 = new JButton("Gerenciar Produtos/Estoque");
        botao2.setBounds(margemLateral, 145, larguraBotao, alturaBotao);
        panel.add(botao2);

        JButton botao3 = new JButton("Gerenciar Transportadoras");
        botao3.setBounds(margemLateral, 205, larguraBotao, alturaBotao);
        panel.add(botao3);

        JButton botao4 = new JButton("Gerenciar Fluxo de Caixa");
        botao4.setBounds(margemLateral, 265, larguraBotao, alturaBotao);
        panel.add(botao4);

        JButton botao5 = new JButton("Gerenciar Negócios em Andamento");
        botao5.setBounds(margemLateral, 325, larguraBotao, alturaBotao);
        panel.add(botao5);

        JButton botao6 = new JButton("Relatórios");
        botao6.setBounds(margemLateral, 385, larguraBotao, alturaBotao);
        panel.add(botao6);

        botao1.addActionListener(e -> {
            new MenuAMX();
            frame.dispose();
        });
        botao2.addActionListener(e -> {
        
        });
        botao3.addActionListener(e -> {
        
        });
        botao4.addActionListener(e -> {
        
        });
        botao5.addActionListener(e -> {
        
        });
        botao6.addActionListener(e -> {
        
        });

        frame.add(panel);
        frame.setVisible(true);
    }

}