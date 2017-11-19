public class Cell {
	private boolean currentState;
	private int numLiveNeighbors = 0;
	
	public Cell(boolean state){
		currentState = state;
	}
	public void setNumLiveNeighbors(int liveNeighbors){
		numLiveNeighbors = liveNeighbors;
	}
	public int getNumLiveNeighbors(){
		return numLiveNeighbors;
	}
	public void setCurrentState(boolean state){
		currentState = state;
	}
	public boolean getCurrentState(){
		return currentState;
	}
	public boolean getNextGenState(){
		if(currentState){
			return numLiveNeighbors >= 2 && numLiveNeighbors <= 3;
		}
		return numLiveNeighbors == 3;
	}
}
