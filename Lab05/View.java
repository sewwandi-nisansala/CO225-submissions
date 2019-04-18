import javax.swing.*;
import java.awt.*;

public class View extends JFrame {

    public static JButton[] buttons;

    public View() {
        setTitle("TicTacToe");
        setLayout(new GridLayout(3, 3));
        setBounds(400, 400, 400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttons = new JButton[9];

        for (int i = 0; i <= 8; i++) {
            buttons[i] = new JButton();
            buttons[i].setText("");

            add(buttons[i]); //adds this button to JPanel (note: no need for JPanel.add(...)
            //because this whole class is a JPanel already
        }

        setVisible(true);
    }
}