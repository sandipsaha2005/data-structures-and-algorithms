import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class FIlehand {
    public static void main(String[] args) {
        try {
            File obj=new File("exampe.txt");

            FileWriter writer=new FileWriter(obj);
            writer.write("Hey i'm sandip");
            writer.write("Saha");
            writer.close();
            
            Scanner sc=new Scanner(obj);
            while (sc.hasNextLine()) {
                String data=sc.nextLine();
                System.out.println(data);
                
            }
            sc.close();

        } catch (Exception e) {

        }

    }

}
