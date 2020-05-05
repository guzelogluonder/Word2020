import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.lang.ref.WeakReference;

public class Main {

    public static void main(String[] args) {
        Writer writer = new Writer();
        NewPage firstPage = new NewPage();
        addPageKeyListener(firstPage, writer);
        NewTab myTab = new NewTab(firstPage);
        WordFrame myFrame = new WordFrame(myTab);
        ImageIcon word = new ImageIcon("images/word.png");
        myFrame.setIconImage(word.getImage());
        Menu myMenu = new Menu();
        /*Menu BAR addition*/
        myFrame.setJMenuBar(myMenu);
        myFrame.validate();
        myMenu.newFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewPage newPage = new NewPage();
                addPageKeyListener(newPage, writer);
                OpenNewTabCommand newTab = new OpenNewTabCommand(myTab, newPage);
                writer.takeCommand(newTab);
                writer.executeCommand();
            }
        });
        myMenu.open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileType;
                String filePath;
                NewPage newPage = new NewPage();
                addPageKeyListener(newPage, writer);
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    String fileName = selectedFile.getName();
                    fileType = fileName.substring(fileName.lastIndexOf("."), fileName.length());
                    filePath = selectedFile.getAbsolutePath();
                    String fileContent = "";
                    if (fileType.equals(".txt")) {
                        OpenFileCommand openFile = new OpenFileCommand(newPage, filePath);
                        writer.takeCommand(openFile);
                        writer.executeCommand();
                    }

                }

                OpenNewTabCommand newTab = new OpenNewTabCommand(myTab, newPage);
                writer.takeCommand(newTab);
                writer.executeCommand();
            }
        });

        myMenu.save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*
                 * 1. file chooser ile pathi a
                 * 1.a) file'ın path'ı ile birlijte new page'İn content'ini de commanda gönder.
                 * 2. bu pathi writefile command'a gönder
                 * 2.a) command'ın içinden new page'in içindeki writeText'i çağır.
                 * 3. o commanddan writer'a ver.
                 * 4.wrtierdan execute et.
                 * */

                NewPage currentPage = (NewPage) myTab.getSelectedComponent();
                SaveFileCommand saveFileCommand = new SaveFileCommand(currentPage);
                writer.takeCommand(saveFileCommand);
                writer.executeCommand();
                JOptionPane saveNews = new JOptionPane();
                saveNews.showMessageDialog(myFrame, "Dosyanız projenin altına kaydedildi");
            }
        });
        myMenu.share.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });


    }

    public static void addPageKeyListener(NewPage page, Writer writer) {
        page.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_K && e.isControlDown()) {
                    e.consume();

                    int start = page.getSelectionStart();
                    int end = page.getSelectionEnd();
                    if (start == end) { // No selection, cursor position.
                        return;
                    }
                    if (start > end) { // Backwards selection?
                        int life = start;
                        start = end;
                        end = life;
                    }
                    BoldCommand boldCmd = new BoldCommand(page, start, end);
                    writer.takeCommand(boldCmd);
                    writer.executeCommand();
                }

                if (e.getKeyCode() == KeyEvent.VK_E && e.isControlDown()) {
                    e.consume();

                    int start = page.getSelectionStart();
                    int end = page.getSelectionEnd();
                    if (start == end) { // No selection, cursor position.
                        return;
                    }
                    if (start > end) { // Backwards selection?
                        int life = start;
                        start = end;
                        end = life;
                    }

                    ItalicCommand ItalicCmd = new ItalicCommand(page, start, end);
                    writer.takeCommand(ItalicCmd);
                    writer.executeCommand();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

    }

}
