package hw4.puzzle;

import edu.princeton.cs.algs4.MinPQ;

import java.util.ArrayDeque;

public class Solver {
    private SearchNode ans;
    private ArrayDeque<WorldState> sequence = new ArrayDeque<>();

    public Solver(WorldState initial) {
        MinPQ<SearchNode> moveSequence = new MinPQ<>();
        SearchNode init = new SearchNode(initial, 0, null);
        moveSequence.insert(init);

        while (!moveSequence.isEmpty()) {
            SearchNode bms = moveSequence.delMin();    //best move sequence

            if (bms.estimatedDistanceToGoal == 0) {
                ans = bms;
                while (ans.prev != null) {
                    sequence.push(ans.world);
                    ans = ans.prev;
                }
                sequence.push(ans.world);
                return;
            }

            for (WorldState neighbor : bms.world.neighbors()) {
                if (bms.prev != null && neighbor.equals(bms.prev.world)) {
                    continue;
                }

                SearchNode nms = new SearchNode(neighbor, bms.distance + 1, bms);
                moveSequence.insert(nms);
            }
        }
    }

    public int moves() {
        return sequence.size() - 1;
    }

    public Iterable<WorldState> solution() {
        return sequence;
    }

    private class SearchNode implements Comparable<SearchNode> {
        final WorldState world;
        final int distance;
        final SearchNode prev;
        final int estimatedDistanceToGoal;

        public SearchNode(WorldState w, int d, SearchNode p) {
            world = w;
            distance = d;
            prev = p;
            estimatedDistanceToGoal = world.estimatedDistanceToGoal();
        }

        @Override
        public int compareTo(SearchNode o) {
            return distance + estimatedDistanceToGoal
                    - (o.distance + o.world.estimatedDistanceToGoal());
        }
    }
}
