package JavaBasics;

public class Circle1 extends Shape{
    @Override
    void draw() {
        System.out.print("cicel");
    }

    public static void main(String[] args) {
        Shape ss = new Circle1();
        ss.draw();
    }

    //In real scenario, implementation is provided by others i.e. unknown by end user

}
