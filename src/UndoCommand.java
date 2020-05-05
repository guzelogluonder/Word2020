import javax.swing.*;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;

public class UndoCommand implements Command {
    private NewPage newPage;

    public UndoCommand(NewPage page){
        this.newPage = page;
    }

    @Override
    public void execute() {
        newPage.undoPage();
    }
}
