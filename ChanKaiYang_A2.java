//Full Name: Chan Kai Yang
//Full Time
//Student no: 7372711
//Tutorial group: T03
//Declaration: This is my own work and I did not pass this program to anyone
//File Name: ChanKaiYang_A2.java

import java.util.ArrayList;
import java.util.Random;

enum ShapeColor {Blue, Yellow, Red, Green, White}

interface ForTwoD
{
    public double perimeter ();

    public void recolor (ShapeColor sc);
}

interface Shape
{
    public double area ();
}

interface ForThreeD
{
    public double volume ();

    public void resize (double percentage);
}

abstract class TwoD implements ForTwoD, Shape
{
    protected ShapeColor sc;
    protected int a;
    protected int b;
    protected int c;
    protected int d;

    public TwoD ()
    {

    }

    //b = 0
    public TwoD (ShapeColor sc, int a)
    {
        this.sc = sc;
        this.a = a;
    }

    //c = 0
    public TwoD (ShapeColor sc, int a, int b)
    {
        this(sc, a);
        this.b = b;
    }

    //d = 0
    public TwoD (ShapeColor sc, int a, int b, int c)
    {
        this(sc, a, b);
        this.c = c;
    }

    public TwoD (ShapeColor sc, int a, int b, int c, int d)
    {
        this(sc, a, b, c);
        this.d = d;
    }

    //Copy Constructor
    public TwoD (TwoD td)
    {
        this (td.sc, td.a, td.b, td.c, td.d);
    }

    public int getA ()
    {
        return a;
    }

    public int getB ()
    {
        return b;
    }

    public int getC ()
    {
        return c;
    }

    public int getD ()
    {
        return d;
    }

    public ShapeColor getShapeColor ()
    {
        return sc;
    }

    public void set (ShapeColor sc, int a)
    {
        this.sc = sc;
        this.a = a;
    }

    public void set (ShapeColor sc, int a, int b)
    {
        this.sc = sc;
        this.a = a;
        this.b = b;
    }

    public void set (ShapeColor sc, int a, int b, int c)
    {
        this.sc = sc;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void set (ShapeColor sc, int a, int b, int c, int d)
    {
        this.sc = sc;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public void recolor (ShapeColor sc)
    {
        this.sc = sc;
    }

    @Override
    public String toString ()
    {
        if (b == 0)
            return String.format ("2D (%s, %d)", sc, a);
        else if (c == 0)
            return String.format ("2D (%s, %d, %d)", sc, a, b);
        else if (d == 0)
            return String.format ("2D (%s, %d, %d, %d)", sc, a, b, c);
        else
            return String.format ("2D (%s, %d, %d, %d, %d)", sc, a, b, c, d);
    } 
}

class Circle extends TwoD
{
    public Circle ()
    {

    }

    public Circle (ShapeColor sc, int radius)
    {
        super(sc, radius);
    }

    public Circle (Circle c)
    {
        this(c.sc, c.a);
    }

    @Override
    public double area ()
    {
		return Math.PI * a * a;
    }

    @Override
    public double perimeter ()
    {
		return 2.0 * Math.PI * a;
    }

    public int getRadius ()
    {
        return a;
    }

    public void set (ShapeColor sc, int radius)
    {
        super.set(sc, radius);
    }

    @Override
    public String toString ()
    {
        return String.format("Circle (%s)", super.toString());
    }
}

class Rectangle extends TwoD
{
    public Rectangle ()
    {

    }

    public Rectangle (ShapeColor sc, int length, int width)
    {
        super (sc, length, width);
    }

    public Rectangle (Rectangle r)
    {
        this(r.sc, r.a, r.b);
    }

    @Override
    public double area ()
    {
        return 1.0 * a * b;
    }

    @Override
    public double perimeter ()
    {
        return 2.0 * (a + b);
    }

    public int getLength ()
    {
        return a;
    }

    public int getWidth ()
    {
        return b;
    }

    public void set (ShapeColor sc, int length, int width)
    {
        super.set(sc, length, width);
    }

    @Override
    public String toString ()
    {
        return String.format ("Rectangle (%s)", super.toString());
    }
}

class Triangle extends TwoD
{
    public Triangle ()
    {

    }

    public Triangle (ShapeColor sc, int a, int b, int c)
    {
        super(sc, a, b, c);
    }

    public Triangle (Triangle t)
    {
        this(t.sc, t.a, t.b, t.c);
    }

    @Override
    public double area ()
    {
        double s = (a + b + c) / 2.0;

		return Math.sqrt (s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double perimeter ()
    {
		return a + b + c;
    }

    @Override
    public int getA ()
    {
        return a;
    }

    @Override
    public int getB ()
    {
        return b;
    }

    @Override
    public int getC ()
    {
        return c;
    }

    public void set (ShapeColor sc, int a, int b, int c)
    {
        super.set(sc, a, b, c);
    }

    @Override
    public String toString ()
    {
        return String.format ("Triangle (%s)", super.toString());
    }
}

class Trapezoid extends TwoD
{
    private int h;

    public Trapezoid ()
    {

    }

    public Trapezoid (ShapeColor sc, int a, int b, int c, int d, int h)
    {
        super(sc, a, b, c, d);
        this.h = h;
    }

    public Trapezoid (Trapezoid t)
    {
        this(t.sc, t.a, t.b, t.c, t.d, t.h);
    }

    @Override
    public double area ()
    {
        return ((a + b) / 2.0) * h;
    }

    @Override
    public double perimeter ()
    {
        return a + b + c + d;
    }

    @Override
    public int getA ()
    {
        return a;
    }

    @Override
    public int getB ()
    {
        return b;
    }

    @Override
    public int getC ()
    {
        return c;
    }

    @Override
    public int getD ()
    {
        return d;
    }

    public int getHeight ()
    {
        return h;
    }

    public void set (ShapeColor sc, int a, int b, int c, int d, int h)
    {
        super.set(sc, a, b, c, d);
        this.h = h;
    }

    @Override
    public String toString ()
    {
        return String.format ("Trapezoid (%s, %d)", super.toString(), h);
    }
}

abstract class ThreeD implements Shape, ForThreeD
{
    protected ShapeColor sc;
    protected double a;

    public ThreeD ()
    {

    }

    public ThreeD (ShapeColor sc, double a)
    {
        this.sc = sc;
        this.a = a;
    }

    public ThreeD (ThreeD td)
    {
        this(td.sc, td.a);
    }

    public double getA ()
    {
        return a;
    }

    public void set (ShapeColor sc, double a)
    {
        this.sc = sc;
        this.a = a;
    }

    //Reduce size by certain percentage (parameter)
    @Override
    public void resize (double percentage)
    {
        this.a = (this.a / 100.0) * (100.0 - percentage);
    }

    @Override
    public String toString ()
    {
        return String.format ("3D (%s, %.3f)", sc, a);
    }
}

class Cube extends ThreeD
{
    public Cube ()
    {

    }

    public Cube (ShapeColor sc, double a)
    {
        super(sc, a);
    }

    public Cube (Cube c)
    {
        this(c.sc, c.a);
    }

    @Override
    public double area ()
    {
        return 6.0 * Math.pow(a, 2);
    }

    @Override
    public double volume ()
    {
        return Math.pow(a, 3);
    }

    @Override
    public double getA ()
    {
        return a;
    }

    public void set (ShapeColor sc, double a)
    {
        super.set(sc, a);
    }

    @Override
    public String toString ()
    {
        return String.format("Cube (%s)", super.toString());
    }
}

class Tetrahedron extends ThreeD
{
    public Tetrahedron ()
    {

    }

    public Tetrahedron (ShapeColor sc, double a)
    {
        super(sc, a);
    }

    public Tetrahedron (Tetrahedron t)
    {
        this(t.sc, t.a);
    }

    @Override
    public double area ()
    {
        return Math.sqrt(3) * Math.pow(a, 2);
    }

    @Override
    public double volume ()
    {
        return (Math.pow(a, 3)) / (6.0 * (Math.sqrt(2)));
    }

    @Override
    public double getA ()
    {
        return a;
    }

    public void set (ShapeColor sc, double a)
    {
        super.set(sc, a);
    }

    @Override
    public String toString ()
    {
        return String.format ("Tetrahedron (%s)", super.toString());
    }
}

class Sphere extends ThreeD
{
    public Sphere ()
    {

    }

    public Sphere (ShapeColor sc, double a)
    {
        super(sc, a);
    }

    public Sphere (Sphere s)
    {
        this(s.sc, s.a);
    }

    @Override
    public double area ()
    {
        return 4.0 * Math.PI * Math.pow(a, 2);
    }

    @Override
    public double volume ()
    {
        return (4.0/3.0) * Math.PI * Math.pow(a, 3);
    }

    @Override
    public double getA ()
    {
        return a;
    }

    public void set (ShapeColor sc, double a)
    {
        super.set(sc, a);
    }

    @Override
    public String toString ()
    {
        return String.format("Sphere (%s)", super.toString());
    }
}


class ChanKaiYang_A2
{

    private static int getInt ()
    {
        Random rand = new Random();

        return rand.nextInt(15) + 1;
    }

    private static double getDouble ()
    {
        Random rand = new Random();

        return rand.nextDouble() * (16 - 1) + 1;
    }

    private static ShapeColor getColor ()
    {
        Random rand = new Random ();

        int a = rand.nextInt(ShapeColor.values().length);

        return ShapeColor.values() [a];
    }

    private static boolean isTriangle (int a, int b, int c)
    {
        if (a < 0)
            return false;
        else if (b < 0)
            return false;
        else if (c < 0)
            return false;
        else if ((a + b) <= c)
            return false;
        else if ((a + c) <= b)
            return false;
        else if ((b + c) <= a)
            return false;        
        else
            return true;
    }

    private static TwoD getTwoD ()
    {
        Random rand = new Random ();
        int random = rand.nextInt(4);

        Trapezoid tr = new Trapezoid (getColor(), getInt(), getInt(), getInt(), getInt(), getInt());
        Rectangle r = new Rectangle (getColor(), getInt(), getInt());
        Triangle t = new Triangle(getColor(), getInt(), getInt(), getInt());
        Circle c = new Circle (getColor(), getInt());

        if (random == 0)
            return tr;
        else if (random == 1)
            return r;
        else if (random == 2 && isTriangle(t.a, t.b, t.c) == true)
            return t;
        else
            return c;
    }

    private static ThreeD getThreeD ()
    {
        Random rand = new Random ();
        int random = rand.nextInt(3);

        Cube c = new Cube(getColor(), getDouble());
        Sphere s = new Sphere(getColor(), getDouble());
        Tetrahedron t = new Tetrahedron(getColor(), getDouble());

        if (random == 0)
            return c;
        else if (random == 1)
            return s;
        else
            return t;
    }

    private static void process2DShape (Shape ss)
    {
        if (ss instanceof TwoD)
        {
            TwoD td = (TwoD) ss;
            ShapeColor sc = getColor();

            do
            {
                sc = getColor();
            } while (td.getShapeColor() == sc);


            td.recolor(sc);

            System.out.printf ("Updated Color: %s%n", td.getShapeColor());
            System.out.printf ("Area = %.3f%n", td.area());
            System.out.printf ("I am a %s shape with color changed to %s%n", td.getClass().getName(), td.getShapeColor());
        }
    }

    private static void process3DShape (Shape ss)
    {
        if (ss instanceof ThreeD)
        {
            ThreeD td = (ThreeD) ss;
            double d = getDouble();

            System.out.printf ("Surface area = %.3f%n", td.area());
            System.out.printf ("Volume = %.3f%n", td.volume());

            td.resize(d);

            System.out.printf ("Size reduced by %.1f%c: %s%n", d, '%', td);
            System.out.printf ("Updated surface area = %.3f%n", td.area());
            System.out.printf ("Updated volume = %.3f%n", td.volume());
            System.out.printf ("I am a %s shape%n", td.getClass().getName());
        }
    }

    private static void displayList (ArrayList <Shape> alist)
    {
        int counter = 1;

        for (Shape ss : alist)
        {
            System.out.printf ("Shape %d: ", counter);
            System.out.printf ("%s%n", ss);

            process2DShape(ss);

            process3DShape(ss);

            System.out.println ("-------------------------------------------------------");

            ++counter;
        }
    }

    public static void main (String [] args)
    {
        ArrayList <Shape> alist = new ArrayList<Shape>();

        Random rand = new Random();
        int random;

        do
        {
            random = rand.nextInt(3);
            if (random == 1)
                alist.add(getTwoD());
            else if (random == 2)
                alist.add(getThreeD());
        } while (random != 0);

        if (alist.size() == 0)
            System.out.println ("The list is empty");
        else
            displayList(alist);
    }
}