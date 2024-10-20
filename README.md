# Conway's Game of Life - Colored version
Conway's Game of Life is a cellular automaton devised by the British mathematician John Horton Conway. This project implements the Game of Life in Java using Processing, PApplet and JavaSwing, allowing users to interact with the simulation in real-time.

## Table of Contents

- [Rules](#rules)
- [Features](#features)
- [Controls](#controls)

- ## Rules
  
The Game of Life follows these rules for cell evolution:

  Survival:
    - A live cell with two or three live neighbors stays alive.
  Death:
    - A live cell with fewer than two live neighbors dies (underpopulation).
    - A live cell with more than three live neighbors dies (overpopulation).
    - Birth: A dead cell with exactly three live neighbors becomes a live cell (reproduction).
    - These rules result in complex patterns and behaviors emerging from simple initial conditions.

## Features

- Interactive grid where users can toggle the state of cells (alive or dead).
- Start/Pause functionality for the simulation.
- Random board generation.
- Reset functionality to reinitialize the board.
- Clear functionality to reset the board without restarting the simulation.
- Customizable number of rows and columns.
- Adjustable frame rate for cell updates.


- ## Controls
  
- Use the mouse to toggle cells between alive (colored) and dead (white).
- Click the Start button to begin the simulation.
- Click the Pause button to stop the simulation.
- Click the Random button to generate a random configuration of cells.
- Click the Reset button to reset the grid and prompt for new dimensions and refresh rate.
- Click the Clear button to clear all cells from the grid.
