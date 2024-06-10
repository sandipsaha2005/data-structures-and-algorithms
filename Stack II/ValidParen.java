import java.util.Stack;

public class ValidParen {
    public static boolean equals(String str) {
        Stack<Character> stack = new Stack<>();
        if (str.length() == 1) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
                stack.push(currentChar);
            } else if (currentChar == ')' || currentChar == '}' || currentChar == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.peek();
                if ((top == '(' && currentChar == ')') ||
                        (top == '{' && currentChar == '}') ||
                        (top == '[' && currentChar == ']')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static boolean dupliParentheses(String str){
        Stack<Character> stk=new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch=str.charAt(i);
            if(ch==')'){
                int count=0;
                while(!stk.isEmpty() && stk.peek()!='('){
                    stk.pop();
                    count++;
                }
                if(count<1){
                    return true;
                }else{
                    stk.pop();
                }
            }else{
                stk.push(ch);
            }

        }
        return false;
    }
//    public static int maxArea(int arr[]) {
//        int start = 0;
//        int end = arr.length - 1;
//        int area = 0;
//
//        while (start < end) {
//            int currArea = (Math.min(arr[start], arr[end]) * (end - start));
//            System.out.println(end-start);
//
//            area = Math.max(area, currArea);
//
//            if (arr[start] < arr[end]) {
//                start++;
//            } else {
//                end--;
//            }
//        }
//        return area;
//    }
//    public static int maxArea(int arr[]){
//        int max=0;
//        int nsr[]=new int[arr.length];
//        Stack<Integer> s=new Stack<>();
//        for(int i=arr.length-1;i>=0;i--){
//            while (!s.isEmpty() && arr[i]<=arr[s.peek()]){
//                s.pop();
//            }
//            if(s.isEmpty()){
//                nsr[i]=arr.length;
//            }else{
//                nsr[i]=s.peek();
//            }
//            s.push(i);
//        }
//        int nsl[]=new int[arr.length];
//        s=new Stack<>();
//        for(int i=0;i<arr.length;i++){
//            while (!s.isEmpty() && arr[i]<=arr[s.peek()]){
//                s.pop();
//            }
//            if(s.isEmpty()){
//                nsl[i]=-1;
//            }else{
//                nsl[i]=s.peek();
//            }
//            s.push(i);
//        }
//        for (int i = 0; i < arr.length; i++) {
//            int area=arr[i] * (nsr[i]-nsl[i]-1);
//            max=Math.max(area,max);
//        }
//        return max;
//    }

    public static int maxArea(int arr[]){
        int max=0;
        int nsr[]=new int[arr.length];
        Stack<Integer> s=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while (!s.isEmpty() && arr[i]<=arr[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i]=arr.length;
            }else{
                nsr[i]=s.peek();
            }
            s.push(i);
        }

        int nsl[]=new int[arr.length];
        s=new Stack<>();
        for(int i=0;i<arr.length;i++){
            while (!s.isEmpty() && arr[i]<=arr[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i]=-1;
            }else{
                nsl[i]=s.peek();
            }
            s.push(i);
        }
        for (int i = 0; i < arr.length; i++) {
            int area=arr[i] * (nsr[i]-nsl[i]-1);
            max=Math.max(area,max);
        }
        return max;
    }
    public static void main(String args[]){
//        String str="[])";
//        String str1="(a+(a+b))";
//        if(dupliParentheses(str1)){
//            System.out.println("There is duplicate parentheses");
//        }else{
//            System.out.println("There is no duplicate parentheses");
//        }
//        if(equals(str)){
//            System.out.println("Parentheses is matched");
//        }else {
//            System.out.println("Parentheses is not matched");
//        }
//        int arr[]={2,4};
        int arr[]={2,1,5,6,2,3};
//        int arr[]={1,2,1};
        System.out.println(maxArea(arr));
    }
}
