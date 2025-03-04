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
    private SistemaVeiculo sistema;
    private JanelaInterna janelaInterna;

    public VeiculoCarAddController(SistemaVeiculo sistema, JanelaInterna janela) {
        this.sistema = sistema;
        this.janelaInterna = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog dialogAddCar = new JDialog(this, "", true);
        dialogAddCar.setTitle("Menu - Cadastrar Carro");
        dialogAddCar.setSize(650, 570);
        dialogAddCar.setLocationRelativeTo(null);
        dialogAddCar.setResizable(true);
        dialogAddCar.getContentPane().setBackground(Color.decode("#000622"));
        //setLayout(new GridLayout(3, 2));
        //dialogAddCar.add(new JLabel());

        //=====================[ INFORMAÇÕES DO CARRO ]=====================
        //titulo:
        JLabel tituloPagina = new JLabel("Cadastrar Carro");
        tituloPagina.setForeground(Color.decode("#ffffff"));
        tituloPagina.setFont(new Font("Serif",Font.BOLD, 30));
        tituloPagina.setBounds(30, 10, 300,50);
        //Estado veiculo
        JLabel labelTipo = new JLabel("Selecione o estado do veiculo:");
        labelTipo.setBounds(30, 60, 200, 30);
        labelTipo.setForeground(Color.white);
        JRadioButton opcaoNovo = new JRadioButton("Novo");
        opcaoNovo.setBounds(25,80,80,30);
        opcaoNovo.setBackground(Color.decode("#000622"));
        opcaoNovo.setForeground(Color.white);
        opcaoNovo.setFocusable(false);
        opcaoNovo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        JRadioButton opcaoUsado = new JRadioButton("Usado");
        opcaoUsado.setBounds(100,80,80,30);
        opcaoUsado.setBackground(Color.decode("#000622"));
        opcaoUsado.setForeground(Color.white);
        opcaoUsado.setFocusable(false);
        opcaoUsado.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        //Faz com que tenha apenas uma escolha
        ButtonGroup grupoTipos = new ButtonGroup();
        grupoTipos.add(opcaoNovo);
        grupoTipos.add(opcaoUsado);

        //Marca do carro:
        JLabel marcaVeiculo = new JLabel("Digite a marca do veículo:");
        marcaVeiculo.setBounds(30, 110, 200, 30);
        marcaVeiculo.setForeground(Color.white);
        JTextField textMarca = new JTextField();
        textMarca.setBounds(30, 140, 250, 30);
        textMarca.setForeground(Color.white);
        textMarca.setBackground(Color.decode("#5271ff"));
        textMarca.setBorder(null);
        //Modelo do carro:
        JLabel modeloVeiculo = new JLabel("Digite o modelo do veículo:");
        modeloVeiculo.setBounds(30, 170, 200, 30);
        modeloVeiculo.setForeground(Color.white);
        JTextField textModelo = new JTextField();
        textModelo.setBounds(30, 200, 250, 30);
        textModelo.setForeground(Color.white);
        textModelo.setBackground(Color.decode("#5271ff"));
        textModelo.setBorder(null);

        //Ano do carro:
        JSlider slideAno = new JSlider(1900,2100,2000);
        slideAno.setMajorTickSpacing(50);
        slideAno.setMinorTickSpacing(10);
        slideAno.setPaintTicks(true);
        slideAno.setPaintLabels(true);
        slideAno.setBounds(30,260,250,50);
        slideAno.setBackground(Color.decode("#5271ff"));
        slideAno.setForeground(Color.white);
        slideAno.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
        JLabel labelAno = new JLabel("Ano do veículo: 2000");
        labelAno.setBounds(30,230,200,30);
        labelAno.setForeground(Color.white);
        //usandoo para mudança de ano<
        slideAno.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int anoDoVeiculo = slideAno.getValue();
                labelAno.setText("Ano do veículo: "+ anoDoVeiculo);
                slideAno.setToolTipText(String.valueOf(anoDoVeiculo));
            }
        });
        //usandoo para mudança de ano>

        //Codigo do Carro:
        JLabel codigoVeiculo = new JLabel("Digite o codigo do veículo:");
        codigoVeiculo.setBounds(30, 310, 200, 30);
        codigoVeiculo.setForeground(Color.white);
        JTextField textCodigo = new JTextField();
        textCodigo.setBounds(30, 340, 250, 30);
        textCodigo.setForeground(Color.white);
        textCodigo.setBackground(Color.decode("#5271ff"));
        textCodigo.setBorder(null);

        //Portas do carro:
        JLabel portasVeiculo = new JLabel("Selecione o número de portas:");
        portasVeiculo.setBounds(30, 370, 200, 30);
        portasVeiculo.setForeground(Color.white);
        SpinnerNumberModel numbPortas = new SpinnerNumberModel(2,2,5,1);
        JSpinner spinnerPortas = new JSpinner(numbPortas);
        spinnerPortas.setBounds(30,400,250,20);
        spinnerPortas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        spinnerPortas.setForeground(Color.white);

        //Automatico:
        JLabel labelEhautomatico = new JLabel("Selecione se o carro é automático:");
        labelEhautomatico.setBounds(30, 420, 200, 30);
        labelEhautomatico.setForeground(Color.white);
        JRadioButton opcaoSim = new JRadioButton("SIM");
        opcaoSim.setBounds(25,440,80,30);
        opcaoSim.setBackground(Color.decode("#000622"));
        opcaoSim.setForeground(Color.white);
        opcaoSim.setFocusable(false);
        opcaoSim.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        JRadioButton opcaoNao = new JRadioButton("NÃO");
        opcaoNao.setBounds(100,440,80,30);
        opcaoNao.setBackground(Color.decode("#000622"));
        opcaoNao.setForeground(Color.white);
        opcaoNao.setFocusable(false);
        opcaoNao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
        cadastrarCarro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        //imagem
        ImageIcon imagCarro = new ImageIcon("./imgs/carroAdd.png");
        //Redimensionando a imagem
        Image imagemRedimensionada = imagCarro.getImage().getScaledInstance(300, 300,Image.SCALE_SMOOTH);
        ImageIcon novaImagem = new ImageIcon(imagemRedimensionada);
        JLabel carroAdd = new JLabel(novaImagem);
        carroAdd.setBounds(300,125, 300,300);
        dialogAddCar.add(carroAdd);


        //============================[ PEGADOR DE DADOS ]================================
        cadastrarCarro.addActionListener(c -> {
            String estado = "";
            if (opcaoNovo.isSelected()) {
                estado = "NOVO";
            } else if (opcaoUsado.isSelected()) {
                estado = "USADO";
            }
            String marca = textMarca.getText().trim();//remover espaço em branco
            String modelo = textModelo.getText().trim();
            int ano = slideAno.getValue();
            String codigo = textCodigo.getText().trim();
            int portas = (Integer) spinnerPortas.getValue();
            boolean ehAutomatico;
            if (opcaoSim.isSelected()) {
                ehAutomatico = true;
            } else {
                ehAutomatico = false;
            }

            if (marca.isEmpty() || modelo.isEmpty() || codigo.isEmpty() || estado.isEmpty()) {
                JOptionPane.showMessageDialog(dialogAddCar, "Preencha todos os campos obrigatórios!");
                return;
            }

            //============================[ CADASTRAR E TRATAR ]================================
            Carro veiculoCarro = new Carro(TipoVeiculo.CARRO, estado, marca, modelo, ano, codigo, portas, ehAutomatico);

            try {
                sistema.cadastrarVeiculo(veiculoCarro);
                JOptionPane.showMessageDialog(dialogAddCar, "Carro cadastrado com sucesso!\n" + veiculoCarro.toString());
                dialogAddCar.dispose();
            } catch (VeiculoJaExisteException ex) {
                JOptionPane.showMessageDialog(dialogAddCar, ex.getMessage());
            }
        });


        //===========================[ ADD A JANELA ]==========================================================
        //add titulo
        dialogAddCar.add(tituloPagina);
        //add tipo
        dialogAddCar.add(opcaoUsado);
        dialogAddCar.add(opcaoNovo);
        dialogAddCar.add(labelTipo);
        //add marca
        dialogAddCar.add(textMarca);
        dialogAddCar.add(marcaVeiculo);
        //add modelo
        dialogAddCar.add(textModelo);
        dialogAddCar.add(modeloVeiculo);
        //add ano
        dialogAddCar.add(labelAno);
        dialogAddCar.add(slideAno);
        //add codigo
        dialogAddCar.add(textCodigo);
        dialogAddCar.add(codigoVeiculo);
        //add portas
        dialogAddCar.add(portasVeiculo);
        dialogAddCar.add(spinnerPortas);
        //add automatico
        dialogAddCar.add(opcaoSim);
        dialogAddCar.add(opcaoNao);
        dialogAddCar.add(labelEhautomatico);
        //add botão cadastrar
        dialogAddCar.add(cadastrarCarro);

        dialogAddCar.setLayout(null);
        //dialogAddCar.setUndecorated(true);
        dialogAddCar.setVisible(true);
    }

}
