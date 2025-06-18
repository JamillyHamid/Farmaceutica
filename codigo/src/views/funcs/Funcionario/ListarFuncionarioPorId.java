package views.funcs.Funcionario;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;
import java.util.List;

import sistema.Empresa;
import sistema.Funcionario;
import sistema.Setor;
import views.MenuFuncionarios;

public class ListarFuncionarioPorId {
    public ListarFuncionarioPorId(Empresa empresa, String setorLogin) {

        JFrame frame = new JFrame("Sistema Farmacêutico");

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label = new JLabel("LISTAR FUNCIONÁRIOS POR ID");
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setBounds(100, 30, 500, 20);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label);

        JLabel subtitle = new JLabel(setorLogin);
        subtitle.setFont(new Font("Arial", Font.BOLD, 10));
        subtitle.setBounds(100, 45, 500, 20);
        subtitle.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(subtitle);

        JLabel labelId = new JLabel("Digite o ID do funcionário: ");
        labelId.setBounds(180, 100, 350, 20);
        panel.add(labelId);

        List<String> idLista = new ArrayList<>();

        for (Setor setor : empresa.getSetores().values()) {
            for (Funcionario fun : setor.getFuncionarios()) {
                idLista.add(fun.getId());
            }
        }

        JComboBox<String> comboBoxid = new JComboBox<>(idLista.toArray(new String[0]));
        comboBoxid.setBounds(350, 100, 150, 25);
        panel.add(comboBoxid);

        String[] colunas = { "ID", "Nome", "Cargo", "Salário Base", "Bonificação", "IR Retido", "Salário Líquido", "VT",
                "VR", "VA", "Plano Saúde", "Plano Odonto" };

        DefaultTableModel model = new DefaultTableModel(colunas, 0) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable tabela = new JTable(model);
        tabela.setRowHeight(30);
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setBounds(50, 220, 600, 68);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        frame.add(scrollPane);

        for (Setor setor : empresa.getSetores().values()) {
            for (Funcionario fun : setor.getFuncionarios()) {
                if (fun.getId().equals(comboBoxid.getSelectedItem().toString())) {
                    model.addRow(new Object[] { fun.getId(), fun.getNomeCompleto(), fun.getCargo(),
                            String.format("R$ %.2f", fun.getSalarioBase()),
                            String.format("R$ %.2f", fun.getBonificacaoLucros()),
                            String.format("R$ %.2f", fun.getImpostoRenda()),
                            String.format("R$ %.2f", fun.getSalarioLiquido()),
                            String.format("R$ %.2f", fun.getValeTransporte()),
                            String.format("R$ %.2f", fun.getValeRefeicao()),
                            String.format("R$ %.2f", fun.getValeAlimentacao()),
                            String.format("R$ %.2f", fun.getPlanoSaude()),
                            String.format("R$ %.2f", fun.getPlanoOdontologico()),
                    });
                    break;
                }
                ;
            }
        }

        comboBoxid.addActionListener(e -> {
            model.setRowCount(0);
            for (Setor setor : empresa.getSetores().values()) {
                for (Funcionario fun : setor.getFuncionarios()) {
                    if (fun.getId().equals(comboBoxid.getSelectedItem().toString())) {
                        model.addRow(new Object[] { fun.getId(), fun.getNomeCompleto(), fun.getCargo(),
                                fun.getSalarioBase(), fun.getBonificacaoLucros(), fun.getImpostoRenda(),
                                fun.getSalarioLiquido(), fun.getValeTransporte(), fun.getValeRefeicao(),
                                fun.getValeAlimentacao(), fun.getPlanoSaude(), fun.getPlanoOdontologico()
                        });
                        break;
                    }
                    ;
                }
            }
        });

        JButton botaoVoltar = new JButton("VOLTAR");
        botaoVoltar.setBounds(50, 400, 100, 30);
        panel.add(botaoVoltar);

        botaoVoltar.addActionListener(e -> {
            new MenuFuncionarios(empresa, setorLogin);
            frame.dispose();
        });

        frame.add(panel);
        frame.setVisible(true);

    }
}
