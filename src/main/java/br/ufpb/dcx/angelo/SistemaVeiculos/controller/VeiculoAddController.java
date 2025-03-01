package br.ufpb.dcx.angelo.SistemaVeiculos.controller;

import br.ufpb.dcx.angelo.SistemaVeiculos.*;
import br.ufpb.dcx.angelo.SistemaVeiculos.windows.wSecundarias.JanelaInterna;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VeiculoAddController implements ActionListener {
    private SistemaVeiculo veiculo;
    private JanelaInterna janelaPrincipal;

    public VeiculoAddController(SistemaVeiculo veiculo, JanelaInterna janela) {
        this.veiculo = veiculo;
        this.janelaPrincipal = janela;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        TipoVeiculo tipoVeiculo;
        Object carroOuMoto [] = {"CARRO", "MOTO"};
        var opcoesDeTipo = JOptionPane.showOptionDialog(null,"Escolha um tipo de veiculo:","AVISO!", 0,2,null, carroOuMoto, carroOuMoto[0]);
        if(opcoesDeTipo==0) {
            tipoVeiculo = TipoVeiculo.CARRO;
            String marca = JOptionPane.showInputDialog("Digite a marca do carro:");
            String modelo = JOptionPane.showInputDialog("Digite o modelo:");
            int ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano:"));
            String codigo = JOptionPane.showInputDialog("Digite o codigo veiculo:");
            int portas = Integer.parseInt(JOptionPane.showInputDialog("Digite quantas portas ele possui:"));
            boolean automatico;
            int tipoAouM = JOptionPane.showConfirmDialog(null,"O carro é automatico:");
            if (tipoAouM==0) {
                automatico = true;
            }else{
                automatico = false;
            }
            Veiculo carroC = new Carro(tipoVeiculo, marca, modelo, ano, codigo, portas, automatico);
            try {
                veiculo.cadastrarVeiculo(carroC);
                JOptionPane.showMessageDialog(null,"Carro cadastrado com sucesso!");
            } catch (VeiculoJaExisteException ee){
                JOptionPane.showMessageDialog(null,"Carro não cadastrado","ops",JOptionPane.ERROR_MESSAGE);
            }
        }else if (opcoesDeTipo==1) {
            tipoVeiculo = TipoVeiculo.MOTO;
            String marca = JOptionPane.showInputDialog("Digite a marca da moto:");
            String modelo = JOptionPane.showInputDialog("Digite o modelo:");
            int ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano:"));
            String codigo = JOptionPane.showInputDialog("Digite o codigo veiculo:");
            boolean possuiEmbreagem;
            int embragem = JOptionPane.showConfirmDialog(null,"A moto possui embreagem:");
            if (embragem==0) {
                possuiEmbreagem = true;
            }else{
                possuiEmbreagem = false;
            }
            Veiculo moto = new Moto(tipoVeiculo,marca,modelo,ano,codigo,possuiEmbreagem);
            try{
                veiculo.cadastrarVeiculo(moto);
                JOptionPane.showMessageDialog(null,"Moto cadastrada com sucesso!");
            }catch (VeiculoJaExisteException ee){
                JOptionPane.showMessageDialog(null,"Moto não cadastrada","ops",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
