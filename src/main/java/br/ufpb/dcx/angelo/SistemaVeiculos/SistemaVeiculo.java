package br.ufpb.dcx.angelo.SistemaVeiculos;

import java.util.List;
import java.util.Objects;

public interface SistemaVeiculo {

    public void cadastrarVeiculo (String tipo, String marca, String modelo, int ano, String codigo, Objects especifico);

    public void adicionarVeiculo(List<Veiculo> veiculos, Veiculo novoVeiculo) throws VeiculoJaExisteException;

    public List<Veiculo> PesquisarVeiculos (String marca, String modelo);

}
