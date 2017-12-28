package se.munhunger.fir.evaluators;

import se.munhunger.fir.model.Board;
import se.munhunger.fir.model.Move;
import se.munhunger.fir.model.Point;

import java.util.Optional;
import java.util.Random;

/**
 * @author Marcus Münger
 */
public class RandomPosition extends Evaluator {
    @Override
    public int getPriority() {
        return Integer.MAX_VALUE;
    }

    @Override
    public Optional<Move> evaluate(Board board) {
        Random rng = new Random();
        return Optional.of(new Move(board.x.size() <= board.o.size(), new Point(rng.nextInt(25), rng.nextInt(25))));
    }
}
