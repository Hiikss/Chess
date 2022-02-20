package model;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.Timer;

public class Chrono {
	
	private Model model;
	
	private JLabel timerBlancLabel = new JLabel();
	private JLabel timerNoirLabel = new JLabel();
	
	private Timer timerBlanc;	
	private Timer timerNoir;	
	public int secondBlanc, minuteBlanc, secondNoir, minuteNoir, msBlanc, msNoir;
	private String ddSecondBlanc, ddMinuteBlanc, ddSecondNoir, ddMinuteNoir;	
	private DecimalFormat dFormat = new DecimalFormat("00");
	
	public Chrono(Model model) {
		this.model = model;
	}
	
	public void countdownTimer() {
		
		msBlanc = 0;
		secondBlanc = 0;
		minuteBlanc = 10;
		ddSecondBlanc = dFormat.format(secondBlanc);
		ddMinuteBlanc = dFormat.format(minuteBlanc);
		timerBlancLabel.setText(ddMinuteBlanc + ":" + ddSecondBlanc);
		timerBlancLabel.setBounds(75, 575, 150, 30);
		timerBlancLabel.setFont(new Font("Arial",Font.PLAIN,29));
		
		msNoir = 0;
		secondNoir = 0;
		minuteNoir = 10;
		ddSecondNoir = dFormat.format(secondNoir);
		ddMinuteNoir = dFormat.format(minuteNoir);	
		timerNoirLabel.setText(ddMinuteNoir + ":" + ddSecondNoir);
		timerNoirLabel.setBounds(75, 50, 100, 30);
		timerNoirLabel.setFont(new Font("Arial",Font.PLAIN,29));
		
		timerBlanc = new Timer(10, new ActionListener() {
		
				@Override
				public void actionPerformed(ActionEvent e) {
					
					msBlanc--;
					if(msBlanc==-1) {
						msBlanc = 69;
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
						timerBlancLabel.setText(ddMinuteBlanc + ":" + ddSecondBlanc );
					}
					if(minuteBlanc==0 && secondBlanc==0 && msBlanc==0) {
						model.gameEnd("Victoire des Noirs au temps");
					}
				}
			});	
		
		timerNoir = new Timer(10, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				msNoir--;
				
				if(msNoir==-1) {
					msNoir = 69;
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
					model.gameEnd("Victoire des Blancs au temps");
				}
			}
		});	
		
		model.addComponent(timerBlancLabel);
		model.addComponent(timerNoirLabel);
	}
	
	public Timer getWhiteTimer() {
		return timerBlanc;
	}
	
	public Timer getBlackTimer() {
		return timerNoir;
	}
}
