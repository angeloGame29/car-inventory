package br.ufpb.dcx.angelo.SistemaVeiculos;

import java.util.Map;
import java.util.Objects;

public class Carro extends Veiculo {
    private int portas;
    private boolean automatico;

    public Carro(TipoVeiculo tipo,String estado, String marca, String modelo, int ano, String codigo, int portas, boolean automatico) {
        super(tipo,estado, marca, modelo, ano, codigo);
        this.portas = portas;
        this.automatico = automatico;
    }
    public int getPortas(){
        return this.portas;
    }

    public boolean getAutomatico(){
        return this.automatico;
    }

    public void setPortas(int portas) {
        this.portas = portas;
    }

    public void setAutomatico(boolean automatico) {
        this.automatico = automatico;
    }

    public String toString() {
        String manualAuto;
        if(automatico){
            manualAuto = "Automática";
        }else {
            manualAuto = "Manual";
        }
        return "Detalhes do Carro:\n" +
                "-------------------\n" +
                "Marca: " + super.getMarca() + "\n" +
                "Modelo: " + super.getModelo() + "\n" +
                "Estado: " + super.getEstadoVeiculo() + "\n" +
                "Ano: " + super.getAno() + "\n" +
                "Código: " + super.getCodigo() + "\n" +
                "Número de Portas: " + portas + "\n" +
                "Transmissão: " + manualAuto + "\n";
    }

    @Override
    public void cadastrar(Map<String, Veiculo> veiculosMap) {
        veiculosMap.put(this.getCodigo(), this);
    }
}
