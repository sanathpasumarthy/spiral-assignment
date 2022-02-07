package com.spiral.assignment.model;

public class StatusFeed extends AbstractCardFeed
{
	private static final long serialVersionUID = 2L;
	
	private String cardTitle      = null;
	private String icon    = null;
	private String message = null;	
	private String buttonText  = null;
	
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getButtonText() {

//		String condition = getCondition();
//		
//		if(condition != null && !condition.isBlank())
//		{
//			if(condition.equals("time-constrained") || condition.equals("age-constrained"))
//			{
//				buttonText = "View Restrictions.";
//				cardTitle      = null;
//				icon    = null;
//				message = "Card Restricted.";
//				setAuthor(null);
//			}
//		}
		
		return buttonText;
	}
	public void setButtonText(String button) {
		this.buttonText = button;
	}
	public String getCardTitle() {
		return cardTitle;
	}
	public void setCardTitle(String cardTitle) {
		this.cardTitle = cardTitle;
	}	
}
