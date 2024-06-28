package cat.confrerie_du_plaid.groupe_5.domain.shared.exceptions;

import cat.confrerie_du_plaid.groupe_5.domain.shared.annotations.DomainException;

@DomainException
public class PagesTotalesInvalide extends Exception {
    public PagesTotalesInvalide() {
    }

    public PagesTotalesInvalide(String message) {
        super(message);
    }
}
