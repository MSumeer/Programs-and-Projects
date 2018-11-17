import java.util.Scanner;

public class ex12016 {
    public static void main(String[] args) {
        int w = 0;
        int h = 0;
        boolean iseven = false;
        System.out.println("Specify width");
        try {
            w = input();
            System.out.println("Specify height");
            h = input();
        } catch (NumberFormatException e) {
            System.out.println("Error");
            System.exit(0);
        }
        for (int i = 0; i < h; i++) {
            for (int p = 0; p < w; p++) {
                if (iseven) {
                    System.out.print("*");
                } else {
                    System.out.print("=");
                }
            }
            if (iseven) {
                iseven = false;
            } else {
                iseven = true;
            }
            System.out.print("\n");
        }
        System.exit(0);
    }

    private static int input() {
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }
}
