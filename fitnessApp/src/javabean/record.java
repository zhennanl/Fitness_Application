package javabean;

public class record {
	
	int year;
	int mouth;
	int date;
	int bol;//0 for Exercise 1 for Food
	String type;
	String name;
	int num;
	int kcal;
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public record(int year, int mouth, int date, int bol, String type, String name,int num, int kcal) {
		super();
		this.year = year;
		this.mouth = mouth;
		this.date = date;
		this.bol = bol;
		this.type = type;
		this.name = name;
		this.num = num;
		this.kcal = kcal;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getMouth() {
		return mouth;
	}
	public void setMouth(int mouth) {
		this.mouth = mouth;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public int getBol() {
		return bol;
	}
	public void setBol(int bol) {
		this.bol = bol;
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