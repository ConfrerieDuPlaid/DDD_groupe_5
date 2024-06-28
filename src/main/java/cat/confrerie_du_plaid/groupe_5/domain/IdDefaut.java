package cat.confrerie_du_plaid.groupe_5.domain;

import cat.confrerie_du_plaid.groupe_5.domain.annotations.ValueObjectId;

import java.util.Objects;

@ValueObjectId
public class IdDefaut {
    private final String _valeur;

    private IdDefaut(String valeur) {
        this._valeur = valeur;
    }

    public String valeur() {
        return _valeur;
    }

    public static IdDefaut depuis(String valeur) {
        return new IdDefaut(valeur);
    }

    public static IdDefaut generate() {
        return new IdDefaut(java.util.UUID.randomUUID().toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IdDefaut idDefaut)) return false;
        return Objects.equals(_valeur, idDefaut._valeur);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(_valeur);
    }

    @Override
    public String toString() {
        return "{ valeur='" + _valeur + "'}";
    }
}
