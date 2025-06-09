package views;

import javax.swing.*;
import java.awt.*;

public class MenuAMX {

    // "1. Gerenciar Estoque");
    // 1. Adicionar Produto
    // 2. Atualizar Produto
    // 3. Remover Produto
    // 4. Listar Produtos em Estoque
    // 5. Registrar Compra/Reabastecimento

    // "2. Negócios");
    // 1. Listar Transportadoras Parceiras
    // 2. Listar Negócios em Andamento
    // 3. Atualizar Status de Negócio
    
    public MenuAMX() {

        JFrame frame = new JFrame("Sistema Farmacêutico");

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label = new JLabel("MENU GERAL");
        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setBounds(300, 30, 200, 20);
        panel.add(label);

        int larguraBotao = 250;
        int alturaBotao = 30;
        int margemLateral = 225;

        JButton botao1 = new JButton("Gerenciar Funcionários");
        botao1.setBounds(margemLateral, 85, larguraBotao, alturaBotao);
        panel.add(botao1);

        JButton botao2 = new JButton("Voltar");
        botao2.setBounds(margemLateral, 145, larguraBotao, alturaBotao);
        panel.add(botao2);

        botao1.addActionListener(e -> {

        });
        botao2.addActionListener(e -> {
            new MenuGDF();
            frame.dispose();
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
