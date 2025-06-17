package views.FNC;

import javax.swing.*;

import sistema.Empresa;
import views.Login;
import views.funcs.Calculos.EstimarLucros;
import views.funcs.Calculos.VerCaixaTotal;
import views.funcs.Produto.ListarTodosProdutos;
import views.funcs.Transportadora.ListarTransportadora;

import java.awt.*;

public class MenuFNC {
    // 1. XXXXX Listar Produtos em Estoque
    // 2. XXXXX Listar Transportadoras Parceiras
    // 3. Ver Caixa Total
    // 4. Estimar Lucros Anuais

    public MenuFNC(Empresa empresa, String setorLogin) {

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

        JButton botao1 = new JButton("Estimar Lucros Anuais");
        botao1.setBounds(margemLateral, 85, larguraBotao, alturaBotao);
        panel.add(botao1);

        JButton botao2 = new JButton("Listar Produtos em Estoque");
        botao2.setBounds(margemLateral, 145, larguraBotao, alturaBotao);
        panel.add(botao2);

        JButton botao3 = new JButton("Listar Transportadoras Parceiras");
        botao3.setBounds(margemLateral, 205, larguraBotao, alturaBotao);
        panel.add(botao3);

        JButton botao4 = new JButton("Ver Caixa Total");
        botao4.setBounds(margemLateral, 265, larguraBotao, alturaBotao);
        panel.add(botao4);

        botao1.addActionListener(e -> {
            new EstimarLucros(empresa, setorLogin);
            frame.dispose();
        });
        botao2.addActionListener(e -> {
            new ListarTodosProdutos(empresa, setorLogin);
            frame.dispose();
        });
        botao3.addActionListener(e -> {
            new ListarTransportadora(empresa, setorLogin);
            frame.dispose();
        });
        botao4.addActionListener(e -> {
            new VerCaixaTotal(empresa, setorLogin);
            frame.dispose();
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
