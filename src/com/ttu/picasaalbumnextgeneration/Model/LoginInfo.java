package com.ttu.picasaalbumnextgeneration.Model;

public class LoginInfo {
	
	public String id;
	public String userName;
	public boolean isLoggedIn;
	
	public LoginInfo(String id, String userName) {
		this.id = id;
		this.userName = userName;
		this.isLoggedIn = false;
	}

	public void setLoggedId(boolean isLoggedIn)
	{
		this.isLoggedIn = isLoggedIn;
	}
	
	public boolean getLoggedIn()
	{
		return this.isLoggedIn;
	}
	
	@Override
	public String toString() {
		return userName;
	}
}
