package DFSandBFS.GraphBFS;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 张驰
 * @Date: 2021/09/26/20:03
 * @Description: 三尺秋水尘不染
 */
/*
你现在手里有一份大小为N x N 的 网格 grid，上面的每个 单元格 都用0和1标记好了。
其中0代表海洋，1代表陆地，请你找出一个海洋单元格，
这个海洋单元格到离它最近的陆地单元格的距离是最大的。

        我们这里说的距离是「曼哈顿距离」（Manhattan Distance）：(x0, y0) 和(x1, y1)这两个单元格之间的距离是|x0 - x1| + |y0 - y1|。

        如果网格上只有陆地或者海洋，请返回-1。


        示例 1：

        输入：[[1,0,1],[0,0,0],[1,0,1]]
        输出：2
        解释：
        海洋单元格 (1, 1) 和所有陆地单元格之间的距离都达到最大，最大距离为 2。

        示例 2：

        输入：[[1,0,0],[0,0,0],[0,0,0]]
        输出：4
        解释：
        海洋单元格 (2, 2) 和所有陆地单元格之间的距离都达到最大，最大距离为 4。
 */
public class maxDistance {
    public static int maxDistance(int[][] grid) {
//                  左   右   下  上
        int[] dx = {0,   0,  -1,  1};
        int[] dy = {1,  -1,  0,  0};

        ArrayDeque<int[]> queue = new ArrayDeque<>();

        int m = grid.length, n = grid[0].length ;

        // 先把所有的陆地都入队。
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
             if(grid[i][j] == 1){
                 //拷贝防止丢失
                 queue.offer(new int[] {i,j});
             }
            }
        }
        // 从各个陆地开始，一圈一圈的遍历海洋，最后遍历到的海洋就是离陆地最远的海洋。
        boolean hasOcean = false;
        int[] point = null;

        while(!queue.isEmpty()){
            point = queue.poll();
            int x = point[0];
            int y = point[1];

                                                        System.out.println("出队元素为：X="+x+"Y="+y);  System.out.println();

            //上下左右便利  （扩散）
            for (int i = 0; i < 4; i++) {
                                                        System.out.println("扩散中:....");
                                                        System.out.println("0,1,2,3对应左   右   下  上");
                                                        System.out.println("第"+i+"次");
                                                        System.out.println();
               int newX = x + dx[i];
               int newY = y + dy[i];
               //边界情况 (越界或者  里面不是海洋）
                if(newX < 0 || newX >= m || newY < 0|| newY >= n || grid[newX][newY] != 0){
                    continue;
                }
                grid[newX][newY] = grid[x][y] + 1;
                hasOcean = true;
                queue.offer(new int[] {newX,newY});
                                                            System.out.println("如对元素为:"+newX+"和"+newY);
                                                            System.out.println("第 "+i+"次操作原数组为");
                                                            for (int[] data:grid
                                                                 ) {
                                                                System.out.println(Arrays.toString(data));
                                                            }
                                                            System.out.println();
                }
            }

    if(point == null || !hasOcean){
        return  -1;
    }
        System.out.println("队列中现在还有");
        System.out.println(point[0]+""+point[1]);

    return grid[point[0]][point[1]] - 1;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,0,1},
                        {0,0,0},
                        {1,0,1}};

        System.out.println(maxDistance(grid));
    }
}
