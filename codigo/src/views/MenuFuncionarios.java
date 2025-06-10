package views;

import javax.swing.*;

import sistema.Empresa;
import views.funcs.AdicionarFuncionario;
import views.funcs.ListarTodosFuncionarios;

import java.awt.*;

public class MenuFuncionarios {

    // 1. Adicionar Funcionário
    // 2. Atualizar Dados do Funcionário
    // 3. Remover Funcionário
    // 4. Listar Funcionários por Setor
    // 5. Listar Todos os Funcionários

    public MenuFuncionarios(Empresa empresa) {

        JFrame frame = new JFrame("Sistema Farmacêutico");

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label = new JLabel("MENU FUNCIONÁRIOS");
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setBounds(250, 30, 250, 20);
        panel.add(label);

        JLabel subtitle = new JLabel("GESTÃO DE PESSOAS");
        subtitle.setFont(new Font("Arial", Font.BOLD, 10));
        subtitle.setBounds(295, 45, 200, 20);
        panel.add(subtitle);

        int larguraBotao = 250;
        int alturaBotao = 30;
        int margemLateral = 225;

        JButton botao1 = new JButton("Adicionar Funcionário");
        botao1.setBounds(margemLateral, 85, larguraBotao, alturaBotao);
        panel.add(botao1);

        JButton botao2 = new JButton("Atualizar Dados do Funcionário");
        botao2.setBounds(margemLateral, 145, larguraBotao, alturaBotao);
        panel.add(botao2);

        JButton botao3 = new JButton("Listar Funcionários por Setor");
        botao3.setBounds(margemLateral, 205, larguraBotao, alturaBotao);
        panel.add(botao3);

        JButton botao4 = new JButton("Listar Todos os Funcionários");
        botao4.setBounds(margemLateral, 265, larguraBotao, alturaBotao);
        panel.add(botao4);

        JButton botao5 = new JButton("Remover Funcionário");
        botao5.setBounds(margemLateral, 325, larguraBotao, alturaBotao);
        panel.add(botao5);

        botao1.addActionListener(e -> {
            new AdicionarFuncionario(empresa);
            frame.dispose();
        });
        botao2.addActionListener(e -> {
            frame.dispose();
        });
        botao4.addActionListener(e -> {
            new ListarTodosFuncionarios(empresa);
            frame.dispose();
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
