import java.util.*;

/**
 * The InsertionSort class provides a static method to sort a CardPile using the Insertion Sort algorithm.
 * It also includes a main method for demonstration purposes.
 */
public class InsertionSort {
   /**
   * Sorts a CardPile using the Insertion Sort algorithm and records the sorting process.
   * 
   * @param unsorted The unsorted CardPile to be sorted.
   * @param record   A SortRecorder object to record the sorting process.
   * @return         The sorted CardPile.
   */
  
  public static CardPile sort(CardPile unsorted, SortRecorder record) {
    
    // register the starting configuration with the recorder
    record.add(unsorted);

    // Here is the result list you will be creating
    CardPile sorted = new CardPile();
  
    // ***********************************************************
    // Here is where you'll do the "work" of InsertionSort:
    //   - Use sorted to store the "sorted portion"
    //   - Don't forget to register the new state with the
    //     recorder after each card is transferred:

    // ***********************************************************

    // return the sorted result here

    Card firstCard = unsorted.remove(); 
    sorted.add(firstCard);

    while(!unsorted.isEmpty()){
      Card c = unsorted.remove();

      if(c.compareTo(sorted.getFirst()) > 0){ //if the currentcard is less than c 
        sorted.addFirst(c); // then make it the first card

        // register the new state with the recorder:
        record.next(); // tell it this is a new step
        record.add(sorted); // the allegedly sorted pile
        record.add(unsorted); // the unsorted pile
      } else {
        ListIterator<Card> pos = sorted.listIterator(sorted.size()); //going to iterate starting from the back of sorted 
        Card lastCard = pos.previous();
        while(pos.hasPrevious() && c.compareTo(lastCard) < 0){
          lastCard = pos.previous();
        }
        sorted.insertAfter(c, lastCard);
        
        // register the new state with the recorder:
        record.next(); // tell it this is a new step
        record.add(sorted); // the allegedly sorted pile
        record.add(unsorted); // the unsorted pile
      }
    }
    return sorted;
  }
  /**
   * Starts the program running. It sets up a class to record and display the sorting results,
   * sets up the deck of cards, and demonstrates the insertion sort algorithm.
   * 
   * @param args The command-line arguments (not used in this program).
   */
  /** Starts the program running */
  public static void main(String args[]) {

    // set up a class to record and display the sorting results
    SortRecorder recorder = new SortRecorder();

    // set up the deck of cards
    Card.loadImages(recorder);
    CardPile cards = new CardPile(Card.newDeck(true), 2, 2);

    // for debugging purposes, uncomment this to
    // work with a smaller number of cards:
    // cards = cards.split(cards.get(39));

    // mix up the cards
    Collections.shuffle(cards);

    // if you want to sort in array form, use:
    Card[] card_arr = cards.toArray(new Card[0]);

    // in your program, this would be a call to a real sorting algorithm
    cards = InsertionSort.sort(cards, recorder);

    // We can print out the (un)sorted result:
    System.out.println(cards);

    // make window appear showing the record
    recorder.display("Card Sort Demo: FakeSort");
  }
}