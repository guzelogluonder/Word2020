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

    public NewPage() {
        //this.setText(text);
    }

    public void makeBold(int startChar, int endChar) {
        final Style style = this.addStyle("Bold", null);
        StyleConstants.setBold(style, true);
        this.getStyledDocument().setCharacterAttributes(startChar, endChar - startChar, style, false);
    }

    public void makeItalic(int startChar, int endChar) {
        final Style style = this.addStyle("Italic", null);
        StyleConstants.setItalic(style, true);
        this.getStyledDocument().setCharacterAttributes(startChar, endChar - startChar, style, false);
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

