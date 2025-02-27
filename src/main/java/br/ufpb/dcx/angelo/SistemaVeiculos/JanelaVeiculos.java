package br.ufpb.dcx.angelo.SistemaVeiculos;

import javax.swing.*;
import java.awt.*;

public class JanelaVeiculos extends JFrame {

    JLabel linha1, linha2;
    ImageIcon logoCarInventory = new ImageIcon("imgs/CarLogo.png");

    public JanelaVeiculos(){
        setTitle("Menu Car-Inventory");
        setSize(500,300);
        setLocation(150,150);
        setResizable(false);
        getContentPane().setBackground(Color.white);
        linha1 = new JLabel("Opções do inventario:",JLabel.CENTER);
        linha1.setForeground(Color.black);
        linha1.setFont(new Font("Serif",Font.BOLD, 20));
        linha2 = new JLabel(logoCarInventory, JLabel.LEFT);
        getContentPane().setLayout(new GridLayout(3,1));
        getContentPane().add(linha1);
        getContentPane().add(linha2);
    }
}
