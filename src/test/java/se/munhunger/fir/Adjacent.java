package se.munhunger.fir;

import org.junit.Assert;
import org.junit.Test;
import se.munhunger.fir.model.Board;
import se.munhunger.fir.model.Point;

public class Adjacent
{
    @Test
    public void placesAdjacent() {
        Board board = new Board();
        board.o.add(new Point(10, 10));
        board.o.add(new Point(10,11));

        board.x.add(new Point(1,1));
        board.x.add(new Point(1,2));
        Solver.solve(board);

        board.initArray();
        Assert.assertTrue(board.board[1][0] == 1 || board.board[1][3] == 1);
    }
}
