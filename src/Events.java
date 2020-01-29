import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class Events {
	
	public static void click(int x, int y) {
		
		//click play button
		if( x < 20 && y < 20) {
			if (Main.play)
				Main.play = false;
			else
				Main.play = true;
			Main.select = -1;
		}
		else if (!Main.play){
			//if no drag
			if(Main.mouseX == x && Main.mouseY == y) {
				
				
				Main.select = findCircle(x, y);
				if (Main.select == -1) {
					Main.select = - (2 + findCon(x,y));
				}
				
				
				//create new circle
				if(x - 15 <= 0)
					x = 15;
				if(y - 15 <= 0)
					y = 15;
				if(x + 15 >= Main.DIMENSIONX)
					x = Main.DIMENSIONX - 15;
				if(y + 15 >= Main.DIMENSIONY)
					y = Main.DIMENSIONY - 15;
				
				if(Main.select == -1) {
					Main.dollar.add(new Dollar(x,y));
				}
			}
			else {	//drag
				//test if movement started and ended in two distinct circles
				int pressLoc = findCircle(Main.mouseX,Main.mouseY);
				int releaseLoc = findCircle(x,y);
				if(releaseLoc != -1 && releaseLoc != -1 && pressLoc != releaseLoc) {
					Main.con.add(new Connection(pressLoc,releaseLoc));
					Main.dollar.get(pressLoc).addCon(Main.con.size() - 1);
					Main.dollar.get(releaseLoc).addCon(Main.con.size() - 1);
				}
				//attempt to drag a circle
				else if(Main.select == pressLoc) {
					Main.dollar.get(pressLoc).changeCoords(x, y);
					for (int i : Main.dollar.get(pressLoc).getConList()){
						Main.con.get(i).updateAngle();
					}
				}
			}
		}
		else {
			if(Main.mouseX == x && Main.mouseY == y && findCircle(x,y) != -1) {
				int circleClicked = findCircle(x,y);
				Dollar circle = Main.dollar.get(findCircle(x,y));
				circle.setMoney((Integer.parseInt(circle.getMoney()) - circle.getConList().size()) + "");
				for(int i : circle.getConList()) {
					int otherDollar = Main.con.get(i).getOtherDollar(circleClicked);
					Main.dollar.get(otherDollar).setMoney((Integer.parseInt(Main.dollar.get(otherDollar).getMoney()) + 1) + "");
				}
			}
		}
	}
	
	public static int findCircle(int x, int y) {
		int j = 0;
			for(Dollar i : Main.dollar) {
				if(Math.sqrt( Math.pow((x - i.getX()),2) + Math.pow((y - i.getY()),2)) < 20) {
					return j;
				}
				j++;
			}
		return -1;
	}
	
	public static int findCon(int x, int y) {
		int j = 0;
		for(Connection i : Main.con) {
			double slope = ((double)(Main.dollar.get(i.getDollar1()).getY() - Main.dollar.get(i.getDollar2()).getY()))/(double)((Main.dollar.get(i.getDollar1()).getX() - Main.dollar.get(i.getDollar2()).getX()));
			// find distance between the point and line. refer to the .txt file
			if((Math.sqrt(Math.pow((x-(-(-x/slope - y - slope*Main.dollar.get(i.getDollar1()).getX() + Main.dollar.get(i.getDollar1()).getY())/(1/slope + slope))),2) + Math.pow((y-(-((-(-x/slope - y -slope*Main.dollar.get(i.getDollar1()).getX() + Main.dollar.get(i.getDollar1()).getY())/(1/slope + slope)) - x)/slope + y)),2)) < 10
			   || Main.dollar.get(i.getDollar1()).getX() == Main.dollar.get(i.getDollar2()).getX())
			// make sure that click was within the line segment
			   && ((x > Main.dollar.get(i.getDollar1()).getX() - 5 && x < Main.dollar.get(i.getDollar2()).getX() + 5)
			   || (x > Main.dollar.get(i.getDollar2()).getX() - 5 && x < Main.dollar.get(i.getDollar1()).getX() + 5))
			   && (((y > Main.dollar.get(i.getDollar1()).getY() - 5 && y < Main.dollar.get(i.getDollar2()).getY() + 5))
			   || (y > Main.dollar.get(i.getDollar2()).getY() - 5 && y < Main.dollar.get(i.getDollar1()).getY() + 5))) {
				return j;
			}
			j++;
		}
	return -1;
	}
	
	public static void keyPressed (KeyEvent e) {
		if (Main.select != -1) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_TAB:
				Main.select ++;
				if (Main.select >= Main.dollar.size())
					Main.select = 0;
				break;
			case KeyEvent.VK_1:
				Main.dollar.get(Main.select).addDigitMoney(1);
				break;
			case KeyEvent.VK_2:
				Main.dollar.get(Main.select).addDigitMoney(2);
				break;
			case KeyEvent.VK_3:
				Main.dollar.get(Main.select).addDigitMoney(3);
				break;
			case KeyEvent.VK_4:
				Main.dollar.get(Main.select).addDigitMoney(4);
				break;
			case KeyEvent.VK_5:
				Main.dollar.get(Main.select).addDigitMoney(5);
				break;
			case KeyEvent.VK_6:
				Main.dollar.get(Main.select).addDigitMoney(6);
				break;
			case KeyEvent.VK_7:
				Main.dollar.get(Main.select).addDigitMoney(7);
				break;
			case KeyEvent.VK_8:
				Main.dollar.get(Main.select).addDigitMoney(8);
				break;
			case KeyEvent.VK_9:
				Main.dollar.get(Main.select).addDigitMoney(9);
				break;
			case KeyEvent.VK_0:
				Main.dollar.get(Main.select).addDigitMoney(0);
				break;
			case KeyEvent.VK_MINUS:
				Main.dollar.get(Main.select).invertMoney();
				break;
			case KeyEvent.VK_BACK_SPACE:
				Main.dollar.get(Main.select).removeDigitMoney();
				break;
			case KeyEvent.VK_DELETE:
				if (Main.select >= 0) {
					Main.dollar.remove(Main.select);
					for(Connection i : Main.con) {
						if(i.getDollar1() == Main.select || i.getDollar2() == Main.select)
							Main.con.remove(i);
					}
				}
				else {
					Main.con.remove(-2 - Main.select);
				}
				Main.select = -1;
				Main.f.repaint();
				break;
			}
			System.out.println(Main.dollar.get(Main.select).getMoney());
		}
	}
	
	public static void cmd(String command) {
		String cmd[] = command.split(" ");
		switch (cmd[0]) {
		case "debugView":
			if (cmd[1].equals("1") || cmd[1].equals("true")) {
				Main.debug = true;
				Main.f.repaint();
			}
			else if (cmd[1].equals("0") || cmd[1].equals("false")) {
				Main.debug = false;
				Main.f.repaint();
			}
			else {
				System.out.println("DebugView = " + Main.debug);
			}
		}
	}
}
