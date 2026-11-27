package db;

import java.util.ArrayList;
import java.util.HashMap;

import models.Workout;

public class MemberToWorkouts {
   HashMap<Integer, ArrayList<Workout> > workoutEntries;

   public void addWorkoutEntry(Workout entry) {
      workoutEntries.get(entry.getMemberId()).add(entry);
   }

   public ArrayList<Workout> getWorkoutsByMemberId(int memberId) {
      return workoutEntries.get(memberId);
   }
}
