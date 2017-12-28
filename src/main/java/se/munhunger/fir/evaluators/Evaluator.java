package se.munhunger.fir.evaluators;

import se.munhunger.fir.model.Board;
import se.munhunger.fir.model.Move;

import java.util.Optional;

public abstract class Evaluator {
    public abstract int getPriority();

    public abstract Optional<Move> evaluate(Board board);
}
