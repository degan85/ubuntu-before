package test;

import static org.junit.Assert.assertEquals;
import main.Account;

import org.junit.Before;
import org.junit.Test;

public class AccountTest {
	
	private Account account;


	@Before
	public void setup() {
		account = new Account(10000);
	}

	@Test
	public void testAccount_생성자생성테스() throws Exception{
		setup();	//TODO setUp
	}


	@Test
	public void testGetBalance_잔액조회_테스트() throws Exception {
		assertEquals(10000, account.getBalance());
		
		account = new Account(1000);
		assertEquals(1000, account.getBalance());
		
		account = new Account(0);
		assertEquals(0, account.getBalance());
	}
	
	
	@Test
	public void testDeposit_입금테스트() throws Exception {
		account.deposite(1000);
		assertEquals(11000, account.getBalance());
	}
	

	@Test
	public void testWithdraw_출금테스트() throws Exception {
		account.withdraw(1000);
		assertEquals(9000, account.getBalance());
	}
	
	@Test(expected=NumberFormatException.class)
	public void testException_예외처리_테스트() throws Exception {
		String value = "g108";
		System.out.println(Integer.parseInt(value));
	}
	
	@Test
	public void testArrayAssertEquals_배열테스트() throws Exception {
		String [] names = {"Tom", "Jimmy", "Johin"};
		String [] anoterNames = {"Tom", "Jimmy", "Johin"};
		assertEquals(names, anoterNames);
	}
}
