public class RainbowColors
{
	private static final int[][] RAINBOW_COLORS =
	{
		{255, 0, 0},     // Red
		{255, 127, 0},   // Orange
		{255, 255, 0},   // Yellow
		{0, 255, 0},     // Green
		{0, 0, 255},     // Blue
		{75, 0, 130},    // Indigo
		{148, 0, 211}    // Violet
	};

	public static int[][] getAllColors()
	{
		return (RAINBOW_COLORS.clone());
	}
}
