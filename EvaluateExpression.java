public class EvaluateExpression {
    
    public static final String SPACE = " ";

    public static String toPostfix(String expr) {
        StringBuilder result = new StringBuilder();
        Stack<String> operators = new ArrayStack<>();
        for (String token : expr.split("\\s+")) {
            if (rank(token) > 0) {
                while(!operators.isEmpty() && rank(operators.peek()) >= rank(token)) {
                    result.append(operators.pop() + SPACE);
                }
                operators.push(token);
            }
            else if (rank(token) == 0) {
                if (token.equals("(")) {
                    operators.push(token);
                }
                else {
                    while(!operators.isEmpty() && !operators.peek().equals("(")) {
                        result.append(operators.pop() + SPACE);
                    }
                    if (!operators.isEmpty()) operators.pop();
                }
            }
            else {
                result.append(token + SPACE);
            }
        }
        while(!operators.isEmpty()) {
            result.append(operators.pop() + SPACE);
        }
        return result.toString();
    }

    public static double evalPostfix(String expr) {
        Stack<Double> operands = new ArrayStack<>();
        for (String token : expr.split("\\s+")) {
            if (rank(token) > 0) {
                double right = operands.pop();
                double left = operands.pop();
                operands.push(applyOperator(token, left, right));
            }
            else {
                operands.push(Double.parseDouble(token));
            }
        }
        return operands.pop();
    }

    public static double applyOperator(String token, double left, double right) {
        switch(token) {
            case "^":
                return Math.pow(left, right);
            case "/":
                return left / right;
            case "*":
                return left * right;
            case "-":
                return left - right;
            case "+":
                return left + right;
            default:
                return 0;
        }
    }

    private static int rank(String op) {
        switch(op) {
            case "^":
                return 3;
            case "*":
            case "/":
                return 2;
            case "+":
            case "-":
                return 1;
            case "(":
            case ")":
                return 0;
            default:
                return -1;        
        }
    }

    public static boolean isBalanced(String expr) {
        Stack<Character> brackets = new ArrayStack<>();
        char[] exprch = expr.toCharArray();
        for (char ch : exprch) {
            if (ch == '(' || ch == '[' || ch == '{') brackets.push(ch);
            else if (ch == ')' || ch == ']' || ch == '}') {
                if (!brackets.isEmpty() && isMatched(brackets.pop(), ch)) continue;
                else return false;
            }
            else continue;
        }
        if (!brackets.isEmpty()) return false;
        else return true;
    }

    private static boolean isMatched(char left, char right) {
        if (left == '(' && right == ')' || left == '[' && right == ']' || left == '{' && right == '}') return true;
        else return false;
    }

    public static void main(String[] args) {
        System.out.println(toPostfix("a + b * c - d + e"));
        System.out.println(evalPostfix(toPostfix("( 1 + 9 ) ^ 1.5 / 4")));
        System.out.println(evalPostfix("1 6 4 5 * + 2 / -"));
        System.out.println("(x+y*(z-w)), Balanced:" + isBalanced("(x+y*(z-w))"));
        System.out.println("((x+(y))*(z-w)), Balanced:" + isBalanced("((x+(y))*(z-w))"));
        System.out.println("(x+y*(z-w), Balanced:" + isBalanced("(x+y*(z-w)"));
        System.out.println("x+y*(z-w)), Balanced:" + isBalanced("x+y*(z-w))"));
        System.out.println("(x+y*[z-w]), Balanced:" + isBalanced("(x+y*[z-w])"));
        System.out.println("(x+y*[z-w)], Balanced:" + isBalanced("(x+y*[z-w)]"));
    }
}