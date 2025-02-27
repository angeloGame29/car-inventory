package br.ufpb.dcx.angelo.SistemaVeiculos;

import javax.swing.*;
import java.awt.*;

public class JanelaVeiculos extends JFrame {

    JLabel linha1, linha2;
    ImageIcon logoCarInventory = new ImageIcon("imgs/carLogo.png");
    MeuSistemaVeiculo sistemaVc = new MeuSistemaVeiculo();
    JMenuBar menuBarra = new JMenuBar();

    public JanelaVeiculos(){
        setTitle("Menu Car-Inventory");
        setSize(650,775);
        setLocation(150,150);
        setResizable(true);
        getContentPane().setBackground(Color.white);
        linha1 = new JLabel("SISTEMA CAR INVENTORY",JLabel.CENTER);
        linha1.setForeground(Color.black);
        linha1.setFont(new Font("Serif",Font.BOLD, 25));
        linha2 = new JLabel(logoCarInventory, JLabel.CENTER);
        setLayout(new GridLayout(3,1));
        add(linha1);
        add(linha2);
        add(new JLabel());
        JMenu menuCadastrarV = new JMenu("CADASTRAR");
        JMenuItem menuCadastrarVeiculo = new JMenuItem("Cadastrar veiculo");
        menuCadastrarV.add(menuCadastrarVeiculo);
        JMenu menuPesquisa = new JMenu("PESQUISAR");
        JMenuItem menuPesquisarVeiculo = new JMenuItem("Pesquisar veiculo");
        menuPesquisa.add(menuPesquisarVeiculo);
        JMenuItem menuPesquisarVeiculos = new JMenuItem("Pesquisar veiculos pela marca");
        menuPesquisa.add(menuPesquisarVeiculo);


        //add opções a barra
        menuBarra.add(menuCadastrarV);
        menuBarra.add(menuPesquisa);
        setJMenuBar(menuBarra);
    }


    public static void main(String [] args){
        JFrame janelaveiculo = new JanelaVeiculos();
        janelaveiculo.setVisible(true);
        janelaveiculo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
