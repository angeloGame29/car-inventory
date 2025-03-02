package br.ufpb.dcx.angelo.SistemaVeiculos.controller;

import br.ufpb.dcx.angelo.SistemaVeiculos.MeuSistemaVeiculo;
import br.ufpb.dcx.angelo.SistemaVeiculos.SistemaVeiculo;
import br.ufpb.dcx.angelo.SistemaVeiculos.gui.windowsSecundarias.JanelaInterna;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class VeiculoSaveController implements ActionListener {
    private SistemaVeiculo veiculo;
    private JanelaInterna janela;

    public VeiculoSaveController(SistemaVeiculo veiculo, JanelaInterna janela){
        this.veiculo = veiculo;
        this.janela = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            veiculo.salvarVeiculo();
            JOptionPane.showMessageDialog(null,"Seus dados foram salvos com sucesso!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"Seus dados não foram salvos!");
        }
    }
}
