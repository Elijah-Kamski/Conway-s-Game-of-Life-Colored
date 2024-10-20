public class Cell
{
	private boolean alive;
	private int colorR;
	private int colorG;
	private int colorB;
	int[][] RAINBOW_COLORS = RainbowColors.getAllColors();

	public Cell(boolean alive, int colorR, int colorG, int colorB)
	{
		this.alive = alive;
		this.colorR = colorR;
		this.colorG = colorG;
		this.colorB = colorB;
	}

	public void setAlive(boolean alive)
	{
		this.alive = alive;
	}

	public boolean getAlive()
	{
		return alive;
	}

	public void setColor(int r, int g, int b)
	{
		this.colorR = r;
		this.colorG = g;
		this.colorB = b;
	}

	public int[] getColor()
	{
		return (new int[]{colorR, colorG, colorB});
	}

	public void randomCellColor()
	{
		int randomIndex = (int) (Math.random() * RAINBOW_COLORS.length);
		int[] selectedColor = RAINBOW_COLORS[randomIndex];
		setColor(selectedColor[0], selectedColor[1], selectedColor[2]);
	}
}
