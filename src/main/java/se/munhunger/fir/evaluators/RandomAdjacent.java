package se.munhunger.fir.evaluators;

import se.munhunger.fir.model.Board;
import se.munhunger.fir.model.Move;
import se.munhunger.fir.model.Point;
import se.munhunger.fir.model.Row;
import se.munhunger.fir.util.Lines;

import java.util.*;
import java.util.stream.Collectors;

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
        boolean isX = board.x.size() <= board.o.size();
        Optional<Move> result = search(isX, isX, board);
        if(!result.isPresent())
            result = search(isX, !isX, board);
        if(!result.isPresent())
            return Optional.empty();
        return result;
    }

    private Optional<Move> search(boolean isX, boolean search, Board board) {
        for(int x = 0; x < 25; x++)
            for(int y = 0; y < 25; y++)
                if(board.board[x][y] == 0)
                    if(!Lines.getAmountOfLengths(1, search, x, y, board).isEmpty())
                        return Optional.of(new Move(isX, new Point(x, y)));
        return Optional.empty();
    }
}
