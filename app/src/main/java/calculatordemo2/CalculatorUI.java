package calculatordemo2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * CalculatorUI class that creates and adds buttons, event handling for the buttons, and calls calculator
 * methods and functions for logic when necessary
 * @author Soria, Steckler, Tesic, Metsis
 */

public class CalculatorUI implements ActionListener {
	private final JFrame frame;
	private final JPanel panel;
	private final JPanel buttonPanel;
	private final JTextArea text;
	//private final JButton jButtons[], add, sub, mult, div, equal, cancel, sqrRt, sqr, inverse, cos, sin, tan;
	public final String[] numValue = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };
	private final String[] opValue = {"+", "-", "*", "/","="};
	private final String[] trigValue = {"Cos","Sin","Tan", "Arccos", "Arcsin", "Arctan"};
	private final String[] comFunctValue = {"√","x*x","1/x", "C"};
	private final Calculator calc;

	/**
	 * The main top level GUI of the calculator and it's frame, button, and text area for # display
	 */
	public CalculatorUI() {
		frame = new JFrame("Calculator");
		frame.setResizable(true);
		frame.setLayout(new BorderLayout());

		panel = new JPanel(new BorderLayout()); //back most panel (holds text field NORTH & common functions just below)
		buttonPanel = new JPanel(new BorderLayout()); //organizes panels involving numbers, operators, and trig

		text = new JTextArea();
		calc = new Calculator();

	}

	/**
	 * Initializes and sets the frame size, buttons, panels. The main runner method of the UI class.
	 */
	public void init() {
		frame.setSize(300, 340);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.add(panel, BorderLayout.NORTH);
		frame.add(buttonPanel, BorderLayout.CENTER);

		panel.add(text, BorderLayout.NORTH);

		ButtonPanel numPanel = new ButtonPanel(numValue, 4, 3);
		ButtonPanel opPanel = new ButtonPanel(opValue, 5, 1);
		ButtonPanel trigPanel = new ButtonPanel(trigValue, 2,3);
		ButtonPanel comFunctPanel = new ButtonPanel(comFunctValue, 1, 4);

		buttonPanel.add(opPanel.getPanel(), BorderLayout.EAST);
		buttonPanel.add(numPanel.getPanel(), BorderLayout.CENTER);
		buttonPanel.add(trigPanel.getPanel(), BorderLayout.SOUTH);
		buttonPanel.add(comFunctPanel.getPanel(), BorderLayout.NORTH);
		
		// add event listeners
		opPanel.addButtonListener(this);
		numPanel.addButtonListener(this);
		trigPanel.addButtonListener(this);
		comFunctPanel.addButtonListener(this);

		frame.setVisible(true);
	}

	/**
	 * Event handling implementation for Calculator button pressing
	 * @param e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		final Object source = e.getSource();
		JButton buttonPicked  = (JButton) source;
		// check 0-9 and update textfield

		for (int i = 0; i < numValue.length; i++) {
			if (numValue[i] == buttonPicked.getText())
			{
				text.replaceSelection(numValue[i]);
				return;
			}
		}
		
		for (int i = 0; i < opValue.length; i++) {
			if (opValue[i] == buttonPicked.getText())
			{
				if (i == 0)
				{
					writer(calc.twoOpCaller(Calculator.twoOperator.add, reader()));
				}
				else if (i == 1)
				{
					writer(calc.twoOpCaller(Calculator.twoOperator.subtract, reader()));
				}
				else if (i == 2)
				{
					writer(calc.twoOpCaller(Calculator.twoOperator.multiply,
					reader()));
				}
				else if (i == 3)
				{
					writer(calc.twoOpCaller(Calculator.twoOperator.divide, reader()));
				}
				else
				{
					writer(calc.calculateEqual(reader()));
				}
			}
		}

		for (int i = 0; i < trigValue.length; i++) {
			if (trigValue[i] == buttonPicked.getText())
			{
				if(i == 0)
				{
					writer(calc.calcScience(Calculator.singleOperator.cos,
					reader()));
				}
				else if (i == 1)
				{
					writer(calc.calcScience(Calculator.singleOperator.sin,
					reader()));
				}
				else if (i == 2)
				{
					writer(calc.calcScience(Calculator.singleOperator.tan,
					reader()));
				}
				else if (i == 3)
				{
					writer(calc.calcScience(Calculator.singleOperator.arccos, reader()));
				}
				else if (i == 4)
				{
					writer(calc.calcScience(Calculator.singleOperator.arcsin, reader()));
				}
				else
				{
					writer(calc.calcScience(Calculator.singleOperator.arctan, reader()));
				}
			}

		}
		for (int i = 0; i < comFunctValue.length; i++) {
			if (comFunctValue[i] == buttonPicked.getText())
			{
				if(i == 0)
				{
					writer(calc.calcScience(Calculator.singleOperator.squareRoot,
					reader()));
				}
				else if(i == 1)
				{
					writer(calc.calcScience(Calculator.singleOperator.square,
					reader()));
				}
				else if (i == 2)
				{
					writer(calc.calcScience(
					Calculator.singleOperator.oneDevidedBy, reader()));
				}
				else
				{
					writer(calc.reset());
				}
			}
		}
		
		// for easy continued calculations/copy
		text.selectAll();
		
	}

	/**
	 * Helper function that gets the texfield area and updates the number input
	 * @return the updated number
	 */
	public Double reader() {
		Double num;
		String str;
		str = text.getText();
		num = Double.valueOf(str);

		return num;
	}

	/**
	 * Helper function that sets the textfield with the number, and avoids NaN issues
	 * @param num
	 */
	public void writer(final Double num) {
		if (Double.isNaN(num)) {
			text.setText("");
		} else {
			text.setText(Double.toString(num));
		}
	}
}
