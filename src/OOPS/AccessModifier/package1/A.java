package OOPS.AccessModifier.package1;

public class A {
    private int a;
    protected void display()
    {
        System.out.println("protected access modifier can be used with subclasses and within the package");
    }
    public  void displayPublicVariable()
    {
        System.out.println("public access modifier can be accessed anywhere");
    }
    private void displayPrivateVariable()
    {
        System.out.println("protected access modifier can be used with subclasses and within the package");
    }
}
