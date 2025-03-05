package br.ufpb.dcx.angelo.SistemaVeiculos.controller;

import br.ufpb.dcx.angelo.SistemaVeiculos.SistemaVeiculo;
import br.ufpb.dcx.angelo.SistemaVeiculos.Veiculo;
import br.ufpb.dcx.angelo.SistemaVeiculos.VeiculoInexistenteException;
import br.ufpb.dcx.angelo.SistemaVeiculos.gui.windowsSecundarias.JanelaInterna;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VeiculoRemoveController extends JDialog implements ActionListener {
    private SistemaVeiculo sistema;
    private JanelaInterna janela;

    public VeiculoRemoveController(SistemaVeiculo sistema, JanelaInterna janela){
        this.sistema = sistema;
        this.janela = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //===================[ JANELA DO ESTOQUE ]===============================
        JDialog dialogRemove = new JDialog(this, "", true);
        dialogRemove.setTitle("Remover Veículo");
        dialogRemove.setSize(650, 570);
        dialogRemove.setLocationRelativeTo(null);
        dialogRemove.setResizable(true);
        dialogRemove.getContentPane().setBackground(Color.decode("#000622"));
        ImageIcon lupa = new ImageIcon("./imgs/iconesDialog/lupa.png");

        //===================[ ELEMENTOS DA JANELA ]=============================
        JLabel tituloCount = new JLabel("Remover veículo:");
        JLabel labelCodigo = new JLabel("Digite o código do veículo:");
        JTextField textCodigo = new JTextField();
        JButton botaoPesquisar = new JButton("VERIFICAR", lupa);
        JButton botaoOk = new JButton("OK");
        JButton botaoRemove = new JButton("REMOVER");
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

        botaoOk.setBounds(250, 480, 150, 25);
        botaoOk.setBackground(Color.decode("#5271ff"));
        botaoOk.setForeground(Color.WHITE);
        botaoOk.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        botaoOk.setFocusable(false);
        botaoOk.addActionListener(d-> dispose());

        botaoRemove.setBounds(250, 445, 150, 25);
        botaoRemove.setBackground(Color.decode("#5271ff"));
        botaoRemove.setForeground(Color.WHITE);
        botaoRemove.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        botaoRemove.setFocusable(false);

        areaVeiculos.setBounds(120, 185, 410, 250);
        areaVeiculos.setBackground(Color.decode("#5271ff"));
        areaVeiculos.setForeground(Color.WHITE);
        areaVeiculos.setFont(new Font("Serif",Font.CENTER_BASELINE,16));

        //============================[ PEGADOR DE DADOS ]================================
        botaoPesquisar.addActionListener(p -> {
            String codigo = textCodigo.getText().trim();

            if (codigo.isEmpty()) {
                JOptionPane.showMessageDialog(dialogRemove, "Preencha o campo obrigatório!");
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
        botaoRemove.addActionListener(r-> {
            String codigo = textCodigo.getText().trim();

            if (codigo.isEmpty()) {
                JOptionPane.showMessageDialog(dialogRemove, "Preencha o campo obrigatório!");
                return;
            }
            try{
                sistema.removeVeiculo(codigo);
                areaVeiculos.setText("Veiculo do codigo: ["+codigo+"] Removido com sucesso!");
            } catch (VeiculoInexistenteException ex) {
                areaVeiculos.setText(ex.getMessage());
            }
        });

        //===================[ ADD A JANELA ]=============================
        dialogRemove.setLayout(null);
        dialogRemove.add(tituloCount);
        dialogRemove.add(labelCodigo);
        dialogRemove.add(textCodigo);
        dialogRemove.add(botaoPesquisar);
        dialogRemove.add(botaoOk);
        dialogRemove.add(botaoRemove);
        dialogRemove.add(areaVeiculos);

        dialogRemove.setVisible(true);
    }
}
