package cat.confrerie_du_plaid.groupe_5.domain;

import java.time.LocalDate;

public class Publication {
    String livreId;
    LocalDate now;
    String commentaire;
    Double evaluation;

    public Publication(String livreId, LocalDate now, String commentaire, Double evaluation) {
        this.livreId = livreId;
        this.now = now;
        this.commentaire = commentaire;
        this.evaluation = evaluation;
    }
}
