package main;

public class Account {
	private int balance;
	
	public Account(int money) {
		this.balance = money;
	}

	public int getBalance(){
		return this.balance;
	}

	public void deposite(int money) {
		this.balance+=money;
	}

	public void withdraw(int money) {
		this.balance-=money;
	}

}
