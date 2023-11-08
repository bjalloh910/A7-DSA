import java.util.Collections;

  /**
   * The SelectionSort class provides a static method to sort a CardPile using the Selection Sort algorithm.
   * It also includes a main method to demonstrate the sorting process.
   */
public class SelectionSort {

  /**
   * Sorts a CardPile using the Selection Sort algorithm and records the sorting process.
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
    // Here is where you'll do the "work" of SelectionSort:
    //   - Use sorted to store the "sorted portion"
    //   - Don't forget to register the new state with the
    //     recorder after each card is transferred:
    //        record.next();        // tell it this is a new step
    //        record.add(sorted);   // the sorted pile
    //        record.add(unsorted); // the unsorted pile
    // ***********************************************************

    /* (Selection Sort)
     Use two iterators, one to traverse the loop element by element and the other to hold the place of the smallest element seen so far, so you get a stable sort.
     
    1. create a a pointer to keep track of the smallest element 
    2. create a pointer to iterate through the list 
    1. while the unsorted isn't empty 
    2. keep moving to the next node
    3. if current node is smaller than.. current smallest element 
        -add it to the sorted list 
        else 
        -keep iterating 
    4. return the sorted list
    */
   // cardpile == ll and card == node
    while(!unsorted.isEmpty()){
     Card min = unsorted.getFirst(); 
     for( Card i: unsorted){
      if(min.compareTo(i) > 0){ //comparing a & b.. if it returns a positive that means a is bigger and it it returns a negative b is bigger
        min = i;    // if i(currentcard we're looking at is greater 0 meaning it return a positive we make the current the new min)
      }
     }
      sorted.add(min);      // add the min to sorted
      unsorted.remove(min); //remove from unsorted
       
      /* This part allows to see it  */
      // register the new state with the recorder:
      record.next(); // tell it this is a new step
      record.add(sorted); // the allegedly sorted pile
      record.add(unsorted); // the unsorted pile}}
    }
    // return the sorted result here
    return sorted;
  
  }
  /**
   * Starts the program running. It sets up a class to record and display the sorting results,
   * sets up the deck of cards, and demonstrates the Selection Sort algorithm.
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
    cards = SelectionSort.sort(cards, recorder);

    // We can print out the (un)sorted result:
    System.out.println(cards);

    // make window appear showing the record
    recorder.display("Card Sort Demo: FakeSort");
  }
}
