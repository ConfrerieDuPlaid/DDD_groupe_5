package cat.confrerie_du_plaid.groupe_5.domain.livre;

import cat.confrerie_du_plaid.groupe_5.domain.shared.annotations.ValueObjectId;

import java.util.Objects;

@ValueObjectId
public class LivreId{
    private final String _valeur;

    private LivreId(String valeur) {
        this._valeur = valeur;
    }

    public String valeur() {
        return _valeur;
    }

    public static LivreId depuis(String valeur) {
        return new LivreId(valeur);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LivreId livreId)) return false;
        return Objects.equals(_valeur, livreId._valeur);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(_valeur);
    }

    @Override
    public String toString() {
        return "LivreId{valeur='" + _valeur + "'}";
    }
}
