package cuppon;

public class DummyCoupon implements Icoupon {

	public String getName() {
		return null;
	}

	public boolean isValid() {
		return false;
	}

	public int getDiscountPercent() {
		return 0;
	}

	public boolean isAppliable(Item item) {
		return false;
	}

	public void doExpire() {
	}

}
