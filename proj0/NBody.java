public class NBody {

    public static double readRadius(String filename) {
        In file = new In(filename);

        int n = file.readInt();
        return file.readDouble();
    }

    public static Planet[] readPlanets(String filename) {
        In file = new In(filename);

        int n = file.readInt();
        double r = file.readDouble();

        Planet[] all = new Planet[n];
        for (int i = 0; i < all.length; i++) {
            double xP = file.readDouble(),
                   yP = file.readDouble(),
                   xV = file.readDouble(),
                   yV = file.readDouble(),
                   m = file.readDouble();
            String img = file.readString();
            all[i] = new Planet(xP, yP, xV, yV, m, img);
        }
        return all;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]),
               dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);

        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        StdDraw.picture(0, 0, "images/starfield.jpg");

        for (Planet planet : planets) {
            planet.draw();
        }

        StdDraw.enableDoubleBuffering();

        for (double time = 0; time < T; time += dt) {
            double[] xForces = new double[planets.length],
                     yForces = new double[planets.length];

            for (int i = 0; i < planets.length; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            for (int i = 0; i < planets.length; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }
            
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (Planet planet : planets) {
                planet.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
        }

        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }
}