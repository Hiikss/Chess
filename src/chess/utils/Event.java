package chess.utils;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import chess.Main;
import chess.game.Case;

public class Event {
	
	public static java.awt.event.ActionListener btnclicked = 
	 		   new java.awt.event.ActionListener(){
	 		   public void actionPerformed(ActionEvent e) {
	 			   JButton btn = (JButton)e.getSource();
	 				System.out.println(Main.board[(btn.getY()-25)/75][(btn.getX()-200)/75]);
	 				System.out.println(btn.getName());
	 				if(Main.team.equals("white")&&Main.board[(btn.getY()-25)/75][(btn.getX()-200)/75]<0 || Main.team.equals("black")&&Main.board[(btn.getY()-25)/75][(btn.getX()-200)/75]>0) {
		 				  if(Case.buttonSelected!=null) {
		 						Case.buttonSelected.setBackground(null);
		 						Case.buttonSelected.setOpaque(false);
		 						Case.buttonSelected = null;
		 				  }
		 			   }
	 				Case.diplayPossibilty(btn);
	 			  
	 		   }
		};
}
