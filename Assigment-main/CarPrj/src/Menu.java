import java.util.ArrayList;
public class Menu extends ArrayList<String>{
    public int int_getChoice(ArrayList<Brand> options){
        CheckInput input = new CheckInput();
        int response;
        for(int i = 0; i < options.size(); i++){
            System.out.println((i+1) + "- " + options.get(i).brandID);
        }
        response = input.intputInt("Please choose an option 1.." + options.size() + ": ");
        return response;
    }
    public Brand ref_getChoice(ArrayList<Brand> options){
        int response;
        do {
            response = int_getChoice(options);
        } while (response < 0 || response > options.size());
        return options.get(response-1);
    }
}
