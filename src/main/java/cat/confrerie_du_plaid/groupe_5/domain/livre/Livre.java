package cat.confrerie_du_plaid.groupe_5.domain.livre;

import cat.confrerie_du_plaid.groupe_5.domain.annotations.Entity;

@Entity
public class Livre {
    private final LivreId livreId;

    public Livre(LivreId livreId) {
        this.livreId = livreId;
    }
}
