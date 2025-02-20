package br.ufpb.dcx.angelo.SistemaVeiculos;

import java.io.IOException;
import java.util.*;

public class MeuSistemaVeiculo implements SistemaVeiculo {
    private GravadorVeiculo gravadorVeiculo;
    private Map<String, Veiculo> veiculosMap;

    public MeuSistemaVeiculo(){
        this.veiculosMap = new HashMap<>();
        this.gravadorVeiculo = new GravadorVeiculo();
    }

    public void recuperaVeiculo() throws IOException, VeiculoJaExisteException{
        Collection<Veiculo> veiculosAchados = this.gravadorVeiculo.recuperaVeiculo();
        for (Veiculo v: veiculosAchados){
            this.cadastrarVeiculo(v.getTipo(),v.getMarca(),v.getModelo(), v.getAno(),v.getCodigo(),0,false);
        }
    }

    public void salvarVeiculo() throws IOException {
        this.gravadorVeiculo.gravarVeiculos(this.veiculosMap.values());
    }


    @Override
    public void cadastrarVeiculo(TipoVeiculo tipo, String marca, String modelo, int ano, String codigoV, int especifico, boolean especificoTwo)throws VeiculoJaExisteException {
        if(this.veiculosMap.containsKey(codigoV)){
            throw new VeiculoJaExisteException("Este veiculo: ["+codigoV+"] já existe" );
        }else{
            if(tipo.equals(TipoVeiculo.CARRO)){
                Carro carro = new Carro(marca,modelo,ano,codigoV,especifico,especificoTwo);
            } else if (tipo.equals(TipoVeiculo.MOTO)) {
                Moto moto = new Moto(marca,modelo,ano,codigoV,especificoTwo);
            }
            }
        }

    @Override
    public void adicionarVeiculo(List<Veiculo> veiculos, Veiculo novoVeiculo) throws VeiculoJaExisteException {
        //TODO IMPLEMENTAR
    }

    @Override
    public List<Veiculo> PesquisarVeiculos(String marca, String modelo) {
        //TODO IMPLEMENTAR
        return List.of();
    }

    @Override
    public void atualizarVeiculo(String codigo, String novoModelo, int novoAno) {
        //TODO IMPLEMENTAR
    }

    @Override
    public int quantidadeDeVeiculosEmEstoque() {
        //TODO IMPLEMENTAR
        return 0;
    }
}
