package br.ufpb.dcx.angelo.SistemaVeiculos;

import java.util.List;
import java.util.Objects;

public interface SistemaVeiculo {

    public void cadastrarVeiculo (Veiculo veiculo) throws VeiculoJaExisteException;

    public List<Veiculo> pesquisarVeiculos (String marca) throws VeiculoInexistenteException;

    public void atualizarVeiculo (String codigo, String novoModelo, int novoAno) throws VeiculoInexistenteException;

    public Veiculo pesquisarVeiculo (String codigo) throws VeiculoInexistenteException;

    public int quantidadeDeVeiculosEmEstoque ();
    public void removeVeiculo(String codigo) throws VeiculoInexistenteException;
}
