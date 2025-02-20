package br.ufpb.dcx.angelo.SistemaVeiculos;

import java.util.Objects;

public class Carro extends Veiculo {
    private int portas;
    private boolean automatico;

    public Carro(String marca, String modelo, int ano, String codigo, int portas, boolean automatico) {
        super(marca, modelo, ano, codigo);
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
                "Ano: " + super.getAno() + "\n" +
                "Código: " + super.getCodigo() + "\n" +
                "Número de Portas: " + portas + "\n" +
                "Transmissão: " + manualAuto + "\n";
    }
}
