package cuppon;

public class PriceCalculator {

	public int getOrderPrice(Item item, Icoupon coupon) {
		//coupon validate
		if(coupon.isValid() && coupon.isAppliable(item)){
			return (int)(item.getPrice()*getDiscountRate(coupon.getDiscountPercent()) );
		}
		return item.getPrice();
	}
	
	private double getDiscountRate(int percent){
		return (100-percent)/100d;
	}

}
