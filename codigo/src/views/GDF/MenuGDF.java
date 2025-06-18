package views.GDF;

import javax.swing.*;

import sistema.Empresa;
import views.Login;
import views.MenuCaixa;
import views.MenuEstoque;
import views.MenuFuncionarios;
import views.MenuNegocio;
import views.MenuTransportadora;

import java.awt.*;

public class MenuGDF {

    // Acesso geral

    // "1. Gerenciar Funcionários");
    // XXXXX 1. Adicionar Funcionário
    // XXXXX 2. Atualizar Dados do Funcionário
    // XXXXX 3. Remover Funcionário
    // XXXXX 4. Listar Funcionários por Setor
    // XXXXX 5. Listar Todos os Funcionários

    // "2. Gerenciar Estoque");
    // 1. Adicionar Produto
    // XXXXX 2. Atualizar Produto
    // XXXXX 3. Remover Produto
    // XXXXX 4. Listar Produtos em Estoque
    // 5. Registrar Venda
    // 6. Registrar Compra/Reabastecimento

    // "3. Gerenciar Transportadoras");
    // XXXXX 1. Adicionar Transportadora
    // XXXXX 2. Listar Transportadoras Parceiras
    // XXXXX 2. Atualizar Transportadoras
    // XXXXX 3. Remover Transportadoras

    // "4. Gerenciar Fluxo de Caixa");
    // 3. Ver Caixa Total
    // 4. Estimar Lucros Anuais
    // XXXXX 6. Calcular Folha de Pagamento

    // "5. Gerenciar Negócios em Andamento");
    // 1. Listar Negócios em Andamento
    // 2. Atualizar Status de Negócio

    public MenuGDF(Empresa empresa, String setorLogin) {
        JFrame frame = new JFrame("Sistema Farmacêutico");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JButton botaoLogout = new JButton();
        botaoLogout.setBounds(20, 20, 20, 20);
        panel.add(botaoLogout);

        botaoLogout.addActionListener(e -> {
            new Login(empresa);
            frame.dispose();
        });

        JLabel label = new JLabel("MENU GERAL");
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setBounds(100, 30, 500, 20);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label);

        JLabel subtitle = new JLabel(setorLogin);
        subtitle.setFont(new Font("Arial", Font.BOLD, 10));
        subtitle.setBounds(100, 45, 500, 20);
        subtitle.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(subtitle);

        int larguraBotao = 250;
        int alturaBotao = 30;
        int margemLateral = 225;

        JButton botao1 = new JButton("Gerenciar Funcionários");
        botao1.setBounds(margemLateral, 85, larguraBotao, alturaBotao);
        panel.add(botao1);

        JButton botao2 = new JButton("Gerenciar Estoque");
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

        botao1.addActionListener(e -> {
            new MenuFuncionarios(empresa, setorLogin);
            frame.dispose();
        });
        botao2.addActionListener(e -> {
            new MenuEstoque(empresa, setorLogin);
            frame.dispose();
        });
        botao3.addActionListener(e -> {
            new MenuTransportadora(empresa, setorLogin);
            frame.dispose();
        });
        botao4.addActionListener(e -> {
            new MenuCaixa(empresa, setorLogin);
            frame.dispose();
        });
        botao5.addActionListener(e -> {
            new MenuNegocio(empresa, setorLogin);
            frame.dispose();
        });

        frame.add(panel);
        frame.setVisible(true);
    }

}