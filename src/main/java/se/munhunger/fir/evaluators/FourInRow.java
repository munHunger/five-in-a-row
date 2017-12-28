package se.munhunger.fir.evaluators;

import se.munhunger.fir.model.Board;
import se.munhunger.fir.model.Move;
import se.munhunger.fir.model.Point;

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
        return Optional.empty();
    }
}
