package main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Rectangle extends Figure implements Surfacable {

	protected Point pointBasGauche;
	protected Point pointBasDroit;
	protected Point pointHautGauche;
	protected Point pointHautDroit;

	public Rectangle(Point point, int width, int height) {
		pointBasGauche = point;
		pointBasDroit = new Point(point.getX() + width, point.getY());
		pointHautGauche = new Point(point.getX(), point.getY() + height);
		pointHautDroit = new Point(point.getX() + width, point.getY() + height);
		this.couleur = Couleur.getCouleurDefaut(); /* Couleur. car en static dans couleur.jave */
	}
	
	public Rectangle(Point point, int width, int height, Couleur couleur) {
		this(point, width, height);
		this.couleur = couleur;
	}

	public Point getPointBasGauche() {
		return pointBasGauche;
	}

	public Point getPointBasDroit() {
		return pointBasDroit;
	}

	public Point getPointHautGauche() {
		return pointHautGauche;
	}

	public Point getPointHautDroit() {
		return pointHautDroit;
	}

	public String print() {
		return "Rectangle " + couleur + "[pointBasGauche=" + pointBasGauche + ", pointBasDroit=" + pointBasDroit + ", pointHautGauche="
				+ pointHautGauche + ", pointHautDroit=" + pointHautDroit + "]";
	}

	@Override
	public double surface() {
		int a = Math.abs(pointHautDroit.getX() - pointBasGauche.getX())
				* Math.abs(pointHautDroit.getY() - pointBasGauche.getY());
		return a;

	}

	@Override
	public Collection<Point> getPoints() {
		List<Point> points = new ArrayList<>();
		points.add(pointBasGauche);
		points.add(pointBasDroit);
		points.add(pointHautDroit);
		points.add(pointHautGauche);
		return points;
	}

	@Override
	public boolean couvre(Point point) {
		return (point.getX() >= pointBasGauche.getX() && point.getX() <= pointHautDroit.getX())
				&& (point.getY() >= pointBasGauche.getY() && point.getY() <= pointHautDroit.getY());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pointBasDroit == null) ? 0 : pointBasDroit.hashCode());
		result = prime * result + ((pointBasGauche == null) ? 0 : pointBasGauche.hashCode());
		result = prime * result + ((pointHautDroit == null) ? 0 : pointHautDroit.hashCode());
		result = prime * result + ((pointHautGauche == null) ? 0 : pointHautGauche.hashCode());
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
		Rectangle other = (Rectangle) obj;
		if (pointBasDroit == null) {
			if (other.pointBasDroit != null)
				return false;
		} else if (!pointBasDroit.equals(other.pointBasDroit))
			return false;
		if (pointBasGauche == null) {
			if (other.pointBasGauche != null)
				return false;
		} else if (!pointBasGauche.equals(other.pointBasGauche))
			return false;
		if (pointHautDroit == null) {
			if (other.pointHautDroit != null)
				return false;
		} else if (!pointHautDroit.equals(other.pointHautDroit))
			return false;
		if (pointHautGauche == null) {
			if (other.pointHautGauche != null)
				return false;
		} else if (!pointHautGauche.equals(other.pointHautGauche))
			return false;
		
		if(this.couleur != ((Rectangle) obj).getCouleur()){
			return false;
		}
		return true;
	}
	
	

}
