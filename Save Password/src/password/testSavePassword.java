package password;

import org.junit.Test;


public class testSavePassword {

	@Test
	public void testSavePwd() throws Exception {
		UserRegister register = new UserRegister();
		
		String userId = "degan";
		String password = "cho";
		
		register.savePassword(userId,password);
		assertEquals(password,getPassword(userId));
	}

	private Object getPassword(String userId) {
		// TODO Auto-generated method stub
		return null;
	}
}
