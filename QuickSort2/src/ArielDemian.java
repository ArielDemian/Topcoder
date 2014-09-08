public class ArielDemian{
	public static void main(String[] args){
		System.out.println("n | k | ddt");
		int n=262144;
		long t,ddt;
		int A[]=new int[n];
		for(int k=1;k<=n;k*=2){
			long media[]=new long[30];
			for(int i=0;i<30;i++){
				for(int j=0;j<n;j++)
					A[j]=(int)Math.floor(Math.random()*n);
				t=System.currentTimeMillis();
				QuickSort2(A,0,n-1,k);
				ddt=System.currentTimeMillis()-t;
				media[i]=ddt;
			}
			System.out.println(n+"\t"+k+"\t"+calcoloMedia(media));
		}
	}
	private static double calcoloMedia(long[] s){
		double m=0;
		for(double a:s)
			m+=a;
		return (m/s.length);
	}
	private static int partition(int[] A,int a,int b){
		int x=A[b],temp,inf=a,sup=b-1;
		do{
			while(A[inf]<=x&&inf<b)inf++;
			while(A[sup]>x&&sup>a)sup--;
			if(inf<sup){
				temp=A[inf];
				A[inf]=A[sup];
				A[sup]=temp;
			}
		}while(inf<sup);
		temp=A[inf];
		A[inf]=x;
		A[b]=temp;
		return inf;
	}
	private static void bubbleSort(int[] A,int inf,int sup){
		boolean scambio;
		for(int i=1;i<=sup-inf;i++){
			scambio=false;
			for(int j=inf+1;j<=sup-(i-1);j++){
				if(A[j-1]>A[j]){
					int temp=A[j-1];
					A[j-1]=A[j];
					A[j]=temp;
					scambio=true;
				}
			}
			if(!scambio)break;
		}
	}
	private static void QuickSort2(int[] A,int i,int f,int k){
		if(i>=f||k<0)return;
		if((f-i)+1<=k){
			bubbleSort(A,i,f);
			return;
		}
		int m=partition(A,i,f);
		QuickSort2(A,i,m-1,k);
		QuickSort2(A,m+1,f,k);
	}
}