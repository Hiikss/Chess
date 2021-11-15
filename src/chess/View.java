package chess;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.Timer;

public class View {
	
	public static JLabel timerBlancLabel = new JLabel();
	public static JLabel timerNoirLabel = new JLabel();
	
	public static Timer timerBlanc;	
	public static Timer timerNoir;	
	public static int secondBlanc, minuteBlanc, secondNoir, minuteNoir, msBlanc, msNoir;
	public static String ddSecondBlanc, ddMinuteBlanc, ddSecondNoir, ddMinuteNoir;	
	public static DecimalFormat dFormat = new DecimalFormat("00");
	
	public static void gameEnd(String reason) {
		timerNoir.stop();
		timerBlanc.stop();
		JLabel label = new JLabel();
		label.setText(reason);
		label.setFont(new Font("Arial",Font.PLAIN,20));
		label.setBounds(50, 50, 300, 50);
		Main.fin.add(label);
		Main.fin.setVisible(true);
	}

	
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
						gameEnd("Victoire des Noirs au temps");
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
					gameEnd("Victoire des Blancs au temps");
				}
			}
		});	
		}
	
}
