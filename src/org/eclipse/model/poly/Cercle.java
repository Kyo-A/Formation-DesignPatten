package org.eclipse.model.poly;

public class Cercle implements Forme{
	private Point centre;
	private int rayon;
	
	/**
	 * Cree un cercle de centre c et de rayon r
	 * @param c les coordonnees du centre du cercle
	 * @param r le rayon du cercle
	 */
	public Cercle(Point c, int r){
		super();
		this.rayon = r;
		this.centre = c;
	}
	
	public Point getCentre() {
		return centre;
	}
	
	public int getRayon() {
		return rayon;
	}
	
	@Override
	public boolean contient(Point p) {
		return centre.distance(p) <= rayon;
	}
	
	@Override
	public void deplace(int deltaX, int deltaY) {
		centre = centre.deplace(deltaX, deltaY);
	}
	
	@Override
	public boolean contenuDans(Rectangle r) {
		Point pMin = PointFactory.creePoint(centre.getX()-rayon, centre.getY()-rayon);
		if (pMin == null) 
			return false;
		Point pMax = PointFactory.creePoint(centre.getX()+rayon, centre.getY()+rayon);
		if (pMax == null) 
			return false;
		return r.contient(pMin) && r.contient(pMax);
	}
	
	
	
	@Override
	public boolean disjoint(Forme f) {
		if (f instanceof Cercle)
			return disjoint((Cercle)f);
		else
			return disjoint((Rectangle)f);
	}
	
	private boolean disjoint(Rectangle r){
		return r.disjoint(this);
	}
	
	private boolean disjoint(Cercle cercle){
		int a = Math.abs(cercle.getRayon()-rayon) ;
		a *= a;
		int b = cercle.getCentre().getX()-centre.getX();
		b *= b;
		int c = cercle.getCentre().getY()-centre.getY();
		c *= c;
		int d = Math.abs(cercle.getRayon()+rayon);
		d *= d;
		return (a >= b+c) || (b+c >= d);
	}




}
