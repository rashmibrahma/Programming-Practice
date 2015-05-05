package maze;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import stack.Stack;


/*public class Maze {

 *//**
 * @param args
 *//*
	char[][] maze;
	Stack<MazePos> S;

	public Maze(char[][] maze){
		S=new Stack<MazePos>();
		this.maze=maze;
	}

	public ArrayList<Character> mazePath(){
		ArrayList<Character> resPath;
		MazePos item=new MazePos();
		//start at top left and end at bottom right
		item.setX(0);
		item.setY(0);
		S.push(item);

		for(int i=0; i<maze.length; i++){
			for(int j=0; j<maze[0].length; j++){
				//check directions: left, right, top, bottom
				item.setX(i);
				item.setY(j);

				if(S.peek()!=item && left(i,j)){
					S.push(item);
				}
				else if(S.peek()!=item && right(i,j)){
					S.push(item);
				}
				else if(S.peek()!=item && top(i,j)){
					S.push(item);
				}
				else if(S.peek()!=item && bottom(i,j)){
					S.push(item);
				}else{
					S.pop();
				}
			}
		}
	}

	private boolean bottom(int row, int col) {
		if(row==maze.length-1)
			return false;
		if(maze[row+1][col]=='0')
			return true;
		else
			return false;
	}

	private boolean top(int row, int col) {
		if(row==0)
			return false;
		if(maze[row-1][col]=='0')
			return true;
		else
			return false;
	}

	private boolean right(int row, int col) {
		if(col==maze[0].length-1)
			return false;
		if(maze[row][col+1]=='0')
			return true;
		else
			return false;
	}

	private boolean left(int row, int col) {
		if(col==0)
			return false;
		if(maze[row][col-1]=='0')
			return true;
		else
			return false;
	}

	public static void main(String[] args) {


	}

}
  */


public class Maze {

	public static void main(String[] args) {
		//Use 2D array
		int[][] maze = new int[6][6];
		maze[0] = new int[] { 1, 1, 0, 0, 0, 0 };
		maze[1] = new int[] { 0, 1, 0, 0, 0, 0 };
		maze[2] = new int[] { 0, 1, 0, 1, 1, 1 };
		maze[3] = new int[] { 1, 1, 1, 1, 0, 1 };
		maze[4] = new int[] { 0, 1, 0, 0, 0, 1 };
		maze[5] = new int[] { 0, 1, 0, 0, 0, 1 };

		//This is the start of exit point of maze
		Point start = new Point(0,0);
		Point exit = new Point(5,5);

		//DFS approach
		Stack<Point> s = new Stack<Point>();
		s.push(start);
		Map<Point,Status> visited = new HashMap<Point,Status>();
		visited.put(start, Status.VISITING);

		while(!s.isEmpty()){
			Point currentP = s.peek();
			boolean isAllVisited = true;

			for (Point p : getAdjacent(currentP.x, currentP.y)){
				//It should be y and x, see above array
				if (visited.get(p)==null && maze[p.y][p.x]==1){
					visited.put(p, Status.VISITING);
					isAllVisited = false ;
					s.push(p);
					if ( p.equals(exit)){
						printPath(s);
					}
					break;
				}
			}
			if (isAllVisited){
				visited.put(currentP, Status.VISITED);
				s.pop();
			}
		}
	}

	private static void printPath(Stack<Point> s){
		while (!s.isEmpty()){
			System.out.print("->");
			Point p = s.pop();
			System.out.format("[%d,%d]",p.x,p.y);
		}
	}

	private static List<Point> getAdjacent(int x, int y){
		List<Point> result = new ArrayList<Point>();
		//above point;
		if (y-1>=0) {
			result.add(new Point(x, y-1));
		}
		//right point;
		if (x+1<=5) {
			result.add(new Point(x+1, y));
		};
		//below point;
		if (y+1<=5) {
			result.add(new Point(x, y+1));
		};
		//left point;
		if (x-1>=0) {
			result.add(new Point(x-1, y));
		};
		return result;		
	}

	private static class Point {
		int x, y;
		public Point(int x,int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
	}
	private static enum Status {
		UNVISITED, VISITING, VISITED
	};
}