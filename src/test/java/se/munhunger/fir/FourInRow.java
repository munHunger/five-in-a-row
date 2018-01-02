package se.munhunger.fir;

import org.junit.Assert;
import org.junit.Test;
import se.munhunger.fir.model.Board;
import se.munhunger.fir.model.Point;

public class FourInRow
{
    @Test
    public void placesFiveInRowVerticalOpen() {
        Board board = new Board();
        board.o.add(new Point(10,10));
        board.o.add(new Point(10,11));
        board.o.add(new Point(10,12));
        board.o.add(new Point(10,13));

        board.x.add(new Point(0,1));
        board.x.add(new Point(0,2));
        board.x.add(new Point(0,3));
        board.x.add(new Point(0,4));
        Solver.solve(board);

        board.initArray();
        Assert.assertTrue(board.board[0][0] == 1 || board.board[0][5] == 1);
    }
    @Test
    public void placesFiveInRowVerticalClosedTop() {
        Board board = new Board();
        board.o.add(new Point(0,0));
        board.o.add(new Point(10,11));
        board.o.add(new Point(10,12));
        board.o.add(new Point(10,13));

        board.x.add(new Point(0,1));
        board.x.add(new Point(0,2));
        board.x.add(new Point(0,3));
        board.x.add(new Point(0,4));
        Solver.solve(board);

        board.initArray();
        Assert.assertTrue(board.board[0][5] == 1);
    }
    @Test
    public void placesFiveInRowVerticalClosedBottom() {
        Board board = new Board();
        board.o.add(new Point(0,5));
        board.o.add(new Point(10,11));
        board.o.add(new Point(10,12));
        board.o.add(new Point(10,13));

        board.x.add(new Point(0,1));
        board.x.add(new Point(0,2));
        board.x.add(new Point(0,3));
        board.x.add(new Point(0,4));
        Solver.solve(board);

        board.initArray();
        Assert.assertTrue(board.board[0][0] == 1);
    }
    @Test
    public void placesFiveInRowHorizontalOpen() {
        Board board = new Board();
        board.o.add(new Point(10,10));
        board.o.add(new Point(10,11));
        board.o.add(new Point(10,12));
        board.o.add(new Point(10,13));

        board.x.add(new Point(5,5));
        board.x.add(new Point(6,5));
        board.x.add(new Point(7,5));
        board.x.add(new Point(8,5));
        Solver.solve(board);

        board.initArray();
        Assert.assertTrue(board.board[4][5] == 1 || board.board[9][5] == 1);
    }
    @Test
    public void placesFiveInRowDiagonalOpen() {
        Board board = new Board();
        board.o.add(new Point(11,10));
        board.o.add(new Point(10,11));
        board.o.add(new Point(10,12));
        board.o.add(new Point(10,13));

        board.x.add(new Point(5,5));
        board.x.add(new Point(6,6));
        board.x.add(new Point(7,7));
        board.x.add(new Point(8,8));
        Solver.solve(board);

        board.initArray();
        Assert.assertTrue(board.board[4][4] == 1 || board.board[9][9] == 1);
    }
}
