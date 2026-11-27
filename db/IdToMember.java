package db;

import models.Member;
import java.util.HashMap;

public class IdToMember {
   private HashMap<Integer, Member> map;

   public IdToMember() {
      map = new HashMap<>();
   }
   
   public Member getMember(int id) {
    return map.get(id);
   }

   public void setMember(int id, Member u) {
      map.put(id, u);
   }
}
