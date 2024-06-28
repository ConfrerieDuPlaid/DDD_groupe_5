package cat.confrerie_du_plaid.groupe_5.domain.exceptions;

import cat.confrerie_du_plaid.groupe_5.domain.annotations.DomainException;

@DomainException
public class CommentaireInvalide extends Exception {
    public CommentaireInvalide(String message) {
        super(message);
    }
}
