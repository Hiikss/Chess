package chess.game;

import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import chess.Main;

public class Piece {
	
	private static int btn = 0;
	
	public static int p = 0;
	
	public static ImageIcon ipoint = new ImageIcon(Case.class.getResource(Main.RES_PATH+"point.png"));
	public static ImageIcon icercle = new ImageIcon(Case.class.getResource(Main.RES_PATH+"cercle.png"));
	
	private static ImageIcon ipb = new ImageIcon(Case.class.getResource(Main.RES_PATH+"pb.png"));
	private static ImageIcon idb = new ImageIcon(Case.class.getResource(Main.RES_PATH+"db.png"));
	private static ImageIcon irb = new ImageIcon(Case.class.getResource(Main.RES_PATH+"rb.png"));
	private static ImageIcon ifb = new ImageIcon(Case.class.getResource(Main.RES_PATH+"fb.png"));
	private static ImageIcon icb = new ImageIcon(Case.class.getResource(Main.RES_PATH+"cb.png"));
	private static ImageIcon itb = new ImageIcon(Case.class.getResource(Main.RES_PATH+"tb.png"));
	
	private static ImageIcon ipn = new ImageIcon(Case.class.getResource(Main.RES_PATH+"pn.png"));
	private static ImageIcon idn = new ImageIcon(Case.class.getResource(Main.RES_PATH+"dn.png"));
	private static ImageIcon irn = new ImageIcon(Case.class.getResource(Main.RES_PATH+"rn.png"));
	private static ImageIcon ifn = new ImageIcon(Case.class.getResource(Main.RES_PATH+"fn.png"));
	private static ImageIcon icn = new ImageIcon(Case.class.getResource(Main.RES_PATH+"cn.png"));
	private static ImageIcon itn = new ImageIcon(Case.class.getResource(Main.RES_PATH+"tn.png"));
	
	public static boolean hasWhiteKingMoved = false;
	public static boolean hasBlackKingMoved = false;
	
	public static boolean hasTA1Moved = false;
	public static boolean hasTH1Moved = false;
	public static boolean hasTA8Moved = false;
	public static boolean hasTH8Moved = false;
	
	public static boolean grandRoqueBlanc = false;
	public static boolean petitRoqueBlanc = false;
	
	public static boolean pepkill = false;
	
	public static JButton b24 = null;
	public static JButton b31 = null;
	public static JButton b0 = null;
	public static JButton b7 = null;
	public static JButton b4 = null;
	public static JButton b28 = null;
	
	public static ArrayList<JButton> pep = new ArrayList<JButton>();
	
	public static ArrayList<JButton> piecesBlanches = new ArrayList<JButton>();
	public static ArrayList<JButton> piecesNoires = new ArrayList<JButton>();
	
	public static ArrayList<JButton> piecesAttaquantRoiBlanc = new ArrayList<JButton>();
	public static ArrayList<JButton> piecesAttaquantRoiNoir = new ArrayList<JButton>();
	
	public static ImageIcon valueToPieceIcon(int valPiece)
	{
		ImageIcon piece = null;
		switch(valPiece){
		   
	       case 1: 
	           piece = ipb;
	           break;
	   
	       case 9:
	    	   piece = idb;
	           break;
	   
	       case 500:
	    	   piece = irb;
	           break;
	           
	       case 3: 
	    	   piece = ifb;
	           break;
	   
	       case 2:
	    	   piece = icb;
	           break;
	   
	       case 5:
	    	   piece = itb;
	           break;
	           
	       case -1: 
	           piece = ipn;
	           break;
	   
	       case -9:
	    	   piece = idn;
	           break;
	   
	       case -500:
	    	   piece = irn;
	           break;
	           
	       case -3: 
	    	   piece = ifn;
	           break;
	   
	       case -2:
	    	   piece = icn;
	           break;
	   
	       case -5:
	    	   piece = itn;
	           break;

	   }
		return piece;
	}
	
	
	public static void piecePossibility(JButton piece) {
		
		JLabel possibility = null;
		
		
		int valeurPiece = Main.board[(piece.getY()-25)/75][(piece.getX()-200)/75];
		int x = piece.getX();
		int y = piece.getY();
		int l = (y-25)/75;
		int c = (x-200)/75;
		
		if(Case.buttonSelected!=null) {
			if(valeurPiece==1) {
			
				if(l==6) {
					for(int i=1;i<=2;i++) {
				
						if(Main.board[l-i][c]==0) {
							possibility=casePossible();
							possibility.setLocation(x,y-(75*i));
							Main.panel.add(possibility);
						}
						else {
							i=3;
						}
					}
				}
				else if(l>0 && Main.board[l-1][c]==0){
					possibility=casePossible();
					possibility.setLocation(x,y-75);
					Main.panel.add(possibility);
				}
				if(l>0) {
					if(c>0) {
						if(Main.board[l-1][c-1]<0) {				
							possibility=casePossibleKill();
							getButtonTarget(x-75,y-75).add(possibility);
				
						}
					}
					if(c<7) {
						if(Main.board[l-1][c+1]<0) {			
							possibility=casePossibleKill();
							getButtonTarget(x+75,y-75).add(possibility);
						}
					}
			
				}
				if(l==3) {
					Component[] components = Main.panel.getComponents();
		 			   for (Component component : components) {
		 				   if (component instanceof JButton) {
		 					   if(pep.contains(component) && (component.getX()==x+75 || component.getX()==x-75)  && component.getY()==250) {
		 						  possibility=casePossible();
		 							possibility.setLocation(component.getX(),175);
		 							Main.panel.add(possibility);
		 							pepkill=true;
		 					   }
		 				   }
		 			   }
				}
			}
			else if(valeurPiece==-1) {
			
				if(l==1) {
					for(int i=1;i<=2;i++) {		
						if(Main.board[l+i][c]==0) {
							possibility=casePossible();
							possibility.setLocation(x,y+(75*i));
							Main.panel.add(possibility);
						}
						else {
							i=3;
						}
				
					}
				}
				else if(l<7 && Main.board[l+1][c]==0){
					possibility=casePossible();
					possibility.setLocation(x,y+75);
					Main.panel.add(possibility);
				}
				if(l<7) {
					if(c>0) {
						if(Main.board[l+1][c-1]>0) {		
							possibility=casePossibleKill();
							getButtonTarget(x-75,y+75).add(possibility);			
						}
					}	
					if(c<7) {
						if(Main.board[l+1][c+1]>0) {
							possibility=casePossibleKill();
							getButtonTarget(x+75,y+75).add(possibility);
						}
					}
			
				}
				if(l==4) {
					Component[] components = Main.panel.getComponents();
		 			   for (Component component : components) {
		 				   if (component instanceof JButton) {
		 					   if(pep.contains(component) && (component.getX()==x+75 || component.getX()==x-75)  && component.getY()==325) {
		 						  possibility=casePossible();
		 							possibility.setLocation(component.getX(),400);
		 							Main.panel.add(possibility);
		 							pepkill=true;
		 					   }
		 				   }
		 			   }
				}
			
			}
			else if(valeurPiece==2 || valeurPiece==-2) {
				
				Movement.deplacementCavalier(valeurPiece,x,y,l,c,possibility);
			}
			else if(valeurPiece==3 || valeurPiece==-3) {

				Movement.deplacementDiag(valeurPiece,x,y,l,c,possibility);
			}
			else if(valeurPiece==5 || valeurPiece==-5) {
				
				Movement.deplacementLigne(valeurPiece,x,y,l,c,possibility);
			}
			else if(valeurPiece==9 || valeurPiece==-9) {
				
				Movement.deplacementDiag(valeurPiece,x,y,l,c,possibility);
				Movement.deplacementLigne(valeurPiece,x,y,l,c,possibility);
			}
			
			else if(valeurPiece==500 || valeurPiece==-500) {
				
				Movement.deplacementRoi(valeurPiece,x,y,l,c,possibility);
			}
			
		}
		
	}
	
	public static JButton valueToPieceButton()
	{
		JButton piece = new JButton();
		
		piece.setName("b"+btn);
		if(btn==24) {
			b24=piece;
		}
		if(btn==31) {
			b31=piece;
		}
		if(btn==0) {
			b0=piece;
		}
		if(btn==7) {
			b7=piece;
		}
		if(btn==4) {
			b4=piece;
		}
		if(btn==28) {
			b28=piece;
		}
		if(btn<=15) {
			piecesNoires.add(piece);
		}
		else {
			piecesBlanches.add(piece);
		}
		btn++;
		return piece;
	}
	
	public static JLabel casePossible() {
		
		JLabel possibility = new JLabel();
		possibility.setName("p"+p);
		p++;
		possibility.setIcon(ipoint);
		possibility.setSize(75,75);
		possibility.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		possibility.addMouseListener(new MouseAdapter()  
		{  
		    public void mouseReleased(MouseEvent e)  
		    {  
		    	JLabel label = (JLabel)e.getSource();
		    	JButton btn = Case.buttonSelected;
		    	int x = btn.getX();
		    	int y = btn.getY();
		    	if(label.getX()==350 && label.getY()==550 && Main.team.equals("white") && Piece.hasTA1Moved==false && Piece.hasWhiteKingMoved==false && Main.board[7][1]==0 && Main.board[7][2]==0 && Main.board[7][3]==0  && Checked.isWhiteKingAttacked(0,0)==false) {
		    		Main.board[7][2]=500;
		    		Main.board[7][3]=5;
		    		Main.board[7][0]=0;
		    		Main.board[7][4]=0;
		    		btn.setLocation(350, 550);
		    		b24.setLocation(425,550);
		    		changeTeam();
		    	}
		    	else if(label.getX()==650 && label.getY()==550 && Main.team.equals("white") && Piece.hasTH1Moved==false && Piece.hasWhiteKingMoved==false && Main.board[7][5]==0 && Main.board[7][6]==0  && Checked.isWhiteKingAttacked(0,0)==false) {
		    		Main.board[7][6]=500;
		    		Main.board[7][5]=5;
		    		Main.board[7][7]=0;
		    		Main.board[7][4]=0;
		    		btn.setLocation(650, 550);
		    		b31.setLocation(575,550);
		    		changeTeam();
		    	}
		    	else if(label.getX()==350 && label.getY()==25 && Main.team.equals("black") && Piece.hasTA8Moved==false && Piece.hasBlackKingMoved==false && Main.board[0][1]==0 && Main.board[0][2]==0 && Main.board[0][3]==0 && Checked.isBlackKingAttacked(0,0)==false) {
		    		Main.board[0][2]=-500;
		    		Main.board[0][3]=-5;
		    		Main.board[0][0]=0;
		    		Main.board[0][4]=0;
		    		btn.setLocation(350, 25);
		    		b0.setLocation(425,25);
		    		changeTeam();
		    	}
		    	else if(label.getX()==650 && label.getY()==25 && Main.team.equals("black") && Piece.hasTH8Moved==false && Piece.hasBlackKingMoved==false && Main.board[0][5]==0 && Main.board[0][6]==0 && Checked.isBlackKingAttacked(0,0)==false) {
		    		Main.board[0][6]=-500;
		    		Main.board[0][5]=-5;
		    		Main.board[0][7]=0;
		    		Main.board[0][4]=0;
		    		btn.setLocation(650, 25);
		    		b7.setLocation(575,25);
		    		changeTeam();
		    		
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
		    		changeTeam();
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
			 					Case.gameEnd("Victoire des Blancs par Mat");
			 				}
			 			}
		 				if(Main.team.equals("black") && Checked.isWhiteKingAttacked(0,0)==true) {
			 				System.out.println("Roi blanc attaqué");
			 				piecesAttaquantRoiBlanc.add(btn);
			 				if(Checkmate.isWhiteKingCheckmate(piecesAttaquantRoiBlanc)==true) {
			 					Case.gameEnd("Victoire des Noirs par Mat");
			 				}
			 			}
		 				changeTeam();
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
	 			Case.buttonSelected = null;
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
		    	JButton nbtn = Case.buttonSelected;
		    	Main.board[(btn.getY()-25)/75][(btn.getX()-200)/75]=Main.board[(nbtn.getY()-25)/75][(nbtn.getX()-200)/75];
				Main.board[(nbtn.getY()-25)/75][(nbtn.getX()-200)/75]=0;
				nbtn.setLocation(btn.getLocation());
			
	 			
	 			

	 				if(Main.team.equals("white") && Checked.isBlackKingAttacked(0,0)==true) {
		    			System.out.println("Roi Noir attaqué");
		    			piecesAttaquantRoiNoir.add(btn);	
		    			if(Checkmate.isBlackKingCheckmate(piecesAttaquantRoiNoir)==true) {
		 					Case.gameEnd("Victoire des Blancs par Mat");
		 				}
		 			}
	 				if(Main.team.equals("black") && Checked.isWhiteKingAttacked(0,0)==true) {
		 				System.out.println("Roi blanc attaqué");
		 				piecesAttaquantRoiBlanc.add(btn);
		 				if(Checkmate.isWhiteKingCheckmate(piecesAttaquantRoiBlanc)==true) {
		 					Case.gameEnd("Victoire des Noirs par Mat");
		 				}
		 			}
	 				changeTeam();
	 				
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
				if(Case.buttonSelected!=null) {
					Case.buttonSelected.setBackground(null);
	 				Case.buttonSelected.setOpaque(false);
	 				Case.buttonSelected=null;
				}
		    }	
		});
		return possibility;
		
	}
	
	public static void clearPossibility() {
		Component[] components = Main.panel.getComponents();
		for (Component component : components) {
			if (component instanceof JLabel) {
				if(component!=Case.timerBlancLabel && component!=Case.timerNoirLabel) {
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
	
	public static JButton getButtonTarget(int x, int y) {
		JButton button = null;
		if(Main.team.equals("white")) {
			for(int i=0;i<=15;i++) {
				if(piecesNoires.get(i).getX()==x && piecesNoires.get(i).getY()==y) {
					button = piecesNoires.get(i);
				}
			}
		}
		else {
			for(int i=0;i<=15;i++) {
				if(piecesBlanches.get(i).getX()==x && piecesBlanches.get(i).getY()==y) {
					button = piecesBlanches.get(i);
				}
			}
		}
		return button;
	}
	
	public static void changeTeam() {
		if(Main.team.equals("white")) {
				Main.team="black";
				Case.timerBlanc.stop();
			Case.timerNoir.start();
			}
			else {
				Main.team="white";
				Case.timerNoir.stop();
				Case.timerBlanc.start();
			}
		setCursor();
	}
	
	public static void setCursor() {
		if(Main.team.equals("white")) {
			for(int i=0;i<=15;i++) {
				piecesNoires.get(i).setCursor(null);
			}
			for(int i=0;i<=15;i++) {
				piecesBlanches.get(i).setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		}
		if(Main.team.equals("black")) {
			for(int i=0;i<=15;i++) {
				piecesNoires.get(i).setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			for(int i=0;i<=15;i++) {
				piecesBlanches.get(i).setCursor(null);
			}
		}
	}
}
