package cuppon;

import java.util.ArrayList;
import java.util.List;

public class FakeCoupon implements Icoupon {

	List<String> categoryList = new ArrayList();
	
	public FakeCoupon(){
		categoryList.add("R2D2");
		categoryList.add("R2D3");
		categoryList.add("R2D4");
		
	}
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
		
		if(this.categoryList.contains(item.getName())){
			return true;
		}
		return false;
	}

	public void doExpire() {
	}

}
