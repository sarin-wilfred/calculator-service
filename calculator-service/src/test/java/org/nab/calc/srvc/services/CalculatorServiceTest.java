package org.nab.calc.srvc.services;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nab.calc.srvc.enums.Operator;
import org.nab.calc.srvc.exceptions.CalculatorException;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

/**
 * 
 * @author HP
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(CalculatorService.class)
public class CalculatorServiceTest {

	@Test
	public void testprocessForAddition() throws Exception {
		CalculatorService calculatorService = new CalculatorService();
		Assert.assertEquals(7.8D, calculatorService.process("4.1 + 3.7"), 0.0D); 
	}
	
	@Test
	public void testprocessForAdditionWithOperand1AsNegative() throws Exception {
		CalculatorService calculatorService = new CalculatorService();
		Assert.assertEquals(-1.02D, calculatorService.process("-4.12 + 3.1"), 0.0D); 
	}
	
	@Test
	public void testprocessForAdditionWithOperand2AsNegative() throws Exception {
		CalculatorService calculatorService = new CalculatorService();
		Assert.assertEquals(-7.12D, calculatorService.process("-4.12 - 3.0"), 0.0D); 
	}
	
	@Test
	public void testprocessForSubtraction() throws Exception {
		CalculatorService calculatorService = new CalculatorService();
		Assert.assertEquals(96.2D, calculatorService.process("196.40 - 100.2"), 0.0D); 
	}
	
	@Test
	public void testprocessForSubtractionWithOperand1AsNegative() throws Exception {
		CalculatorService calculatorService = new CalculatorService();
		Assert.assertEquals(-296.6D, calculatorService.process("-196.40 - 100.2"), 0.0D); 
	}
	
	@Test
	public void testprocessForSubtractionWithOperand2AsNegative() throws Exception {
		CalculatorService calculatorService = new CalculatorService();
		Assert.assertEquals(296.6D, calculatorService.process("196.40 - -100.2"), 0.0D); 
	}
	
	@Test
	public void testprocessForSubtractionWithBothOperandAsNegative() throws Exception {
		CalculatorService calculatorService = new CalculatorService();
		Assert.assertEquals(-96.2D, calculatorService.process("-196.40 - -100.2"), 0.0D); 
	}
	
	@Test
	public void testprocessForMultiplication() throws Exception {
		CalculatorService calculatorService = new CalculatorService();
		Assert.assertEquals(55.12D, calculatorService.process("10.60 * 5.2"), 0.0D); 
	}
	
	@Test
	public void testprocessForMultiplicationWithOperand1AsNegative() throws Exception {
		CalculatorService calculatorService = new CalculatorService();
		Assert.assertEquals(-55.12D, calculatorService.process("-10.60 * 5.2"), 0.0D); 
	}
	
	@Test
	public void testprocessForMultiplicationWithOperand2AsNegative() throws Exception {
		CalculatorService calculatorService = new CalculatorService();
		Assert.assertEquals(-55.12D, calculatorService.process("-10.60 * 5.2"), 0.0D); 
	}
	
	@Test
	public void testprocessForMultiplicationWithBothOperandAsNegative() throws Exception {
		CalculatorService calculatorService = new CalculatorService();
		Assert.assertEquals(55.12D, calculatorService.process("-10.60 * -5.2"), 0.0D); 
	}
	
	@Test
	public void testprocessForMultiplicationWithOperand1AsZero() throws Exception {
		CalculatorService calculatorService = new CalculatorService();
		Assert.assertEquals(0D, calculatorService.process("0 * 5.2"), 0.0D); 
	}
	
	@Test
	public void testprocessForMultiplicationWithOperand2AsZero() throws Exception {
		CalculatorService calculatorService = new CalculatorService();
		Assert.assertEquals(0D, calculatorService.process("10.60 * 0"), 0.0D); 
	}
	
	@Test
	public void testprocessForDivision() throws Exception {
		CalculatorService calculatorService = new CalculatorService();
		Assert.assertEquals(7.0D, calculatorService.process("15.4 / 2.2"), 0.0D); 
	}
	
	@Test
	public void testprocessForDivisionWithOperand1AsNegative() throws Exception {
		CalculatorService calculatorService = new CalculatorService();
		Assert.assertEquals(-7.0D, calculatorService.process("-15.4 / 2.2"), 0.0D); 
	}
	
	@Test
	public void testprocessForDivisionWithOperand2AsNegative() throws Exception {
		CalculatorService calculatorService = new CalculatorService();
		Assert.assertEquals(-7.0D, calculatorService.process("15.4 / -2.2"), 0.0D); 
	}
	
	@Test
	public void testprocessForDivisionWithBothOperandAsNegative() throws Exception {
		CalculatorService calculatorService = new CalculatorService();
		Assert.assertEquals(7.0D, calculatorService.process("-15.4 / -2.2"), 0.0D); 
	}
	
	@Test
	public void testprocessForDivisionWithOperand1AsZero() throws Exception {
		CalculatorService calculatorService = new CalculatorService();
		Assert.assertEquals(0D, calculatorService.process("0 / 2.2"), 0.0D); 
	}
	
	@Test
	public void testprocessForDivisionWithOperand2AsZero() throws Exception {
		CalculatorService calculatorService = new CalculatorService();
		Assert.assertNull(calculatorService.process("15.4 / 0")); 
	}
	
	
	
	//Tests for private methods 
	@Test
	public void testCalculateForAddition() throws Exception {
		Assert.assertEquals(227.62D, Whitebox.invokeMethod(new CalculatorService(), "calculate",Operator.ADD, 126.81D, 100.81D), 0.0D);
	}
	
	@Test
	public void testCalculateForSubtraction() throws Exception {
		Assert.assertEquals(186.11D, Whitebox.invokeMethod(new CalculatorService(), "calculate",Operator.SUBTRACT, 196.81D, 10.70D), 0.0D);
	}
	
	@Test
	public void testCalculateForMultiplicaton() throws Exception {
		Assert.assertEquals(170.40400000000002D, Whitebox.invokeMethod(new CalculatorService(), "calculate",Operator.MULTIPLY, 15.08D, 11.3D), 0.0D);
	}
	
	@Test
	public void testCalculateToOperatorForDivision() throws Exception {
		Assert.assertEquals(20.966101694915253D, Whitebox.invokeMethod(new CalculatorService(), "calculate",Operator.DIVIDE, 123.7D, 5.9D), 0.0D);
	}
	
	@Test
	public void testConvertToOperatorForAddition() throws Exception {
		Assert.assertEquals(Operator.ADD, Whitebox.invokeMethod(new CalculatorService(), "convertToOperator","+"));
	}
	
	@Test
	public void testConvertToOperatorForSubtraction() throws Exception {
		Assert.assertEquals(Operator.SUBTRACT, Whitebox.invokeMethod(new CalculatorService(), "convertToOperator","-"));
	}
	
	@Test
	public void testConvertToOperatorForMultiplication() throws Exception {
		Assert.assertEquals(Operator.MULTIPLY, Whitebox.invokeMethod(new CalculatorService(), "convertToOperator","*"));
	}
	
	@Test
	public void testConvertToOperatorForDivision() throws Exception {
		Assert.assertEquals(Operator.DIVIDE, Whitebox.invokeMethod(new CalculatorService(), "convertToOperator","/"));
	}
	
	@Test(expected= CalculatorException.class)
	public void testConvertToOperatorForInvalidOperator() throws Exception {
		MatcherAssert.assertThat(Whitebox.invokeMethod(new CalculatorService(), "convertToOperator","#"), CoreMatchers.is("Invalid operator"));
	}
	
	@Test
	public void testConvertToDouble() throws Exception {
		Assert.assertEquals(1.999D, Whitebox.invokeMethod(new CalculatorService(), "convertToDouble","1.999"), 0.0D);
	}
	
	@Test
	public void testConvertToDoubleForException() throws Exception {
		Assert.assertNull(Whitebox.invokeMethod(new CalculatorService(), "convertToDouble", "#"));
	}
	
}