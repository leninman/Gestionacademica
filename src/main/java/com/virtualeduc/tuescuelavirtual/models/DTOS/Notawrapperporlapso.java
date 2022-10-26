/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.virtualeduc.tuescuelavirtual.models.DTOS;

import com.virtualeduc.tuescuelavirtual.models.Alumno;


import java.io.Serializable;
import java.util.List;

/**
 *
 * @author lenin
 */

public class Notawrapperporlapso implements Serializable {
    
    private Alumno alumno;
    
    private Float notalapso1;

    private Float porcentajenotalapso1;

    private Float notalapso2;

    private Float porcentajenotalapso2;
    
    private Float notalapso3;

    private Float porcentajenotalapso3;

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Float getNotalapso1() {
        return notalapso1;
    }

    public void setNotalapso1(Float notalapso1) {
        this.notalapso1 = notalapso1;
    }

    public Float getPorcentajenotalapso1() {
        return porcentajenotalapso1;
    }

    public void setPorcentajenotalapso1(Float porcentajenotalapso1) {
        this.porcentajenotalapso1 = porcentajenotalapso1;
    }

    public Float getNotalapso2() {
        return notalapso2;
    }

    public void setNotalapso2(Float notalapso2) {
        this.notalapso2 = notalapso2;
    }

    public Float getPorcentajenotalapso2() {
        return porcentajenotalapso2;
    }

    public void setPorcentajenotalapso2(Float porcentajenotalapso2) {
        this.porcentajenotalapso2 = porcentajenotalapso2;
    }

    public Float getNotalapso3() {
        return notalapso3;
    }

    public void setNotalapso3(Float notalapso3) {
        this.notalapso3 = notalapso3;
    }

    public Float getPorcentajenotalapso3() {
        return porcentajenotalapso3;
    }

    public void setPorcentajenotalapso3(Float porcentajenotalapso3) {
        this.porcentajenotalapso3 = porcentajenotalapso3;
    }

    public Notawrapperporlapso(){}


}
