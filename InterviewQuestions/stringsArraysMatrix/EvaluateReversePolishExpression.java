package interviewQuestions;

import java.util.Stack;

/*
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation. 
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression. For example:

  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */

public class EvaluateReversePolishExpression {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] tokens={"4", "13", "5", "/", "+"};
		try {
			System.out.println(evalRPN(tokens));
		} catch (InvalidOperatorException e) {
			e.printStackTrace();
		}
	}

	private static int evalRPN(String[] tokens) throws InvalidOperatorException{
		if(tokens.length==0){
			return 0;
		}
		String operators="+-*/";
		Stack<String> s=new Stack<String>();
		int sum=0;
		for(int i=0; i<tokens.length; i++){
			if(!operators.contains(tokens[i])){
				s.push(tokens[i]);
			}
			else{
				//if(s.size()>=2){
					if(tokens[i]=="+"){
						sum=Integer.parseInt((String) s.pop())+Integer.parseInt((String) s.pop());
						s.push(String.valueOf(sum));
						continue;
					}
					else if(tokens[i]=="-"){
						sum=Integer.parseInt((String) s.pop())-Integer.parseInt((String) s.pop());
						s.push(String.valueOf(sum));
						continue;
					}
					else if(tokens[i]=="*"){
						sum=Integer.parseInt((String) s.pop())*Integer.parseInt((String) s.pop());
						s.push(String.valueOf(sum));
						continue;
					}
					else if(tokens[i]=="/"){
						String temp=(String) s.pop();
						sum=Integer.parseInt((String) s.pop())/Integer.parseInt(temp);
						s.push(String.valueOf(sum));
						continue;
					}
					else{
						throw new InvalidOperatorException("operator is invalid");
					}
				/*}
				else{
					throw new InvalidOperatorException("two few operands");
				}*/
			}
		}
		return sum;
	}

}
