import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame implements ActionListener{

	JTextField inputField;
	JTextField resultField;
	JPanel scientificPanel;
	JPanel standardPanel;
    JPanel displayPanel;
	
	ImageIcon image;
	String operator;
	String sciOperator;
	double num1, num2, result;

	JButton[] numberButtons = new JButton[10];
	JButton[] scientificButtons = new JButton[24];
	JButton[] functionButtons = new JButton[10];

	JButton addButton, subButton, multButton, divButton,
		negButton, clrButton,delButton, decButton,
		 equButton, ansButton;

	JButton sinButton, cosButton, tanButton, sinhButton, coshButton,
		tanhButton, modButton, logButton, logXButton, sqrtButton,
		cbrtButton, powButton, binaryButton, radButton, degButton,
		sqrButton, cubeButton, rndButton, cielButton, floorButton,
		piButton, expoButton, percButton, absButton;

	Font inputFont = new Font("ariel", Font.BOLD, 20);
	Font resultFont = new Font("courier new", Font.BOLD, 20);

	Calculator(){

		this.setTitle("Scientific Calculator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(550,800);
		this.getContentPane().setBackground(new Color(0x123456));
        this.setLayout(null);
		this.setResizable(false);

		addButton = new JButton("+");
		subButton = new JButton("-");
		multButton = new JButton("x");
		divButton = new JButton("/");
		negButton = new JButton("+-");
		clrButton = new JButton("CE");
		delButton = new JButton("DEL");
		decButton = new JButton(".");
		equButton = new JButton("=");
		ansButton = new JButton("Ans");

		functionButtons[0] = delButton;
		functionButtons[1] = clrButton;
		functionButtons[2] = multButton;
		functionButtons[3] = divButton;
		functionButtons[4] = addButton;
		functionButtons[5] = subButton;
		functionButtons[6] = decButton;
		functionButtons[7] = negButton;
		functionButtons[8] = ansButton;
		functionButtons[9] = equButton;

		for(int i = 0; i < functionButtons.length; i++){
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(new Font("Comic sans", Font.BOLD, 20));
			functionButtons[i].setFocusable(false);
			functionButtons[i].setForeground(Color.WHITE);
			if(i == 0 || i == 1)
				functionButtons[i].setBackground(Color.RED);
			else
				functionButtons[i].setBackground(new Color(0x999966));
		}

		for(int i = 0; i < numberButtons.length; i++){
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(new Font("Comic sans", Font.BOLD, 20));
			numberButtons[i].setFocusable(false);
			numberButtons[i].setBackground(new Color(0x737373));
			numberButtons[i].setForeground(Color.WHITE);
		}
/**********************EVERYTHING RELATED TO SCIENTIFIC PANEL AND SCIENTIFIC BUTTONS******************************/
		sinButton =  new JButton("sin")
		cosButton = new JButton("cos");
		tanButton = new JButton("tan");
		sinhButton = new JButton("sinh");
		coshButton = new JButton("cosh");
		tanhButton = new JButton("tanh");
		sqrtButton = new JButton("sqrt");
		cbrtButton = new JButton("cbrt");
		sqrButton = new JButton("x^2");
		cubeButton = new JButton("x^3");
		powButton = new JButton("x^y");
		binaryButton = new JButton("B-2");
		radButton = new JButton("RAD");
		degButton = new JButton("DEG");
		logButton = new JButton("log10");
		logXButton = new JButton("logX");
		piButton = new JButton("PI");
		expoButton = new JButton("EXP");
		floorButton = new JButton("RD");
		cielButton = new JButton("RU");
		rndButton = new JButton("RND");
		modButton = new JButton("mod");
		percButton = new JButton("%");
		absButton = new JButton("abs");

		scientificButtons[0] = sinButton;
		scientificButtons[1] = cosButton;
		scientificButtons[2] = tanButton;
		scientificButtons[3] = sinhButton;
		scientificButtons[4] = coshButton;
		scientificButtons[5] = tanhButton;
		scientificButtons[6] = sqrtButton;
		scientificButtons[7] = cbrtButton;
		scientificButtons[8] = sqrButton;
		scientificButtons[9] = cubeButton;
		scientificButtons[10] = powButton;
		scientificButtons[11] = binaryButton;
		scientificButtons[12] = radButton;
		scientificButtons[13] = degButton;
		scientificButtons[14] = logButton;
		scientificButtons[15] = logXButton;
		scientificButtons[16] = piButton;
		scientificButtons[17] = expoButton;
		scientificButtons[18] = floorButton;
		scientificButtons[19] = cielButton;
		scientificButtons[20] = rndButton;
		scientificButtons[21] = modButton;
		scientificButtons[22] = percButton;
		scientificButtons[23] = absButton;

		resultField = new JTextField();
		resultField.setFont(resultFont);
		resultField.setEditable(false);
		resultField.setForeground(Color.BLACK);
		resultField.setBounds(10, 10, 514, 65);
		resultField.setBackground(Color.GRAY);
		resultField.setVisible(true);

		inputField = new JTextField();
		inputField.setEditable(false);
		inputField.setForeground(Color.BLACK);
		inputField.setFont(inputFont);
		inputField.setBounds(10, 73, 514, 70);
		inputField.setBackground(Color.GRAY);
		inputField.setVisible(true);

		/*-------------------------------ScientificPanel ---------------------------------------*/
		scientificPanel = new JPanel();
		scientificPanel.setBounds(10, 160, 514, 255);
		scientificPanel.setLayout(new GridLayout(4, 6, 5, 5));

		for(int i = 0; i < scientificButtons.length; i++){
			scientificButtons[i].setFocusable(false);
			if((i == 11) || (i == 12) || (i == 13))
				scientificButtons[i].setBackground(new Color(0xff8000));
			else if((i == 0) || (i == 1) || (i == 2) || (i == 3) || (i == 4) || (i == 5))
				scientificButtons[i].setBackground(Color.BLACK);
			else
				scientificButtons[i].setBackground(new Color(0x666633));
			scientificButtons[i].setForeground(Color.WHITE);
			scientificButtons[i].setFont(new Font("ariel", Font.TRUETYPE_FONT, 18));
			scientificButtons[i].addActionListener(this);
			scientificPanel.add(scientificButtons[i]);
		}
		scientificPanel.setBackground(new Color(0x123456));

/*********************************************STANDARD PANEL**********************************************/
		standardPanel = new JPanel();
		standardPanel.setBounds(10, 432, 514, 320);
		standardPanel.setLayout(new GridLayout(4, 5));

		standardPanel.add(numberButtons[7]);//first row
		standardPanel.add(numberButtons[8]);
		standardPanel.add(numberButtons[9]);
		standardPanel.add(functionButtons[0]);
		standardPanel.add(functionButtons[1]);
		standardPanel.add(numberButtons[4]);//second row
		standardPanel.add(numberButtons[5]);
		standardPanel.add(numberButtons[6]);
		standardPanel.add(functionButtons[2]);
		standardPanel.add(functionButtons[3]);
		standardPanel.add(numberButtons[1]);//third row
		standardPanel.add(numberButtons[2]);
		standardPanel.add(numberButtons[3]);
		standardPanel.add(functionButtons[4]);
		standardPanel.add(functionButtons[5]);
		standardPanel.add(numberButtons[0]);//fourth row
		standardPanel.add(functionButtons[6]);
		standardPanel.add(functionButtons[7]);
		standardPanel.add(functionButtons[8]);
		standardPanel.add(functionButtons[9]);
		standardPanel.setBackground(new Color(0x123456));

		image = new ImageIcon("calcpics.png");
		this.setIconImage(image.getImage());
		// this.setIconImage(
		// 	new ImageIcon("calcpics.png")
		// 	.getImage()
		// )
		this.add(scientificPanel);
		this.add(standardPanel);
        this.add(resultField);
		this.add(inputField);
		this.setVisible(true);

	}

/*****************************************ACTION PERFORMED METHOD********************************************/
	@Override
	public void actionPerformed(ActionEvent e) {

		for(int i = 0; i < numberButtons.length; i++){
			if(e.getSource() == numberButtons[i]){
				inputField.setText(inputField.getText().concat(String.valueOf(i)));
			}
		}

		if(e.getSource() == decButton){
			inputField.setText(inputField.getText().concat("."));
		}

		/////////////////////////////////////////MODULUS AND PERCENT BUTTON///////////////////////////////////////////
		if(e.getSource() == modButton){
			num1 = Double.parseDouble(inputField.getText());
			operator = "mod";
			resultField.setText(resultField.getText().concat(num1 + String.valueOf(operator)));
			inputField.setText("");
		}
		if(e.getSource() == percButton){
			num1 = Double.parseDouble(inputField.getText());
			sciOperator = "%";
			resultField.setText(resultField.getText().concat(num1 + String.valueOf(sciOperator)));
			double temp = num1 / 100;
			inputField.setText(String.valueOf(temp));
		}

		////////////////////////////POWER BUTTON///////////////////////////////////////////////
		if(e.getSource() == powButton){
			num1 = Double.parseDouble(inputField.getText());
			operator = "^";
			resultField.setText(resultField.getText().concat(num1 + String.valueOf(operator)));
			inputField.setText("");
		}

		/////////////////////ADD, SUBTRACT, MULTIPLY AND DIVIDE BUTTONS//////////////////////////////
		if(e.getSource() == addButton){
			num1 = Double.parseDouble(inputField.getText());
			operator = "+";
			resultField.setText(
				resultField.getText()
				.concat(num1 + String.valueOf(operator))
				);
			inputField.setText("");
		}
		if(e.getSource() == subButton){
			num1 = Double.parseDouble(inputField.getText());
			operator = "-";
			resultField.setText(resultField.getText().concat(num1 + String.valueOf(operator)));
			inputField.setText("");
		}
		if(e.getSource() == multButton){
			num1 = Double.parseDouble(inputField.getText());
			operator = "x";
			resultField.setText(resultField.getText().concat(num1 + String.valueOf(operator)));
			inputField.setText("");
		}
		if(e.getSource() == divButton){
			num1 = Double.parseDouble(inputField.getText());
			operator = "/";
			resultField.setText(resultField.getText().concat(num1 + String.valueOf(operator)));
			inputField.setText("");
		}

		///////////////////////////////////////TRIGONONMETRIC BUTTONS/////////////////////////////////////////

		if(e.getSource() == sinButton){
			num1 = Double.parseDouble(inputField.getText());
			sciOperator = "sin";
			resultField.setText(resultField.getText().concat(sciOperator + "(" + num1 + "\"" + ")"));
			inputField.setText(String.valueOf(Math.sin(num1)));
		}
		if(e.getSource() == cosButton){
			num1 = Double.parseDouble(inputField.getText());
			sciOperator = "cos";
			resultField.setText(resultField.getText().concat(sciOperator + "(" + num1 + "\"" + ")"));
			inputField.setText(String.valueOf(Math.cos(num1)));
		}
		if(e.getSource() == tanButton){
			num1 = Double.parseDouble(inputField.getText());
			sciOperator = "tan";
			resultField.setText(resultField.getText().concat(sciOperator + "(" + num1 + "\"" + ")"));
			inputField.setText(String.valueOf(Math.tan(num1)));
		}
		if(e.getSource() == sinhButton){
			num1 = Double.parseDouble(inputField.getText());
			sciOperator = "sinh";
			resultField.setText(resultField.getText().concat(sciOperator + "(" + num1 + "\"" + ")"));
			inputField.setText(String.valueOf(Math.toDegrees(Math.sinh(num1))));
		}
		if(e.getSource() == coshButton){
			num1 = Double.parseDouble(inputField.getText());
			sciOperator = "cosh";
			resultField.setText(resultField.getText().concat(sciOperator + "(" + num1 + "\"" + ")"));
			inputField.setText(String.valueOf(Math.toDegrees(Math.cosh(num1))));
		}
		if(e.getSource() == tanhButton){
			num1 = Double.parseDouble(inputField.getText());
			sciOperator = "tanh";
			resultField.setText(resultField.getText().concat(sciOperator + "(" + num1 + "\"" + ")"));
			inputField.setText(String.valueOf(Math.toDegrees(Math.tan(num1))));
		}

		///////////////////////////////////////SQUARE ROOT, CUBE ROOT, SQUARE AND CUBE BUTTONS//////////////////////////
		if(e.getSource() == sqrtButton){
			num1 = Double.parseDouble(inputField.getText());
			sciOperator = "sqrt";
			resultField.setText(resultField.getText().concat(sciOperator + "(" + num1 + "\"" + ")"));
			inputField.setText(String.valueOf(Math.sqrt(num1)));
		}
		if(e.getSource() == cbrtButton){
			num1 = Double.parseDouble(inputField.getText());
			sciOperator = "cbrt";
			resultField.setText(resultField.getText().concat(sciOperator + "(" + num1 + "\"" + ")"));
			inputField.setText(String.valueOf(Math.cbrt(num1)));
		}
		if(e.getSource() == sqrButton){
			num1 = Double.parseDouble(inputField.getText());
			sciOperator = "sqr";
			resultField.setText(resultField.getText().concat(sciOperator + "(" + num1 + "\"" + ")"));
			double temp = num1 * num1;
			inputField.setText(String.valueOf(temp));
		}
		if(e.getSource() == cubeButton){
			num1 = Double.parseDouble(inputField.getText());
			sciOperator = "cube";
			resultField.setText(resultField.getText().concat(sciOperator + "(" + num1 + "\"" + ")"));
			double temp = num1 * num1 * num1;
			inputField.setText(String.valueOf(temp));
		}

		////////////////////////////////////ALL THE APPROXIMATING OPERATIONS////////////////////////////////////////////
		if(e.getSource() == floorButton){
			num1 = Double.parseDouble(inputField.getText());
			sciOperator = "roundDown";
			resultField.setText(resultField.getText().concat(sciOperator + "(" + num1 + "\"" + ")"));
			inputField.setText(String.valueOf(Math.floor(num1)));
		}
		if(e.getSource() == cielButton){
			num1 = Double.parseDouble(inputField.getText());
			sciOperator = "roundUp";
			resultField.setText(resultField.getText().concat(sciOperator + "(" + num1 + "\"" + ")"));
			inputField.setText(String.valueOf(Math.ceil(num1)));
		}
		if(e.getSource() == rndButton){
			num1 = Double.parseDouble(inputField.getText());
			sciOperator = "Approx";
			resultField.setText(resultField.getText().concat(sciOperator + "(" + num1 + "\"" + ")"));
			inputField.setText(String.valueOf(Math.round(num1)));
		}

		/////////////////////////////CLEAR, DELETE AND NEGATIVE BUTTON/////////////////////////////////////////////////

		if(e.getSource() == clrButton){
			inputField.setText("");
			resultField.setText("");
		}
		if(e.getSource() == delButton){
			String temp = inputField.getText();
			//resultField.setText("");
			inputField.setText("");
			for(int i = 0; i < temp.length() - 1; i++){
				inputField.setText(inputField.getText() + temp.charAt(i));
			}
		}
		if(e.getSource() == negButton){
			double temp = Double.parseDouble(inputField.getText());
			temp *= -1;
			inputField.setText(String.valueOf(temp));
		}

		//////////////////////////////////////LOGARITHM BUTTONS AND THEIR OPERATIONS IMPLEMENTATIONS//////////////////////////////////

		if(e.getSource() == logXButton){
			num1 = Double.parseDouble(inputField.getText());
			sciOperator = "log";
			resultField.setText(resultField.getText().concat(sciOperator + "(" + num1 + ")"));
			inputField.setText(String.valueOf(Math.log(num1)));
		}
		if(e.getSource() == logButton){
			num1 = Double.parseDouble(inputField.getText());
			sciOperator = "log10";
			resultField.setText(resultField.getText().concat(sciOperator + "(" + num1 + ")"));
			inputField.setText(String.valueOf(Math.log10(num1)));
		}

		/////////////////////////////////////////////THE BINARY, RADIAN AND DEGREE BUTTONS///////////////////////////////////////////////////

		if(e.getSource() == binaryButton){
			num1 = Double.parseDouble(inputField.getText());
			sciOperator = "baseTwo";
			resultField.setText(
				resultField.getText()
				.concat(sciOperator + "(" + num1 + ")")
				);
			inputField.setText(Integer.toString((int)num1, 2));
		}
		if(e.getSource() == radButton){
			num1 = Double.parseDouble(inputField.getText());
			sciOperator = "RAD";
			resultField.setText(
				resultField.getText()
				.concat(sciOperator + "(" + num1 + ")")
				);
			inputField.setText(String.valueOf(Math.toRadians(num1)));
		}
		if(e.getSource() == degButton){
			num1 = Double.parseDouble(inputField.getText());
			sciOperator = "DEG";
			resultField.setText(
				resultField.getText()
				.concat(sciOperator + "(" + num1 + ")")
				);
			inputField.setText(String.valueOf(Math.toDegrees(num1)));
		}

		////////////////////////////////////////PI, EXPONENT AND ABSOLUTE VALUE BUTTONS///////////////////////////////////////////////

		if(e.getSource() == piButton){
			sciOperator = "PI";
			inputField.setText(inputField.getText().concat(String.valueOf(Math.PI)));
		}
		if(e.getSource() == expoButton){
			sciOperator = "EXP";
			inputField.setText(
				inputField.getText()
				.concat(String.valueOf(Math.E))
			);
		}
		if(e.getSource() == absButton){
			num1 = Double.parseDouble(inputField.getText());
			operator = "abs";
			resultField.setText(
				resultField.getText()
				.concat(operator + "(" + num1 + ")")
			);
		}

		//////////////////////////////ANSWER BUTTON///////////////////////////

		if(e.getSource() == ansButton){
			resultField.setText(
				resultField.getText()
				.concat("Ans:" + String.valueOf(result))
			);
		}

		//Solve method

		///////////////////////////////THE EQUALS BUTTON///////////////////////////////////
		if(e.getSource() == equButton){
			solveCalculations();
		}
		
	}

	public void solveCalculations(){
		num2 = Double.parseDouble(inputField.getText());
		inputField.setText(String.valueOf(num2));

			switch(operator){
				case "+":
					result = num1 + num2;
					break;
				case "-":
					result = num1 - num2;
					break;
				case "x":
					result = num1 * num2;
					break;
				case "/":
					if(num2 == 0){
						result = Double.NaN;
					}
					result = num1 / num2;
					break;
				case "mod":
					result = num1 % num2;
					break;
				case "^":
					result = Math.pow(num1, num2);
					break;
				case "abs":
					result = Math.abs(num1);
					break;
			}
		num1 = result;
		inputField.setText(String.valueOf(result));
		resultField.setText("");
	}
	//////////////////////////THE MAIN FUNCTION/////////////////////////////////////////////////////////
	public static void main(String... args){
		new Calculator();
	}

}