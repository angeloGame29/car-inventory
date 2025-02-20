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

    public void recuperaVeiculo() throws IOException {
        Collection<Veiculo> veiculosAchados = this.gravadorVeiculo.recuperaVeiculo();
        for (Veiculo v : veiculosAchados) {
            if (!this.veiculosMap.containsKey(v.getCodigo())) {
                v.cadastrar(this.veiculosMap); // Cada veículo sabe como se cadastrar
            }
        }
    }

    public void salvarVeiculo() throws IOException {
        this.gravadorVeiculo.gravarVeiculos(this.veiculosMap.values());
    }


    @Override
    public void cadastrarVeiculo(Veiculo veiculo) throws VeiculoJaExisteException {
        if (this.veiculosMap.containsKey(veiculo.getCodigo())) {
            throw new VeiculoJaExisteException("Este veículo [" + veiculo.getCodigo() + "] já existe");
        }
        veiculo.cadastrar(this.veiculosMap);
    }

    @Override
    public List<Veiculo> pesquisarVeiculos(String marca, String modelo) {
        //TODO IMPLEMENTAR
        return List.of();
    }

    @Override
    public void atualizarVeiculo(String codigo, String novoModelo, int novoAno) {
        //TODO IMPLEMENTAR
    }

    @Override
    public Veiculo pesquisarVeiculo(String codigo) throws VeiculoInexistenteException {
        if (this.veiculosMap.containsKey(codigo)) {
            return this.veiculosMap.get(codigo);
        }else{
            throw new VeiculoInexistenteException("Não existe nenhum veiculo com este: ["+codigo+"] codigo");
        }
    }

    @Override
    public int quantidadeDeVeiculosEmEstoque() {
        //TODO IMPLEMENTAR
        return 0;
    }
}
