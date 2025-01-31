package cat.confrerie_du_plaid.groupe_5.domain.lecture;


import cat.confrerie_du_plaid.groupe_5.domain.shared.exceptions.EvaluationInvalide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class EvaluationTest {
    @Test()
    public void evaluationInferieureAZero() {
        Assertions.assertThrows(EvaluationInvalide.class, () -> {
            Evaluation.ajouterUneNote(-1.0);
        }, "La note doit être comprise entre 0 et 5");
    }

    @Test()
    public void evaluationSuperieureACinq () {
        Assertions.assertThrows(EvaluationInvalide.class, () -> {
            Evaluation.ajouterUneNote(5.5);
        }, "La note doit être comprise entre 0 et 5");
    }

    @Test()
    public void evaluationNonMultipleDeDemiPoint() {
        Assertions.assertThrows(EvaluationInvalide.class, () -> {
            Evaluation.ajouterUneNote(3.3);
        },"La note doit être un multiple de 0.5");
    }

    @Test()
    public void evaluationValide() throws EvaluationInvalide {
        Evaluation evaluation = Evaluation.ajouterUneNote(3.5);
        Assertions.assertEquals(3.5, evaluation.getNote());
    }

    @Test()
    public void sansEvaluation() throws EvaluationInvalide {
        Assertions.assertInstanceOf(Evaluation.SansEvaluation.class, Evaluation.ajouterUneNote(null));
    }

    @Test()
    public void evaluationEgalent() throws EvaluationInvalide {
        Evaluation evaluation1 = Evaluation.ajouterUneNote(3.5);
        Evaluation evaluation2 = Evaluation.ajouterUneNote(3.5);
        assert(evaluation1.equals(evaluation2));
    }

    @Test()
    public void evaluationNonEgalent() throws EvaluationInvalide {
        Evaluation evaluation1 = Evaluation.ajouterUneNote(3.5);
        Evaluation evaluation2 = Evaluation.ajouterUneNote(4.0);
        assert(!evaluation1.equals(evaluation2));
    }
}
