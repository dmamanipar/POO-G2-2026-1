package pe.edu.upeu.interfaceencap;

public class Loro implements Animal{
    @Override
    public void emitirSonido() {
        System.out.println("Hola muchachos...aprendan!!");
    }

    @Override
    public void dormir() {
        System.out.println("Zzzz...zzz...zz!!");
    }
}
