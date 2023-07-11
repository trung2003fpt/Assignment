import java.util.ArrayList;
import java.util.Scanner;
public class CheckInput{
    Scanner sc = new Scanner(System.in);
    public String inputString(String msg) {
        String a;
        do {
            System.out.print(msg);
            a = sc.nextLine().trim();
        } while (a.length() == 0 || a == null);
        return a;
    }
    public String inputPattern(String msg, String pattern){
        String data;
        do {
            System.out.print(msg);
            data = sc.nextLine().trim();
        } while (!data.matches(pattern));
        return data;
    }
    public int intputInt(String msg){
        int num = 0;
        do {
            try{
                System.out.print(msg);
                num = Integer.parseInt(sc.nextLine());
            }
            catch(NumberFormatException e){
                System.out.println("The input value must be a number, please enter again!");
            }
        } while(num <= 0);
        return num;
    }
    public Double intputDouble(String msg){
        double num = 0;
        do {
            try{
                System.out.print(msg);
                num = Double.parseDouble(sc.nextLine());
            }
            catch(NumberFormatException e){
                System.out.println("The input value must be a number, please enter again!");
            }
        } while(num <= 0);
        return num;
    } 
    public boolean duplicatedCar(ArrayList<Car> arr, String carID){
        for (Car c : arr) {
            if (c.getCarID().equals(carID)){
                return true;
            }
        }
        return false;
    }
    public boolean duplicatedBrand(ArrayList<Brand> arr, String brandID){
        for (Brand c : arr) {
            if (c.getBrandID().equals(brandID)){
                return true;
            }
        }
        return false;
    }
    public boolean duplicatedFrameID(ArrayList<Car> arr, String FrameID) {
        for (Car a : arr) {
            if (a.getFrameID().equals(FrameID)){
                return true;
            }
        }
        return false;
    }
    public boolean duplicatedEngineID(ArrayList<Car> arr, String EngineID) {
        for (Car a : arr) {
            if (a.getEngineID().equals(EngineID)){
                return true;
            }
        }
        return false;
    }
    public String InputBrandId(ArrayList<Brand> list, String msg){
        while(true){
            String BrandId = inputString(msg);
            if(duplicatedBrand(list, BrandId)){
                System.out.println("BrandID existed, please enter again!");
                continue;
            } 
            return BrandId;
        }    
    }
    public String InputCarID(ArrayList<Car> list, String msg){
        while(true){
            String CarID = inputString(msg);
            if(duplicatedCar(list, CarID)){
                System.out.println("CarID existed, please enter again!");
                continue;
            } 
            return CarID;
        }    
    }
    public String InputFrameID(ArrayList<Car>list, String msg, String pattern){
        while(true){
            String FrameID = inputString(msg);
            if(!FrameID.matches(pattern)){
                System.out.println("FrameID must be like format(F00000)");
                continue;
            }
            if(duplicatedFrameID(list,FrameID)){
                System.out.println("FrameID existed, please enter again!");
                continue;
            }
            return FrameID;
        }
    }
    public String InputEngineID(ArrayList<Car>list, String msg, String pattern){
        while(true){
            String engineID = inputString(msg);
            if(!engineID.matches(pattern)){
                System.out.println("EngineID must be like format(E00000)");
                continue;
            }
            if(duplicatedEngineID(list,engineID)){
                System.out.println("EngineID existed, please enter again!");
                continue;
            }
            return engineID;
        }
    }
}
