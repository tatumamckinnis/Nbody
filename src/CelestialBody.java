

/**
 * Celestial Body class for NBody
 * Modified from original Planet class
 * used at Princeton and Berkeley
 * @author ola
 *
 * If you add code here, add yourself as @author below
 * @author Tatum McKinnis
 *
 */
public class CelestialBody {

	private double myXPos;
	private double myYPos;
	private double myXVel;
	private double myYVel;
	private double myMass;
	private String myFileName;

	/**
	 * Create a Body from parameters	
	 * @param xp initial x position
	 * @param yp initial y position
	 * @param xv initial x velocity
	 * @param yv initial y velocity
	 * @param mass of object
	 * @param filename of image for object animation
	 */
	public CelestialBody(double xp, double yp, double xv,
			             double yv, double mass, String filename){
		// TODO: complete constructor
	
		myXPos = xp; 
		myYPos = yp; 
		myXVel = xv; 
		myYVel = yv; 
		myMass = mass; 
		myFileName = filename; 
	}

	/**
	 *
	 * @return
	 */
	public double getX() {
		// TODO: complete method
		return myXPos; 
	}

	/**
	 *
	 * @return
	 */
	public double getY() {
		// TODO: complete method
		return myYPos; 
	}

	/**
	 * Accessor for the x-velocity
	 * @return the value of this object's x-velocity
	 */
	public double getXVel() {
		// TODO: complete method
		return myXVel;
	}
	/**
	 * Return y-velocity of this Body.
	 * @return value of y-velocity.
	 */
	public double getYVel() {
		// TODO: complete method
		return myYVel; 
	}

	/**
	 *
	 * @return
	 */
	public double getMass() {
		// TODO: complete method
		return myMass; 
	}

	/**
	 *
	 * @return
	 */
	public String getName() {
		// TODO: complete method
		return myFileName;
	}

	/**
	 * Return the distance between this body and another
	 * @param b the other body to which distance is calculated
	 * @return distance between this body and b
	 */
	public double calcDistance(CelestialBody b) {
		// TODO: complete method
		double xCoorDiff = myXPos - b.getX();
		double yCoorDiff = myYPos - b.getY(); 
		double xSqua= Math.pow(xCoorDiff,2);
		double ySqua= Math.pow(yCoorDiff,2);
		double result = Math.sqrt(xSqua + ySqua);
		return result;
	}

	public double calcForceExertedBy(CelestialBody b) {
		// TODO: complete method
		double distance = calcDistance(b); 
		double force = ((6.67*1e-11) * myMass * b.getMass()) / (Math.pow(distance, 2));
		return force;
	}

	public double calcForceExertedByX(CelestialBody b) {
		double dx = b.getX() - myXPos; 
		double force = calcForceExertedBy(b); 
		double r = calcDistance (b); 
		double result = (force) * (dx/r); 
		return result; 
	}
	public double calcForceExertedByY(CelestialBody b) {
		// TODO: complete method
			double dy = b.getY() - myYPos;  
		double force = calcForceExertedBy(b); 
		double r = calcDistance (b); 
		double result = (force) * (dy/r); 
		return result; 
	}

	public double calcNetForceExertedByX(CelestialBody[] bodies) {
		// TODO: complete method
		double sum = 0.0;
		for (int i= 0; i<bodies.length; i++)
		{
			if (bodies[i] != this)
			{
				sum = sum + calcForceExertedByX(bodies[i]);
			}
		}
		return sum;
	}

	public double calcNetForceExertedByY(CelestialBody[] bodies) {
		double sum = 0.0;
		for (int i= 0; i<bodies.length; i++)
		{
			if (bodies[i] != this)
			{
				sum = sum + calcForceExertedByY(bodies[i]);
			}
		}
		return sum;
	}

	public void update(double deltaT, 
			           double xforce, double yforce) {
		// TODO: complete method
	}

	/**
	 * Draws this planet's image at its current position
	 */
	public void draw() {
		StdDraw.picture(myXPos,myYPos,"images/"+myFileName);
	}
}
