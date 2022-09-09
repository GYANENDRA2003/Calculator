import javax.swing.*;
import java.awt.*;
public class Caculator {
	JFrame fr=new JFrame("Caculator");
	JTextField tb=new JTextField(0);
	JButton bt=new JButton("hello");
	public Caculator() {
		fr.setSize(600,700);
		fr.setLocationRelativeTo(null);
		fr.setResizable(false);
		fr.setVisible(true);
		addComponent();
	}
	public void addComponent() {
		
		
	}
	public static void main(String args[]) {
		new Caculator();
	}

}
