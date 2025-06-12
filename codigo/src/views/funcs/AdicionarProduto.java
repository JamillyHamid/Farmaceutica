package views.funcs;

import javax.swing.*;

import sistema.Empresa;
import sistema.Produto;
import views.MenuEstoque;

import java.awt.*;

public class AdicionarProduto {
    public AdicionarProduto(Empresa empresa) {
        JFrame frame = new JFrame("Sistema Farmacêutico");

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label = new JLabel("CADASTRAR PRODUTO");
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setBounds(100, 30, 500, 20);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label);

        JLabel subtitle = new JLabel("ALMOXARIFADO");
        subtitle.setFont(new Font("Arial", Font.BOLD, 10));
        subtitle.setBounds(100, 45, 500, 20);
        subtitle.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(subtitle);

        JLabel labelNome = new JLabel("Informe o nome do produto:");
        labelNome.setBounds(180, 100, 350, 20);
        panel.add(labelNome);

        JTextField textFieldNome = new JTextField();
        textFieldNome.setBounds(350, 100, 150, 25);
        panel.add(textFieldNome);

        JLabel labelValorCompra = new JLabel("Informe o valor da compra:");
        labelValorCompra.setBounds(180, 150, 350, 20);
        panel.add(labelValorCompra);

        JTextField textFieldValorCompra = new JTextField();
        textFieldValorCompra.setBounds(350, 150, 150, 25);
        panel.add(textFieldValorCompra);

        JLabel labelValorVenda = new JLabel("Informe o valor da venda:");
        labelValorVenda.setBounds(180, 200, 350, 20);
        panel.add(labelValorVenda);

        JTextField textFieldValorVenda = new JTextField();
        textFieldValorVenda.setBounds(350, 200, 150, 25);
        panel.add(textFieldValorVenda);

        JLabel labelQtd = new JLabel("Informe a quantidade:");
        labelQtd.setBounds(180, 250, 350, 20);
        panel.add(labelQtd);

        JTextField textFieldQtd = new JTextField();
        textFieldQtd.setBounds(350, 250, 150, 25);
        panel.add(textFieldQtd);

        JButton botaoSair = new JButton("VOLTAR");
        botaoSair.setBounds(50, 400, 100, 30);
        panel.add(botaoSair);

        JButton botaoSalvar = new JButton("SALVAR");
        botaoSalvar.setBounds(550, 400, 100, 30);
        panel.add(botaoSalvar);

        botaoSair.addActionListener(e -> {
            new MenuEstoque(empresa);
            frame.dispose();
        });

        botaoSalvar.addActionListener(e -> {
            empresa.adicionarProduto(
                    new Produto(textFieldNome.getText(), Double.parseDouble(textFieldValorCompra.getText()),
                            Double.parseDouble(textFieldValorVenda.getText()),
                            Integer.parseInt(textFieldQtd.getText())));
            frame.dispose();
            new MenuEstoque(empresa);
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
