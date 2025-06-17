package views.funcs.NegocioAndamento;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import sistema.Empresa;
import sistema.NegocioEmAndamento;
import sistema.Produto;
import views.MenuNegocio;
import views.AMX.MenuAMX;
import views.ATC.MenuATC;
import views.VND.MenuVND;

public class ListarNegocioAndamento {
    private int i = 0;

    public ListarNegocioAndamento(Empresa empresa, String setorLogin) {
        JFrame frame = new JFrame("Sistema Farmacêutico");

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label = new JLabel("LISTAR NEGÓCIOS EM ANDAMENTO");
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setBounds(100, 30, 500, 20);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label);

        JLabel subtitle = new JLabel(setorLogin);
        subtitle.setFont(new Font("Arial", Font.BOLD, 10));
        subtitle.setBounds(100, 45, 500, 20);
        subtitle.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(subtitle);

        String[] colunas = { "ID", "Tipo", "Status", "Data" };
        DefaultTableModel model = new DefaultTableModel(colunas, 0) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable tabela = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setBounds(50, 85, 600, 150);
        frame.add(scrollPane);

        for (NegocioEmAndamento negocio : empresa.getNegociosEmAndamento()) {
            model.addRow(new Object[] { negocio.getIdNegocio(), negocio.getTipo(), negocio.getStatus(),
                    negocio.getDataInicio() });
        }

        DefaultListModel<String> funcLista = new DefaultListModel<>();
        JList<String> listaFunc = new JList<>(funcLista);
        Border bordaFunc = BorderFactory.createLineBorder(Color.BLACK, 1);
        JScrollPane scrollPaneFunc = new JScrollPane(listaFunc);
        scrollPaneFunc.setBounds(400, 265, 200, 100);
        scrollPaneFunc.setBorder(bordaFunc);
        panel.add(scrollPaneFunc);

        DefaultListModel<String> prodLista = new DefaultListModel<>();
        JList<String> listaProd = new JList<>(prodLista);
        Border bordaProd = BorderFactory.createLineBorder(Color.BLACK, 1);
        JScrollPane scrollPaneProd = new JScrollPane(listaProd);
        scrollPaneProd.setBounds(100, 265, 200, 100);
        scrollPaneProd.setBorder(bordaProd);
        panel.add(scrollPaneProd);

        tabela.getSelectionModel().addListSelectionListener(e -> {
            int linhaSelecionada = tabela.getSelectedRow();
            String id = tabela.getValueAt(linhaSelecionada, 0).toString();

            for (NegocioEmAndamento negocio : empresa.getNegociosEmAndamento()) {
                if (negocio.getIdNegocio().equals(id)) {
                    funcLista.clear();
                    prodLista.clear();
                    i = 0;
                    if (negocio.getTipo().equals("Venda")) {
                        negocio.getParticipantesVenda().forEach(item -> {
                            funcLista.add(i, item.getId());
                            i++;
                        });
                    } else {
                        negocio.getParticipantesCompra().forEach(item -> {
                            funcLista.add(i, item.getId());
                            i++;
                        });
                    }
                    i = 0;
                    negocio.getProdutosEnvolvidos().forEach((idprod, qtd) -> {
                        prodLista.add(i, String.format("%s - %d", idprod, qtd));
                        i++;
                    });

                    listaProd.setModel(prodLista);
                    listaFunc.setModel(funcLista);
                }
            }
        });

        JButton botaoVoltar = new JButton("VOLTAR");
        botaoVoltar.setBounds(50, 400, 100, 30);
        panel.add(botaoVoltar);

        botaoVoltar.addActionListener(e -> {
            switch (setorLogin) {
                case "GERENTE":
                    new MenuNegocio(empresa, setorLogin);
                    break;
                case "ATENDIMENTO AO CLIENTE":
                    new MenuATC(empresa, setorLogin);
                    break;
                case "VENDAS":
                    new MenuVND(empresa, setorLogin);
                    break;
                case "ALMOXARIFADO":
                    new MenuAMX(empresa, setorLogin);
                    break;
            }
            frame.dispose();
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
