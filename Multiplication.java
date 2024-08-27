import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.StringJoiner;

public class Multiplication extends Composite {
    public Multiplication() {
        super();
    }

    public Multiplication(Function... terms) {
        super(terms);
    }

    public Multiplication(ArrayList<Function> terms) {
        super(terms);
    }

    @Override
    public double calculate(double x) {
        double result = 1.0;

        for (Function function : terms()) {
            result *= function.calculate(x);
        }

        return terms().isEmpty() ? 0.0 : result;
    }

    @Override
    public Function derivative() {
        final ArrayList<Function> derivativeTerms = new ArrayList<Function>(terms().size());

        for (Function outerFunction : terms()) {
            final ArrayList<Function> sumDerivativeTerms = new ArrayList<Function>(terms().size());

            for (Function innerFunction : terms()) {
                if (innerFunction == outerFunction) {
                    sumDerivativeTerms.add(innerFunction.derivative());
                }
                else {
                    sumDerivativeTerms.add(innerFunction);
                }
            }

            derivativeTerms.add(new Multiplication(sumDerivativeTerms));
        }

        return new Sum(derivativeTerms);
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        final StringJoiner joiner = new StringJoiner("*");

        for (Function function : terms()) {
            joiner.add(function.toPrettyString(nf));
        }

        return String.format("(%s)", joiner.toString());
    }

    public static Sum of(Function... terms) {
        return new Sum(terms);
    }
}