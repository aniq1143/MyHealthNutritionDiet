package com.example.myhealthnutritiondiet;

public class Data{
   private  String date, angiogenesis1, regeneration1, microbiome1,immunity1,dna1;
   public Data(String date, String regeneration1, String microbiome1, String immunity1, String dna1){

       this.date = date;
       this.angiogenesis1 = angiogenesis1;
       this.regeneration1 = regeneration1;
       this.microbiome1 = microbiome1;
       this.immunity1 = immunity1;
       this.dna1 = dna1;

   }

    public Data() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAngiogenesis1() {
        return angiogenesis1;
    }

    public void setAngiogenesis1(String angiogenesis1) {
        this.angiogenesis1 = angiogenesis1;
    }

    public String getRegeneration1() {
        return regeneration1;
    }

    public void setRegeneration1(String regeneration1){
        this.regeneration1= regeneration1;
    }

    public String getMicrobiome1() {
        return microbiome1;
    }

    public void setMicrobiome1(String microbiome1) {
        this.microbiome1 = microbiome1;
    }

    public String getImmunity1() {
        return immunity1;
    }

    public void setImmunity1(String immunity1) {
        this.immunity1 = immunity1;
    }

    public String getDna1() {
        return dna1;
    }

    public void setDna1(String dna1) {
        this.dna1 = dna1;
    }
}
