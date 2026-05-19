package org.sebsy.grasps.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Entité représentant une réservation.
 */
@Entity
public class Reservation {

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    @Id
    private Long id;

    private LocalDateTime date;

    private int nbPlaces;

    private double total;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENT")
    private Client client;

    public Reservation() {
    }

    public Reservation(LocalDateTime date) {
        this.date = date;
    }

    /**
    * Calcule le montant total de la réservation en fonction du nombre de places et du type de réservation.
     *
     * @param type le type de réservation portant les informations tarifaires
     */
    public void calculerTotal(TypeReservation type) {
        double montantBrut = type.getMontant() * nbPlaces;

        if (client != null && client.isPremium()) {
            montantBrut = montantBrut * (1 - type.getReductionPourcent() / 100.0);
        }

        this.total = montantBrut;
    }

    /**
     * Fabrique une {@link Reservation} à partir d'une date au format {@code dd/MM/yyyy HH:mm:ss}.
     *
     * @param dateStr date au format String
     * @return nouvelle instance de Reservation
     */
    public static Reservation fromDateString(String dateStr) {
        LocalDateTime date = LocalDateTime.parse(dateStr, FORMATTER);
        return new Reservation(date);
    }

    // -------------------------------------------------------------------------
    // Getters / Setters
    // -------------------------------------------------------------------------

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getNbPlaces() {
        return nbPlaces;
    }

    public void setNbPlaces(int nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}