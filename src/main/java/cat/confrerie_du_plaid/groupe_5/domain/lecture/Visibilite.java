package cat.confrerie_du_plaid.groupe_5.domain.lecture;

import cat.confrerie_du_plaid.groupe_5.domain.shared.annotations.ValueObject;
import cat.confrerie_du_plaid.groupe_5.domain.shared.exceptions.VisibiliteInvalide;

import java.util.Objects;

@ValueObject
public enum Visibilite {
    PUBLIQUE,
    AMIS,
    PERSONNELLE;

    public static Visibilite depuis(String visibilite) throws VisibiliteInvalide {
        return switch (Objects.requireNonNullElse(visibilite, "").toUpperCase()) {
            case "PUBLIQUE" -> Visibilite.PUBLIQUE;
            case "AMIS" -> Visibilite.AMIS;
            case "PERSONNELLE" -> Visibilite.PERSONNELLE;
            default -> throw new VisibiliteInvalide("Visibilite inconnue : " + visibilite);
        };
    }
}
