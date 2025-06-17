package views.funcs.NegocioAndamento;

import java.awt.*;
import javax.swing.*;

import sistema.Empresa;
import views.MenuNegocio;
import views.AMX.MenuAMX;
import views.ATC.MenuATC;
import views.VND.MenuVND;

public class ListarNegocioAndamento {
    public ListarNegocioAndamento(Empresa empresa, String setorLogin) {
        JFrame frame = new JFrame("Sistema Farmacêutico");

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label = new JLabel("LISTAR NEGÓCIOS EM ANDAMENTO");
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setBounds(100, 30, 500, 20);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label);

        JLabel subtitle = new JLabel(setorLogin);
        subtitle.setFont(new Font("Arial", Font.BOLD, 10));
        subtitle.setBounds(100, 45, 500, 20);
        subtitle.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(subtitle);

        JButton botaoVoltar = new JButton("VOLTAR");
        botaoVoltar.setBounds(50, 400, 100, 30);
        panel.add(botaoVoltar);

        botaoVoltar.addActionListener(e -> {
            switch (setorLogin) {
                case "GERENTE":
                    new MenuNegocio(empresa, setorLogin);
                    break;
                case "ATENDIMENTO AO CLIENTE":
                    new MenuATC(empresa, setorLogin);
                    break;
                case "VENDAS":
                    new MenuVND(empresa, setorLogin);
                    break;
                case "ALMOXARIFADO":
                    new MenuAMX(empresa, setorLogin);
                    break;
            }
            frame.dispose();
        });

        frame.add(panel);
        frame.setVisible(true);
    }
}
