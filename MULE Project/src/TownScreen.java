import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;


public class TownScreen extends Screen {
	public TownScreen(){
		super(Color.MAGENTA); //Creates screen with background color Blue
		setBorder(new LineBorder(new Color(0, 0, 0), 5));
		setBackground(Color.ORANGE);
		setPreferredSize(new Dimension(1700,900));
		setLayout(new GridLayout(3, 3, 566, 300));
		
		
	}
	public static void main(String[] args){
		
	}
}
