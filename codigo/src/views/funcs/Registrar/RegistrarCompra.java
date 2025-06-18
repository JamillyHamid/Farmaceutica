package views.funcs.Registrar;

import sistema.Empresa;
import sistema.Funcionario;
import sistema.Produto;
import sistema.Setor;
import sistema.Transportadora;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import views.MenuEstoque;

public class RegistrarCompra {

    private int indexProd = 0;
    private int indexFunc = 0;
    private Map<Produto, Integer> map = new HashMap<>();
    private double totalConta = 0;
    private double memoria = 0;

    public RegistrarCompra(Empresa empresa, String setorLogin) {

        JFrame frame = new JFrame("Sistema Farmacêutico");

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label = new JLabel("REGISTRAR COMPRA");
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setBounds(100, 30, 500, 20);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label);

        JLabel subtitle = new JLabel(setorLogin);
        subtitle.setFont(new Font("Arial", Font.BOLD, 10));
        subtitle.setBounds(100, 45, 500, 20);
        subtitle.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(subtitle);
        // Total

        JLabel total = new JLabel(String.format("TOTAL DA COMPRA: R$ %.2f", totalConta));
        total.setBounds(250, 400, 200, 30);
        total.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(total);

        // Tabela de produtos

        String[] colunas = { "Nome", "ID", "Compra", "Estoque" };
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
                    String.format("R$ %.2f", produto.getValorCompra()),
                    produto.getQuantidadeEstoque()
            });
        }

        // Lista para selecionar os produtos

        List<String> idListaProd = new ArrayList<>();
        for (Produto prod : empresa.getProdutos().values()) {
            idListaProd.add(prod.getCodigo());
        }

        JComboBox<String> comboBoxIdProd = new JComboBox<>(idListaProd.toArray(new String[0]));
        comboBoxIdProd.setBounds(50, 195, 100, 25);
        panel.add(comboBoxIdProd);

        JTextField textFieldQtd = new JTextField();
        textFieldQtd.setBounds(170, 195, 50, 25);
        panel.add(textFieldQtd);

        DefaultListModel<String> prodLista = new DefaultListModel<>();
        JList<String> listaProd = new JList<>(prodLista);
        Border bordaProd = BorderFactory.createLineBorder(Color.BLACK, 1);
        JScrollPane scrollPaneProd = new JScrollPane(listaProd);
        scrollPaneProd.setBounds(50, 235, 170, 80);
        scrollPaneProd.setBorder(bordaProd);
        panel.add(scrollPaneProd);

        JButton botaoAddProd = new JButton("ADICIONAR");
        botaoAddProd.setBounds(240, 195, 100, 25);
        panel.add(botaoAddProd);

        botaoAddProd.addActionListener(e -> {
            if (!textFieldQtd.getText().isEmpty()) {
                Produto prod = empresa.getProdutos().get(comboBoxIdProd.getSelectedItem().toString());
                if (prod.getQuantidadeEstoque() < Integer.parseInt(textFieldQtd.getText())) {
                    JOptionPane.showMessageDialog(null, "Quantidade de estoque insuficiente!");
                } else {
                    prodLista.add(indexProd, String.format("%s - %s", comboBoxIdProd.getSelectedItem().toString(),
                            textFieldQtd.getText()));
                    map.put(prod, Integer.parseInt(textFieldQtd.getText()));
                    listaProd.setModel(prodLista);
                    totalConta += (prod.getValorCompra() * (Double.parseDouble(textFieldQtd.getText())));
                    total.setText(String.format("TOTAL DA COMPRA: R$ %.2f", totalConta));
                    textFieldQtd.setText("");
                    indexProd++;
                }
            }

        });

        JButton botaoRetrocederProd = new JButton("APAGAR");
        botaoRetrocederProd.setBounds(240, 290, 100, 25);
        panel.add(botaoRetrocederProd);

        botaoRetrocederProd.addActionListener(e -> {
            if (!prodLista.isEmpty()) {
                Produto prod = empresa.getProdutos().get(comboBoxIdProd.getSelectedItem().toString());
                map.remove(prod);
                totalConta -= (prod.getValorCompra()
                        * (Double.parseDouble(prodLista.get(indexProd - 1).split("-")[1].trim())));
                total.setText(String.format("TOTAL DA COMPRA: R$ %.2f", totalConta));
                prodLista.remove(indexProd - 1);
                listaProd.setModel(prodLista);
                System.out.println(map);
                indexProd--;
            }
        });

        // Lista para adicionar funcionários

        List<String> idListaFunc = new ArrayList<>();
        Setor setorVND = empresa.getSetores().get("Almoxarifado");
        Setor setorGDF = empresa.getSetores().get("Gerente de Filial");
        for (Funcionario fun : setorVND.getFuncionarios()) {
            idListaFunc.add(fun.getId());
        }
        for (Funcionario fun : setorGDF.getFuncionarios()) {
            idListaFunc.add(fun.getId());
        }

        JComboBox<String> comboBoxIdFunc = new JComboBox<>(idListaFunc.toArray(new String[0]));
        comboBoxIdFunc.setBounds(360, 195, 170, 25);
        panel.add(comboBoxIdFunc);

        DefaultListModel<String> funcLista = new DefaultListModel<>();
        JList<String> listaFunc = new JList<>(funcLista);
        Border bordaFunc = BorderFactory.createLineBorder(Color.BLACK, 1);
        JScrollPane scrollPaneFunc = new JScrollPane(listaFunc);
        scrollPaneFunc.setBounds(360, 235, 170, 80);
        scrollPaneFunc.setBorder(bordaFunc);
        panel.add(scrollPaneFunc);

        JButton botaoAddFunc = new JButton("ADICIONAR");
        botaoAddFunc.setBounds(550, 195, 100, 25);
        panel.add(botaoAddFunc);

        botaoAddFunc.addActionListener(e -> {
            funcLista.add(indexFunc, comboBoxIdFunc.getSelectedItem().toString());
            listaFunc.setModel(funcLista);
            indexFunc++;
        });

        JButton botaoRetrocederFunc = new JButton("APAGAR");
        botaoRetrocederFunc.setBounds(550, 290, 100, 25);
        panel.add(botaoRetrocederFunc);

        botaoRetrocederFunc.addActionListener(e -> {
            if (!funcLista.isEmpty()) {
                funcLista.remove(indexFunc - 1);
                listaFunc.setModel(funcLista);
                indexFunc--;
            }
        });

        // Transportadora e locais

        List<String> nomeListaTransp = new ArrayList<>();
        for (Transportadora transp : empresa.getTransportadoras()) {
            nomeListaTransp.add(transp.getNome());
        }

        JComboBox<String> comboBoxNomeTransp = new JComboBox<>(nomeListaTransp.toArray(new String[0]));
        comboBoxNomeTransp.setBounds(50, 350, 290, 25);
        panel.add(comboBoxNomeTransp);

        JComboBox<String> comboBoxNomeLocais = new JComboBox<>();
        comboBoxNomeLocais.setBounds(360, 350, 290, 25);
        panel.add(comboBoxNomeLocais);

        comboBoxNomeTransp.addActionListener(e -> {
            List<String> nomeListaLocais = new ArrayList<>();
            DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>(nomeListaLocais.toArray(new String[0]));
            for (Transportadora transp : empresa.getTransportadoras()) {
                if (transp.getNome().equals(comboBoxNomeTransp.getSelectedItem().toString())) {
                    modelo.addAll(transp.getLocaisAtendimento());
                    comboBoxNomeLocais.setModel(modelo);
                    totalConta += transp.getValorFreteFixo() - memoria;
                    memoria = transp.getValorFreteFixo();
                    total.setText(String.format("TOTAL DA COMPRA: R$ %.2f", totalConta));
                    break;
                }
            }
        });

        // Sair e Salvar

        JButton botaoVoltar = new JButton("VOLTAR");
        botaoVoltar.setBounds(50, 400, 100, 30);
        panel.add(botaoVoltar);

        JButton botaoSalvar = new JButton("SALVAR");
        botaoSalvar.setBounds(550, 400, 100, 30);
        panel.add(botaoSalvar);

        botaoVoltar.addActionListener(e -> {
            new MenuEstoque(empresa, setorLogin);
            frame.dispose();
        });

        botaoSalvar.addActionListener(e -> {
            List<String> ids = new ArrayList<>();
            for (int i = 0; i < funcLista.size(); i++) {
                ids.add(funcLista.get(i));
            }
            empresa.registrarCompra(map, ids, comboBoxNomeTransp.getSelectedItem().toString(),
                    comboBoxNomeLocais.getSelectedItem().toString(), totalConta);
            new RegistrarCompra(empresa, setorLogin);
            frame.dispose();
        });

        frame.add(panel);
        frame.setVisible(true);

    }
}
