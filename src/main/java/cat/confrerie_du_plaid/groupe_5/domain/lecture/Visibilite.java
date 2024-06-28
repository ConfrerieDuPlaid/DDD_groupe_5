package cat.confrerie_du_plaid.groupe_5.domain.lecture;

import java.util.Objects;

public enum Visibilite {
    PUBLIC,
    AMIS,
    PERSONNEL;

    public static Visibilite depuis(String visibilite) throws VisibiliteInvalide {
        return switch (Objects.requireNonNullElse(visibilite, "").toUpperCase()) {
            case "PUBLIC" -> Visibilite.PUBLIC;
            case "AMIS" -> Visibilite.AMIS;
            case "PERSONNEL" -> Visibilite.PERSONNEL;
            default -> throw new VisibiliteInvalide("Visibilite inconnue : " + visibilite);
        };
    }
}
