import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.security.cert.CertificateParsingException;

public class Calculator {
    JFrame fr=new JFrame("Calculator");
    JTextField tb=new JTextField("0");
    JButton [] bt=new JButton[20];
    JPanel pa=new JPanel();
    public  Calculator(){
        fr.setSize(600,700);
        fr.setLocationRelativeTo(null);
        fr.setDefaultCloseOperation(3);
        fr.setResizable(false);
        fr.setLayout(null);
        addTextBox();
        fr.setVisible(true);

    }
    private void addTextBox(){
        tb.setBounds(20,20,550,55);
        tb.setFont(new Font("arial",0,25));
        tb.setHorizontalAlignment(JTextField.RIGHT);////zero ko right may karne ke liye
        tb.setEditable(false);
        tb.setBackground(Color.white);
        tb.setBorder(BorderFactory.createLineBorder(Color.black,4));
        fr.add(tb);
        addButton();

    }
    private void addButton(){
        pa.setBounds(20,100,550,475);
        pa.setBackground(Color.green);
        fr.add(pa);
        pa.setLayout(new GridLayout(5,4,10,15));
        String [] str={"Back","CE","C","%","7","8","9","/","4","5","6","*","1","2","3","-","0",".","=","+"};
        Font fo=new Font("arial",0,30);
        CalListener listener=new CalListener();
        for(int i=0;i<20;i++){
            bt[i]=new JButton(str[i]);
            bt[i].addActionListener(listener);
            bt[i].setFont(fo);
            if(i==3 || i==7 || i==11 || i==15 || i==18 || i==19 ){
                bt[i].setForeground(Color.red);
            }
            else{
                bt[i].setForeground(Color.blue);
            }
            pa.add(bt[i]);
        }
    }
    class CalListener implements ActionListener{

    	int num1;
    	int c=0;
    	String cb="";
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton bb=(JButton)e.getSource();
			String t1=bb.getText();
			String t2=tb.getText();
			///for airthmetic button
			if(bb==bt[7] || bb==bt[11] || bb==bt[15] || bb==bt[19]) {
				if(t2.equals("0"))
					return;
				cal();
				c=1;
				cb=t1;
				num1=Integer.parseInt(tb.getText());
			}
			////for digits button
			if(bb==bt[4]|| bb==bt[5]|| bb==bt[6]||bb==bt[8]||bb==bt[9]||bb==bt[10]||bb==bt[12]||bb==bt[13]||bb==bt[14]||bb==bt[16]) {
				if(t2.equals("0")|| c==1) {
					tb.setText(t1);
				           c=0;
				}
				else {
			       tb.setText(t2+t1);}
		   }
			if(bb==bt[0]) {///back button
				///int num=Integer.parseInt(t2);//convert it text box into integer
				///num=num/10;
				///tb.setText(String.valueOf(num)); //it covert integer value into string
				if(t2.length()==1) {
					tb.setText("0");
					return;
				}
				t2=t2.substring(0,t2.length()-1);
				tb.setText(t2);
			}
			if(bb==bt[1]) {//CE button
				tb.setText("0");
			}
			if(bb==bt[2]) {//c button
				tb.setText("0");
				num1=0;
				cb="";
				c=0;
			}
			if(bb==bt[18]) {//equal button
				cal();
				
				
			}
			
			
		}
		private void cal() {
			int num2=Integer.parseInt(tb.getText());
			if(cb.equals("+")) {
				int res1=num1+num2;
				tb.setText(String.valueOf(res1));
			}
			else if(cb.equals("*")) {
				int res2=num1*num2;
				tb.setText(String.valueOf(res2));
			}
			else if(cb.equals("-")){
				int res3=num1-num2;
				tb.setText(String.valueOf(res3));
			}
			else if(cb.equals("/")) {
				int res4=num1/num2;
				tb.setText(String.valueOf(res4));
				
			}
		}
    }
    public static void main(String args[]){
        new Calculator();

    }
}
