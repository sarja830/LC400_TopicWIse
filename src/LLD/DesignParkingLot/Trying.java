package LLD.DesignParkingLot;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class Trying {
    static class ParkingSpot
    {
        String id;
        String date;

        String c;

        public ParkingSpot(String id, String date, String c) {
            this.id = id;
            this.date = date;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof ParkingSpot that)) return false;
            return Objects.equals(id, that.id) && Objects.equals(date, that.date);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, date);
        }
    }


    public static void main(String[] args) {

        ParkingSpot a = new ParkingSpot("1","12","ab");
        ParkingSpot b = new ParkingSpot("1","12","ab");
        HashSet<ParkingSpot> set =  new HashSet<>();
        set.add(a);
        boolean c = set.contains(b);
        boolean flag = a.equals(b);
       int a1 = a.hashCode();
        int b1 = b.hashCode();

    }
}
