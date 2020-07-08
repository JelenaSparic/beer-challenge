package com.jsparic.beerchallenge.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PunkapiBeer {
    private Long id;
    private String name;
    private String description;
    private Method method;

    public Long getId() {
        return this.id;
    }
    public void setId(Long id) { this.id = id; }

    public String getName() {
        return this.name;
    }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return this.description; }
    public void setDescription(String description) { this.description = description; }

    public Method getMethod() { return this.method;}
    public void setMethod(Method method) { this.method = method; }

    public int[] getTemps(){
        int n = this.method.mash_temp.length;
        int[] temps = new int[n];
        for(int i = 0; i < n; i++){
            temps[i] = this.method.mash_temp[i].temp.value;
        }
        return temps;
    }

    static class Method {
        private Mash_temp[] mash_temp;

        public Mash_temp[] getMash_temp(){ return this.mash_temp; }
        public void setMash_temp(Mash_temp[] mash_temps){
            int n = mash_temps.length;
            this.mash_temp = new Mash_temp[n];
            for (int i = 0; i < n; i++){
                this.mash_temp[i] = mash_temps[i];
            }
        }

        static class Mash_temp {
            private Temp temp;

            public Temp getTemp() {
                return this.temp;
            }
            public void setTemp(Temp temp) { this.temp = temp; }

            static class Temp {
                private int value;

                public int getValue() {
                    return this.value;
                }
                public void setValue(int value) { this.value = value; }
            }

        }

    }

}
