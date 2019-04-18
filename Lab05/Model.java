public class Model {

    private int alternate;

    public Model(){
        setAlternate(2);
    }

    public void resetGame()
    {
        setAlternate(1);
        for(int i = 0; i <= 8; i++)
        {
            View.buttons[i].setText("");
        }
    }

    public boolean gridFull() {
        int n = 0;
        for (int i = 0; i <= 8; i++) {
            if (View.buttons[i].getText().equals("")) {
                n++;
            }
        }

        return n == 0;
    }

    public int getAlternate() {
        return alternate;
    }

    private void setAlternate(int alternate) {
        this.alternate = alternate;
    }

    public void incrementAlternate(){
        this.alternate++;
    }
}
