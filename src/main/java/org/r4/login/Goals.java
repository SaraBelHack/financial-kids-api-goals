package org.r4.login;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import java.util.Random;
import java.util.List;


@Entity
@Schema (description = "Clase Goals")
public class Goals extends PanacheEntity {

    public Long id;
    public String descripcion;
    public int puntos;

    public static List<Goals> todasGoals(){
        return  listAll();
    }

    public Goals(String descripcion, int puntos){
         this.descripcion = descripcion;
         this.puntos = puntos;
    }

    public Goals(){}

    @Override
    public String toString() {
        return "Goals{" +
            "id='" + id.toString() + "\'" +
            ",descripcion='" + descripcion + "\'" +
            ", puntos='" + puntos +
            '}';
    }

    public String getDescripcion(){
        return this.descripcion;
    }

    public int getPuntos(){
        return  this.puntos;
    }

    public Long getId(){
        return this.id;
    }

    /*
    public static Login findUser(){
        return findAll();
    }
    */

    /*
    public static Hero findRandom() {
        long countHeroes = Hero.count();
        Random random = new Random();
        int randomHero = random.nextInt((int) countHeroes);
        return Hero.findAll().page(randomHero, 1).firstResult();
    }
    */
}