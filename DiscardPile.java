import java.util.Random;

class DiscardPile extends CardPile 
{   
  // constructors
    public DiscardPile (int x, int y) { super (x, y); }

  // mutators
    public void addCard (Card aCard) 
    {   if (! aCard.faceUp())
            aCard.flip();
        super.addCard(aCard);
    }

    public void select (int tx, int ty, CardPile[] allPiles) 
    {   if (isEmpty())
            return;
        Card topCard = pop();
        for (int i = 0; i < 4; i++)
            if (allPiles[2+i].canTake(topCard)) 
            {   allPiles[2+i].addCard(topCard);
                return;
            }
        for (int i = 0; i < 7; i++)
            if (allPiles[6+i].canTake(topCard)) 
            {   allPiles[6+i].addCard(topCard);
                return;
            }
        // nobody can use it, put it back on our list
        addCard(topCard);
    }
}