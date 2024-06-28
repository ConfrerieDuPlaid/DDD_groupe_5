package cat.confrerie_du_plaid.groupe_5.domain.exceptions;

import cat.confrerie_du_plaid.groupe_5.domain.annotations.DomainException;

@DomainException
public class PagesTotalesInvalide extends Exception {
    public PagesTotalesInvalide() {
    }

    public PagesTotalesInvalide(String message) {
        super(message);
    }
}
