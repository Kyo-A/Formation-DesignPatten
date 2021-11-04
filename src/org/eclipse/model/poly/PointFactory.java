package org.eclipse.model.poly;

public class PointFactory {
	private static Point points[][];
	private static int largeur;
	private static int hauteur;

	/**
	 * Cree une fabrique de points capable de creer des points dont les coordonnees (x,y) 
	 * sont telles que x est compris entre 0 et l et y est compris entre 0 et h
	 * Utilisation du design pattern fly weight pour recycler les points crees
	 * @param l la largeur
	 * @param h la hauteur
	 */
	public static void initPointFactory(int l, int h){
		PointFactory.largeur = l;
		PointFactory.hauteur = h;
		PointFactory.points = new Point[l+1][h+1];
	}
	
	/** 
	 * @param x
	 * @param y
	 * @return une instance p de Point telle que p.x = x et p.y = y
	 */
	public static Point creePoint(int x, int y){
		if ((x > largeur) || (x < 0) || (y > hauteur) || (y < 0))
			return null;
		if (points[x][y] == null)
			points[x][y] = new Point(x,y);
		return points[x][y];
	}
}

