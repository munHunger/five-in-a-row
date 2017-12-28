package se.munhunger.fir;

import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;
import se.munhunger.fir.evaluators.Evaluator;
import se.munhunger.fir.model.Board;
import se.munhunger.fir.model.Move;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author Marcus Münger
 */
public class Solver {
    public static void solve(Board board) {
        board.initArray();
        List<ClassLoader> classLoadersList = new LinkedList<>();
        classLoadersList.add(ClasspathHelper.contextClassLoader());
        classLoadersList.add(ClasspathHelper.staticClassLoader());

        Reflections reflections = new Reflections(new ConfigurationBuilder()
                                                          .setScanners(new SubTypesScanner(false /* don't exclude Object.class */), new ResourcesScanner())
                                                          .setUrls(ClasspathHelper.forClassLoader(classLoadersList.toArray(new ClassLoader[0])))
                                                          .filterInputsBy(new FilterBuilder().include(FilterBuilder.prefix("se.munhunger.fir.evaluators"))));
        Set<Class<? extends Evaluator>> classes = reflections.getSubTypesOf(Evaluator.class);
        classes.stream().map(evalClass ->
                             {
                                 try {
                                     return evalClass.newInstance();
                                 } catch (InstantiationException e) {
                                     e.printStackTrace();
                                 } catch (IllegalAccessException e) {
                                     e.printStackTrace();
                                 }
                                 return null;
                             })
                        .sorted(Comparator.comparingInt(Evaluator::getPriority))
                        .filter(eval -> eval.evaluate(board).isPresent())
                        .findFirst()
                        .ifPresent(eval -> {
                            Move move = eval.evaluate(board).get();
                            if(move.isX)
                                board.x.add(move.p);
                            else
                                board.o.add(move.p);
                        });
    }
}
