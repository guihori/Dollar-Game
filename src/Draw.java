import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

class Draw extends JPanel{
	private final int dimensionX = Main.DIMENSIONX;
	private final int dimensionY = Main.DIMENSIONY;

	public Draw() {
        setBorder(BorderFactory.createLineBorder(Color.black));

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
            	Main.mouseX = e.getX();
            	Main.mouseY = e.getY();
            }
            public void mouseReleased(MouseEvent e) {
            	Events.click(e.getX(),e.getY());
            	repaint();
            }
        });
        
        this.setFocusable(true);
        this.requestFocus();
        this.setFocusTraversalKeysEnabled(false);
        this.addKeyListener(new KeyAdapter(){
        	public void keyPressed(KeyEvent e) {
        		Events.keyPressed(e);
        		repaint();
        	}
        });
        
        
    }
	
	public Dimension getPreferredSize() {
	      return new Dimension(dimensionX,dimensionY);
	}
	
	protected void paintComponent(Graphics g) {
		   super.paintComponent(g);
		   
		   Graphics2D g2 =(Graphics2D)g;
		   
		   
		   
		   g2.drawRect(0, 0, 20, 20);
		   if(Main.play) {
			   g2.fillRect(5, 2, 4, 16);
			   g2.fillRect(13, 2, 4, 16);
		   }
		   else {
			   g2.fillPolygon(new int[]{2,2,18,18},new int[]{2,18,9,10}, 4);
		   }
		   
		   int j = -2;
		   for(Connection i : Main.con) {
			   int x1 = Main.dollar.get(i.getDollar1()).getX();
			   int x2 = Main.dollar.get(i.getDollar2()).getX();
			   int y1 = Main.dollar.get(i.getDollar1()).getY();
			   int y2 = Main.dollar.get(i.getDollar2()).getY();
			   g2.drawLine(x1 + (int)(20*Math.cos(i.getAngle())),
					   	   y1 + (int)(20*Math.sin(i.getAngle())),
					   	   x2 - (int)(20*Math.cos(i.getAngle())),
					   	   y2 - (int)(20*Math.sin(i.getAngle())));
			   if (j == Main.select) {
				   g2.setColor(Color.CYAN);
				   g2.drawLine(x1 + (int)(2*Math.cos((i.getAngle() + Math.PI/2))), 
						   	   y1 + (int)(2*Math.sin((i.getAngle() + Math.PI/2))), 
						   	   x2 + (int)(2*Math.cos((i.getAngle() + Math.PI/2))), 
						   	   y2 + (int)(2*Math.sin((i.getAngle() + Math.PI/2))));
				   g2.drawLine(x1 + (int)(2*Math.cos((i.getAngle() - Math.PI/2))), 
					   	   	   y1 + (int)(2*Math.sin((i.getAngle() - Math.PI/2))), 
					   	   	   x2 + (int)(2*Math.cos((i.getAngle() - Math.PI/2))), 
					   	   	   y2 + (int)(2*Math.sin((i.getAngle() - Math.PI/2))));
				   g2.setColor(Color.BLACK);
			   }
			   j--;
		   }
		   
		   j = 0;
		   for(Dollar i : Main.dollar) {
			   
			   g2.setColor(Color.WHITE);
			   g2.fillOval(i.getX() - 20, i.getY() - 20, 40, 40);
			   g2.setColor(Color.BLACK);
			   g2.drawOval(i.getX() - 20, i.getY() - 20, 40, 40);
			   g2.drawString(i.getMoney(), i.getX() + 1 - (i.getMoney().length() * 7) / 2 , i.getY() + 5);
			   if(j == Main.select) {
				   g2.setColor(Color.CYAN);
				   g2.drawOval(i.getX() - 19, i.getY() - 19, 38, 38);
				   g2.drawOval(i.getX() - 21, i.getY() - 21, 42, 42);	
				   g2.setColor(Color.BLACK);
				   
			   }
			   j++;
		   }
		   
		   
		   //debug view
		   if(Main.debug) {
			   for(int x = 0; x < Main.DIMENSIONX; x++) {
				   for(int y = 0; y < Main.DIMENSIONY; y++) {
					   int click = Events.findCircle(x, y);
					   if (click == -1)
						   click = - (2 + Events.findCon(x,y));
					   if(click >= 0) {
						   g2.setColor(Color.RED);
					   }
					   else if(click < -1) {
						   g2.setColor(Color.GREEN);
					   }
					   else {
						   g2.setColor(Color.GRAY);
					   }
					   g2.drawLine(x, y, x, y);
				   }
			   }
		   }
		   g2.setColor(Color.BLACK);
		   
		   
		   
	}
	
}
