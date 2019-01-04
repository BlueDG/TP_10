package utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import main.Carre;
import main.Dessin;
import main.Figure;
import main.Point;
import main.Rectangle;
import main.Rond;
import main.Segment;
import main.Surfacable;

public class TP10 {

	/**
	 * @return random number between 0 and 100 excluded
	 */
	private static int randomInt() {
		return ThreadLocalRandom.current().nextInt(0, 99);
	}

	public static Rond getRandomRond() {
		Point p = new Point(randomInt(), randomInt());
		return new Rond(p, randomInt());
	}

	public static Rectangle getRandomRectangle() {
		Point p = new Point(randomInt(), randomInt());
		return new Rectangle(p, randomInt(), randomInt());
	}

	public static Carre getRandomCarre() {
		Point p = new Point(randomInt(), randomInt());
		return new Carre(p, randomInt());
	}

	public static Segment getRandomSegment() {
		Point p = new Point(randomInt(), randomInt());
		return new Segment(p, randomInt(), randomInt() < 50 ? true : false);
	}

	public static Figure getRandomFigure() {
		int chx = ThreadLocalRandom.current().nextInt(0, 4);
		switch (chx) {
		case 0:
			return getRandomRond();
		case 1:
			return getRandomCarre();
		case 2:
			return getRandomSegment();
		case 3:
		default:
			return getRandomRectangle();
		}
	}

	public static Surfacable getRandomSurfacable() {

		int chx = ThreadLocalRandom.current().nextInt(0, 3);
		switch (chx) {
		case 0:
			return getRandomRond();
		case 1:
			return getRandomCarre();
		case 2:
		default:
			return getRandomRectangle();
		}
	}

	public static Collection<Point> getPoints(Figure... fig) {
		List<Point> points = new ArrayList<>();
		for (int i = 0; i < fig.length; i++) {
			points.addAll(fig[i].getPoints());
		}
		return points;
	}

	public static Collection<Figure> genere(int n) {
		Collection<Figure> figures = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			figures.add(getRandomFigure());
		}
		return figures;
	}

	public static Figure getFigureEn(Point p, Dessin d) {
		for (Figure figure : d.getFigures()) {
			if (figure.couvre(p)) {
				return figure;
			}
		}
		return null;
	}

	public static Collection<Figure> trieProcheOrigine(Dessin dessin) {
		List<Figure> figures = new ArrayList<>(dessin.getFigures());
		Collections.sort(figures);
		return figures;
	}

	public static Collection<Figure> trieSurface(Dessin dessin) {
		List<Figure> figures = new ArrayList<>(dessin.getFigures());
		List<Figure> figureSurfacable = new ArrayList<>();
		for (Figure tmp : figures) {
			if (tmp instanceof Surfacable) {
				figureSurfacable.add(tmp);
			}
		}
		Collections.sort(figureSurfacable, new Comparator<Figure>() {
					@Override
					public int compare(Figure o1, Figure o2) {
						Surfacable s1 = (Surfacable) o1;
						Surfacable s2 = (Surfacable) o2;
						if (s1.surface() > s2.surface()) {
							return 1;
						} else if (s1.surface() < s2.surface()) {
							return -1;
						}
						return 0;
					}
				});
		return figureSurfacable;
	}

}
