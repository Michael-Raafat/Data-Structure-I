package eg.edu.alexu.csd.datastructure.linkedList.cs59.Menu;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import eg.edu.alexu.csd.datastructure.linkedList.cs59.Polysolver;
/**
 * GUI for the project polysolver.
 * @author Michael.
 *
 */
public class PolySolverMenu {
	/**
	 * ArrayList to save Input from.
	 */
	private ArrayList<Integer> gotem = new ArrayList<Integer>();
	/**
	 * Label to display results and messages.
	 */
	private JLabel label;
	/**
	 * Solver used to get data.
	 */
	private Polysolver solver = new Polysolver();
	/**
	 * constants.
	 */
	private final int magic100 = 100, magic611 = 611, magic347 = 347,
			magic12 = 12, magic34 = 34, magic153 = 153,
			magic38 = 38, magic15 = 15, magic410 = 410,
			magic171 = 171, magic207 = 207, magic204 = 204,
			magic201 = 201, magic199 = 199, magic48 = 48,
			magic213 = 213, magic25 = 25, magic97 = 97,
			magic136 = 136, magic262 = 262, magic115 = 115,
			magic484 = 484, magic85 = 85, magic569 = 569,
			magic103 = 103, magic356 = 356, magic135 = 135,
		 	magic17 = 17;
	/**
	 * frame which contains the buttons,etc....
	 */
	private JFrame frame;

	/**
	 * Launch the application.
	 * *@param args
	 * *not used
	 **/
	public static void main(final String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PolySolverMenu window
					= new PolySolverMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PolySolverMenu() {
		initialize();
	}
	/**
	 * The set button activity.
	 */
	private void setbuttonaction() {
		String[] polys = {"A", "B", "C" };
		JComboBox<String> choice1
			= new JComboBox<String>(polys);
		JTextField field1 = new JTextField();
		JOptionPane.showMessageDialog(null,
				choice1,
				"Choose First Operator", 1);
		char a
		= choice1.getSelectedItem().
		toString().charAt(0);
		boolean check = true;
		try {
			while (check) {
				JOptionPane.showMessageDialog(
						null,
						field1,
					"Enter Coeffeicient",
						1);
				int cof
				= Integer.parseInt(
					field1.getText());
				field1.setText(null);
				if (cof == 0) {
					throw new
					RuntimeException();
				}
				JOptionPane.showMessageDialog(
						null,
					field1, "Enter Power",
						1);
				int pow
			= Integer.parseInt(field1.getText());
				if (pow < 0) {
					throw new
					RuntimeException();
				}
				gotem.add(cof);
				gotem.add(pow);
			String[] options = new String[2];
				options[0] = new String("Yes");
				options[1] = new String("No");
			int ans = JOptionPane.showOptionDialog(
					frame.getContentPane(),
					"Do you want to insert"
					+ " another variable ?",
					"Terminate ?", 0,
					JOptionPane.
					INFORMATION_MESSAGE,
					null, options, null);
			if (ans == JOptionPane.NO_OPTION) {
					check = false;
				}
			}
			int[][] terms
			= new int[gotem.size() / 2][2];
			int len = 0;
			for (int count = 0;
				count < gotem.size();
					count += 2) {
				terms[len][0]
						= gotem.get(
							count);
				terms[len][1]
						= gotem.get(
						count + 1);
				len++;
			}
			gotem.clear();
			solver.setPolynomial(a, terms);
			label.setText("Polynomial "
			+ a + " has been set !");
		} catch (Exception ex) {
			gotem.clear();
			label.setText("<html>"
			+ "Error during "
			+ "setting operation ! Please try "
			+ "again and remember to input only "
			+ "positive numbers for "
			+ "degree and numbers "
			+ "only for coefficients and degrees"
			+ "</html>");
		}
	}
	/**
	 * add function for the add button.
	 */
	private void addbuttonfunction() {
		String[] polys = {"A", "B", "C" };
		JComboBox<String> choice1
		= new JComboBox<String>(polys);
		JComboBox<String> choice2
		= new JComboBox<String>(polys);
		JOptionPane.showMessageDialog(null,
				choice1,
				"Choose First Operator",
				1);
		JOptionPane.showMessageDialog(null,
				choice2,
				"Choose Second Operator",
				1);
		char a = choice1.getSelectedItem().
				toString().charAt(0);
		char b = choice2.getSelectedItem().
				toString().charAt(0);
		try {
			solver.add(a, b);
			label.setText("<html>"
			+ solver.print('R')
			+ "</html>");
		} catch (RuntimeException er) {
			label.setText("Error ! One of the"
				+ " chosen Polynomials "
				+ "are not set");
		}
	}
	/**
	 * function for sub. button.
	 */
	private void subtractfunction() {
		String[] polys = {"A", "B", "C" };
		JComboBox<String> choice1
		= new JComboBox<String>(polys);
		JComboBox<String> choice2
		= new JComboBox<String>(polys);
		JOptionPane.showMessageDialog(null,
				choice1,
				"Choose First Operator",
				1);
		JOptionPane.showMessageDialog(null,
				choice2,
				"Choose Second Operator",
				1);
		char a = choice1.getSelectedItem().
				toString().charAt(0);
		char b = choice2.getSelectedItem().
				toString().charAt(0);
		try {
			solver.subtract(a, b);
			label.setText("<html>"
			+ solver.print('R')
			+ "</html>");
		} catch (RuntimeException er) {
			label.setText("<html>"
		+ "Error ! One of the chosen"
		+ " Polynomials are not set"
					+ "</html>");
		}
	}
	/**
	 * function for multi button.
	 */
	private void multiplyfunction() {
		String[] polys = {"A", "B", "C" };
		JComboBox<String> choice1
		= new JComboBox<String>(polys);
		JComboBox<String> choice2
		= new JComboBox<String>(polys);
		JOptionPane.showMessageDialog(null,
				choice1,
				"Choose First Operator",
				1);
		JOptionPane.showMessageDialog(null,
				choice2,
				"Choose Second Operator",
				1);
		char a = choice1.getSelectedItem().
				toString().charAt(0);
		char b = choice2.getSelectedItem().
				toString().charAt(0);
		try {
			solver.multiply(a, b);
			label.setText("<html>"
			+ solver.print('R')
			+ "</html>");
		} catch (RuntimeException er) {
			label.setText("Error ! "
				+ "One of the chosen"
				+ " Polynomials are not set");
		}
	}
	/**
	 * evalute button function.
	 */
	private void evaluatebuttonfun() {
		String[] polys = {"A", "B", "C" };
		JComboBox<String> choice1
		= new JComboBox<String>(polys);
		JOptionPane.showMessageDialog(null,
				choice1, "Choose"
					+ "First Operator",
						1);
		char a = choice1.getSelectedItem().
				toString().charAt(0);
		try {
			JTextField field3 = new JTextField();
			JOptionPane.showMessageDialog(null,
					field3,
					"Enter your float",
					1);
			float floatn = Float.parseFloat(
					field3.getText());
			field3.setText(null);
			label.setText("Polynomial "
			+ a
			+ " is equal "
			+ solver.evaluatePolynomial(a, floatn));
		} catch (Exception er) {
			label.setText("Error !");
		}
	}
	/**
	 * clearfunction for the button clear.
	 */
	private void clearbutfun() {
		String[] polys = {"A", "B", "C" };
		JComboBox<String> choice1
		= new JComboBox<String>(polys);
		JOptionPane.showMessageDialog(null,
				choice1,
				"Choose First Operator",
				1);
		char a = choice1.getSelectedItem().
				toString().charAt(0);
		try {
			solver.clearPolynomial(a);
			label.setText("Polynomial "
			+ a
			+ " is cleared.");
		} catch (RuntimeException er) {
			label.setText("Error !");
		}
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(magic100, magic100, magic611, magic347);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnSetPolynomial = new JButton("Set Polynomial");
		btnSetPolynomial.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				setbuttonaction();
			}
		});
		btnSetPolynomial.setForeground(new Color(0, magic100, 0));
		btnSetPolynomial.setFont(
				new Font("Tahoma", Font.BOLD, magic15));
		btnSetPolynomial.setBackground(Color.LIGHT_GRAY);
		btnSetPolynomial.setBounds(magic12, magic34, magic153, magic38);
		frame.getContentPane().add(btnSetPolynomial);

		JButton btnPrintPolynomial = new JButton("Print Polynomial");
		btnPrintPolynomial.addActionListener(new ActionListener() {

			public void actionPerformed(final ActionEvent e) {
				String[] polys = {"A", "B", "C" };
				JComboBox<String> choice1
				= new JComboBox<String>(polys);
				JOptionPane.showMessageDialog(null, choice1,
						"Choose First Operator", 1);
				char a = choice1.getSelectedItem().
						toString().charAt(0);
				String lastop = solver.print(a);
				if (lastop == null) {
					label.setText("Polynomial "
				+ a
				+ " has not been set yet!");
				} else {
					label.setText(
							"<html>"
					+ lastop
					+ "</html>");
				}
			}
		});

		btnPrintPolynomial.setForeground(new Color(0, magic100, 0));
		btnPrintPolynomial.setFont(
				new Font("Tahoma", Font.BOLD, magic15));
		btnPrintPolynomial.setBackground(Color.LIGHT_GRAY);
		btnPrintPolynomial.setBounds(
				magic410, magic34, magic171, magic38);
		frame.getContentPane().add(btnPrintPolynomial);

		JButton btnClearPolynomial = new JButton("Clear Polynomial");
		btnClearPolynomial.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				clearbutfun();
			}
		});
		btnClearPolynomial.setForeground(new Color(0, magic100, 0));
		btnClearPolynomial.setFont(new Font(
				"Tahoma", Font.BOLD, magic15));
		btnClearPolynomial.setBackground(Color.LIGHT_GRAY);
		btnClearPolynomial.setBounds(
				magic207, magic34, magic171, magic38);
		frame.getContentPane().add(btnClearPolynomial);

		JButton btnShowLast = new JButton("Show Last Operation");
		btnShowLast.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				String lastop = solver.print('R');
				if (lastop == null) {
					label.setText(
							"Still no operation "
							+ "has been done !");
				} else {
					label.setText("<html>"
				+ lastop
				+ "</html>");
				}
			}
		});
		btnShowLast.setForeground(new Color(0, magic100, 0));
		btnShowLast.setFont(new Font("Tahoma", Font.BOLD, magic15));
		btnShowLast.setBackground(Color.LIGHT_GRAY);
		btnShowLast.setBounds(magic204, magic201, magic199, magic48);
		frame.getContentPane().add(btnShowLast);

		JButton btnAdd = new JButton("Add");
		btnAdd.setForeground(new Color(0, magic100, 0));
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, magic15));
		btnAdd.setBackground(Color.LIGHT_GRAY);
		btnAdd.setBounds(magic12, magic213, magic97, magic25);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				addbuttonfunction();
			}
		});
		frame.getContentPane().add(btnAdd);

		JButton btnSubtract = new JButton("Subtract");
		btnSubtract.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				subtractfunction();
			}
		});
		btnSubtract.setBackground(Color.LIGHT_GRAY);
		btnSubtract.setForeground(new Color(0, magic100, 0));
		btnSubtract.setFont(new Font("Tahoma", Font.BOLD, magic15));
		btnSubtract.setBounds(magic136, magic262, magic115, magic25);
		frame.getContentPane().add(btnSubtract);

		JButton btnMultiply = new JButton("Multiply");
		btnMultiply.setForeground(new Color(0, magic100, 0));
		btnMultiply.setFont(new Font("Tahoma", Font.BOLD, magic15));
		btnMultiply.setBackground(Color.LIGHT_GRAY);
		btnMultiply.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				multiplyfunction();
			}
		});
		btnMultiply.setBounds(magic484, magic213, magic97, magic25);
		frame.getContentPane().add(btnMultiply);

		label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(magic12, magic85, magic569, magic103);
		label.setFont(new Font("Agency FB", Font.BOLD, magic17));
		label.setForeground(Color.GREEN);
		label.setOpaque(true);
		label.setBackground(Color.BLACK);
		frame.getContentPane().add(label);

		JButton btnNewButton = new JButton("Evaluate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				evaluatebuttonfun();
			}
		});
		btnNewButton.setForeground(new Color(0, magic100, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, magic15));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(magic356, magic262, magic135, magic25);
		frame.getContentPane().add(btnNewButton);
	}
}