package br.ufpb.dcx.angelo.SistemaVeiculos;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class GravadorVeiculo {
    private String arquivoVeiculos;

    public GravadorVeiculo(){
        this.arquivoVeiculos = "veiculos.dat";
    }
    public Collection<Veiculo> recuperaVeiculo() throws IOException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(this.arquivoVeiculos))){
            Collection<Veiculo> veiculosEncontrados = (ArrayList<Veiculo>) in.readObject();
            return veiculosEncontrados;
        }catch (ClassNotFoundException | ClassCastException e){
            throw new IOException(e);
        }

    }

    public void gravarVeiculos(Collection<Veiculo> veiculos) throws IOException {
        ArrayList<Veiculo> veiculosArrayList = new ArrayList<>();
        veiculosArrayList.addAll(veiculos);
        try ( ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivoVeiculos))){
            out.writeObject(veiculosArrayList);
        }
    }

}
