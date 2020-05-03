import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main {
    public static void main(String[] args) {
        Writer writer = new Writer();
        NewPage myPage = new NewPage();
        WordFrame myFrame = new WordFrame(myPage);
        Menu myMenu = new Menu();
        /*Menu BAR addition*/
        myFrame.setJMenuBar(myMenu);

        myPage.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_B){
                    e.consume();
                    BoldCommand boldCmd = new BoldCommand(myPage);
                    writer.takeCommand(boldCmd);
                    writer.executeCommand();
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

    }
}
