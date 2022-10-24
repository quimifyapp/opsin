import com.quimify.organic.opsin.es.OpsinES;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Quimify OPSIN ES");

        while (true) {
            String input = new Scanner(System.in).nextLine();

            OpsinES opsinES = new OpsinES(input);

            if(opsinES.isPresent())
                System.out.println(opsinES.getSmiles());
            else System.out.println("Not found");
        }
    }

}