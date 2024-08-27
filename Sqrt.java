import java.text.NumberFormat;

public class Sqrt implements Function {
    public Sqrt(Function term) {
        this.term = term;
    }

    @Override
    public double calculate(double x) {
        return Math.sqrt(term.calculate(x));
    }

    @Override
    public Function derivative() {
        return new Multiplication(new Multiplication(new Const(0.5), new Divide(Const.ONE, new Sqrt(term))), term.derivative());
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return "sqrt(" + term.toPrettyString(nf) + ")";
    }

    private final Function term;
}
