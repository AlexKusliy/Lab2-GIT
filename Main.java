import java.text.NumberFormat;

public class Main {
    public static void main(String[] args) {
        final double a = 0.7;
        final double b = 0.05;
        final double x = 0.4;

        final Function firstExpression =
            new Sum(
                new Multiplication(
                    new Pow(
                        Linear.X,
                        2.0
                    ),
                    new Sqrt(
                        new Absolute(
                            new Sum(
                                new Linear(a),
                                Const.NEGATIVE_ONE
                            )
                        )
                    )
                ),
                new Negate(
                    new Pow(
                        new Sine(
                            new Sum(
                                Linear.X,
                                new Const(b)
                            )
                        ),
                        3.0
                    )
                )
            );

        final Function secondExpression =
            new Sum(
                new Divide(
                    new Const(a),
                    Linear.X
                ),
                new Negate(
                    new Pow(
                        new Tangent(
                            new Sum(
                                new Linear(a),
                                new Const(b)
                            )
                        ),
                        3.0
                    )
                )
            );

        final Function thirdExpression =
            new Multiplication(
                new Sine(
                    new Absolute(
                        new Cosine(
                            new Pow(
                                Linear.X,
                                5.0
                            )
                        )
                    )
                ),
                new Divide(
                    new Linear(3.0),
                    new Negate(
                        new Sum(
                            Linear.X,
                            new Pow(
                                Linear.X,
                                2.0
                            )
                        )
                    )
                )
            );

        final NumberFormat nf = NumberFormat.getInstance();

        System.out.format("f1(x) = %s", firstExpression.toPrettyString(nf)).println();
        System.out.format("f1'(x) = %s", firstExpression.derivative().toPrettyString(nf)).println();
        System.out.format("f1(%s) = %f", x, firstExpression.calculate(x)).println();
        System.out.format("f1'(%s) = %f", x, firstExpression.derivative().calculate(x)).println();
        System.out.println("============================================");
        System.out.format("f2(x) = %s", secondExpression.toPrettyString(nf)).println();
        System.out.format("f2'(x) = %s", secondExpression.derivative().toPrettyString(nf)).println();
        System.out.format("f2(%s) = %f", x, secondExpression.calculate(x)).println();
        System.out.format("f2'(%s) = %f", x, secondExpression.derivative().calculate(x)).println();
        System.out.println("============================================");
        System.out.format("f3(x) = %s", thirdExpression.toPrettyString(nf)).println();
        System.out.format("f3'(x) = %s", thirdExpression.derivative().toPrettyString(nf)).println();
        System.out.format("f3(%s) = %f", x, thirdExpression.calculate(x)).println();
        System.out.format("f3'(%s) = %f", x, thirdExpression.derivative().calculate(x)).println();
    }
}
