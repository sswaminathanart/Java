import java.util.Comparator;
import java.util.PriorityQueue;

public class GraphRainWater {
    public class Cell implements Comparable<Cell> {
        int row;
        int col;
        int height;
        public Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
        @Override
        public int compareTo(Cell other){
            return Integer.compare(this.height,other.height);
        }

    }

    public int trapRainWater(int[][] heights) {
        if (heights == null || heights.length == 0 || heights[0].length == 0)
            return 0;

        PriorityQueue<Cell> queue = new PriorityQueue<>();
        int row = heights.length;
        int col = heights[0].length;
        boolean[][] visited = new boolean[row][col];

        // Initially, add all the Cells which are on borders to the queue.
        for (int i = 0; i < row; i++) {
            visited[i][0] = true;
            visited[i][col - 1] = true;
            queue.offer(new Cell(i, 0, heights[i][0]));
            queue.offer(new Cell(i, col - 1, heights[i][col - 1]));
        }

        for (int i = 0; i < col; i++) {
            visited[0][i] = true;
            visited[row - 1][i] = true;
            queue.offer(new Cell(0, i, heights[0][i]));
            queue.offer(new Cell(row - 1, i, heights[row - 1][i]));
        }

        // from the borders, pick the shortest cell visited and check its neighbors:
        // if the neighbor is shorter, collect the water it can trap and update its height as its height plus the water trapped
        // add all its neighbors to the queue.
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int res = 0;
        while (!queue.isEmpty()) {
            Cell cell = queue.poll();
            for (int[] dir : dirs) {
                int row1= cell.row + dir[0];
                int col1 = cell.col + dir[1];
                if (row1 >= 0 && row1 < row && col1 >= 0 && col1 < col && !visited[row1][col1]) {
                    visited[row1][col1] = true;
                    res += Math.max(0, cell.height - heights[row1][col1]);
                    queue.offer(new Cell(row1, col1, Math.max(heights[row1][col1], cell.height)));
                }
            }
        }

        return res;
    }
}
