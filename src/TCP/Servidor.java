package TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * @autor Angel Yesid Mondragón
 * @version 1.0.0
 */

public class Servidor {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//inicializamos las variables de nuestro servidor TCP
		ServerSocket servidor = null;
		Socket sc = null;
		DataInputStream in = null;
		DataOutputStream out = null;
		// Asigno el puerto
		final int PORT = 5000;
		
		
		try {
		servidor = new ServerSocket(PORT);
		System.out.println("inicializando el servidor");
		while(true) {
			// se queda esperando la petición por parte de un cliente
			// me devuelve el socket del cliente 
			sc = servidor.accept();
			// creo los puentes del servidor
			
			System.out.println("Cliente conectado");
			// camino del cliente al servidor, leo las peticiones del cliente 
			in = new DataInputStream(sc.getInputStream());
			
			//camino servidor al cliente, envio respuesta del servidor
			out = new DataOutputStream(sc.getOutputStream());
			
			// Leo los mensajes
			String mensaje = in.readUTF();
			
			// Imprimo el mensaje 
			System.out.println(mensaje);
			
			out.writeUTF("Mensaje recibido, saludos desde el servidor");
			
			// Cierro la conexión 
			sc.close();
		}
		
		
		}catch(IOException e) {
		  System.err.print(e);
		  System.out.println("Error al leavantar el servidor");
		}	

	}

}
