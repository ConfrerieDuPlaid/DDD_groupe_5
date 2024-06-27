package cat.confrerie_du_plaid.groupe_5.domain;

public class Commentaire {
    private String contenu;

    private Commentaire(String contenu) {
        this.contenu = contenu;
    }

    public String getContenu() {
        return contenu;
    }

    public static Commentaire ecrireCommentaire(String contenu) {
        if (contenu == null || contenu.isEmpty()) {
            throw new IllegalArgumentException("Le contenu du commentaire ne peut pas être vide");
        }
        if (contenu.split(" ").length < 5) {
            throw new IllegalArgumentException("Le contenu du commentaire doit contenir au moins 5 mots");
        }
        return new Commentaire(contenu);
    }
}
