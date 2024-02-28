package mypage;
import java.sql.Date;

public class ProductPlanManagementDTO {
	String itemCode;
	String itemName;
	int outgoing;
	int quantity;
	int makeAmount;
	int remainAmount;
	Date startdate;
	Date enddate;
	
	
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemName() {
		return itemName;
	}
	public int getOutgoing() {
		return outgoing;
	}
	public void setOutgoing(int outgoing) {
		this.outgoing = outgoing;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getMakeAmount() {
		return makeAmount;
	}
	public void setMakeAmount(int makeAmount) {
		this.makeAmount = makeAmount;
	}
	public int getRemainAmount() {
		return remainAmount;
	}
	public void setRemainAmount(int remainAmount) {
		this.remainAmount = remainAmount;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	
	@Override
	public String toString() {
		return "ProductPlanManagementDTO [itemCode=" + itemCode + ", itemName=" + itemName + ", outgoing=" + outgoing
				+ ", quantity=" + quantity + ", makeAmount=" + makeAmount + ", remainAmount=" + remainAmount
				+ ", startdate=" + startdate + ", enddate=" + enddate + "]";
	}
}
