import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Basicuse {
    public static void main(String[] args) {
        HashMap<String,Integer> hm=new HashMap<>();
        hm.put("India",21);
        hm.put("usa",22);
        System.out.println(hm);
        Set<String> sett=hm.keySet();
        for (String k: sett){
            System.out.println("The key is :"+k+",value is "+hm.get(k));
        }
    }
}
