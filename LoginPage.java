import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class LoginPage extends JPanel implements ActionListener{
    static JPanel containerPanel = new JPanel(); 
    static JPanel centerPanel = new JPanel(); 
    static JPanel loginPanel = new JPanel();

    JTextField usernameField = new JTextField(); 
    JPasswordField passwordField = new JPasswordField(); 
    JLabel usernameLabel = new JLabel("Username");
    JLabel passwordLabel = new JLabel("Password");
    JLabel loginLabel = new JLabel("LOGIN");
    JButton loginButton = new JButton("Sign In");
    JButton clearButton = new JButton("Clear "); 
    JButton createAccountButton = new JButton("create account");
    static JLabel emailDoesNotExistLabel = new JLabel("Email does not exist!"); 
    static JLabel incorrectPasswordLabel = new JLabel("Incorrect Password!"); 
    static JLabel loginSuccessfulLabel = new JLabel("Login Successful!");
    JButton titleButton = new JButton("CALIBRI VINYLS"); 
    static JLabel accountCreatedLabel = new JLabel("Account Created!"); 
    static JLabel accountAlreadyExistsLabel = new JLabel("Account already exists!"); 
    static JLabel fieldsCannotContainLabel = new JLabel("Fields cannot contain \",\" and can't be empty"); 

    Border border = BorderFactory.createLineBorder(Color.black, 1);

    LoginPage(){
        fieldsCannotContainLabel.setBounds(21,165,350,175);
        fieldsCannotContainLabel.setFont(new Font("Helvetica",Font.PLAIN, 14));

        accountAlreadyExistsLabel.setBounds(21,165,250,175);
        accountAlreadyExistsLabel.setFont(new Font("Helvetica",Font.PLAIN, 14));

        accountCreatedLabel.setBounds(130,30,200,50);
        accountCreatedLabel.setFont(new Font("Helvetica",Font.PLAIN, 16));

        loginSuccessfulLabel.setBounds(130,30,200,50);
        loginSuccessfulLabel.setFont(new Font("Helvetica",Font.PLAIN, 16));

        emailDoesNotExistLabel.setBounds(21,165,250,175);
        emailDoesNotExistLabel.setFont(new Font("Helvetica",Font.PLAIN, 14));

        emailDoesNotExistLabel.setBounds(21,165,250,175);
        emailDoesNotExistLabel.setFont(new Font("Helvetica",Font.PLAIN, 14));

        incorrectPasswordLabel.setBounds(21,165,250,175); 
        incorrectPasswordLabel.setFont(new Font("Helvetica",Font.PLAIN, 14)); 

        loginLabel.setBounds(170,30,200,50);
        loginLabel.setFont(new Font("Helvetica",Font.PLAIN, 16));

        createAccountButton.setBounds(100,330,200,40);
        createAccountButton.setFont(new Font("Helvetica",Font.PLAIN, 16));
        createAccountButton.addActionListener(this);

        loginButton.setBounds(100,280, 100, 40);
        loginButton.setFont(new Font("Helvetica",Font.PLAIN, 16));
        loginButton.addActionListener(this);
        
        clearButton.setBounds(200,280, 100, 40);
        clearButton.setFont(new Font("Helvetica",Font.PLAIN, 16));
        clearButton.addActionListener(this);

        usernameField.setBounds(20,120,360,40);
        usernameField.setBorder(border); 
        usernameField.setFont(new Font("Helvetica",Font.PLAIN, 14));
        usernameLabel.setBounds(21,85,100,50);
        usernameLabel.setVerticalAlignment(JLabel.CENTER);
        usernameLabel.setFont(new Font("Helvetica",Font.PLAIN, 16));

        passwordField.setBounds(20,200,360,40); 
        passwordField.setBorder(border); 
        passwordLabel.setBounds(21,165,100,50);
        passwordLabel.setVerticalAlignment(JLabel.CENTER);
        passwordLabel.setFont(new Font("Helvetica",Font.PLAIN, 16)); 

        loginPanel.setLayout(null);
        loginPanel.setPreferredSize(new Dimension(400,600));
        //loginPanel.setBackground(new Color(249, 246, 238));
        loginPanel.add(usernameField); 
        loginPanel.add(passwordField); 
        loginPanel.add(usernameLabel);
        loginPanel.add(passwordLabel);
        loginPanel.add(loginLabel); 
        loginPanel.add(loginButton); 
        loginPanel.add(clearButton);
        loginPanel.add(createAccountButton);

        centerPanel.add(loginPanel);
        //centerPanel.setBackground(new Color(249, 246, 238));
        centerPanel.setLayout(new GridBagLayout());

        
        JPanel header = new JPanel(); 
        JPanel topPanel = new JPanel();
        titleButton.setFont(new Font("Helvetica", Font.PLAIN,65));
        titleButton.setForeground(Color.white);
        titleButton.setBorderPainted(false);
        titleButton.setFocusPainted(false);
        titleButton.addActionListener(this);
        header.setBackground(Color.black);
        header.add(titleButton);
        topPanel.setLayout(new GridBagLayout());
        topPanel.add(header);
        topPanel.setPreferredSize(new Dimension(500,140));
        topPanel.setBackground(Color.black);



        containerPanel.setLayout(new BorderLayout());
        containerPanel.add(topPanel,BorderLayout.NORTH);
        containerPanel.add(centerPanel,BorderLayout.CENTER);
    }

    public static void removeAllPopups(){                 // removes all popup labels in the loginPanel. 
        loginPanel.remove(incorrectPasswordLabel);
        loginPanel.remove(emailDoesNotExistLabel);
        loginPanel.remove(accountAlreadyExistsLabel);
        loginPanel.remove(fieldsCannotContainLabel); 
        loginPanel.remove(accountCreatedLabel);
        loginPanel.remove(loginSuccessfulLabel);
        loginPanel.revalidate();
        loginPanel.repaint();
    }
    

    public void actionPerformed(ActionEvent e) {
        String username = usernameField.getText(); 
        String password = String.valueOf(passwordField.getPassword()); 

        if(e.getSource()==clearButton){           //clears fields and labels in the loginLabel. 
            LoginPage.removeAllPopups();
            loginPanel.add(loginLabel);
            usernameField.setText("");
            passwordField.setText("");
            loginPanel.revalidate();
            loginPanel.repaint();
        }

        if(e.getSource()==titleButton){                 // turns the title into a button to return to ProductListingPage. 
            WindowManager.displayProductListingPage();
            LoginPage.removeAllPopups(); 
            loginPanel.add(loginLabel);
            usernameField.setText("");
            passwordField.setText("");
            loginPanel.revalidate();
            loginPanel.repaint();
        }

        if(e.getSource()==loginButton){    // button that handles the login procedure. 
            try {
                loginPanel.add(loginLabel); 

                if(Account.checkIfAccountExists(username)){
                    LoginPage.removeAllPopups();

                    if(Account.checkIfPasswordIsCorrect(username,password)){   //Correct username and password
                        LoginPage.removeAllPopups();
                        loginPanel.remove(loginLabel); 
                        loginPanel.add(loginSuccessfulLabel);
                        usernameField.setText("");
                        passwordField.setText("");
                        loginPanel.revalidate();
                        loginPanel.repaint();

                    } else {
                        LoginPage.removeAllPopups();
                        loginPanel.add(incorrectPasswordLabel); 
                        passwordField.setText("");
                        loginPanel.revalidate();
                        loginPanel.repaint();
                    }

                } else {
                    LoginPage.removeAllPopups();
                    loginPanel.add(emailDoesNotExistLabel);
                    passwordField.setText("");
                    loginPanel.revalidate();
                    loginPanel.repaint();
                }
            } catch (FileNotFoundException e1) {}

        }

        if(e.getSource()==createAccountButton){                                 // button that handles the create account procedure. 
            if(username.contains(",")||username.contains(" ")||username.isEmpty()||password.contains(",")||password.contains(" ")||password.isEmpty()){
                LoginPage.removeAllPopups(); 
                loginPanel.add(loginLabel);
                loginPanel.add(fieldsCannotContainLabel);
                loginPanel.revalidate();
                loginPanel.repaint();
            } else {
                try {
                    if(Account.checkIfAccountExists(username)){     // if account already exits
                        LoginPage.removeAllPopups(); 
                        loginPanel.add(accountAlreadyExistsLabel);
                        loginPanel.revalidate();
                        loginPanel.repaint();
                    } else {
                        LoginPage.removeAllPopups();
                        Account.createAccount(username, password);  // if account does NOT exist 
                        loginPanel.remove(loginLabel); 
                        loginPanel.add(accountCreatedLabel);
                        passwordField.setText("");
                        loginPanel.revalidate();
                        loginPanel.repaint();
                    }
                } catch (IOException e1) {e1.printStackTrace();}
            }
        }
    }
}