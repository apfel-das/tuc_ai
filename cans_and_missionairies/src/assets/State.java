package assets;

import java.util.ArrayList;

/**
 * A class representing the State of the problem
 * @author dasApfel
 *
 */
public class State {
	
	// missionaries and cannibals on each side
	private int leftCans;
	private int rightCans;
	private int leftMis;
	private int rightMis;
	
	// missionaries and cannibals number.
	int threshold;
	
	//boat existence (0 -> left, 1->right), an enum could also be used.
	private boolean boat;
	
	// parent State encapsulation
	private State parent; 
	
	//class Constructor
	
	public State(int lC,int rC,int lM,int rM, boolean b, int t) 
	{
		leftCans = lC;
		rightCans = rC;
		leftMis = lM;
		rightMis = rM;
		threshold = t;
		boat = b;
		
		
	}
	
	public State getParent() {
		return parent;
	}

	public void setParent(State pState) {
		this.parent = pState;
	}

	/**
	 * Check if the problem's goal has been achieved.
	 * {@summary For the goal to be: ACHIEVED we need 3 cannibals and 3 missionaries on the left side (boat == TRUE)}
	 * @return true or false
	 */
	public boolean isTarget() 
	{
		return (leftCans == 0 && leftMis == 0);
	}
	
	
	public boolean isInitState() 
	{
		
		if(leftCans == threshold && rightCans == threshold && boat == true)
			return true;
		return false;
	}
	
	
	public boolean isValidState(State s) 
	{
		if(leftCans >= 0 && leftMis >= 0 && rightCans >= 0 && rightMis >= 0 && (leftMis == 0 || leftMis >= leftCans) && (rightMis >= rightCans || rightMis == 0))
			return true;
		return false;
	}
	
	private boolean alterBoatPosition(boolean b) 
	{
		return !b;
	}
	private int calcTransferMode(boolean b) 
	{
		if(b)
			return 1;
		return -1;
		
	}
	
	public ArrayList<State> stateGenerator()
	{
		ArrayList<State> childStates = new ArrayList<State>();
		
		int t = calcTransferMode(boat);
		 
		
		//for each missionary
		for(int i = 0; i<3; i++)
		{
			//for each cannibal
			for(int j =0; j<3; j++) 
			{
				
				//no more than a pair can travel
				if((i+j <= 2) && (i + j != 0)) 
				{
					//create a State.
					State s = new State(leftCans + (t*j), rightCans - (t*j),leftMis + (t*i), rightMis - (t*i), alterBoatPosition(boat),threshold); 
					
					//check validity
					if(s.isValidState(s)) 
					{	
						//append
						s.setParent(this);
						childStates.add(s);
											
					}
					
				}
				
				
				
			}
		}
		
		
		return childStates;
		
	}
	
	
	public void print() 
	{
		//ternary assignment
		String boatLoc = (boat) ? "Right" : "Left";
		System.out.println("Cannibals [Left]: "+leftCans+" Missionaries [Left]: "+leftMis+" Cannibals [Right]: "+rightCans+" Missionaries [Right]: "+rightMis+ " boat_location: "+boatLoc);
	}
	
}
