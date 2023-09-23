package Hospital_Las_Vegas;

import java.util.Random;

public class Aleatorios {
    
    public String generarNombres(){

        String[] nombres = {"Pedro", "Jhon", "Andru", "Leo", "Juan", "Samuel", "Eiko", "Michael", "Ruben", "Oswald", "Sarah", "Sofia", "Valeria", "Anna", "Dali", "Monica", "Paula","Alejandro"};
        String[] apellidos = {"Quiroz", "Buelvas", "Zapata", "Olaya", "Galindo", "Torres", "Chingenguan", "Ariztisabal", "Gomez", "Parra", "Fuentes", "Rey", "Grande", "Jackson", "Sierra", "Dai", "Soi", "Dan"};
        Random random = new Random();
        int indice = random.nextInt(nombres.length);
        String apellidoElejido = apellidos[indice];
        String nombreElejido = nombres[indice];
        String concate = nombreElejido+" "+apellidoElejido;

        return concate;
    }

    public String generarTriaje(){

        String[] nombres = {"CodigoAzul","Urgente","Normal","Leve"};
        Random random = new Random();
        int indice = random.nextInt(nombres.length);
        String code = nombres[indice];
        return code;

    }

}
