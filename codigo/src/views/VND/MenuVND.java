package views.VND;

import javax.swing.*;

import sistema.Empresa;
import views.Login;
import views.funcs.NegocioAndamento.AtualizarStatusNegocio;
import views.funcs.NegocioAndamento.ListarNegocioAndamento;
import views.funcs.Produto.ListarTodosProdutos;
import views.funcs.Registrar.RegistrarVenda;
import views.funcs.Transportadora.ListarTransportadora;

import java.awt.*;

public class MenuVND {
    // 1. XXXXX Registrar Venda
    // 2. Atualizar Status de Negócio
    // 3. Listar Negócios em Andamento
    // 4. XXXXX Listar Produtos em Estoque
    // 5. XXXXX Listar Transportadoras Parceiras
    public MenuVND(Empresa empresa, String setorLogin) {

        JFrame frame = new JFrame("Sistema Farmacêutico");

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JButton botaoLogout = new JButton();
        botaoLogout.setBounds(20, 20, 20, 20);
        panel.add(botaoLogout);

        botaoLogout.addActionListener(e -> {
            new Login(empresa);
            frame.dispose();
        });

        JLabel label = new JLabel("MENU GERAL");
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setBounds(100, 30, 500, 20);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label);

        JLabel subtitle = new JLabel(setorLogin);
        subtitle.setFont(new Font("Arial", Font.BOLD, 10));
        subtitle.setBounds(100, 45, 500, 20);
        subtitle.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(subtitle);

        int larguraBotao = 250;
        int alturaBotao = 30;
        int margemLateral = 225;

        JButton botao1 = new JButton("Atualizar Status de Negócio");
        botao1.setBounds(margemLateral, 85, larguraBotao, alturaBotao);
        panel.add(botao1);

        JButton botao2 = new JButton("Listar Negócios em Andamento");
        botao2.setBounds(margemLateral, 145, larguraBotao, alturaBotao);
        panel.add(botao2);

        JButton botao3 = new JButton("Listar Produtos em Estoque");
        botao3.setBounds(margemLateral, 205, larguraBotao, alturaBotao);
        panel.add(botao3);

        JButton botao4 = new JButton("Listar Transportadoras Parceiras");
        botao4.setBounds(margemLateral, 265, larguraBotao, alturaBotao);
        panel.add(botao4);

        JButton botao5 = new JButton("Registrar Venda");
        botao5.setBounds(margemLateral, 325, larguraBotao, alturaBotao);
        panel.add(botao5);

        botao1.addActionListener(e -> {
            new AtualizarStatusNegocio(empresa, setorLogin);
            frame.dispose();
        });
        botao2.addActionListener(e -> {
            new ListarNegocioAndamento(empresa, setorLogin);
            frame.dispose();
        });
        botao3.addActionListener(e -> {
            new ListarTodosProdutos(empresa, setorLogin);
            frame.dispose();
        });
        botao4.addActionListener(e -> {
            new ListarTransportadora(empresa, setorLogin);
            frame.dispose();
        });
        botao5.addActionListener(e -> {
            new RegistrarVenda(empresa, setorLogin);
            frame.dispose();
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
