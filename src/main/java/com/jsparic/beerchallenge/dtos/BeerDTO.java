package com.jsparic.beerchallenge.dtos;

public class BeerDTO {
    private long id;
    private String name;
    private String description;
    private float mash_temp_mean;

    public BeerDTO (long id, String name, String description, int[] mash_temps){
        this.id = id;
        this.name = name;
        this.description = description;
        long sum = 0;
        for(int i = 0; i < mash_temps.length; i++){
            sum = sum + mash_temps[i];
        }
        if (mash_temps.length > 0){
            this.mash_temp_mean = sum / mash_temps.length;
        }

    }

    public long getId() { return id;}

    public String getName(){ return name; }

    public String getDescription(){ return description;}

    public float getMash_temp_mean(){ return this.mash_temp_mean; }

    @Override
    public String toString(){
        return "{id=" + id +
                ", name='" + name + "'" +
                ", description=" + description + "'" +
                ", mash_temp_mean=" + mash_temp_mean;
    }


}
