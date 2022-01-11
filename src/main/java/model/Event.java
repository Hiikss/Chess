package model;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

import log4j2.Log4j;
import view.Display;

/** 
 * La classe <b>Event</b> appartient au package <b>model</b>.
 * Elle comprend une méthode permettant d'actualiser l'affichage à chaque actions.
 * @see <b>actionPerformed<b>
 */

public class Event {
	
	public static java.awt.event.ActionListener btnclicked = 
	 		   new java.awt.event.ActionListener(){
	 		   public void actionPerformed(ActionEvent e) {
	 			   JButton btn = (JButton)e.getSource();
	 			    Log4j.logInfo(String.valueOf(Main.board[(btn.getY()-25)/75][(btn.getX()-200)/75]));
	 			    Log4j.logInfo(btn.getName());
	 				if(Main.team.equals("white")&&Main.board[(btn.getY()-25)/75][(btn.getX()-200)/75]<0 || Main.team.equals("black")&&Main.board[(btn.getY()-25)/75][(btn.getX()-200)/75]>0) {
		 				  if(Display.buttonSelected!=null) {
		 					 Display.buttonSelected.setBackground(null);
		 					Display.buttonSelected.setOpaque(false);
		 					Display.buttonSelected = null;
		 				  }
		 			   }
	 				int pieceValue = Main.board[(btn.getY()-25)/75][(btn.getX()-200)/75];
	 				Display.clearPossibility();
	 				if((Main.team.equals("white")&& pieceValue>0) || (Main.team.equals("black")&& pieceValue<0)) {
	 					if(Display.buttonSelected!=null) {
	 						Display.buttonSelected.setBackground(null);
	 						Display.buttonSelected.setOpaque(false);
	 						if(Display.buttonSelected!=btn) {
	 							btn.setBackground(Color.decode("#348339"));
	 							Display.buttonSelected = btn;
	 							btn.setOpaque(true);
	 						}
	 						else {
	 							Display.buttonSelected = null;
	 						}
	 					
	 					}
	 					else {
	 						btn.setBackground(Color.decode("#348339"));
	 						Display.buttonSelected = btn;
	 						btn.setOpaque(true);
	 					}
	 					Game.piecePossibility(btn);
	 				
	 			}
	 				Main.panel.repaint();
	 				Main.panel.revalidate();
	 			  
	 		   }
		};
}
