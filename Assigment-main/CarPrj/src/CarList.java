import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList; 
public class CarList extends ArrayList<Car>{ 
    BrandList brandList = new BrandList();
    CheckInput input = new CheckInput();
    Menu menu = new Menu();
    public CarList(){
    }
    public CarList(BrandList brl){
        brandList = brl;
    } 
    public Brand ReturnBrand(String brandID){
        int index = 0;
        for(int i =0; i < brandList.size(); i++){
            if(brandList.get(i).getBrandID().equals(brandID)){
                index = i;
            }
        }
        return brandList.get(index);
    }
    public void loadFromFile(String filename)throws IOException{
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        String a = "";
        while(true){
            a = br.readLine();
            if(a == null) break;
            String[] text = a.split(", ");  
            this.add(new Car(text[0], ReturnBrand(text[1]), text[2], text[3], text[4]));
        }
        fr.close();
        br.close();
    }
    public void ListAscending() throws ArrayIndexOutOfBoundsException{
        for(int i =0; i < this.size(); i++){
            for(int j = i + 1; j < this.size(); j++){
                if(this.get(i).brand.getBrandID().compareTo(this.get(j).brand.getBrandID()) > 0){
                    Car temp = this.get(j);
                    this.set(j, this.get(i));
                    this.set(i, temp);
                }
            }
        }
        for(Car c: this){
            System.out.println(c);
        }
    }
    public void ListCar(){
        String partBrandID = "";
        String partName = input.inputString("Enter a part of name brand: ");
        for(Brand br: brandList){
            if(br.getBrandName().contains(partName)){
                partBrandID = br.getBrandID();
                for(Car c: this){
                    if(c.getBrand().brandID.equals(partBrandID)){
                        System.out.println(c);
                    }
                }
            }
        }
        if(partBrandID.isEmpty()){
            System.out.println("No result");
        }
    } 
    public void RemoveCar(){
        String mcarID = input.inputString("Enter carID you want to remove: ");
        Boolean bool = false;
        for(int i =0; i < this.size(); i++){
            if(this.get(i).getCarID().equals(mcarID)){
                bool = true;
                this.remove(this.get(i));
            }
        } 
        if(bool){
            System.out.println("Remove successfully.");
        }
        else{
            System.out.println("Not found.");
        }
    }
    public void AddCar(){
        String carID = input.InputCarID(this, "Enter carID: ");
        System.out.println("Car brand you want to choose: ");
        Brand br = menu.ref_getChoice(brandList); 
        String color = input.inputString("Input color: ");
        String frameID = input.InputFrameID(this, "Enter frameID: ", "F\\d{5}");
        String engineID = input.InputEngineID(this, "Enter engineID: ", "E\\d{5}");
        add(new Car(carID, br, color, frameID, engineID));
        System.out.println("Cars have been added!");
    }
    public void SaveCar(String filename) throws IOException {
        FileWriter fw = new FileWriter(filename);
        PrintWriter pw = new PrintWriter(fw);
        for(int i = 0; i < this.size();i++){
            pw.println(this.get(i));
        }
        System.out.println("Cars have been saved!");
        fw.close();
        pw.close();
    }
    public void UpdateCar(){
        String uCarID, uFrameID, uEngineID, uColor;
        uCarID = input.inputString("Enter carID you want to update: ");
        for(Car c: this){
            if(c.getCarID().equals(uCarID)){
                System.out.println("New carBrand you want to choose: ");
                Brand br = menu.ref_getChoice(brandList); 
                uColor = input.inputString("Input color: ");
                uFrameID = input.InputFrameID(this, "Enter frameID: ", "F\\d{5}");
                uEngineID = input.InputEngineID(this, "Enter engineID: ", "E\\d{5}");
                c.setBrand(br);
                c.setColor(uColor);
                c.setFrameID(uFrameID);
                c.setEngineID(uEngineID);
                System.out.println("Brands has been updated!");
                return;
            }
        }
        System.out.println("Not found!");
    }
}
