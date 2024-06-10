import com.sun.security.jgss.GSSUtil;

import javax.lang.model.element.NestingKind;
import  java.util.*;
public  class S {

	public static void pushBotton(Stack<Integer> s,int data) {
		if(s.isEmpty()){
			s.push(data);
			return;
		}
		int top=s.pop();
		pushBotton(s,data);
		s.push(top);
	}
	public  static  String rev(Stack<Character> s,StringBuilder sc) {
		for(int i=0;i<sc.length();i++){
			s.push(sc.charAt(i));
		}
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<sc.length();i++){
			sb.append(s.peek());
			s.pop();
		}
		return  sb.toString();
	}
	public  static void revStk(Stack<Integer> s){
		if(s.isEmpty()){
			return;
		}
		int top=s.pop();
		revStk(s);
		pushBotton(s,top);
	}
	public  static void print(Stack<Integer> s){
		while (!s.isEmpty()){
			System.out.print(s.pop() +" ");
		}
	}
	public  static  void main(String args[]){

//		Stack<Character> s=new Stack<>();  // we can create this stack in the function. It's up to U.
//		StringBuilder s1=new StringBuilder("sandip");
//		String newStr=rev(s,s1);
//		System.out.println(newStr);

//		Stack<Integer> s=new Stack<>();
//		s.push(2);
//		s.push(3);
//		s.push(5);
////		while (!s.isEmpty()){
////			System.out.print(s.peek());
////			s.pop();
////		}
////		System.out.println();
//		pushBotton(s,10);
//		while (!s.isEmpty()){
//			System.out.print(s.peek() +" ");
//			s.pop();
//		}

		Stack<Integer> stk=new Stack<>();
		stk.push(1);
		stk.push(2);
		stk.push(3);

		revStk(stk);
		print(stk);
	}
}
