package se.munhunger.fir.evaluators;

import se.munhunger.fir.model.Board;
import se.munhunger.fir.model.Move;
import se.munhunger.fir.model.Point;

import java.util.*;

/**
 * @author Marcus Münger
 */
public class RandomAdjacent extends Evaluator {
    @Override
    public int getPriority() {
        return 9001;
    }

    @Override
    public Optional<Move> evaluate(Board board) {
        List<Point> points = new ArrayList<>();
        points.addAll(board.o);
        points.addAll(board.x);
        for(Point adjacent : points)
            for(int x = -1; x <= 1; x++)
                for(int y = -1; y <= 1; y++)
                    if(!(x == 0 && y == 0))
                        if(adjacent.x + x >= 0 && adjacent.x + x < 25 && adjacent.y + y >= 0 && adjacent.y + y < 25)
                            if(board.board[x+adjacent.x][y+adjacent.y] == 0)
                                return Optional.of(new Move(board.x.size() <= board.o.size(), new Point(x + adjacent.x, y + adjacent.y)));
        return Optional.empty();
    }
}
