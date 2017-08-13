/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author rohan
 */
public class AlphaModel {
    private String alpha;
    private ArrayList family;
    private ArrayList categories;
   

   
    public ArrayList getCategories() {
        return categories;
    }

    public void setCategories(ArrayList categories) {
        this.categories = categories;
    }

    public String getAlpha() {
        return alpha;
    }

    public void setAlpha(String alpha) {
        this.alpha = alpha;
    }

    public ArrayList getFamily() {
        return family;
    }

    public void setFamily(ArrayList family) {
        this.family = family;
    }
    
}
