package views;

import javax.swing.*;

import sistema.Empresa;

import java.awt.*;

public class MenuFNC {
    // 1. Listar Produtos em Estoque
    // 2. Listar Transportadoras Parceiras
    // 3. Ver Caixa Total
    // 4. Estimar Lucros Anuais
    // 5. Folha de Pagamento Detalhada
    public MenuFNC(Empresa empresa) {

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

        JLabel subtitle = new JLabel("FINANCEIRO");
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

        JButton botao2 = new JButton("Folha de Pagamento Detalhada");
        botao2.setBounds(margemLateral, 145, larguraBotao, alturaBotao);
        panel.add(botao2);

        JButton botao3 = new JButton("Listar Produtos em Estoque");
        botao3.setBounds(margemLateral, 205, larguraBotao, alturaBotao);
        panel.add(botao3);

        JButton botao4 = new JButton("Listar Transportadoras Parceiras");
        botao4.setBounds(margemLateral, 265, larguraBotao, alturaBotao);
        panel.add(botao4);

        JButton botao5 = new JButton("Ver Caixa Total");
        botao5.setBounds(margemLateral, 265, larguraBotao, alturaBotao);
        panel.add(botao5);

        botao1.addActionListener(e -> {
            frame.dispose();
        });
        botao2.addActionListener(e -> {
            frame.dispose();
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
