package views.funcs;

import javax.swing.*;
import java.awt.*;

import javax.swing.table.DefaultTableModel;

import sistema.Empresa;
import sistema.Produto;
import views.MenuEstoque;

public class ListarTodosProdutos {
    public ListarTodosProdutos(Empresa empresa) {

        JFrame frame = new JFrame("Sistema Farmacêutico");

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label = new JLabel("LISTAR TODOS OS PRODUTOS");
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setBounds(100, 30, 500, 20);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label);

        JLabel subtitle = new JLabel("ALMOXARIFADO");
        subtitle.setFont(new Font("Arial", Font.BOLD, 10));
        subtitle.setBounds(100, 45, 500, 20);
        subtitle.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(subtitle);

        String[] colunas = { "Nome", "ID", "Compra", "Venda", "Estoque" };
        DefaultTableModel model = new DefaultTableModel(colunas, 0) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable tabela = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setBounds(50, 105, 600, 250);
        frame.add(scrollPane);

        for (Produto produto : empresa.getProdutos().values()) {
            model.addRow(new Object[] { produto.getNome(), produto.getCodigo(), produto.getValorCompra(),
                    produto.getValorVenda(),
                    produto.getQuantidadeEstoque()
            });
        }

        JButton botaoSair = new JButton("VOLTAR");
        botaoSair.setBounds(305, 400, 100, 30);
        panel.add(botaoSair);

        botaoSair.addActionListener(e -> {
            new MenuEstoque(empresa);
            frame.dispose();
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
