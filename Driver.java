import java.util.concurrent.TimeUnit;

public class Driver {
	
	public static void main(String args[]) throws InterruptedException{
		//Cell[][] gameBoard = new Cell[3][3];
		//create a board object with all cells = true
		
		
		Board gameBoard = new Board();
		for(int i=0; i < 4; i++){
			gameBoard.printBoard();
			gameBoard.getLivingNeighborCountForEachCell();
			gameBoard.updateNextGenerationValuesForEachCell();
			gameBoard.moveToNextGeneration();
			System.out.println();
			TimeUnit.SECONDS.sleep(1);
		}
		
		int boardSize = 10;
		Board gameBoard2 = new Board(boardSize, true);
		for(int i=0; i < 4; i++){
			gameBoard2.printBoard();
			gameBoard2.getLivingNeighborCountForEachCell();
			gameBoard2.updateNextGenerationValuesForEachCell();
			gameBoard2.moveToNextGeneration();
			System.out.println();
			TimeUnit.SECONDS.sleep(1);
		}
	}
}