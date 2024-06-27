package cat.confrerie_du_plaid.groupe_5.application.livre;

import cat.confrerie_du_plaid.groupe_5.application.livre.exceptions.*;
import cat.confrerie_du_plaid.groupe_5.domain.lecture.Lecture;
import cat.confrerie_du_plaid.groupe_5.domain.lecture.Lectures;
import cat.confrerie_du_plaid.groupe_5.domain.Livre;
import cat.confrerie_du_plaid.groupe_5.domain.Livres;

import java.util.Objects;
import java.util.Optional;

import static java.time.LocalDate.now;

public class PublierUneLecture {
    private final Livres livres;
    private final Lectures lectures;

    public PublierUneLecture(Livres livres, Lectures lectures) {
        this.livres = livres;
        this.lectures = lectures;
    }

    public Lecture publier(String livreId, String commentaire, Double evaluation, Integer pagesLues, Integer pagesTotales)
            throws LivreNonTrouve, CommentaireInvalide, PagesTotalesInvalide, EvaluationInvalide, PagesLuesInvalide {
        Optional<Livre> livre = livres.recupererUnLivreParSonId(livreId);
        if(livre.isEmpty()) {
            throw new LivreNonTrouve("Livre n'existe pas");
        }

        if(Objects.nonNull(commentaire) && commentaire.split(" ").length < 5)  {
            throw new CommentaireInvalide("Le contenu du commentaire ne peut pas être vide");
        }

        if(Objects.nonNull(pagesLues) && pagesLues < 0) {
            throw new PagesLuesInvalide();
        }

        if(Objects.nonNull(pagesLues) && Objects.nonNull(pagesTotales) && pagesTotales < pagesLues ) {
            throw new PagesTotalesInvalide();
        }

        if(Objects.nonNull(evaluation) && (evaluation < 0 || evaluation > 5)) {
            throw new EvaluationInvalide();
        }

        var lecture = new Lecture(
                livreId,
                now(),
                commentaire,
                evaluation,
                pagesLues,
                pagesTotales
        );
        lectures.enregistrer(lecture);

        return lecture;
    }
}
