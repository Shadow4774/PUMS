package it.enaip.corso.model;

public class User {
	protected int id;
	protected String name;
	protected String surname;
	protected int age;
	protected String department;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(int id) {
		this.id = id;
	}
	
	public User(String name, String surname, int age, String department) {
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.department = department;
	}
	
	public User(int id, String name, String surname, int age, String department) {
		this(name, surname, age, department);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
}
