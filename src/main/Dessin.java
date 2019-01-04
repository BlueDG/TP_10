package main;

import java.util.ArrayList;
import java.util.Collection;

public class Dessin {

	private Collection<Figure> figures;

	public Dessin() {
		figures = new ArrayList<>();
	}

	public boolean add(Figure figure) {
		return figures.add(figure);
	}

	public Collection<Figure> getFigures() {
		return figures;
	}
}
