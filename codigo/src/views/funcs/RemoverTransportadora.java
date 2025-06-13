package views.funcs;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import java.awt.*;

import sistema.Empresa;
import sistema.Transportadora;
import views.MenuTransportadora;

public class RemoverTransportadora {
    public RemoverTransportadora(Empresa empresa) {
        JFrame frame = new JFrame("Sistema Farmacêutico");

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label = new JLabel("REMOVER TRANSPORTADORA");
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setBounds(100, 30, 500, 20);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label);

        JLabel subtitle = new JLabel("GERENTE");
        subtitle.setFont(new Font("Arial", Font.BOLD, 10));
        subtitle.setBounds(100, 45, 500, 20);
        subtitle.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(subtitle);

        JLabel labelId = new JLabel("Nome da transportadora: ");
        labelId.setBounds(190, 100, 350, 20);
        panel.add(labelId);

        List<String> nomeLista = new ArrayList<>();

        for (Transportadora transp : empresa.getTransportadoras()) {
            nomeLista.add(transp.getNome());
        }

        JComboBox<String> comboBoxNome = new JComboBox<>(nomeLista.toArray(new String[0]));
        comboBoxNome.setBounds(360, 100, 200, 25);
        panel.add(comboBoxNome);

        JButton botaoSair = new JButton("VOLTAR");
        botaoSair.setBounds(225, 400, 100, 30);
        panel.add(botaoSair);

        JButton botaoDeletar = new JButton("DELETAR");
        botaoDeletar.setBounds(375, 400, 100, 30);
        panel.add(botaoDeletar);

        botaoSair.addActionListener(e -> {
            new MenuTransportadora(empresa);
            frame.dispose();
        });

        botaoDeletar.addActionListener(e -> {
            int popup = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir essa transportadora?");
            if (popup == JOptionPane.YES_OPTION) {
                empresa.removerTransportadora(comboBoxNome.getSelectedItem().toString());
                new MenuTransportadora(empresa);
                frame.dispose();
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
