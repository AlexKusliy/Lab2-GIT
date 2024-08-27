import java.text.NumberFormat;

public class Negate implements Function {
    public Negate(Function term) {
        this.term = term;
    }

    @Override
    public double calculate(double x) {
        return -term.calculate(x);
    }

    @Override
    public Function derivative() {
        return new Negate(term.derivative());
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return "-" + term.toPrettyString(nf);
    }

    private final Function term;
}
