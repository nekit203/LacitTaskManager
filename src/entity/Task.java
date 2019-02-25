package entity;

import java.util.Date;

public class Task extends Entity {

    private static final long serialVersionUID = 1L;

    private User user;

    enum nameTask{
    	disembarking("Высадка"),
    	treatment("Лечение"),
    	destruction("Уничтожение");
    	private String rusName;
        public String getCode(){return rusName;}
        public void setCode(String code){this.rusName = rusName;}
        private nameTask(String code){this.rusName = rusName;}
    }
    
    private String text;

    private Date date;
    
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
    
    

}
