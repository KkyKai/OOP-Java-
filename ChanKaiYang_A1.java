//Full Name: Chan Kai Yang
//Full Time
//Student no: 7372711
//Tutorial group: T03
//Declaration: This is my own work and I did not pass this program to anyone
//File Name: ChanKaiYang_A1.java

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.StringJoiner;

enum Zodiac
{
    Rat ("RAT", 1948),
    Ox ("OX", 1949),
    Tiger ("TIGER", 1950),
    Rabbit ("RABBIT", 1951),
    Dragon ("DRAGON", 1952),
    Snake ("SNAKE", 1953),
    Horse ("HORSE", 1954),
    Goat ("GOAT", 1955),
    Monkey ("MONKEY", 1956),
    Rooster ("ROOSTER", 1957),
    Dog ("DOG", 1958),
    Pig ("PIG", 1959);

    //Instance Variables
    private final String abbreviation;
    private final int year;
    
    Zodiac (String abbreviation, int year)
    {
        this.abbreviation = abbreviation;
        this.year = year;
    }

    public String getAbbreviation ()
    {
        return abbreviation;
    }

    public int getYear ()
    {
        return year;
    }
}

class Set
{
    private ArrayList <Zodiac> s;

    public Set ()
    {
        this.s = new ArrayList <Zodiac> ();
    }

    public Set (Set otherSet)
    {
        this.s = new ArrayList<Zodiac>();

        //Deep copying
        for (int i = 0; i < otherSet.s.size(); i++)
            this.s.add(otherSet.s.get(i));
    }

    //If arraylist is empty
    public boolean isEmpty ()
    {
        if (this.s.size() == 0)
            return true;
        else 
            return false;
    }

    //Return number of elements in set
    public int cardinality ()
    {
        return s.size();
    }

    //check if an element is inside a set
    public boolean belongTo (Zodiac element)
    {
        if (s.contains(element))
            return true;
        else
            return false;
    }

    //Add element into set if it is not alr inside set
    public void addElement (Zodiac element)
    {
        if (belongTo(element) == false) 
            this.s.add(element);
    }

    //check for subset of set
    public boolean subset (Set otherSet)
    {
        return this.s.containsAll(otherSet.s);
    }

    //Get union set of set and otherSet
    public void union (Set otherSet)
    {
        for (int i = 0; i < otherSet.s.size(); i++)
        {
            addElement(otherSet.s.get(i));
        }
    }

    //Get intersection set of set and otherSet
    public void intersection (Set otherSet)
    {
        this.s.retainAll(otherSet.s);
    }

    //Difference of set - otherSet
    public void difference (Set otherSet)
    {
        for (int i = 0; i < otherSet.s.size (); i++)
        {
            if (this.s.contains (otherSet.s.get(i)))
            {
                this.s.remove (otherSet.s.get(i));
            }
        }
    }

    //!this.s
    public Set complement()
    {
        Set c = new Set ();

        for (int i = 0; i < Zodiac.values ().length; i++)
        {
            c.addElement(Zodiac.values()[i]);
        }

        c.difference(this);

        return c;
    }

    //check equality of 2 sets
    public boolean equality (Set otherSet)
    {
        if (this.subset(otherSet) == true && otherSet.subset(this) == true)
            return true;
        else
            return false;
    }

    public String getEnumFormat ()
    {  
        StringJoiner sj = new StringJoiner(", ", "{", "}");
        String a = "";

        for (int i = 0; i < this.s.size (); i++)
        {
            a = String.format ("%s", s.get(i));
            sj.add(a);
        }
        String desired = sj.toString();

        return desired;
    }

    public String getYearFormat ()
    {  
        StringJoiner sj = new StringJoiner(", ", "{", "}");
        String a = "";

        for (int i = 0; i < this.s.size (); i++)
        {
            a = String.format ("%s", s.get(i).getYear());
            sj.add(a);
        }
        String desired = sj.toString();

        return desired;
    }

    public String toString ()
    {  
        StringJoiner sj = new StringJoiner(", ", "{", "}");
        
        for (int i = 0; i < this.s.size (); i++)
        {
            sj.add(s.get(i).getAbbreviation());
        }
        String desired = sj.toString();

        return desired;
    }
}

class ChanKaiYang_A1
{
    private static Scanner input = new Scanner (System.in);

    private static void displayZodiacInfo ()
    {
        System.out.printf ("%s%n%n", "Universal set info");

        System.out.printf ("%-15s%-15s%-15s%n", "Zodiac Sign", "Known as", "For example");

        for (Zodiac z : Zodiac.values())
            System.out.printf("%-15s%-15s%-15s%n", z, z.getAbbreviation(), z.getYear());
    }

    //get random ele
    private static Zodiac getAnElement ()
    {
        Random rand = new Random();

        int a = rand.nextInt (Zodiac.values().length);

        return Zodiac.values()[a];
    }

    //Get set with random no. of elements
    private static Set getASet ()
    {
        Set s = new Set ();
        Random rand = new Random();
        int random = rand.nextInt (Zodiac.values().length + 1);

        for (int i = 0; i < random; i++)
        {
            Zodiac d = getAnElement();

            s.addElement(d);
        }

        return s;
    }

    private static void displayMenu ()
    {
        System.out.printf ("%n%s%n%n", "Welcome to SIM Set Theory lesson");
        System.out.printf ("0: %s%n", "Properties of set");
        System.out.printf ("1: %s%n", "Union example");
        System.out.printf ("2: %s%n", "Intersection example");
        System.out.printf ("3: %s%n", "Subset example");
        System.out.printf ("4: %s%n", "Difference example");
        System.out.printf ("5: %s%n", "Complement example");
        System.out.printf ("6: %s%n", "Sets equality example");
        System.out.printf ("7: %s%n", "Distributive Law 1");
        System.out.printf ("8: %s%n", "Distributive Law 2");
        System.out.printf ("9: %s%n", "Quit");

        System.out.println ();
    }

    private static void unionExample ()
    {
        Set a = getASet();
        Set b = getASet();

        System.out.println ("Given Sets");
        System.out.printf ("%12s%s%n", "A = ", a);
        System.out.printf ("%12s%s%n", "B = ", b);

        a.union(b);

        System.out.printf ("%27s%s%n", "Union of A and B = ", a);

    }

    private static void intersectionExample ()
    {
        Set a = getASet();
        Set b = getASet();

        System.out.println ("Given Sets");
        System.out.printf ("%12s%s%n", "A = ", a);
        System.out.printf ("%12s%s%n", "B = ", b);

        a.intersection(b);
 
        System.out.printf ("%34s%s%n", "Intersection of A and B = ", a);
    }

    private static void subsetExample ()
    {
        Set a = getASet();
        Set b = getASet();

        System.out.println ("Given Sets");
        System.out.printf ("%12s%s%n", "A = ", a);
        System.out.printf ("%12s%s%n", "B = ", b);
        System.out.println ();

        boolean sub = b.subset(a);

        System.out.println ("Conclusion");
        System.out.printf ("%23s%s%n", "A subset of B: ", sub);

        boolean sub2 = a.subset(b);

        System.out.printf ("%23s%s%n", "B subset of A: ", sub2);
    }

    private static void differenceExample ()
    {
        Set a = getASet();
        Set b = getASet();

        System.out.println ("Given Sets");
        System.out.printf ("%12s%s%n", "A = ", a);
        System.out.printf ("%12s%s%n", "B = ", b);
        System.out.println ();

        a.difference(b);

        System.out.printf ("%16s%s%n", "A - B = ", a);
    }

    private static void complementExample ()
    {
        Set a = getASet();

        System.out.println ("Given Set");
        System.out.printf ("%12s%s%n", "A = ", a);
        System.out.println ();

        System.out.printf ("%13s%s%n", "A' = ", a.complement()); 

    }

    private static void equalityExample ()
    {
        Set a = getASet();
        Set b = getASet();

        System.out.println ("Given Sets");
        System.out.printf ("%12s%s%n", "A = ", a);
        System.out.printf ("%12s%s%n", "B = ", b);
        System.out.println ();

        boolean sub = b.subset(a);

        System.out.println ("Analysis");
        System.out.printf ("%23s%s%n", "A subset of B: ", sub);

        boolean sub2 = a.subset(b);

        System.out.printf ("%23s%s%n", "B subset of A: ", sub2);
        System.out.println ();

        boolean eq = a.equality(b);
        System.out.println ("Conclusion");
        System.out.printf ("%23s%s%n", "A equals to B: ", eq);
    }

    private static void distributiveLaw ()
    {
        Set a = getASet();
        Set b = getASet();
        Set c = getASet();

        //use copy constructor
        Set newA = new Set (a);
        Set newB = new Set (b);
        Set newC = new Set (c);

        Set newA2 = new Set (a);

        System.out.println ("We wish to prove: A U (B I C) = (A U B) I (A U C)");
        System.out.println ();

        System.out.println ("Given Sets");
        System.out.printf ("%12s%s%n", "A = ", a);
        System.out.printf ("%12s%s%n", "B = ", b);
        System.out.printf ("%12s%s%n", "C = ", c);
        System.out.println ();

        System.out.println ("LHS analysis");

        //(B I C)
        b.intersection(c);
        //A U (B I C)
        a.union(b);

        System.out.printf ("%14s%s%n", "LHS = ", a);
        System.out.println ();

        System.out.println ("RHS analysis");

        //(A U B)
        newA.union (newB);
        //(A U C)
        newA2.union(newC);
        //(A U B) I (A U C)
        newA.intersection(newA2);

        System.out.printf ("%14s%s%n", "RHS = ", newA);
        System.out.println ();

        System.out.println ("Conclusion");

        //A U (B I C) = (A U B) I (A U C)
        boolean eq = a.equality(newA);

        System.out.printf ("%21s%s%n", "LHS = RHS is ", eq);
    }

    private static void distributiveLaw2 ()
    {
        Set a = getASet();
        Set b = getASet();
        Set c = getASet();

        //use copy constructor
        Set newA = new Set (a);
        Set newB = new Set (b);
        Set newC = new Set (c);

        Set newA2 = new Set (a);

        System.out.println ("We wish to prove: A I (B U C) = (A I B) U (A I C)");
        System.out.println ();

        System.out.println ("Given Sets");
        System.out.printf ("%12s%s%n", "A = ", a);
        System.out.printf ("%12s%s%n", "B = ", b);
        System.out.printf ("%12s%s%n", "C = ", c);
        System.out.println ();

        System.out.println ("LHS analysis");

        //(B U C)
        b.union(c);
        //A I (B U C)
        a.intersection(b);

        System.out.printf ("%14s%s%n", "LHS = ", a);
        System.out.println ();

        System.out.println ("RHS analysis");

        //(A I B)
        newA.intersection(newB);
        //(A I C)
        newA2.intersection(newC);
        //(A I B) U (A I C)
        newA.union(newA2);

        System.out.printf ("%14s%s%n", "RHS = ", newA);
        System.out.println ();

        System.out.println ("Conclusion");

        //A I (B U C) = (A I B) U (A I C)
        boolean eq = a.equality(newA);

        System.out.printf ("%21s%s%n", "LHS = RHS is ", eq);


    }

    public static void displaySubmenu ()
    {
        System.out.println ("Some basic operations in set");

        System.out.printf ("%11s%s%n", "1. ", "Add an element");
        System.out.printf ("%11s%s%n", "2. ", "Check an element");
        System.out.printf ("%11s%s%n", "3. ", "Cardinality");
        System.out.printf ("%11s%s%n", "4. ", "Enum format");
        System.out.printf ("%11s%s%n", "5. ", "Year format");
        System.out.printf ("%11s%s%n", "9. ", "Quit");
        System.out.println ();
    }

    public static void anExample ()
    {
        Set s = getASet();
        Zodiac z;
        int option;

        System.out.println ("Here is an example of set");

        System.out.printf ("%11s%s%n", "A = ", s);
        System.out.printf ("%56s%n", "All elements in set are distinct and random order");
        System.out.println ();

        do 
        {
            displaySubmenu();

            System.out.printf ("%s", "Enter your option: ");
            option = input.nextInt();
            System.out.println ();

            if (option == 1)
            {
                System.out.printf ("%s", "Enter an element: ");                
                z = Zodiac.valueOf(input.next());

                if (s.belongTo(z) == false)
                {
                    s.addElement(z);
                }

                System.out.printf ("A = %s%n", s);
            }

            else if (option == 2)
            {
                System.out.printf ("%s", "Enter an element: ");
                z = Zodiac.valueOf(input.next());                

                if (s.belongTo(z) == false)
                    System.out.printf ("Element %s is not in the set%n", z);
                else
                    System.out.printf ("Element %s is in the set%n", z);
            }

            else if (option == 3)
            {
                System.out.printf ("No of elements in set is %d%n", s.cardinality());
            }

            else if (option == 4)
            {
                System.out.println ("Notation in enum format");
                System.out.printf ("%12s%s%n", "A = ", s.getEnumFormat());
            }

            else if (option == 5)
            {
                System.out.println ("Notation in year format");
                System.out.printf ("%12s%s%n", "A = ", s.getYearFormat());
            }
            System.out.println ("--------------------------------------------");
        } while (option != 9);

    }

    public static void main (String [] args)
    {
        int option;

        displayZodiacInfo();

        do
        {
            displayMenu();

            System.out.printf ("%s", "Your option: ");
            option = input.nextInt();
            System.out.println ();

            switch (option)
            {
                case 0: anExample();
                    break;

                case 1: unionExample();
                    break;

                case 2: intersectionExample();
                    break;
            
                case 3: subsetExample();
                    break;

                case 4: differenceExample();
                    break;

                case 5: complementExample();
                    break;

                case 6: equalityExample();
                    break;

                case 7: distributiveLaw();
                    break;

                case 8: distributiveLaw2();
                    break;
            }
            System.out.println ("--------------------------------------------");

        } while (option != 9);
    }
}