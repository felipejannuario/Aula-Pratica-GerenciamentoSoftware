package AulaPratica1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InterfaceGrafica extends JFrame {
    private JTextField campoCodigo, campoFuncionalidade, campoUsabilidade;
    private JButton botaoCalcular, botaoSair;
    private JLabel resultadoLabel;

    public InterfaceGrafica() {
        setTitle("Avaliador de Qualidade de Software");
        setSize(400, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        add(new JLabel("Código (0-10):"));
        campoCodigo = new JTextField(10);
        add(campoCodigo);

        add(new JLabel("Funcionalidade (0-10):"));
        campoFuncionalidade = new JTextField(10);
        add(campoFuncionalidade);

        add(new JLabel("Usabilidade (0-10):"));
        campoUsabilidade = new JTextField(10);
        add(campoUsabilidade);

        botaoCalcular = new JButton("Calcular Média");
        add(botaoCalcular);

        botaoSair = new JButton("Sair");
        add(botaoSair);

        resultadoLabel = new JLabel("");
        resultadoLabel.setPreferredSize(new Dimension(360, 25));
        add(resultadoLabel);

        botaoCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double cod = Double.parseDouble(campoCodigo.getText());
                    double func = Double.parseDouble(campoFuncionalidade.getText());
                    double usa = Double.parseDouble(campoUsabilidade.getText());
                    double media = (cod + func + usa) / 3;

                    resultadoLabel.setText("Média de qualidade: " + String.format("%.2f", media));
                } catch (NumberFormatException ex) {
                    resultadoLabel.setText("Insira valores válidos (0-10)!");
                }
            }
        });

        botaoSair.addActionListener(e -> System.exit(0));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InterfaceGrafica janela = new InterfaceGrafica();
            janela.setLocationRelativeTo(null);
            janela.setVisible(true);
        });
    }
}
