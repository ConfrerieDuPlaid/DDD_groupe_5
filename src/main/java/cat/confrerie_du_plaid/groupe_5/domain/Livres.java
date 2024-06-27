package cat.confrerie_du_plaid.groupe_5.domain;

import java.util.Optional;

public interface Livres {
    Optional<Livre> recupererUnLivreParSonId(String livreId);
}
