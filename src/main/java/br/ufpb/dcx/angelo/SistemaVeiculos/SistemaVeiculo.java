package br.ufpb.dcx.angelo.SistemaVeiculos;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public interface SistemaVeiculo {
    /**
     * Cadastra um veículo, independentemente de ser carro ou moto
     * @param veiculo O veículo a ser cadastrado
     * @throws VeiculoJaExisteException Se o veículo já existir no sistema.
     */
    public void cadastrarVeiculo (Veiculo veiculo) throws VeiculoJaExisteException;

    /**
     * Pesquisa os veículos com base na marca informada.
     * @param marca A marca dos veículos a serem pesquisados.
     * @return Um lista de veículos de uma marca especifica.
     * @throws VeiculoInexistenteException Se nenhum veículo da marca for encontrada.
     */
    public List<Veiculo> pesquisarVeiculos (String marca) throws VeiculoInexistenteException;

    /**
     * Atualiza o modelo e o ano de um veículo já no sistema.
     * @param codigo O código do veículo.
     * @param novoModelo O novo modelo do veículo.
     * @param novoAno O novo ano do veículo
     * @throws VeiculoInexistenteException Se o veículo já existe no sistema.
     */
    public void atualizarVeiculo (String codigo, String novoModelo, int novoAno) throws VeiculoInexistenteException;

    /**
     * Pesquisa um veículo pelo seu código.
     * @param codigo O código do veículo a ser pesquisado.
     * @return O veículo encontrado.
     * @throws VeiculoInexistenteException Se o veículo já existe no sistema.
     */
    public Veiculo pesquisarVeiculo (String codigo) throws VeiculoInexistenteException;

    /**
     * Retorna a quantidade total de veículos em estoque.
     * @return O número total de veículos cadastrados.
     */
    public int quantidadeDeVeiculosEmEstoque ();

    /**
     * Remove um veículo do sistema com base no código.
     * @param codigo O código do veículo a ser removido.
     * @throws VeiculoInexistenteException Se o veículo já existe no sistema.
     */
    public void removeVeiculo(String codigo) throws VeiculoInexistenteException;

    /**
     * Recupera os veículos armazenados a partir de um arquivo .dat.
     * @throws IOException Se houver erro ao salvar os veículos cadastrados.
     */
    public void recuperaVeiculo() throws IOException;

    /**
     * Salva os veículos cadastrados em um arquivo .dat.
     * @throws IOException Se houver erro ao salvar os veículos cadastrados.
     */
    public void salvarVeiculo() throws IOException;
}
