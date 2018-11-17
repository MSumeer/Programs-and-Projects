import javax.swing.*;

public class hex2decimal {
    public static void main(String args[]){
        int counter = 0;
        String in = JOptionPane.showInputDialog("enter HEX to convert to Decimal");
        final int lengthHalf = in.length()/2;
        final int length = in.length();
        Record[] recArr = new Record[lengthHalf];
        String[] split =  in.split("(?!^)");
        for(int i = 0; i<length;i++){
            recArr[i] = new Record();
            try {
                setFirst(recArr[i],Integer.parseInt(split[counter]));
            }catch(NumberFormatException e){
                setFirst2(split[counter],record);
                setFirst2(recArr[i],A);
            }
            counter++;
            setSeccond(recArr[i],in.charAt(counter));

        }



    }
    private static void setFirst2(String a,Record record){
        if(a.equalsIgnoreCase("A")){
            record.first = 10;
        }else if(a.equalsIgnoreCase("B")){
            record.first = 11;
        }else if(a.equalsIgnoreCase("C")){
            record.first = 12;
        }else if(a.equalsIgnoreCase("C")){
            record.first = 13;
        }else if(a.equalsIgnoreCase("D")){
            record.first = 14;
        }else if(a.equalsIgnoreCase("E")){
            record.first = 15;
        }else if(a.equalsIgnoreCase("F")){
            record.first= 16;
        }else{
            System.out.println("Not a sutable hexadecimal valur");
            System.exit(0);
        }

    }
    private static void setFirst(Record record,int a){
        record.first = a;
    }
    private static void setSeccond(Record record, int a){
        record.seccond = a;
    }
}
class Record{
   int first;
   int seccond;
   int firstBin;
   int SeccondBin;
   int decimal;
}
