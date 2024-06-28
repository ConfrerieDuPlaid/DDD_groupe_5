package cat.confrerie_du_plaid.groupe_5.domain.livre;

import cat.confrerie_du_plaid.groupe_5.domain.shared.annotations.Entity;

import java.util.Objects;

@Entity
public class Livre {
    private final LivreId livreId;

    public Livre(LivreId livreId) {
        this.livreId = livreId;
    }

    public LivreId id() {
        return livreId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Livre livre)) return false;
        return Objects.equals(livreId, livre.livreId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(livreId);
    }
}
