package views.funcs.Calculos;

import javax.swing.*;
import java.awt.*;
import sistema.Empresa;
import views.MenuCaixa;
import views.GDP.MenuGDP;

public class CalcularFolha {
    public CalcularFolha(Empresa empresa, String setorLogin) {
        JFrame frame = new JFrame("Sistema Farmacêutico");

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label = new JLabel("CÁLCULO DA FOLHA DE PAGAMENTO");
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setBounds(100, 30, 500, 20);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label);

        JLabel subtitle = new JLabel(setorLogin);
        subtitle.setFont(new Font("Arial", Font.BOLD, 10));
        subtitle.setBounds(100, 45, 500, 20);
        subtitle.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(subtitle);

        double[] valores = empresa.calcularFolhaDePagamento();

        JLabel labelSalario = new JLabel("Total de Salários Líquidos Pagos");
        labelSalario.setFont(new Font("Arial", Font.BOLD, 15));
        labelSalario.setBounds(100, 120, 500, 20);
        labelSalario.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(labelSalario);

        JLabel subtitleSalario = new JLabel("R$ " + String.format("%.2f", valores[0]));
        subtitleSalario.setFont(new Font("Arial", Font.BOLD, 12));
        subtitleSalario.setBounds(100, 140, 500, 20);
        subtitleSalario.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(subtitleSalario);

        JLabel labelImposto = new JLabel("Total de Impostos de Renda Retidos");
        labelImposto.setFont(new Font("Arial", Font.BOLD, 15));
        labelImposto.setBounds(100, 180, 500, 20);
        labelImposto.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(labelImposto);

        JLabel subtitleImposto = new JLabel("R$ " + String.format("%.2f", valores[1]));
        subtitleImposto.setFont(new Font("Arial", Font.BOLD, 12));
        subtitleImposto.setBounds(100, 200, 500, 20);
        subtitleImposto.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(subtitleImposto);

        JLabel labelCusto = new JLabel("Total de Custos com Benefícios");
        labelCusto.setFont(new Font("Arial", Font.BOLD, 15));
        labelCusto.setBounds(100, 240, 500, 20);
        labelCusto.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(labelCusto);

        JLabel subtitleCusto = new JLabel("R$ " + String.format("%.2f", valores[2]));
        subtitleCusto.setFont(new Font("Arial", Font.BOLD, 12));
        subtitleCusto.setBounds(100, 260, 500, 20);
        subtitleCusto.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(subtitleCusto);

        JLabel labelTotal = new JLabel("Custo Total Estimado com Pessoal");
        labelTotal.setFont(new Font("Arial", Font.BOLD, 15));
        labelTotal.setBounds(100, 300, 500, 20);
        labelTotal.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(labelTotal);

        JLabel subtitleTotal = new JLabel("R$ " + String.format("%.2f", valores[3]));
        subtitleTotal.setFont(new Font("Arial", Font.BOLD, 12));
        subtitleTotal.setBounds(100, 320, 500, 20);
        subtitleTotal.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(subtitleTotal);

        JButton botaoVoltar = new JButton("VOLTAR");
        botaoVoltar.setBounds(50, 400, 100, 30);
        panel.add(botaoVoltar);

        botaoVoltar.addActionListener(e -> {
            switch (setorLogin) {
                case "GERENTE":
                    new MenuCaixa(empresa, setorLogin);
                    break;
                case "GESTÃO DE PESSOAS":
                    new MenuGDP(empresa, setorLogin);
                    break;
            }
            frame.dispose();
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
