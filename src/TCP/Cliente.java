package TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/*
 * @autor Angel Yesid Mondragón
 * @version 1.0.0
 */

public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// inicializo las variables del cliente
		// Host del servidor
		final String HOST = "127.0.0.1";
		// puerto del servidor
		final int PORT = 5000;
		
		DataInputStream in;
		DataOutputStream out;
		
		// Trato de hacer la conexión
		
		try {
			Socket sc = new Socket(HOST,PORT);
			
			in = new DataInputStream(sc.getInputStream());
			out = new DataOutputStream(sc.getOutputStream());
			
			out.writeUTF("Saludos desde el cliente");
			
			String mensaje = in.readUTF();
			
			System.out.println(mensaje);
			
			sc.close();
					
		}catch(IOException e) {
		    System.err.print(e);
		}
	
	}

}
