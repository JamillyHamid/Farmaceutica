package views;

import views.AMX.MenuAMX;
import views.GDF.MenuGDF;
import views.funcs.Produto.AdicionarProduto;
import views.funcs.Produto.AtualizarProduto;
import views.funcs.Produto.ListarTodosProdutos;
import views.funcs.Produto.RemoverProduto;
import views.funcs.Registrar.RegistrarCompra;
import views.funcs.Registrar.RegistrarVenda;

import javax.swing.*;

import sistema.Empresa;

import java.awt.*;

public class MenuEstoque {

    // 1. Gerenciar Estoque");
    // 1. Adicionar Produto
    // 2. Atualizar Produto
    // 3. Remover Produto
    // 4. Listar Produtos em Estoque
    // 5. Registrar Compra/Reabastecimento

    // 1. Adicionar Produto
    // XXXXX 2. Atualizar Produto
    // XXXXX 3. Remover Produto
    // XXXXX 4. Listar Produtos em Estoque
    // 5. Registrar Venda
    // 6. Registrar Compra/Reabastecimento

    public MenuEstoque(Empresa empresa, String setorLogin) {

        JFrame frame = new JFrame("Sistema Farmacêutico");

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label = new JLabel("MENU ESTOQUE");
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

        JButton botao1 = new JButton("Adicionar Produto");
        botao1.setBounds(margemLateral, 85, larguraBotao, alturaBotao);
        panel.add(botao1);

        JButton botao2 = new JButton("Editar Produto");
        botao2.setBounds(margemLateral, 145, larguraBotao, alturaBotao);
        panel.add(botao2);

        JButton botao3 = new JButton("Listar Produtos em Estoque");
        botao3.setBounds(margemLateral, 205, larguraBotao, alturaBotao);
        panel.add(botao3);

        JButton botao4 = new JButton("Registrar Compra");
        botao4.setBounds(margemLateral, 265, larguraBotao, alturaBotao);
        panel.add(botao4);

        JButton botao5 = new JButton("Remover Produto");
        botao5.setBounds(margemLateral, 325, larguraBotao, alturaBotao);
        panel.add(botao5);

        JButton botao6 = new JButton("Registrar venda");
        if (setorLogin.equals("GERENTE")) {
            botao6.setBounds(margemLateral, 385, larguraBotao, alturaBotao);
            panel.add(botao6);
        }

        JButton botaoVoltar = new JButton("VOLTAR");
        botaoVoltar.setBounds(50, 400, 100, 30);
        panel.add(botaoVoltar);

        botao1.addActionListener(e -> {
            new AdicionarProduto(empresa, setorLogin);
            frame.dispose();
        });
        botao2.addActionListener(e -> {
            new AtualizarProduto(empresa, setorLogin);
            frame.dispose();
        });
        botao3.addActionListener(e -> {
            new ListarTodosProdutos(empresa, setorLogin);
            frame.dispose();
        });
        botao4.addActionListener(e -> {
            new RegistrarCompra(empresa, setorLogin);
            frame.dispose();
        });
        botao5.addActionListener(e -> {
            new RemoverProduto(empresa, setorLogin);
            frame.dispose();
        });
        botao6.addActionListener(e -> {
            new RegistrarVenda(empresa, setorLogin);
            frame.dispose();
        });
        botaoVoltar.addActionListener(e -> {
            switch (setorLogin) {
                case "GERENTE":
                    new MenuGDF(empresa, setorLogin);
                    break;
                case "ALMOXARIFADO":
                    new MenuAMX(empresa, setorLogin);
                    break;
            }
            frame.dispose();
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}