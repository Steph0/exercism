import java.text.MessageFormat;

class CalculatorConundrum {
    public String calculate(int operand1, int operand2, String operation) {

        Operation calculator = switch (operation) {
            case "+" -> new Add(operand1, operand2);
            case "/" -> new Divide(operand1, operand2);
            case "*" -> new Multiply(operand1, operand2);
            case "" -> throw new IllegalArgumentException("Operation cannot be empty");
            case null -> throw new IllegalArgumentException("Operation cannot be null");
            default -> throw new IllegalOperationException(
                    MessageFormat.format("Operation ''{0}'' does not exist", operation));
        };

        return MessageFormat.format(
                "{0,number,#} {1} {2,number,#} = {3,number,#}",
                calculator.x(), operation, calculator.y(), calculator.calculate());
    }
}

record Add(int x, int y) implements Operation {
    @Override
    public int calculate() {
        return x + y;
    }

    static Add of(int x, int y) {
        return new Add(x, y);
    }
}

record Multiply(int x, int y) implements Operation {
    @Override
    public int calculate() {
        return x * y;
    }
}

record Divide(int x, int y) implements Operation {
    @Override
    public int calculate() {
        try {
            return x / y;
        } catch (ArithmeticException e) {
            throw new IllegalOperationException("Division by zero is not allowed", e);
        }
    }
}

interface Operation {
    int x();
    int y();
    int calculate();
}
