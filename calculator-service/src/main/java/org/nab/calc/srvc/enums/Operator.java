package org.nab.calc.srvc.enums;

/**
 * 
 * @author HP
 *
 */
public enum Operator {

	ADD("+", 2),

	SUBTRACT("-", 2),

	MULTIPLY("*", 2),

	DIVIDE("/", 2);

	private String symbol;
	private int numOfOperands;

	Operator(String symbol, int numOfOperands) {
		this.symbol = symbol;
		this.numOfOperands = numOfOperands;
	}

	/**
	 * 
	 * @return symbol
	 */
	public String getSymbol() {
		return symbol;
	}


	/**
	 * 
	 * @return operandsNumber
	 */
	public int getNumOfOperands() {
		return numOfOperands;
	}

	/**
	 * 
	 * @return symbol
	 */
	@Override
	public String toString() {
		return symbol;
	}
	
	/**
	 * This method returns the Operator
	 * 
	 * @param value
	 * @return Operator
	 */
	public static Operator getEnum(String value) {
		Operator operator = null;
		if (null != value) {
			for (Operator opr : values()) {
				if (opr.getSymbol().equalsIgnoreCase(value)) {
					operator = opr;
				}
			}
		}
		return operator;
	}
}