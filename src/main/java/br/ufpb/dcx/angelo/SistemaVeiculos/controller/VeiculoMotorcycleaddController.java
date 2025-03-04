package br.ufpb.dcx.angelo.SistemaVeiculos.controller;

import br.ufpb.dcx.angelo.SistemaVeiculos.*;
import br.ufpb.dcx.angelo.SistemaVeiculos.gui.windowsSecundarias.JanelaInterna;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VeiculoMotorcycleaddController extends JDialog implements ActionListener {
    private SistemaVeiculo sistema;
    private JanelaInterna janelaInterna;

    public VeiculoMotorcycleaddController(SistemaVeiculo sistema, JanelaInterna janela){
        this.sistema = sistema;
        this.janelaInterna = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog dialogAddMoto = new JDialog(this, "", true);
        dialogAddMoto.setTitle("Menu - Cadastrar Moto");
        dialogAddMoto.setSize(650, 570);
        dialogAddMoto.setLocationRelativeTo(null);
        dialogAddMoto.setResizable(true);
        dialogAddMoto.getContentPane().setBackground(Color.decode("#000622"));

        //=====================[ INFORMAÇÕES DA MOTO ]=====================
        //Titulo:
        JLabel tituloPagina = new JLabel("Cadastrar Moto");
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

        //Marca do moto:
        JLabel marcaVeiculo = new JLabel("Digite a marca do veículo:");
        marcaVeiculo.setBounds(30, 110, 200, 30);
        marcaVeiculo.setForeground(Color.white);
        JTextField textMarca = new JTextField();
        textMarca.setBounds(30, 140, 250, 30);
        textMarca.setForeground(Color.white);
        textMarca.setBackground(Color.decode("#5271ff"));
        textMarca.setBorder(null);

        //Modelo do moto:
        JLabel modeloVeiculo = new JLabel("Digite o modelo do veículo:");
        modeloVeiculo.setBounds(30, 170, 200, 30);
        modeloVeiculo.setForeground(Color.white);
        JTextField textModelo = new JTextField();
        textModelo.setBounds(30, 200, 250, 30);
        textModelo.setForeground(Color.white);
        textModelo.setBackground(Color.decode("#5271ff"));
        textModelo.setBorder(null);

        //Ano do moto:
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
        //Usandoo para mudança de ano<
        slideAno.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int anoDoVeiculo = slideAno.getValue();
                labelAno.setText("Ano do veículo: "+ anoDoVeiculo);
                slideAno.setToolTipText(String.valueOf(anoDoVeiculo));
            }
        });
        //Usandoo para mudança de ano>

        //Codigo do moto:
        JLabel codigoVeiculo = new JLabel("Digite o codigo do veículo:");
        codigoVeiculo.setBounds(30, 310, 200, 30);
        codigoVeiculo.setForeground(Color.white);
        JTextField textCodigo = new JTextField();
        textCodigo.setBounds(30, 340, 250, 30);
        textCodigo.setForeground(Color.white);
        textCodigo.setBackground(Color.decode("#5271ff"));
        textCodigo.setBorder(null);

        //Embragem:
        JLabel labelEmbreagem = new JLabel("Selecione se a moto possui embragem:");
        labelEmbreagem.setBounds(30, 370, 200, 30);
        labelEmbreagem.setForeground(Color.white);
        JRadioButton opcaoSim = new JRadioButton("SIM");
        opcaoSim.setBounds(25,400,80,30);
        opcaoSim.setBackground(Color.decode("#000622"));
        opcaoSim.setForeground(Color.white);
        opcaoSim.setFocusable(false);
        opcaoSim.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        JRadioButton opcaoNao = new JRadioButton("NÃO");
        opcaoNao.setBounds(100,400,80,30);
        opcaoNao.setBackground(Color.decode("#000622"));
        opcaoNao.setForeground(Color.white);
        opcaoNao.setFocusable(false);
        opcaoNao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        //Faz com que tenha apenas uma escolha
        ButtonGroup grupoSimNao = new ButtonGroup();
        grupoSimNao.add(opcaoSim);
        grupoSimNao.add(opcaoNao);

        //Botão cadastrar
        JButton cadastrarCarro = new JButton("Cadastrar");
        cadastrarCarro.setBounds(77, 440, 150, 25);
        cadastrarCarro.setBackground(Color.decode("#5271ff"));
        cadastrarCarro.setFont(new Font("Arial", Font.BOLD, 14));
        cadastrarCarro.setForeground(Color.white);
        cadastrarCarro.setFocusable(false);
        cadastrarCarro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        //Imagem
        ImageIcon imagCarro = new ImageIcon("./imgs/motoAdd.png");
        //Redimensionando a imagem
        Image imagemRedimensionada = imagCarro.getImage().getScaledInstance(300, 300,Image.SCALE_SMOOTH);
        ImageIcon novaImagem = new ImageIcon(imagemRedimensionada);
        JLabel carroAdd = new JLabel(novaImagem);
        carroAdd.setBounds(300,125, 300,300);
        dialogAddMoto.add(carroAdd);

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
            boolean embreagem;
            if (opcaoSim.isSelected()) {
                embreagem = true;
            } else {
                embreagem = false;
            }

            if (marca.isEmpty() || modelo.isEmpty() || codigo.isEmpty() || estado.isEmpty()) {
                JOptionPane.showMessageDialog(dialogAddMoto, "Preencha todos os campos obrigatórios!");
                return;
            }

            //============================[ CADASTRAR E TRATAR ]================================
            Veiculo veiculoCarro = new Moto(TipoVeiculo.MOTO, estado, marca, modelo, ano, codigo, embreagem);

            try {
                sistema.cadastrarVeiculo(veiculoCarro);
                JOptionPane.showMessageDialog(dialogAddMoto, "Moto cadastrada com sucesso!\n" + veiculoCarro.toString());
                dialogAddMoto.dispose();
            } catch (VeiculoJaExisteException ex) {
                JOptionPane.showMessageDialog(dialogAddMoto, ex.getMessage());
            }
        });

        //===========================[ ADD A JANELA ]=============================
        //Add titulo
        dialogAddMoto.add(tituloPagina);
        //Add tipo
        dialogAddMoto.add(opcaoUsado);
        dialogAddMoto.add(opcaoNovo);
        dialogAddMoto.add(labelTipo);
        //Add marca
        dialogAddMoto.add(textMarca);
        dialogAddMoto.add(marcaVeiculo);
        //Add modelo
        dialogAddMoto.add(textModelo);
        dialogAddMoto.add(modeloVeiculo);
        //Add ano
        dialogAddMoto.add(labelAno);
        dialogAddMoto.add(slideAno);
        //Add codigo
        dialogAddMoto.add(textCodigo);
        dialogAddMoto.add(codigoVeiculo);
        //Add automatico
        dialogAddMoto.add(opcaoSim);
        dialogAddMoto.add(opcaoNao);
        dialogAddMoto.add(labelEmbreagem);
        //Add botão cadastrar
        dialogAddMoto.add(cadastrarCarro);

        dialogAddMoto.setLayout(null);
        //dialogAddMoto.setUndecorated(true);
        dialogAddMoto.setVisible(true);

    }
}
