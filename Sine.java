import java.text.NumberFormat;

public class Sine implements Function {
    public Sine(Function term) {
        this.term = term;
    }

    @Override
    public double calculate(double x) {
        return Math.sin(term.calculate(x));
    }

    @Override
    public Function derivative() {
        return new Multiplication(new Cosine(term), term.derivative());
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return "sin(" + term.toPrettyString(nf) + ")";
    }

    private final Function term;
}
