package cat.confrerie_du_plaid.groupe_5.domain.lecture;

import cat.confrerie_du_plaid.groupe_5.application.livre.exceptions.EvaluationInvalide;

import java.util.Objects;

public class Evaluation {
    private final Double note;

    public static class SansEvaluation extends Evaluation {
        public SansEvaluation() {
            super(0.0);
        }
    }

    protected Evaluation(Double note) {
        this.note = note;
    }

    public static Evaluation ajouterUneNote(Double note) throws EvaluationInvalide {
        if(Objects.isNull(note)){
            return new SansEvaluation();
        }
        if (note < 0 || note > 5) {
            throw new EvaluationInvalide("La note doit être comprise entre 0 et 5");
        }
        boolean estUnDemiPoint = note * 10 % 5 == 0;
        if (!estUnDemiPoint) {
            throw new EvaluationInvalide("La note doit être un multiple de 0.5");
        }
        return new Evaluation(note);
    }

    public double getNote() {
        return note;
    }
}
