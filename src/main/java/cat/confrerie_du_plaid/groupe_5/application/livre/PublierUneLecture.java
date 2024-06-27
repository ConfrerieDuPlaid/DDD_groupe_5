package cat.confrerie_du_plaid.groupe_5.application.livre;

import cat.confrerie_du_plaid.groupe_5.domain.Livre;
import cat.confrerie_du_plaid.groupe_5.domain.Livres;
import cat.confrerie_du_plaid.groupe_5.domain.Publication;
import cat.confrerie_du_plaid.groupe_5.domain.Publications;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

public class PublierUneLecture {
    private final Livres livres;
    private final Publications publications;

    public PublierUneLecture(Livres livres, Publications publications) {
        this.livres = livres;
        this.publications = publications;
    }

    public Publication publier(String livreId, LocalDate dateDePublication, String commentaire, Double evaluation)
            throws LivreNonTrouve, CommentaireInvalide {
        Optional<Livre> livre = livres.recupererUnLivreParSonId(livreId);
        if(livre.isEmpty()) {
            throw new LivreNonTrouve("Livre n'existe pas");
        }

        if(Objects.nonNull(commentaire) && commentaire.split(" ").length < 5)  {
            throw new CommentaireInvalide();
        }

        var publication = new Publication();
        publications.enregistrer(publication);

        return publication;
    }
}
