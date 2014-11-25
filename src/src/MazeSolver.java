package src;

public class MazeSolver {

	final Maze MAZE;					// Primary MAZE object
	int[][] solution;					// Tracks MAZE solution
	private int[][] visited;			// Tracks visited areas of MAZE
	private int[] location;				// Tracks current position in MAZE

	/*
	 * Maze Solver Constructor
	 */
	public MazeSolver(Maze maze) {
		this.MAZE = maze;
		this.visited = new int[MAZE.MAZEHEIGHT][MAZE.MAZELENGTH];
		this.solution = new int[MAZE.MAZEHEIGHT][MAZE.MAZELENGTH];
		this.location = MAZE.STARTPOINT;
	}

	/*
	 * Find the best next move given current position
	 * and priority of move
	 * 
	 * Each move query consists of:
	 * 		- boundary test
	 * 		- visited test
	 * 		- priority test
	 * 
	 * Returns coordinate of next move
	 */
	private int[] findRoute(int[] newLocation, int priority) {
		if (
				(newLocation[0] < MAZE.MAZEHEIGHT - 1) &&
				(MAZE.maze[newLocation[0] + 1][newLocation[1]] == 0) && 
				(visited[newLocation[0] + 1][newLocation[1]] < priority)) {
			newLocation[0]++;
		} else if (
				(newLocation[0] > 0) &&
				(MAZE.maze[newLocation[0] - 1][newLocation[1]] == 0) && 
				(visited[newLocation[0] - 1][newLocation[1]] < priority)) {
			newLocation[0]--;
		} else if (
				(newLocation[1] < MAZE.MAZELENGTH - 1) &&
				(MAZE.maze[newLocation[0]][newLocation[1] + 1] == 0) && 
				(visited[newLocation[0]][newLocation[1] + 1] < priority)) {
			newLocation[1]++;
		} else if (
				(newLocation[1] > 0) &&
				(MAZE.maze[newLocation[0]][newLocation[1] - 1] == 0) &&
				(visited[newLocation[0]][newLocation[1] - 1] < priority)) {
			newLocation[1]--;
		}
		return newLocation;
	}

	/*
	 * The driver for identifying the next move, tracking priority, and
	 * updating the solution table
	 * 
	 * Returns the coordinate of the next location or throws exception
	 * if no untried moves remain
	 */
	private int[] findBestOption() throws Exception {
		int[] newLocation = location.clone();
		int priority = 0;
		while (this.location[0] == newLocation[0] && this.location[1] == newLocation[1]) {
			newLocation = findRoute(newLocation, ++priority);
			// Record solution path
			if (solution[newLocation[0]][newLocation[1]] == 0) {
				solution[this.location[0]][this.location[1]] = 1;
			} else {
				solution[this.location[0]][this.location[1]] = 0;
			}
			if (priority > 4) {
				throw new Exception("Puzzle Has No Solution");
			}
		}
		return newLocation;
	}

	/*
	 * Function to solve the MAZE, updates the current MAZE position and
	 * tests for MAZE completion
	 * 
	 * Outputs solution when found
	 */
	void solve() throws Exception {
		while ((location[0] != MAZE.getEndX()) || (location[1] != MAZE.getEndY())) {
			visited[location[0]][location[1]] += 1;
			this.location = findBestOption();
		}
		System.out.println("---------------------");
		System.out.println("=== Puzzle Solved ===");
		System.out.println("---------------------");
		this.printDouble(solution);
	}

	/*
	 * Function to print the double arrays used to solve the MAZE,
	 * formatting for key landmarks like start / end point
	 * 
	 * Outputs the given double array
	 */
	void printDouble(int[][] map) {
		String ch;
		for (int i=0; i<map.length; i++) {
			for (int j=0; j<map[i].length; j++) {
				if (MAZE.getStartX() == i && MAZE.getStartY() == j) {
					ch = "S";
				} else if (MAZE.getEndX() == i && MAZE.getEndY() == j) {
					ch = "E";
				} else {
					ch = String.valueOf(map[i][j]);
				}
				System.out.print(ch);
			}
			System.out.print('\n');
		}
	}

	public static void main(String[] args) throws Exception {
		MazeSolver solver = new MazeSolver(SampleMaze.MAZE);
		solver.printDouble(solver.MAZE.maze);
		solver.solve();
	}

}