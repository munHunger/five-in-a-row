package se.munhunger.fir.evaluators;

import se.munhunger.fir.model.Board;
import se.munhunger.fir.model.Move;
import se.munhunger.fir.model.Point;

import java.util.Optional;

/**
 * @author Marcus Münger
 */
public class OpenThreeInRow extends Evaluator {

    @Override
    public int getPriority() {
        return 200;
    }

    @Override
    public Optional<Move> evaluate(Board board) {
        return Optional.empty();
    }
}
