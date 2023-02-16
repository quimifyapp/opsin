import com.quimify.organic.opsin.OpsinEnglish;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Quimify OPSIN English");

        while (true) {
            System.out.print("Name: ");

            String input = new Scanner(System.in).nextLine();

            OpsinEnglish opsinEN = new OpsinEnglish(input);

            if(opsinEN.isPresent())
                System.out.println(opsinEN.getSmiles());
            else System.out.println("Not found");
        }
    }

}
