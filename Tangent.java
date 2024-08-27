import java.text.NumberFormat;

public class Tangent implements Function {
    public Tangent(Function term) {
        this.term = term;
    }

    @Override
    public double calculate(double x) {
        return Math.tan(term.calculate(x));
    }

    @Override
    public Function derivative() {
        return new Multiplication(new Divide(new Sine(term), new Cosine(term)).derivative(), term.derivative());
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return "tan(" + term.toPrettyString(nf) + ")";
    }

    private final Function term;
}
