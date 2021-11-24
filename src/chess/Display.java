package chess;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import chess.game.Piece;
import chess.game.Checked;
import chess.game.Checkmate;
import chess.game.Chrono;

public class Display {
	
	public static JButton buttonSelected=null;
	
	public static ArrayList<JButton> piecesAttaquantRoiBlanc = new ArrayList<JButton>();
	public static ArrayList<JButton> piecesAttaquantRoiNoir = new ArrayList<JButton>();
	
	public static ImageIcon ipoint = new ImageIcon(Display.class.getResource(Main.RES_PATH+"point.png"));
	public static ImageIcon icercle = new ImageIcon(Display.class.getResource(Main.RES_PATH+"cercle.png"));
	
	public static boolean hasWhiteKingMoved = false;
	public static boolean hasBlackKingMoved = false;
	
	public static boolean hasTA1Moved = false;
	public static boolean hasTH1Moved = false;
	public static boolean hasTA8Moved = false;
	public static boolean hasTH8Moved = false;
	
	public static boolean pepkill = false;
	
	public static ArrayList<JButton> pep = new ArrayList<JButton>();
	
	public static int p = 0;
	
public static JLabel casePossible() {
		
		JLabel possibility = new JLabel();
		possibility.setName("p"+p);
		p++;
		possibility.setIcon(ipoint);
		possibility.setSize(75,75);
		possibility.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		possibility.addMouseListener(new MouseAdapter()  
		{  
		    public void mouseReleased(MouseEvent e) {  
		    	JLabel label = (JLabel)e.getSource();
		    	JButton btn = buttonSelected;
		    	int x = btn.getX();
		    	int y = btn.getY();
		    	if(label.getX()==350 && label.getY()==550 && Main.team.equals("white") && hasTA1Moved==false && hasWhiteKingMoved==false && Main.board[7][1]==0 && Main.board[7][2]==0 && Main.board[7][3]==0  && Checked.isWhiteKingAttacked(0,0)==false) {
		    		Main.board[7][2]=500;
		    		Main.board[7][3]=5;
		    		Main.board[7][0]=0;
		    		Main.board[7][4]=0;
		    		btn.setLocation(350, 550);
		    		Piece.b24.setLocation(425,550);
		    		Game.changeTeam();
		    	}
		    	else if(label.getX()==650 && label.getY()==550 && Main.team.equals("white") && hasTH1Moved==false && hasWhiteKingMoved==false && Main.board[7][5]==0 && Main.board[7][6]==0  && Checked.isWhiteKingAttacked(0,0)==false) {
		    		Main.board[7][6]=500;
		    		Main.board[7][5]=5;
		    		Main.board[7][7]=0;
		    		Main.board[7][4]=0;
		    		btn.setLocation(650, 550);
		    		Piece.b31.setLocation(575,550);
		    		Game.changeTeam();
		    	}
		    	else if(label.getX()==350 && label.getY()==25 && Main.team.equals("black") && hasTA8Moved==false && hasBlackKingMoved==false && Main.board[0][1]==0 && Main.board[0][2]==0 && Main.board[0][3]==0 && Checked.isBlackKingAttacked(0,0)==false) {
		    		Main.board[0][2]=-500;
		    		Main.board[0][3]=-5;
		    		Main.board[0][0]=0;
		    		Main.board[0][4]=0;
		    		btn.setLocation(350, 25);
		    		Piece.b0.setLocation(425,25);
		    		Game.changeTeam();
		    	}
		    	else if(label.getX()==650 && label.getY()==25 && Main.team.equals("black") && hasTH8Moved==false && hasBlackKingMoved==false && Main.board[0][5]==0 && Main.board[0][6]==0 && Checked.isBlackKingAttacked(0,0)==false) {
		    		Main.board[0][6]=-500;
		    		Main.board[0][5]=-5;
		    		Main.board[0][7]=0;
		    		Main.board[0][4]=0;
		    		btn.setLocation(650, 25);
		    		Piece.b7.setLocation(575,25);
		    		Game.changeTeam();
		    		
		    	}
		    	else if(pepkill==true && btn.getX()!=label.getX()) {
		    		Main.board[(label.getY()-25)/75][(label.getX()-200)/75]=Main.board[(btn.getY()-25)/75][(btn.getX()-200)/75];
		    		Main.board[(btn.getY()-25)/75][(btn.getX()-200)/75]=0;
		    		if(Main.team.equals("white")) {
		    			Main.board[(label.getY()+50)/75][(label.getX()-200)/75]=0;
		    		}
		    		else {
		    			Main.board[(label.getY()-100)/75][(label.getX()-200)/75]=0;
		    		}
		    		btn.setLocation(label.getX(), label.getY());
		    		Main.panel.remove(pep.get(0));
		    		pepkill=false;
		    		Game. changeTeam();
		    	}
		    	else {
		    		if(!pep.isEmpty()) {
		    			pep.clear();
		    		}
		    		if(Main.team.equals("white") && Main.board[(btn.getY()-25)/75][(btn.getX()-200)/75]==1 && label.getY()==btn.getY()-150 && btn.getX()==label.getX()) {
		    			pep.add(btn);
		    		}
		    		if(Main.team.equals("black") && Main.board[(btn.getY()-25)/75][(btn.getX()-200)/75]==-1 && label.getY()==btn.getY()+150 && btn.getX()==label.getX()) {
		    			pep.add(btn);
		    		}
		    		Main.board[(label.getY()-25)/75][(label.getX()-200)/75]=Main.board[(btn.getY()-25)/75][(btn.getX()-200)/75];
		    		Main.board[(btn.getY()-25)/75][(btn.getX()-200)/75]=0;
		    		btn.setLocation(label.getX(), label.getY());
		    		if(Main.team.equals("white") && Checked.isWhiteKingAttacked(0,0)==true){
		    			System.out.println("Roi blanc attaqué");			
		    			Main.board[(y-25)/75][(x-200)/75]=Main.board[(btn.getY()-25)/75][(btn.getX()-200)/75];
		    			Main.board[(btn.getY()-25)/75][(btn.getX()-200)/75]=0;
		    			btn.setLocation(x,y);
		    		}
		    		else if(Main.team.equals("black") && Checked.isBlackKingAttacked(0,0)==true) {
		 				System.out.println("Roi Noir attaqué");
		 				Main.board[(y-25)/75][(x-200)/75]=Main.board[(btn.getY()-25)/75][(btn.getX()-200)/75];
		 				Main.board[(btn.getY()-25)/75][(btn.getX()-200)/75]=0;
		 				btn.setLocation(x,y);
		 			}	
		 			else {
		 				if(Main.team.equals("white") && Checked.isBlackKingAttacked(0,0)==true) {
			    			System.out.println("Roi Noir attaqué");
			    			piecesAttaquantRoiNoir.add(btn);	
			    			if(Checkmate.isBlackKingCheckmate(piecesAttaquantRoiNoir)==true) {
			 					Game.gameEnd("Victoire des Blancs par Mat");
			 				}
			 			}
		 				if(Main.team.equals("black") && Checked.isWhiteKingAttacked(0,0)==true) {
			 				System.out.println("Roi blanc attaqué");
			 				piecesAttaquantRoiBlanc.add(btn);
			 				if(Checkmate.isWhiteKingCheckmate(piecesAttaquantRoiBlanc)==true) {
			 					Game.gameEnd("Victoire des Noirs par Mat");
			 				}
			 			}
		 				Game.changeTeam();
		 			}
		    		if(btn.getName().equals("b0") && hasTA8Moved==false) {
		    			hasTA8Moved=true;
		    		}
		    		if(btn.getName().equals("b7") && hasTH8Moved==false) {
		    			hasTH8Moved=true;
		    		}
		    		if(btn.getName().equals("b24") && hasTA1Moved==false) {
		    			hasTA1Moved=true;
		    		}
		    		if(btn.getName().equals("b31") && hasTH1Moved==false) {
		    			hasTH1Moved=true;
		    		}
		    		if(btn.getName().equals("b4") && hasBlackKingMoved==false) {
		    			hasBlackKingMoved=true;
		    		}
		    		if(btn.getName().equals("b28") && hasWhiteKingMoved==false) {
		    			hasWhiteKingMoved=true;
		    		}
		    	}
		    	if(!piecesAttaquantRoiBlanc.isEmpty()) {
		    		piecesAttaquantRoiBlanc.clear();
		    	}
		    	if(!piecesAttaquantRoiNoir.isEmpty()) {
		    		piecesAttaquantRoiNoir.clear();
		    	}
		    	btn.setBackground(null);
	 			btn.setOpaque(false);
	 			buttonSelected = null;
	 			clearPossibility();
	 			Main.panel.repaint();
	 			Main.panel.revalidate();
	 			System.out.println(piecesAttaquantRoiBlanc);
		    }	
		}); 
		return possibility;
		
	}
	
	public static JLabel casePossibleKill() {
		
		JLabel possibility = new JLabel();
		possibility.setName("p"+p);
		p++;
		possibility.setIcon(icercle);
		possibility.setSize(75,75);
		possibility.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		possibility.addMouseListener(new MouseAdapter()  
		{  
		    public void mouseReleased(MouseEvent e)  
		    {  
		    	JButton btn = (JButton) possibility.getParent();
		    	JButton nbtn = buttonSelected;
		    	Main.board[(btn.getY()-25)/75][(btn.getX()-200)/75]=Main.board[(nbtn.getY()-25)/75][(nbtn.getX()-200)/75];
				Main.board[(nbtn.getY()-25)/75][(nbtn.getX()-200)/75]=0;
				nbtn.setLocation(btn.getLocation());

	 				if(Main.team.equals("white") && Checked.isBlackKingAttacked(0,0)==true) {
	 					System.out.println("Roi Noir attaqué");
		    			piecesAttaquantRoiNoir.add(btn);
		    			if(Checkmate.isBlackKingCheckmate(piecesAttaquantRoiNoir)==true) {
		 					Game.gameEnd("Victoire des Blancs par Mat");
		 				}
		 			}
	 				if(Main.team.equals("black") && Checked.isWhiteKingAttacked(0,0)==true) {
		 				System.out.println("Roi blanc attaqué");
		 				piecesAttaquantRoiBlanc.add(btn);
		 				if(Checkmate.isWhiteKingCheckmate(piecesAttaquantRoiBlanc)==true) {
		 					Game.gameEnd("Victoire des Noirs par Mat");
		 				}
		 			}
	 				Game.changeTeam();
	 				
				Main.getInstance().remove(btn);
				
				if(btn.getName().equals("b0") && hasTA8Moved==false) {
	    			hasTA8Moved=true;
	    		}
	    		if(btn.getName().equals("b7") && hasTH8Moved==false) {
	    			hasTH8Moved=true;
	    		}
	    		if(btn.getName().equals("b24") && hasTA1Moved==false) {
	    			hasTA1Moved=true;
	    		}
	    		if(btn.getName().equals("b31") && hasTH1Moved==false) {
	    			hasTH1Moved=true;
	    		}
	    		if(btn.getName().equals("b4") && hasBlackKingMoved==false) {
	    			hasBlackKingMoved=true;
	    		}
	    		if(btn.getName().equals("b28") && hasWhiteKingMoved==false) {
	    			hasWhiteKingMoved=true;
	    		}
	    		
				btn.setLocation(0, 0);
				if(!piecesAttaquantRoiBlanc.isEmpty()) {
		    		piecesAttaquantRoiBlanc.clear();
		    	}
		    	if(!piecesAttaquantRoiNoir.isEmpty()) {
		    		piecesAttaquantRoiNoir.clear();
		    	}
			    clearPossibility();
			    Main.panel.repaint();
			    Main.panel.revalidate();
				if(buttonSelected!=null) {
					buttonSelected.setBackground(null);
	 				buttonSelected.setOpaque(false);
	 				buttonSelected=null;
				}
		    }	
		});
		return possibility;
		
	}
	
	public static void clearPossibility() {
		Component[] components = Main.panel.getComponents();
		for (Component component : components) {
			if (component instanceof JLabel) {
				if(component!=Chrono.timerBlancLabel && component!=Chrono.timerNoirLabel) {
		        Main.panel.remove(component);
				}
		    }
			if (component instanceof JButton) {
		        Component[] buttons = ((Container) component).getComponents();
		        JButton btn = (JButton) component;
		        for (Component comp : buttons) {
		        	if (comp instanceof JLabel) {
				        btn.remove(comp);
				    }
		        }
		    }
		
		} 
		p=0;
	}
	
	public static void displayPossibilty(JButton piece) {
		int pieceValue = Main.board[(piece.getY()-25)/75][(piece.getX()-200)/75];
		clearPossibility();
		if((Main.team.equals("white")&& pieceValue>0) || (Main.team.equals("black")&& pieceValue<0)) {
			if(buttonSelected!=null) {
				buttonSelected.setBackground(null);
				buttonSelected.setOpaque(false);
				if(buttonSelected!=piece) {
					piece.setBackground(Color.decode("#348339"));
					buttonSelected = piece;
					piece.setOpaque(true);
				}
				else {
					buttonSelected = null;
				}
			
			}
			else {
				piece.setBackground(Color.decode("#348339"));
				buttonSelected = piece;
				piece.setOpaque(true);
			}
			Game.piecePossibility(piece);
		
	}
		Main.panel.repaint();
		Main.panel.revalidate();
		
	}

}
