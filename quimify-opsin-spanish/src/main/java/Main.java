import com.quimify.organic.opsin.OpsinSpanish;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Quimify OPSIN Spanish");

        while (true) {
            System.out.print("Name: ");

            String input = new Scanner(System.in).nextLine();

            OpsinSpanish opsinSpanish = new OpsinSpanish(input);

            if(opsinSpanish.isPresent())
                System.out.println(opsinSpanish.getSmiles());
            else System.out.println("Not found");
        }
    }

}