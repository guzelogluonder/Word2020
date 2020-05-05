import javax.swing.*;
import java.awt.event.KeyEvent;
import java.nio.channels.ConnectionPendingException;

public class Menu extends JMenuBar {
    JMenu menu = new JMenu("File");
    JMenuItem open = new JMenuItem("Dosya Ac");
    JMenuItem save = new JMenuItem("Dosya Kaydet");
    JMenuItem newFile = new JMenuItem("Yeni Dosya");
    JMenuItem share = new JMenuItem("Dosyayı Paylaş");

    public Menu() {

        menu.add(save);
        menu.add(open);
        menu.add(newFile);
        menu.add(share);
        this.add(menu);
    }
}
