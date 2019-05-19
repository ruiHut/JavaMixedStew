package swordToOffer.basicKnowledge;

// 矩阵中的路径
public class q_12 {
    public static void main(String[] args) {
        // TODO 照抄原书 有待测试
    }

    private static boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        // TODO java 中 char 类型是否存在 null 状态？
        if (rows < 1 || cols < 1) {
            return false;
        }

        boolean[] visited = new boolean[rows * cols];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        int pathLength = 0;
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                if (hasPathCore(matrix, rows, cols, row, col, str, pathLength, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col, char[] str, int pathLength, boolean[] visited) {
        if (str[pathLength] == '\0')
            return true;

        boolean hasPath = false;
        if (row >= 0 && row < rows && col >= 0 && col < cols
                && matrix[row * cols + col] == str[pathLength]
                && !visited[row * cols + col]) {
            pathLength++;
            visited[row * cols + col] = true;

            hasPath = hasPathCore(matrix, rows, cols, row, col - 1,
                    str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row - 1, col,
                    str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row + 1, col,
                    str, pathLength, visited);

            if (!hasPath) {
                --pathLength;
                visited[row * cols + col] = false;
            }
        }

        return hasPath;
    }
}
