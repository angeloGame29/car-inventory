package br.ufpb.dcx.angelo.SistemaVeiculos.windows.wSecundarias;

import br.ufpb.dcx.angelo.SistemaVeiculos.MeuSistemaVeiculo;
import br.ufpb.dcx.angelo.SistemaVeiculos.SistemaVeiculo;
import br.ufpb.dcx.angelo.SistemaVeiculos.controller.VeiculoAddController;

import javax.swing.*;
import java.awt.*;

public class JanelaInterna extends JDialog {
    SistemaVeiculo veiculo = new MeuSistemaVeiculo();
    JMenuBar menuBarra = new JMenuBar();

     public JanelaInterna( JFrame janelaInertna) {
        JDialog dialog = new JDialog(this, "Janela Secundária", true);
        dialog.setTitle("Menu Car-Inventory");
        dialog.setSize(650,570);
        dialog.setLocationRelativeTo(null);
        dialog.setResizable(true);
        dialog.getContentPane().setBackground(Color.decode("#000622"));
        setLayout(new GridLayout(3,1));
        dialog.add(new JLabel());

        //menu barra estilizado
        menuBarra.setBackground(Color.LIGHT_GRAY);

        //Gerenciamento:
        JMenu menuGestao = new JMenu("GERENCIAMENRO");
        JMenuItem itemCadastrarVeiculo = new JMenuItem("Cadastrar veículo");
        menuGestao.add(itemCadastrarVeiculo);
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

        itemCadastrarVeiculo.addActionListener(new VeiculoAddController(veiculo,this));
        itemSair.addActionListener(e -> dispose());


        //add opções a barra
        menuBarra.add(menuGestao);
        menuBarra.add(menuConsulta);
        menuBarra.add(menuSistema);
        dialog.setJMenuBar(menuBarra);
        dialog.setVisible(true);
    }
}
