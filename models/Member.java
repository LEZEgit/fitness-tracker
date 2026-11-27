package models;


public class Member {
    public static int count=0;
    int memberID;
    String name;
    int age;
    float weight_kg;
    float height_cm;
    FitnessGoal goal;
    float dailyTargetCalories;
    float dailyTargetProtein;

    public Member(
        String name,
        int age,
        float weight_kg,
        float height_cm,
        FitnessGoal goal,
        float dailyTargetCalories,
        float dailyTargetProtein
    ) {
        count++;
        this.memberID = count;
        this.name = name;
        this.age = age;
        this.weight_kg = weight_kg;
        this.height_cm = height_cm;
        this.goal = goal;
        this.dailyTargetCalories = dailyTargetCalories;
        this.dailyTargetProtein = dailyTargetProtein;
    }

    public int getId() {
        return memberID;
    }
    public String getName() {
        return name;
    }
}
