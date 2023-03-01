import java.util.Scanner;

public class Student {
    public Student(String jmeno, int rocnik)
    {
        this.jmeno=jmeno;
        this.rocnik=rocnik;
    }

    public String getJmeno()
    {
        return jmeno;
    }

    public int getRocnik()
    {
        return rocnik;
    }

    public float getStudijniPrumer() throws exception {
        if (this.studijniPrumer == 0){
            throw new exception();
        }
        else{
            return studijniPrumer;
        }
    }

    public void setStudijniPrumer(float studijniPrumer) throws exception{
        if(studijniPrumer >=1 && studijniPrumer <=5){
            this.studijniPrumer = studijniPrumer;
        }
        else {
            throw new exception(studijniPrumer);
        }
    }

    private String jmeno;
    private int rocnik;
    private float studijniPrumer;
}