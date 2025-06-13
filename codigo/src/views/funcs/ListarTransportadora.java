package views.funcs;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import sistema.Empresa;
import sistema.Transportadora;
import views.MenuTransportadora;

import java.awt.*;

public class ListarTransportadora {
    public ListarTransportadora(Empresa empresa) {
        JFrame frame = new JFrame("Sistema Farmacêutico");

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label = new JLabel("LISTAR TRANSPORTADORA");
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setBounds(100, 30, 500, 20);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label);

        JLabel subtitle = new JLabel("GERENTE");
        subtitle.setFont(new Font("Arial", Font.BOLD, 10));
        subtitle.setBounds(100, 45, 500, 20);
        subtitle.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(subtitle);

        String[] colunas = { "Nome", "Frete", "Locais" };
        DefaultTableModel model = new DefaultTableModel(colunas, 0) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable tabela = new JTable(model);
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(200);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(70);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(500);

        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setBounds(50, 105, 600, 250);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        frame.add(scrollPane);

        for (Transportadora transp : empresa.getTransportadoras()) {
            model.addRow(new Object[] { transp.getNome(), transp.getValorFreteFixo(), transp.getLocaisAtendimento()
            });
        }

        JButton botaoSair = new JButton("VOLTAR");
        botaoSair.setBounds(305, 400, 100, 30);
        panel.add(botaoSair);

        botaoSair.addActionListener(e -> {
            new MenuTransportadora(empresa);
            frame.dispose();
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
