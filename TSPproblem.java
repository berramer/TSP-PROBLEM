import java.io.FileNotFoundException;
	import java.math.*;
	import java.util.ArrayList;
	import java.util.Scanner;


public class TSPproblem {
static int yol=0;
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		java.io.File file=new java.io.File("text-4.txt");
		 Scanner input=new Scanner(file);
	ArrayList<þehir>que=new ArrayList<>();
	while(input.hasNext()){
		String strid=input.next();
		String strx=input.next();
		String stry=input.next();
		int id=Integer.parseInt(strid);
		double x=Double.parseDouble(strx);
		double y=Double.parseDouble(stry);
	þehir x1=new þehir(id,x,y);
	que.add(x1);
	}

int  adjlist[][]=new int[que.size()][que.size()];

	for (int k=0;k<que.size();k++) {
		for(int l=k+1;l<que.size();l++) {
			int uzaklýk=(int) Math.round(Math.sqrt(Math.pow((que.get(k).x-que.get(l).x),2.0)+Math.pow((que.get(k).y-que.get(l).y),2.0)));
			
		adjlist[k][l]=uzaklýk;
		adjlist[l][k]=uzaklýk;
		}
	}
	for (int k=0;k<que.size();k++) {
		adjlist[k][k]=Integer.MAX_VALUE;
	}
	

	    ArrayList<þehir>tour=new ArrayList<>();
int þehirk=findmin(adjlist[0],que);

que.get(0).visited=true;
tour.add(que.get(0));

	while(!(visit(que))) {
		
		tour.add(que.get(þehirk));
		þehirk=findmin(adjlist[þehirk],que);
}
	tour.add(que.get(þehirk));
	
   yol+=adjlist[0][þehirk];
	

	
	
	
	twoopt(tour,adjlist);

	print(tour,adjlist);
	
	}	
	
public static int findmin(int arr[],ArrayList<þehir> que) {
	int min=Integer.MAX_VALUE;
	int þehir=0;
	for(int i=0;i<que.size();i++) {
		if(arr[i]<min && !(que.get(i).visited)) {
			min=arr[i];
			þehir=i;
		}

	}
	
	yol+=min;
	que.get(þehir).visited=true;

	return þehir;
	
	
}

public static boolean visit(ArrayList<þehir> que) {
	for(int y=0;y<que.size();y++) {
		if(!(que.get(y).visited)) {
			return false;
			
		}
	}
	return true;
	}

static void twoopt(ArrayList<þehir>tour,int adj[][]) {
	int min=yol;
	int mini=Integer.MAX_VALUE;
	int mink=Integer.MAX_VALUE;
	
	
	for(int i=1;i<tour.size()-5;i++) {
		int k=i+3;
	
		int current=adj[tour.get(i).id][tour.get(i+1).id]+adj[tour.get(k).id][tour.get(k+1).id];
		int opt=adj[tour.get(i).id][tour.get(k).id]+adj[tour.get(i+1).id][tour.get(k+1).id];
		int optyol=yol-current+opt;
			if(optyol<min) {
			min=optyol;
			mini=i;
			mink=k;
	
			
			}
		
	}
	
	if(min<yol) {
		int id1=tour.get(mini+1).id;
		tour.get(mini+1).id=tour.get(mink).id;
		tour.get(mink).id=id1;
	System.out.print(min+" "+larrl(tour,adj));}
	
}



static void print(ArrayList<þehir>tour,int adj[][]) throws FileNotFoundException {
	java.io.File file1=new java.io.File("textoutput4.txt");
    java.io.PrintWriter output1=new java.io.PrintWriter(file1);
    output1.println(larrl(tour,adj));
    for(int i=0;i<tour.size();i++) {
    	output1.println(tour.get(i).id);
    }
    output1.close();
}

static int larrl(ArrayList<þehir>tour,int adj[][]) {
int sum=0;
int m=0;
for( m=0;m<tour.size()-1;m++) {
	sum+=adj[tour.get(m).id][tour.get(m+1).id];
}

return sum+adj[0][tour.get(m).id];
}
}

