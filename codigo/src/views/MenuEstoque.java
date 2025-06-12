package views;

import views.funcs.AdicionarProduto;
import views.funcs.AtualizarProduto;
import views.funcs.ListarTodosProdutos;
import views.funcs.RemoverProduto;

import javax.swing.*;

import sistema.Empresa;

import java.awt.*;

public class MenuEstoque {

    // "1. Gerenciar Estoque");
    // 1. Adicionar Produto
    // 2. Atualizar Produto
    // 3. Remover Produto
    // 4. Listar Produtos em Estoque
    // 5. Registrar Compra/Reabastecimento

    // 1. Listar Transportadoras Parceiras
    // 2. Listar Negócios em Andamento
    // 3. Atualizar Status de Negócio

    public MenuEstoque(Empresa empresa) {

        JFrame frame = new JFrame("Sistema Farmacêutico");

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label = new JLabel("GERENCIAR ESTOQUE");
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setBounds(255, 30, 300, 20);
        panel.add(label);

        JLabel subtitle = new JLabel("ALMOXARIFADO");
        subtitle.setFont(new Font("Arial", Font.BOLD, 10));
        subtitle.setBounds(310, 45, 200, 20);
        panel.add(subtitle);

        int larguraBotao = 250;
        int alturaBotao = 30;
        int margemLateral = 225;

        JButton botao1 = new JButton("Adicionar Produto");
        botao1.setBounds(margemLateral, 85, larguraBotao, alturaBotao);
        panel.add(botao1);

        JButton botao2 = new JButton("Atualizar Produto");
        botao2.setBounds(margemLateral, 145, larguraBotao, alturaBotao);
        panel.add(botao2);

        JButton botao3 = new JButton("Listar Produtos em Estoque");
        botao3.setBounds(margemLateral, 205, larguraBotao, alturaBotao);
        panel.add(botao3);

        JButton botao4 = new JButton("Registrar Compra/Reabastecimento");
        botao4.setBounds(margemLateral, 265, larguraBotao, alturaBotao);
        panel.add(botao4);

        JButton botao5 = new JButton("Remover Produto");
        botao5.setBounds(margemLateral, 325, larguraBotao, alturaBotao);
        panel.add(botao5);

        JButton botaoSair = new JButton("Voltar");
        botaoSair.setBounds(margemLateral, 385, larguraBotao, alturaBotao);
        panel.add(botaoSair);

        botao1.addActionListener(e -> {
            new AdicionarProduto(empresa);
            frame.dispose();
        });
        botao2.addActionListener(e -> {
            new AtualizarProduto(empresa);
            frame.dispose();
        });
        botao3.addActionListener(e -> {
            new ListarTodosProdutos(empresa);
            frame.dispose();
        });
        botao5.addActionListener(e -> {
            new RemoverProduto(empresa);
            frame.dispose();
        });
        botaoSair.addActionListener(e -> {
            new MenuAMX(empresa);
            frame.dispose();
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}