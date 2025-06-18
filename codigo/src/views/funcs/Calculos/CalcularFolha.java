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

        JLabel labelSalario = new JLabel("Total de Salários Líquidos Pagos: R$ " + String.format("%.2f", valores[0]));
        labelSalario.setBounds(150, 140, 350, 20);
        panel.add(labelSalario);

        JLabel labelImposto = new JLabel("Total de Impostos de Renda Retidos: R$" + String.format("%.2f", valores[1]));
        labelImposto.setBounds(150, 180, 350, 20);
        panel.add(labelImposto);

        JLabel labelCusto = new JLabel(
                "Total de Custos com Benefícios (Empresa): R$" + String.format("%.2f", valores[2]));
        labelCusto.setBounds(150, 220, 350, 20);
        panel.add(labelCusto);

        JLabel labelTotal = new JLabel(
                "Custo Total Estimado com Pessoal (Salário Base + Benefícios): R$"
                        + String.format("%.2f", valores[3]));
        labelTotal.setBounds(150, 260, 450, 20);
        panel.add(labelTotal);

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
