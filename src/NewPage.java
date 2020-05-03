import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
}
