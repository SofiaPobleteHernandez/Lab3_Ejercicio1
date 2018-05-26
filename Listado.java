import java.util.ArrayList;
import java.util.Scanner;

public class Listado {
    ArrayList<Pregunta> preguntas;
    Pregunta[] prueba;
    Scanner leer_opcion;
    Scanner leer_pregunta;
    int opcion=0;
    String pregunta;
    int puntos_pregunta;

    public Listado(){
        preguntas=new ArrayList<Pregunta>();
        prueba=new Pregunta[5];
        leer_opcion=new Scanner(System.in);
        leer_pregunta=new Scanner(System.in);
    }


    public int Menu(){
        System.out.println("");
        System.out.println(" MENU : ");
        System.out.println("");
        System.out.println("[1] : Ingresar una nueva pregunta.");
        System.out.println("[2] : Crear prueba.");
        System.out.println("[3] : Salir del programa.");
        System.out.println("Ingrese la opción escogida : ");
        System.out.println("");

        opcion=leer_opcion.nextInt();
        return opcion;
    }

    public int Resolver(){

        if(opcion==1){
            System.out.println("");
            System.out.println("Ingrese pregunta : ");
            pregunta=leer_pregunta.next();
            puntos_pregunta=(int)(Math.random()*30)+1;
            Pregunta problema = new Pregunta(pregunta,puntos_pregunta);
            preguntas.add(problema);
        }
        if(opcion==2){
            int suma=0;
            int valor=0;
            int posicion=0;
            for(int j=0; j<preguntas.size(); j++){
               suma=suma+preguntas.get(j).getScore();
            }

            if((suma>99)&&(preguntas.size()>4)){
                int i=0;
                while(i<5){
                    posicion=(int)(Math.random()*preguntas.size());
                    int repeticiones=0;
                    if(i>0){
                        for(int a=0; a<5;a++){
                            if((prueba[a].getQuestion()).equalsIgnoreCase(preguntas.get(posicion).getQuestion())){
                                repeticiones++;
                            }
                        }
                    }
                    if(repeticiones==0) {
                        prueba[i] = new Pregunta(preguntas.get(posicion).getQuestion(), preguntas.get(posicion).getScore());
                        i++;
                    }
                }

                int sub_suma=0;
                for(int b=0; b<5; b++){
                    sub_suma=sub_suma+prueba[b].getScore();
                }

                while(sub_suma<100){
                    while(i<5){
                        posicion=(int)(Math.random()*preguntas.size());
                        int repeticiones=0;
                        if(i>0){
                            for(int a=0; a<5;a++){
                                if((prueba[a].getQuestion()).equalsIgnoreCase(preguntas.get(posicion).getQuestion())){
                                    repeticiones++;
                                }
                            }
                        }
                        if(repeticiones==0) {
                            prueba[i] = new Pregunta(preguntas.get(posicion).getQuestion(), preguntas.get(posicion).getScore());
                            i++;
                        }
                    }
                    for(int b=0; b<5; b++){
                        sub_suma=sub_suma+prueba[b].getScore();
                    }
                }
            }
            else{
                System.out.println("No hay preguntas suficientes en el Banco para construir una prueba");
            }
        }

        if((opcion!=3)&&(opcion!=1)&&(opcion!=2)){
            System.out.println("Número de opción no válido.");
        }
        return opcion;
    }

    public int Mostrar_Ultima_Prueba(){
        System.out.println("");
        System.out.println("LA ULTIMA PRUEBA CREADA ES : ");
        System.out.println("");
        try {
            for (int num = 0; num < 5; num++) {
                System.out.println("Pregunta N°" + (num + 1));
                System.out.println("-Pregunta : " + prueba[num].getQuestion());
                System.out.println("-Puntaje  : " + prueba[num].getScore());
                System.out.println("-----------------------------------------");
                System.out.println("");
            }
        }
        catch(Exception e){
            System.out.println("No hay pruebas registradas");
        }
        return 0;
    }

}
