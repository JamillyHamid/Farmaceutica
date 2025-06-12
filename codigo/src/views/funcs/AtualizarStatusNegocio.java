package views.funcs;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import views.MenuAMX;

import sistema.Empresa;
import sistema.NegocioEmAndamento;

public class AtualizarStatusNegocio {

    // System.out.print("Digite o ID do negócio para atualizar o status: ");
    // String idNegocio = scanner.nextLine();
    // System.out.print("Digite o novo status (Ex: Concluído, Cancelado, Em
    // negociação): ");
    // String novoStatus = scanner.nextLine();
    // atualizarStatusNegocio(idNegocio, novoStatus);

    public AtualizarStatusNegocio(Empresa empresa) {
        JFrame frame = new JFrame("Sistema Farmacêutico");

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label = new JLabel("ATUALIZAR STATUS DO NEGÓCIO");
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setBounds(100, 30, 500, 20);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label);

        JLabel subtitle = new JLabel("ALMOXARIFADO");
        subtitle.setFont(new Font("Arial", Font.BOLD, 10));
        subtitle.setBounds(100, 45, 500, 20);
        subtitle.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(subtitle);

        JLabel labelId = new JLabel("Digite o ID do negócio: ");
        labelId.setBounds(200, 100, 350, 20);
        panel.add(labelId);

        List<String> idLista = new ArrayList<>();

        List<NegocioEmAndamento> negocioEmAndamento = empresa.getNegociosEmAndamento();
        for (NegocioEmAndamento neg : negocioEmAndamento) {
            idLista.add(neg.getIdNegocio());
        }

        JComboBox<String> comboBoxid = new JComboBox<>(idLista.toArray(new String[0]));
        comboBoxid.setBounds(350, 100, 150, 25);
        panel.add(comboBoxid);

        JLabel labelStatus = new JLabel("Digite o novo status: ");
        labelStatus.setBounds(200, 150, 350, 20);
        panel.add(labelStatus);

        String[] statusLista = {
                "Concluído",
                "Cancelado",
                "Em Negociação"
        };

        JComboBox<String> comboBoxStatus = new JComboBox<>(statusLista);
        comboBoxStatus.setBounds(350, 150, 150, 25);
        panel.add(comboBoxStatus);

        JButton botaoSair = new JButton("VOLTAR");
        botaoSair.setBounds(225, 220, 100, 30);
        panel.add(botaoSair);

        JButton botaoSalvar = new JButton("SALVAR");
        botaoSalvar.setBounds(375, 220, 100, 30);
        panel.add(botaoSalvar);

        botaoSair.addActionListener(e -> {
            new MenuAMX(empresa);
            frame.dispose();
        });

        botaoSalvar.addActionListener(e -> {
            new MenuAMX(empresa);
            frame.dispose();
            empresa.atualizarStatusNegocio(comboBoxid.getSelectedItem().toString(),
                    comboBoxStatus.getSelectedItem().toString());
            empresa.listarNegociosEmAndamento();
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
