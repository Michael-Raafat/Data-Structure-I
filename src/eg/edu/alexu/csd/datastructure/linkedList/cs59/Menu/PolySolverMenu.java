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
 * @author michael
 *
 */
public class PolySolverMenu {
	/**
	 * textfield for coef.
	 */
	private JTextField textField;
	/**
	 * textfield for degree.
	 */
	private JTextField textField1;
	/**
	 * Saved choice.
	 */
	private char chosenone;
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
		 	magic17 = 17, magic10 = 10, magic150 = 150,
		 	magic35 = 35, magic62 = 62, magic450 = 450,
		 	magic300 = 300, magic18 = 18, magic110 = 110,
		 	magic13 = 13, magic113 = 113, magic132 = 132,
		 	magic44 = 44, magic27 = 27, magic28 = 28,
		 	magic198 = 198, magic158 = 158, magic42 = 42,
		 	magic138 = 138, magic231 = 231;
	/**
	 * frame which contains the buttons,etc....
	 */
	private JFrame frame;
	/**
	 * frameset.
	 */
	private JFrame setframe;
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
	 * Function SettingPoly.
	 */
	private void settingPoly() {
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
		solver.setPolynomial(chosenone, terms);
		label.setText("Polynomial "
		+ chosenone + " has been set !");
	}
	/**
	 * Add another button in setform.
	 */
	private void addButtonSet() {
		try {
			int coeff
			= Integer.parseInt(
				textField.getText());
			if (coeff == 0) {
				throw new
				RuntimeException();
			}
			int degree = Integer.parseInt(
					textField1.
					getText());
			if (degree < 0) {
				throw new
				RuntimeException();
			}
			gotem.add(coeff);
			gotem.add(degree);
			textField.setText(null);
			textField1.setText(null);
		} catch (Exception foo) {
			label.setText("<html>"
			+ "Error during "
			+ "setting operation !"
			+ " Please try "
			+ "again and remember"
			+ " to input only "
			+ "positive numbers for "
			+ "degree and numbers "
			+ "only for "
			+ "coefficients and degrees "
			+ "& you enter them "
			+ "in the order of degree"
			+ "</html>");
			frame.setVisible(true);
			setframe.setVisible(false);
			gotem.clear();
		}
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
		chosenone
		= choice1.getSelectedItem().
		toString().charAt(0);
		try {
			frame.setVisible(false);
			setframe = new JFrame();
			setframe.setBounds(
					magic100, magic100, magic450, magic300);
			setframe.getContentPane().setBackground(Color.GRAY);
			setframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setframe.getContentPane().setLayout(null);
			setframe.setVisible(true);
			JLabel lblCoeffecient = new JLabel("Coeffecient :");
			lblCoeffecient.setForeground(new Color(0, magic100, 0));
			lblCoeffecient.setFont(new Font(
					"Trebuchet MS", Font.BOLD, magic18));
			lblCoeffecient.setBounds(
					magic12, magic13, magic132, magic44);
			setframe.getContentPane().add(lblCoeffecient);
			textField = new JTextField();
			textField.setBounds(
					magic12, magic62, magic201, magic35);
			setframe.getContentPane().add(textField);
			textField.setColumns(magic10);
			JLabel lblDegree = new JLabel("Degree :");
			lblDegree.setForeground(new Color(0, magic100, 0));
			lblDegree.setFont(new Font(
					"Trebuchet MS", Font.BOLD, magic18));
			lblDegree.setBounds(
					magic12, magic110, magic113, magic27);
			setframe.getContentPane().add(lblDegree);
			textField1 = new JTextField();
			textField1.setBounds(
					magic12, magic150, magic201, magic35);
			setframe.getContentPane().add(textField1);
			textField1.setColumns(magic10);
			JButton btnAddAnotherPoint
			= new JButton("Add Another Point");
			btnAddAnotherPoint.setBackground(Color.LIGHT_GRAY);
			btnAddAnotherPoint.setFont(new Font(
					"Times New Roman", Font.BOLD, magic15));
			btnAddAnotherPoint.setForeground(
					new Color(0, magic100, 0));

			btnAddAnotherPoint.addActionListener(
					new ActionListener() {
				public void actionPerformed(
						final ActionEvent e) {
					addButtonSet();
				}
			});
			btnAddAnotherPoint.setBounds(
					magic28, magic198, magic158, magic42);
			setframe.getContentPane().add(btnAddAnotherPoint);
			JButton btnEnd = new JButton("End");

			btnEnd.setBackground(Color.LIGHT_GRAY);
			btnEnd.setFont(new Font(
					"Times New Roman", Font.BOLD, magic15));
			btnEnd.setForeground(new Color(0, magic100, 0));
			btnEnd.addActionListener(new ActionListener() {
				public void actionPerformed(
						final ActionEvent e) {
					try {
						int coeff = Integer.parseInt(
								textField.
								getText());
						if (coeff == 0) {
							throw new
							RuntimeException();
						}
						int degree = Integer.parseInt(
								textField1.
								getText());
						if (degree < 0) {
							throw new
							RuntimeException();
						}
						gotem.add(coeff);
						gotem.add(degree);
						textField.setText(null);
						textField1.setText(null);
						setframe.setVisible(false);
						frame.setVisible(true);
						settingPoly();
						label.setText("Polynomial "
								+ chosenone
								+ " has been"
								+ " set!");
					} catch (Exception foo) {
						label.setText("<html>"
						+ "Error during "
						+ "setting operation !"
						+ " Please try "
						+ "again and remember"
						+ " to input only "
						+ "positive numbers for "
						+ "degree and numbers "
						+ "only for "
						+ "coefficients and degrees "
						+ "& you enter them "
						+ "in the order of degree"
						+ "</html>");
						frame.setVisible(true);
						setframe.setVisible(false);
						gotem.clear();
					}
				}
			});
			btnEnd.setBounds(magic231, magic198, magic138, magic42);
			setframe.getContentPane().add(btnEnd);
		} catch (Exception ex) {
			gotem.clear();
			label.setText("<html>"
			+ "Error during "
			+ "setting operation ! Please try "
			+ "again and remember to input only "
			+ "positive numbers for "
			+ "degree and numbers "
			+ "only for coefficients and degrees "
			+ "& you enter them in the order of degree"
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

		JButton btnSetPolynomial = new JButton("Set Polynomial");
		btnSetPolynomial.setBounds(magic12, magic34, magic153, magic38);
		btnSetPolynomial.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				setbuttonaction();
			}
		});
		frame.getContentPane().setLayout(null);
		btnSetPolynomial.setForeground(new Color(0, magic100, 0));
		btnSetPolynomial.setFont(
				new Font("Tahoma", Font.BOLD, magic15));
		btnSetPolynomial.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(btnSetPolynomial);

		JButton btnPrintPolynomial = new JButton("Print Polynomial");
		btnPrintPolynomial.setBounds(
				magic410, magic34, magic171, magic38);
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
		frame.getContentPane().add(btnPrintPolynomial);

		JButton btnClearPolynomial = new JButton("Clear Polynomial");
		btnClearPolynomial.setBounds(
				magic207, magic34, magic171, magic38);
		btnClearPolynomial.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				clearbutfun();
			}
		});
		btnClearPolynomial.setForeground(new Color(0, magic100, 0));
		btnClearPolynomial.setFont(new Font(
				"Tahoma", Font.BOLD, magic15));
		btnClearPolynomial.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(btnClearPolynomial);

		JButton btnShowLast = new JButton("Show Last Operation");
		btnShowLast.setBounds(magic204, magic201, magic199, magic48);
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
		frame.getContentPane().add(btnShowLast);

		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(magic12, magic213, magic97, magic25);
		btnAdd.setForeground(new Color(0, magic100, 0));
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, magic15));
		btnAdd.setBackground(Color.LIGHT_GRAY);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				addbuttonfunction();
			}
		});
		frame.getContentPane().add(btnAdd);

		JButton btnSubtract = new JButton("Subtract");
		btnSubtract.setBounds(magic136, magic262, magic115, magic25);
		btnSubtract.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				subtractfunction();
			}
		});
		btnSubtract.setBackground(Color.LIGHT_GRAY);
		btnSubtract.setForeground(new Color(0, magic100, 0));
		btnSubtract.setFont(new Font("Tahoma", Font.BOLD, magic15));
		frame.getContentPane().add(btnSubtract);

		JButton btnMultiply = new JButton("Multiply");
		btnMultiply.setBounds(magic484, magic213, magic97, magic25);
		btnMultiply.setForeground(new Color(0, magic100, 0));
		btnMultiply.setFont(new Font("Tahoma", Font.BOLD, magic15));
		btnMultiply.setBackground(Color.LIGHT_GRAY);
		btnMultiply.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				multiplyfunction();
			}
		});
		frame.getContentPane().add(btnMultiply);

		label = new JLabel("");
		label.setBounds(magic12, magic85, magic569, magic103);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Agency FB", Font.BOLD, magic17));
		label.setForeground(Color.GREEN);
		label.setOpaque(true);
		label.setBackground(Color.BLACK);
		frame.getContentPane().add(label);

		JButton btnNewButton = new JButton("Evaluate");
		btnNewButton.setBounds(magic356, magic262, magic135, magic25);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				evaluatebuttonfun();
			}
		});
		btnNewButton.setForeground(new Color(0, magic100, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, magic15));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(btnNewButton);
	}
}
