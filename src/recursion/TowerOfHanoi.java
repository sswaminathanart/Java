package recursion;

public class TowerOfHanoi {
    public static void main(String[] args){
        String from = "Rod1";
        String to = "Rod2";
        String helper = "Rod3";
        int no_of_rings = 3;
        steps_in_tower_of_hanoi_helper(no_of_rings,"Rod1","Rod3","Rod2");
    }
    public static void steps_in_tower_of_hanoi_helper(int no_of_rings,
                                                      String from,
                                                      String to,
                                                      String helper){
        if(no_of_rings <=0) return;
        steps_in_tower_of_hanoi_helper(no_of_rings-1,from,helper,to);
        System.out.println("Move Disk "+ no_of_rings + " from " +from +" to " +to );
        steps_in_tower_of_hanoi_helper(no_of_rings-1,helper,to,from);
    }
}
