import java.net.*;
import java.io.*;

public class DatagramServer {

  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("ERROR] Usage: java DatagramServer <Port>");
      System.exit(1);
    }
    int port = 0;
    try {
      port = Integer.parseInt(args[0]);
    } catch (Exception e) {
      System.out.println("[ERROR] Usage: java DatagramServer <Port>");
      System.exit(1);
    }
    //leeres Datagramm bereitstellen
    DatagramPacket packr = new DatagramPacket(new byte[1024], 1024);
    //Sende-/Empfangssocket mit Port aus Argument
    DatagramSocket ds = null;
    try {
      ds = new DatagramSocket(port);
      System.out.println("[INFO] server running on " + ds.getInetAddress().getLocalHost() + ":" +ds.getLocalPort());
    } catch (SocketException e) {
      System.out.println("[ERROR] SocketException on port " + port);
      System.exit(2);
    } catch (UnknownHostException uhe) {
      System.out.println("[ERROR] server running");
    }

    while (ds != null) {
      //warten auf Empfang
      try {
        ds.receive(packr);
      } catch (IOException e) {
        System.out.println("[ERROR] IOException while receiving");
        System.exit(3);
      }
      System.out.println("[REQUEST] Received from: " + packr.getAddress() + ":" + packr.getPort());
      //Paket auspacken
      String messr = new String(packr.getData(), 0, packr.getLength());
      //System.out.println(messr);
      //Antwort bauen
      Weekday w = null;
      //Wochentag objekt erstellen mit Daten aus Datagram
      try {
        // "." muss escaped werden, da es als reg. Ex. für jedes Zeichen steht,
        //und nochmal damit Java den Slash übergibt
         w = new Weekday(messr.split("\\."));
      } catch(NumberFormatException nfe) {
        w.setIllegal(true);
      }

      //Wochentag berechnen
      byte[] answer = w.getWeekdayString().getBytes();
      if (w.isIllegal()) {
        System.out.println("[FAILURE] Illegal date: " + w.getDay() + "." + w.getMonth() + "." + w.getYear());
      } else {
        System.out.println("[SUCCESS] date: " + w.getDay() + "." + w.getMonth() + "." + w.getYear() + " --> " + w.getDateDay());
      }

      //Antworten
      DatagramPacket packetAnswer = new DatagramPacket(answer, answer.length, packr.getAddress(), packr.getPort());
      try {
        ds.send(packetAnswer);
        System.out.println("[ANSWER] Send to: " + packr.getAddress() + ":" + packr.getPort() + "\n");
      } catch (UnknownHostException uhe) {
        System.out.println("[ERROR] UnknownHostException");
        System.exit(4);
      } catch (SocketException se) {
        System.out.println("[ERROR] SocketException");
        System.exit(5);
      } catch (IOException ioe) {
        System.out.println("[ERROR] IOException while sending");
        System.exit(6);
      }
    }
    //ds.close();
  }
}
