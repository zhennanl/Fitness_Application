package javabean;

public class User {
	
	String Username;
	int Age;
	int Gender;//0 for Female, 1 for Male
	
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public int getGender() {
		return Gender;
	}
	public void setGender(int gender) {
		Gender = gender;
	}
	public User(String username, int age, int gender) {
		super();
		Username = username;
		Age = age;
		Gender = gender;
	}
	
	
	
}
