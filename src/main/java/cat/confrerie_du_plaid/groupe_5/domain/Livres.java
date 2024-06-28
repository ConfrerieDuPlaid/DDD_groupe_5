package cat.confrerie_du_plaid.groupe_5.domain;

import cat.confrerie_du_plaid.groupe_5.domain.livre.Livre;

import java.util.Optional;

public interface Livres {
    Optional<Livre> recupererUnLivreParSonId(String livreId);
}
