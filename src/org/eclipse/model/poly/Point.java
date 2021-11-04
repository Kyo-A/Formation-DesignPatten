package org.eclipse.model.poly;

public class Point {

	private int x;
	private int y;
	
	/**
	 * Cree un point de coordonnees (x,y)
	 * @param x
	 * @param y
	 */
	protected Point(int x, int y){ // Design Pattern FlyWeight : les instances de Point sont creees par PointFactory
		this.x = x;
		this.y = y;
	}
	
	public int distance(Point p){
		return (int)(Math.sqrt((x-p.getX())*(x-p.getX()) + (y-p.getY())*(y-p.getY())));
	}
	
	public Point deplace(int deltaX, int deltaY) {
		return PointFactory.creePoint(x+deltaX, y+deltaY);
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
