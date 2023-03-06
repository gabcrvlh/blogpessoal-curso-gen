package com.gen.blogpessoal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_postagens")
public class Postagem {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank(message = "Insira o título")
        @Size(min = 1, max = 100, message = "Digite no mínimo 1 caracteres e no máximo 100.")
        private  String titulo;

        @NotBlank(message = "Insira o texto")
        @Size(min = 2, max = 1000, message = "Digite no mínimo 2 caracteres e no máximo 1000.")
        private  String texto;

        @UpdateTimestamp
        private LocalDateTime data;

        @ManyToOne
        @JsonIgnoreProperties("postagem")
        private Tema tema;

        @ManyToOne
        @JsonIgnoreProperties("postagem")
        private Usuario usuario;



        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getTitulo() {
                return titulo;
        }

        public void setTitulo(String titulo) {
                this.titulo = titulo;
        }

        public String getTexto() {
                return texto;
        }

        public void setTexto(String texto) {
                this.texto = texto;
        }

        public LocalDateTime getData() {
                return data;
        }

        public void setData(LocalDateTime data) {
                this.data = data;
        }

        public Tema getTema() {
                return tema;
        }

        public void setTema(Tema tema) {
                this.tema = tema;
        }

        public Usuario getUsuario() {
                return this.usuario;
        }

        public void setUsuario(Usuario usuario) {
                this.usuario = usuario;
        }
}
