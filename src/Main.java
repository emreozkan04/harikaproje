import javax.swing.SwingUtilities;
public class Main 
{
	public static String postfixExpression;
	public static double result;
	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(GUI::new);

	}

	
	public static String getPostfix() 
	{
		return postfixExpression;
	}

	public static double getResult() 
	{
		return result;
	}

	 public static void setPostfix(String text) 
	 {
		 postfixExpression = text;
	 }
}
