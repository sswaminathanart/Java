public class TowerAniProblem {
    public static void tower(char from,char to,char helper,int i,int disk){
        if(i> disk){
            return;
        }
        System.out.println("Move Disk "+i +" from "+ from + " to "+ to);
        tower(from,helper,to,i+1,disk);
        tower(helper,to,from,i+1,disk);
    }
    public static void main(String args[]){
        tower('A','B','C',1,3);
    }
}
