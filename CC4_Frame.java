import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.ObjectOutputStream;

public class CC4_Frame extends JFrame implements MouseListener {
    // Display message
    private String text = "";
    // the letter you are playing as
    private char player;
    // stores all the game data
    private GameData gameData = null;
    // output stream to the server
    ObjectOutputStream os;

    public CC4_Frame(GameData gameData, ObjectOutputStream os, char player)
    {
        super("Connect Four Game");
        // sets the attributes
        this.gameData = gameData;
        this.os = os;
        this.player = player;

        // adds a KeyListener to the Frame
        addMouseListener(this);

        // makes closing the frame close the program
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Set initial frame message
        if(player == 'X')
            text = "Waiting for Black to Connect";

        setSize(600,600);
        setResizable(false);
        setAlwaysOnTop(true);
        setVisible(true);
    }

    public void paint(Graphics g)
    {
        // draws the background
        g.setColor(Color.YELLOW);
        g.fillRect(0,0,getWidth(),getHeight());

        // draws the display text to the screen
        g.setColor(Color.RED);
        g.setFont(new Font("Times New Roman",Font.BOLD,30));
        g.drawString(text,20,55);

        // draws the tic-tac-toe grid lines to the screen
        int inc = 0;
        for(int i = 1; i <= 7; i++){
            inc += 70;
            g.setColor(Color.WHITE);
            g.fillOval(inc, 60 , 60,60);
        }
        inc = 0;
        for(int i = 1; i <= 7; i++){
            inc += 70;
            g.setColor(Color.WHITE);
            g.fillOval(inc, 130 , 60,60);
        }
        inc = 0;
        for(int i = 1; i <= 7; i++){
            inc += 70;
            g.setColor(Color.WHITE);
            g.fillOval(inc, 200 , 60,60);
        }
        inc = 0;
        for(int i = 1; i <= 7; i++){
            inc += 70;
            g.setColor(Color.WHITE);
            g.fillOval(inc, 270 , 60,60);
        }
        inc = 0;
        for(int i = 1; i <= 7; i++){
            inc += 70;
            g.setColor(Color.WHITE);
            g.fillOval(inc, 340 , 60,60);
        }
        inc = 0;
        for(int i = 1; i <= 7; i++){
            inc += 70;
            g.setColor(Color.WHITE);
            g.fillOval(inc, 410 , 60,60);
        }
        inc = 0;
        for(int i = 1; i <= 7; i++){
            inc += 70;
            g.setColor(Color.WHITE);
            g.fillOval(inc, 480 , 60,60);
        }
        /*g.setColor(Color.RED);
        for(int y =0;y<=1; y++)
            g.drawLine(0,(y+1)*133+60,getWidth(),(y+1)*133+60);
        for(int x =0;x<=1; x++)
            g.drawLine((x+1)*133,60,(x+1)*133,getHeight());*/

        // draws the player moves to the screen
        g.setFont(new Font("Times New Roman",Font.BOLD,70));
        for(int r=0; r<gameData.getGrid().length; r++)
            for(int c=0; c<gameData.getGrid().length; c++)
                g.drawString(""+gameData.getGrid()[r][c],c*133+42,r*133+150);
    }

    public void setText(String text) {
        this.text = text;
        repaint();
    }


    public void setTurn(char turn) {
        if(turn==player)
            text = "Your turn";
        else
        {
            text = turn+"'s turn.";
        }
        repaint();
    }

    public void makeMove(int c, int r, char letter)
    {
        gameData.getGrid()[r][c] = letter;
        repaint();
    }

  /*  @Override
    public void keyTyped(KeyEvent event) {
        char key = event.getKeyChar();
        int r;
        int c;

        // sets the row and column, based on the entered key
        switch(key)
        {
            case '1':
                r=0;
                c=0;
                break;
            case '2':
                r=0;
                c=1;
                break;
            case '3':
                r=0;
                c=2;
                break;
            case '4':
                r=1;
                c=0;
                break;
            case '5':
                r=1;
                c=1;
                break;
            case '6':
                r=1;
                c=2;
                break;
            case '7':
                r=2;
                c=0;
                break;
            case '8':
                r=2;
                c=1;
                break;
            case '9':
                r=2;
                c=2;
                break;
            default:
                r=c=-1;
        }
        // if a valid enter was entered, send the move to the server
        if(c!=-1) {
            try {
                os.writeObject(new CommandFromClient(CommandFromClient.MOVE, "" + c + r + player));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


   */


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int r = 0;
        if(getMousePosition().getX() >=140 && getMousePosition().getY() <=200)
        {
            r = 1;
        }
        if(getMousePosition().getX() >=210 && getMousePosition().getY() <=270)
        {
            r = 2;
        }
        if(getMousePosition().getX() >=280 && getMousePosition().getY() <=340)
        {
            r = 3;
        }
        if(getMousePosition().getX() >=350 && getMousePosition().getY() <=410)
        {
            r = 4;
        }
        if(getMousePosition().getX() >=420 && getMousePosition().getY() <=480)
        {
            r = 5;
        }
        if(getMousePosition().getX() >=490 && getMousePosition().getY() <=540)
        {
            r = 6;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
