import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;
@SuppressWarnings("serial")
public class GUI extends JFrame
{
	public GUI() 
	{
		this.setVisible(true);
		this.setSize(860,620);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("PostFix Calculator");
		
		
		JPanel panel = new JPanel(new GridBagLayout());
		panel.setBackground(Color.decode("#E6F0ff"));
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		
		JLabel inputLabel = new JLabel("Input: ");
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(inputLabel,gbc);

		JTextField inputField = new JTextField(20);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		panel.add(inputField,gbc);
		
		JLabel outputLabel = new JLabel("Output: ");
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		panel.add(outputLabel,gbc);
		
		JTextArea outputField = new JTextArea(5,20);
		outputField.setEditable(false);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		panel.add(outputField,gbc);

		JButton submitButton = new JButton("Calculate");
		submitButton.setBackground(Color.blue);
		submitButton.setForeground(Color.white);
		submitButton.setFont(new Font("Arial",Font.BOLD,14));
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		
		panel.add(submitButton,gbc);
		
		submitButton.addActionListener(e -> submitButtonOnClick(inputField, outputField));
		
		JButton convertButton = new JButton("Convert from postfix");
		convertButton.setBackground(Color.blue);
		convertButton.setForeground(Color.white);
		convertButton.setFont(new Font("Arial",Font.BOLD,14));
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		panel.add(convertButton,gbc);
		
		convertButton.addActionListener(e->ConvertButtonOnClick(inputField,outputField));
		
		this.getContentPane().add(panel);
		
		setVisible(true);
		
		
	}

	private void ConvertButtonOnClick(JTextField inputField,JTextArea outputField) {
		String userInput = inputField.getText();
		if (utilFunctions.isPostfix(userInput)) 
		{
			TreeNode root = utilFunctions.constructExpressionTree(userInput);
			String result = utilFunctions.convertFromPostFix(root);
			outputField.setText(result);
		}
		else {
			outputField.setText("Invalid postfix");
		}
	}

	
	private void submitButtonOnClick(JTextField inputField,JTextArea outputField) 
	{ 
		String userInput = inputField.getText();
		if (utilFunctions.isPostfix(userInput)) 
		{
			Main.setPostfix(userInput);
			outputField.setText("" + utilFunctions.calculatePostFix(Main.getPostfix()));
			
		}
		else {
			outputField.setText("Invalid Postfix expression!");
		}
	}

}
