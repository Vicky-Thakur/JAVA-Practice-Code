package com.practice;

import java.util.Scanner;
import java.util.Stack;

public class ValidateParenthesis {
	
	public boolean checkForBalance(String str){
		Stack<Character> st = new Stack<Character>();
		int i = 0,strlength = str.length();
		while(i<strlength){
			if(str.charAt(i) == '{' || str.charAt(i) == '[' || str.charAt(i) == '(')
				st.push(str.charAt(i));
			else{
				char ch = st.pop();
				if(str.charAt(i) == '}' && ch == '{'
						|| (str.charAt(i) == ')' && ch == '(')
						|| (str.charAt(i) == ']' && ch == '[')){
				}else
					return false;
			}
			i++;
		}
		if(st.empty())
			return true;
		return false;
	}

	public static void main(String[] args) {
		System.out.println("Enter String to check parenthesis: ");
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		scan.close();
		ValidateParenthesis obj = new ValidateParenthesis();
		System.out.println(obj.checkForBalance(str));
	}
}
