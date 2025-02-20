package br.ufpb.dcx.angelo.SistemaVeiculos;

public class VeiculoJaExisteException extends Exception {
    public VeiculoJaExisteException(String msg){
        super (msg);
    }
}
