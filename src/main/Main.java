package main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> number = new ArrayList<>();
		number.add(1);
		number.add(1);
		number.add(1);
		number.add(1897);
		number.add(65741);
		number.add(1);
		number.add(null);
		number.add(1657);
		number.add(1879);
		number.add(1687);
		number.add(1687);
		number.add(100);
		number.add(10);

		System.out.println(number.stream().filter(i -> i != null).reduce((sum, current) -> sum + current).orElse(0));
		System.out.println(number.stream().filter(i -> i != null).map(i -> i.toString())
				.reduce((sum, current) -> sum + ", " + current).orElse("va chier"));

		System.out.println(number.stream().filter(i -> i != null && i > 1600).collect(Collectors.toList()));

		List<Integer> res = new ArrayList<>();
		for (Integer i : number) {
			if (i != null && i > 1600) {
				res.add(i);
			}
		}
		System.out.println(res);

//		
//
//		Point p = new Point(1, 1);
//		Rectangle r = new Rectangle(p, 2, 3);
//		System.out.println(p.toString());
//		r.affiche();
//
//		Rond rond = FigureUtil.getRandomRond();
//		rond.affiche();
//		Rectangle rect = FigureUtil.getRandomRectangle();
//		rect.affiche();
//
//		Carre c = new Carre(p, 2);
//		c.affiche();
//
//		System.out.println(p.equals(p));
//		System.out.println(p.equals(new Point()));
//
//		FigureUtil.getRandomFigure().affiche();
//
//		System.out.println(FigureUtil.getPoints(FigureUtil.getRandomFigure(), FigureUtil.getRandomFigure(),
//				FigureUtil.getRandomFigure(), FigureUtil.getRandomFigure(), FigureUtil.getRandomFigure(),
//				FigureUtil.getRandomFigure(), FigureUtil.getRandomFigure()).size());
//
//		System.out.println("N figures Aleatoire : ");
//		System.out.println(FigureUtil.genere(10));
//
//		Dessin d = new Dessin();
//		Collection<Figure> figures = FigureUtil.genere(100);
//		for (Figure f : figures) {
//			d.add(f);
//		}
//		System.out.println("Figure en : ");
//		Figure figure = FigureUtil.getFigureEn(new Point(50, 50), d);
//		if (figure != null) {
//			figure.affiche();
//		} else {
//			System.out.println("pas trouvé");
//		}
//
//		Collection<Figure> fs = FigureUtil.trieProcheOrigine(d);
//		for (Figure ft : fs) {
//			System.out.println("distance origine : " + ft.distanceOrigine());
//		}
//
//		Collection<Figure> fs1 = FigureUtil.trieSurface(d);
//		for (Figure ft : fs1) {
//			System.out.println("surface : " + ((Surfacable) ft).surface());
//		}
//		
//		try {
//			FigureUtil.imprime();
//		} catch (ImpressionHorsLimite  e) {
//			System.out.println("impression hors limite detectée : " + e.getMessage());
//		} catch (IOException e) {
//			System.out.println("IOException detectée : " + e.getMessage());
//		}
//		
//		//Fichier
//		
//		Dessin draw = new Dessin();
//		
//		for(Figure fig : FigureUtil.genere(10)) { // je parcours la collection de figures que l'on génère aléatoirement grâce a FigureUtil.genere(NBFigure) que j'ai crée dans FigureUtil ligne 103 
//			draw.add(fig); // On stocke les figures géneré dans notre dessin
//		}
//		
//		FigureUtil.imprime(draw);
	}

}
