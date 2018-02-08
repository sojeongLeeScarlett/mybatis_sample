package kr.or.dgit.mybatis_study.dto;

public class PhoneNumber {
	private String countryCode;
	private String stateCode;
	private String number;
	public PhoneNumber() {}
	public PhoneNumber(String countryCode, String stateCode, String number) {
		super();
		this.countryCode = countryCode;
		this.stateCode = stateCode;
		this.number = number;
	}
	@Override
	public String toString() {
		return String.format("phoneNumber [countryCode=%s, stateCode=%s, number=%s]", countryCode, stateCode, number);
	}
	
	public  PhoneNumber(String str) {
		if(str != null) {
			String[] parts = str.split("-");
			if(parts.length>0) {
				this.countryCode = parts[0];
			}
			if(parts.length>1) {
				this.stateCode = parts[1];
			}
			if(parts.length>2) {
				this.number = parts[2];			}
		}
	}
	
	
}
