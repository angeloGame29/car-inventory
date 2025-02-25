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
                v.cadastrar(this.veiculosMap); // Cada veículo sabe como se cadastrar, pois usei o metodo polimorfico nas classes para cadastrar
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
    public List<Veiculo> pesquisarVeiculos(String marca) throws VeiculoInexistenteException {
        List<Veiculo> veiculosEncontrados = new ArrayList<>();
            for (Veiculo v : this.veiculosMap.values()) {
                if (v.getMarca().equalsIgnoreCase(marca)) {
                veiculosEncontrados.add(v);
            }
        }if(veiculosEncontrados.isEmpty()){
                throw new VeiculoInexistenteException("Não foi cadastrado nenhum veiculo com esta marca: [" + marca + "]");
        }
        return veiculosEncontrados;
    }

    @Override
    public void atualizarVeiculo(String codigo, String novoModelo, int novoAno) throws VeiculoInexistenteException {
        if(!this.veiculosMap.containsKey(codigo)){
            throw new VeiculoInexistenteException("Não foi cadastrado nenhum veiculo com este codigo: ["+codigo+"]");
        }else {
            Veiculo veiculoAAtualizar = this.veiculosMap.get(codigo);
            veiculoAAtualizar.setModelo(novoModelo);
            veiculoAAtualizar.setAno(novoAno);
        }
    }

    @Override
    public Veiculo pesquisarVeiculo(String codigo) throws VeiculoInexistenteException {
        if (this.veiculosMap.containsKey(codigo)) {
            return this.veiculosMap.get(codigo);
        }else{
            throw new VeiculoInexistenteException("Não existe nenhum veiculo com este codigo: ["+codigo+"]");
        }
    }

    @Override
    public int quantidadeDeVeiculosEmEstoque() {
        int cont = 0;
        for (Veiculo v: this.veiculosMap.values()){
            cont++;
        }
        return cont;
    }
}
