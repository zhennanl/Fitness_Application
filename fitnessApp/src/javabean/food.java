package javabean;

public class food {
	String type;
	String name;
	String unit;
	int kcal;
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
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public int getKcal() {
		return kcal;
	}
	public void setKcal(int kcal) {
		this.kcal = kcal;
	}
	public food(String type, String name, String unit, int kcal) {
		super();
		this.type = type;
		this.name = name;
		this.unit = unit;
		this.kcal = kcal;
	}
	
	
	
	
}
