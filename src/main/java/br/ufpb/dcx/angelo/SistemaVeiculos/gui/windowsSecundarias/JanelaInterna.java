package br.ufpb.dcx.angelo.SistemaVeiculos.gui.windowsSecundarias;

import br.ufpb.dcx.angelo.SistemaVeiculos.MeuSistemaVeiculo;
import br.ufpb.dcx.angelo.SistemaVeiculos.SistemaVeiculo;
import br.ufpb.dcx.angelo.SistemaVeiculos.controller.VeiculoCarAddController;
import br.ufpb.dcx.angelo.SistemaVeiculos.controller.VeiculoMotorcycleaddController;
import br.ufpb.dcx.angelo.SistemaVeiculos.controller.VeiculoSaveController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class JanelaInterna extends JDialog {
   JLabel linha3;
   ImageIcon imgCadastrar = new ImageIcon("./imgs/iconesDialog/imgCadastrar.png");
   ImageIcon imgSalvar = new ImageIcon("./imgs/iconesDialog/imgSalvar.png");
   ImageIcon imgRemover = new ImageIcon("./imgs/iconesDialog/imgRemover.png");
   ImageIcon imgFechar = new ImageIcon("./imgs/iconesDialog/imgOff.png");
   JButton botaoCadastar, botaoSalvar, botaoRemover, botaoFechar;
   SistemaVeiculo sistema = new MeuSistemaVeiculo();
   JMenuBar menuBarra = new JMenuBar();

     public JanelaInterna( JFrame janelaInertna) {
        try{
           sistema.recuperaVeiculo();
           JOptionPane.showMessageDialog(null,"Tudo okay!\nSeus veiculos foram restaurados com sucesso!");
        } catch (IOException e){
           JOptionPane.showMessageDialog(null,"Falha! Veiculos não recuperados! :(","ops",JOptionPane.ERROR_MESSAGE);
           e.printStackTrace();
        }

        JDialog dialog = new JDialog(this, "Janela Secundária", true);
        dialog.setTitle("Menu Car-Inventory");
        dialog.setSize(650,570);
        dialog.setLocationRelativeTo(null);
        dialog.setResizable(true);
        dialog.setLayout(null);
        dialog.getContentPane().setBackground(Color.decode("#000622"));
        dialog.add(new JLabel());

        //Ações rápidas
        linha3 = new JLabel("AÇÕES RÁPIDAS:");
        linha3.setBounds(190,50,300,100);
        linha3.setForeground(Color.white);
        linha3.setFont(new Font("Serif",Font.BOLD,30));
        botaoCadastar = new JButton(imgCadastrar);
        botaoCadastar.setBounds(50,185,150,150);
        botaoCadastar.setBackground(Color.decode("#5271ff"));
        botaoCadastar.setFocusable(false);
        botaoCadastar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        botaoCadastar.setToolTipText("Cadastrar veículo");
        botaoSalvar = new JButton(imgSalvar);
        botaoSalvar.setBounds(248,185,150,150);
        botaoSalvar.setBackground(Color.decode("#5271ff"));
        botaoSalvar.setFocusable(false);
        botaoSalvar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        botaoSalvar.setToolTipText("Salvar Dados");
        botaoRemover = new JButton(imgRemover);
        botaoRemover.setBounds(440,185,150,150);
        botaoRemover.setBackground(Color.decode("#5271ff"));
        botaoRemover.setFocusable(false);
        botaoRemover.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        botaoRemover.setToolTipText("Remover veículo");
        botaoFechar = new JButton(imgFechar);
        botaoFechar.setBounds(285,380,80,80);
        botaoFechar.setBackground(Color.decode("#5271ff"));
        botaoFechar.setFocusable(false);
        botaoFechar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        botaoFechar.setToolTipText("Fechar programa");

         //duas opções<
        JPopupMenu popupCarroMoto = new JPopupMenu();
        JMenuItem menuCarro = new JMenuItem("Cadastrar carro");
        JMenuItem menuMoto = new JMenuItem("Cadastrar moto");
        popupCarroMoto.add(menuCarro);
        popupCarroMoto.add(menuMoto);

         //mostra o menu ao clicar no botão
        botaoCadastar.addMouseListener(new MouseAdapter() {
           @Override
           public void mousePressed(MouseEvent e) {
              popupCarroMoto.show(botaoCadastar, e.getX(), e.getY());
           }
        });
        //duas opções>

        //menu barra estilizado
        menuBarra.setBackground(Color.LIGHT_GRAY);

        //Gerenciamento:
        JMenu menuGestao = new JMenu("GERENCIAMENRO");
        JMenu itemCadastrarVeiculo = new JMenu("Cadastrar veículo");
        menuGestao.add(itemCadastrarVeiculo);
        //submenu de cadastra<
        JMenuItem itemCadastrarCarro = new JMenuItem("Cadastrar carro");
        itemCadastrarVeiculo.add(itemCadastrarCarro);
        JMenuItem itemCadastrarMoto = new JMenuItem("Cadastrar moto");
        itemCadastrarVeiculo.add(itemCadastrarMoto);
        //submenu de cadastra>
        JMenuItem itemSalvar = new JMenuItem("Salvar veículos");
        menuGestao.add(itemSalvar);
        JMenuItem itemSair = new JMenuItem("Fechar programa");
        menuGestao.add(itemSair);

        //Consulta:
        JMenu menuConsulta = new JMenu("CONSULTA");
        JMenuItem itemPesquisarVeiculo = new JMenuItem("Pesquisar veículo");
        menuConsulta.add(itemPesquisarVeiculo);
        JMenuItem itemPesquisarVeiculos = new JMenuItem("Pesquisar veículos pela marca");
        menuConsulta.add(itemPesquisarVeiculos);
        JMenuItem itemQuantidade = new JMenuItem("Quantidade de veículos em estoque");
        menuConsulta.add(itemQuantidade);

        //Sistema:
        JMenu menuSistema = new JMenu("SISTEMA");
        JMenuItem itemAtualizar = new JMenuItem("Atualizar veículo");
        menuSistema.add(itemAtualizar);
        JMenuItem itemRemover = new JMenuItem("Remover veículo");
        menuSistema.add(itemRemover);

        //ações do programa
        itemCadastrarCarro.addActionListener(new VeiculoCarAddController(sistema,this));
        itemSair.addActionListener(e -> dispose());
        menuCarro.addActionListener(new VeiculoCarAddController(sistema, this));
        menuMoto.addActionListener(new VeiculoMotorcycleaddController(sistema,this));
        botaoSalvar.addActionListener(new VeiculoSaveController(sistema,this));
        itemSalvar.addActionListener(new VeiculoSaveController(sistema,this));
        botaoFechar.addActionListener(e -> dispose());
        //TODO IMPLEMENTAR

        //add opções a barra
        menuBarra.add(menuGestao);
        menuBarra.add(menuConsulta);
        menuBarra.add(menuSistema);
        dialog.add(linha3);
        dialog.add(botaoCadastar);
        dialog.add(botaoSalvar);
        dialog.add(botaoRemover);
        dialog.add(botaoFechar);
        dialog.setJMenuBar(menuBarra);
        dialog.setVisible(true);
    }
}
