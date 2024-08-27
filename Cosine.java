import java.text.NumberFormat;

public class Cosine implements Function {
    public Cosine(Function term) {
        this.term = term;
    }

    @Override
    public double calculate(double x) {
        return Math.cos(term.calculate(x));
    }

    @Override
    public Function derivative() {
        return new Multiplication(new Negate(new Sine(term)), term.derivative());
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return "cos(" + term.toPrettyString(nf) + ")";
    }

    private final Function term;
}
