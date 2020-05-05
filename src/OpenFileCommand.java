public class OpenFileCommand implements Command {
    private NewPage newPage;
    private String path;

    public OpenFileCommand(NewPage newPage, String path) {
        this.newPage = newPage;
        this.path = path;
    }

    @Override
    public void execute() {
        newPage.getText(path);
    }
}
