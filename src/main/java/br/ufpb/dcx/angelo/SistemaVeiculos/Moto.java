package br.ufpb.dcx.angelo.SistemaVeiculos;

import java.util.Map;

public class Moto extends Veiculo {
    private boolean possuiEmbreagem;
    public Moto( TipoVeiculo tipo,String estado, String marca, String modelo, int ano, String codigo, boolean possuiEmbreagem) {
        super(tipo,estado, marca, modelo, ano, codigo);
        this.possuiEmbreagem = possuiEmbreagem;
    }

    public boolean getPossuiEmbreagem() {
        return possuiEmbreagem;
    }

    public void setPossuiEmbreagem(boolean possuiEmbreagem) {
        this.possuiEmbreagem = possuiEmbreagem;
    }

    public boolean ligado() {
        return true;
    }


    public String toString() {
        String embreagem;
        if (possuiEmbreagem) {
            embreagem = "SIM";
        } else {
            embreagem = "NÃO";
        }

        return "Detalhes da Moto:\n" +
                "------------------\n" +
                "Marca: " + super.getMarca() + "\n" +
                "Modelo: " + super.getModelo() + "\n" +
                "Estado: " + super.getEstadoVeiculo() + "\n" +
                "Ano: " + super.getAno() + "\n" +
                "Código: " + super.getCodigo() + "\n" +
                "Possui Embreagem: " + embreagem + "\n";
    }

    @Override
    public void cadastrar(Map<String, Veiculo> veiculosMap) {
        veiculosMap.put(this.getCodigo(), this);
    }
}
