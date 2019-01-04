package main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class Figure implements Comparable<Figure> {

	private static int id;
	public abstract String print();
	protected Couleur couleur;
	
	public void affiche() {
		System.out.println(this.print());
	}
	
	public String getId() {
		id++;
		return this.getClass().getName() + id;
	}

	public abstract Collection<Point> getPoints();

	public abstract boolean couvre(Point point);

	public double distanceOrigine() {
		List<Double> d = new ArrayList<>();
		for (Point p : this.getPoints()) {
			d.add(p.distanceOrigine());
		}
		return Collections.min(d);
	}

	@Override
	public int compareTo(Figure o) {
		if (this.distanceOrigine() > o.distanceOrigine()) {
			return 1;
		} else if (this.distanceOrigine() < o.distanceOrigine()) {
			return -1;
		}
		return 0;
	}
	
	public Couleur getCouleur() {
		return couleur;
	}
	
	
}
