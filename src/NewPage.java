import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class NewPage extends JTextPane {
    // text;

    public NewPage() {
        //this.setText(text);
    }

    public void makeBold() {
        //this.setText(text);
        this.setFont(this.getFont().deriveFont(Font.BOLD, this.getFont().getSize()));

        /*StyledDocument doc = (StyledDocument) this.getDocument();
        int selectionEnd = this.getSelectionEnd();
        int selectionStart = this.getSelectionStart();
        System.out.println(selectionStart +  " == " + selectionEnd);
        if (selectionStart == selectionEnd) {
            return;
        }

        Element element = doc.getCharacterElement(selectionStart);
        AttributeSet as = element.getAttributes();

        MutableAttributeSet asNew = new SimpleAttributeSet(as.copyAttributes());
        StyleConstants.setBold(asNew, !StyleConstants.isBold(as));
        doc.setCharacterAttributes(selectionStart, this.getSelectedText()
                .length(), asNew, true);
        String text = (StyleConstants.isBold(as) ? "Cancel Bold" : "Bold");
        this.setText(text);*/
    }

    public void makeItalic() {
        this.setFont(this.getFont().deriveFont(Font.ITALIC, this.getFont().getSize()));
    }

    public void getText(String path) {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(path), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setText(contentBuilder.toString());
    }

    public void writeText(String text) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("test.txt"));
            writer.write(text);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

