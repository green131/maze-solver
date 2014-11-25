package src;

public class Maze {

	int[][] maze;				// Maze array
	
	final int[] STARTPOINT;		// Beginning point of maze
	int[] ENDPOINT;				// Ending point of maze

	final int MAZEHEIGHT;		// Height of maze
	final int MAZELENGTH;		// Length of maze

	/*
	 * Maze Constructor
	 */
	public Maze(int[][] maze, int[] startPoint, int[] endPoint) {
		this.maze = maze;
		this.MAZEHEIGHT = maze.length;
		this.MAZELENGTH = maze[0].length;
		this.STARTPOINT = startPoint;
		this.ENDPOINT = endPoint;
	}

	/*
	 * Return X-coordinate of starting point
	 */
	int getStartX() {
		return STARTPOINT[0];
	}

	/*
	 * Return Y-coordinate of starting point
	 */
	int getStartY() {
		return STARTPOINT[1];
	}

	/*
	 * Return X-coordinate of ending point
	 */
	int getEndX() {
		return ENDPOINT[0];
	}

	/*
	 * Return Y-coordinate of ending point
	 */
	int getEndY() {
		return ENDPOINT[1];
	}

}
