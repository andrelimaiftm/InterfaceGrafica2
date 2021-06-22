package br.edu.iftm.interfacegrafica2.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;



public class TelaLogin extends JPanel{
    
    private final Color  COR_FUNDO = Color.decode("#f9f9f9");
    private JLabel labelContaRiot;
    private JLabel imagemFundo;
    private JTextField campoUsuario;
    //private JPasswordField campoSenha;
    private  JTextField campoSenha;
    private  JButton botaoLogar;
    private JLabel imagemLogo;
    
    public TelaLogin(){
        this.setBackground(this.COR_FUNDO);
        this.setLayout(null);        
        this.iniciarInterface();
    }

    private void iniciarInterface(){
        this.imagemLogo = this.criarImagem("logo.png", new Rectangle(150, 30, 59, 59));
        /*this.imagemLogo = new JLabel("");
        ImageIcon logo = new ImageIcon(this.getClass().getResource("imagens/logo.png"));
        this.imagemLogo.setIcon(logo);
        this.imagemLogo.setBounds(150, 30, 59, 59);*/

        labelContaRiot = new JLabel("Fazer login");
        //labelContaRiot.setBounds(50, 50, 100, 20);
        labelContaRiot.setBounds(118, 125, 150, 30);
        labelContaRiot.setFont(new Font("Tahoma", Font.BOLD, 22));
        labelContaRiot.setForeground(Color.decode("#111111"));

        this.imagemFundo = this.criarImagem("fundo.jpg", new Rectangle(340, 0, 940, 700));
        //this.imagemFundo = new JLabel("");
       //ImageIcon fundo = new ImageIcon(this.getClass().getResource("imagens/fundo.jpg"));
       //System.out.println("Diretorio: ");
       //System.out.println(this.getClass().getResource("imagens/fundo.jpg"));
        //this.imagemFundo.setIcon(fundo);
        //this.imagemFundo.setBounds(340, 0, 940, 700);

        this.campoUsuario = new JTextField();
        //this.campoUsuario.setBounds(45, 190, 260, 50);
        this.campoUsuario = this.alterarEstiloCampo(/*this.campoUsuario,*/ "NOME DE USUÁRIO",190);
        //campoUsuario.setBackground(Color.decode("#ededed"));
        //campoUsuario.setBorder(new EmptyBorder(0,0,0,0));
        //this.campoUsuario.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(), BorderFactory.createEmptyBorder(15, 15, 15, 15)));
        //this.campoUsuario.setFont(new Font("Tahoma",Font.BOLD, 12));
        //this.campoUsuario.setForeground(Color.decode("#999999"));

        //this.campoSenha =  new JPasswordField("SENHA");
        this.campoSenha =  new JTextField();
        //this.campoSenha.setBounds(45, 250, 260, 50);
        this.campoSenha = this.alterarEstiloCampo(/*this.campoSenha,*/ "SENHA",250);
        //this.campoSenha.setBackground(Color.decode("#ededed"));        
        //this.campoSenha.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(), BorderFactory.createEmptyBorder(15, 15, 15, 15)));
        //this.campoSenha.setFont(new Font("Tahoma",Font.BOLD, 12));
        //this.campoSenha.setForeground(Color.decode("#999999"));
        
        this.botaoLogar = new JButton("Entrar");
        botaoLogar.setBounds(101, 435, 113, 45);
        botaoLogar.setBackground(COR_FUNDO);
        botaoLogar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
                //System.out.println("Fez o login");
                String usuario = campoUsuario.getText();
                String senha = campoSenha.getText();
                String mensagem = String.format("Você fez o login!\nLogin: %s\nSenha: %s", usuario, senha);  
                if(usuario.trim().equals("pedro") && 
                    senha.trim().equals("1234")){
                        //acertou usuario e a senha
                        JOptionPane.showMessageDialog(null, mensagem, "Login", JOptionPane.PLAIN_MESSAGE);
                }else{
                    //errou usuario e senha
                    JOptionPane.showMessageDialog(null, "Senha inválida!", "Login", JOptionPane.ERROR_MESSAGE);
                }
                //JOptionPane.showMessageDialog(null, mensagem);
            }
        });

        this.add(imagemLogo);
        this.add(labelContaRiot);
        this.add(campoUsuario);
        this.add(campoSenha);
        this.add(imagemFundo);
        this.add(botaoLogar);
        
        //JPanel panel = new JPanel();
        //panel.add(comp);
    }

    public JLabel criarImagem(String nomeImagem, Rectangle bounds){
        JLabel labelImage = new JLabel("");
        //nomeIagem = "logo.png"
        // "imagens/" + "logo.png" = "imagens/logo.png"
        ImageIcon imagem = new ImageIcon(this.getClass().getResource("imagens/"+nomeImagem));
        labelImage.setIcon(imagem);
        labelImage.setBounds(bounds);
        return labelImage;
    }

    private JTextField/*void*/ alterarEstiloCampo(/*JTextField campo,*/ String placeHolder, int posicaoY){
        JTextField campo = new JTextField(placeHolder);
        
        //atualiza  a mensagem do campo
        campo.setText(placeHolder);
        //posicao na tela
        campo.setBounds(45, posicaoY, 260, 50);
        //cor da fonte
        campo.setBackground(Color.decode("#ededed"));        
        //define a bborda e o espaçamento interno
        campo.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(), BorderFactory.createEmptyBorder(15, 15, 15, 15)));
        //estilo da fonte (negrito e tamanho)
        campo.setFont(new Font("Tahoma",Font.BOLD, 12));
        //cor da fonte
        campo.setForeground(Color.decode("#999999"));

        campo.addFocusListener(new FocusListener(){

            @Override
            public void focusGained(FocusEvent e) {
                if(campo.getText().equals(placeHolder)){
                    campo.setText("");
                }
                
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(campo.getText().isEmpty()){
                    campo.setText(placeHolder);
                }
                
            }
            
        });

        return campo;
    }
}
