public class Brand {
    String brandID, brandName, soundBrand;
    double price;
    public Brand(){

    }
    public Brand(String brandID, String brandName, String soundBrand, double price){
        this.brandID = brandID;
        this.brandName = brandName;
        this.soundBrand = soundBrand;
        this.price = price;
    }
    public String getBrandID(){
        return this.brandID;
    }
    public String getBrandName(){
        return this.brandName;
    }
    public String getSoundBrand(){
        return this.soundBrand;
    }
    public double getPrice(){
        return this.price;
    }
    public void setBrandID(String brandID){
        this.brandID = brandID;
    }
    public void setBrandName(String brandName){
        this.brandName = brandName;
    }
    public void setSoundBrand(String soundBrand){
        this.soundBrand = soundBrand;
    }
    public void setPrice(double price){
        this.price = price;
    }
    @Override
    public String toString(){
        return brandID + ", " + brandName + ", " + soundBrand + ": " + price;
    }
}
