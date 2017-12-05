
/**
 *  The {@code InvertIndexList} class is a ADT to store invert index of the address book.
 *  <p>
 *  This implementation uses array to store tokens.
 *  One token is an {@link element} which includes the invert index list
 *  <p>
 *  Author: Yi Zhang
 */
public class Q2InvertIndexList {
	private Q2Element [] dictionary; 
	private int pointerIndex = 0;
	
	/**
     * Default constructor
     * Initialize the array with 100 elements
     */
	public Q2InvertIndexList(){
		dictionary = new Q2Element[100];
	}
	
	/**
     * Search the dictionary with the target string
     * @param str target string 
     * @return Return true if found
     */
	public boolean contain(String str){
		str = str.trim();
		if(pointerIndex  == 0 ) 
			return false;
		else
		{
			for(int i = 0; i<pointerIndex;i++){
				if(dictionary[i].getKey().toLowerCase().compareTo(str.toLowerCase()) == 0)
					return true;
			}
		}
		return false;
	}
	
	/**
     * Add to the list if it is the first occurrence 
     * @param str key  
     * @param index position
     */
	public void addNew(String str, int index){
		str = str.trim();
		if(pointerIndex < dictionary.length)
		{
			dictionary[pointerIndex] = new Q2Element(str,index);
			pointerIndex++;
		}
		else
		{
			expand();
			dictionary[pointerIndex] = new Q2Element(str,index);
			pointerIndex++;
		}
	}
	
	/**
     * Add to the list if there is a duplicate  
     * @param str key
     * @param index position in the list 
     */
	public void add(String str, int index){
		str = str.trim();
		for(int i = 0; i<pointerIndex;i++){
			if(dictionary[i].getKey().toLowerCase().compareTo(str.toLowerCase()) == 0)
			{
				if(pointerIndex < dictionary.length)
				{
					dictionary[i].addToList(index);
					break;
				}
				else
				{
					expand();
					dictionary[i].addToList(index);
					break;
				}
			}
		}
	}
	
	/**
     * Expand the array if it is full 
     */
	private void expand(){
		Q2Element [] list_temp = dictionary.clone();
		dictionary = new Q2Element [dictionary.length*2];
		for(int i = 0;i<list_temp.length;i++){
			dictionary[i] = list_temp[i];
		}
	}
	
	/**
     * Retrun the search result(list)  
     * @param str string
     * @return index array 
     */
	public int[] returnList(String str){
		str = str.trim();
		if(this.contain(str)){
			for(int i = 0; i<pointerIndex;i++){
				if(dictionary[i].getKey().toLowerCase().compareTo(str.toLowerCase()) == 0)
				{
					//dictionary[i].print();
					return dictionary[i].getList();
				}
			}
		}
		return null;
	}
}
