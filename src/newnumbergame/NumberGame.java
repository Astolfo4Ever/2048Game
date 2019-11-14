package newnumbergame;

/**
 *
 * @author mikper222
 */
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Jonathan Larsson
 * @author G.I Buttwipere
 */
public class NumberGame extends JFrame {

    GamePanel panel = new GamePanel();
    File file = new File("src/spacewar/Webb/about.html");
    private long nanos;
    private final String TITLE = "2048";

    public NumberGame() throws HeadlessException {
        setContentPane(panel);
        fixMenu();
        setTitle(TITLE);
        setResizable(false);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        run();

    }

    private void run() {
        while (true) {
            panel.nextFrame();
            panel.repaint();
            long delay = 0;

            while (System.nanoTime() < nanos + delay) {
                Thread.yield();
            }
            nanos += delay;
        }

    }

    private void fixMenu() {
        JMenuBar bar = new JMenuBar();
        JMenu menu = new JMenu("New Game");
        JMenuItem item = new JMenuItem("New Game");

        JMenu about = new JMenu("About");
        JMenuItem aboutItem = new JMenuItem("About");
        JMenuItem aboutHTMLJFramePopup = new JMenuItem("aboutJFrame");

        
        JMenu save = new JMenu("Save");
        JMenuItem saveItem = new JMenuItem("Save");

        JMenu load = new JMenu("Load");
        JMenuItem loadItem = new JMenuItem("Load");

        setJMenuBar(bar);
        bar.add(menu);
        bar.add(about);
        bar.add(save);
        bar.add(load);
        menu.add(item);
        about.add(aboutItem);
        about.add(aboutHTMLJFramePopup);
        save.add(saveItem);
        load.add(loadItem);

        item.addActionListener(newGameLis());
        aboutItem.addActionListener(about());
        saveItem.addActionListener(save());
        loadItem.addActionListener(load());
        aboutHTMLJFramePopup.addActionListener(AboutPopup());
    }

    private ActionListener newGameLis() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                remove(panel);
                panel = new GamePanel();
                add(panel);
                validate();

            }
        };
    }

    public static void main(String[] args) {
        new NumberGame();
    }

    private ActionListener about() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Desktop.getDesktop().open(file);
                } catch (IOException ex) {
                }
            }
        };
    }

    private ActionListener save() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("G:\\Mina dokument\\spacewar.obj"));
                    oos.writeObject(panel);
                    oos.close();
                } catch (Exception ex) {
                }
            }
        };
    }

    private ActionListener load() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ObjectInputStream oos = new ObjectInputStream(new FileInputStream("G:\\Mina dokument\\spacewar.obj"));
                    GamePanel oldGame = (GamePanel) oos.readObject();
                    remove(panel);
                    setContentPane(oldGame);
                    validate();
                    oldGame.requestFocus();
                    panel = oldGame;
                    oos.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };
    }

    private ActionListener AboutPopup() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    URL url = NumberGame.class.getResource("Webb/about.html");

                    JEditorPane pane = new JEditorPane(url);
                    JFrame popupFrame = new JFrame();
                    popupFrame.setContentPane(pane);
                    popupFrame.setSize(600, 400);
                    popupFrame.setVisible(true);
                    popupFrame.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosing(WindowEvent e) {
                            popupFrame.setVisible(false);
                        }
                    });
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        };
    }
}