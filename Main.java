import java.util.Scanner;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        GymManager gm = new GymManager();
        int choice;
        do {
            System.out.println("=====FitTrack=====");
            System.out.println("\n1. Register new member\n2. Login\n3. Exit\n\nEnter your choice: ");
            // TODO: try-catch
            choice = sc.nextInt();
            // handle new user registration
            if (choice == 1) gm.handleAppEntry(choice);
        } while (choice == 1); 

        // handle login or exit
        if (gm.handleAppEntry(choice).equals("Exit")) {
            sc.close();
            return;
        }

        sc.close();
    }
}