package cat.confrerie_du_plaid.groupe_5.domain.lecture;

import cat.confrerie_du_plaid.groupe_5.domain.annotations.ValueObject;
import cat.confrerie_du_plaid.groupe_5.domain.exceptions.EvaluationInvalide;

import java.util.Objects;

@ValueObject
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Evaluation that)) return false;
        return Objects.equals(getNote(), that.getNote());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getNote());
    }
}
