public class Planet {
    public double xxPos, yyPos, xxVel, yyVel, mass;
    public String imgFileName;
    private static double G = 6.67E-11d;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        this(p.xxPos, p.yyPos, p.xxVel, p.yyVel, p.mass, p.imgFileName);
    }

    public double calcDistance(Planet other) {
        double dx = other.xxPos - this.xxPos,
               dy = other.yyPos - this.yyPos;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double calcForceExertedBy(Planet other) {
        double r = this.calcDistance(other),
               m1 = this.mass,
               m2 = other.mass;
        return G * m1 * m2 / (r * r);
    }

    public double calcForceExertedByX(Planet other) {
        double F = this.calcForceExertedBy(other),
               dx = other.xxPos - this.xxPos,
               r = this.calcDistance(other);
        return F * dx / r;
    }

    public double calcForceExertedByY(Planet other) {
        double F = this.calcForceExertedBy(other),
               dy = other.yyPos - this.yyPos,
               r = this.calcDistance(other);
        return F * dy / r;
    }

    public double calcNetForceExertedByX(Planet[] all) {
        double force = 0d;
        for (Planet other : all) {
            if (!this.equals(other)) {
                force += this.calcForceExertedByX(other);
            }
        }
        return force;
    }

    public double calcNetForceExertedByY(Planet[] all) {
        double force = 0d;
        for (Planet other : all) {
            if (!this.equals(other)) {
                force += this.calcForceExertedByY(other);
            }
        }
        return force;
    }

    public void update(double dt, double fX, double fY) {
        double aX = fX / this.mass,
               aY = fY / this.mass;
        this.xxVel += dt * aX;
        this.yyVel += dt * aY;
        this.xxPos += dt * xxVel;
        this.yyPos += dt * yyVel;
    }

    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
    }
}