package cat.confrerie_du_plaid.groupe_5.domain.lecture;

import cat.confrerie_du_plaid.groupe_5.domain.annotations.ValueObject;
import cat.confrerie_du_plaid.groupe_5.domain.exceptions.CommentaireInvalide;

import java.util.Objects;

@ValueObject
public class Commentaire {
    private final String contenu;

    protected Commentaire(String contenu) {
        this.contenu = contenu;
    }

    public static class SansCommentaire extends Commentaire {
        public SansCommentaire() {
            super("");
        }
    }

    public String getContenu() {
        return contenu;
    }

    public static Commentaire ecrire(String contenu) throws CommentaireInvalide {
        if(contenu == null) {
            return new SansCommentaire();
        }
        if (contenu.isBlank()) {
            throw new CommentaireInvalide("Le contenu du commentaire ne peut pas être vide");
        }
        if (contenu.split(" ").length < 5) {
            throw new CommentaireInvalide("Le contenu du commentaire doit contenir au moins 5 mots");
        }
        return new Commentaire(contenu);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Commentaire that)) return false;
        return Objects.equals(getContenu(), that.getContenu());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getContenu());
    }
}
