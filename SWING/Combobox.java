import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

class Combobox extends Panel{

    JComboBox b;
    public void Combobox()
    {
        Vector<String> v=new Vector<String>();
        v.add("Klein Bubi");
        v.add("Klein Erna");
        v.add("Frau Pumeier");
        b=new JComboBox(v);
        add(b) ;
        b.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e)
            {
                System.out.println((String)(b.getSelectedItem()));
            }
        });
		return;
}

public static void main(String args[]){
    Combobox cb = new Combobox();
    Frame f = new Frame("Box");
    f.add(cb);
    f.addWindowListener(new WindowAdapter(){
                        public void windowClosing(WindowEvent e){
                        System.exit(0);
                        }
    });
    f.setVisible(true);
    f.pack();
}

}
