import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Deck {

	private int size;
	private Card[] cards;
	private int[] cardsVals;

	public Deck () {
		this.cards = new Card[36];
		this.cardsVals = new int[36];
		this.size = 36;

		int j = 0;
		int k = 0;

		for (int i = 0; i < 36; i++) {
			if (k == 9) {
				k = 0;
				j++;
			}
			this.cards[i] = new Card( Rank.values[k], Suit.values[j]);
			this.cardsVals[i] = i;
			k++;
		}
	}
    
    public void shuffle () {

    	Random rnd = ThreadLocalRandom.current();
    	for (int i = 0; i < this.size; i++) {
    		int index = rnd.nextInt(i+1);
    		Card a = this.cards[index];
    		int aa = this.cardsVals[index];
    		this.cards[index] = this.cards[i];
    		this.cardsVals[index] = this.cardsVals[i];
    		this.cards[i] = a;
    		this.cardsVals[i] = aa;
    	}

    }
    
    public void order () {

        int temp = 0;
        Card tempCard;  
         for(int i=0; i < this.size; i++){  
                 for(int j=1; j < (this.size-i); j++){  
                          if(this.cardsVals[j-1] > this.cardsVals[j]){  
                                 //swap elements  
                                 temp = this.cardsVals[j-1];
                                 tempCard = this.cards[j-1];  
                                 this.cardsVals[j-1] = this.cardsVals[j];
                                 this.cards[j-1] = this.cards[j];  
                                 this.cardsVals[j] = temp;
                                 this.cards[j]= tempCard;  
                         }  
                          
                 }  
         }

    }
    
    public boolean hasNext () {
    	if (this.size > 0) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public Card drawOne () {

    	this.size--;
    	return this.cards[this.size];

    } 

    public void printAllCards () {
    	for (int i = 0; i < this.size; i++) {
    		this.cards[i].printCard();
    	}
    }

    public void printSize () {
    	System.out.println(size);
    }
}  