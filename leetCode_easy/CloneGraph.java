/*
 * OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
 */

package leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */

public class CloneGraph {

	public static UndirectedGraphNode cloneGraph(UndirectedGraphNode root1) {
		if(root1==null){
			return null;
		}
		UndirectedGraphNode root2;
		Set<Integer> visited=new HashSet<Integer>();
		root2=cloneGraph(root1, visited);
		return root2;
	}
	
	private static UndirectedGraphNode cloneGraph(UndirectedGraphNode root1, Set visited){
		visited.add(root1.label);
		System.out.println("visited root: "+root1.label+"\n"+"copy of node: "+root1.label);
		UndirectedGraphNode root2=new UndirectedGraphNode(root1.label);
		for(UndirectedGraphNode node:root1.neighbors){
			root2.neighbors.add(node);
			System.out.println("child node for "+root1.label+" is: "+node.label);
			if(!visited.contains(node.label)){
				System.out.println(node.label+" has not been visited");
				cloneGraph(node, visited);
			}
		}
		System.out.println("returned root2: "+root2.label);
		return root2;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UndirectedGraphNode zero=new UndirectedGraphNode(0);
		UndirectedGraphNode one=new UndirectedGraphNode(1);
		UndirectedGraphNode two=new UndirectedGraphNode(2);
		zero.neighbors.add(one);
		zero.neighbors.add(two);
		one.neighbors.add(zero);
		one.neighbors.add(two);
		two.neighbors.add(zero);
		two.neighbors.add(one);
		two.neighbors.add(two);
		UndirectedGraphNode cloneOne=cloneGraph(zero);
		System.out.println();
		printGraph(cloneOne);
		System.out.println();
		printGraph(zero);
	}

	private static void printGraph(UndirectedGraphNode root) {
		Set<Integer> visit=new HashSet<Integer>();
		printGraph(root, visit);
	}

	private static void printGraph(UndirectedGraphNode root, Set<Integer> visit) {
		visit.add(root.label);
		//System.out.println("root value: "+root.label);
		System.out.println(root.label);
		for(UndirectedGraphNode neighbor:root.neighbors){
			//System.out.println("neighbor: "+neighbor.label);
			if(!visit.contains(neighbor.label)){
				printGraph(neighbor, visit);
			}
		}
	}
	
	public static void addNodes(String list){
		list=list.replaceAll("\\s+", "");
		for(int i=0; i<list.length(); i++){
			if(list.charAt(i)=='#' || list.charAt(i)==','){
				continue;
			}
		}
	}

}
