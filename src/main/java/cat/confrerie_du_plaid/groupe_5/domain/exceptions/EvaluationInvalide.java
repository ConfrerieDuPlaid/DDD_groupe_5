package cat.confrerie_du_plaid.groupe_5.domain.exceptions;

import cat.confrerie_du_plaid.groupe_5.domain.annotations.DomainException;

@DomainException
public class EvaluationInvalide extends Exception {
    public EvaluationInvalide(String message) {
        super(message);
    }

    public EvaluationInvalide() {
    }
}
