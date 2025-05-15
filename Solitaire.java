import java.awt.*;
import java.awt.event.*;

public class Solitaire 
{ 
  // public class variables for the various card piles of game
    public DeckPile deckPile;
    public DiscardPile discardPile;
    public TablePile tableau [ ];
    public SuitPile suitPile [ ];
  // single array to alias all above piles -- to aid polymorphism
    public CardPile allPiles [ ];

  // application entry point
    static public void main (String[] args) 
    {   Solitaire world = new Solitaire(); }

  // constructors
    public Solitaire () 
    {   window = new SolitaireFrame();
        init();
        window.show();
    }

  // mutators
    public void init () 
    {       // first allocate the arrays
        allPiles = new CardPile[13];
        suitPile = new SuitPile[4];
        tableau = new TablePile[7];
            // then fill them in
        allPiles[0] = deckPile = new DeckPile(335, 30);
        allPiles[1] = discardPile = new DiscardPile(268, 30);
        for (int i = 0; i < 4; i++)
            allPiles[2+i] = suitPile[i] =
                new SuitPile(15 + (Card.width+10) * i, 30);
        for (int i = 0; i < 7; i++)
            allPiles[6+i] = tableau[i] =
                new TablePile(15 + (Card.width+5) * i, Card.height + 35, i+1, deckPile); 
    }

  // inner classes
    // part of Class Solitaire
    private class SolitaireFrame extends Frame 
    {
        private class RestartButtonListener implements ActionListener 
        {   
            public void actionPerformed (ActionEvent e) 
            {   init();
                window.repaint();
            }
        }

        private class MouseKeeper extends MouseAdapter 
        {   
            public void mousePressed (MouseEvent e) 
            {  
              int x = e.getX();
                int y = e.getY();
                for (int i = 0; i < 13; i++)
                    if (allPiles[i].includes(x, y)) 
                    {   //Passing allpiles instance variable as argument so that multiple instances can be played
                        allPiles[i].select(x, y, allPiles);
                        repaint();
                    }
            }
        }

        public SolitaireFrame() 
        {   setSize(600, 500);
            setTitle("Solitaire Game");
            addMouseListener (new MouseKeeper());
            Button restartButton = new Button("New Game");
            restartButton.addActionListener(new RestartButtonListener());
            add("South", restartButton);
        }

        public void paint(Graphics g) 
        {   for (int i = 0; i < 13; i++) 
                allPiles[i].display(g);
        }
    }

  // internal data fields
    private Frame window;  // the application window
    
    
}