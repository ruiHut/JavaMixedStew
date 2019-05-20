package swordToOffer.basicKnowledge;


/*
    机器人的运动范围
    n * m 方格
 */
public class q_13 {
    public static void main(String[] args) {

    }

    private int movingCount(int threshold, int rows, int cols) {
        if (threshold < 0 || rows <= 0 || cols <= 0)
            throw new IllegalArgumentException("Illegal args!");

        boolean[] visited = new boolean[rows * cols];
        for (int i = 0; i < rows * cols; i++)
            visited[i] = false;

        return movingCountCore(threshold, rows, cols, 0, 0, visited);
    }

    private int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        int count = 0;
        if (check(threshold, rows, cols, row, col, visited)) {
            visited[row * cols + col] = true;

            count = 1 + movingCountCore(threshold, rows, cols,
                        row - 1, col, visited)
                    + movingCountCore(threshold, rows, cols,
                        row, col - 1, visited)
                    + movingCountCore(threshold, rows, cols,
                        row + 1, col, visited)
                    + movingCountCore(threshold, rows, cols,
                        row, col + 1, visited);
        }

        return count;
    }

    private boolean check(int threshold, int rows, int cols, int row, int col, boolean[] visited) {

        if (row >= 0 && row < rows && col >= 0 && col < cols
                && getDigitSum(row) + getDigitSum(col) <= threshold
                && !visited[row * cols + col])
            return true;

        return false;

    }

    private int getDigitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }
}
