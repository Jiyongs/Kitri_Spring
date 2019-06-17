package com.kitri.ditest;

public class MemberDto {

	private String id;
	private String name;
	private int age;
	private double money;
	private AddressDto addressDto;
	
	// [생성자]
	public MemberDto() {
		
	}
	
	public MemberDto(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public MemberDto(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public MemberDto(String name, double money) {
		super();
		this.name = name;
		this.money = money;
	}

	public MemberDto(String id, String name, int age, double money) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.money = money;
	}
	
	public MemberDto(String id, String name, int age, double money, AddressDto addressDto) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.money = money;
		this.addressDto = addressDto;
	}

	// [setter]
	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public void setAddressDto(AddressDto addressDto) {
		this.addressDto = addressDto;
	}

	// [toString]
	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", name=" + name + ", age=" + age + ", money=" + money + ", addressDto="
				+ addressDto + "]";
	}
	
}
