package javabean;

public class sport {
	String type;
	String name;
	int kcal;
	public sport(String type, String name, int kcal) {
		super();
		this.type = type;
		this.name = name;
		this.kcal = kcal;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKcal() {
		return kcal;
	}
	public void setKcal(int kcal) {
		this.kcal = kcal;
	}
	
	
	
}
