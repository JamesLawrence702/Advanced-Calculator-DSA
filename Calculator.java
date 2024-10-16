import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 
import java.util.Stack;


public class Calculator implements ActionListener
{                                           
    double base = 0; 
    double exponent = 0; 
    boolean isExponentMode = false;
    
    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10]; // Number Buttons
    JButton[] functionButtons = new JButton[32]; // Function Buttons
    JButton addButton, subButton, multiButton, divButton;
    JButton decimalButton, equalButton, openparenthesisButton, closeparenthesisButton, percentageButton, positivenegativeButton;
    JButton shiftButton, minmaxButton, absoluteButton, roundButton, delButton, clearButton;
    JButton matrixButton, summationButton, capitalpiButton, integralButton, modulusButton;
    JButton ceilButton, floorButton, lowercasepiButton, sinButton, cosButton, tanButton;
    JButton squarerootButton, permutationButton, combinationButton, factorialButton, customexponentButton, logarithmButton;
    JPanel panel;

    Font largeFont = new Font("SansSerif", Font.PLAIN, 40);
    Font myFont = new Font("SansSerif", Font.PLAIN, 20);
    double num1=0, num2=0, result=0;
    char operator;
    boolean squareRootFlag = false;
  
    Calculator() 
    {
        
        frame = new JFrame("Advanced/Scientific Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(720, 999);
        frame.getContentPane().setBackground(Color.decode("#1c1c1c"));
        frame.setLayout(null);
        frame.setVisible(true);
        
        textfield = new JTextField();
        textfield.setBounds(50, 30, 590, 95);
        textfield.setFont(largeFont);
        textfield.setEditable(false);
        textfield.setBackground(Color.decode("#1c1c1c"));
        textfield.setForeground(Color.WHITE);
        textfield.setBorder(BorderFactory.createEmptyBorder());
                            
        addButton = new Design("+", 30);
        subButton = new Design("-", 30);
        multiButton = new Design("×", 30);
        divButton = new Design("÷", 30);
        decimalButton = new Design(".", 30);
        equalButton = new Design("=", 30);
        openparenthesisButton = new Design("(", 30);
        openparenthesisButton.addActionListener(this);
        closeparenthesisButton = new Design(")", 30);
        closeparenthesisButton.addActionListener(this);
        percentageButton = new Design("%", 30); // modulus
        positivenegativeButton = new Design("±", 30);
        shiftButton = new Design ("SHIFT", 15);
        minmaxButton = new Design("MinMax", 15);
        absoluteButton = new Design("ABS", 15);
        roundButton = new Design("ROUND", 15);
        delButton = new Design("DEL", 15);
        clearButton = new Design("AC/ON", 15);
        matrixButton = new Design("[   ]", 15);
        summationButton = new Design("∑", 15);
        capitalpiButton = new Design("Π", 15);
        integralButton = new Design("∫", 15);
        modulusButton = new Design("|x|", 15);
        ceilButton = new Design("⌈CEIL⌉", 15);
        floorButton = new Design("⌊ FLR ⌋", 15);
        lowercasepiButton = new Design("π", 15);
        sinButton = new Design("sin", 15);
        cosButton = new Design("cos", 15);
        tanButton = new Design("tan", 15);
        squarerootButton = new Design("√", 15);
        permutationButton = new Design("nPr", 15);
        combinationButton = new Design("nCr", 15);
        factorialButton = new Design("!", 15);
        customexponentButton = new Design("xʸ", 15);
        logarithmButton = new Design("logₙy", 15);
        
        addButton.setBackground(Color.decode("#ff9500"));
        subButton.setBackground(Color.decode("#ff9500"));
        multiButton.setBackground(Color.decode("#ff9500"));
        divButton.setBackground(Color.decode("#ff9500"));
        percentageButton.setBackground(Color.decode("#ff9500"));
        equalButton.setBackground(Color.decode("#ff9500"));
        decimalButton.setBackground(Color.decode("#ff9500"));
        positivenegativeButton.setBackground(Color.decode("#ff9500"));
        closeparenthesisButton.setBackground(Color.decode("#ff9500"));
        openparenthesisButton.setBackground(Color.decode("#ff9500"));
        shiftButton.setBackground(Color.decode("#ff9500"));
        minmaxButton.setBackground(Color.decode("#505050"));
        absoluteButton.setBackground(Color.decode("#505050"));
        roundButton.setBackground(Color.decode("#505050"));
        delButton.setBackground(Color.decode("#ff9500"));
        clearButton.setBackground(Color.decode("#ff9500"));
        matrixButton.setBackground(Color.decode("#505050"));
        summationButton.setBackground(Color.decode("#505050"));
        capitalpiButton.setBackground(Color.decode("#505050"));
        integralButton.setBackground(Color.decode("#505050"));
        modulusButton.setBackground(Color.decode("#505050"));
        ceilButton.setBackground(Color.decode("#505050"));
        floorButton.setBackground(Color.decode("#505050"));
        lowercasepiButton.setBackground(Color.decode("#505050"));
        sinButton.setBackground(Color.decode("#505050"));
        cosButton.setBackground(Color.decode("#505050"));
        tanButton.setBackground(Color.decode("#505050"));
        squarerootButton.setBackground(Color.decode("#505050"));
        permutationButton.setBackground(Color.decode("#505050"));
        combinationButton.setBackground(Color.decode("#505050"));
        factorialButton.setBackground(Color.decode("#505050"));
        customexponentButton.setBackground(Color.decode("#505050"));
        logarithmButton.setBackground(Color.decode("#505050"));
        
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = multiButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decimalButton;
        functionButtons[5] = equalButton;
        functionButtons[6] = openparenthesisButton;
        functionButtons[7] = closeparenthesisButton;
        functionButtons[8] = percentageButton;
        functionButtons[9] = positivenegativeButton;
        functionButtons[10] = shiftButton;
        functionButtons[11] = minmaxButton;
        functionButtons[12] = absoluteButton;
        functionButtons[13] = roundButton;
        functionButtons[14] = delButton;
        functionButtons[15] = clearButton;
        functionButtons[16] = matrixButton;
        functionButtons[17] = summationButton;
        functionButtons[18] = capitalpiButton;
        functionButtons[19] = integralButton;
        functionButtons[20] = factorialButton;
        functionButtons[21] = ceilButton;
        functionButtons[22] = floorButton;
        functionButtons[23] = lowercasepiButton;
        functionButtons[24] = sinButton;
        functionButtons[25] = cosButton;
        functionButtons[26] = tanButton;
        functionButtons[27] = squarerootButton;
        functionButtons[28] = permutationButton;
        functionButtons[29] = combinationButton;
        functionButtons[30] = customexponentButton;
        functionButtons[31] = logarithmButton;
        
        
    for(int i=0; i<32; i++)
    {
        functionButtons[i].addActionListener(this);
        functionButtons[i].setForeground(Color.WHITE);
        functionButtons[i].setFont(myFont);
        functionButtons[i].setFocusable(false);
    }
            
        openparenthesisButton.setFont(new Font("SansSerif", Font.PLAIN, 35));
        closeparenthesisButton.setFont(new Font("SansSerif", Font.PLAIN, 35));
        multiButton.setFont(new Font("SansSerif", Font.PLAIN, 35));
        subButton.setFont(new Font("SansSerif", Font.PLAIN, 35));
        divButton.setFont(new Font("SansSerif", Font.PLAIN, 35));
        addButton.setFont(new Font("SansSerif", Font.PLAIN, 35));
        equalButton.setFont(new Font("SansSerif", Font.PLAIN, 35));
        positivenegativeButton.setFont(new Font("SansSerif", Font.PLAIN, 35));
        percentageButton.setFont(new Font("SansSerif", Font.PLAIN, 35));
        decimalButton.setFont(new Font("SansSerif", Font.PLAIN, 35));
        
    for(int i=0; i<10; i++)
    {
        numberButtons[i] = new Design(String.valueOf(i), 30);
        numberButtons[i].addActionListener(this);
        numberButtons[i].setFont(largeFont);
        numberButtons[i].setBackground(Color.decode("#d4d4d2"));
        numberButtons[i].setFocusable(false);
    }

        delButton.setBounds(410, 138, 110, 30);
        clearButton.setBounds(530, 138, 110, 30);
        shiftButton.setBounds(50, 138, 110, 30);
        minmaxButton.setBounds(170, 138, 110, 30);
        absoluteButton.setBounds(290, 138, 110, 30);
        roundButton.setBounds(50, 187, 110, 30);
        matrixButton.setBounds(170, 187, 110, 30);
        summationButton.setBounds(290, 187, 110, 30);
        capitalpiButton.setBounds(410, 187, 110, 30);
        integralButton.setBounds(530, 187, 110, 30);
        factorialButton.setBounds(50, 236, 110, 30);
        ceilButton.setBounds(170, 236, 110, 30);
        floorButton.setBounds(290, 236, 110, 30);
        lowercasepiButton.setBounds(410, 236, 110, 30);
        sinButton.setBounds(530, 236, 110,30);
        cosButton.setBounds(50, 285, 110, 30);
        tanButton.setBounds(170, 285, 110, 30);
        squarerootButton.setBounds(290, 285, 110, 30);
        permutationButton.setBounds(410, 285, 110, 30);
        combinationButton.setBounds(530, 285, 110, 30);
        customexponentButton.setBounds(50, 334, 110, 30);
        logarithmButton.setBounds(170, 334, 110, 30);
      
        panel = new JPanel();
        panel.setBounds (50, 395, 590, 550);
        panel.setLayout (new GridLayout(4, 4, 10, 10));
        //panel.setBackground(Color.GRAY);
         
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(openparenthesisButton);
        panel.add(closeparenthesisButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(multiButton);
        panel.add(divButton);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(subButton);
        panel.add(addButton);
        panel.add(positivenegativeButton);
        panel.add(numberButtons[0]);
        panel.add(decimalButton);
        panel.add(percentageButton);
        panel.add(equalButton);
        panel.setBackground(Color.decode("#1c1c1c"));
         
        frame.add(panel);
        frame.add(delButton);
        frame.add(clearButton);
        frame.add(textfield);
        frame.add(shiftButton);
        frame.add(minmaxButton);
        frame.add(absoluteButton);
        frame.add(roundButton);
        frame.add(matrixButton);
        frame.add(summationButton);
        frame.add(capitalpiButton);
        frame.add(integralButton);
        frame.add(ceilButton);
        frame.add(floorButton);
        frame.add(lowercasepiButton);
        frame.add(sinButton);
        frame.add(cosButton);
        frame.add(tanButton);
        frame.add(squarerootButton);
        frame.add(permutationButton);
        frame.add(combinationButton);
        frame.add(factorialButton);
        frame.add(customexponentButton);
        frame.add(logarithmButton);
        frame.setBackground(Color.decode("#1c1c1c"));
        frame.setVisible(true);    
    }
 
    public static void main(String[]args) 
    {
        Calculator calc = new Calculator();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
    for (int i = 0; i < 10; i++) 
    {
        if (e.getSource() == numberButtons[i]) 
        {
            textfield.setText(textfield.getText().concat(String.valueOf(i)));
        }
    }

    if (e.getSource() == decimalButton) 
    { //Decimal Button
        textfield.setText(textfield.getText().concat("."));
    }

    if (e.getSource() == summationButton) 
    { // summation
        try 
        {
            String startInput = JOptionPane.showInputDialog(null, "Enter start value");
            String endInput = JOptionPane.showInputDialog(null, "Enter end value");

            if (startInput != null && !startInput.isEmpty() && endInput != null && !endInput.isEmpty()) 
            {
                int start = Integer.parseInt(startInput);
                int end = Integer.parseInt(endInput);

                if (start > end) 
                {
                    textfield.setText("Error - start value must be equal to the end value.");
                    return;
                }
                String expressionInput = JOptionPane.showInputDialog(null, "Enter the expression (polynomial or any math expression):");

                if (expressionInput != null && !expressionInput.isEmpty()) 
                {
                    double summationResult = 0;
                    for (int x = start; x <= end; x++) 
                    {
                        double value = evaluatePolynomial(expressionInput, x);
                        summationResult += value;
                    }

                    textfield.setText("Σ (" + expressionInput + ") from " + start + " to " + end + " = " + summationResult);
                }
                else 
                {
                    textfield.setText("Error - invalid expression!");
                }
            } 
            else 
            {
                textfield.setText("Error - invalid range!");
            }
        } 
        catch (NumberFormatException ex) 
        {
            textfield.setText("Error - invalid input!");
        }
    }
    
    if (e.getSource() == addButton) 
    { //Addition Button
        textfield.setText(textfield.getText().concat(" + "));
        operator = '+';
    }
    
    if (e.getSource() == subButton) 
    { //Substraction Button
        textfield.setText(textfield.getText().concat(" - "));
        operator = '-';
    }
    
    if (e.getSource() == multiButton) 
    { //Multiplication Button
        textfield.setText(textfield.getText().concat(" × "));
        operator = '*';
    }
    
    if (e.getSource() == divButton) 
    { //Division Button
        textfield.setText(textfield.getText().concat(" ÷ "));
        operator = '/';
    }
    
    if (e.getSource() == equalButton) 
    { //Equal Button
        String expression = textfield.getText();
        
        if (expression.startsWith("√")) 
        { 
            num1 = Double.parseDouble(expression.substring(1));
            result = Math.sqrt(num1);
            textfield.setText(String.valueOf(result)); 
        } 
        else if (isExponentMode) 
        { // Handle exponent mode
            double exponent = Double.parseDouble(textfield.getText());
            result = Math.pow(base, exponent);
            textfield.setText(base + " ^ " + exponent + " = " + result); 
            isExponentMode = false; 
        } 
        else 
        {
            try 
            {
                result = evaluateExpression(expression);
                textfield.setText(String.valueOf(result)); 
            } 
            catch (Exception ex) 
            {
                textfield.setText("Error");
            }
        }
    }
    
    if (e.getSource() == clearButton) 
    { //Clear Button
        textfield.setText("");
    }
    
    if (e.getSource() == delButton) 
    { //Delete Button
        String string = textfield.getText();
        textfield.setText("");
        for (int i = 0; i < string.length() - 1; i++) 
        {
            textfield.setText(textfield.getText() + string.charAt(i));
        }
    }

    if (e.getSource() == capitalpiButton) 
    { // capital pi
        try 
        {
            String startInput = JOptionPane.showInputDialog(null, "Enter start value");
            String endInput = JOptionPane.showInputDialog(null, "Enter end value");

            if (startInput != null && !startInput.isEmpty() && endInput != null && !endInput.isEmpty()) 
            {
                int start = Integer.parseInt(startInput);
                int end = Integer.parseInt(endInput);

                if (start > end) 
                {
                    textfield.setText("Error - Start num must be less than the end num.");
                    return;
                }

                String expressionInput = JOptionPane.showInputDialog(null, "Enter the expression (polynomial or any math expression):");

                if (expressionInput != null && !expressionInput.isEmpty()) 
                {
                    double productResult = 1;

                    for (int x = start; x <= end; x++) 
                    {
                        double value = evaluatePolynomial(expressionInput, x);
                        productResult *= value;
                    }

                    textfield.setText("Π (" + expressionInput + ") from " + start + " to " + end + " = " + productResult);
                }
                else 
                {
                    textfield.setText("Error - invalid expression!");
                }
            } 
            else 
            {
                textfield.setText("Error - invalid range!");
            }
        } 
        catch (NumberFormatException ex) 
        {
            textfield.setText("Error - invalid input!");
        }
    }
    
    if (e.getSource() == absoluteButton) 
    { //Abosulute Button
        double absolute = Double.parseDouble(textfield.getText());
        absolute = Math.abs(absolute);
        textfield.setText(String.valueOf(absolute));
    }
    
    if (e.getSource() == floorButton) 
    { //Floor Button
        double floor = Double.parseDouble(textfield.getText());
        floor = Math.floor(floor);
        textfield.setText(String.valueOf(floor));
    }
    
    if (e.getSource() == ceilButton) 
    { //Ceiling Button
        double ceil = Double.parseDouble(textfield.getText());
        ceil = Math.ceil(ceil);
        textfield.setText(String.valueOf(ceil));
    }
     
    if (e.getSource() == roundButton) 
    { //Round off Button
        double roundOff = Double.parseDouble(textfield.getText());
        roundOff = Math.round(roundOff);
        textfield.setText(String.valueOf(roundOff));
    }
    
    if (e.getSource() == percentageButton) 
    { // Modulus Button
        textfield.setText(textfield.getText().concat(" % "));
        operator = '%';
    }
 
    if (e.getSource() == positivenegativeButton) 
    { // Positive Negative Button
        String text = textfield.getText();
 
        String[] tokens = text.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)"); // Split by non-digit boundaries
        String lastToken = tokens[tokens.length - 1]; // Get the last token

    if (!lastToken.isEmpty() && lastToken.matches("-?\\d+(\\.\\d+)?")) {
        double temp = Double.parseDouble(lastToken);
        temp *= -1; 
        text = text.substring(0, text.length() - lastToken.length()) + temp; // Replace the last number
        textfield.setText(text);
    }
} 
    if (e.getSource() == minmaxButton) 
    { //Min Max Button
        new MinMaxIO();
    }

    if (e.getSource() == integralButton) 
    { //Calculus Functions
        new PolynomialCalc().setVisible(true);
    }

    if (e.getSource() == matrixButton)
    { // Matrices
        new MatrixCalc().setVisible(true);
    }
    
    if (e.getSource() == factorialButton) 
    { //Factorial Button
        String input = textfield.getText();
        try 
        {
            double num = Double.parseDouble(input);
            result = factorial(num);
            textfield.setText(String.valueOf(result));
        } 
        catch (NumberFormatException ex) 
        {
            textfield.setText("Invalid input");
        }
    }
    
    if (e.getSource() == sinButton) 
    { // Sine Button
        double angle = Double.parseDouble(textfield.getText());
        double result = Math.sin(Math.toRadians(angle)); 
        textfield.setText(String.valueOf(result));
    }

    if (e.getSource() == cosButton) 
    { // Cosine Button
        double angle = Double.parseDouble(textfield.getText());
        double result = Math.cos(Math.toRadians(angle)); 
        textfield.setText(String.valueOf(result));
    }

    if (e.getSource() == tanButton) 
    { // Tangent Button
        double angle = Double.parseDouble(textfield.getText());
        double result = Math.tan(Math.toRadians(angle)); 
        textfield.setText(String.valueOf(result));
    }
    
    if (e.getSource() == squarerootButton) 
    { //Square Root Button
        textfield.setText(textfield.getText().concat("√"));
    }
    
    if (e.getSource() == customexponentButton) 
    { //Custom Exponent Button
        isExponentMode = true; 
        base = Double.parseDouble(textfield.getText()); 
        textfield.setText(""); 
    }

    if (e.getSource() == openparenthesisButton) 
    { // Open Parenthesis Button
        textfield.setText(textfield.getText().concat("("));
    }

    if (e.getSource() == closeparenthesisButton) 
    { // Close Parenthesis Button
        textfield.setText(textfield.getText().concat(")"));
    }
    
    if (e.getSource() == logarithmButton) 
    { // custom logarithm
        try 
        {
            String baseInput = JOptionPane.showInputDialog(null, "Enter base n");

            if (baseInput != null && !baseInput.isEmpty()) 
            {
                double base = Double.parseDouble(baseInput);
                String expressionInput = JOptionPane.showInputDialog(null, "Enter y");
                if (expressionInput != null && !expressionInput.isEmpty()) 
                {
                    String xValueInput = JOptionPane.showInputDialog(null, "Enter value of x (if polynomial, press enter if not)");

                    double x = 0;
                    boolean isPolynomial = false;

                    if (xValueInput != null && !xValueInput.isEmpty()) 
                    {
                        x = Double.parseDouble(xValueInput);
                        isPolynomial = true;
                    }

                    double value;
                    if (isPolynomial) 
                    {
                        value = evaluatePolynomial(expressionInput, x);
                    } 
                    else 
                    {
                        value = Double.parseDouble(expressionInput);
                    }

                    if (value > 0) 
                    {
                        double logResult = Math.log(value) / Math.log(base);
                        textfield.setText("logₙ" + base + "(" + expressionInput + ") = " + logResult);
                    } 
                    else 
                    {
                        textfield.setText("math.abs to be implemented soon");
                    }
                }
                else 
                {
                    textfield.setText("Error, invalid expression");
                }
            } 
            else 
            {
                textfield.setText("Error, invalid base");
            }
        } 
        catch (NumberFormatException ex) 
        {
            textfield.setText("Error, invalid input");
        }
    }
}

    private double evaluatePolynomial(String expression, double x) 
    {
        expression = expression.replace(" ", "").replace("^", "**");
        double result = 0;
        String[] terms = expression.split("\\+|(?=-)");

        for (String term : terms) 
        {
            double coefficient = 1;
            double exponent = 0;

            if (term.contains("x**")) 
            {
                String[] parts = term.split("x\\*\\*");
                coefficient = parts[0].isEmpty() ? 1 : Double.parseDouble(parts[0]);
                exponent = Double.parseDouble(parts[1]);
            } 
            else if (term.contains("x")) 
            {
                String[] parts = term.split("x");
                coefficient = parts[0].isEmpty() ? 1 : Double.parseDouble(parts[0]);
                exponent = 1;
            } 
            else 
            {
                coefficient = Double.parseDouble(term);
                exponent = 0;
            }
            result += coefficient * Math.pow(x, exponent);
        }
        return result;
    }

    
    public double evaluateExpression(String expression) {
    expression = expression.replaceAll("\\s+", ""); 
    Stack<Double> values = new Stack<>();
    Stack<Character> operators = new Stack<>();

    boolean expectNegativeNumber = true;

    StringBuilder number = new StringBuilder();

    for (int i = 0; i < expression.length(); i++) {
        char currentChar = expression.charAt(i);

        if (Character.isDigit(currentChar) || currentChar == '.') {
            number.append(currentChar);
            expectNegativeNumber = false; 
        } else if (currentChar == '-' && expectNegativeNumber) {

            number.append(currentChar);
            expectNegativeNumber = false;
        } else if (currentChar == '(') {

            operators.push(currentChar);
            expectNegativeNumber = true; 
        } else if (currentChar == ')') {

            while (!operators.isEmpty() && operators.peek() != '(') {
                values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
            }
            operators.pop(); 
        } else {
            
            if (number.length() > 0) {
                values.push(Double.parseDouble(number.toString()));
                number.setLength(0); 
            }

            if (isOperator(currentChar)) {
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(currentChar)) {
                    values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                }
                operators.push(currentChar);
                expectNegativeNumber = true; 
            }
        }
    }

    
    if (number.length() > 0) {
        values.push(Double.parseDouble(number.toString()));
    }


    while (!operators.isEmpty()) {
        values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
    }

    return values.pop();
}


    private boolean isOperator(char c) 
    {
        return c == '+' || c == '-' || c == '×' || c == '÷' || c == '%';
    }

    private int precedence(char operator) 
    {
        switch (operator) 
        {
            case '+':
            case '-':
                return 1;
            case '×':
            case '÷':
            case '%':
                return 2;
            default:
                return 0;
        }
    }

    private double applyOperator(char operator, double b, double a) 
    {
        switch (operator) 
        {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '×':
                return a * b;
            case '÷':
                if (b == 0) 
                {
                    throw new UnsupportedOperationException("Cannot divide by zero");
                }
                return a / b;
            case '%':
                return a % b;
            default:
                throw new UnsupportedOperationException("Unsupported operator: " + operator);
        }
    }

    // Keeping factorial function as it is
    private static double factorial(double num) 
    {
        if (num < 0) 
        {
            return 0; 
        }
        double result = 1;
        for (int i = 2; i <= num; i++) 
        {
            result *= i;
        }
        return result;
    }
}
