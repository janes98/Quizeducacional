package com.janequiz.quizeducacional.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pergunta")
public class Pergunta {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String texto;
	    
	    @ManyToOne
	    @JoinColumn(name = "quiz_id") 
	    private Quiz quiz;
	    
	    @OneToMany(mappedBy = "pergunta", cascade = CascadeType.ALL, orphanRemoval = true )
	    private List<Resposta> respostas;
	    
	    public Pergunta() {
	    	
	    }
	    public Pergunta(String texto, Quiz quiz) {
	    	this.texto = texto;
	    	this.quiz = quiz;
	    }
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getTexto() {
			return texto;
		}
		public void setTexto(String texto) {
			this.texto = texto;
		}
		public Quiz getQuiz() {
			return quiz;
		}
		public void setQuiz(Quiz quiz) {
			this.quiz = quiz;
		}
		public List<Resposta> getRespostas() {
			return respostas;
		}
		public void setRespostas(List<Resposta> respostas) {
			this.respostas = respostas;
		}
	    
	    

	    

}
