package OOPS;
class Parent{
    int id =1;
     public void print()
    {
        System.out.println("parent");
    }
}
class Child extends Parent
{
    int id =0;
    @Override
   public  void print()
    {  System.out.println("child");

    }
   public  int print(int a)
    {
        System.out.println("child");
        return 0;
    }
}

public class DownCastingUpcasting {
    public static void main(String[] args) {
        Parent a = new Child();
        System.out.println(a.id);
        a.print();
    }
}
