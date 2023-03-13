/**
 *  Tests Planet class
 */
public class TestPlanet {
	public static void main(String[] args) {
		checkPlanet();
	}

	/** Test the netForce of p1 */
	public static void checkPlanet() {
		Planet p1 = new Planet(0, 0, 0, 0, 5, "planet_one");
		Planet p2 = new Planet(8, 6, 0, 0, 10, "planet_two");
		Planet p3 = new Planet(-4, 3, 0, 0, 10, "planet_therr");

		Planet[] allPlanets = new Planet[]{p1, p2, p3};
		double netForce = p1.calcNetForceExertedByX(allPlanets);
		if(Math.abs(netForce - 8.0e-11) < 1.0e-12) {
			System.out.println("Failed. the netforce is " + netForce);
		} else {
			System.out.println("Passed.");
		}
	}
}