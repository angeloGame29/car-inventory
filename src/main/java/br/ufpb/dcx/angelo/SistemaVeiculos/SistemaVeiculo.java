package br.ufpb.dcx.angelo.SistemaVeiculos;

import java.util.List;
import java.util.Objects;

public interface SistemaVeiculo {

    public void cadastrarVeiculo (TipoVeiculo tipo, String marca, String modelo, int ano, String codigo, int especifico, boolean especificoTwo) throws VeiculoJaExisteException;

    public void adicionarVeiculo(List<Veiculo> veiculos, Veiculo novoVeiculo) throws VeiculoJaExisteException;

    public List<Veiculo> PesquisarVeiculos (String marca, String modelo);

    public void atualizarVeiculo (String codigo, String novoModelo, int novoAno);

    public int quantidadeDeVeiculosEmEstoque ();
}
