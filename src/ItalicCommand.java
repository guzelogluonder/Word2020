public class ItalicCommand implements Command {
    private NewPage myPage;
    private int startChar, endChar;
    public ItalicCommand(NewPage page, int startChar, int endChar) {

        this.myPage = page;
        this.startChar = startChar;
        this.endChar = endChar;
    }

    @Override
    public void execute() {
        myPage.makeItalic(startChar, endChar);
    }
}
