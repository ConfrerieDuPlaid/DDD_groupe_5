package cat.confrerie_du_plaid.groupe_5.domain;

public class Evaluation {
    private double note;

    private Evaluation (double note) {
        this.note = note;
    }

    public static Evaluation ajouterUneNote(double note) {
        if (note < 0 || note > 5) {
            throw new IllegalArgumentException("La note doit être comprise entre 0 et 5");
        }
        boolean estUnDemiPoint = note * 10 % 5 == 0;
        if (!estUnDemiPoint) {
            throw new IllegalArgumentException("La note doit être un multiple de 0.5");
        }
        return new Evaluation(note);
    }

    public double getNote() {
        return note;
    }
}
