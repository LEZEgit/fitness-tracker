import java.util.ArrayList;

import models.FitnessGoal;
import models.Workout;

public class LoginUtils extends GymManager {
    ArrayList<Workout> history;

    public LoginUtils() {
        history = u2w.getWorkoutsByMemberId(currentUser.getId());
    }

    public void ViewProfile() {

    }

    public void UpdateFitnessGoals() {
        System.out.print("goal (\n\t0: CUT\n\t1:BULK\n\t2:MAINTAIN\n): ");
        int index = inputScanner.nextInt();
        FitnessGoal goal = FitnessGoal.values()[index];
        currentUser.setGoal(goal);
        System.out.println("Fitness Goal Updated!");
    }

    public void LogWorkout() {
        Workout workout;
        System.out.println("=====LOG WORKOUT=====");
        System.out.println();
        System.out.print("Exercise Name: ");
        String exerciseName = inputScanner.nextLine();
        inputScanner.nextLine();
        System.out.print("Duration (minutes): ");
        float duration = inputScanner.nextFloat();
        System.out.print("Calories Burned: ");
        float calsBurned = inputScanner.nextFloat();

        workout = new Workout(currentUser.getId(), exerciseName, duration, calsBurned);
        u2w.addWorkoutEntry(workout);
        System.out.println("Workout saved\n");
    }

    public void ViewWorkoutHistory() {
        System.out.println("=====WORKOUT HISTORY=====");
        System.out.println();
        System.out.println("ID\tExercise\tDuration\tCalories");
        for (Workout workout : history) {
            System.out.println(workout.toString());
        }
    }

    public void ViewProgressSummary() {
        int totalWorkouts = history.size();
        float totalWorkoutDuration = 0;
        float totalCaloriesBurned = 0;

        for (Workout workout : history) {
            totalWorkoutDuration += workout.getDuration();
            totalCaloriesBurned += workout.getCalories();
        }

        String progressSummary = """
                ========== PROGRESS SUMMARY ==========

                Member: %s

                Fitness Goal: %s
                Target Calories: %f kcal
                Target Protein: %f g

                Total Workouts: %d
                Total Workout Duration: %f minutes
                Total Calories Burned: %f kcal
                """.formatted(
                currentUser.getName(), currentUser.getGoal(), 1900, 1900,
                totalWorkouts, totalWorkoutDuration, totalCaloriesBurned);
        System.out.println(progressSummary);
    }

    public void Logout() {
        handleExit();
    }
}
