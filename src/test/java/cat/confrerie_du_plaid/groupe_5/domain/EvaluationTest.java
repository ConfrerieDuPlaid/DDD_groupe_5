package cat.confrerie_du_plaid.groupe_5.domain;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class EvaluationTest {
    @Test()
    public void evaluationInferieureAZero() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Evaluation evaluation = Evaluation.ajouterUneNote(-1.0);
        });
    }

    @Test()
    public void evaluationSuperieureACinq () {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Evaluation evaluation = Evaluation.ajouterUneNote(5.5);
        });
    }

    @Test()
    public void evaluationNonMultipleDeDemiPoint() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Evaluation evaluation = Evaluation.ajouterUneNote(3.3);
        });
    }

    @Test()
    public void evaluationValide() {
        Evaluation evaluation = Evaluation.ajouterUneNote(3.5);
        Assertions.assertEquals(3.5, evaluation.getNote());
    }

}
