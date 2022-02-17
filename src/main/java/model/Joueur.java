package model;

import java.awt.Image;

public class Joueur {
	
	private String name;
	private Image profilePicture;

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public Image getIcon() {
		return profilePicture;
	}

	public void setIcon(Image profilePicture) {
		this.profilePicture = profilePicture;
	}
	
}
