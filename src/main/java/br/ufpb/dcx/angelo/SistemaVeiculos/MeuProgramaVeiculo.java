package br.ufpb.dcx.angelo.SistemaVeiculos;

import javax.swing.*;
import java.io.IOException;

public class MeuProgramaVeiculo {
    public static void main (String [] args){
        MeuSistemaVeiculo sistema = new MeuSistemaVeiculo();
        try{
            sistema.recuperaVeiculo();
            JOptionPane.showMessageDialog(null,"Tudo okay!\nSeus veiculos foram restaurados com sucesso!");
        } catch (IOException e){
            JOptionPane.showMessageDialog(null,"Falha! Veiculos não recuperados! :(","ops",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        boolean permanecer = true;
        while (permanecer){
            String opcao = JOptionPane.showInputDialog(null,"Escolha uma dessas opções: "+
                    "\n1 - Cadastrar Veiculo" +
                    "\n2 - Pesquisar por Veiculo" +
                    "\n3 - Salvar Veiculos" +
                    "\n4 - Sair","MENU",JOptionPane.QUESTION_MESSAGE);

            switch (opcao){
                case "1"://cadastrar o veiculo
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
                            sistema.cadastrarVeiculo(carroC);
                            JOptionPane.showMessageDialog(null,"Carro cadastrado com sucesso!");
                        } catch (VeiculoJaExisteException e){
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
                            sistema.cadastrarVeiculo(moto);
                            JOptionPane.showMessageDialog(null,"Moto cadastrada com sucesso!");
                        }catch (VeiculoJaExisteException e){
                            JOptionPane.showMessageDialog(null,"Moto não cadastrada","ops",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;

                case "2":// pesquisar veiculo
                    String codigo = JOptionPane.showInputDialog("Digite o codigo do veiculo:");
                    try{
                    Veiculo veiculoPesquisado = sistema.pesquisarVeiculo(codigo);
                        JOptionPane.showMessageDialog(null,veiculoPesquisado.toString());
                    }catch (VeiculoInexistenteException e){
                        JOptionPane.showMessageDialog(null, "Veiculo inexitente!","ops",JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case "3"://Salvar o veiculos
                    try{
                        sistema.salvarVeiculo();
                        JOptionPane.showMessageDialog(null,"Seus dados foram salvos com sucesso!");
                    }catch (IOException e){
                        JOptionPane.showMessageDialog(null,"Seus dados não foram salvos!");
                    }
                    break;

                case "4"://sair
                    Object [] options = {"SIM","VOLTAR"};
                    var escolha = JOptionPane.showOptionDialog(null,"Você deseja mesmo sair?","AVISO!",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                            null, options, options[0]);
                    if(escolha==0) {
                        permanecer = false;
                        break;
                    }else{
                        permanecer = true;
                        break;
                    }
            }
        }



    }
}
