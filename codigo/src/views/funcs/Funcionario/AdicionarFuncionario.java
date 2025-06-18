package views.funcs.Funcionario;

import javax.swing.*;

import sistema.Empresa;
import sistema.Funcionario;
import views.MenuFuncionarios;


import java.awt.*;

public class AdicionarFuncionario {

    // adicionarFuncionario(new Funcionario(nome, senha, idade, genero, cargo,
    // salario), setorNome);

    public AdicionarFuncionario(Empresa empresa, String setorLogin) {
        JFrame frame = new JFrame("Sistema Farmacêutico");

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label = new JLabel("CADASTRAR FUNCIONÁRIO");
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setBounds(100, 30, 500, 20);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label);

        JLabel subtitle = new JLabel(setorLogin);
        subtitle.setFont(new Font("Arial", Font.BOLD, 10));
        subtitle.setBounds(100, 45, 500, 20);
        subtitle.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(subtitle);

        JLabel labelNome = new JLabel("Informe o nome completo:");
        labelNome.setBounds(180, 100, 350, 20);
        panel.add(labelNome);

        JTextField textFieldNome = new JTextField();
        textFieldNome.setBounds(350, 100, 150, 25);
        panel.add(textFieldNome);

        JLabel labelSenha = new JLabel("Crie a senha de usuário:");
        labelSenha.setBounds(180, 150, 350, 20);
        panel.add(labelSenha);

        JPasswordField passwordFieldNome = new JPasswordField();
        passwordFieldNome.setBounds(350, 150, 150, 25);
        panel.add(passwordFieldNome);

        JLabel labelIdade = new JLabel("Informe a idade:");
        labelIdade.setBounds(180, 200, 350, 20);
        panel.add(labelIdade);

        JTextField textFieldIdade = new JTextField();
        textFieldIdade.setBounds(350, 200, 150, 25);
        panel.add(textFieldIdade);

        JLabel labelGenero = new JLabel("Selecione seu gênero: ");
        labelGenero.setBounds(180, 250, 350, 20);
        panel.add(labelGenero);

        String[] generoLista = {
                "Masculino",
                "Feminino",
                "Outros"
        };

        JComboBox<String> comboBoxGenero = new JComboBox<>(generoLista);
        comboBoxGenero.setBounds(350, 250, 150, 25);
        panel.add(comboBoxGenero);

        JLabel Labelsetor = new JLabel("Selecione o setor:");
        Labelsetor.setBounds(180, 300, 150, 25);
        panel.add(Labelsetor);

        String[] setoresLista = {
                "Almoxarifado",
                "Atendimento ao Cliente",
                "Financeiro",
                "Gerente de Filial",
                "Gestão de Pessoas",
                "Vendas"
        };

        JComboBox<String> comboBoxSetor = new JComboBox<>(setoresLista);
        comboBoxSetor.setBounds(350, 300, 150, 25);
        panel.add(comboBoxSetor);

        JLabel labelSalario = new JLabel("Informe o salário inicial:");
        labelSalario.setBounds(180, 350, 350, 20);
        panel.add(labelSalario);

        JTextField textFieldSalario = new JTextField();
        textFieldSalario.setBounds(350, 350, 150, 25);
        panel.add(textFieldSalario);

        JLabel labelCargo = new JLabel("Informe o cargo:");
        labelCargo.setBounds(180, 400, 350, 20);
        panel.add(labelCargo);

        JTextField textFieldCargo = new JTextField();
        textFieldCargo.setBounds(350, 400, 150, 25);
        panel.add(textFieldCargo);

        JButton botaoVoltar = new JButton("VOLTAR");
        botaoVoltar.setBounds(50, 400, 100, 30);
        panel.add(botaoVoltar);

        JButton botaoSalvar = new JButton("SALVAR");
        botaoSalvar.setBounds(550, 400, 100, 30);
        panel.add(botaoSalvar);

        botaoVoltar.addActionListener(e -> {
            new MenuFuncionarios(empresa, setorLogin);
            frame.dispose();
        });

        botaoSalvar.addActionListener(e -> {
            empresa.adicionarFuncionario(
                    new Funcionario(textFieldNome.getText(), new String(passwordFieldNome.getPassword()),
                            Integer.parseInt(textFieldIdade.getText()),
                            comboBoxGenero.getSelectedItem().toString(), textFieldCargo.getText(),
                            Double.parseDouble(textFieldSalario.getText())),
                    comboBoxSetor.getSelectedItem().toString());
            System.out.println(Double.parseDouble(textFieldSalario.getText()));
            new AdicionarFuncionario(empresa, setorLogin);
            frame.dispose();
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
