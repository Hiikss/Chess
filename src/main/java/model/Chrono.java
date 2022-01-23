package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.Timer;

/** 
 * La classe <b>Chrono</b> appartient au package <b>model</b>.
 * Cette classe créer un timer pour l'équipe blanche et l'équipe noir.
 */

public class Chrono {
	
	public static JLabel timerBlancLabel = new JLabel();
	public static JLabel timerNoirLabel = new JLabel();
	
	public static Timer timerBlanc;	
	public static Timer timerNoir;	
	public static int secondBlanc, minuteBlanc, secondNoir, minuteNoir, msBlanc, msNoir;
	public static String ddSecondBlanc, ddMinuteBlanc, ddSecondNoir, ddMinuteNoir;	
	public static DecimalFormat dFormat = new DecimalFormat("00");
	
	public static void countdownTimer() {
		
		timerBlanc = new Timer(10, new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					msBlanc--;
					
					if(msBlanc==-1) {
						msBlanc = 59;
						secondBlanc--;
						ddSecondBlanc = dFormat.format(secondBlanc);
						ddMinuteBlanc = dFormat.format(minuteBlanc);	
						timerBlancLabel.setText(ddMinuteBlanc + ":" + ddSecondBlanc);
					}
					if(secondBlanc==-1) {
						secondBlanc = 59;
						minuteBlanc--;
						ddSecondBlanc = dFormat.format(secondBlanc);
						ddMinuteBlanc = dFormat.format(minuteBlanc);	
						timerBlancLabel.setText(ddMinuteBlanc + ":" + ddSecondBlanc);
					}
					if(minuteBlanc==0 && secondBlanc==0 && msBlanc==0) {
						
						//Game.gameEnd("Victoire des Noirs au temps");
					}
				}
			});	
		
		timerNoir = new Timer(10, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				msNoir--;
				
				if(msNoir==-1) {
					msNoir = 59;
					secondNoir--;
					ddSecondNoir = dFormat.format(secondNoir);
					ddMinuteNoir = dFormat.format(minuteNoir);	
					timerNoirLabel.setText(ddMinuteNoir + ":" + ddSecondNoir);
				}
				
				if(secondNoir==-1) {
					secondNoir = 59;
					minuteNoir--;
					ddSecondNoir = dFormat.format(secondNoir);
					ddMinuteNoir = dFormat.format(minuteNoir);	
					timerNoirLabel.setText(ddMinuteNoir + ":" + ddSecondNoir);
				}
				if(minuteNoir==0 && secondNoir==0 && msNoir==0) {
					//Game.gameEnd("Victoire des Blancs au temps");
				}
			}
		});	
		}

}
