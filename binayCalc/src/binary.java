import javax.swing.*;

public class binary {

    public static void main(String[] args) {

        int[] a = new int[17];
        int in = 0;
        in = input(in);
        convert(a,in);

    }
    private static int input(int in){
        try {
            in = Integer.parseInt(JOptionPane.showInputDialog("Input number to convert to binary"));
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException");
        }
        return in;
    }
    private static void convert(int[] a, int in){
        boolean start;
        int counter = 0;
        for (int i = 0; i < a.length; i++) {
           a[i] = in%2;
            in = in/2;
            if(a[i] == 1||in>0){
                start = true;
            }else{start = false;}
            if(start) {
                counter++;
            }
        }
        for(int i = counter-1;i>=0;i--){
            System.out.print(a[i]);
        }
    }
}
