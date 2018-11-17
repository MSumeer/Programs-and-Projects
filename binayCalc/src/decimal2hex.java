import javax.swing.*;
import java.util.ArrayList;

public class decimal2hex {
    public static void main(String[] args){
        long decimal = 0;
        long leftOver;
        ArrayList<Long> noHex = new ArrayList<>();
        ArrayList<String> hex = new ArrayList<>();
        int counter = 0;
        try{decimal = Integer.parseInt(JOptionPane.showInputDialog("enter decimal to convert to hex")); }
        catch(NumberFormatException e){
            System.out.println("Number Format Exception");
            System.exit(0);
        }
        while(decimal>=1) {
            leftOver = decimal % 16;
            decimal = decimal / 16;
            noHex.add(counter,leftOver);
            counter+=1;
        }
        int size = noHex.size()-1;
        counter = 0;
        for(int i = size;i>-1;i--){

            if(noHex.get(i)==10){
                hex.add(counter,"A");
            }else if(noHex.get(i)==11){
                hex.add(counter,"B");
            }else if(noHex.get(i)==12){
                hex.add(counter,"C");
            }else if(noHex.get(i)==13){
                hex.add(counter,"D");
            }else if(noHex.get(i)==14){
                hex.add(counter,"E");
            }else if(noHex.get(i)==15){
                hex.add(counter,"F");
            }else{
                hex.add(counter,Long.toString(noHex.get(i)));
            }
            System.out.print(hex.get(counter));
        }

    }
}
