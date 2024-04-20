package com.pmu.mvp.domain;

import java.time.LocalDate;
import java.util.List;

public record Course(Long id, LocalDate date, Integer numero, String nom, List<Partant> partants) {
    public static class Builder {
        private Long id;
        private LocalDate date;
        private Integer numero;
        private String nom;

        private List<Partant> partants;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder date(LocalDate date) {
            this.date = date;
            return this;
        }
        public Builder numero(Integer numero) {
            this.numero = numero;
            return this;
        }
        public Builder nom(String nom) {
            this.nom = nom;
            return this;
        }

        public Builder partants(List<Partant> partants) {
            this.partants = partants;
            return this;
        }

        public Course build() {
            return new Course(id, date, numero, nom, partants);
        }
    }
}
