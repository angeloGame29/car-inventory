package br.ufpb.dcx.angelo.SistemaVeiculos.controller;

import br.ufpb.dcx.angelo.SistemaVeiculos.*;
import br.ufpb.dcx.angelo.SistemaVeiculos.gui.windowsSecundarias.JanelaInterna;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VeiculoCarAddController extends JDialog implements ActionListener {
    private SistemaVeiculo veiculo;
    private JanelaInterna janelaPrincipal;

    public VeiculoCarAddController(SistemaVeiculo veiculo, JanelaInterna janela) {
        this.veiculo = veiculo;
        this.janelaPrincipal = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog dialog = new JDialog(this, "Janela Secundária", true);
        dialog.setTitle("Menu - Cadastrar Veículo");
        dialog.setSize(650, 570);
        dialog.setLocationRelativeTo(null);
        dialog.setResizable(true);
        dialog.getContentPane().setBackground(Color.decode("#000622"));
        //setLayout(new GridLayout(3, 2));
        dialog.add(new JLabel());
        //titulo:
        JLabel tituloPagina = new JLabel("Cadastrar Carro");
        tituloPagina.setForeground(Color.decode("#ffffff"));
        tituloPagina.setFont(new Font("Serif",Font.BOLD, 30));
        tituloPagina.setBounds(30, 10, 300,50);

        //Tipo do veiculo
        JLabel labelTipo = new JLabel("Selecione o estado do veiculo:");
        labelTipo.setBounds(30, 60, 200, 30);
        labelTipo.setForeground(Color.white);
        JRadioButton opcaoCarro = new JRadioButton("Novo");
        opcaoCarro.setBounds(25,80,80,30);
        opcaoCarro.setBackground(Color.decode("#000622"));
        opcaoCarro.setForeground(Color.white);
        opcaoCarro.setFocusable(false);
        JRadioButton opcaoMoto = new JRadioButton("Usado");
        opcaoMoto.setBounds(100,80,80,30);
        opcaoMoto.setBackground(Color.decode("#000622"));
        opcaoMoto.setForeground(Color.white);
        opcaoMoto.setFocusable(false);
        //Faz com que tenha apenas uma escolha
        ButtonGroup grupoTipos = new ButtonGroup();
        grupoTipos.add(opcaoCarro);
        grupoTipos.add(opcaoMoto);

        //Marca do carro:
        JLabel marcaVeiculo = new JLabel("Digite a marca do veículo:");
        marcaVeiculo.setBounds(30, 110, 200, 30);
        marcaVeiculo.setForeground(Color.white);
        JTextField textMarca = new JTextField();
        textMarca.setBounds(30, 140, 250, 30);

        //Modelo do carro:
        JLabel modeloVeiculo = new JLabel("Digite o modelo do veículo:");
        modeloVeiculo.setBounds(30, 170, 200, 30);
        modeloVeiculo.setForeground(Color.white);
        JTextField textModelo = new JTextField();
        textModelo.setBounds(30, 200, 250, 30);

        //Ano do carro:
        JSlider slideAno = new JSlider(1900,2100,2000);
        slideAno.setMajorTickSpacing(50);
        slideAno.setMinorTickSpacing(10);
        slideAno.setPaintTicks(true);
        slideAno.setPaintLabels(true);
        slideAno.setBounds(30,260,250,50);
        JLabel labelAno = new JLabel("Ano do veículo: 2000");
        labelAno.setBounds(30,230,200,30);
        labelAno.setForeground(Color.white);
        //usaso para mudança de estado<
        slideAno.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int anoDoVeiculo = slideAno.getValue();
                labelAno.setText("Ano do veículo: "+ anoDoVeiculo);
                slideAno.setToolTipText(String.valueOf(anoDoVeiculo));
            }
        });
        //usaso para mudança de estado>

        //Codigo do Carro:
        JLabel codigoVeiculo = new JLabel("Digite o codigo do veículo:");
        codigoVeiculo.setBounds(30, 310, 200, 30);
        codigoVeiculo.setForeground(Color.white);
        JTextField textCodigo = new JTextField();
        textCodigo.setBounds(30, 340, 250, 30);

        //Portas do carro:
        JLabel portasVeiculo = new JLabel("Selecione o número de portas:");
        portasVeiculo.setBounds(30, 370, 200, 30);
        portasVeiculo.setForeground(Color.white);
        SpinnerNumberModel numbPortas = new SpinnerNumberModel(2,2,5,1);
        JSpinner spinnerPortas = new JSpinner(numbPortas);
        spinnerPortas.setBounds(30,400,250,20);

        //Automatico:
        JLabel labelEhautomatico = new JLabel("Selecione se o carro é automático:");
        labelEhautomatico.setBounds(30, 420, 200, 30);
        labelEhautomatico.setForeground(Color.white);
        JRadioButton opcaoSim = new JRadioButton("SIM");
        opcaoSim.setBounds(25,440,80,30);
        opcaoSim.setBackground(Color.decode("#000622"));
        opcaoSim.setForeground(Color.white);
        opcaoSim.setFocusable(false);
        JRadioButton opcaoNao = new JRadioButton("NÃO");
        opcaoNao.setBounds(100,440,80,30);
        opcaoNao.setBackground(Color.decode("#000622"));
        opcaoNao.setForeground(Color.white);
        opcaoNao.setFocusable(false);
        //Faz com que tenha apenas uma escolha
        ButtonGroup grupoSimNao = new ButtonGroup();
        grupoSimNao.add(opcaoSim);
        grupoSimNao.add(opcaoNao);
        //botão cadastrar
        JButton cadastrarCarro = new JButton("Cadastrar");
        cadastrarCarro.setBounds(77, 480, 150, 25);
        cadastrarCarro.setBackground(Color.decode("#5271ff"));
        cadastrarCarro.setFont(new Font("Arial", Font.BOLD, 14));
        cadastrarCarro.setForeground(Color.white);
        cadastrarCarro.setFocusable(false);
        //TODO IMPLEMENTAR
        cadastrarCarro.addActionListener(f-> dispose());

        //add titulo
        dialog.add(tituloPagina);
        //add tipo
        dialog.add(opcaoMoto);
        dialog.add(opcaoCarro);
        dialog.add(labelTipo);
        //add marca
        dialog.add(textMarca);
        dialog.add(marcaVeiculo);
        //add modelo
        dialog.add(textModelo);
        dialog.add(modeloVeiculo);
        //add ano
        dialog.add(labelAno);
        dialog.add(slideAno);
        //add codigo
        dialog.add(textCodigo);
        dialog.add(codigoVeiculo);
        //add portas
        dialog.add(portasVeiculo);
        dialog.add(spinnerPortas);
        //add automatico
        dialog.add(opcaoSim);
        dialog.add(opcaoNao);
        dialog.add(labelEhautomatico);
        //add botão cadastrar
        dialog.add(cadastrarCarro);

        dialog.setLayout(null);
        //dialog.setUndecorated(true);
        dialog.setVisible(true);
    }
}
