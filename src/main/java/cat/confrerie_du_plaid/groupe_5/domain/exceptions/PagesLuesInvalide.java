package cat.confrerie_du_plaid.groupe_5.domain.exceptions;

import cat.confrerie_du_plaid.groupe_5.domain.annotations.DomainException;

@DomainException
public class PagesLuesInvalide extends Exception {
    public PagesLuesInvalide(String message) {
        super(message);
    }

    public PagesLuesInvalide() {
    }
}
