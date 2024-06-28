package cat.confrerie_du_plaid.groupe_5.domain.exceptions;

import cat.confrerie_du_plaid.groupe_5.domain.annotations.DomainException;

@DomainException
public class LivreNonTrouve extends Exception {
    public LivreNonTrouve(String msg) {
        super(msg);
    }
}
