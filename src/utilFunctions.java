import java.util.Stack;

public class utilFunctions 
{

	
	public static TreeNode constructExpressionTree(String postfixExpression) 
		{
			Stack<TreeNode> stack = new Stack<>();
			for (String token : postfixExpression.split(" ")) 
			{
				if (isOperand(token)) 
				{
					stack.push(new TreeNode(token));
				}
				else {
					TreeNode rightNode = stack.pop();
					TreeNode leftNode = stack.pop();			
					TreeNode operatorNode = new TreeNode(token);
					operatorNode.left = leftNode;
					operatorNode.right = rightNode;
					stack.push(operatorNode);
				}
			}
			return stack.pop();
		}
		
	
	public static double evaluateExpressionTree(TreeNode root) 
		{
			if (root == null) 
			{
				return 0;
			}
			if(isOperand(root.value)) 
			{
				return Integer.valueOf(root.value);
				
			}
			
			double leftValue = evaluateExpressionTree(root.left);
			double rightValue = evaluateExpressionTree(root.right);
			
			return performOperation(root.value, leftValue, rightValue);
		}
	

	public static double performOperation(String operator, double operand1, double operand2) 
			{
				switch (operator) {
				
				case "+":
					return operand1 + operand2;
				
				case "-":
					return operand1 - operand2;
				
				case "*":
					return operand1*operand2;
				case "/":
					if (operand2 !=0 ) 
					{
						return operand1 / operand2;
					} 
					else {
						throw new ArithmeticException("Division by zero!");
						
					}
				
				default:
					throw new IllegalArgumentException("Invalid operation!");
				}
			}
	

	public static double calculatePostFix(String postfix) 
		{
			TreeNode Root = constructExpressionTree(postfix);
			double Result = evaluateExpressionTree(Root);
			return Result;
		}
	
	
	public static boolean isOperand(String token) 
		{
			return token.matches("[0-9]+");
		}
	
	
	public static boolean isOperator(String token) 
	{
		return token.matches("[+-/*]");
	}
	
	
	public static boolean isPostfix(String postfix) 
	{
		boolean result = true;
		for (String token : postfix.split(" ")) 
		{
			if (!isOperand(token) && !isOperator(token)) 
			{
				result = false;
			}
			
		}
		return result;
	}
	
	public static String convertFromPostFix(TreeNode node) 
	{
		String result = "";
		if (node == null) 
		{
			return "";
		}
		String leftValue = convertFromPostFix(node.left);
		String rightValue = convertFromPostFix(node.right);
		result += leftValue + node.value + rightValue ;
		if (result.contains("+") || result.contains("*") || result.contains("/") || result.contains("-")) 
		{
			result = "(" + result + ")";
		}
		return result ;

	}
}
