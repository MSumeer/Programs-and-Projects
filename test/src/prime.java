public class prime {
    public static void main(String args[]) {
        int counter = 2;
        int sqrot = 0;
        int divide = 3;
        boolean done;
        while (counter <= 1000) {
            if (counter == 2 || counter == 3 || counter == 5 || counter == 7) {
                System.out.print(" " + counter + " ");
            } else if (counter > 10) {
                if (!(counter % 2 == 0)) {
                    System.out.println("counter: " + counter);
                    done = false;
                    sqrot = (int) Math.sqrt(counter);
                    while (!done) {
                        if (!(counter % divide == 0)) {
                            divide = divide + 2;
                            if (divide > sqrot) {
                                System.out.println(" " + counter + " ");
                                done = true;
                                divide = 3;
                            }
                        }
                    }
                }
            }
            counter++;
        }
    }
}
