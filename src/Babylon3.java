public class Babylon3 {

    public static void main(String[] args) {


        String[] strings = new String[]{
                "7",
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


    static int zombieCluster(String[] zombies) {

        int N = Integer.parseInt(zombies[0]);

        int[][] M = new int [N][N];
        for(int i = 0; i<N; i++) {
            for (int j = 0 ; j<N; j++) {
                M[i][j] = Integer.parseInt(zombies[i + 1].charAt(j) + "");
            }
        }

        boolean visited[] = new boolean[N];
        boolean visiting[] = new boolean[N];

        int count = 0;
        for (int i = 0; i < N; ++i) {
            if(!visited[i]) {
                visiting[i] = true;
                DFS(M, N, visited, visiting, i);
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
            for(int j = 0; j < N; j++) {
                if(M[s][j] == 1 && !visiting[j]) {
                    visiting[j] = true;
                    DFS(M, N, visited, visiting, j);
                    visited[j] = true;
                }
            }
        }
    }
}