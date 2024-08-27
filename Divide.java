import java.text.NumberFormat;

public class Divide implements Function {
    public Divide(Function termA, Function termB) {
        this.termA = termA;
        this.termB = termB;
    }

    @Override
    public double calculate(double x) {
        return termA.calculate(x) / termB.calculate(x);
    }

    @Override
    public Function derivative() {
        return new Multiplication(termA, new Pow(termB, -1.0)).derivative();
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return termA.toPrettyString(nf) + "/" + termB.toPrettyString(nf);
    }

    private final Function termA;
    private final Function termB;
}
