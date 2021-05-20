import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

class HexDumpPanel extends Panel
{
  // hier Referenzen fuer Komponenten
  // (Buttons, Textfields, Panels) vereinbaren
  private TextField address;
  private TextArea content;

  public HexDumpPanel()
  {
    setFont(new Font("Courier", Font.PLAIN, 30));
    setLayout(new BorderLayout());
    address = new TextField();
    content = new TextArea();
    content.setEditable(false);
    add(address, BorderLayout.NORTH);
    add(content, BorderLayout.CENTER);
    address.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        try {
          URL url = new URL(address.getText());
          URLConnection c = url.openConnection();
          //c.connect();
          InputStream input = c.getInputStream();
          HexDump dump = new HexDump(input);
          content.setText(dump.getHexString());
        } catch (Exception urle) {
          System.out.println(urle);
          System.exit(1);
        }
      }
    });
  }

  public static void main(String args[])
  {
      Frame F=new Frame();
      F.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent we){System.exit(0);}});
      HexDumpPanel P=new HexDumpPanel();
      F.add(P);
      F.pack();
      F.setVisible(true);
  }
}
