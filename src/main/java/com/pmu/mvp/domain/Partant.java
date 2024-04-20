package com.pmu.mvp.domain;


public record Partant(Long id, Integer numero, String nom) {
    public static class Builder {
        private Long id;
        private Integer numero;
        private String nom;

        public Builder id(Long id) {
            this.id = id;
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

        public Partant build() {
            return new Partant(id, numero, nom);
        }
    }
}
