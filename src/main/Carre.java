package main;

public class Carre extends Rectangle {

	public Carre(Point point, int width) {
		super(point, width, width);
	}

	public Carre(Point point, int width, Couleur couleur) {
		super(point, width, width, couleur);
	}
	
	public String print() {
		return "Carre "+ couleur + "[pointBasGauche=" + pointBasGauche + ", pointBasDroit=" + pointBasDroit + ", pointHautGauche="
				+ pointHautGauche + ", pointHautDroit=" + pointHautDroit + "]";
	}
}
