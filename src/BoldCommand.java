public class BoldCommand implements Command{
    private NewPage myPage;

    public BoldCommand(NewPage page){
        this.myPage = page;
    }

    @Override
    public void execute() {
        myPage.makeBold();
    }
}
