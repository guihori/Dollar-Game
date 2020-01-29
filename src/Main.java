import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;

public class Main {
	
	final static int DIMENSIONX = 800;
	final static int DIMENSIONY = 800;
	static JFrame f = new JFrame("Dollar Game");
	static ArrayList<Dollar> dollar = new ArrayList<Dollar>();
	static ArrayList<Connection> con = new ArrayList<Connection>();
	static int select; // -1 -> none selected; >=0 Dollar selected; <-1 Connection selected
	static boolean play;
	static int mouseX, mouseY;
	static boolean debug = false;
	static Scanner s = new Scanner(System.in);
	
	public static void main (String[] args) {
		
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        f.add(new Draw());
        f.pack();
        f.setVisible(true);
        
        while(true) {
        	String command = s.nextLine();
        	Events.cmd(command);
        }
        
        
        
	}
}
