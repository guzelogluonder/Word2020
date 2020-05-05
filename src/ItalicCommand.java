public class ItalicCommand implements Command {
    private NewPage myPage;

    public ItalicCommand(NewPage page) {

        this.myPage = page;
    }

    @Override
    public void execute() {
        myPage.makeItalic();
    }
}
