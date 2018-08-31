public class Zombies {
    static int zombieCluster(String[] zombies) {
        int[][] intzombies = new int[zombies.length][zombies[0].length()];
        for(int i=0;i<zombies.length;i++){
            for(int j=0;j<zombies[i].length();j++){
                intzombies[i][j] = Integer.parseInt(zombies[i].charAt(j) + "");
            }
        }
        int N = zombies.length;
        boolean visited[] = new boolean[N];
        boolean visiting[] = new boolean[N];

        int count = 0;
        for (int i = 0; i < N; ++i) {
            if(!visited[i]) {
                visiting[i] = true;
                DFS(intzombies, N, visited, visiting, i);
                visited[i] = true;
                count++;
            }
        }
        return count;
    }

    static void DFS(int M[][], int N, boolean visited[], boolean[] visiting, int s)
    {
        if( !visited[s] ) {
            visiting[s] = true;
            for(int j = s+1; j < N; j++) {
                if(M[s][j] == 1 && !visited[j]) {
                    visiting[j] = true;
                    DFS(M, N, visited, visiting, j);
                    visited[j] = true;
                }
            }
        }
    }
    public static void main(String[] args){
        String [] s= {
                "1000001000",
                "0100010001",
                "0010100000",
                "0001000000",
                "0010100000",
                "0100010000",
                "1000001000",
                "0000000100",
                "0000000010",
                "0100000001"
        };
        int o =zombieCluster(s);
        System.out.println(o);
    }
}
