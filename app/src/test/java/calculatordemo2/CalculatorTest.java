package calculatordemo2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private static Calculator classUnderTest;


    @BeforeAll
    public static void setUp() {
        classUnderTest = new Calculator();
    }

    @DisplayName("Tests the square function")
    @Test
    void testSquare() {
        double num = 5.0;
        assertEquals(num*num, classUnderTest.calcScience(Calculator.singleOperator.square, num));
    }

    @DisplayName("Tests the square root function")
    @Test
    void testSquareRoot() {
        double num = 9.0;
        assertEquals(Math.sqrt(num), classUnderTest.calcScience(Calculator.singleOperator.squareRoot, num));
    }

    @DisplayName("Tests the 1/x function")
    @Test
    void testOneDividedBy() {
        double num = 2.0;
        assertEquals(1/num, classUnderTest.calcScience(Calculator.singleOperator.oneDevidedBy, num));
    }

    @DisplayName("Tests the cosine function in degrees")
    @Test
    void testCos() {
        double num = 45.0;
        assertEquals(Math.cos(num), classUnderTest.calcScience(Calculator.singleOperator.cos, num));
    }

    @DisplayName("Tests the sine function in degrees")
    @Test
    void testSin() {
        double num = 30.0;
        assertEquals(Math.sin(num), classUnderTest.calcScience(Calculator.singleOperator.sin, num));
    }

    @DisplayName("Tests the tangent function in degrees")
    @Test
    void testTan() {
        double num = 60.0;
        assertEquals(Math.tan(num), classUnderTest.calcScience(Calculator.singleOperator.tan, num));
    }

    @DisplayName("Tests whether an error is thrown if a null mode is passed")
    @Test
    void testThrowError() {
        assertThrows(Error.class, () -> classUnderTest.calcScience(null, 10.0));
    }


    //Testing TwoOpOperations() method
    @DisplayName("Tests two operations in normal mode")
    @Test
    public void testTwoOpNormal()
    {
        classUnderTest.mode = Calculator.twoOperator.normal;
        classUnderTest.num2 = 15.0;
        double result = classUnderTest.twoOpOperations();
        assertEquals(15.0, result, 0.001);

    }

    @DisplayName("Tests addition of two numbers")
    @Test
    public void testAdd()
    {
        classUnderTest.mode = Calculator.twoOperator.add;
        classUnderTest.num1 = 6.0;
        classUnderTest.num2 = 15.0;
        double result = classUnderTest.twoOpOperations();
        assertEquals(21.0, result, 0.001);
    }

    @DisplayName("Tests subtraction of two numbers")
    @Test
    public void testSub()
    {
        classUnderTest.mode = Calculator.twoOperator.subtract;
        classUnderTest.num1 = 6.0;
        classUnderTest.num2 = 15.0;
        double result = classUnderTest.twoOpOperations();
        assertEquals(-9.0, result, 0.001);
    }

    @DisplayName("Tests multipication of two numbers")
    @Test
    public void testMult()
    {
        classUnderTest.mode = Calculator.twoOperator.multiply;
        classUnderTest.num1 = 6.0;
        classUnderTest.num2 = 15.0;
        double result = classUnderTest.twoOpOperations();
        assertEquals(90.0, result, 0.001);
    }

    @DisplayName("Tests division of two numbers")
    @Test
    public void testDiv()
    {
        classUnderTest.mode = Calculator.twoOperator.divide;
        classUnderTest.num1 = 6.0;
        classUnderTest.num2 = 15.0;
        double result = classUnderTest.twoOpOperations();
        assertEquals(0.4, result, 0.001);
    }

    @DisplayName("Tests with invalid mode")
    @Test
    public void testInvalidMode()
    {
        classUnderTest.mode = Calculator.twoOperator.normal;
        classUnderTest.num2 = 15.0;
        double result = classUnderTest.twoOpOperations();
        assertEquals(15.0, result, 0.001);
    }

    @DisplayName("Tests multiple operations")
    @Test
    public void testMultiple1()
    {
        classUnderTest.mode = Calculator.twoOperator.add;
        classUnderTest.num1 = 2.0;
        classUnderTest.num2 = 3.0;
        classUnderTest.twoOpOperations(); //result is 5.0
        classUnderTest.mode = Calculator.twoOperator.multiply;
        classUnderTest.num1 = 5.0;
        classUnderTest.num2 = 2.0;
        assertEquals(10.0, classUnderTest.twoOpOperations(), 0.001);
    }

    @DisplayName("Tests multiple operations")
    @Test
    public void testMultiple2()
    {
        classUnderTest.mode = Calculator.twoOperator.subtract;
        classUnderTest.num1 = 2.0;
        classUnderTest.num2 = 3.0;
        classUnderTest.twoOpOperations(); //result is -1.0
        classUnderTest.mode = Calculator.twoOperator.add;
        classUnderTest.num1 = -1.0;
        classUnderTest.num2 = 2.0;
        assertEquals(1.0, classUnderTest.twoOpOperations(), 0.001);
    }

    @DisplayName("Tests multiple operations")
    @Test
    public void testMultiple3()
    {
        classUnderTest.mode = Calculator.twoOperator.divide;
        classUnderTest.num1 = 1.0;
        classUnderTest.num2 = 2.0;
        classUnderTest.twoOpOperations(); //result is 0.5
        classUnderTest.mode = Calculator.twoOperator.multiply;
        classUnderTest.num1 = 0.5;
        classUnderTest.num2 = 2.0;
        assertEquals(1.0, classUnderTest.twoOpOperations(), 0.001);
    }


    //Testing twoOpCaller() method
    @DisplayName("Tests addition operation")
    @Test
    public void testOpCallerAdd()
    {
        double result = classUnderTest.twoOpCaller(Calculator.twoOperator.add, 5.0);
        assertEquals(Double.NaN, result, 0.01);
    }

    @DisplayName("Tests subtraction operation")
    @Test
    public void testOpCallerSubtract()
    {
        double result = classUnderTest.twoOpCaller(Calculator.twoOperator.subtract, 5.0);
        assertEquals(Double.NaN, result, 0.01);
    }


    @DisplayName("Tests the arccos function")
    @Test
    void testArccos() {
        double num = 45.0;
        assertEquals(Math.acos(num), classUnderTest.calcScience(Calculator.singleOperator.arccos, num));
    }

    @DisplayName("Tests the arcsin function")
    @Test
    void testArcsin() {
        double num = 45.0;
        assertEquals(Math.asin(num), classUnderTest.calcScience(Calculator.singleOperator.arcsin, num));
    }

    @DisplayName("Tests the arctan function")
    @Test
    void testArctan() {
        double num = 45.0;
        assertEquals(Math.atan(num), classUnderTest.calcScience(Calculator.singleOperator.arctan, num));
    }

    
}
