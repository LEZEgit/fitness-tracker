package models;

public class Workout {
    public static int count=0;
    int workoutId;
    int memberId;
    String exerciseName;
    float duration_min;
    float calories_burned;
    // String date;

    public Workout(
        int memberId,
        String exerciseName,
        float duration_min,
        float calories_burned
        ) {
            count++;
            this.workoutId = count;
            this.memberId = memberId;
            this.exerciseName = exerciseName;
            this.duration_min = duration_min;
            this.calories_burned = calories_burned;
        }

    public int getMemberId() {
        return memberId;
    }
    public float getDuration() {
        return duration_min;
    }
    public float getCalories() {
        return calories_burned;
    }

    @Override 
    public String toString() {
        String res;
        res = workoutId + "\t" + exerciseName + "\t" + duration_min + "\t" + calories_burned; 
        return res;
    }
}