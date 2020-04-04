package searchMethods;

import assets.State;
import java.util.*;

public class BFS implements search {

	@Override
	public State exec(State initState) {
		
		
		ArrayList<State> visited = new ArrayList<State>();
		LinkedList<State> queue = new LinkedList<State>();
		
		
		// base-case.
		if(initState.isInitState())
			return initState;
		
		queue.add(initState);
		
		// begin parsing.
		while(true) 
		{
			//shit happens.
			if(queue.isEmpty())
				return null;
			
			//pop and add to visited.
			State curr = queue.poll();
			visited.add(curr);
			
			ArrayList<State> children = curr.stateGenerator();
			
			//funny iteration.
			for(State child : children) 
			{
				if(!visited.contains(child) || !queue.contains(child)) 
				{
					//we're done here.
					if(child.isTarget()) 
					{
						return child;
					}
					//if we reach this point, the child does not solve a shit.
					queue.add(child);
				}
			}
			
			
			
		}
		
		
	
	}

	@Override
	public void backtrack(State s)
	{
		
		State solution = exec(s);
		if (solution == null) 
		{
			System.out.println("No solution found.");
			return;
		} 
		
		
	
		//a List to hold path towards goal.	
		ArrayList<State> path = new ArrayList<State>();
		State state = solution;
		
		//itterate parentwise.
		while(state.getParent() != null) 
		{
			
			
			path.add(state);
			state = state.getParent();
			
			
			
			if(state.isInitState()) 
			{
				path.add(state);
				break;
			}
		}
		path.add(s);

		int depth = path.size() - 1;
		
		//print the solution path, backwards.
		for (int i = depth; i >= 0; i--) 
		{
			state = path.get(i);
			state.print();
			
		}
		System.out.println("\nDepth: " + depth);
	

	}
}
		
		
		
		
		
		
	
	


