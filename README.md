# Conway's Game of Life - Colored version
Conway's Game of Life is a cellular automaton devised by the British mathematician John Horton Conway. This project implements the Game of Life in Java using Processing, PApplet and JavaSwing, allowing users to interact with the simulation in real-time.

## Table of Contents

- [Rules](#rules)
- [Features](#features)
- [Controls](#controls)
- [Color](#color)


## Rules
  
The Game of Life follows these rules for cell evolution:

  Survival:
    - A live cell with two or three live neighbors stays alive.
  Death:
    - A live cell with fewer than two live neighbors dies (underpopulation).
    - A live cell with more than three live neighbors dies (overpopulation).
    - Birth: A dead cell with exactly three live neighbors becomes a live cell (reproduction).

## Features

- Interactive grid where users can toggle the state of cells (alive or dead).
- Start/Pause functionality for the simulation.
- Random board generation.
- Reset functionality to reinitialize the board.
- Clear functionality to reset the board without restarting the simulation.
- Customizable number of rows and columns.
- Adjustable frame rate for cell updates.
- Dynamic color changes for cells based on the average color of neighboring cells.

## Controls
  
- Use the mouse to toggle cells between alive (colored) and dead (white).
- Click the Start button to begin the simulation.
- Click the Pause button to stop the simulation.
- Click the Random button to generate a random configuration of cells.
- Click the Reset button to reset the grid and prompt for new dimensions and refresh rate.
- Click the Clear button to clear all cells from the grid.

## Color
In this implementation, the color of each live cell changes based on the average color of its living neighbors. This feature adds an aesthetic and dynamic element to the simulation, allowing for visual representation of cell interactions and providing a more engaging experience. The colors are represented using RGB values, giving each cell a unique appearance depending on its neighbors. The color of the cell is always rounded to one of the following: 

    {255, 0, 0},     // Red
		{255, 127, 0},   // Orange
		{255, 255, 0},   // Yellow
		{0, 255, 0},     // Green
		{0, 0, 255},     // Blue
		{75, 0, 130},    // Indigo
		{148, 0, 211}    // Violet

  Were the colors not be rounded, the game colors would always end in gray-like tones, making the game more dull and less appealing.
