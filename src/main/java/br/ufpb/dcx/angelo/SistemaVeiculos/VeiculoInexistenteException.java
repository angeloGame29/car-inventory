package br.ufpb.dcx.angelo.SistemaVeiculos;

public class VeiculoInexistenteException extends Exception {
    public VeiculoInexistenteException (String msg){
        super(msg);
    }
}
