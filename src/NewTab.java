import javax.swing.*;

public class NewTab extends JTabbedPane {

    public NewTab(NewPage newPage) {
        this.addTab("tab", newPage);
    }

    public void openNewTab(NewPage myNewPage) {
        this.addTab("tab2", myNewPage);

    }
}
