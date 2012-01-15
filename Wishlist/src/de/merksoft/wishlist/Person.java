package de.merksoft.wishlist;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Person implements Serializable{
	
	private static final long serialVersionUID = -7921684538694302331L;
	
	private List<Element> elementList;
	private String name;
	private Timestamp timeCreated;
	private Date lastChange;
	
	public Person(String name){
		this.elementList = new ArrayList<Element>();
		this.name = name;
		this.timeCreated = new Timestamp(System.currentTimeMillis());
		
		Calendar c = Calendar.getInstance();
		this.lastChange = c.getTime();
	}
	
	public Date getLastChange() {
		return lastChange;
	}

	public void addElement(Element element){
		this.elementList.add(element);
	}

	public List<Element> getElementList(){
		return this.elementList;
	}

	public String getName() {
		return name;
	}

	public Timestamp getTimeCreated() {
		return timeCreated;
	}
	
}
