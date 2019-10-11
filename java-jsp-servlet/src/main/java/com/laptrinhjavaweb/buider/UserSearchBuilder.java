package com.laptrinhjavaweb.buider;

public class UserSearchBuilder {
	private String userName;

	private String fullName;
	private String phone;
	private String email;
	private String staffId;
	public String getPhone() {
		return phone;
	}


	public String getEmail() {
		return email;
	}


	public String getStaffId() {
		return staffId;
	}


	public String getUsername() {
		return userName;
	}
	
	
	public String getUserName() {
		return userName;
	}


	public String getFullName() {
		return fullName;
	}
	private UserSearchBuilder(Builder builder) {
		this.userName=builder.userName;
		this.fullName=builder.fullName;
		this.email=builder.email;
		this.phone=builder.phone;
		this.staffId=builder.staffId;
	}


	public static class Builder{
		private String userName;

		private String fullName;
		private String phone;
		private String email;
		private String staffId;
		
		
		public Builder setPhone(String phone) {
			this.phone = phone;
			return this;
		}


		public Builder setEmail(String email) {
			this.email = email;
			return this;
		}


		public Builder setStaffId(String staffId) {
			this.staffId = staffId;
			return this;
		}


		public Builder setUserName(String userName) {
			this.userName = userName;
			return this;
		}


		public Builder setFullName(String fullName) {
			this.fullName = fullName;
			return this;
		}


		public UserSearchBuilder build() {
			return new UserSearchBuilder(this);
		}
	}
}
