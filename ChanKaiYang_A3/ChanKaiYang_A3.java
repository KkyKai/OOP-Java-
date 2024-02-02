//Full Name: Chan Kai Yang
//Full Time
//Student no: 7372711
//Tutorial group: T03
//Declaration: This is my own work and I did not pass this program to anyone
//File Name: ChanKaiYang_A3.java

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.ArrayList;
import java.util.Random;

class Olympic
{
    private int NO;
    private String country;
    private double [] score;
    private int rank;

    public Olympic (String country)
    {
        this.country = country;
        this.NO = 10;

        this.score = new double [NO];

        processScores();
        getScoreArray();
    }

    public Olympic (Olympic oly)
    {
        this(oly.country);
    }

    public void processScores ()
    {
        Random rand = new Random ();

        for (int i = 0; i < score.length; i++)
        {
            score [i] = rand.nextDouble() * 100;
        }
    }

    public double totalScores ()
    {
        double sum = 0.0;

        for (double d : score)
            sum += d;
        
        return sum;
    }

    public void set (int rank)
    {
        this.rank = rank;
    }

    public int getRank ()
    {
        return rank;
    }

    public String getName ()
    {
        return country;
    }

    private double [] getScoreArray ()
    {
        return score;
    }

    @Override
    public String toString ()
    {
        return String.format ("Rank%d: %s", rank, country);
    }

}

class OlympicFrame extends JFrame implements ActionListener
{
    private JButton [] jbArray;
    private final String [] countryArray = {"USA", "Spain", "China", "Japan", "Italy", "Germany", "France", 
                                                "Brazil", "Netherland", "Poland", "Russia", "Ukraine"};
    private ArrayList <Olympic> alist;

    public OlympicFrame ()
    {
        super ("Olympic 2021");
        setLayout(new GridLayout (3, 4));

        jbArray = new JButton [countryArray.length];

        //Initialize button
        for (int i = 0; i < jbArray.length ; i++)
        {
            Icon ic = new ImageIcon(String.valueOf(i + 1) + ".jpg");
            jbArray [i] = new JButton (ic);
            jbArray [i].setHorizontalTextPosition(SwingConstants.RIGHT);
        }

		// Add buttons to JFrame
        for (JButton jb : jbArray)
            add (jb);

        // Register the events to each button
        for (JButton jb : jbArray)
            jb.addActionListener(this);

        alist = new ArrayList <Olympic> (countryArray.length);
        constructAList();
        getFinalRanking();         
    }

    private void constructAList ()
    {
        Olympic oc;

        for (int i = 0; i < countryArray.length; i++)
        {
            oc = new Olympic (countryArray [i]);
            alist.add(oc);
        }
    }

    private int getRank (double [] scoreArray, double d)
    {
        int rank = 1;
        int i = 0;

        while (d != scoreArray [i])
        {
            rank += 1;
            i++;
        }

        return rank;
    }

    private String getFinalRanking ()
    {
        //Create and populate scoreArray
        double [] scoreArray = new double [countryArray.length];
        
        for (int i = 0; i < alist.size(); i++)
        {
            scoreArray [i] = alist.get(i).totalScores();
        }
        
        //Sort by Descending
        double temp = 0.0;
        for (int i = 0; i < scoreArray.length; i++) 
        {   
            for (int j = i+1; j < scoreArray.length; j++) 
            {   
                if(scoreArray[i] < scoreArray[j])
                {  
                    temp = scoreArray[i];  
                    scoreArray[i] = scoreArray[j];  
                    scoreArray[j] = temp;  
                }   
            }   
        }
        
        //set Final Rank
        for (int i = 0; i < alist.size(); i++)
        {
            alist.get(i).set (getRank(scoreArray, alist.get(i).totalScores()));
        }
        
        //Display ranking info
        String str = String.format("%s%n%n%n", "FINAL RANKING");
        for (int i = 0; i < alist.size(); i++)
        {
            str += String.format ("Rank %d: %s (%.2f)%n", getRank(scoreArray, scoreArray [i]), 
                                                        getCountry(alist, getRank(scoreArray, scoreArray [i])).toUpperCase(), 
                                                        getScores(alist, getCountry(alist, getRank(scoreArray, scoreArray [i]))));
        }

        return str;
    }

    private String getCountry (ArrayList <Olympic> alist, int n)
    {
        int ci = 0;

        for (int i = 0; i < alist.size (); i++)
        {
            if (alist.get(i).getRank() == n)
            ci = i;
        }

        return alist.get(ci).getName();
    }

    private double getScores (ArrayList <Olympic> alist, String name)
    {
        int ci = 0;

        for (int i = 0; i < alist.size (); i++)
        {
            if (alist.get(i).getName() == name)
            {
                ci = i;
            }
        }

        return alist.get(ci).totalScores();
        
    }

    @Override
    public void actionPerformed (ActionEvent e)
    {
        for (int i = 0; i < jbArray.length; i++)
        {
            if (e.getSource() == jbArray [i])
            {
                jbArray [i].setText ("Rank " + String.valueOf(alist.get(i).getRank()));
                Icon ic = new ImageIcon("trophy.jpg");
                JOptionPane.showMessageDialog (null, getFinalRanking(), "Miss World 2020",
                JOptionPane.PLAIN_MESSAGE, ic);
            }
        }
    }

}

class ChanKaiYang_A3 
{
    public static void main (String [] args)
    {
        OlympicFrame of = new OlympicFrame ();
        of.setSize(1200, 800);
        of.setVisible(true);
        of.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}