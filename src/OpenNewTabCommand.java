public class OpenNewTabCommand implements Command {

    private NewPage myPage;

    public OpenNewTabCommand(NewPage page) {
        this.myPage = page;
    }

    @Override
    public void execute() {
        myPage.openNewTab();
    }
}
