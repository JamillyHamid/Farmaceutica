package views.funcs.Transportadora;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import sistema.Empresa;
import sistema.Transportadora;
import views.MenuTransportadora;

public class AtualizarTransportadora {
    private int index = 0;
    private String nomeFixo;

    public AtualizarTransportadora(Empresa empresa, String setorLogin) {
        JFrame frame = new JFrame("Sistema Farmacêutico");

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label = new JLabel("EDITAR TRANSPORTADORA");
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setBounds(100, 30, 500, 20);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label);

        JLabel subtitle = new JLabel(setorLogin);
        subtitle.setFont(new Font("Arial", Font.BOLD, 10));
        subtitle.setBounds(100, 45, 500, 20);
        subtitle.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(subtitle);

        JLabel labelId = new JLabel("Transportadora: ");
        labelId.setBounds(180, 100, 350, 20);
        panel.add(labelId);

        List<String> nomeLista = new ArrayList<>();
        for (Transportadora transp : empresa.getTransportadoras()) {
            nomeLista.add(transp.getNome());
        }

        JComboBox<String> comboBoxNome = new JComboBox<>(nomeLista.toArray(new String[0]));
        comboBoxNome.setBounds(350, 100, 200, 25);
        panel.add(comboBoxNome);

        JLabel labelNome = new JLabel("Nome da transportadora:");
        labelNome.setBounds(180, 150, 350, 20);
        panel.add(labelNome);

        JTextField textFieldNome = new JTextField();
        textFieldNome.setBounds(350, 150, 150, 25);
        panel.add(textFieldNome);

        JLabel labelValorFrete = new JLabel("Valor do frete:");
        labelValorFrete.setBounds(180, 200, 350, 20);
        panel.add(labelValorFrete);

        JTextField textFieldValorFrete = new JTextField();
        textFieldValorFrete.setBounds(350, 200, 150, 25);
        panel.add(textFieldValorFrete);

        JLabel labelLocais = new JLabel("Local (cidade - estado):");
        labelLocais.setBounds(180, 250, 350, 20);
        panel.add(labelLocais);

        JTextField textFieldLocais = new JTextField();
        textFieldLocais.setBounds(350, 250, 150, 25);
        panel.add(textFieldLocais);

        JButton botaoLocais = new JButton("ADICIONAR");
        botaoLocais.setBounds(550, 250, 100, 25);
        panel.add(botaoLocais);

        DefaultListModel<String> locaisLista = new DefaultListModel<>();
        JList<String> lista = new JList<>(locaisLista);
        Border borda = BorderFactory.createLineBorder(Color.BLACK, 1);
        JScrollPane scrollPane = new JScrollPane(lista);
        scrollPane.setBounds(200, 300, 300, 100);
        scrollPane.setBorder(borda);
        panel.add(scrollPane);

        botaoLocais.addActionListener(e -> {
            locaisLista.add(index, textFieldLocais.getText().toString());
            lista.setModel(locaisLista);
            index++;
            textFieldLocais.setText(null);
        });

        JButton botaoRetroceder = new JButton("APAGAR");
        botaoRetroceder.setBounds(550, 300, 100, 25);
        panel.add(botaoRetroceder);

        botaoRetroceder.addActionListener(e -> {
            if (!locaisLista.isEmpty()) {
                locaisLista.remove(index - 1);
                lista.setModel(locaisLista);
                index--;
            }
        });

        comboBoxNome.addActionListener(e -> {
            nomeFixo = comboBoxNome.getSelectedItem().toString();
            locaisLista.removeAllElements();
            for (Transportadora transp : empresa.getTransportadoras()) {
                if (transp.getNome().equals(comboBoxNome.getSelectedItem().toString())) {
                    textFieldNome.setText(transp.getNome());
                    textFieldValorFrete.setText(String.valueOf(transp.getValorFreteFixo()));
                    for (int i = 0; i < transp.getLocaisAtendimento().size(); i++) {
                        locaisLista.add(i, transp.getLocaisAtendimento().get(i));
                        index++;
                    }
                }
            }
        });

        JButton botaoVoltar = new JButton("VOLTAR");
        botaoVoltar.setBounds(50, 400, 100, 30);
        panel.add(botaoVoltar);

        JButton botaoSalvar = new JButton("SALVAR");
        botaoSalvar.setBounds(550, 400, 100, 30);
        panel.add(botaoSalvar);

        botaoVoltar.addActionListener(e -> {
            new MenuTransportadora(empresa, setorLogin);
            frame.dispose();
        });

        botaoSalvar.addActionListener(e -> {
            List<String> locaisList = new ArrayList<>();
            for (int i = 0; i < locaisLista.size(); i++) {
                locaisList.add(locaisLista.get(i));
            }
            empresa.atualizarTransportadora(nomeFixo, textFieldNome.getText().toString(),
                    Double.parseDouble(textFieldValorFrete.getText()), locaisList);
            new AtualizarTransportadora(empresa, setorLogin);
            frame.dispose();
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
