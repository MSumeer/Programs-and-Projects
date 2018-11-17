import java.util.Scanner;

public class ex1 {

    public static void main(String[] args){
        int max = 0;
        char character = '+';
        boolean dashes = false;
        int counter = 1;
        try{
            System.out.println("input maximum number of squares");
            max = input();
            System.out.println("Input the character");
            character = input2();
            dashes = input3();
        }catch(Exception e){
            System.out.println("Error");
            System.exit(0);
        }
        for(int i = 0;i<max;i++){
            for(int p = 0;p<counter;p++) {
                for (int h = 0; h < counter; h++) {
                    System.out.print(character);
                }
                System.out.print("\n");
            }
            counter++;
        }
        if(dashes){
            for(int i = 0; i<max*2;i++){
                System.out.print("-");
            }
            System.out.print("\n");
        }
        for(int i = max;i>=1;i--){
            for(int p = counter;p>1;p--){
                    for(int h = counter;h>1;h--) {
                        System.out.print(character);
                    }
                    System.out.print("\n");
            }

            counter--;
        }
        System.exit(0);
    }
    private static int input(){
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());

    }
    private static char input2(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().charAt(0);

    }
    private static boolean input3(){
        boolean a = false;
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if(input.equals("Yes")||input.equals("yes")||input.equals("y")){
            a = true;
        }
        return a;
    }
}
