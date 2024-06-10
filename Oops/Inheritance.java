public class Inheritance{
    public static void main(String args[]){
        // Fish f=new Fish("water");
        // System.out.println(f.area);
        // f.swim();
        // Calculator clc=new Calculator();
        // System.out.println(clc.sum(5,6));
        // System.out.println(clc.sum((float)5.00,(float)6.00));
        // System.out.println(clc.sum(3,7,1));
        // Sandip san=new Sandip();
        // san.name();
        Kingfisher k=new Kingfisher();
        k.talk();
        k.fly();
        System.out.println(k.color);

        Peacock p=new Peacock();
        p.talk();
        p.fly();
        p.setClr("red");
        System.out.println(p.color);

    }
}

// base class
class Animal{
    String colo;
    void eat(){
        System.out.println("Eats");
    }
    void sleep(){
        System.out.println("Sleeping");
    }
    void walk(){
        System.out.println("walking");
    }
}


// derived class
class Fish extends Animal{
    String area;

    Fish(String newarea){  // setters
        this.area=newarea;
    }
    void swim(){
        System.out.println("Generally i swim in :"+this.area);
    }
}


// method overloading
class Calculator{
    int sum(int a,int b){
        return a+b;
    }
    int sum(int a,int b,int c){
        return a+b+c;
    }
    float sum(float a,float b){
        return a+b;
    }
}


// method overriding
class Human{
    void name(){
        System.out.println("Human can speak !");
    }
}
class Sandip extends Human{
    void name(){
        System.out.println("Sandip can speak !");
    }
}


//abstract class
abstract class Birds{   // we can't make instance of this object
    String color;
    Birds(){
        this.color="blue";
    }
    abstract void fly();
    void talk(){
        System.out.println("Can talk to eachothers !");
    }
}
class Kingfisher extends Birds{
    Kingfisher(){
        this.color="reb-blue-green";
    }
    void fly(){
        System.out.println("Yes can fly");
    }
}
class Peacock extends Birds{
    void setClr(String newcolor){
        this.color=newcolor;
    }
    void fly(){
        System.out.println("No proparly");
    }
}