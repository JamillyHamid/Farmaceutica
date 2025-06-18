package views.funcs.Produto;

import javax.swing.*;
import java.awt.*;

import javax.swing.table.DefaultTableModel;

import sistema.Empresa;
import sistema.Produto;
import views.MenuEstoque;
import views.ATC.MenuATC;
import views.FNC.MenuFNC;
import views.GDP.MenuGDP;
import views.VND.MenuVND;

public class ListarTodosProdutos {
    public ListarTodosProdutos(Empresa empresa, String setorLogin) {

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

        JLabel subtitle = new JLabel(setorLogin);
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
            model.addRow(new Object[] { produto.getNome(), produto.getCodigo(), String.format("R$ %.2f", produto.getValorCompra()),
                    String.format("R$ %.2f", produto.getValorVenda()),
                    produto.getQuantidadeEstoque()
            });
        }

        JButton botaoVoltar = new JButton("VOLTAR");
        botaoVoltar.setBounds(50, 400, 100, 30);
        panel.add(botaoVoltar);

        botaoVoltar.addActionListener(e -> {
            switch (setorLogin) {
                case "GERENTE":
                    new MenuEstoque(empresa, setorLogin);
                    break;
                case "ATENDIMENTO AO CLIENTE":
                    new MenuATC(empresa, setorLogin);
                    break;
                case "GESTÃO DE PESSOAS":
                    new MenuGDP(empresa, setorLogin);
                    break;
                case "FINANCEIRO":
                    new MenuFNC(empresa, setorLogin);
                    break;
                case "VENDAS":
                    new MenuVND(empresa, setorLogin);
                    break;
                case "ALMOXARIFADO":
                    new MenuEstoque(empresa, setorLogin);
                    break;
            }
            frame.dispose();
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
