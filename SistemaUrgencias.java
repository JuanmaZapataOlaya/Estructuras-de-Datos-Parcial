package Hospital_Las_Vegas;
import java.util.ArrayList;
import java.util.Random;

// Clase para el sistema de urgencias //

public class SistemaUrgencias {

    Registro registro = new Registro();

    ArrayList<Paciente> CodigoAzul = new ArrayList<>();
    ArrayList<Paciente> Urgente = new ArrayList<>();
    ArrayList<Paciente> Normal = new ArrayList<>();
    ArrayList<Paciente> Leve = new ArrayList<>();
    ArrayList<Paciente> Laboratorio = new ArrayList<>();

    //Getters de las listas

    public ArrayList<Paciente> getCodigoAzul() {
        return CodigoAzul;
    }

    public ArrayList<Paciente> getUrgente() {
        return Urgente;
    }

    public ArrayList<Paciente> getNormal() {
        return Normal;
    }

    public ArrayList<Paciente> getLeve() {
        return Leve;
    }

    public ArrayList<Paciente> getLaboratorio() {
        return Laboratorio;
    }


    // Triage //

    public void triage(Paciente paciente) {

        Registro registro = new Registro();

        if(paciente.getCodigoTriage().equalsIgnoreCase("CodigoAzul")){
            CodigoAzul.add(paciente);

        }else if(paciente.getCodigoTriage().equalsIgnoreCase("Urgente")){
            Urgente.add(paciente);

        }else if(paciente.getCodigoTriage().equalsIgnoreCase("Normal")){
            Normal.add(paciente);

        }else if(paciente.getCodigoTriage().equalsIgnoreCase("Leve")){
            Leve.add(paciente);

        }else{
            System.out.println("El paciente no tiene ningún diagnostico");
            registro.escribirRegistro("El paciente no tiene ningún diagnostico");
        }
    }

    // Atención //

    public void atencionMedica(ArrayList<Paciente> paciente){

        Registro registro = new Registro();

        for(Paciente personas : paciente){

            String nombre = personas.getNombre();

            Random probabilidad = new Random();
            int caso = probabilidad.nextInt(6);

            registro.escribirRegistro("===Procedimientos realizados===");
            System.out.println("===Procedimientos realizados===");

            if(caso ==0 || caso ==5){
                System.out.print("El paciente: "+ nombre  + " se le realizaron exámenes médicos \n");
                registro.escribirRegistro("El paciente: "+ nombre  + " se le realizaron exámenes médicos \n");
            }

            if(caso == 1 || caso ==4){
                System.out.print("El paciente: "+ nombre + " se le realizaron pruebas diagnosticas \n");
                registro.escribirRegistro("El paciente: "+ nombre + " se le realizaron pruebas diagnosticas \n");
            }

            if(caso == 2 || caso ==5){
                System.out.print("El paciente: "+ nombre + " se le realizaron procedimientos curativos \n");
                registro.escribirRegistro("El paciente: "+ nombre + " se le realizaron procedimientos curativos \n");
            }

            if(caso ==3 || caso ==4){
                System.out.print("El paciente: "+ nombre + " se le realizo una estabilizacion de dolencias y monitoreo de signos vitales en una franja de tiempo\n");
                registro.escribirRegistro("El paciente: "+ nombre + " se le realizo una estabilizacion de dolencias y monitoreo de signos vitales en una franja de tiempo\n");
            }

            System.out.print("\n");
            registro.escribirRegistro("\n");

        }
    }

    public void salidaPaciente(ArrayList<Paciente> paciente){

        Registro registro = new Registro();

        for(Paciente personas : paciente){

          String gravedad = personas.getCodigoTriage();
            String nombre = personas.getNombre();
            int peligro = 0;


            // Aqui entre más elevado sea el numero más probabilidades habra de muerte o complicaciones
            if(gravedad.equalsIgnoreCase("CodigoAzul")){
                Random probabilidad = new Random();
                peligro = probabilidad.nextInt(100);
                

            }else if(gravedad.equalsIgnoreCase("Urgente")){
                Random probabilidad = new Random();
                peligro = probabilidad.nextInt(75);

            }else if(gravedad.equalsIgnoreCase("Normal")){
                Random probabilidad = new Random();
                peligro = probabilidad.nextInt(62);

            }else if(gravedad.equalsIgnoreCase("Leve")){
                Random probabilidad = new Random();
                peligro = probabilidad.nextInt(30);
            }

            if(peligro>60){
                System.out.println("La persona: "+ nombre+" falleció y fue trasladada a la MORGUE");
                registro.escribirRegistro("La persona: "+ nombre+" falleció y fue trasladada a la MORGUE");

            }else if(peligro>50){
                System.out.println("La persona: "+ nombre+" fue HOSPITALIZADO");
                registro.escribirRegistro("La persona: "+ nombre+" fue HOSPITALIZADO");

            }else if(peligro>40){
                System.out.println("La persona: "+ nombre+" fue Remitido a un MÉDICO ESPECIALISTA");
                registro.escribirRegistro("La persona: "+ nombre+" fue Remitido a un MÉDICO ESPECIALISTA");

            }else if(peligro>30){
                System.out.println("La persona: "+ nombre+" se dió de alta VOLUNTARIAMENTE");
                registro.escribirRegistro("La persona: "+ nombre+" se dió de alta VOLUNTARIAMENTE");

            }else if(peligro>20){
                System.out.println("La persona: "+ nombre+" fue dado de ALTA CON MEDICAMENTO");
                registro.escribirRegistro("La persona: "+ nombre+" fue dado de ALTA CON MEDICAMENTO");
                Laboratorio.add(personas);

            }else if(peligro>10){
                System.out.println("La persona: "+ nombre+" fue dado de ALTA");
                registro.escribirRegistro("La persona: "+ nombre+" fue dado de ALTA");

            }  
        }
    }

    public void laboratorio(ArrayList<Paciente> paciente){


        Registro registro = new Registro();

        if (paciente.size()>9){
            registro.escribirRegistro("\n");
            System.out.print("\n");
            for(Paciente personas : paciente){

                String nombre = personas.getNombre();

                System.out.println("La persona: "+nombre+" Solicitó su medicamento y abandono el laboratorio");
                registro.escribirRegistro("La persona: "+nombre+" Solicitó su medicamento y abandono el laboratorio");

            }
        }else{
            registro.escribirRegistro("\n");
            registro.escribirRegistro("No se encontraron suficientes pacientes, de todas formas el medico los atendera a final de turno");
            registro.escribirRegistro("Numero de pacientes que necesitan medicamento: "+paciente.size());
            registro.escribirRegistro("\n");

            System.out.print("\n");
            System.out.println("No se encontraron suficientes pacientes, de todas formas el medico los atendera a final de turno");
            System.out.println("Numero de pacientes que necesitan medicamento: "+paciente.size());
            System.out.print("\n");
            for(Paciente personas : paciente){

                String nombre = personas.getNombre();

                System.out.println("La persona: "+nombre+" Solicitó su medicamento y abandono el laboratorio");
                registro.escribirRegistro("La persona: "+nombre+" Solicitó su medicamento y abandono el laboratorio");

            }
        }
    }

    public void limpieza(ArrayList<Paciente> paciente){
        paciente.clear();
    }

}