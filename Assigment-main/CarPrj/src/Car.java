public class Car {
    String carID, brandID, color, frameID, engineID;
    Brand brand;
    public Car(){
    }
    public Car(String carID, Brand brand, String color, String frameID, String engineID){
        this.carID = carID;
        this.brand = brand;
        this.color = color;
        this.frameID = frameID;
        this.engineID = engineID;
    }
    public String getCarID(){
        return this.carID;
    }
    public Brand getBrand(){
        return this.brand;
    }
    public String getColor(){
        return this.color;
    }
    public String getFrameID(){
        return this.frameID;
    }
    public String getEngineID(){
        return this.engineID;
    }
    public void setCarID(String carID){
        this.carID = carID;
    }
    public void setBrand(Brand brand){
        this.brand = brand;
    }
    public void setColor(String color){
        this.color = color;
    }
    public void setFrameID(String frameID){
        this.frameID = frameID;
    }
    public void setEngineID(String engineID){
        this.engineID = engineID;
    }
    @Override
    public String toString(){
        return carID + ", " + brand.getBrandID() + ", " + color + ", " + frameID + ", " + engineID;
    }
    public int comparedTo(Car c){
        if(this.brand.brandName.compareTo(c.brand.brandName) != 0){
            return this.brand.brandName.compareTo(c.brand.brandName);
        }
        return this.carID.compareTo(c.carID); 
    }
}
