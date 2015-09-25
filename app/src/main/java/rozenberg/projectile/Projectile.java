package rozenberg.projectile;

public class Projectile {

	private double angle;
	private double velocity;
	private double time;
	private double radians;

	public Projectile(double ang, double vel, double ti) {
		angle = ang;
		velocity = vel;
		time = ti;
		radians = Math.toRadians(angle);
		// in the constructor so it doesn't have to be redone many times
	}

	public double getX() {
		return Math.sin(radians) * velocity * time;

	}

	public double getY() {
		return Math.cos(radians) * velocity * time - (.5 * 9.8 * time * time);

	}
	 
	public void setTime(double ti){
		time = ti;
		
	}
	
	//to modify the file for git practice
}
