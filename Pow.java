import java.text.NumberFormat;

public class Pow implements Function {
    public Pow(Function term, double power) {
        this.term = term;
        this.power = power;
    }

    @Override
    public double calculate(double x) {
        return Math.pow(term.calculate(x), power);
    }

    @Override
    public Function derivative() {
        return new Multiplication(new Multiplication(new Const(power), new Pow(term, power - 1.0)), term.derivative());
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return term.toPrettyString(nf) + "^" + power;
    }

    private final Function term;
    private final double power;
}
