package cuppon;

import java.util.ArrayList;
import java.util.List;

public class SpyCoupon implements Icoupon {

	List<String> categoryList = new ArrayList();
	private int isAppliableCallCount;
	
	public SpyCoupon(){
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
		isAppliableCallCount++;	//if call this method, increase number
		if(this.categoryList.contains(item.getName())){
			return true;
		}
		return false;
	}
	public int getIsAppliableCallCount(){
		return this.isAppliableCallCount;
	}
	public void doExpire() {
	}

}
