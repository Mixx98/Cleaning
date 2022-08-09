import java.util.Scanner;

class Clean{
	static int n,i,j; //n입력, 좌표 i,j
	static int a = 0; //a먼지값
	static int sum=0; //떨어진 먼지 총합
	static int[] value = new int[5]; //%계산값
	static int[][] table; //표
	static Scanner sc = new Scanner(System.in);
	
	Clean() { //초기화
		Clean.n=sc.nextInt(); //n을 입력
		table = new int[n][n]; //n*n행렬
		i = ((n/2)+1); //좌표(행)를 가운데로 지정
		j = ((n/2)+1); //좌표(열)를 가운데로 지정
	}
	
	static void setTable() { //행렬 값 입력
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				table[i][j] = sc.nextInt();
			}
		}
	}
	static void cal() {
		value[0] = (int)((table[i][j]/100.0)*10);
		value[1] = (int)((table[i][j]/100.0)*7);
		value[2] = (int)((table[i][j]/100.0)*5);
		value[3] = (int)((table[i][j]/100.0)*2);
		value[4] = (int)((table[i][j]/100.0)*1);
	}
	
	static void up() { //위로 이동할때
		cal();
		try {table[i-1][j+1]+=value[0];a+=value[0];}catch(ArrayIndexOutOfBoundsException e){sum+=value[0];a+=value[0];}
		try {table[i-1][j-1]+=value[0];a+=value[0];}catch(ArrayIndexOutOfBoundsException e){sum+=value[0];a+=value[0];}
		try {table[i][j+1]+=value[1];a+=value[1];
			try{table[i][j+2]+=value[3];a+=value[3];}catch(ArrayIndexOutOfBoundsException e){sum+=value[3];a+=value[3];}
		}catch(ArrayIndexOutOfBoundsException e){sum+=value[1];a+=value[1];}
		try {table[i][j-1]+=value[1];table[i][j-2]+=value[3];}catch(ArrayIndexOutOfBoundsException e){sum+=value[1];}
		try {table[i+1][j+1]+=value[4];}catch(ArrayIndexOutOfBoundsException e){sum+=value[4];}
		try {table[i+1][j-1]+=value[4];}catch(ArrayIndexOutOfBoundsException e){sum+=value[4];}
		a=table[i][j]-(value[0]*2+value[1]*2+value[2]+value[3]*2+value[4]*2);
		try {table[i-1][j]+=value[2];}catch(ArrayIndexOutOfBoundsException e){sum+=value[2];}
		try {table[i-2][j]+=value[2];}catch(ArrayIndexOutOfBoundsException e){sum+=value[2];}
		
		i--;
	}
	
}
public class Cleaner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Clean cl = new Clean();
		cl.setTable();
	}

}
