package cat.confrerie_du_plaid.groupe_5.domain;

import java.time.LocalDate;

public class Publication {
    private String livreId;
    private LocalDate now;
    private String commentaire;
    private Double evaluation;
    private Integer pagesLues;
    private Integer pagesTotales;

    public Publication(String livreId, LocalDate now, String commentaire, Double evaluation, Integer pagesLues, Integer pagesTotales) {
        this.livreId = livreId;
        this.now = now;
        this.commentaire = commentaire;
        this.evaluation = evaluation;
        this.pagesLues = pagesLues;
        this.pagesTotales = pagesTotales;
    }
}
