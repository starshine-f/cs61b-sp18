public class Planet {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	private static final double G = 6.67e-11; 

	/** Two planet constructors */
	public Planet(double xP, double yP, double xV, 
				double yV, double m, String img) {
		this.xxPos = xP;
		this.yyPos = yP;
		this.xxVel = xV;
		this.yyVel = yV;
		this.mass = m;
		this.imgFileName = img;
	}

	/** The second constructor should take in a Planet object 
	 * and initialize an identical Planet object*/
	public Planet(Planet p) {
		this.xxPos = p.xxPos;
		this.yyPos = p.yyPos;
		this.xxVel = p.xxVel;
		this.yyVel = p.yyVel;
		this.mass = p.mass;
		this.imgFileName = p.imgFileName;
	}

	/** Calculate the distance bewteen two planets */
	public double calcDistance(Planet p) {
		double dx = this.xxPos - p.xxPos;
		double dy = this.yyPos - p.yyPos;
		return Math.sqrt(dx * dx + dy * dy);
	}

	/** Calculate the force exerted by others */
	public double calcForceExertedBy(Planet p) {
		double distance = this.calcDistance(p);
		return G * this.mass * p.mass / (distance * distance);
	}

	public double calcForceExertedByX(Planet p) {
		double total_F = this.calcForceExertedBy(p);
		double distance = this.calcDistance(p);
		double dx = p.xxPos - this.xxPos;
		return total_F * dx / distance;
	}

	public double calcForceExertedByY(Planet p) {
		double total_F = this.calcForceExertedBy(p);
		double distance = this.calcDistance(p);
		double dy = p.yyPos - this.yyPos;
		return total_F * dy / distance;
	}

	/** Calculate the net force of all planets */
	public double calcNetForceExertedByX(Planet[] allPlanets) {
		double net_forceX = 0;
		for(Planet p : allPlanets) {
			if(!p.equals(this)) {
				net_forceX = net_forceX + this.calcForceExertedByX(p);
			}
		}
		return net_forceX;
	}

	public double calcNetForceExertedByY(Planet[] allPlanets) {
		double net_forceY = 0;
		for(Planet p : allPlanets) {
			if(!p.equals(this)) {
				net_forceY = net_forceY + this.calcForceExertedByY(p);
			}
		}
		return net_forceY;
	}

	/** Updata the velocity and position */
	public void update(double dt, double fX, double fY) {
		double aX = fX / this.mass;
		double aY = fY / this.mass;
		this.xxVel = this.xxVel + aX * dt;
		this.yyVel = this.yyVel + aY * dt;
		this.xxPos = this.xxPos + this.xxVel * dt;
		this.yyPos = this.yyPos + this.yyVel * dt;
	}

	public void draw() {
		StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
	}
}