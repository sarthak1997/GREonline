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
public class userCatModel {
    private String userID;
    private ArrayList synonym,meaning;
    private int category;

   
    
    public ArrayList getSynonym() {
        return synonym;
    }

    public void setSynonym(ArrayList synonym) {
        this.synonym = synonym;
    }

    public ArrayList getMeaning() {
        return meaning;
    }

    public void setMeaning(ArrayList meaning) {
        this.meaning = meaning;
    }
  
    
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
    
    
}
