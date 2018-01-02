package se.munhunger.fir.evaluators;

import se.munhunger.fir.model.Board;
import se.munhunger.fir.model.Move;
import se.munhunger.fir.model.Point;
import se.munhunger.fir.model.Row;
import se.munhunger.fir.util.Lines;

import java.util.List;
import java.util.Optional;

/**
 * @author Marcus Münger
 */
public class FourInRow extends Evaluator {

    @Override
    public int getPriority() {
        return 100;
    }

    @Override
    public Optional<Move> evaluate(Board board) {
        for(int x = 0; x < 25; x++)
            for(int y = 0; y < 25; y++)
                if(board.board[x][y] == 0) {
                    List<Row> rows = Lines.getAmountOfLengths(4, board.x.size() <= board.o.size(), x, y, board);
                    if(!rows.isEmpty())
                        return Optional.of(new Move(board.x.size() <= board.o.size(), new Point(x, y)));
                }
        return Optional.empty();
    }
}
