package cat.confrerie_du_plaid.groupe_5.infrastructure.persistance;

import cat.confrerie_du_plaid.groupe_5.domain.Livre;
import cat.confrerie_du_plaid.groupe_5.domain.Livres;

import java.util.Optional;

public class InMemoryLivres implements Livres {
    @Override
    public Optional<Livre> recupererUnLivreParSonId(String livreId) {
        return Optional.empty();
    }
}
