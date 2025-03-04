package br.ufpb.dcx.angelo.SistemaVeiculos.controller;

import br.ufpb.dcx.angelo.SistemaVeiculos.SistemaVeiculo;
import br.ufpb.dcx.angelo.SistemaVeiculos.Veiculo;
import br.ufpb.dcx.angelo.SistemaVeiculos.VeiculoInexistenteException;
import br.ufpb.dcx.angelo.SistemaVeiculos.gui.windowsSecundarias.JanelaInterna;

import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VeiculoSearchController extends JDialog implements ActionListener {
    private SistemaVeiculo sistema;
    private JanelaInterna janela;

    public VeiculoSearchController(SistemaVeiculo sistema, JanelaInterna janela){
        this.sistema = sistema;
        this.janela = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //===================[ JANELA DO ESTOQUE ]===============================
        JDialog dialogSearch = new JDialog(this, "", true);
        dialogSearch.setTitle("Pesquisar veículos pela marca");
        dialogSearch.setSize(650, 570);
        dialogSearch.setLocationRelativeTo(null);
        dialogSearch.setResizable(true);
        dialogSearch.getContentPane().setBackground(Color.decode("#000622"));
        ImageIcon lupa = new ImageIcon("./imgs/iconesDialog/lupa.png");

        //===================[ ELEMENTOS DA JANELA ]=============================
        JLabel tituloCount = new JLabel("PESQUISAR VEÍCULO:");
        JLabel labelCodigo = new JLabel("Digite o código do veículo:");
        JTextField textCodigo = new JTextField();
        JButton botaoPesquisar = new JButton("PESQUISAR", lupa);
        JButton botaoOk = new JButton("OK");
        JTextArea areaVeiculos = new JTextArea();
        areaVeiculos.setEditable(false);

        //===================[ ESTILIZAÇÃO DOS ELEMENTOS ]=============================
        tituloCount.setBounds(120, 50, 400, 50);
        tituloCount.setFont(new Font("Serif", Font.BOLD, 30));
        tituloCount.setForeground(Color.WHITE);

        labelCodigo.setBounds(120, 120, 250, 25);
        labelCodigo.setFont(new Font("Serif", Font.ROMAN_BASELINE, 20));
        labelCodigo.setForeground(Color.WHITE);

        textCodigo.setBounds(120, 150, 250, 25);
        textCodigo.setBackground(Color.decode("#5271ff"));
        textCodigo.setBorder(null);
        textCodigo.setFont(new Font("Serif", Font.ROMAN_BASELINE, 15));
        textCodigo.setForeground(Color.white);

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

        areaVeiculos.setBounds(120, 200, 410, 250);
        areaVeiculos.setBackground(Color.decode("#5271ff"));
        areaVeiculos.setForeground(Color.WHITE);
        areaVeiculos.setFont(new Font("Serif",Font.CENTER_BASELINE,16));

        //============================[ PEGADOR DE DADOS ]================================
        botaoPesquisar.addActionListener(p -> {
            String codigo = textCodigo.getText().trim();

            if (codigo.isEmpty()) {
                JOptionPane.showMessageDialog(dialogSearch, "Preencha o campo obrigatório!");
                return;
            }

            //============================[ TRATAR + PESQUISAR ]================================
            try {
                    Veiculo resultado = sistema.pesquisarVeiculo(codigo);
                    areaVeiculos.setText("VEÍCULOS ENCONTRADOS:\n"+"\n"+resultado.toString());
            } catch (VeiculoInexistenteException ex) {
                areaVeiculos.setText("Nenhum veículo encontrado para a codigo: " + codigo);
            }
        });

        //===================[ ADD A JANELA ]=============================
        dialogSearch.setLayout(null);
        dialogSearch.add(tituloCount);
        dialogSearch.add(labelCodigo);
        dialogSearch.add(textCodigo);
        dialogSearch.add(botaoPesquisar);
        dialogSearch.add(botaoOk);
        dialogSearch.add(areaVeiculos);

        dialogSearch.setVisible(true);
    }
}
