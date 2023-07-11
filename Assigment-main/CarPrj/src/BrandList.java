import java.util.ArrayList;
import java.io.*;
public class BrandList extends ArrayList<Brand>{
    CheckInput input = new CheckInput();
    public BrandList(){ 
    } 
    public void loadFromFile(String filename)throws IOException{
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        String a = "";
        while(true){
            a = br.readLine();
            if(a == null) break;
            String[] text = a.split(":");
            String[] text1 = text[0].split(", ");
            double d = Double.parseDouble(text[1]);
            add(new Brand(text1[0], text1[1], text1[2], d));
        }
        fr.close();
        br.close();
    }
    public void saveToFile(String filename) throws IOException {
        FileWriter fw = new FileWriter(filename);
        PrintWriter pw = new PrintWriter(fw);
        for(int i = 0; i < this.size();i++){
            pw.println(this.get(i));
        }
        System.out.println("Brands have been saved!");
        fw.close();
        pw.close();
    }
    public int searchID(String bID){
        for(int i  = 0; i< this.size(); i++){
            if(this.get(i).getBrandID().equals(bID)){
                return i;
            }
        }
        return -1;
    } 
    public void searchID(){
        String currentID = input.inputString("Enter brandID: ");
        if(searchID(currentID) != -1){
            System.out.println(this.get(searchID(currentID)));
        }
        else{
            System.out.println("Not found!");
        }
    }
    public void listBrands(){
        if(this.isEmpty()){
            System.out.println("List brand is empty!");
            return;
        }
        for(int i = 0; i < this.size(); i++){
            System.out.println(this.get(i));
        }
    }  
    public void addBrand(){
        String newID, newName, newSound;
        Double newPrice;
        newID = input.InputBrandId(this, "Enter brandID: ");
        newName = input.inputString("Enter brandName: ");
        newSound = input.inputString("Enter soundBrand: ");
        newPrice = input.intputDouble("Enter price: ");
        add(new Brand(newID, newName, newSound, newPrice));
        System.out.println("Brands has been added!");
    }
    public void updateBrand(){
        String currentID, updName, updSound = "";
        Double updPrice;
        currentID = input.inputString("Enter brandID: ");
        if(searchID(currentID) < 0) System.out.println("Not found!");
        else{
        updName = input.inputString("Enter brandName: ");
        updSound = input.inputString("Enter soundBrand: ");
        updPrice = input.intputDouble("Enter price: ");
        Brand br = this.get(searchID(currentID));
        br.setBrandName(updName);
        br.setSoundBrand(updSound);
        br.setPrice(updPrice);
        System.out.println("Brands has been updated!");
        }
    }
}

