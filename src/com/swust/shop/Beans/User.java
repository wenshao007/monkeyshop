package com.swust.shop.Beans;

public class User {
		private String  USER_ID;
		private String  USER_NAME;
		private String  USER_PASSWORD;
		private String  USER_SEX;
		private String  USER_BIRTHDAY;
		private String  USER_IDENITY_COD;
		private String  USER_EMAIL;
		private String  USER_MOBILE;
		private String  USER_ADDRESS;
		private String  USER_STATUS;

		public User(String uSER_ID, String uSER_NAME, String uSER_PASSWORD, String uSER_SEX, String uSER_BIRTHDAY,
				String uSER_IDENITY_COD, String uSER_EMAIL, String uSER_MOBILE, String uSER_ADDRESS,
				String uSER_STATUS) {
			super();
			USER_ID = uSER_ID;
			USER_NAME = uSER_NAME;
			USER_PASSWORD = uSER_PASSWORD;
			USER_SEX = uSER_SEX;
			USER_BIRTHDAY = uSER_BIRTHDAY;
			USER_IDENITY_COD = uSER_IDENITY_COD;
			USER_EMAIL = uSER_EMAIL;
			USER_MOBILE = uSER_MOBILE;
			USER_ADDRESS = uSER_ADDRESS;
			USER_STATUS = uSER_STATUS;
		}

		public String getUSER_ID() {
			return USER_ID;
		}

		public void setUSER_ID(String uSER_ID) {
			USER_ID = uSER_ID;
		}

		public String getUSER_NAME() {
			return USER_NAME;
		}

		public void setUSER_NAME(String uSER_NAME) {
			USER_NAME = uSER_NAME;
		}

		public String getUSER_PASSWORD() {
			return USER_PASSWORD;
		}

		public void setUSER_PASSWORD(String uSER_PASSWORD) {
			USER_PASSWORD = uSER_PASSWORD;
		}

		public String getUSER_SEX() {
			return USER_SEX;
		}

		public void setUSER_SEX(String uSER_SEX) {
			USER_SEX = uSER_SEX;
		}

		public String getUSER_BIRTHDAY() {
			return USER_BIRTHDAY;
		}

		public void setUSER_BIRTHDAY(String uSER_BIRTHDAY) {
			USER_BIRTHDAY = uSER_BIRTHDAY;
		}

		public String getUSER_IDENITY_COD() {
			return USER_IDENITY_COD;
		}

		public void setUSER_IDENITY_COD(String uSER_IDENITY_COD) {
			USER_IDENITY_COD = uSER_IDENITY_COD;
		}

		public String getUSER_EMAIL() {
			return USER_EMAIL;
		}

		public void setUSER_EMAIL(String uSER_EMAIL) {
			USER_EMAIL = uSER_EMAIL;
		}

		public String getUSER_MOBILE() {
			return USER_MOBILE;
		}

		public void setUSER_MOBILE(String uSER_MOBILE) {
			USER_MOBILE = uSER_MOBILE;
		}

		public String getUSER_ADDRESS() {
			return USER_ADDRESS;
		}

		public void setUSER_ADDRESS(String uSER_ADDRESS) {
			USER_ADDRESS = uSER_ADDRESS;
		}

		public String getUSER_STATUS() {
			return USER_STATUS;
		}

		public void setUSER_STATUS(String uSER_STATUS) {
			USER_STATUS = uSER_STATUS;
		}
		
		
		
}
