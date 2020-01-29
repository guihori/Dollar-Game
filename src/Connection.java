
public class Connection {
	private int dollar1, dollar2;
	private double angle;
	
	public Connection (int dollar1, int dollar2) {
		this.dollar1 = dollar1;
		this.dollar2 = dollar2;
		this.angle =  Math.atan((double)(Main.dollar.get(dollar2).getY() - Main.dollar.get(dollar1).getY()) / (double)(Main.dollar.get(dollar2).getX() - Main.dollar.get(dollar1).getX()));
	}
	
	public int getDollar1() {
		return dollar1;
	}
	
	public int getDollar2() {
		return dollar2;
	}
	
	public int getOtherDollar(int dollar) {
		return (dollar == dollar1)? dollar2 : dollar1;
	}
	
	public double getAngle() {
		return angle;
	}
	
	public void updateAngle() {
		this.angle =  Math.atan((double)(Main.dollar.get(dollar2).getY() - Main.dollar.get(dollar1).getY()) / (double)(Main.dollar.get(dollar2).getX() - Main.dollar.get(dollar1).getX()));
	}
}
