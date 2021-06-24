package br.edu.iftm.interfacegrafica2.views;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class LeagueOfLegends {

    public static void main(String[] args) {
        
        JFrame janela = new JFrame("Tela");
        janela.setBounds(250, 120, 1280, 700);
        //janela.setUndecorated(true);
        janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        TelaLogin telaLogin = new TelaLogin();

        janela.add(telaLogin);
        janela.setVisible(true);

        
    }
    
}
