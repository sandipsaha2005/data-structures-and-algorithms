public class Oops{

    public static void main(String args[]){
        // Pen p1=new Pen();
        // p1.setClr("Blue");
        // p1.setPrice(100);
        // System.out.println(p1.getClr() + " "+ p1.getPrice());
        
        // BankdAcc myAcc=new BankdAcc();
        // myAcc.username="sandip";
        // myAcc.setPass("sandip@123");
        // System.out.println(myAcc.username);
        // myAcc.displayPass();

        Student s1=new Student("Sandip","Kolkata",12);
        s1.showDetails();
        Student s2=new Student(s1);
        s2.roll=21;
        s2.showDetails();

    }
}
class Student{
    String name;
    String city;
    int roll;



    // shallow copy
    // Student (Student user){
    //     this.name=user.name;
    //     this.city=user.city;
    // }


    // deep copy
    Student (Student user){
        this.name=user.name;
    }
    Student(String name,String city,int roll){
        this.name=name;
        this.city=city;
        this.roll=roll;
    }
    void showDetails(){
        System.out.println("Name :"+this.name);
        System.out.println("Roll :"+this.roll);
        System.out.println("City :"+this.city);
    }
}

class BankdAcc{
    public String username;
    private String password;
    void setPass(String pass){
        this.password=pass;
    }
    void displayPass(){
        System.out.print(this.password);
    }
}


class Pen{
    private String color;
    private int price;

    void setClr(String newColor){   // setters
        this.color=newColor;
    }

    String getClr(){    // getters
        return this.color;
    }

    int getPrice(){  // getters
        return this.price;
    }

    void setPrice(int newprice){   // setters
        this.price=newprice;
    }

}