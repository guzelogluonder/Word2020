public class OpenNewTabCommand implements Command {
    private NewPage myNewPage;
    private NewTab myTab;

    public OpenNewTabCommand(NewTab newTab, NewPage newPage) {
        this.myNewPage = newPage;
        this.myTab = newTab;
    }

    @Override
    public void execute() {
        myTab.openNewTab(myNewPage);
    }
}
