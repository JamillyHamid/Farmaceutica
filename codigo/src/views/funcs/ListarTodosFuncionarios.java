package views.funcs;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.util.List;
import java.util.Map;

import sistema.Empresa;
import sistema.Funcionario;
import sistema.Setor;
import views.MenuFuncionarios;

public class ListarTodosFuncionarios {
    public ListarTodosFuncionarios(Empresa empresa) {
        JFrame frame = new JFrame("Sistema Farmacêutico");

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label = new JLabel("LISTAR TODOS OS FUNCIONÁRIOS");
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setBounds(200, 30, 350, 20);
        panel.add(label);

        JLabel subtitle = new JLabel("GESTÃO DE PESSOAS");
        subtitle.setFont(new Font("Arial", Font.BOLD, 10));
        subtitle.setBounds(295, 45, 200, 20);
        panel.add(subtitle);

        JLabel setorLabel = new JLabel("Pesquisar por setor:");
        setorLabel.setBounds(135, 75, 150, 25);
        panel.add(setorLabel);

        String[] setoresLista = {
                "Todos",
                "Almoxarifado",
                "Atendimento ao Cliente",
                "Financeiro",
                "Gerente de Filial",
                "Gestão de Pessoas",
                "Vendas"
        };

        JComboBox<String> setorComboBox = new JComboBox<>(setoresLista);
        setorComboBox.setBounds(280, 75, 150, 25);
        panel.add(setorComboBox);

        String[] colunas = { "ID", "Nome", "Idade", "Genêro", "Setor", "Cargo", "Salário" };
        DefaultTableModel model = new DefaultTableModel(colunas, 0) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable tabela = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setBounds(50, 115, 600, 250);
        frame.add(scrollPane);

        for (Setor setor : empresa.getSetores().values()) {
            for (Funcionario fun : setor.getFuncionarios()) {
                model.addRow(new Object[] { fun.getId(), fun.getNomeCompleto(), fun.getIdade(), fun.getGenero(),
                        setor.getNomeSetor(),
                        fun.getCargo(), fun.getSalarioBase() });
            }
        }

        setorComboBox.addActionListener(e -> {
            model.setRowCount(0);
            String escolha = setorComboBox.getSelectedItem().toString();
            if (escolha.equals("Todos")) {
                for (Setor setor : empresa.getSetores().values()) {
                    for (Funcionario fun : setor.getFuncionarios()) {
                        model.addRow(new Object[] { fun.getId(), fun.getNomeCompleto(), fun.getIdade(), fun.getGenero(),
                                setor.getNomeSetor(),
                                fun.getCargo(), fun.getSalarioBase() });
                    }
                }
            } else {
                Map<String, Setor> setores = empresa.getSetores();
                Setor setor = setores.get(setorComboBox.getSelectedItem());
                List<Funcionario> funcionarios = setor.getFuncionarios();

                for (Funcionario fun : funcionarios) {
                    model.addRow(new Object[] { fun.getId(), fun.getNomeCompleto(), fun.getIdade(), fun.getGenero(),
                            setor.getNomeSetor(),
                            fun.getCargo(), fun.getSalarioBase() });
                }
            }
        });

        JButton botaoSair = new JButton("VOLTAR");
        botaoSair.setBounds(305, 400, 100, 30);
        panel.add(botaoSair);

        botaoSair.addActionListener(e -> {
            new MenuFuncionarios(empresa);
            frame.dispose();
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
