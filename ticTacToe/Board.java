package ticTacToe;

public class Board {

	private static final Entry X = null;
	private static final Entry O = null;
	Entry marker;
	Entry[][] board;
	int gameCounter=0;
	String winner;
	
	public String getWinner() {
		return winner;
	}

	public Board(){
		board=new Entry[3][3];
	}
	
	public char[][] getBoard(){
		char[][] resBoard=new char[board.length][board[0].length];
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board[0].length; j++){
				resBoard[i][j]=board[i][j].toString().charAt(0);
			}
		}
		return resBoard;
	}
	
	public void play(Entry marker, int row, int col){
		//if marker already placed return
		//else place marker and check for win
		//increment gameCounter by 1
		
		if(!(board[row][col]==null))
			return;	//marker already present	//throw exception
		else{
			board[row][col]=marker;	//place the marker
			if(!gameOver())
				gameCounter++;
			else
				return;	
		}
		
	}
	
	public boolean won(){
		if(winningCombinations())
			return true;
		else
			return false;
	}
	
	public boolean gameOver(){
		if(won())
			return true;
		else if(gameCounter==9)
			return true;
		else
			return false; 
	}
	
 	public boolean winningCombinations(){
		//check horizontal wins
		for(int i=0; i<board.length; i++){
			if(!checkHorizontalWin(i))
				continue;
			else{
				if(board[i][0]==X)
					winner=Player.player1;	
				else if(board[i][0]==O)
					winner=Player.player2;
				return true;	//there is a win
			}
		}
		//no horizontal wins
		
		//check vertical wins
		for(int i=0; i<board[0].length; i++){
			if(!checkVerticalWin(i))
				continue;
			else{
				if(board[0][i]==X)
					winner=Player.player1;	
				else if(board[0][i]==O)
					winner=Player.player2;
				return true;	//there is a win
			}
		}
		//no vertical wins
		
		//check diagonal wins
		Entry check=board[0][0];
		int counter=0;
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board[0].length; j++){
				if(check==board[i][j])
				{
					counter++;
					continue;
				}

				else
					return false;
			}
		}
		if(counter==board.length){
			return true;	//there is a win
		}
		else
			return false;
		
	}

	private boolean checkVerticalWin(int index) {
		Entry check=board[0][index];
		for(int i=0; i<board.length; i++){
			if(check==board[i][index])
				continue;
			else
				return false;
		}
		return true;
	}

	private boolean checkHorizontalWin(int index) {
		Entry check=board[index][0];
		for(int i=0; i<board[index].length; i++){
			if(check==board[index][i])
				continue;
			else
				return false;
		}
		return true;
	}

	

}


