package BackTracking;

public class PathInMaze {
	
	public static void main(String[] args)
	{
		int[][] maze  =  {  {1, 0, 0, 0},
		        			{1, 1, 1, 1},
		        			{0, 0, 1, 0},
		        			{1, 1, 1, 1}
		    			 };
		solveMaze(maze);
				 
	}
	
	private static boolean solveMaze(int[][] maze)
	{
		int[][] solution = new int[maze.length][maze[0].length];
		
		for(int i=0; i<solution.length; i++)
		{
			for(int j=0; j< solution[0].length; j++)
				solution[i][j] = 0;
		}
		
		if(solveMazeUtil(maze,0,0,solution) == true)
		{
			System.out.println("Here is the solution matrix");
			for(int i=0; i<solution.length; i++)
			{
				for(int j=0; j< solution[0].length; j++)
				{
					System.out.print(solution[i][j] + " ");
				}
				System.out.println(" ");
			}
			return true;
		}
		else 
			System.out.println("No solution found");
		
		return false;
	}
	
	private static boolean solveMazeUtil(int[][] maze,int x, int y, int[][] solution)
	{
		if(x == (maze.length -1 ) && y == (maze[0].length -1))
		{
			solution[x][y] = 1;
			return true;
		}
		if(isSafe(x,y,maze) == true)
		{
			//lets move down first
			solution[x][y] = 1;
			if(solveMazeUtil(maze,x+1,y,solution) == true)
				return true;
			if(solveMazeUtil(maze,x,y+1, solution) == true)
				return true;
			solution[x][y] = 0;
			return false;
		}
		else
			return false;
	}
	
	private static boolean isSafe(int x, int y, int[][] maze)
	{
		if( x< maze.length && y< maze[0].length)
		{
			if( maze[x][y] == 1)
				return true;
			return false;
		}
		return false;
	}

}
