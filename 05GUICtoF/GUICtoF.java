import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUICtoF extends JFrame{
    private Container pane;
    private JButton FtoC;
    private JButton CtoF;
    private JLabel label;
    private JTextField textfield;
    public GUICtoF(){
	this.setTitle("Celsius to Fahrenheit Converter");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());
	FtoC = new JButton("Convert Fahrenheit to Celsius");
	CtoF = new JButton("Convert Celsius to Fahrenheit");
	textfield = new JTextField(12);
	label = new JLabel("",null,JLabel.CENTER);
	pane.add(textfield);
	pane.add(FtoC);
	pane.add(CtoF);
	pane.add(label);

    }
    public static void main(String[] args){
	GUICtoF converter = new GUICtoF();
	converter.setVisible(true);
    }
}