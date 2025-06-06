package views;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {

    public Login() {

        JFrame frame = new JFrame();
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

        JLabel idLabel = new JLabel("ID do Funcionário:");
        idLabel.setBounds(40, 60, 150, 25);
        panel.add(idLabel);

        JTextField idField = new JTextField();
        idField.setBounds(190, 60, 150, 25);
        panel.add(idField);

        JLabel senhaLabel = new JLabel("Senha do Funcionário:");
        senhaLabel.setBounds(40, 100, 150, 25);
        panel.add(senhaLabel);

        JPasswordField senhaField = new JPasswordField();
        senhaField.setBounds(190, 100, 150, 25);
        panel.add(senhaField);

        JButton loginBotao = new JButton("Entrar");
        loginBotao.setBounds(130, 165, 120, 30);
        panel.add(loginBotao);

        loginBotao.addActionListener(e ->{
            
        });

        frame.add(panel);
        frame.setVisible(true);

    }

}