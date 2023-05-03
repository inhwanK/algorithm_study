package algorithm_study.exam;

public class Ex {
    /*public static void main(String args[]) {
        StringBuilder sb1 = new StringBuilder("123");
        sb1.append("abc");
        String s1 = "123";
        s1 = s1.concat("abc");
        System.out.println(sb1 + " " + s1);
    }*/

    /*public static void main(String[] args) {
        Integer x = 400;
        Integer y = x;
        x++;
        StringBuilder sb1 = new StringBuilder("123");
        StringBuilder sb2 = sb1;
        sb1.append("5");
        System.out.println((x == y) + " " + (sb1 == sb2));
    }*/

    /*public static void main(String[] args) {
        Animal animal = new Dog();
        Cat cat = (Cat) animal;
        System.out.println("이까진 되는지?");
        System.out.println(cat.noise());
    }*/

    /*public static void main(String[] args) {
        int x = 5;
        Ex p = new Ex();
        p.doStuff(x);
        System.out.print(" main x = " + x);
    }*/

    void doStuff(int x) {
        System.out.print(" doStuff x = " + x++);
    }
}

class Animal {
    public String noise() {
        return "peep";
    }
}

class Dog extends Animal {
    public String noise() {
        return "bark";
    }

}

class Cat extends Animal {
    public String noise() {
        return "meow";
    }
}