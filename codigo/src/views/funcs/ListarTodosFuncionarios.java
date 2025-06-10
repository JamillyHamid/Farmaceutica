package views.funcs;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import sistema.Empresa;
import sistema.Funcionario;
import sistema.NegocioEmAndamento;
import sistema.Setor;
import views.MenuFuncionarios;

public class ListarTodosFuncionarios {
    public ListarTodosFuncionarios(Empresa empresa) {
        JFrame frame = new JFrame("Sistema Farmacêutico");

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label = new JLabel("LISTAR TODOS OS FUNCIONÁRIOS");
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setBounds(250, 30, 350, 20);
        panel.add(label);

        JLabel subtitle = new JLabel("GESTÃO DE PESSOAS");
        subtitle.setFont(new Font("Arial", Font.BOLD, 10));
        subtitle.setBounds(295, 45, 200, 20);
        panel.add(subtitle);

        String[] colunas = {"ID", "Nome", "Idade", "Genêro", "Setor", "Cargo", "Salário"};

        JButton botaoSair = new JButton("VOLTAR");
        botaoSair.setBounds(225, 400, 100, 30);
        panel.add(botaoSair);

        botaoSair.addActionListener(e -> {
            new MenuFuncionarios(empresa);
            frame.dispose();
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
