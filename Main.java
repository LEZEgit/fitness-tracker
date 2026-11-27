import java.util.Scanner;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        GymManager gm = new GymManager(sc);
        System.out.println("=====FitTrack=====");
        System.out.println("\n1. Register new member\n2. Login\n3. Exit\n\nEnter your choice: ");
        // TODO: try-catch
        int choice = sc.nextInt();
        gm.handleAppEntry(choice);




        sc.close();
    }
}