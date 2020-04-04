package assets;
import searchMethods.*;

public class Main {

	public static void main(String[] args) 
	{
		
		State init = new State(3,0,3,0,false,3);
		BFS bfs = new BFS();
		bfs.backtrack(init);
		

	}

}
