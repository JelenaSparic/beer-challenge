package com.jsparic.beerchallenge.entities;

import javax.persistence.*;

@Entity
@Table(name="BEER")
public class Beer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String description;
    private int[] mash_temp;

    public  long getId() { return id; }

    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }

    public String getDescription(){ return description;}
    public void setDescription(String description){ this.description = description; }

    public int[] getMash_temp(){ return  mash_temp; }
    public void setMash_temp(int[] mash_temps){
        int n = mash_temps.length;
        this.mash_temp = new int[n];
        for (int i = 0; i < n; i++){
            this.mash_temp[i] = mash_temps[i];
        }
    }

    @Override
    public String toString(){
        int n = mash_temp.length;
        String mash_temp_string = "";
        for (int i = 0; i < n; i++) {
            mash_temp_string = mash_temp_string + mash_temp[i];
            if (i < n - 1) { mash_temp_string = mash_temp_string + ", "; }
        }
        return "{id=" + id +
                ", name='" + name + "'" +
                ", description='" + description + "'" +
                ", mash_temp=[" + mash_temp_string + "]";
    }
}

