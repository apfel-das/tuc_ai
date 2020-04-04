package searchMethods;
import assets.*;

public interface search {
	
	public State exec(State initState);
	public void backtrack(State init);

}
