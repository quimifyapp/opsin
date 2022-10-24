import com.quimify.organic.opsin.en.OpsinEN;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Quimify OPSIN EN");

        while (true) {
            String input = new Scanner(System.in).nextLine();

            OpsinEN opsinEN = new OpsinEN(input);

            if(opsinEN.isPresent())
                System.out.println(opsinEN.getSmiles());
            else System.out.println("Not found");
        }
    }

}
