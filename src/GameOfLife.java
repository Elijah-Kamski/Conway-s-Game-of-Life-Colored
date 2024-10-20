public class GameOfLife
{
	private Cell[][] board;
	private int col_count;
	private int row_count;
	int[][] RAINBOW_COLORS = RainbowColors.getAllColors();

	public GameOfLife(int col_count, int row_count)
	{
		this.col_count = col_count;
		this.row_count = row_count;
		board = new Cell[col_count][row_count];
		initializeBoard();
	}

	private void initializeBoard()
	{
		int x = 0;
		while (x < col_count)
		{
			int y = 0;
			while (y < row_count)
			{
				board[x][y] = new Cell(false, 255, 255, 255);
				y++;
			}
			x++;
		}
	}

	// Randomly assign cells as alive or dead and set appropriate colors
	public void randomBoard()
	{
		int x = 0;
		while (x < col_count) {
			int y = 0;
			while (y < row_count) {
				boolean isAlive = Math.random() < 0.5;  // 50% chance alive
				board[x][y].setAlive(isAlive);
				if (isAlive) {
					board[x][y].randomCellColor();
				} else {
					board[x][y].setColor(255, 255, 255); // Dead cells are white
				}
				y++;
			}
			x++;
		}
	}

	// Reset the board, turning all cells to dead
	public void resetBoard()
	{
		int x = 0;
		while (x < col_count)
		{
			int y = 0;
			while (y < row_count)
			{
				board[x][y].setAlive(false);
				board[x][y].setColor(255, 255, 255); // White color for dead cells
				y++;
			}
			x++;
		}
	}

	// Count live neighbors for a specific cell
	private int countLiveNeighbors(int x, int y)
	{
		int liveNeighbors = 0;
		int i = -1;
		while (i <= 1) {
			int j = -1;
			while (j <= 1) {
				if (i == 0 && j == 0)
				{
					j++;
					continue;  // Skip the cell itself
				}
				int neighborX = (x + i + col_count) % col_count;
				int neighborY = (y + j + row_count) % row_count;
				if (board[neighborX][neighborY].getAlive())
				{
					liveNeighbors++;
				}
				j++;
			}
			i++;
		}
		return liveNeighbors;
	}

	// updateBoard() updates the colors with a "rounded" version, so it fits in the RAINBOWCOLORS list.
	// Were the code to use real average colors, the outcome would tend to be similar, but with less vibrant tones

	public void updateBoard()
	{
		Cell[][] newBoard = new Cell[col_count][row_count];
		int x = 0;
		while (x < col_count)
		{
			int y = 0;
			while (y < row_count)
			{
				int liveNeighbors = countLiveNeighbors(x, y);
				boolean currentState = board[x][y].getAlive();
				boolean newState;
	
				if (currentState)
					newState = liveNeighbors >= 2 && liveNeighbors <= 3;
				else
					newState = liveNeighbors == 3;

				int newColorR = 0;
				int newColorG = 0;
				int newColorB = 0;
	
				if (newState)
				{
					int colorSumR = 0;
					int colorSumG = 0;
					int colorSumB = 0;
					int neighborCount = 0;
	
					// Calculate the average color of alive neighbors
					int i = -1;
					while (i <= 1)
					{
						int j = -1;
						while (j <= 1)
						{
							if (i == 0 && j == 0)
							{
								j++;
								continue; // Skip the cell itself
							}
							int neighborX = (x + i + col_count) % col_count;
							int neighborY = (y + j + row_count) % row_count;
	
							if (board[neighborX][neighborY].getAlive())
							{
								int[] neighborColor = board[neighborX][neighborY].getColor();
								colorSumR += neighborColor[0];
								colorSumG += neighborColor[1];
								colorSumB += neighborColor[2];
								neighborCount++;
							}
							j++;
						}
						i++;
					}
	
					// Average the color values
					if (neighborCount > 0)
					{
						newColorR = colorSumR / neighborCount;
						newColorG = colorSumG / neighborCount;
						newColorB = colorSumB / neighborCount;
	
						// Round the averaged color to the nearest vibrant color
						int[] roundedColor = roundToNearestrainbowColor(newColorR, newColorG, newColorB);
						newColorR = roundedColor[0];
						newColorG = roundedColor[1];
						newColorB = roundedColor[2];
					}
					else
					{
						newColorR = 255;
						newColorG = 255;
						newColorB = 255;
					}
				}
				newBoard[x][y]= new Cell(newState, newColorR, newColorG, newColorB);
				y++;
			}
			x++;
		}
		board = newBoard;
	}
	
	// Helper method to round to the nearest vibrant color
	private int[] roundToNearestrainbowColor(int r, int g, int b)
	{
		int minDistance = Integer.MAX_VALUE;
		int[] closestColor = {255, 255, 255}; // Default to white
	
		for (int[] rainbowColor : RAINBOW_COLORS)
		{
			int distance = (rainbowColor[0] - r) * (rainbowColor[0] - r)
						 + (rainbowColor[1] - g) * (rainbowColor[1] - g)
						 + (rainbowColor[2] - b) * (rainbowColor[2] - b);
	
			if (distance < minDistance)
			{
				minDistance = distance;
				closestColor = rainbowColor;
			}
		}
		return (closestColor);
	}
	
	public Cell[][] getBoard()
	{
		return (board);
	}
}
