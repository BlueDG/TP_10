package utils;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import exception.ImpressionHorsLimite;
import main.Carre;
import main.Couleur;
import main.Dessin;
import main.Figure;
import main.Point;
import main.Rectangle;
import main.Rond;
import main.Segment;
import main.Surfacable;

public class FigureUtil {

	private static Map<String, Figure> figures = new HashMap<>();

	/**
	 * @return random number between 0 and 100 excluded
	 */
	private static int randomInt() {
		return ThreadLocalRandom.current().nextInt(0, 52);
	}

	public static Rond getRandomRond() {
		Point p = new Point(randomInt(), randomInt());
		Rond rond = new Rond(p, randomInt(), Couleur.getCouleurRandom());
		figures.put(rond.getId(), rond);
		return rond;
	}

	public static Rectangle getRandomRectangle() {
		Point p = new Point(randomInt(), randomInt());
		Rectangle rectangle = new Rectangle(p, randomInt(), randomInt(), Couleur.getCouleurRandom());
		figures.put(rectangle.getId(), rectangle);
		return rectangle;
	}

	public static Carre getRandomCarre() {
		Point p = new Point(randomInt(), randomInt());
		Carre carre = new Carre(p, randomInt(), Couleur.getCouleurRandom());
		figures.put(carre.getId(), carre);
		return carre;
	}

	public static Segment getRandomSegment() {
		Point p = new Point(randomInt(), randomInt());
		Segment segment = new Segment(p, randomInt(), randomInt() < 50 ? true : false, Couleur.getCouleurRandom());
		figures.put(segment.getId(), segment);
		return segment;
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
//		List<Figure> figures = new ArrayList<>(dessin.getFigures());
//		Collections.sort(figures);
//		return figures;
		return dessin.getFigures().stream().sorted().collect(Collectors.toList());
	}

	public static Collection<Figure> trieSurface(Dessin dessin) {
		
		return dessin.getFigures().stream().filter(i-> i instanceof Surfacable).sorted((o1,o2)->{
			Surfacable s1 = (Surfacable) o1;
			Surfacable s2 = (Surfacable) o2;
			if (s1.surface() > s2.surface()) {
				return 1;
			} else if (s1.surface() < s2.surface()) {
				return -1;
			}
			return 0;
		}).collect(Collectors.toList());
		
		
//		List<Figure> figures = new ArrayList<>(dessin.getFigures());
//		List<Figure> figureSurfacable = new ArrayList<>();
//		for (Figure tmp : figures) {
//			if (tmp instanceof Surfacable) {
//				figureSurfacable.add(tmp);
//			}
//		}
//		Collections.sort(figureSurfacable, new Comparator<Figure>() {
//			@Override
//			public int compare(Figure o1, Figure o2) {
//				Surfacable s1 = (Surfacable) o1;
//				Surfacable s2 = (Surfacable) o2;
//				if (s1.surface() > s2.surface()) {
//					return 1;
//				} else if (s1.surface() < s2.surface()) {
//					return -1;
//				}
//				return 0;
//			}
//		});
//		return figureSurfacable;
	}

	public static Figure get(String id) {
		return figures.get(id);
	}

	public static void imprime() throws ImpressionHorsLimite, IOException {
		for (Entry<String, Figure> entry : figures.entrySet()) {
			Figure f = entry.getValue();
			for (Point p : f.getPoints()) {
				if (p.getX() < 0 || p.getX() > 99 || p.getY() < 0 || p.getY() > 99) {
					throw new ImpressionHorsLimite(
							"figure hors limite : " + entry.getKey() + " " + p.getX() + " " + p.getY());
				}
			}
		}
	}

	public static void stockTableau(Figure fig, char[][] tableau) {
		for (Point point : fig.getPoints()) {
			if (!(point.getX() < 0 || point.getX() > 99 || point.getY() < 0 || point.getY() > 99)) {
				tableau[point.getX()][point.getY()] = fig.getCouleur().getCode(); // tu ajoutes getcode car tu veux
																					// afficher le code DE la couleur DE
																					// la figure affichée

			}
		}
	}

	public static void imprime(Dessin d) {

		try {
			File fichier = File.createTempFile("dessin", ".txt");
			/*
			 * tu crées un fichier tu tapes File puis son nom puis = la formule avec ses
			 * paramètres "nom car de type de string" puis "txt en tan qu'extension" on te
			 * propose ensuite un try catch car exception needed. tu clic. et voilà.
			 */

			FileWriter writer = new FileWriter(fichier); // new car on crée un nouveau. on fait appel au constructeur.
															// fichier étant le nom que j'ai choisi.
			/*
			 * filewriter est un flux d'écriture, nécessaire un File nécessite un flux, dont
			 * ici filewriter
			 */

			System.out.println("Chemin du fichier : " + fichier.getPath());

			// writer.write("j'ecris dans mon fichier"); Exemple d'écriture dans un fichier

			for (Figure fig : d.getFigures()) { // on fait une boucle qui parcourt les figures de notre dessin. figure
												// bleu = type. fig = nom. la suite = va me choper les figures dans le
												// dessin, la liste des figures du dessin
				writer.write(fig.print() + System.lineSeparator()); // print ici est comme tostring, permettant de
																	// convertir une figure en chaine de caractères.
			}

			for (int i = 0; i < 100; i++) { // afficher et multiplier = 100 fois
				writer.write("=");
			}
			writer.write(System.lineSeparator()); // revient à la ligne

			char tableau[][] = new char[100][100];

			for (int i = 0; i < tableau.length; i++) {
				for (int j = 0; j < tableau[i].length; j++) {
					tableau[i][j] = ' '; // single car char et non string
					// ds le cas où le tableau est biscornu, j'ai disons [100] et [200], je fais
					// quand même une 2ème boucle
					// le problème vient de length. la longueur de la 1 ligne peut = à 100
					// la ligne 21 peut être = à 110.
					// donc je fais une deuxième length de tableau de [i] car [i] correspond à la
					// première case de chaque ligne

				}

			}

			for (Figure fig : d.getFigures()) {
				stockTableau(fig, tableau);
			}

			for (int i = 0; i < tableau.length; i++) {
				writer.write(tableau[i]); // j'affiche le tableau
				writer.write(System.lineSeparator()); // je fais le retour à la ligne

			}

			Desktop.getDesktop().open(fichier); // on ouvre le fichier que l'on à crée

			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void sauvegarde() {

	}

	public Dessin charge() {

		return null;
	}

}
