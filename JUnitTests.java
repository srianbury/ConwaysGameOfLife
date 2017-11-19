import static org.junit.Assert.*;

import org.junit.Test;

public class JUnitTests {
	Cell aliveCell = new Cell(true);
	Cell deadCell = new Cell(false);
	
	@Test
	public void testAliveState(){
		assertEquals(aliveCell.getCurrentState(), true);
	}
	
	@Test
	public void testDeadState(){
		assertEquals(deadCell.getCurrentState(), false);
	}
	
	@Test
	public void testReturnCorrectNumberOfNeighbors(){
		aliveCell.setNumLiveNeighbors(3);
		assertEquals(aliveCell.getNumLiveNeighbors(),3);
	}
	
	@Test
	public void livingCellWithLessThan2NeighborsBecomesDead(){
		aliveCell.setNumLiveNeighbors(0);
		assertEquals(aliveCell.getNextGenState(),false);
	}
	
	@Test
	public void livingCellWith2NeighborsStaysAlive(){
		aliveCell.setNumLiveNeighbors(2);
		assertEquals(aliveCell.getNextGenState(),true);
	}
	
	@Test
	public void livingCellWith3NeighborsStaysAlive(){
		aliveCell.setNumLiveNeighbors(3);
		assertEquals(aliveCell.getNextGenState(),true);
	}
	
	@Test
	public void livingCellWith4NeighborBecomesDead(){
		aliveCell.setNumLiveNeighbors(4);
		assertEquals(aliveCell.getNextGenState(),false);
	}
	
	@Test
	public void deadCellWith0NeighborsStaysDead(){
		deadCell.setNumLiveNeighbors(0);
		assertEquals(deadCell.getNextGenState(),false);
	}
	
	@Test
	public void deadCellWith3NeighborsComesToLife(){
		deadCell.setNumLiveNeighbors(3);
		assertEquals(deadCell.getNextGenState(),true);
	}
	
	@Test
	public void deadCellWith4NeighborsStaysDead(){
		deadCell.setNumLiveNeighbors(4);
		assertEquals(deadCell.getNextGenState(),false);
	}
	
}
