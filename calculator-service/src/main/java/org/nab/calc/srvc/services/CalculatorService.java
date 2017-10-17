/**
 * 
 */
package org.nab.calc.srvc.services;

import java.util.StringTokenizer;

import org.nab.calc.srvc.enums.Operator;
import org.nab.calc.srvc.exceptions.CalculatorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author HP
 *
 */
@Service
public class CalculatorService {
	
	private static final Logger LOG = LoggerFactory.getLogger(CalculatorService.class);
	
	/**
	 * This method acts as an entry point to Calculator service that co-ordinates all the operation
	 * 
	 * @param input
	 * @return result
	 */
	public Double process(String input){
		LOG.debug("STARTS-process");
		Double result  = null;

		try {
			StringTokenizer tokenizer= new StringTokenizer(input, " ");
			if(tokenizer.countTokens() != 3) {
				throw new CalculatorException("Invalid statement, statement should be in format: operand operator operand");
			}
			Double operand1 = convertToDouble(tokenizer.nextToken().trim());
			Operator operator = convertToOperator(tokenizer.nextToken().trim());
			Double operand2 = convertToDouble(tokenizer.nextToken().trim());

			//calculate
			switch(operator.getNumOfOperands()) {
			case 2:
				//For binary operator
				result = calculate(operator, operand1, operand2);
				break;
			case 1:
				//For unary operator(sine, cosine)
				break;
			} 
			
			LOG.debug("#Result: " + result);
		} catch (CalculatorException calcExcptn) {
			LOG.debug("Error message :- " + calcExcptn.getMessage());
		}
		
		LOG.debug("STARTS-process");
		return result;

	}
	
	/**
	 * This method calculates the output of two operands based on the operator
	 * 
	 * @param operator
	 * @param operand1
	 * @param operand2
	 * @return result
	 * @throws CalculatorException
	 */
	private Double calculate(Operator operator, Double operand1, Double operand2) throws CalculatorException {
		LOG.debug("STARTS-calculate");
		Double result = null;
		switch(operator) {
			case ADD: 
				result = operand1 + operand2;
				break;
			case SUBTRACT: 
				result = operand1 - operand2;
				break;
			case MULTIPLY: 
				result = operand1 * operand2;
				break;
			case DIVIDE: 
				if (operand2 == 0)
					throw new CalculatorException("Cannot divide by Zero (0).");
				result = operand1 / operand2;
				break;
			default:
				break;
		}
		
		LOG.debug("ENDS-calculate");
		return result;
	}
	
	/**
	 * This method converts the string operand to double
	 * 
	 * @param input
	 * @return double
	 */
	private Double convertToDouble(String input) {
		LOG.debug("INSIDE-convertToDouble");
		try {
			return Double.parseDouble(input);
		} catch (NumberFormatException numberFormatException) {
			return null;
		}
	}
	
	/**
	 * This method converts the string operator to Operator enum
	 * 
	 * @param input
	 * @return operator
	 * @throws CalculatorException
	 */
	private Operator convertToOperator(String input) throws CalculatorException {
		LOG.debug("INSIDE-convertToOperators");
		Operator operator = Operator.getEnum(input);
		if(null == operator)
			throw new CalculatorException("Invalid operator");
		return operator;
	}
}
