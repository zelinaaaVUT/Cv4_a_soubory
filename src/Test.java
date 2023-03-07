import java.util.Scanner;


public class Test {

    public static int pouzeCelaCisla(Scanner sc)
    {
        int cislo = 0;
        try
        {
            cislo = sc.nextInt();
        }
        catch(Exception e)
        {
            System.out.println("Nastala vyjimka typu "+e.toString());
            System.out.println("zadejte prosim cele cislo ");
            sc.nextLine();
            cislo = pouzeCelaCisla(sc);
        }
        return cislo;
    }

    public static int checkArray(Scanner sc, Databaze mojeDatabaze)
    {
        int cislo = 0;
        try {
            cislo = sc.nextInt();
            mojeDatabaze.getStudent(cislo);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Nastava vyjimka " + e.toString());
            System.out.println("Zadal jsi mimo pole");
            sc.nextLine();
            cislo = checkArray(sc, mojeDatabaze);
        }catch (NullPointerException e){
            System.out.println("Nastava vyjimka " + e.toString());
            System.out.println("Zadal jsi mimo pole");
            sc.nextLine();
            cislo = checkArray(sc, mojeDatabaze);
        }
        return cislo;
    }
    public static float pocitaniPrumer(Scanner sc, Databaze mojeDatabaze)
    {
        int cislo = 0;
        float prum = 0;
        try {
            cislo = checkArray(sc, mojeDatabaze);
            prum = sc.nextFloat();
            mojeDatabaze.setPrumer(cislo, prum);
        }
        catch(Exception e)
        {
            System.out.println("Nastala vyjimka typu " + e.toString());
            sc.nextLine();
            prum = pocitaniPrumer(sc, mojeDatabaze);
        }
        return 1;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc=new Scanner(System.in);
        Databaze mojeDatabaze=new Databaze(1);
        int idx;
        float prumer;
        int volba;
        boolean run=true;
        while(run)
        {
            System.out.println("Vyberte pozadovanou cinnost:");
            System.out.println("1 .. vytvoreni nove databaze");
            System.out.println("2 .. vlozeni noveho studenta");
            System.out.println("3 .. nastaveni prumeru studenta");
            System.out.println("4 .. vypis informace o studentovi");
            System.out.println("5 .. vypis databaze");
            System.out.println("6 .. ulozeni do souboru");
            System.out.println("7 .. nacteci ze souboru");
            System.out.println("8 .. ukonceni aplikace");
            volba=pouzeCelaCisla(sc);
            switch(volba)
            {
                case 1:
                    System.out.println("Zadejte pocet studentu");
                    mojeDatabaze=new Databaze(pouzeCelaCisla(sc));
                    break;
                case 2:
                    try{
                        System.out.println("Zadejte jmeno studenta, rok narozeni");
                        String jmeno = sc.next();
                        int rok = sc.nextInt();
                        mojeDatabaze.setStudent(jmeno, rok);
                    }catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("Databaze mimo index");
                    }

                    break;
                case 3:
                    System.out.println("Zadejte index a prumer studenta");
                    pocitaniPrumer(sc, mojeDatabaze);
                    break;
                case 4:
                    System.out.println("Zadejte index studenta");
                    idx= checkArray(sc, mojeDatabaze);
                    Student info=mojeDatabaze.getStudent(idx);
                    try {
                        System.out.println("Jmeno: " + info.getJmeno() + " rok narozeni: " + info.getRocnik() + " prumer: " + info.getStudijniPrumer());
                    } catch (exception eexception){
                        System.out.println("Nastala vyjimka " + eexception.toString());
                    } catch (NullPointerException e){
                        System.out.println("Nastala vyjimka " + e);
                        System.out.println("Mimo pole");
                    }
                    break;
                case 5:
                    try {
                        mojeDatabaze.returnDatabase();
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 6:
                    try {
                        sc.nextLine();
                        System.out.println("Zadej nazev souboru: ");
                        mojeDatabaze.zapisDoSouboru(sc.nextLine());
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 7:
                    try {
                    sc.nextLine();
                    System.out.println("Zadej nazev souboru: ");
                    mojeDatabaze.nactiZeSouboru(sc.nextLine(), mojeDatabaze);
                    }
                    catch (Exception e){
                    System.out.println(e);
                    }
                    break;
                case 8:
                    run=false;
                    break;
            }

        }
    }

}
