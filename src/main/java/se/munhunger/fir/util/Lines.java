package se.munhunger.fir.util;

import se.munhunger.fir.model.Board;
import se.munhunger.fir.model.Row;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lines
{
    /**
     * Checks the board for "lines", i.e. if there are n amount of x's in a row.
     * The function returns a list of rows of the length length.
     * Note that the function uses x and y as a base, but ignores them in the length count.
     * i.e. if x and y is the middle of a row, then this will count 2 rows.
     * @param length the length sought
     * @param isX true if searching for x.
     * @param x x co-ordinate
     * @param y y co-ordinate
     * @param board the board to search in
     * @return a list of rows
     */
    public static List<Row> getAmountOfLengths(int length, boolean isX, int x, int y, Board board) {
        List<Row> result = new ArrayList<>();
        for(int dX = -1; dX <= 1; dX++)
            for(int dY = -1; dY <= 1; dY++)
                if(!(dX == 0 && dY == 0)) {
                    int xPos = x;
                    int yPos = y;
                    int currentLength = 0;
                    boolean completeRow = false;
                    while (!completeRow)
                    {
                        xPos += dX;
                        yPos += dY;
                        if (xPos >= 0 && xPos < 25 && yPos >= 0 && yPos < 25)
                        {
                            if (board.board[xPos][yPos] == (isX ? 1 : -1)) currentLength++;
                            else if (board.board[xPos][yPos] == 0) {
                                result.add(new Row(currentLength, true, board.board[x][y] == 0));
                                completeRow = true;
                            }
                            else {
                                result.add(new Row(currentLength, board.board[x][y] == 0, false));
                                completeRow = true;
                            }
                        }
                        else {
                            result.add(new Row(currentLength, board.board[x][y] == 0, false));
                            completeRow = true;
                        }
                    }
                }
        return result.stream().filter(row -> row.length == length).collect(Collectors.toList());
    }
}
