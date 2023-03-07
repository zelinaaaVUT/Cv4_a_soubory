import javax.xml.crypto.Data;
import java.util.Scanner;
import java.io.*;

public class Databaze {
    public Databaze(int pocetPrvku)
    {
        prvkyDatabaze=new Student[pocetPrvku];
        sc=new Scanner(System.in);
    }

    public void setStudent(String jmeno, int rok)
    {
        //System.out.println("Zadejte jmeno studenta, rok narozeni");
        //String jmeno=sc.next();
        //int rok=sc.nextInt(); presunuto do switche v Test.java
        prvkyDatabaze[posledniStudent++]=new Student(jmeno,rok);
    }

    public Student getStudent(int idx)
    {
        return prvkyDatabaze[idx];
    }

    public void setPrumer(int idx, float prumer) throws exception
    {
        prvkyDatabaze[idx].setStudijniPrumer(prumer);
    }

    public void returnDatabase() throws exception{
        try {
            for (int i = 0; i < prvkyDatabaze.length; i++){
                System.out.println("Jmeno: " + prvkyDatabaze[i].getJmeno() + " rok: " + prvkyDatabaze[i].getRocnik() + " prumer: " + prvkyDatabaze[i].getStudijniPrumer());
            }
        }
        catch (Exception e){
        }
    }

    public void zapisDoSouboru(String file) throws exception{
        FileWriter fw = null; BufferedWriter bw = null;
        try{
            fw = new FileWriter(file);  //true pro append mod
            bw = new BufferedWriter(fw);

            for (int i = 0; i < prvkyDatabaze.length; i++){
                bw.write(prvkyDatabaze[i].getJmeno() + " " + prvkyDatabaze[i].getRocnik()+ " " + prvkyDatabaze[i].getStudijniPrumer() + "\n");
            }
        }
        catch (IOException e ){
            System.out.println("Soubor nejde otevrit");
        }
        catch (NullPointerException e){
        }
        finally {
            try {
                bw.close(); fw.close();
            }
            catch (IOException e){
                System.out.println("Soubor nejde zavrit");
            }
        }
    }
    public  void nactiZeSouboru(String file, Databaze mojeDatabaze) throws exception{
        String jmeno; int rok; float prumer; int index = 0;
        FileReader fr = null; BufferedReader br = null;
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);

            String radek;
            while ((radek = br.readLine())!= null){
                String[] parts = radek.split(" ");
                jmeno = parts[0];
                rok = Integer.parseInt(parts[1]);
                prumer = Float.parseFloat(parts[2]);


                mojeDatabaze.setStudent(jmeno, rok);
                mojeDatabaze.setPrumer(index, prumer);
                index++;
            }
        }
        catch (IOException e){
            System.out.println("Soubor se nepodarilo otevrit");
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Databaze neni vytvorena nebo uz jdes mimo index");
        }
        finally {
            try {
                br.close(); fr.close();
            }
            catch (IOException e){
                System.out.println("Soubor se nepodarilo otevrit");
            }
        }
    }

    private Scanner sc;
    private Student [] prvkyDatabaze;
    private int posledniStudent;
}