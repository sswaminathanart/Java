public class GraphZombie {
    static int zombieCluster(String[] zombies) {
        int len = zombies.length;
        int[][] Mat=new int[len][len];
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                Mat[i][j] = Integer.parseInt(zombies[i].charAt(j)+"");
            }
        }
        int count = 0;
        boolean[] visited = new boolean[len];
        boolean[] visiting = new boolean[len];
        for(int i=0;i<len;i++){
            if(!visited[i]) {
                visiting[i] = true;
                DFS(Mat, len, visited, visiting, i);
                visited[i] = true;
                count++;
            }
        }
        return count;

    }
    public static void DFS(int[][] Mat,int len,boolean[] visited,boolean[] visiting,int row){
        if(!visited[row]){
            visiting[row] = true;
            for(int j=0;j<len;j++){
                if(Mat[row][j] ==1 && !visiting[j] ){
                    visiting[j] = true;
                    DFS(Mat,len,visited,visiting,j);
                    visited[j] = true;
                }
            }
        }
    }
    public static void main(String args[]){
        String[] strings = new String[]{
                "1100001",
                "1110001",
                "0110001",
                "0001100",
                "0001100",
                "0000010",
                "0010001"

        };

        int count = zombieCluster(strings);
        System.out.println(count);
    }
}
