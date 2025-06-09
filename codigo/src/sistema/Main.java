package sistema;

import java.util.Scanner;

import javax.swing.*;

import views.Login;
import views.MenuRH;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        // JFrame frame = new JFrame("Sistema Farmacêutico - Login");
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setSize(400, 250);
        // frame.setLocationRelativeTo(null);

        // JPanel panel = new JPanel();
        // panel.setLayout(null);

        // JLabel titulo = new JLabel("Login por Setor");
        // titulo.setBounds(130, 10, 200, 30);
        // titulo.setFont(new Font("Arial", Font.BOLD, 16));
        // panel.add(titulo);

        // JLabel idLabel = new JLabel("ID do Funcionário:");
        // idLabel.setBounds(50, 60, 120, 25);
        // panel.add(idLabel);

        // JTextField idField = new JTextField();
        // idField.setBounds(180, 60, 150, 25);
        // panel.add(idField);

        // JLabel setorLabel = new JLabel("Setor:");
        // setorLabel.setBounds(50, 100, 120, 25);
        // panel.add(setorLabel);

        // String[] setores = {
        // "Gerente de Filial", "Atendimento ao Cliente", "Gestão de Pessoas",
        // "Financeiro", "Vendas", "Almoxarifado", "Transportadoras"
        // };
        // JComboBox<String> setorComboBox = new JComboBox<>(setores);
        // setorComboBox.setBounds(180, 100, 150, 25);
        // panel.add(setorComboBox);

        // JButton loginButton = new JButton("Entrar");
        // loginButton.setBounds(130, 150, 120, 30);
        // panel.add(loginButton);

        // // Ação do botão de login
        // loginButton.addActionListener(e -> {
        // String id = idField.getText();
        // String setor = (String) setorComboBox.getSelectedItem();
        // Empresa empresa = new Empresa(); // ou receba como parâmetro

        // if (id.isBlank()) {
        // JOptionPane.showMessageDialog(frame, "Informe o ID do funcionário.");
        // } else {
        // // Aqui você chama seu método de lógica, por exemplo:
        // // empresa.entrarNoSistema(id, setor);
        // new MenuRH(empresa);
        // JOptionPane.showMessageDialog(frame, "Login como " + setor + " com ID: " +
        // id);

        // frame.dispose(); // Fecha a janela de login
        // // Aqui você poderia abrir o menu correspondente ao setor
        // }
        // });

        // frame.add(panel);
        // frame.setVisible(true);

        new Login();
        // Empresa empresa = new Empresa();
        // empresa.exibirMenu();

    }

    // public static void login() {
    // Scanner scan = new Scanner(System.in);
    // System.out.println("\n========== LOGIN ==========");
    // System.out.print("Id: ");
    // String loginId = scan.next();
    // System.out.print("Senha: ");
    // String loginSenha = scan.next();

    // }
}