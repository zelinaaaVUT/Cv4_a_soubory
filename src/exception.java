public class exception extends java.lang.Exception{
    public exception(){
        super("Nebyl zadan prumer");
    }
    public exception(double prumer){
        super("Prumer nebyl zadan v intervalu 1-5");
    }
}
