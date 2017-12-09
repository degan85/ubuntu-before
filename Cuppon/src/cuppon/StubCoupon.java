package cuppon;

public class StubCoupon implements Icoupon {

	public String getName() {
		return "VIP coupon!!";
	}

	public boolean isValid() {
		return true;
	}

	public int getDiscountPercent() {
		return 7;
	}

	public boolean isAppliable(Item item) {
		
		if(item.getName().equals("LightSavor")){
			return true;
		}else if(item.getName().equals("D2B2")){
			return false;
		}
		return false;
	}

	public void doExpire() {
	}

}
