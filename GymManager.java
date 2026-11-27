import java.util.ArrayList;
import java.util.Scanner;

import db.*;
import models.FitnessGoal;
import models.Member;


class GymManager {
    protected IdToMember i2U;
    protected MemberToWorkouts u2w;
    protected ArrayList<Member> onlineUsers;
    protected Member currentUser;
    Scanner inputScanner;

    public GymManager() {
        i2U = new IdToMember();
        u2w = new MemberToWorkouts();
        System.out.println("Initialising...");
        inputScanner = new Scanner(System.in);
        onlineUsers = new ArrayList<>();
    }

    String handleAppEntry(int choice) {
        switch (choice) {
            case 1:
                handleRegisterMember();
                return "Reg";
            case 2:
                handleLogin();
                return "Login";
            case 3:
                handleExit();
                return "Exit";
            default:
                return "Default";
        }
    }

    private void handleExit() {
        System.out.println("\nLogging you out");
        // TODO: Feel like we need another Session class
        // I am thinking of one user per thread, we need to remove the user in Session object running at current thread.
        // Leaving it here for now, as closing the program will empty the onlineUsers finally
        // onlineUsers.remove(onlineUsers.indexOf())
        System.out.println("Thanks for using Fittrack :)\nExiting...");
        return;
    }

    private void handleLogin() {
        System.out.println("=====Login=====");
        System.out.print("Member Id: ");
        int id = inputScanner.nextInt();
        Member currentUser = i2U.getMember(id);
        if (currentUser == null) {
            System.out.println("\n\nMembership not found!");
            return;
        }
        onlineUsers.add(currentUser);
        System.out.println("Logged in successfully");
        
    }

    private void handleRegisterMember() {
        System.out.println("=====New Member Registration=====");
        System.out.print("name: ");
        String name = inputScanner.nextLine();
        inputScanner.nextLine();
        System.out.print("age: ");
        int age = inputScanner.nextInt();
        System.out.print("weight_kg: ");
        float weight_kg = inputScanner.nextFloat();
        System.out.print("height_cm: ");
        float height_cm = inputScanner.nextFloat();
        System.out.print("goal (\n\t0: CUT\n\t1:BULK\n\t2:MAINTAIN): ");
        int index = inputScanner.nextInt();
        FitnessGoal goal= FitnessGoal.values()[index];      
        System.out.print("dailyTargetCalories: ");
        float dailyTargetCalories = inputScanner.nextFloat();
        System.out.print("dailyTargetProtein: ");
        float dailyTargetProtein = inputScanner.nextFloat();

        Member m = new Member(name, age, weight_kg, height_cm, goal, dailyTargetCalories, dailyTargetProtein);

        i2U.setMember(m.getId(), m);

        System.out.println("\nNew Member: "+ i2U.getMember(m.getId()).getName() +" added successfully");
        return;
    }

}