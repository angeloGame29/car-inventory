package br.dcx.ufpb.angelo.VeiculoTest;

import br.ufpb.dcx.angelo.SistemaVeiculos.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class MeuSistemaVeiculoTest {

    @Test
    public void testaCadastroVeiculo() throws VeiculoJaExisteException, IOException {
        MeuSistemaVeiculo sistema = new MeuSistemaVeiculo();
        try{
            Veiculo veiculo = new Carro(TipoVeiculo.CARRO,"honda","civic",2023,"001",2,true);
            sistema.cadastrarVeiculo(veiculo);
            Veiculo carro = sistema.pesquisarVeiculo("001");
            assertEquals("civic",carro.getModelo());
        }catch (VeiculoJaExisteException | VeiculoInexistenteException e){
            e.printStackTrace();
            fail("exceção não esperada!");
        }


    }
}
