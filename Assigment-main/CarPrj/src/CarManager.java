import java.io.IOException;
public class CarManager {
    public static void main(String[] args) throws IOException {
        Menu ops = new Menu(); 
        CheckInput input = new CheckInput();
        ops.add("List all brands");
        ops.add("Add a new brand");
        ops.add("Search a brand based on its ID");
        ops.add("Update a brand");
        ops.add("Save brands to the file, named brands.txt");
        ops.add("List all cars in ascending order of brand names");
        ops.add("List cars based on a part of an input brand name");
        ops.add("Add a car");
        ops.add("Remove a car based on its ID");
        ops.add("Update a car based on its ID");
        ops.add("Save cars to file, named cars.txt");
        BrandList brandL = new BrandList();
        CarList cList = new CarList(brandL);
        brandL.loadFromFile("brands.txt"); 
        cList.loadFromFile("cars.txt");
        int choice = 0;
        do {
            System.out.println();
            for(int i = 0; i < ops.size(); i++){
                System.out.println((i+1) + "- " + ops.get(i));
            }
            choice = input.intputInt("Please choose an option 1.." + ops.size() + ": "); 
            switch (choice) {
                case 1:
                    brandL.listBrands();
                    break;
                case 2:
                    brandL.addBrand();
                    break;
                case 3:
                    brandL.searchID();
                    break;
                case 4:
                    brandL.updateBrand();
                    break;
                case 5:
                    brandL.saveToFile("brands.txt");
                    break;   
                case 6:
                    cList.ListAscending();
                    break;
                case 7:
                    cList.ListCar();
                    break;
                case 8:
                    cList.AddCar();
                    break;
                case 9:
                    cList.RemoveCar();
                    break;
                case 10:
                    cList.UpdateCar();
                    break;
                case 11:
                    cList.SaveCar("cars.txt");
                    break;
                default:
                    System.out.println("Bye!");
                    break;
            }
        } while (choice > 0 && choice < 12);
    }
}
