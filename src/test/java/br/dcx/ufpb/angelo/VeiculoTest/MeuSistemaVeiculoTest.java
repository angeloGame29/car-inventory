package br.dcx.ufpb.angelo.VeiculoTest;

import br.ufpb.dcx.angelo.SistemaVeiculos.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
    @Test
    public void testaSalvarVeiculo () throws VeiculoJaExisteException{
        MeuSistemaVeiculo sistema = new MeuSistemaVeiculo();

        try {
            Veiculo c1 = new Carro(TipoVeiculo.CARRO, "toyota", "corolla", 2011, "002", 4, false);
            Veiculo c2 = new Carro(TipoVeiculo.CARRO, "honda", "civic v8", 2015, "003", 4, true);
            Veiculo m1 = new Moto(TipoVeiculo.MOTO,"Yamaha","Fazer",2020,"004",true);
            Veiculo m2 = new Moto(TipoVeiculo.MOTO,"Honda","Titan",2020,"005",true);
            sistema.cadastrarVeiculo(c1);
            sistema.cadastrarVeiculo(c2);
            sistema.cadastrarVeiculo(m1);
            sistema.cadastrarVeiculo(m2);
            sistema.salvarVeiculo();
            MeuSistemaVeiculo novoSistemaTest = new MeuSistemaVeiculo();
            novoSistemaTest.recuperaVeiculo();
            Veiculo c1recuperado = novoSistemaTest.pesquisarVeiculo("002");
            Veiculo c2recuperado = novoSistemaTest.pesquisarVeiculo("003");
            Veiculo m1recuperado = novoSistemaTest.pesquisarVeiculo("004");
            Veiculo m2recuperado = novoSistemaTest.pesquisarVeiculo("005");
            assertEquals("corolla",c1recuperado.getModelo());
            assertEquals("civic v8",c2recuperado.getModelo());
            assertEquals("Fazer",m1recuperado.getModelo());
            assertEquals("Titan",m2recuperado.getModelo());
        }catch (VeiculoJaExisteException | IOException | VeiculoInexistenteException e){
            e.printStackTrace();
            fail("Exceção não esperada!");
        }
    }
}
