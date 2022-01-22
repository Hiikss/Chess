package view;

public class Display {
	
	 private Strategy strategy;

	   public Display(Strategy strategy){
	      this.strategy = strategy;
	   }

	   public int executeStrategy(){
	      return strategy.performAction();
	   }

}
