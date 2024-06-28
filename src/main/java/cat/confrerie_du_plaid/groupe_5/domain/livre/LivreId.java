package cat.confrerie_du_plaid.groupe_5.domain.livre;

import cat.confrerie_du_plaid.groupe_5.domain.DefaultId;
import cat.confrerie_du_plaid.groupe_5.domain.ValueObjectId;

import java.util.Objects;

@ValueObjectId
public class LivreId{
    private final String _value;

    private LivreId(String value) {
        this._value = value;
    }

    public String value() {
        return _value;
    }

    public static LivreId from(String value) {
        return new LivreId(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LivreId livreId)) return false;
        return Objects.equals(_value, livreId._value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(_value);
    }

    @Override
    public String toString() {
        return "LivreId{value='" + _value + "'}";
    }
}
