/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.virtualeduc.tuescuelavirtual.models.DTOS;

import com.virtualeduc.tuescuelavirtual.models.Alumno;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author lenin
 */
@Setter
@Getter
public class Notawrapperporlapso implements Serializable {
    
    private Alumno alumno;
    
    private Float notalapso1;

    private Float porcentajenotalapso1;

    private Float notalapso2;

    private Float porcentajenotalapso2;
    
    private Float notalapso3;

    private Float porcentajenotalapso3;
    
    public Notawrapperporlapso(){}


}
