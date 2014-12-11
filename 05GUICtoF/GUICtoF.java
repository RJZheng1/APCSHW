import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUICtoF extends JFrame implements ActionListener{
    private Container pane;
    private JTextField celsius;
    private JTextField fahrenheit;
    private JLabel l1;
    private JLabel l2;
    private JButton FtoC;
    private JButton CtoF;

    public GUICtoF(){
	this.setTitle("Celsius to Fahrenheit Converter");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new GridLayout(3,3));
	FtoC = new JButton("Convert Fahrenheit to Celsius");
	CtoF = new JButton("Convert Celsius to Fahrenheit");
	l1 = new JLabel("Celsius",null,JLabel.LEFT);
	l2 = new JLabel("Fahrenheit",null,JLabel.LEFT);
	celsius = new JTextField(40);
	fahrenheit = new JTextField(40);

	FtoC.setActionCommand("FtoC");
	FtoC.addActionListener(this);
	CtoF.setActionCommand("CtoF");
	CtoF.addActionListener(this);

	pane.add(l1);
	pane.add(celsius);
	pane.add(l2);
	pane.add(fahrenheit);
	pane.add(FtoC);
	pane.add(CtoF);
    }
    public void actionPerformed(ActionEvent e){
	String action = e.getActionCommand();
	if(action.equals("FtoC")){
	    double ftemp = Double.parseDouble(fahrenheit.getText());
	    ftemp = (ftemp-32)/1.8;
	    celsius.setText(""+ftemp);
	}
	if(action.equals("CtoF")){
	    double ctemp = Double.parseDouble(celsius.getText());
	    ctemp = ctemp*1.8+32;
	    fahrenheit.setText(""+ctemp);
	}
    }   
    public static void main(String[] args){
	GUICtoF converter = new GUICtoF();
	converter.setVisible(true);
    }
}
