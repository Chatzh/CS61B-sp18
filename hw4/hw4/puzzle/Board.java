package hw4.puzzle;

import edu.princeton.cs.algs4.Queue;

public class Board implements WorldState {
    private final int[][] grid;
    private final int size;

    public Board(int[][] tiles) {
        grid = new int[tiles.length][tiles.length];
        size = grid.length;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = tiles[i][j];
            }
        }
    }

    public int tileAt(int i, int j) {
        if (!isValidIndex(i, j)) {
            throw new java.lang.IndexOutOfBoundsException("Index out of Bound.");
        }

        return grid[i][j];
    }

    public int size() {
        return size;
    }

    /**
     * Returns neighbors of this board.
     * SPOILERZ: This is the answer.
     *
     * From http://joshh.ug/neighbors.html
     * @author josh hug
     */
    @Override
    public Iterable<WorldState> neighbors() {
        Queue<WorldState> neighbors = new Queue<>();
        int hug = size();
        int bug = -1;
        int zug = -1;

        for (int rug = 0; rug < hug; rug++) {
            for (int tug = 0; tug < hug; tug++) {
                if (tileAt(rug, tug) == 0) {
                    bug = rug;
                    zug = tug;
                }
            }
        }

        int[][] ili1li1 = new int[hug][hug];

        for (int pug = 0; pug < hug; pug++) {
            for (int yug = 0; yug < hug; yug++) {
                ili1li1[pug][yug] = tileAt(pug, yug);
            }
        }

        for (int l11il = 0; l11il < hug; l11il++) {
            for (int lil1il1 = 0; lil1il1 < hug; lil1il1++) {
                if (Math.abs(-bug + l11il) + Math.abs(lil1il1 - zug) - 1 == 0) {
                    ili1li1[bug][zug] = ili1li1[l11il][lil1il1];
                    ili1li1[l11il][lil1il1] = 0;
                    Board neighbor = new Board(ili1li1);
                    neighbors.enqueue(neighbor);
                    ili1li1[l11il][lil1il1] = ili1li1[bug][zug];
                    ili1li1[bug][zug] = 0;
                }
            }
        }

        return neighbors;
    }

    public int hamming() {
        int count = 0;
        int goalNumber = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int currNumber = tileAt(i, j);
                goalNumber++;

                if (currNumber != 0 && currNumber != goalNumber) {
                    count++;
                }
            }
        }

        return count;
    }

    public int manhattan() {
        int sum = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int currNumber = tileAt(i, j);

                if (currNumber != 0) {
                    int correctRow = (currNumber - 1) / size;
                    int correctCol = Math.floorMod(currNumber - 1, size);
                    sum += Math.abs(correctRow - i) + Math.abs(correctCol - j);
                }
            }
        }

        return sum;
    }

    @Override
    public int estimatedDistanceToGoal() {
        return manhattan();
    }

    @Override
    public boolean equals(Object y) {
        if (this == y) {
            return true;
        }

        if (y == null || getClass() != y.getClass()) {
            return false;
        }

        Board o = (Board) y;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (tileAt(i, j) != o.tileAt(i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    /** Returns the string representation of the board. 
      * Uncomment this method. */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        int N = size();
        s.append(N + "\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                s.append(String.format("%2d ", tileAt(i, j)));
            }
            s.append("\n");
        }
        s.append("\n");
        return s.toString();
    }

    private boolean isValidIndex(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }
}
