import java.util.*;
public class Wage
{
    public static void main(){
        Scanner scanner = new Scanner(System.in);
        int hourlyRate = 0;
        try{
            hourlyRate = input("How much do you earn per hour?", scanner);
        }catch(NumberFormatException e){
            System.out.println(" Error? input must be a number");
        }
        boolean temp = false;
        int hours = 0;
        int days = 0;
        do{
            try{
                hours = input("How many hours do you work per day?", scanner);
            }catch(NumberFormatException e){
                System.out.println(" Error? input must be a number");
                hours = 25;
            }
            if (hours<=24){temp = true;}
            else{
                System.out.println(" Error? input number must be between 0 and 24");
                temp = false;
            }
        }while(temp == false);
        do{
            try{
                days = input("How many days do you work per week?",scanner);
            }catch(NumberFormatException e){
                System.out.println(" Error? input must be a number");
                days = 8;
            }
            if (days<=7){temp = true;}
            else{
                System.out.println(" Error? input number must be between 0 and 7");
                temp = false;
            }
        }while(temp == false);
        System.out.println("1 week of wage (based on £"+hourlyRate+" per hour): £" + ((hourlyRate*hours)*days));
        System.out.println("1 month of wage (based on £"+hourlyRate+" per hour): £" + ((hourlyRate*hours)*days)*4);
        System.out.println("1 year of wage (based on £"+hourlyRate+" per hour): £" + (((hourlyRate*hours)*days)*4)*12);        
    }

    public static int input(String message, Scanner scanner){
        System.out.println(message);
        return Integer.parseInt(scanner.nextLine());
    }
}
