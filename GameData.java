import java.util.ArrayList;

public class GameData
{
    private char[][] grid = {{' ',' ', ' ', ' ', ' ', ' ', ' '}, {' ',' ', ' ', ' ', ' ', ' ', ' '}, {' ',' ', ' ', ' ', ' ', ' ', ' '}, {' ',' ', ' ', ' ', ' ', ' ', ' '}, {' ',' ', ' ', ' ', ' ', ' ', ' '}, {' ',' ', ' ', ' ', ' ', ' ', ' '}};

    public char[][] getGrid()
    {
        return grid;
    }

    public void reset()
    {

        grid = new char[6][7];
        for(int r=0;r<grid.length; r++)
            for(int c=0; c<grid[0].length; c++)
                grid[r][c]=' ';
    }


    public boolean isCat()
    {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == ' ') {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isWinner(char letter)
    {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col <= grid[0].length - 4; col++) {
                if (grid[row][col] == letter &&
                        grid[row][col + 1] == letter &&
                        grid[row][col + 2] == letter &&
                        grid[row][col + 3] == letter) {
                    return true;
                }
            }
        }
            // Check vertical
            for (int row = 0; row <= grid.length - 4; row++) {
                for (int col = 0; col < grid[0].length; col++) {
                    if (grid[row][col] == letter &&
                            grid[row + 1][col] == letter &&
                            grid[row + 2][col] == letter &&
                            grid[row + 3][col] == letter) {
                        return true;
                    }
                }
            }

            // Check diagonal (top-left to bottom-right)
            for (int row = 0; row <= grid.length - 4; row++) {
                for (int col = 0; col <= grid[0].length - 4; col++) {
                    if (grid[row][col] == letter &&
                            grid[row + 1][col + 1] == letter &&
                            grid[row + 2][col + 2] == letter &&
                            grid[row + 3][col + 3] == letter) {
                        return true;
                    }
                }
            }

            // Check diagonal (top-right to bottom-left)
            for (int row = 0; row <= grid.length - 4; row++) {
                for (int col = 3; col < grid[0].length; col++) {
                    if (grid[row][col] == letter &&
                            grid[row + 1][col - 1] == letter &&
                            grid[row + 2][col - 2] == letter &&
                            grid[row + 3][col - 3] == letter) {
                        return true;
                    }
                }
            }

            return false;
        }
        /*
        if((grid[0][0] ==letter && grid[0][1] ==letter && grid[0][2] ==letter)
                || (grid[1][0] ==letter && grid[1][1] ==letter && grid[1][2] ==letter)
                || (grid[2][0] ==letter && grid[2][1] ==letter && grid[2][2] ==letter)

                || (grid[0][0] ==letter && grid[1][0] ==letter && grid[2][0] ==letter)
                || (grid[0][1] ==letter && grid[1][1] ==letter && grid[2][1] ==letter)
                || (grid[0][2] ==letter && grid[1][2] ==letter && grid[2][2] ==letter)

                || (grid[0][0] ==letter && grid[1][1] ==letter && grid[2][2] ==letter)
                || (grid[0][2] ==letter && grid[1][1] ==letter && grid[2][0] ==letter))
            return true;
        else
            return false;

         */




}

