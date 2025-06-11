package views.funcs;

import javax.swing.*;
import java.awt.*;
import sistema.Empresa;
import views.MenuFuncionarios;
import views.MenuGDP;

public class CalcularFolha {
    public CalcularFolha(Empresa empresa) {
        JFrame frame = new JFrame("Sistema Farmacêutico");

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label = new JLabel("CALCULAR FOLHA DE PAGAMENTO");
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setBounds(200, 30, 350, 20);
        panel.add(label);

        JLabel subtitle = new JLabel("GESTÃO DE PESSOAS");
        subtitle.setFont(new Font("Arial", Font.BOLD, 10));
        subtitle.setBounds(295, 45, 200, 20);
        panel.add(subtitle);

        double[] valores = empresa.calcularFolhaDePagamentoDetalhada();

        JLabel labelSalario = new JLabel("Total de Salários Líquidos Pagos: R$ " + String.format("%.2f", valores[0]));
        labelSalario.setBounds(150, 100, 350, 20);
        panel.add(labelSalario);

        JLabel labelImposto = new JLabel("Total de Impostos de Renda Retidos: R$" + String.format("%.2f", valores[1]));
        labelImposto.setBounds(150, 170, 350, 20);
        panel.add(labelImposto);

        JLabel labelCusto = new JLabel(
                "Total de Custos com Benefícios (Empresa): R$" + String.format("%.2f", valores[2]));
        labelCusto.setBounds(150, 240, 350, 20);
        panel.add(labelCusto);

        JLabel labelTotal = new JLabel(
                "Custo Total Estimado com Pessoal (Salário Base + Benefícios): R$"
                        + String.format("%.2f", valores[3]));
        labelTotal.setBounds(150, 310, 450, 20);
        panel.add(labelTotal);

        JButton botaoSair = new JButton("VOLTAR");
        botaoSair.setBounds(305, 400, 100, 30);
        panel.add(botaoSair);

        botaoSair.addActionListener(e -> {
            new MenuGDP(empresa);
            frame.dispose();
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
