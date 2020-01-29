import java.util.ArrayList;

public class Dollar {
	private int x,y;
	private String money = "";
	private ArrayList<Integer> conList = new ArrayList<Integer>();
	
	public Dollar(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void changeCoords(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void addDigitMoney(int money) {
		this.money = this.money + money;
	}
	
	public void removeDigitMoney() {
		money = money.substring(0, money.length() - 1);
	}
	
	public void invertMoney() {
		if('-' == money.charAt(0)) {
			money = money.substring(1, money.length());
		}
		else {
			money = "-" + money;
		}
	}
	
	public String getMoney() {
		return money;
	}
	
	public void setMoney(String money) {
		this.money = money;
	}
	
	public void addCon(int con) {
		this.conList.add(con);
	}
	
	public ArrayList<Integer> getConList(){
		return conList;
	}
}
