package main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Segment extends Figure {

	private Point debut;
	private Point fin;
	private boolean horizontal;

	public Segment(Point point, int longueur, boolean horizontal) {
		this.debut = point;
		this.horizontal = horizontal;
		if (horizontal) {
			this.fin = new Point(point.getX() + longueur, point.getY());
		} else {
			this.fin = new Point(point.getX(), point.getY() + longueur);
		}
		this.couleur = Couleur.getCouleurDefaut();
	}
	
	public Segment(Point point, int longueur, boolean horizontal, Couleur couleur) {
		this(point, longueur, horizontal);
		this.couleur = couleur;
		
	}

	@Override
	public String print() {
		return "Segment " + couleur + "[debut=" + debut + ", fin=" + fin + "]";
		
	}

	@Override
	public Collection<Point> getPoints() {
		List<Point> points = new ArrayList<>();
		points.add(debut);
		points.add(fin);
		return points;
	}

	@Override
	public boolean couvre(Point point) {
		return (horizontal && (point.getY() == debut.getY() && point.getX() >= debut.getX() && point.getX() <= fin.getX())) || 
				(!horizontal && (point.getX() == debut.getX() && point.getY() >= debut.getY() && point.getY() <= fin.getY()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((debut == null) ? 0 : debut.hashCode());
		result = prime * result + ((fin == null) ? 0 : fin.hashCode());
		result = prime * result + (horizontal ? 1231 : 1237);
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
		Segment other = (Segment) obj;
		if (debut == null) {
			if (other.debut != null)
				return false;
		} else if (!debut.equals(other.debut))
			return false;
		if (fin == null) {
			if (other.fin != null)
				return false;
		} else if (!fin.equals(other.fin))
			return false;
		if (horizontal != other.horizontal)
			return false;
		if(this.couleur != ((Segment) obj).getCouleur()){
			return false;
		}
		return true;
	}

	

}
