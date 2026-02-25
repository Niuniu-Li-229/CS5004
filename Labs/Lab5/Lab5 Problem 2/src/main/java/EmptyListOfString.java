/**
 * Represents the empty (base-case) node of a linked list of Strings.
 */
public class EmptyListOfString implements ListOfStrings {

  public EmptyListOfString(){};

  @Override
  public boolean isEmpty(){
    return true;
  }

  @Override
  public int size(){
    return 0;
  }

  @Override
  public boolean contains(String s){
    return false;
  }

  @Override
  public boolean containsAll(ListOfStrings other){
    return true;
  }

  @Override
  public ListOfStrings filterLargerThan(int maxLength){
    return this;
  }

  @Override
  public boolean hasDuplicates(){
    return false;
  }

  @Override
  public ListOfStrings removeDuplicates(){
    return this;
  }

  @Override
  public String toString(){
    return "()";
  }
}
