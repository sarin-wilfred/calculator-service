package org.nab.calc.srvc;

import java.io.Console;

import org.nab.calc.srvc.services.CalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author HP
 *
 */
@SpringBootApplication
public class AppConfig  implements CommandLineRunner {
	
	private static final Logger LOG = LoggerFactory.getLogger(AppConfig.class);

	public static void main(String[] args) {
		LOG.debug("STARTS-main");
		SpringApplication.run(AppConfig.class, args);
		LOG.debug("ENDS-main");
	}
	
	@Autowired
	private CalculatorService calculatorService;
	
	public void run(String... args) throws Exception {
		LOG.debug("STARTS-run");
		boolean keepRunning = true;
		Double result = null;
		Console console = System.console();
		if (console == null) {
			String input = "";
			// *(Multiplication) will act as a wild card if so it won't work properly if given as command line argument from eclipse
			for (String arg : args) {
				input = input + arg + " ";
			}
			result = calculatorService.process(input);
			if(result == null) {
				return;
			} 
			System.out.println("#Result: " + result);
			keepRunning = false;
		}
		
		
		// If you are running from command prompt with out passing command line arguments all operators will work
		while (keepRunning) {
			LOG.debug("Input data in the format operand operator operand and 'exit' to quits");
			String input = console.readLine(": ");
			if ("exit".equals(input)) {
				keepRunning = false;
			} else {
				result = calculatorService.process(input);
				if(result == null) {
					continue;
				}
				System.out.println("#Result: " + result);
			}
		}
		LOG.debug("ENDS-run");
	}
	
}
