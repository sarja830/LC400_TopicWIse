package OOPS.NestedClasses;

public class NestedClasses {
    private int y =5;
    void classInsideMethod()
    {
        //can not be accessed by  anywhere except this method
        class classInsideAMethod {
            int y;
            public void print()
            {

                System.out.println("inside a method class"+y);
            }
        }
        classInsideAMethod cim = new classInsideAMethod();
        cim.print();
    }
    public static void main(String[] args) {
        NestedClasses outer = new NestedClasses();
        NestedClasses outer1 = new NestedClasses();
        innerClass inner1 = outer1.new innerClass();
        innerClass inner = outer.new innerClass();

        outer.classInsideMethod();
        inner.setVariable(6);
        inner1.setVariable(5);
        inner.print();
        inner1.print();
    }
    class innerClass
    {
        int variable;

        void print()
        {
            System.out.println("variabe from nested inner class"+variable);
        }

        void setVariable(int x)
        {
            variable =x;
        }
    }

}
