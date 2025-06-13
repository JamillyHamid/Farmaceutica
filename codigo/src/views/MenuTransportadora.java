package views;

import javax.swing.*;
import java.awt.*;

import sistema.Empresa;
import views.funcs.AdicionarTransportadora;
import views.funcs.AtualizarTransportadora;
import views.funcs.ListarTodosProdutos;
import views.funcs.ListarTransportadora;
import views.funcs.RemoverTransportadora;

public class MenuTransportadora {
    public MenuTransportadora(Empresa empresa) {

        JFrame frame = new JFrame("Sistema Farmacêutico");

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label = new JLabel("MENU TRANSPORTADORA");
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setBounds(100, 30, 500, 20);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label);

        JLabel subtitle = new JLabel("GERENTE");
        subtitle.setFont(new Font("Arial", Font.BOLD, 10));
        subtitle.setBounds(100, 45, 500, 20);
        subtitle.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(subtitle);

        int larguraBotao = 250;
        int alturaBotao = 30;
        int margemLateral = 225;

        JButton botao1 = new JButton("Adicionar Transportadora");
        botao1.setBounds(margemLateral, 85, larguraBotao, alturaBotao);
        panel.add(botao1);

        JButton botao2 = new JButton("Editar Transportadora");
        botao2.setBounds(margemLateral, 145, larguraBotao, alturaBotao);
        panel.add(botao2);

        JButton botao3 = new JButton("Listar Transportadora");
        botao3.setBounds(margemLateral, 205, larguraBotao, alturaBotao);
        panel.add(botao3);

        JButton botao4 = new JButton("Remover Transportadora");
        botao4.setBounds(margemLateral, 265, larguraBotao, alturaBotao);
        panel.add(botao4);

        JButton botaoSair = new JButton("Voltar");
        botaoSair.setBounds(margemLateral, 325, larguraBotao, alturaBotao);
        panel.add(botaoSair);

        botao1.addActionListener(e -> {
            new AdicionarTransportadora(empresa);
            frame.dispose();
        });
        botao2.addActionListener(e -> {
            new AtualizarTransportadora(empresa);
            frame.dispose();
        });
        botao3.addActionListener(e -> {
            new ListarTransportadora(empresa);
            frame.dispose();
        });
        botao4.addActionListener(e -> {
            new RemoverTransportadora(empresa);
            frame.dispose();
        });
        botaoSair.addActionListener(e -> {
            new MenuGDF(empresa);
            frame.dispose();
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
