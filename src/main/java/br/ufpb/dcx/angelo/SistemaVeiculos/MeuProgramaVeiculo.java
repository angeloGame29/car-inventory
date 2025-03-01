package br.ufpb.dcx.angelo.SistemaVeiculos;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

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
            String[] opcoes = {
                    "Cadastrar Veículo",
                    "Pesquisar por Veículo",
                    "Pesquisar Veículos por Marca",
                    "Atualizar Veículo",
                    "Quantidade de Carros no Inventário",
                    "Salvar Veículos","Remover Veiculo",
                    "Sair"
            };

            String listaMenu = (String) JOptionPane.showInputDialog(
                    null, "Escolha uma opção:", "MENU",
                    JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]
            );
            switch (listaMenu){
                case "Cadastrar Veículo"://cadastrar o veiculo
                    TipoVeiculo tipoVeiculo;
                    Object carroOuMoto [] = {"CARRO", "MOTO"};
                    var opcoesDeTipo = JOptionPane.showOptionDialog(null,"Escolha um tipo de veiculo:","AVISO!", 0,2,null, carroOuMoto, carroOuMoto[0]);
                    if(opcoesDeTipo==0) {
                        tipoVeiculo = TipoVeiculo.CARRO;
                            String estadoCarro = JOptionPane.showInputDialog("Digite o estado do carro (NOVO/USADO):");
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
                            Veiculo carroC = new Carro(tipoVeiculo, estadoCarro, marca, modelo, ano, codigo, portas, automatico);
                        try {
                            sistema.cadastrarVeiculo(carroC);
                            JOptionPane.showMessageDialog(null,"Carro cadastrado com sucesso!");
                        } catch (VeiculoJaExisteException e){
                            JOptionPane.showMessageDialog(null,"Carro não cadastrado","ops",JOptionPane.ERROR_MESSAGE);
                        }
                    }else if (opcoesDeTipo==1) {
                        tipoVeiculo = TipoVeiculo.MOTO;
                        String estadoMoto = JOptionPane.showInputDialog("Digite o estado da moto (NOVO/USADO):");
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
                        Veiculo moto = new Moto(tipoVeiculo,estadoMoto,marca,modelo,ano,codigo,possuiEmbreagem);
                        try{
                            sistema.cadastrarVeiculo(moto);
                            JOptionPane.showMessageDialog(null,"Moto cadastrada com sucesso!");
                        }catch (VeiculoJaExisteException e){
                            JOptionPane.showMessageDialog(null,"Moto não cadastrada","ops",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;

                case "Pesquisar por Veículo":// pesquisar veiculo
                    String codigo = JOptionPane.showInputDialog("Digite o codigo do veiculo:");
                    try{
                    Veiculo veiculoPesquisado = sistema.pesquisarVeiculo(codigo);
                        JOptionPane.showMessageDialog(null,veiculoPesquisado.toString());
                    }catch (VeiculoInexistenteException e){
                        JOptionPane.showMessageDialog(null,e.getMessage());                    }
                    break;
                case "Pesquisar Veículos por Marca"://Pesquisar Veiculos por marca
                    String marcaVeiculo = JOptionPane.showInputDialog("Digite uma marca de veiculos:");
                    try{
                        List<Veiculo> veiculosNaLista = sistema.pesquisarVeiculos(marcaVeiculo);
                        JOptionPane.showMessageDialog(null, "Veiculos da marca: "+marcaVeiculo+"\n"+veiculosNaLista.toString());
                    }catch (VeiculoInexistenteException e){
                        JOptionPane.showMessageDialog(null,e.getMessage());
                    }
                    break;
                case "Atualizar Veículo"://Atualizar Veiculo
                    String codigoVeiculo = JOptionPane.showInputDialog("Digite o codigo do veiculo:");
                    String novoModelo = JOptionPane.showInputDialog("Digite o novo modelo do veiculo:");
                    int novoAno = Integer.parseInt(JOptionPane.showInputDialog("Digite o novo ano do veiculo:"));
                    try{
                        sistema.atualizarVeiculo(codigoVeiculo,novoModelo,novoAno);
                        Veiculo carroAtualizado = sistema.pesquisarVeiculo(codigoVeiculo);
                        JOptionPane.showMessageDialog(null, "Veiculo:\n"+carroAtualizado.toString()+"\nAtualizado com sucesso!");
                    }catch (VeiculoInexistenteException e){
                        JOptionPane.showMessageDialog(null,e.getMessage());
                    }
                    break;

                case "Quantidade de Carros no Inventário"://quantidade de veiculos em estoque
                    int quantidade = sistema.quantidadeDeVeiculosEmEstoque();
                    JOptionPane.showMessageDialog(null,"A quantidade de veiculos em estoque é: "+quantidade);
                    break;

                case "Salvar Veículos"://Salvar o veiculos
                    try{
                        sistema.salvarVeiculo();
                        JOptionPane.showMessageDialog(null,"Seus dados foram salvos com sucesso!");
                    }catch (IOException e){
                        JOptionPane.showMessageDialog(null,"Seus dados não foram salvos!");
                    }
                    break;
                case "Remover Veiculo":
                    String codigoDoVeiculo = JOptionPane.showInputDialog("Digite o codigo do veiculo a ser removido:");
                    try{
                        sistema.removeVeiculo(codigoDoVeiculo);
                        JOptionPane.showMessageDialog(null, "Veiculo do codigo: ["+codigoDoVeiculo+"] Removido com sucesso!");
                    }catch (VeiculoInexistenteException e){
                        JOptionPane.showMessageDialog(null,e.getMessage());
                    }
                    break;

                case "Sair"://sair
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
