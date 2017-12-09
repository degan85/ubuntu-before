package cuppon;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;


public class UserTest {
	
	@Ignore @Test
	public void testAddCouppn() throws Exception {
		User user = new User("degan");
		assertEquals("before receive coupon", 0,user.getTotalCoupponCount());
		
		Icoupon coupon = new DummyCoupon();
		
		User.addCoupon(coupon);
		assertEquals("after receive coupon", 1, user.getTotalCouponCount());
		
	}
	
	@Ignore @Test
	public void testGetLastOccupiedCoupon() throws Exception {
		User user = new User("degan");
		Icoupon eventCoupon = new StubCoupon();
		user.addCoupon(eventCoupon);
		Icoupon lastCoupon = user.getLastOccupiedCoupon();
		
		assertEquals("coupon discount percent", 7, lastCoupon.getDiscountPercent());
		assertEquals("coupon's name", "VIP coupon!!", userCoupon.getName());
	}
	
	@Test
	public void testGetOrderPrice_discountAbleItem() throws Exception {
		PriceCalculator calculator = new PriceCalculator();
		//new Item(name, category, price)
		Item item = new Item("LightSavor","knife",100000);
		Icoupon coupon = new StubCoupon();
		
		assertEquals("discounted price", 93000,calculator.getOrderPrice(item, coupon));
	}
	
	@Test
	public void testGetOrderPrice_undiscountableItem() throws Exception {
		PriceCalculator calculator = new PriceCalculator();
		
		Item item = new Item("R2D2","alert clock",20000);
		Icoupon coupon = new StubCoupon();
		
		assertEquals("can not be able apply coupon for item", 20000, calculator.getOrderPrice(item, coupon));
		
	}
	
	@Test
	public void testGetOrderPrice() throws Exception {
		PriceCalculator calculator = new PriceCalculator();
		
		Item item = new Item("R3D2","alert clock",20000);
		Icoupon coupon = new FakeCoupon();
		
		assertEquals( 20000, calculator.getOrderPrice(item, coupon));
		
	}
	
	@Test
	public void testGetOrderPrice_useSpy() throws Exception {
		List mockedList = mock(List.class);

		when(mockedList.get(0)).thenReturn("item");
		when(mockedList.size()).thenReturn(1);
		
		System.out.println(mockedList.get(0));
		System.out.println(mockedList.size());
		System.out.println(mockedList.get(2));
		
		PriceCalculator calculator = new PriceCalculator();
		
		Item item = new Item("R2D3","alert clock",100);
		Icoupon coupon = new SpyCoupon();
		
		assertEquals( 93, calculator.getOrderPrice(item, coupon));
		
		int methodCallCount = ((SpyCoupon)coupon).getIsAppliableCallCount();
		assertEquals("called methoed count", 1, methodCallCount);
	}
	
	@Test(expected=RuntimeException.class)
	public void testException() throws Exception {
		List mockedList = mock(List.class);
		
		when(mockedList.get(1)).thenThrow(new RuntimeException());
		
		System.out.println(mockedList.get(1));
		assertTrue(true);
	}
}
