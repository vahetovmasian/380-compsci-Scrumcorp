import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;

public class MyFrame extends JFrame implements ActionListener{


    MyFrame() {
        this.setTitle("GUI");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,400);
        this.setVisible(true);
    
        //frame.setLayout(null);
        //frame.setLayout(new GridLayout(3,4)); //new GridLayout(4,3,1,1)
           
        }


    public void actionPerformed(ActionEvent e) {

    }

}
