public class BoldCommand implements Command {
    private NewPage myPage;
    private int startChar;
    private int endChar;
    public BoldCommand(NewPage page, int startChar, int endChar) {
        this.myPage = page;
        this.startChar = startChar;
        this.endChar = endChar;
    }

    @Override
    public void execute() {
        myPage.makeBold(startChar, endChar);

    }
}
