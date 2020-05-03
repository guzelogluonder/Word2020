import javax.swing.*;

public class Menu extends JMenuBar {

    JMenuItem open =  new JMenuItem("Dosya Ac");
    JMenuItem kaydet =  new JMenuItem("Dosya Kaydet");

    JMenu menu = new JMenu("File");
    public Menu(){

        menu.add(kaydet);
        menu.add(open);

        this.add(menu);
    }
}
