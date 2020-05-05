import javax.swing.*;
import java.awt.*;

public class WordFrame extends JFrame {

    public WordFrame(JTabbedPane myNewTab) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(1200, 800));
        this.setTitle("Microsoft Word 2020");
        this.add(myNewTab);
        this.pack();
        this.setVisible(true);
    }

}
