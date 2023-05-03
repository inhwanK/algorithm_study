package algorithm_study.exam;

public class Atom {
    public Atom() {
        System.out.print("atom ");
    }
}

class Rock extends Atom {
    public Rock(String type) {
        System.out.print(type);
    }
}

class Line {
    public class Point {
        public int x, y;
    }

    public Point getPoint() {
        return new Point();
    }
}

class Triangle {
    public Triangle() {
//        Line.Point p = Line.
        // insert code here
    }
}

class Mountain extends Rock {
    Mountain() {
        super("granite ");
        new Rock("granite ");
    }

    public static void main(String[] a) {
        new Mountain();
    }
}
