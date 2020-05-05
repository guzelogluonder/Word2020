public class SaveFileCommand implements Command {

    private NewPage newPage;

    public SaveFileCommand(NewPage newPage) {
        this.newPage = newPage;
    }

    @Override
    public void execute() {
        newPage.writeText(newPage.getText());
    }
}
