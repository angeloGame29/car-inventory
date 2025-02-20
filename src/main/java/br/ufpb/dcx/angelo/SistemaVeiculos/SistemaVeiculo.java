package br.ufpb.dcx.angelo.SistemaVeiculos;

import java.util.List;
import java.util.Objects;

public interface SistemaVeiculo {

    public void cadastrarVeiculo (Veiculo veiculo) throws VeiculoJaExisteException;

    public List<Veiculo> pesquisarVeiculos (String marca, String modelo);

    public void atualizarVeiculo (String codigo, String novoModelo, int novoAno);

    public Veiculo pesquisarVeiculo (String codigo) throws VeiculoInexistenteException;

    public int quantidadeDeVeiculosEmEstoque ();
}
