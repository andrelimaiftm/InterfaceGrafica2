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


        

        /*JFrame janela1 = new JFrame("Janela 1");
        janela1.setBounds(50, 50, 200, 200);
        janela1.setVisible(true);

        JFrame janela2 = new JFrame("Janela 2");
        janela2.setBounds(300, 300, 200, 200);
        janela2.setVisible(true);*/
    }
}
