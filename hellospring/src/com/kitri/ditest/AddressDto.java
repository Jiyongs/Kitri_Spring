package com.kitri.ditest;

public class AddressDto {

	private String zipcode;
	private String address;
	private String addressDetail;
	
	// [생성자]
	public AddressDto() {
		
	}
	
	public AddressDto(String zipcode, String address, String addressDetail) {
		super();
		this.zipcode = zipcode;
		this.address = address;
		this.addressDetail = addressDetail;
	}

	// [setter]
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	// [toString]
	@Override
	public String toString() {
		return "AddressDto [zipcode=" + zipcode + ", address=" + address + ", addressDetail=" + addressDetail + "]";
	}
	
}
