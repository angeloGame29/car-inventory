package br.ufpb.dcx.angelo.SistemaVeiculos;

public class Moto extends Veiculo {
    private boolean possuiEmbreagem;
    public Moto(String marca, String modelo, int ano, String codigo, boolean possuiEmbreagem) {
        super(marca, modelo, ano, codigo);
        this.possuiEmbreagem = possuiEmbreagem;
    }

    public boolean isPossuiEmbreagem() {
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
                "Ano: " + super.getAno() + "\n" +
                "Código: " + super.getCodigo() + "\n" +
                "Possui Embreagem: " + embreagem + "\n";
    }
}
