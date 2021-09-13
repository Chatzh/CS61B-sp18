package byog.Core;

import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

public class MapGenerator {
    private static int WIDTH,
                       HEIGHT;
    private double random;

    private static Random rand;
    TETile[][] world;

    private class Position {
        int x,
            y;

        Position(int xx, int yy) {
            x = xx;
            y = yy;
        }

        /** Go to next horizontal point (x+1, y), if touch the @param xBound,
         *  go to next line (0, y+1), reset x = 0.
         */
        public void nextPosition(int xBound, int yBound) {
            if (x < xBound) {
                x++;
            } else if (y < yBound) {
                x = 0;
                y++;
            }
        }

        /** if this position's tile equals to @param tile, return true, otherwise return false. */
        public boolean equals(TETile tile) {
            return world[x][y].equals(tile);
        }
    }

    MapGenerator(int width, int height, long seed) {
        WIDTH = width;
        HEIGHT = height;
        rand = new Random(seed);
        world = new TETile[WIDTH][HEIGHT];
        random = rand.nextInt(70) / 10000d + 0.001;

        initializeWorld();
        roomGenerator();
        hallwayGenerator();
    }

    /** Initialize the world fill with Tileset.NOTHING. */
    private void initializeWorld() {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                world[x][y] = Tileset.NOTHING;
            }
        }
    }

    /** Randomly generate some rooms, surrounded by wall. */
    private void roomGenerator() {
        Position pos = new Position(0, 0);

        while (pos.y < HEIGHT - 3) {
            int width = rand.nextInt(WIDTH / 8) + 4,
                height = rand.nextInt(HEIGHT / 8) + 4;

            if (rand.nextDouble() < random) {
                Position newPos = new Position(pos.x + 1, pos.y + 1);

                roomAdder(pos, width, height, 0, Tileset.NOTHING, Tileset.WALL);
                roomAdder(newPos, width - 2, height - 2, 1, Tileset.WALL, Tileset.FLOOR);
            }

            pos.nextPosition(WIDTH - 3, HEIGHT);
        }
    }

    /** Randomly generate some hallways, surround by wall. */
    private void hallwayGenerator() {
        Position pos = new Position(0, 0);

        while (pos.y < HEIGHT - 3) {
            int width = rand.nextInt(WIDTH) + 5,
                height = rand.nextInt(HEIGHT) + 5;

            if (rand.nextDouble() < 0.009 - random) {
                Position newPos = new Position(pos.x + 1, pos.y + 1);

                roomAdder(pos, 3, height, 0, Tileset.NOTHING, Tileset.WALL);
                roomAdder(newPos, 1, height - 2, 1, Tileset.WALL, Tileset.FLOOR);
                roomAdder(pos, width, 3, 0, Tileset.NOTHING, Tileset.WALL);
                roomAdder(newPos, width - 2, 1, 1, Tileset.WALL, Tileset.FLOOR);
            }

            pos.nextPosition(WIDTH - 3, HEIGHT);
        }
    }

    /** Put a room at @param pos position with width @param w and height @param h,
     *  fill with @param tile.
     */
    private void roomAdder(Position pos,
                           int width, int height, int restrict, TETile under, TETile tile) {
        for (int x = 0; x < width && pos.x + x < WIDTH - restrict; x++) {
            for (int y = 0; y < height && pos.y + y < HEIGHT - restrict; y++) {
                Position newPos = new Position(pos.x + x, pos.y + y);
                if (newPos.equals(under)) {
                    world[pos.x + x][pos.y + y] = tile;
                }
            }
        }
    }
}
