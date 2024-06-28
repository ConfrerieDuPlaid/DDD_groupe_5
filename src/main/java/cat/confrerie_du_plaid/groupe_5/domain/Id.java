package cat.confrerie_du_plaid.groupe_5.domain;

import cat.confrerie_du_plaid.groupe_5.domain.annotations.ValueObjectId;

import java.util.Objects;

@ValueObjectId
public class Id {
    private final String _valeur;

    private Id(String valeur) {
        this._valeur = valeur;
    }

    public String valeur() {
        return _valeur;
    }

    public static Id depuis(String valeur) {
        return new Id(valeur);
    }

    public static Id generate() {
        return new Id(java.util.UUID.randomUUID().toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Id id)) return false;
        return Objects.equals(_valeur, id._valeur);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(_valeur);
    }

    @Override
    public String toString() {
        return "{valeur='" + _valeur + "'}";
    }
}
