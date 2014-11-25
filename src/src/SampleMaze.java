package src;

/*
 * An example maze for use with the Maze Solver function
 */
public class SampleMaze {
	
	static int[] startPoint = {0, 0};	// Define X,Y coordinates of starting point
	static int[] endPoint = {5, 0};		// Define X,Y coordinates of ending point

	static int[][] maze = {				// The integer representation of the maze to solve
			{0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1, 0},
			{0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1},
			{0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
			{1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0},
			{0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
			{0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1},
			{0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}
			};
	
	final static Maze MAZE = new Maze(maze, startPoint, endPoint);	// Build maze object
}