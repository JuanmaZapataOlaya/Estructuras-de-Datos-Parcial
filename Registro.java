package Hospital_Las_Vegas;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Registro{

    public void escribirRegistro(String mensaje) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Informe_Urgencias.txt", true))) {
            writer.write(mensaje);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
