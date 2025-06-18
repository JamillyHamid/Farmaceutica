package views.funcs.Calculos;

import javax.swing.*;
import java.awt.*;

import sistema.Empresa;
import views.MenuCaixa;
import views.FNC.MenuFNC;

public class EstimarLucros {
    public EstimarLucros(Empresa empresa, String setorLogin) {
        JFrame frame = new JFrame("Sistema Farmacêutico");

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label = new JLabel("ESTIMAR LUCROS");
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setBounds(100, 30, 500, 20);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label);

        JLabel subtitle = new JLabel(setorLogin);
        subtitle.setFont(new Font("Arial", Font.BOLD, 10));
        subtitle.setBounds(100, 45, 500, 20);
        subtitle.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(subtitle);

        JLabel labelValorEstimado = new JLabel("Valor para estipular:");
        labelValorEstimado.setBounds(150, 100, 150, 20);
        panel.add(labelValorEstimado);

        JTextField textFieldValorEstimado = new JTextField();
        textFieldValorEstimado.setBounds(320, 100, 150, 20);
        panel.add(textFieldValorEstimado);

        JButton botaoEstimar = new JButton("ESTIMAR");
        botaoEstimar.setBounds(550, 400, 100, 30);
        panel.add(botaoEstimar);

        JLabel labelVendas = new JLabel();
        labelVendas.setBounds(150, 180, 350, 20);
        panel.add(labelVendas);

        JLabel labelCusto = new JLabel();
        labelCusto.setBounds(150, 220, 350, 20);
        panel.add(labelCusto);

        JLabel labelLucroMensal = new JLabel();
        labelLucroMensal.setBounds(150, 260, 350, 20);
        panel.add(labelLucroMensal);

        JLabel labelLucroAnual = new JLabel();
        labelLucroAnual.setBounds(150, 300, 450, 20);
        panel.add(labelLucroAnual);

        botaoEstimar.addActionListener(e -> {
            double[] valores = empresa.estimarLucros(Double.parseDouble(textFieldValorEstimado.getText()));
            labelVendas.setText("Vendas Programadas Mensais: R$" + String.format("%.2f", valores[0]));
            labelCusto.setText("Custo Mensal Estimado com Pessoal: R$" + String.format("%.2f", valores[1]));
            labelLucroMensal.setText("Lucro Mensal Estimado: R$" + String.format("%.2f", valores[2]));
            labelLucroAnual.setText("Lucro Anual Estimado : R$"
                    + String.format("%.2f", valores[3]));

        });

        JButton botaoVoltar = new JButton("VOLTAR");
        botaoVoltar.setBounds(50, 400, 100, 30);
        panel.add(botaoVoltar);

        botaoVoltar.addActionListener(e -> {
            switch (setorLogin) {
                case "GERENTE":
                    new MenuCaixa(empresa, setorLogin);
                    break;
                case "FINANCEIRO":
                    new MenuFNC(empresa, setorLogin);
                    break;
            }
            frame.dispose();
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
