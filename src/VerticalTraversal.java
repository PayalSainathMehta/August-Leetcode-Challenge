import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VerticalTraversal {
	//Since cant find Pair refer to Leetcode problem #987 for solution of this
	
	
	/*
	 * English solution
	 * 
	 * we have a map which stores column as key and Pair of row, node.val as value
	 * 
	 * we have a queue which has node, row, column
	 * 
	 * we have a method BFS that helps us fix the range which starts at minColumn 
	 * and ends at maxColumn
	 * 
	 * we traverse the queue and populate the map
	 * 
	 * we return to original function and implement custom comparator to sort values of map.get(i
	 * 
	 * if two have same key i.e. rows we sort by value i.e by node.val
	 * 
	 * we traverse the sorted map and form a sorted column in which we add the node.val
	 * 
	 * then we add this to output.
	 * 
	 * we return the output.
	 */
}
