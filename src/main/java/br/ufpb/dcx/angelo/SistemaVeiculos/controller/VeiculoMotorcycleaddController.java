package br.ufpb.dcx.angelo.SistemaVeiculos.controller;

import br.ufpb.dcx.angelo.SistemaVeiculos.SistemaVeiculo;
import br.ufpb.dcx.angelo.SistemaVeiculos.gui.windowsSecundarias.JanelaInterna;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VeiculoMotorcycleaddController extends JDialog implements ActionListener {
    private SistemaVeiculo veiculo;
    private JanelaInterna janelaInterna;

    public VeiculoMotorcycleaddController(SistemaVeiculo veiculo, JanelaInterna janela){
        this.veiculo = veiculo;
        this.janelaInterna = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
