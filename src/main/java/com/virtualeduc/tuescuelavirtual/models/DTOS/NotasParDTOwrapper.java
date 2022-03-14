/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.virtualeduc.tuescuelavirtual.models.DTOS;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author lenin
 */
public class NotasParDTOwrapper implements Serializable {
    
    
    public List<NotasParDTO> notasParDTOlist;

    public List<NotasParDTO> getNotasParDTOlist() {
        return notasParDTOlist;
    }

    public void setNotasParDTOlist(List<NotasParDTO> notasParDTOlist) {
        this.notasParDTOlist = notasParDTOlist;
    }
    
    
    
}
