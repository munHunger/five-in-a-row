package se.munhunger.fir.evaluators;

import se.munhunger.fir.model.Board;
import se.munhunger.fir.model.Move;
import se.munhunger.fir.model.Point;
import se.munhunger.fir.model.Row;
import se.munhunger.fir.util.Lines;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ClosedThreeInRow extends Evaluator
{
    @Override
    public int getPriority()
    {
        return 300;
    }

    @Override
    public Optional<Move> evaluate(Board board)
    {
        boolean isX = board.x.size() <= board.o.size();
        for(int x = 0; x < 25; x++)
            for(int y = 0; y < 25; y++)
                if(board.board[x][y] == 0)
                {
                    List<Row> rows = Lines.getAmountOfLengths(2, !isX, x, y, board);
                    if (!rows.stream().filter(row -> !row.isFree).collect(Collectors.toList()).isEmpty())
                        return Optional.of(new Move(!isX, new Point(x, y)));
                }
        return Optional.empty();
    }
}
