package pe.edu.upeu.claseinterna;


import java.util.ArrayList;
import java.util.List;

public class ClaseExterna {
    int num1;
    int num2;

    ClaseExterna(int num1, int num2){
        this.num1=num1;
        this.num2=num2;
    }

    public static void main(String[] args) {
        ClaseExterna ce=new ClaseExterna(10, 6);
        char[] opers={'+', '-', '/', '*'};

        ClaseInternU ciu=ce.new ClaseInternU();
        ClaseInternaD cid=ce.new ClaseInternaD();
        for (char op: opers) {
            String h = ciu.operar(ce.num1, ce.num2, op);
            cid.guardar(h);
        }

        for (String v: cid.lista){
            System.out.println(v);
        }
    }


    class ClaseInternU{
        String operar(int num1, int num2, char oper){
            double result=0;
            switch (oper){
                case '+':result=num1+num2; break;
                case '-':result=num1-num2; break;
                case '/':result= (double) num1/num2; break;
                case '*':result=num1*num2; break;
                default: break;
            }
            return num1+" "+oper+" "+num2+"="+result;
        }
    }

    class ClaseInternaD{
        List<String> lista=new ArrayList<>();

        void guardar(String dato) {
            lista.add(dato);
        }
    }
}
