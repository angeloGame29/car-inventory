package br.ufpb.dcx.angelo.SistemaVeiculos.controller;

import br.ufpb.dcx.angelo.SistemaVeiculos.*;
import br.ufpb.dcx.angelo.SistemaVeiculos.gui.windowsSecundarias.JanelaInterna;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VeiculoSearchVsController extends JDialog implements ActionListener {
    private SistemaVeiculo sistema;
    private JanelaInterna janela;

    public VeiculoSearchVsController(SistemaVeiculo sistema, JanelaInterna janela){
        this.sistema = sistema;
        this.janela = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //===================[ JANELA DO ESTOQUE ]===============================
        JDialog dialogSearchVs = new JDialog(this, "", true);
        dialogSearchVs.setTitle("Pesquisar veículos pela marca");
        dialogSearchVs.setSize(650, 570);
        dialogSearchVs.setLocationRelativeTo(null);
        dialogSearchVs.setResizable(true);
        dialogSearchVs.getContentPane().setBackground(Color.decode("#000622"));
        ImageIcon lupa = new ImageIcon("./imgs/iconesDialog/lupa.png");

        //===================[ ELEMENTOS DA JANELA ]=============================
        JLabel tituloCount = new JLabel("PESQUISAR VEÍCULOS:");
        JLabel labelMarca = new JLabel("Digite a marca do veículo:");
        JTextField textMarca = new JTextField();
        JButton botaoPesquisar = new JButton("PESQUISAR", lupa);
        JButton botaoOk = new JButton("OK");

        // Criando JTextArea com rolagem
        JTextArea areaVeiculos = new JTextArea();
        areaVeiculos.setEditable(false);
        //Rolagem do JTextArea
        JScrollPane scrollAreaVeiculo = new JScrollPane(areaVeiculos);
        scrollAreaVeiculo.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollAreaVeiculo.setBounds(120, 200, 410, 250); // Define o tamanho correto
        areaVeiculos.setBackground(Color.decode("#5271ff"));
        areaVeiculos.setForeground(Color.WHITE);
        areaVeiculos.setFont(new Font("Serif",Font.CENTER_BASELINE,16));

        //===================[ ESTILIZAÇÃO DOS ELEMENTOS ]=============================
        tituloCount.setBounds(120, 50, 400, 50);
        tituloCount.setFont(new Font("Serif", Font.BOLD, 30));
        tituloCount.setForeground(Color.WHITE);

        labelMarca.setBounds(120, 120, 250, 25);
        labelMarca.setFont(new Font("Serif", Font.ROMAN_BASELINE, 20));
        labelMarca.setForeground(Color.WHITE);

        textMarca.setBounds(120, 150, 250, 25);
        textMarca.setBackground(Color.decode("#5271ff"));
        textMarca.setBorder(null);
        textMarca.setFont(new Font("Serif", Font.ROMAN_BASELINE, 15));
        textMarca.setForeground(Color.white);

        botaoPesquisar.setBounds(380, 150, 150, 25);
        botaoPesquisar.setBackground(Color.decode("#5271ff"));
        botaoPesquisar.setForeground(Color.WHITE);
        botaoPesquisar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        botaoPesquisar.setFocusable(false);

        botaoOk.setBounds(250, 470, 150, 25);
        botaoOk.setBackground(Color.decode("#5271ff"));
        botaoOk.setForeground(Color.WHITE);
        botaoOk.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        botaoOk.setFocusable(false);
        botaoOk.addActionListener(d-> dispose());

        //============================[ PEGADOR DE DADOS ]================================
        botaoPesquisar.addActionListener(p -> {
            String marca = textMarca.getText().trim();

            if (marca.isEmpty()) {
                JOptionPane.showMessageDialog(dialogSearchVs, "Preencha o campo obrigatório!");
                return;
            }

            //============================[ TRATAR + PESQUISAR ]================================
            try {
                    List<Veiculo> resultado = sistema.pesquisarVeiculos(marca);
                    areaVeiculos.setText("VEÍCULOS ENCONTRADOS:\n"+"\n"+resultado.toString());
            } catch (VeiculoInexistenteException ex) {
                areaVeiculos.setText("Nenhum veículo encontrado para a marca: " + marca);
            }
        });

        //===================[ ADD A JANELA ]=============================
        dialogSearchVs.setLayout(null);
        dialogSearchVs.add(tituloCount);
        dialogSearchVs.add(labelMarca);
        dialogSearchVs.add(textMarca);
        dialogSearchVs.add(botaoPesquisar);
        dialogSearchVs.add(botaoOk);
        dialogSearchVs.add(scrollAreaVeiculo); //adiciona o JScrollPane, não o JTextArea

        dialogSearchVs.setVisible(true);
    }
}
