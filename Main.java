package Hospital_Las_Vegas;
import java.util.ArrayList;
import java.util.Scanner;

public class Main extends Paciente{

    public static void main(String args[]){

        Registro registro = new Registro();

        System.out.println("¿ Cuantos pacientes van a ingresar ?");

            Scanner i = new Scanner(System.in);
            int e = i.nextInt();

        SistemaUrgencias lasVegas = new SistemaUrgencias();

        // Ingresar los pacientes a el sistema

        for(int x = 0; e>x; x++){
            Paciente paciente = new Paciente();
            Aleatorios crear = new Aleatorios();

            String nombre = crear.generarNombres();
            String triaje = crear.generarTriaje();

            paciente.setNombre(nombre);
            paciente.setCodigoTriage(triaje);

            lasVegas.triage(paciente);

        }

        // Atendemos a cada lista de personas segun su urgencia
        ArrayList<Paciente> azul = lasVegas.getCodigoAzul();
        lasVegas.atencionMedica(azul);
        System.out.println("\n");
        System.out.println("Recuento de pacientes: "+ azul.size());
        System.out.println("::Se atendieron todos los pacientes de codigo azul::");
        System.out.println("\n");

        registro.escribirRegistro("\n");
        registro.escribirRegistro("Recuento de pacientes: "+ azul.size());
        registro.escribirRegistro("::Se atendieron todos los pacientes de codigo azul::");
        registro.escribirRegistro("\n");

        ArrayList<Paciente> urgente = lasVegas.getUrgente();
        lasVegas.atencionMedica(urgente);
        System.out.println("\n");
        System.out.println("Recuento de pacientes: "+ urgente.size());
        System.out.println("::Se atendieron todos los pacientes urgentes::");
        System.out.println("\n");

        registro.escribirRegistro("\n");
        registro.escribirRegistro("Recuento de pacientes: "+ urgente.size());
        registro.escribirRegistro("::Se atendieron todos los pacientes urgentes::");
        registro.escribirRegistro("\n");

        ArrayList<Paciente> normal = lasVegas.getNormal();
        lasVegas.atencionMedica(normal);
        System.out.println("\n");
        System.out.println("Recuento de pacientes: "+ normal.size());
        System.out.println("::Se atendieron todos los pacientes en prioridad normal::");
        System.out.println("\n");

        registro.escribirRegistro("\n");
        registro.escribirRegistro("Recuento de pacientes: "+ normal.size());
        registro.escribirRegistro("::Se atendieron todos los pacientes en prioridad normal::");
        registro.escribirRegistro("\n");

        ArrayList<Paciente> leve = lasVegas.getLeve();
        lasVegas.atencionMedica(leve);
        System.out.println("\n");
        System.out.println("Recuento de pacientes: "+ leve.size());
        System.out.println("::Se atendieron todos los pacientes en prioridad leve::");
        System.out.println("\n");

        registro.escribirRegistro("\n");
        registro.escribirRegistro("Recuento de pacientes: "+ leve.size());
        registro.escribirRegistro("::Se atendieron todos los pacientes en prioridad leve::");
        registro.escribirRegistro("\n");


        // informe de las salidas y limpieza de las listas
        lasVegas.salidaPaciente(azul);
        lasVegas.limpieza(azul);

        lasVegas.salidaPaciente(urgente);
        lasVegas.limpieza(urgente);

        lasVegas.salidaPaciente(normal);
        lasVegas.limpieza(normal);

        lasVegas.salidaPaciente(leve);
        lasVegas.limpieza(leve);

        // Atendemos a los del laboratorio solo si hay más de 10

        ArrayList<Paciente> laboratorio = lasVegas.getLaboratorio();
        lasVegas.laboratorio(laboratorio);

    }
}
