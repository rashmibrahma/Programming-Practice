package ticTacToe;

/*
 * assign X to Player1 and O to Player2 or vice versa
 */

public class Game {

	private static final Entry X = null;
	private static final Entry O = null;
	Board board;
	boolean continuePlaying;
	String currentPlayer;
	Entry currentPlayerMove;	//X or O
	
	
	public Game(){
		board=new Board();
		currentPlayer=Player.player1;	//player1=X
	}
	
	public void gamePlay(Entry currentPlayerMove,int row, int col){
		if(!board.won() || !board.gameOver()){
			board.play(currentPlayerMove, row, col);
			if(playerTurn() == null)
				return;	//game over
		}
		
		if(board.won()){
			board.getWinner();
		}
	}
	
	public Entry getCurrentPlayerMove() {
		return currentPlayerMove;
	}

	public void setCurrentPlayerMove(Entry currentPlayerMove) {
		this.currentPlayerMove = currentPlayerMove;
	}

	public String playerTurn(){
		
		//need to check if game over
		if(board.gameOver()){
			continuePlaying=false;
			return null;
		}
		
		//if game not over then change the player
		if(currentPlayer==Player.player1){
			setCurrentPlayer(Player.player2);
			setCurrentPlayerMove(O);
			return Player.player2;
		}
		else{
			setCurrentPlayer(Player.player1);
			setCurrentPlayerMove(X);
			return Player.player1;
		}
	}

	public String getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(String currentPlayer) {
		this.currentPlayer = currentPlayer;
	}
	
}
