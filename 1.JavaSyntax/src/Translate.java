public class Translate {
    public static void main(String[] args)
     throws java.io.IOException{
        char choice;
        int count = 0;

        do {
            choice = (char) System.in.read();
            if (choice == '.') break;
            if ((int) choice >= 65 & (int) choice <=90) {

               int choice2 = (int) choice + 32;
               choice = (char) choice2;
               count++;
                System.out.println(choice + " " + count);

            } else if ((int) choice >= 97 & (int) choice <=122) {

                int choice3 = (int) choice - 32;
                choice = (char) choice3;
                count++;
                System.out.println(choice + " " + count);
            }

        } while (true);


    }
}
