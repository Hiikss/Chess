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

	public Image getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(Image profilePicture) {
		this.profilePicture = profilePicture;
	}
	
}
