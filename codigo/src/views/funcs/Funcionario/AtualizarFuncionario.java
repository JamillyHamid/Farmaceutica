package views.funcs.Funcionario;

import javax.swing.*;

import sistema.Empresa;
import sistema.Funcionario;
import sistema.Setor;
import views.MenuFuncionarios;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AtualizarFuncionario {

    // adicionarFuncionario(new Funcionario(nome, senha, idade, genero, cargo,
    // salario), setorNome);

    public AtualizarFuncionario(Empresa empresa, String setorLogin) {
        JFrame frame = new JFrame("Sistema Farmacêutico");

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label = new JLabel("ATUALIZAR FUNCIONÁRIO");
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
        labelId.setBounds(180, 90, 350, 20);
        panel.add(labelId);

        List<String> idLista = new ArrayList<>();

        for (Setor setor : empresa.getSetores().values()) {
            for (Funcionario fun : setor.getFuncionarios()) {
                idLista.add(fun.getId());
            }
        }

        JComboBox<String> comboBoxid = new JComboBox<>(idLista.toArray(new String[0]));
        comboBoxid.setBounds(350, 90, 150, 25);
        panel.add(comboBoxid);

        JLabel labelNome = new JLabel("Informe o nome completo:");
        labelNome.setBounds(180, 135, 350, 20);
        panel.add(labelNome);

        JTextField textFieldNome = new JTextField();
        textFieldNome.setBounds(350, 135, 150, 25);
        panel.add(textFieldNome);

        JLabel labelSenha = new JLabel("Crie a senha de usuário:");
        labelSenha.setBounds(180, 180, 350, 20);
        panel.add(labelSenha);

        JPasswordField passwordFieldSenha = new JPasswordField();
        passwordFieldSenha.setBounds(350, 180, 150, 25);
        panel.add(passwordFieldSenha);

        JLabel labelIdade = new JLabel("Informe a idade em anos:");
        labelIdade.setBounds(180, 225, 350, 20);
        panel.add(labelIdade);

        JTextField textFieldIdade = new JTextField();
        textFieldIdade.setBounds(350, 225, 150, 25);
        panel.add(textFieldIdade);

        JLabel labelGenero = new JLabel("Selecione seu gênero: ");
        labelGenero.setBounds(180, 270, 350, 20);
        panel.add(labelGenero);

        String[] generoLista = {
                "Masculino",
                "Feminino",
                "Outros"
        };

        JComboBox<String> comboBoxGenero = new JComboBox<>(generoLista);
        comboBoxGenero.setBounds(350, 270, 150, 25);
        panel.add(comboBoxGenero);

        JLabel Labelsetor = new JLabel("Selecione o setor:");
        Labelsetor.setBounds(180, 315, 150, 25);
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
        comboBoxSetor.setBounds(350, 315, 150, 25);
        panel.add(comboBoxSetor);

        JLabel labelSalario = new JLabel("Informe o salário inicial:");
        labelSalario.setBounds(180, 360, 350, 20);
        panel.add(labelSalario);

        JTextField textFieldSalario = new JTextField();
        textFieldSalario.setBounds(350, 360, 150, 25);
        panel.add(textFieldSalario);

        JLabel labelCargo = new JLabel("Informe o cargo:");
        labelCargo.setBounds(180, 405, 350, 20);
        panel.add(labelCargo);

        JTextField textFieldCargo = new JTextField();
        textFieldCargo.setBounds(350, 405, 150, 25);
        panel.add(textFieldCargo);

        comboBoxid.addActionListener(e -> {
            for (Setor setor : empresa.getSetores().values()) {
                for (Funcionario fun : setor.getFuncionarios()) {
                    if (fun.getId().equals(comboBoxid.getSelectedItem().toString())) {
                        String nome = fun.getNomeCompleto();
                        String senha = fun.getSenha();
                        String idade = String.valueOf(fun.getIdade());
                        String salario = String.valueOf(fun.getSalarioBase());
                        String cargo = fun.getCargo();

                        textFieldNome.setText(nome);
                        passwordFieldSenha.setText(senha);
                        textFieldIdade.setText(idade);
                        textFieldSalario.setText(salario);
                        textFieldCargo.setText(cargo);

                        comboBoxGenero.setSelectedItem(fun.getGenero());
                        comboBoxSetor.setSelectedItem(setor.getNomeSetor());

                        break;
                    }
                    ;
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
            new MenuFuncionarios(empresa, setorLogin);
            frame.dispose();
        });

        botaoSalvar.addActionListener(e -> {
            empresa.atualizarFuncionario(comboBoxid.getSelectedItem().toString(), textFieldNome.getText(),
                    passwordFieldSenha.getPassword().toString(), Integer.parseInt(textFieldIdade.getText()),
                    comboBoxGenero.getSelectedItem().toString(), comboBoxSetor.getSelectedItem().toString(),
                    Double.parseDouble(textFieldSalario.getText()), textFieldCargo.getText());
            new AtualizarFuncionario(empresa, setorLogin);
            frame.dispose();
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
