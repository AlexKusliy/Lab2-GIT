import java.text.NumberFormat;

public class Absolute implements Function {
    public Absolute(Function term) {
        this.term = term;
    }

    @Override
    public double calculate(double x) {
        double result = term.calculate(x);

        return result > 0 ? result : -result;
    }

    @Override
    public Function derivative() {
        return new Multiplication(new Divide(term, new Absolute(term)), term.derivative());
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return "|" + term.toPrettyString(nf) + "|";
    }

    private final Function term;
}
