package br.ufpb.dcx.angelo.SistemaVeiculos;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

public abstract class Veiculo implements Serializable {
    private static final long serialVersionUID = 1L;
    private TipoVeiculo tipo;
    private String estadoVeiculo;
    private String marca;
    private String modelo;
    private int ano;
    private String codigo;

    public Veiculo ( TipoVeiculo tipo, String estado, String marca, String modelo, int ano, String codigo){
        this.tipo = tipo;
        this.estadoVeiculo = estado;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.codigo = codigo;
    }

    public TipoVeiculo getTipo() {
        return tipo;
    }

    public String getEstadoVeiculo() {
        return estadoVeiculo;
    }

    public String getMarca(){
        return this.marca;
    }

    public String getModelo(){
        return this.modelo;
    }

    public int getAno(){
        return this.ano;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setTipo(TipoVeiculo tipo) {
        this.tipo = tipo;
    }

    public void setEstadoVeiculo(String estadoVeiculo) {
        this.estadoVeiculo = estadoVeiculo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return Objects.equals(modelo, veiculo.modelo) && Objects.equals(codigo, veiculo.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modelo, codigo);
    }

    public abstract void cadastrar(Map<String, Veiculo> veiculosMap);
}
