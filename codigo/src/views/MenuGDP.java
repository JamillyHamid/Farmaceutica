package views;

import javax.swing.*;

import sistema.Empresa;
import views.funcs.CalcularFolha;

import java.awt.*;

public class MenuGDP {

    // "1. Funcionarios");
    // 1. Adicionar Funcionário
    // 2. Atualizar Dados do Funcionário
    // 3. Remover Funcionário
    // 4. Listar Funcionários por Setor
    // 5. Listar Todos os Funcionários

    // 1. Calcular Folha de Pagamento
    // 2. Listar Produtos em Estoque
    // 3. Listar Transportadoras Parceiras

    public MenuGDP(Empresa empresa) {

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

        JLabel subtitle = new JLabel("GESTÃO DE PESSOAS");
        subtitle.setFont(new Font("Arial", Font.BOLD, 10));
        subtitle.setBounds(100, 45, 500, 20);
        subtitle.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(subtitle);

        int larguraBotao = 250;
        int alturaBotao = 30;
        int margemLateral = 225;

        JButton botao1 = new JButton("Calcular Folha de Pagamento");
        botao1.setBounds(margemLateral, 85, larguraBotao, alturaBotao);
        panel.add(botao1);

        JButton botao2 = new JButton("Funcionarios");
        botao2.setBounds(margemLateral, 145, larguraBotao, alturaBotao);
        panel.add(botao2);

        JButton botao3 = new JButton("Listar Produtos em Estoque");
        botao3.setBounds(margemLateral, 205, larguraBotao, alturaBotao);
        panel.add(botao3);

        JButton botao4 = new JButton("Listar Transportadoras Parceiras");
        botao4.setBounds(margemLateral, 265, larguraBotao, alturaBotao);
        panel.add(botao4);

        botao1.addActionListener(e -> {
            new CalcularFolha(empresa);
            frame.dispose();
        });
        botao2.addActionListener(e -> {
            new MenuFuncionarios(empresa);
            frame.dispose();
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
