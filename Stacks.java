class Stack
{
    int top = 0;
    int capacity = 2;
    int stack[] = new int[capacity];
    public void push(int data){
        if(top==stack.length){
            expand();
        }
        stack[top] = data;
        top++;

    }

    private void expand(){
        capacity*=2;
        int[] oStack = new int[capacity];
        System.arraycopy(stack,0,oStack,0,size());
        stack = oStack;
    }

    public int peak(){
        return stack[top-1];
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is empty " + isEmpty());
        }else{
            top--;
            int a = stack[top];
            stack[top] = 0;
            if(top-1<=capacity/2){
                shrink();
            }
            return a;
        }
        return 0;
    }

    public void shrink(){
        capacity/=2;
        int[] oStack = new int[capacity];
        System.arraycopy(stack,0,oStack,0,size());
        stack = oStack;
    }

    public void show(){
        for(int a:stack){
            System.out.print(a+" ");
        }
        System.out.println();
    }

    public int size(){
        return top;
    }

    public boolean isEmpty(){
        if (size()>0){
            return false;
        }
        return true;
    }
}
public class Stacks{
    public static void main(){
        Stack stack = new Stack();

        stack.push(10);
        stack.push(25);
        stack.push(10);
        stack.show();
        stack.pop();
        stack.show();
    }

}