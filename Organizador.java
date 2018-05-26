public class Organizador {
    Listado listado;
    public Organizador(){
        listado=new Listado();
    }

    public void Bienvenida(){
        System.out.println("");
        System.out.println("        BIENVENIDO AL CONSTRUCTOR DE PRUEBAS");
        System.out.println("        ====================================");
    }

    public void Repositorio(){
        while(listado.opcion!=3){
            listado.Menu();
            listado.Resolver();
            listado.Mostrar_Ultima_Prueba();
        }
        System.out.println("Has cerrado sesión exitosamente.");
    }
}