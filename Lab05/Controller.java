import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 when a button is clicked, it generates an ActionEvent.
 */
public class Controller extends View implements ActionListener {
    private Model tModel;

    public Controller() {
        this.tModel = new Model();
        addAction();
    }

    public void actionPerformed(ActionEvent e) {

        JButton buttonClicked = (JButton) e.getSource(); //get the particular button that was clicked
        if (buttonClicked.getText().equals("")) {
            if (tModel.getAlternate() % 2 == 0) {
                buttonClicked.setText("1");
            } else {
                buttonClicked.setText("2");
            }

            if (checkForWin()) {
                JOptionPane.showConfirmDialog(null, "Player " + (tModel.getAlternate() % 2 + 1) + " wins");
                tModel.resetGame();
            } else if (tModel.gridFull()) {
                JOptionPane.showConfirmDialog(null, "Game is Over!");
                tModel.resetGame();
            }

            tModel.incrementAlternate();
        }
    }

    public boolean checkForWin() {
        /*
        Check for horizontal side
         */
        if (checkAdjacent(0, 1, 2))
            return true;
        else if (checkAdjacent(3, 4, 5))
            return true;
        else if (checkAdjacent(6, 7, 8))
            return true;

           /*
           Check for verticle side
            */
        else if (checkAdjacent(0, 3, 6))
            return true;
        else if (checkAdjacent(1, 4, 7))
            return true;
        else if (checkAdjacent(2, 5, 8))
            return true;

             /*
           Check for diagonal side
            */
        else if (checkAdjacent(0, 4, 8))
            return true;
        else return checkAdjacent(2, 4, 6); // This is the last test, if true game win, else not...
    }

    public boolean checkAdjacent(int a, int b, int c) {
        return buttons[a].getText().equals(buttons[b].getText()) && buttons[b].getText().equals(buttons[c].getText()) && !buttons[a].getText().equals("");
    }

    private void addAction() {
        for (int i = 0; i < 9; i++) {
            buttons[i].addActionListener(this);
        }
    }
}