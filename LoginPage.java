import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.concurrent.Flow;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;

public class LoginPage extends JPanel implements ActionListener{
    static JPanel containerPanel = new JPanel(); 
    static JPanel centerPanel = new JPanel(); 
    static JPanel loginPanel = new JPanel();

    JTextField usernameField = new JTextField(); 
    JTextField passwordField = new JTextField(); 
    JLabel usernameText = new JLabel("Username");
    JLabel passwordText = new JLabel("Password");
    JLabel loginText = new JLabel("LOGIN");
    JButton loginButton = new JButton("Sign In");


    Border border = BorderFactory.createLineBorder(Color.black, 1);

    
    LoginPage(){
        loginText.setBounds(170,30,200,50);
        loginText.setFont(new Font("Helvetica",Font.PLAIN, 16));

        loginButton.setBounds(155,280, 80, 40);
        loginButton.addActionListener(this);

        usernameField.setBounds(20,120,360,40);
        usernameField.setBorder(border); 
        usernameField.setFont(new Font("Helvetica",Font.PLAIN, 14));
        usernameText.setBounds(21,85,100,50);
        usernameText.setVerticalAlignment(JLabel.CENTER);
        usernameText.setFont(new Font("Helvetica",Font.PLAIN, 16));

        passwordField.setBounds(20,200,360,40); 
        passwordField.setBorder(border); 
        passwordText.setBounds(21,165,100,50);
        passwordText.setVerticalAlignment(JLabel.CENTER);
        passwordText.setFont(new Font("Helvetica",Font.PLAIN, 16)); 

        loginPanel.setLayout(null);
        loginPanel.setPreferredSize(new Dimension(400,400));
        loginPanel.setBackground(Color.WHITE);
        loginPanel.add(usernameField); 
        loginPanel.add(passwordField); 
        loginPanel.add(usernameText);
        loginPanel.add(passwordText);
        loginPanel.add(loginText); 
        loginPanel.add(loginButton); 

        centerPanel.add(loginPanel);
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.setBackground(Color.BLACK);  

        containerPanel.setLayout(new BorderLayout());
        containerPanel.add(centerPanel,BorderLayout.CENTER);
    }
    

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==loginButton){
            Window.displayProductListingPage();     
        }
    }
}
