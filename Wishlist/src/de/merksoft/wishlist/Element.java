package de.merksoft.wishlist;

import java.io.Serializable;

public class Element implements Serializable{

	private static final long serialVersionUID = 7921107012373376231L;
	

	//	private Image picture;
	private String name;
	private String description;
	
	public Element(String name, String description){
		this.name = name;
		this.description = description; 
	}

	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}

}
