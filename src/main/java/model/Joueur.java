package model;

import javax.swing.ImageIcon;

public class Joueur {
	
	private String name;
	private ImageIcon profilePicture;

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public ImageIcon getIcon() {
		return profilePicture;
	}

	public void setIcon(ImageIcon profilePicture) {
		this.profilePicture = profilePicture;
	}
	
}
