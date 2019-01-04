package main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Rond extends Figure implements Surfacable {

	private Point point;
	private int r;

	public Rond(Point point, int r) {
		super();
		this.point = point;
		this.r = r;
		this.couleur = Couleur.getCouleurDefaut(); /* Couleur. car en static dans couleur.jave */
	}

	public Rond(Point point, int r, Couleur couleur) {
		this(point, r);
		this.couleur = couleur;
	}

	public String print() {
		return "Rond " + couleur + "[point=" + point.toString() + ", r=" + r + "]";
	}

	@Override
	public double surface() {
		return Math.PI * Math.pow(r, 2);
	}

	@Override
	public Collection<Point> getPoints() {
		List<Point> points = new ArrayList<>();
		points.add(point);
		return points;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((point == null) ? 0 : point.hashCode());
		result = prime * result + r;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rond other = (Rond) obj;
		if (point == null) {
			if (other.point != null)
				return false;
		} else if (!point.equals(other.point))
			return false;
		if (r != other.r)
			return false;
		if(this.couleur != ((Rond) obj).getCouleur()){
			return false;
		}
		
		return true;
	}

	@Override
	public boolean couvre(Point point) {
		// return this.point.distance(point) <= (double) r;
		return Math.sqrt(
				Math.pow(point.getX() - this.point.getX(), 2) + Math.pow(point.getY() - this.point.getY(), 2)) <= r;
	}

}
