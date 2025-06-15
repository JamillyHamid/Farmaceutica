package views.funcs;

import sistema.Empresa;
import sistema.Funcionario;
import sistema.Produto;
import sistema.Setor;
import sistema.Transportadora;
import views.MenuVND;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.util.ArrayList;

import java.util.List;

public class RegistrarVenda {

    private int indexProd = 0;
    private int indexFunc = 0;
    private List<String> idListaLocais = new ArrayList<>();


    public RegistrarVenda(Empresa empresa) {
        JFrame frame = new JFrame("Sistema Farmacêutico");

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label = new JLabel("REGISTRAR VENDA");
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setBounds(100, 30, 500, 20);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label);

        JLabel subtitle = new JLabel("VENDAS");
        subtitle.setFont(new Font("Arial", Font.BOLD, 10));
        subtitle.setBounds(100, 45, 500, 20);
        subtitle.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(subtitle);

        // Tabela de produtos

        String[] colunas = { "Nome", "ID", "Venda", "Estoque" };
        DefaultTableModel model = new DefaultTableModel(colunas, 0) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable tabela = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setBounds(50, 85, 600, 75);
        frame.add(scrollPane);

        for (Produto produto : empresa.getProdutos().values()) {
            model.addRow(new Object[] { produto.getNome(), produto.getCodigo(),
                    produto.getValorVenda(),
                    produto.getQuantidadeEstoque()
            });
        }

        // Lista para selecionar os produtos

        List<String> idListaProd = new ArrayList<>();
        for (Produto prod : empresa.getProdutos().values()) {
            idListaProd.add(prod.getCodigo());
        }

        JComboBox<String> comboBoxIdProd = new JComboBox<>(idListaProd.toArray(new String[0]));
        comboBoxIdProd.setBounds(50, 180, 100, 25);
        panel.add(comboBoxIdProd);

        JTextField textFieldQtd = new JTextField();
        textFieldQtd.setBounds(170, 180, 50, 25);
        panel.add(textFieldQtd);

        DefaultListModel<String> prodLista = new DefaultListModel<>();
        JList<String> listaProd = new JList<>(prodLista);
        Border bordaProd = BorderFactory.createLineBorder(Color.BLACK, 1);
        JScrollPane scrollPaneProd = new JScrollPane(listaProd);
        scrollPaneProd.setBounds(50, 220, 170, 80);
        scrollPaneProd.setBorder(bordaProd);
        panel.add(scrollPaneProd);

        JButton botaoAddProd = new JButton("ADICIONAR");
        botaoAddProd.setBounds(240, 180, 100, 25);
        panel.add(botaoAddProd);

        botaoAddProd.addActionListener(e -> {
            prodLista.add(indexProd,
                    String.format("%s - %s", comboBoxIdProd.getSelectedItem().toString(), textFieldQtd.getText()));
            listaProd.setModel(prodLista);
            indexProd++;
        });

        JButton botaoRetrocederProd = new JButton("APAGAR");
        botaoRetrocederProd.setBounds(240, 275, 100, 25);
        panel.add(botaoRetrocederProd);

        botaoRetrocederProd.addActionListener(e -> {
            if (!prodLista.isEmpty()) {
                prodLista.remove(indexProd - 1);
                listaProd.setModel(prodLista);
                indexProd--;
            }
        });

        // Lista para adicionar funcionários

        List<String> idListaFunc = new ArrayList<>();
        for (Setor setor : empresa.getSetores().values()) {
            for (Funcionario fun : setor.getFuncionarios()) {
                idListaFunc.add(fun.getId());
            }
        }

        JComboBox<String> comboBoxIdFunc = new JComboBox<>(idListaFunc.toArray(new String[0]));
        comboBoxIdFunc.setBounds(360, 180, 170, 25);
        panel.add(comboBoxIdFunc);

        DefaultListModel<String> funcLista = new DefaultListModel<>();
        JList<String> listaFunc = new JList<>(funcLista);
        Border bordaFunc = BorderFactory.createLineBorder(Color.BLACK, 1);
        JScrollPane scrollPaneFunc = new JScrollPane(listaFunc);
        scrollPaneFunc.setBounds(360, 220, 170, 80);
        scrollPaneFunc.setBorder(bordaFunc);
        panel.add(scrollPaneFunc);

        JButton botaoAddFunc = new JButton("ADICIONAR");
        botaoAddFunc.setBounds(550, 180, 100, 25);
        panel.add(botaoAddFunc);

        botaoAddFunc.addActionListener(e -> {
            funcLista.add(indexFunc, comboBoxIdFunc.getSelectedItem().toString());
            listaFunc.setModel(funcLista);
            indexFunc++;
        });

        JButton botaoRetrocederFunc = new JButton("APAGAR");
        botaoRetrocederFunc.setBounds(550, 275, 100, 25);
        panel.add(botaoRetrocederFunc);

        botaoRetrocederFunc.addActionListener(e -> {
            if (!funcLista.isEmpty()) {
                funcLista.remove(indexFunc - 1);
                listaFunc.setModel(funcLista);
                indexFunc--;
            }
        });

        // Transportadora

        List<String> idListaTransp = new ArrayList<>();
        for (Transportadora transp : empresa.getTransportadoras()) {
            idListaTransp.add(transp.getNome());
        }

        JComboBox<String> comboBoxIdTransp = new JComboBox<>(idListaTransp.toArray(new String[0]));
        comboBoxIdTransp.setBounds(50, 340, 290, 25);
        panel.add(comboBoxIdTransp);

        comboBoxIdTransp.addActionListener(e -> {
            for (Transportadora transp : empresa.getTransportadoras()) {
                if(transp.getNome().equals(comboBoxIdTransp.getSelectedItem().toString())){
                    idListaLocais = transp.getLocaisAtendimento();
                    break;
                }
            }
        });

        // Locais


        JComboBox<String> comboBoxIdLocais = new JComboBox<>(idListaLocais.toArray(new String[0]));
        comboBoxIdLocais.setBounds(360, 340, 290, 25);
        panel.add(comboBoxIdLocais);

        // Sair e Salvar

        JButton botaoSair = new JButton("VOLTAR");
        botaoSair.setBounds(50, 400, 100, 30);
        panel.add(botaoSair);

        JButton botaoSalvar = new JButton("SALVAR");
        botaoSalvar.setBounds(550, 400, 100, 30);
        panel.add(botaoSalvar);

        botaoSair.addActionListener(e -> {
            new MenuVND(empresa);
            frame.dispose();
        });

        botaoSalvar.addActionListener(e -> {
            new MenuVND(empresa);
            frame.dispose();
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
