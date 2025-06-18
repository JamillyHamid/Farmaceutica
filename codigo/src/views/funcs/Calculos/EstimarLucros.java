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
        labelValorEstimado.setBounds(150, 90, 150, 20);
        panel.add(labelValorEstimado);

        JTextField textFieldValorEstimado = new JTextField();
        textFieldValorEstimado.setBounds(320, 90, 150, 20);
        panel.add(textFieldValorEstimado);

        JButton botaoEstimar = new JButton("ESTIMAR");
        botaoEstimar.setBounds(550, 400, 100, 30);
        panel.add(botaoEstimar);

        JLabel labelVendas = new JLabel("Vendas Programadas Mensais");
        labelVendas.setFont(new Font("Arial", Font.BOLD, 15));
        labelVendas.setBounds(100, 140, 500, 20);
        labelVendas.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(labelVendas);

        JLabel subtitleVendas = new JLabel("R$ 0,00");
        subtitleVendas.setFont(new Font("Arial", Font.BOLD, 12));
        subtitleVendas.setBounds(100, 160, 500, 20);
        subtitleVendas.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(subtitleVendas);

        JLabel labelCusto = new JLabel("Custo Mensal Estimado com Pessoal");
        labelCusto.setFont(new Font("Arial", Font.BOLD, 15));
        labelCusto.setBounds(100, 200, 500, 20);
        labelCusto.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(labelCusto);

        JLabel subtitleCusto = new JLabel("R$ 0,00");
        subtitleCusto.setFont(new Font("Arial", Font.BOLD, 12));
        subtitleCusto.setBounds(100, 220, 500, 20);
        subtitleCusto.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(subtitleCusto);

        JLabel labelLucroMensal = new JLabel("Lucro Mensal Estimado");
        labelLucroMensal.setFont(new Font("Arial", Font.BOLD, 15));
        labelLucroMensal.setBounds(100, 260, 500, 20);
        labelLucroMensal.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(labelLucroMensal);

        JLabel subtitleLucroMensal = new JLabel("R$ 0,00");
        subtitleLucroMensal.setFont(new Font("Arial", Font.BOLD, 12));
        subtitleLucroMensal.setBounds(100, 280, 500, 20);
        subtitleLucroMensal.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(subtitleLucroMensal);

        JLabel labelLucroAnual = new JLabel("Lucro Anual Estimado");
        labelLucroAnual.setFont(new Font("Arial", Font.BOLD, 15));
        labelLucroAnual.setBounds(100, 320, 500, 20);
        labelLucroAnual.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(labelLucroAnual);

        JLabel subtitleLucroAnual = new JLabel("R$ 0,00");
        subtitleLucroAnual.setFont(new Font("Arial", Font.BOLD, 12));
        subtitleLucroAnual.setBounds(100, 340, 500, 20);
        subtitleLucroAnual.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(subtitleLucroAnual);

        botaoEstimar.addActionListener(e -> {
            double[] valores = empresa.estimarLucros(Double.parseDouble(textFieldValorEstimado.getText()));
            subtitleVendas.setText(String.format("R$ %.2f", valores[0]));
            subtitleCusto.setText(String.format("R$ %.2f", valores[1]));
            subtitleLucroMensal.setText(String.format("R$ %.2f", valores[2]));
            subtitleLucroAnual.setText(String.format("R$ %.2f", valores[3]));

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
