package br.ufpb.dcx.angelo.SistemaVeiculos.controller;

import br.ufpb.dcx.angelo.SistemaVeiculos.SistemaVeiculo;
import br.ufpb.dcx.angelo.SistemaVeiculos.Veiculo;
import br.ufpb.dcx.angelo.SistemaVeiculos.VeiculoInexistenteException;
import br.ufpb.dcx.angelo.SistemaVeiculos.gui.windowsSecundarias.JanelaInterna;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VeiculoUpdateController extends JDialog implements ActionListener {
    private SistemaVeiculo sistema;
    private JanelaInterna janela;

    public VeiculoUpdateController(SistemaVeiculo sistema, JanelaInterna janela){
        this.sistema = sistema;
        this.janela = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //===================[ JANELA DO ESTOQUE ]===============================
        JDialog dialogUpdate = new JDialog(this, "", true);
        dialogUpdate.setTitle("Atualizar Veículo");
        dialogUpdate.setSize(650, 570);
        dialogUpdate.setLocationRelativeTo(null);
        dialogUpdate.setResizable(true);
        dialogUpdate.getContentPane().setBackground(Color.decode("#000622"));
        ImageIcon lupa = new ImageIcon("./imgs/iconesDialog/lupa.png");

        //===================[ ELEMENTOS DA JANELA ]=============================
        JLabel tituloCount = new JLabel("Atualizar veículo:");
        JLabel labelCodigo = new JLabel("Digite o código do veículo:");
        JTextField textCodigo = new JTextField();
        JButton botaoPesquisar = new JButton("VERIFICAR", lupa);
        JButton botaoOk = new JButton("OK");
        JButton botaoUpdate = new JButton("ATUALIZAR");
        JTextArea areaVeiculos = new JTextArea();
        areaVeiculos.setEditable(false);
        JLabel labelModelo = new JLabel("Digite o novo modelo:");
        JTextField textModeloNovo = new JTextField();
        JLabel labelAno = new JLabel("Digite o novo ano:");
        JTextField textAnoNovo = new JTextField();

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

        labelModelo.setBounds(380, 185, 150, 25);
        labelModelo.setFont(new Font("Serif", Font.ROMAN_BASELINE, 14));
        labelModelo.setForeground(Color.WHITE);

        textModeloNovo.setBounds(380, 208, 150, 25);
        textModeloNovo.setBackground(Color.decode("#5271ff"));
        textModeloNovo.setBorder(null);
        textModeloNovo.setFont(new Font("Serif", Font.ROMAN_BASELINE, 15));
        textModeloNovo.setForeground(Color.white);

        labelAno.setBounds(380, 235, 150, 25);
        labelAno.setFont(new Font("Serif", Font.ROMAN_BASELINE, 14));
        labelAno.setForeground(Color.WHITE);

        textAnoNovo.setBounds(380, 258, 150, 25);
        textAnoNovo.setBackground(Color.decode("#5271ff"));
        textAnoNovo.setBorder(null);
        textAnoNovo.setFont(new Font("Serif", Font.ROMAN_BASELINE, 15));
        textAnoNovo.setForeground(Color.white);

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

        botaoUpdate.setBounds(250, 445, 150, 25);
        botaoUpdate.setBackground(Color.decode("#5271ff"));
        botaoUpdate.setForeground(Color.WHITE);
        botaoUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        botaoUpdate.setFocusable(false);

        areaVeiculos.setBounds(120, 185, 250, 250);
        areaVeiculos.setBackground(Color.decode("#5271ff"));
        areaVeiculos.setForeground(Color.WHITE);
        areaVeiculos.setFont(new Font("Serif",Font.CENTER_BASELINE,16));


        //============================[ PEGADOR DE DADOS ]================================
        botaoPesquisar.addActionListener(p -> {
            String codigo = textCodigo.getText().trim();

            if (codigo.isEmpty()) {
                JOptionPane.showMessageDialog(dialogUpdate, "Falha na pesquisa: Preencha o campo codigo!");
                return;
            }

            //============================[ TRATAR + PESQUISAR ]================================
            try {
                Veiculo resultado = sistema.pesquisarVeiculo(codigo);
                areaVeiculos.setText(" VEÍCULOS ENCONTRADOS:\n"+"\n"+resultado.toString());
            } catch (VeiculoInexistenteException ex) {
                areaVeiculos.setText(" Nenhum veículo encontrado para\n o codigo: " + codigo);
            }
        });
        botaoUpdate.addActionListener(r-> {
            String codigo = textCodigo.getText().trim();
            String novoModelo = textModeloNovo.getText().trim();
            int novoAno = 0;

            if (codigo.isEmpty()) {
                JOptionPane.showMessageDialog(dialogUpdate, "Falha: campo codigo está vazio!");
                return;
            }

            if (novoModelo.isEmpty()) {
                JOptionPane.showMessageDialog(dialogUpdate, "Falha: O campo modelo está vazio!");
                return;
            }
            if(textAnoNovo.getText().isEmpty()){
                JOptionPane.showMessageDialog(dialogUpdate, "Falha: O campo do ano está vazio!");
            }else {
                try {
                    novoAno = Integer.parseInt(textAnoNovo.getText().trim());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(dialogUpdate, "Erro: O valor inserido não é um número válido!");
                }

                if (novoAno <= 1899) {
                    JOptionPane.showMessageDialog(dialogUpdate, "Ano de veículo não permitido!");
                    return;
                }

                try {
                    sistema.atualizarVeiculo(codigo, novoModelo, novoAno);
                    Veiculo veiculoAtualizado = sistema.pesquisarVeiculo(codigo);
                    areaVeiculos.setText("-VEÍCULO ATUALIZADO:\n" + "\n " + veiculoAtualizado.toString());
                } catch (VeiculoInexistenteException ex) {
                    areaVeiculos.setText(ex.getMessage());
                }
            }
        });

        //===================[ ADD A JANELA ]=============================
        dialogUpdate.setLayout(null);
        dialogUpdate.add(tituloCount);
        dialogUpdate.add(labelCodigo);
        dialogUpdate.add(textCodigo);
        dialogUpdate.add(botaoPesquisar);
        dialogUpdate.add(botaoOk);
        dialogUpdate.add(botaoUpdate);
        dialogUpdate.add(textModeloNovo);
        dialogUpdate.add(textAnoNovo);
        dialogUpdate.add(labelModelo);
        dialogUpdate.add(labelAno);
        dialogUpdate.add(areaVeiculos);

        dialogUpdate.setVisible(true);
    }
}
