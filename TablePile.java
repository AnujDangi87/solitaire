import java.util.Enumeration;
import java.awt.*;
import java.util.Stack;

class TablePile extends CardPile { // constructors
    public TablePile(int x, int y, int c, DeckPile deckpile) { // initialize the parent class
        super(x, y);
        // then initialize our pile of cards
        for (int i = 0; i < c; i++) {
            addCard(deckpile.pop());
        }
        // flip topmost card face up
        top().flip();
    }

    // mutators
    public void select(int tx, int ty, CardPile[] allPiles) {
        if (isEmpty())
            return;

        Card topCard = top();
        if (!topCard.faceUp()) {
            topCard.flip();
            return;
        }

        //card stack to store the selected card
        Stack selectPile = new Stack();

        //finding which card is being clicked on its pos start form 0, 1, 2 etc
        int pos = (int) ((ty - y) / 35);

        //If pos is greater or equal than the size of pile then pick the top card
        if (thePile.size() <= pos)  { pos = thePile.size()-1; }

        //The size of card which have been selected
        int size = thePile.size() - pos;

        //Initialize the cards
        //Pop form pile and insert into selected pile stack
        for (int i = 0; i < size; i++) 
        {
            selectPile.push(thePile.pop());
        }
        //The card which have been clicked on
        topCard = (Card)selectPile.peek();

        //Check if selected card stack top card is available to transfer
        if(topCard.faceUp())
        {
            //Insert into suite pile only if a single card is selected
            if(size == 1)
            {
                for (int i = 0; i < 4; i++)
                    if (allPiles[2 + i].canTake(topCard)) {
                        allPiles[2 + i].addCard(topCard);
                        flipNext();
                        return;
                    }
            }

            // else see if any other table pile can take card
            for (int i = 0; i < 7; i++)
            {
                if (allPiles[6 + i].canTake(topCard)) 
                {
                    for(int j = 0;j < size;j++)
                    {
                        allPiles[6 + i].addCard((Card)selectPile.pop());
                    }
                    flipNext();
                    return;
                }
            }
        }

        // else put the selected cards back on our pile
        for (int i = 0;i < size;i++) 
        {
            thePile.push(selectPile.pop());
        }
    }

    //Method to top flip card if any card is transfered from current table
    public void flipNext()
    {
        if (isEmpty())
        return;

        Card topCard = top();
        if (!topCard.faceUp()) {
            topCard.flip();
            return;
        }
    }

    // accessors
    public boolean canTake(Card aCard) {
        if (isEmpty())
            return aCard.rank() == 12;
        Card topCard = top();
        return (aCard.color() != topCard.color()) &&
                (aCard.rank() == topCard.rank() - 1);
    }

    public boolean includes(int tx, int ty) { // don't test bottom of card
        return x <= tx && tx <= x + Card.width && y <= ty;
    }

    public void display(Graphics g) {
        int localy = y;
        for (Enumeration e = thePile.elements(); e.hasMoreElements();) {
            Card aCard = (Card) e.nextElement();
            aCard.draw(g, x, localy);
            localy += 35;
        }
    }
}