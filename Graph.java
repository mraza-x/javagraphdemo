import java.util.*;
import java.io.*;

public class Graph
{
	protected int maxSize;
	protected int gSize;
	protected LinkedList[] graph;

	public Graph()
	{
		maxSize = 100;
		gSize = 0;
		graph = new LinkedList[maxSize];

		for(int i = 0; i < maxSize; i++)
			graph[i] = new LinkedList<Integer>();
	}

	public Graph(int size)
	{
		maxSize = size;
		gSize = 0;
		graph = new LinkedList[maxSize];

		for(int i = 0; i < maxSize; i++)
			graph[i] = new LinkedList<Integer>();
	}

	public boolean isEmpty()
	{
		return (gSize == 0);
	}

	public void createGraph()
	{
		Scanner console = new Scanner(System.in);

		String fileName;

		if(gSize != 0)
			clearGraph();

		Scanner infile = null;

		try
		{
			System.out.print("Enter input file name: ");
			fileName = console.nextLine();
			System.out.println();
			infile = new Scanner(new FileReader(fileName));
		}

		catch (FileNotFoundException fnfe)
		{
			System.out.println(fnfe.toString());
			System.exit(0);
		}

		gSize = infile.nextInt();

		for(int index = 0; index < gSize; index++)
		{

			int vertex = infile.nextInt();
			int adjacentVertex = infile.nextInt();

			while(adjacentVertex != -999)
			{
				graph[vertex].addLast(adjacentVertex);
				adjacentVertex = infile.nextInt();
			}
		}
	}

	public void clearGraph()
	{
		for(int index = 0; index < gSize; index++)
			graph[index] = null;

		gSize = 0;
	}

	public void printGraph()
	{
		for(int index = 0; index < gSize; index++)
		{
			System.out.print(index + " ");
			System.out.print(graph[index]);
			System.out.println();
		}

		System.out.println();
	}

	public void depthFirstTraversal()
	{
		dodepthFirstTraversal(root);
	}

	public void dodepthFirstTraversal(ListNode t)
	{

		if(t != null)
		{
			System.out.println(t.getValue());
			dodepthFirstTraversal(t.getNext());
		}
	}




}