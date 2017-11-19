import java.util.Random;

public class Board {
	public Cell[][] board;
	private int boardSize;
	private int neighborCount;
	Random rand = new Random();
	
	//create a board of size*size
	public Board(int size){
		boardSize = size;
		board = new Cell[size][size];
		for(int row=0; row<size; row++){
			for(int col=0; col<size; col++){
				board[row][col] = new Cell(true);
			}
		}
	}
	
	//the boolean doesnt do anything but it is used to create a dif constructor
	public Board(int size, boolean random){
		int randomNumber = rand.nextInt(3)+1;
		boardSize = size;
		board = new Cell[size][size];
		for(int row=0; row<size; row++){
			for(int col=0; col<size; col++){
				if(row%randomNumber==1 || col%randomNumber==2){
					board[row][col] = new Cell(false);
				}
				else{
					board[row][col] = new Cell(true);
				}
			}
		}
	}
	
	//default constructor, 3x3 filled with all false cells except the top row
	public Board(){
		boardSize = 3;
		board = new Cell[][] { 
			{new Cell(false), new Cell(false), new Cell(false)},
			{new Cell(true), new Cell(true), new Cell(true)},
			{new Cell(false), new Cell(false), new Cell(false)}
		};
	}
	
	public int getBoardSize(){
		return boardSize;
	}
	
	//count the number of living neighbors for each cell
	public void getLivingNeighborCountForEachCell(){
		Cell currentCell;
	
		for(int row=0; row<boardSize; row++){
			for(int col=0; col<boardSize; col++){
				neighborCount = 0;
				currentCell = board[row][col];
				
				if(col-1>=0){
					if(row-1>=0){
						//topLeft = board[row-1][col-1];
						if(board[row-1][col-1].getCurrentState()){neighborCount++;}
					}
					//left = board[row][col-1];
					if(board[row][col-1].getCurrentState()){neighborCount++;}
					if(row+1<boardSize){
						//bottomLeft = board[row+1][col-1];
						if(board[row+1][col-1].getCurrentState()){neighborCount++;}
					}
				}
				if(col+1<boardSize){
					if(row-1>=0){
						//topRight = board[row-1][col+1];
						if(board[row-1][col+1].getCurrentState()){ neighborCount++; }
					}
					//right = board[row][col+1];
					if(board[row][col+1].getCurrentState()){ neighborCount++; }
					if(row+1<boardSize){
						//bottomRight = board[row+1][col+1];
						if(board[row+1][col+1].getCurrentState()){ neighborCount++; }
					}
				}
				if(row-1>=0){
					//above = board[row-1][col];
					if(board[row-1][col].getCurrentState()){ neighborCount++; }
				}
				
				if(row+1<boardSize){
					//below = board[row+1][col];
					if(board[row+1][col].getCurrentState()){ neighborCount++; }
				}
				
				currentCell.setNumLiveNeighbors(neighborCount);
			}
		}
	}
	
	//update the future state value for each cell
	public void updateNextGenerationValuesForEachCell(){
		//create a temp board
		for(int row=0; row<boardSize; row++){
			for(int col=0; col<boardSize; col++){
				board[row][col].getNextGenState();
			}
		}
	}
	
	//update the board to the next gen
	public void moveToNextGeneration(){
		for(int row=0; row<boardSize; row++){
			for(int col=0; col<boardSize; col++){
				board[row][col].setCurrentState(board[row][col].getNextGenState());
			}
		}
	}
	
	//show current board state
	public void printBoard(){
		for(int row=0; row<boardSize; row++){
			for(int col=0; col<boardSize; col++){
				if(board[row][col].getCurrentState()){
					System.out.print("#\t");
				}else{
					System.out.print(".\t");
				}
			}
			System.out.println();
		}
	}

	//was used for testing, print what the board will look like in the next gen
	public void printNextGenBoard(){
		for(int row=0; row<boardSize; row++){
			for(int col=0; col<boardSize; col++){
				if(board[row][col].getNextGenState()){
					System.out.print("#\t");
				}else{
					System.out.print(".\t");
				}
			}
			System.out.println();
		}
	}
		
}
