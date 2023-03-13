/** NBody is a class that will actually run simulation*/
public class NBody {
	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		In in = new In(filename);
		int count = in.readInt();
		double radius = NBody.readRadius(filename);
		Planet[] allPlanets = NBody.readPlanets(filename);

		StdDraw.setScale(-radius, radius);
		StdDraw.picture(0, 0, "images/starfield.jpg");
		for(Planet p : allPlanets) {
			p.draw();
		}

		StdDraw.enableDoubleBuffering();

		double time = 0;

		while(time <= T) {
			double[] xForces = new double[count];
			double[] yForces = new double[count];
			for(int i = 0; i < count; i++) {
				xForces[i] = allPlanets[i].calcNetForceExertedByX(allPlanets);
				yForces[i] = allPlanets[i].calcNetForceExertedByY(allPlanets);
				allPlanets[i].update(dt, xForces[i], yForces[i]);
			}
			StdDraw.picture(0, 0, "images/starfield.jpg");
			for(Planet p : allPlanets) {
				p.draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
			time = time + dt;
		}

		StdOut.printf("%d\n", allPlanets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < allPlanets.length; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  allPlanets[i].xxPos, allPlanets[i].yyPos, allPlanets[i].xxVel,
                  allPlanets[i].yyVel, allPlanets[i].mass, allPlanets[i].imgFileName);   
		}
	}

	/** Read the radius of the universe */
	public static double readRadius(String s) {
		In in = new In(s);
		int count = in.readInt();
		double radius = in.readDouble();
		return radius;
	}

	/** Read the info of planets */
	public static Planet[] readPlanets(String s) {
		In in = new In(s);
		int count = in.readInt();
		double radius = in.readDouble();
		Planet[] res = new Planet[count];
		for(int i = 0; i < count; i++){
			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass = in.readDouble();
			String img = in.readString();
			res[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, img);
		}
		return res;
	}
}