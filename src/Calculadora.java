import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class Calculadora {

	private JFrame frame;
	private JTextField campo1;
	private JButton C;
	private JButton Par;
	private JButton uno;
	private JButton dos;
	private JButton tres;
	private JButton cuatro;
	private JButton cinco;
	private JButton seis;
	private JButton siete;
	private JButton ocho;
	private JButton nueve;
	private JButton cero;
	private JButton igual;
	private JButton suma;
	private JButton resta;
	private JButton multiplicar;
	private JButton dividir;
	private String contenidoCampo1 = "";
	private float num1 = 0.0f;
	private float num2 = 0.0f;
	private String operador = "";
	private float num = 0.0f;

	public String sincero(float resultado) {
		String retorno = "";
		retorno = Float.toString(resultado);// le digo que retorno lo pase de flotante a string y lo meta en resultado.
		if (resultado % 1 == 0) {// utilizo un condicional le digo que si resultado termina en 0.0 le decimos que sea 0.
									
			retorno = retorno.substring(0, retorno.length() - 2);	/* vamos a recortar el 0.0. utilizamos la clase
																	   substring para decirle que retorno
																	   vaya de 0 a la longitud de retorno -2. que le
																	   quitará dos caracteres. entonces cuando un
																   resultado acabe en 20.0 por ejemplo lo dejara en 20.*/
		}

		return retorno;
	}

	public String bloqueo() {
		String bloc = "";

		uno.setEnabled(false);
		dos.setEnabled(false);
		tres.setEnabled(false);
		cuatro.setEnabled(false);
		cinco.setEnabled(false);
		seis.setEnabled(false);
		siete.setEnabled(false);
		ocho.setEnabled(false);
		nueve.setEnabled(false);
		cero.setEnabled(false);
		igual.setEnabled(false);
		Par.setEnabled(false);

		return bloc;
	}

	public String desbloqueo() {
		String des = "";
		uno.setEnabled(true);
		dos.setEnabled(true);
		tres.setEnabled(true);
		cuatro.setEnabled(true);
		cinco.setEnabled(true);
		seis.setEnabled(true);
		siete.setEnabled(true);
		ocho.setEnabled(true);
		nueve.setEnabled(true);
		cero.setEnabled(true);
		igual.setEnabled(true);
		Par.setEnabled(true);

		return des;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora window = new Calculadora();
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
	public Calculadora() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBounds(100, 100, 550, 659);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		campo1 = new JTextField();
		campo1.setEditable(false);
		campo1.setBackground(Color.WHITE);
		campo1.setToolTipText("");
		campo1.setForeground(Color.BLACK);
		// campo1.setText("0");
		campo1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		campo1.setHorizontalAlignment(SwingConstants.RIGHT);
		campo1.setBounds(73, 33, 397, 60);
		frame.getContentPane().add(campo1);
		campo1.setColumns(10);

		C = new JButton("C");
		C.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				campo1.setText("");// para borrar
				desbloqueo();
				// campo1.setText("0");

			}
		});
		C.setFont(new Font("Tahoma", Font.PLAIN, 20));
		C.setBounds(85, 126, 61, 60);
		frame.getContentPane().add(C);

		Par = new JButton("Par");
		Par.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {

					contenidoCampo1 = campo1.getText().toString();
					num = Float.parseFloat(contenidoCampo1);
					if (num % 2 == 0) {
						campo1.setText("Par");
						bloqueo();
					} else {
						campo1.setText("Impar");
						bloqueo();
					}

				}

				catch (Exception e2) {
					campo1.equals("");
					campo1.setText("Error");
					bloqueo();
				}
			}
		});
		Par.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Par.setBounds(167, 126, 76, 60);
		frame.getContentPane().add(Par);

		uno = new JButton("1");
		uno.setForeground(Color.BLACK);
		uno.setFont(new Font("Tahoma", Font.PLAIN, 20));
		uno.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				campo1.setText(campo1.getText() + "1");// para capturar el num 1 en la caja le decimos 1 que en campo1
														// añada lo que picamos, si
														// queremos marcar varios 1, lo que hay que hacer es llamar lo
														// que hemos picado y lo concatenamos.
			}
		});
		uno.setBounds(85, 243, 55, 50);
		frame.getContentPane().add(uno);

		dos = new JButton("2");
		dos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		dos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				campo1.setText(campo1.getText() + "2");
			}
		});
		dos.setBounds(167, 243, 55, 50);
		frame.getContentPane().add(dos);

		tres = new JButton("3");
		tres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				campo1.setText(campo1.getText() + "3");
			}
		});
		tres.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tres.setBounds(246, 243, 55, 50);
		frame.getContentPane().add(tres);

		suma = new JButton("+");
		suma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					num1 = Float.parseFloat(campo1.getText());// num1 com es flotante lo paso a string momentaneamente
					operador = "+";// le asignamos el + a la variable operador
					campo1.setText("");// borramos el contenido del campo

				}

				catch (Exception e1) {
					campo1.equals("");
					campo1.setText("Error");
					bloqueo();
				}
			}
		});
		suma.setFont(new Font("Tahoma", Font.PLAIN, 20));
		suma.setBounds(440, 243, 55, 50);
		frame.getContentPane().add(suma);

		cuatro = new JButton("4");
		cuatro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				campo1.setText(campo1.getText() + "4");
			}
		});
		cuatro.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cuatro.setBounds(85, 342, 55, 50);
		frame.getContentPane().add(cuatro);

		cinco = new JButton("5");
		cinco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				campo1.setText(campo1.getText() + "5");
			}
		});
		cinco.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cinco.setBounds(167, 342, 55, 50);
		frame.getContentPane().add(cinco);

		seis = new JButton("6");
		seis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				campo1.setText(campo1.getText() + "6");
			}
		});
		seis.setFont(new Font("Tahoma", Font.PLAIN, 20));
		seis.setBounds(246, 342, 55, 50);
		frame.getContentPane().add(seis);

		resta = new JButton("-");
		resta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					num1 = Float.parseFloat(campo1.getText());// transformo num1 de flotante a string
					operador = "-";// asigno el operador
					campo1.setText("");// borro el contenido de la pantalla
				} catch (Exception e2) {
					campo1.equals("");
					campo1.setText("Error");
					bloqueo();
				}
			}
		});
		resta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		resta.setBounds(440, 342, 55, 50);
		frame.getContentPane().add(resta);

		siete = new JButton("7");
		siete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				campo1.setText(campo1.getText() + "7");
			}
		});
		siete.setFont(new Font("Tahoma", Font.PLAIN, 20));
		siete.setBounds(85, 440, 55, 50);
		frame.getContentPane().add(siete);

		ocho = new JButton("8");
		ocho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				campo1.setText(campo1.getText() + "8");
			}
		});
		ocho.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ocho.setBounds(167, 440, 55, 50);
		frame.getContentPane().add(ocho);

		nueve = new JButton("9");
		nueve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				campo1.setText(campo1.getText() + "9");
			}
		});
		nueve.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nueve.setBounds(246, 440, 55, 50);
		frame.getContentPane().add(nueve);

		multiplicar = new JButton("*");
		multiplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					num1 = Float.parseFloat(campo1.getText());// transformo num1 de flotante a string
					operador = "*";// asigno el operador
					campo1.setText("");// borro el contenido de la pantalla
				} catch (Exception e2) {
					campo1.equals("");
					campo1.setText("Error");
					bloqueo();
				}

			}
		});
		multiplicar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		multiplicar.setBounds(440, 440, 55, 50);
		frame.getContentPane().add(multiplicar);

		cero = new JButton("0");
		cero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				campo1.setText(campo1.getText() + "0");
			}
		});
		cero.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cero.setBounds(85, 538, 55, 50);
		frame.getContentPane().add(cero);

		igual = new JButton("=");
		igual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					num2 = Float.parseFloat(campo1.getText());// le decimos que el campo1 tiene el contenido del num2
																// para luego posteriormente picar al =
					/*
					 * catch (Exception e2) {
					 * 
					 * campo1.equals(""); campo1.setText("Error"); bloqueo();
					 * 
					 * }
					 */

					switch (operador) {// utilizamos un switch para analizar cada una de las operaciones que hay que
										// realizar.

					case "+":

						campo1.setText(sincero(num1 + num2));// en el caso de la + le decimos que muestre por pantalla
																// la
																// operacion de suma de num1 y num2
						bloqueo();

						break;

					case "-":
						campo1.setText(sincero(num1 - num2));
						bloqueo();
						break;

					case "*":
						campo1.setText(sincero(num1 * num2));// en el caso de la + le decimos que muestre por pantalla
																// la
																// operacion de suma de num1 y num2
						bloqueo();
						break;

					case "/":
						if (num2 == 0) {// utilizo un if para decirle que si el valor de num2 es 0 salga por pantalla el
										// siguiente mensaje.

							campo1.setText("Indeterminación");
							bloqueo();
						} else {

							campo1.setText(sincero(num1 / num2));// en el caso de la + le decimos que muestre por
																	// pantalla
																	// la operacion de suma de num1 y num2
							bloqueo();
						}

						break;
					}

				} catch (Exception e2) {

					campo1.equals("");
					campo1.setText("Error");
					bloqueo();

				}

			}

		});
		igual.setFont(new Font("Tahoma", Font.PLAIN, 20));
		igual.setBounds(167, 538, 132, 50);
		frame.getContentPane().add(igual);

		dividir = new JButton("/");
		dividir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					num1 = Float.parseFloat(campo1.getText());// transformo num1 de flotante a string
					operador = "/";// asigno el operador
					campo1.setText("");// borro el contenido de la pantalla
				} catch (Exception e2) {
					campo1.equals("");
					campo1.setText("Error");
					bloqueo();
				}
			}
		});
		dividir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		dividir.setBounds(440, 538, 55, 50);
		frame.getContentPane().add(dividir);
	}
}
