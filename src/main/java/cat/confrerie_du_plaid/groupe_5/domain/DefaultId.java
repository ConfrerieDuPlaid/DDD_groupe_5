package cat.confrerie_du_plaid.groupe_5.domain;

import java.util.Objects;

@ValueObjectId
public class DefaultId {
    private final String _value;

    private DefaultId(String value) {
        this._value = value;
    }

    public String value() {
        return _value;
    }

    public static DefaultId from(String value) {
        return new DefaultId(value);
    }

    public static DefaultId generate() {
        return new DefaultId(java.util.UUID.randomUUID().toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DefaultId lectureId)) return false;
        return Objects.equals(_value, lectureId._value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(_value);
    }

    @Override
    public String toString() {
        return "LectureId{ value='" + _value + "'}";
    }
}
