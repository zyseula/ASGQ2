
/**
 *  The {@code element} class is a ADT to store contacts information {@link InvertIndexList}.
 *  <p>
 *  This class contain one key for searching, one list(array) for storing index list.
 *  Pointer is used to specified to point the insertion index of the array
 *  <p>
 *  Author: Yi Zhang
 */
public class Q2Element {
	private String key;
	private int [] list = new int[10];
	private int pointer = 0;
	
	/**
     * Constructor
     * @param str key 
     * @param index position in the list
     */
	public Q2Element(String str,int index){
		this.key = str;
		this.list[pointer] = index;
		pointer++;
		for(int i = pointer;i<list.length;i++){
			list[i] = -1;
		}
	}
	
	/**
     * Get key
     * @return key
     */
	public String getKey(){
		return key;
	}
	
	/**
     * Get list
     * @return Return list
     */
	public int [] getList(){
		return list;
	}
	
	/**
     * Print this entry
     */
	public void print(){
		System.out.println("Key is "+key+"; list is: ["+printList()+"]");
	}
	
	/**
     * Get list as string
     * @return list as string
     */
	public String printList(){
		String temp = "";
		for(int  i= 0;i<pointer;i++)
			temp =list[i]+",";
		return temp;
	}
	
	/**
     * Add the index to the list if it duplicate 
     * @param index  the position index of the entry in the array
     */
	public void addToList(int index){
		if(pointer < list.length){
			list[pointer] = index;
			pointer++;
		}
		else{
			listExpend();
			list[pointer] = index;
			pointer++;
		}
	}
	
	/**
     * Expand the array if it is full
     */
	private void listExpend(){
		int [] list_temp = list.clone();
		list = new int [list.length*2];
		for(int i = 0;i<list_temp.length;i++){
			list[i] = list_temp[i];
		}
		for(int i = pointer;i<list.length;i++){
			list[i] = -1;
		}
	}
}
