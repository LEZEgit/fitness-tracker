import java.util.Scanner;

import db.*;
import models.FitnessGoal;
import models.Member;


class GymManager {
    protected IdToMember i2U;
    protected MemberToWorkouts u2w;
    Scanner inputScanner;

    public GymManager(Scanner sc) {
        i2U = new IdToMember();
        u2w = new MemberToWorkouts();
        System.out.println("Initialising...");
        inputScanner = sc;
    }

    void handleAppEntry(int choice) {
        switch (choice) {
            case 1:
                handleRegisterMember();
                break;
            case 2:
                handleLogin();
                break;
            case 3:
                handleExit();
                break;
            default:
                break;
        }
    }

    private void handleExit() {
        System.out.println("Thanks for using Fittrack :)\nExiting...");
        return;
    }

    private void handleLogin() {
        System.out.println("=====Login=====");
        System.out.print("Memeber Id: ");
        
    }

    private void handleRegisterMember() {
        System.out.println("=====New Member Registration=====");
        System.out.print("name: ");
        inputScanner.nextLine();
        String name = inputScanner.nextLine();
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