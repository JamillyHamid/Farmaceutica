package views;

import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.List;

import sistema.Empresa;
import sistema.Funcionario;
import sistema.Setor;

public class Login extends JFrame {

    public Login() {

        JFrame frame = new JFrame("Login - Sistema Farmacêutico");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel titulo = new JLabel("Login por Setor");
        titulo.setBounds(130, 10, 200, 30);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(titulo);

        JLabel setorLabel = new JLabel("Setor:");
        setorLabel.setBounds(40, 60, 150, 25);
        panel.add(setorLabel);

        String[] setoresLista = {
                "Almoxarifado", "Atendimento ao Cliente", "Financeiro",
                "Gerente de Filial", "Gestão de Pessoas", "Vendas"
        };
        JComboBox<String> setorComboBox = new JComboBox<>(setoresLista);
        setorComboBox.setBounds(190, 60, 150, 25);
        panel.add(setorComboBox);

        JLabel idLabel = new JLabel("ID do Funcionário:");
        idLabel.setBounds(40, 100, 150, 25);
        panel.add(idLabel);

        JTextField idField = new JTextField();
        idField.setBounds(190, 100, 150, 25);
        panel.add(idField);

        JLabel senhaLabel = new JLabel("Senha do Funcionário:");
        senhaLabel.setBounds(40, 140, 150, 25);
        panel.add(senhaLabel);

        JPasswordField senhaField = new JPasswordField();
        senhaField.setBounds(190, 140, 150, 25);
        panel.add(senhaField);

        JButton loginBotao = new JButton("Entrar");
        loginBotao.setBounds(130, 190, 120, 30);
        panel.add(loginBotao);

        Empresa empresa = new Empresa();

        loginBotao.addActionListener(e -> {

            Map<String, Setor> setores = empresa.getSetores();
            Setor setor = setores.get(setorComboBox.getSelectedItem());
            List<Funcionario> funcionarios = setor.getFuncionarios();
            String senha = new String(senhaField.getPassword());
            String escolha =  (String) (setorComboBox.getSelectedItem());
            int i = 1;
            for (Funcionario fun : funcionarios) {
                if (fun.getId().equals(idField.getText()) && fun.getSenha().equals(senha)) {
                    switch (escolha) {
                        case "Gerente de Filial":
                            new MenuGDF();
                            break;
                        case "Atendimento ao Cliente":
                            new MenuATC();
                            break;
                        case "Gestão de Pessoas":
                            new MenuGDP();
                            break;
                        case "Financeiro":
                            new MenuFNC();
                            break;
                        case "Vendas":
                            new MenuVND();
                            break;
                        case "Almoxarifado":
                            new MenuAMX();
                            break;
                    }
                    frame.dispose();
                    break;
                } else if (i == funcionarios.size()) {
                    JOptionPane.showMessageDialog(frame, "Dados incorretos!");
                }
                i++;
            }
        });

        frame.add(panel);
        frame.setVisible(true);

    }

}