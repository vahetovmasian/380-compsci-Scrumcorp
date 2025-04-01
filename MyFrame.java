import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MyFrame extends JFrame{
    ImageIcon img = new ImageIcon("icons/frameIcon.png");
    
    MyFrame(){
        this.setIconImage(img.getImage());
        this.setLayout(new BorderLayout());
        this.setTitle("GUI");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1350,800);
        this.setVisible(true);
    }
}
