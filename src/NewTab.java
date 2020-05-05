import javax.swing.*;

public class NewTab extends JTabbedPane {

    public NewTab(NewPage newPage) {
        this.addTab("Tab", newPage);
    }

    public void openNewTab(NewPage myNewPage) {
        this.addTab("Tab", myNewPage);

    }
}
