package db;

import java.util.ArrayList;
import java.util.HashMap;

import models.MemberToWorkout;
import models.Workout;

public class MemberToWorkouts {
   HashMap<Integer, ArrayList<Workout> > workoutEntries;

   private void addWorkoutEntry(MemberToWorkout entry) {
      workoutEntries.get(entry.getId()).add(entry.getWorkout());
   }
}
