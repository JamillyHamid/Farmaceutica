package views.funcs.Produto;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import java.awt.*;

import sistema.Empresa;
import sistema.Produto;
import views.MenuEstoque;

public class RemoverProduto {
    public RemoverProduto(Empresa empresa, String setorLogin) {
        JFrame frame = new JFrame("Sistema Farmacêutico");

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label = new JLabel("DELETAR PRODUTO");
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setBounds(100, 30, 500, 20);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label);

        JLabel subtitle = new JLabel(setorLogin);
        subtitle.setFont(new Font("Arial", Font.BOLD, 10));
        subtitle.setBounds(100, 45, 500, 20);
        subtitle.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(subtitle);

        JLabel labelId = new JLabel("Informe o ID do produto: ");
        labelId.setBounds(190, 100, 350, 20);
        panel.add(labelId);

        List<String> idLista = new ArrayList<>();

        for (Produto produto : empresa.getProdutos().values()) {
            idLista.add(produto.getCodigo());
        }

        JComboBox<String> comboBoxid = new JComboBox<>(idLista.toArray(new String[0]));
        comboBoxid.setBounds(360, 100, 150, 25);
        panel.add(comboBoxid);

        JButton botaoVoltar = new JButton("VOLTAR");
        botaoVoltar.setBounds(50, 400, 100, 30);
        panel.add(botaoVoltar);

        JButton botaoDeletar = new JButton("DELETAR");
        botaoDeletar.setBounds(550, 400, 100, 30);
        panel.add(botaoDeletar);

        botaoVoltar.addActionListener(e -> {
            new MenuEstoque(empresa, setorLogin);
            frame.dispose();
        });

        botaoDeletar.addActionListener(e -> {
            int popup = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir esse produto?");
            if (popup == JOptionPane.YES_OPTION) {
                empresa.removerProduto(comboBoxid.getSelectedItem().toString());
                new RemoverProduto(empresa, setorLogin);
                frame.dispose();
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
