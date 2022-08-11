import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Clean2{
    int i,j;
    int[][] table;

    Clean2() throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        final int N = bf.read();

        i = N;
        j = N;

        this.table = new int[N+2][N+2];

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                table[i][j]=bf.read();
            }
        }
    }

    void start(){

        int count = 0;
        int len = 1;
        boolean bl = true;

        while(bl) {
            for (int a = 0; a < 2; a++) {
                for (int b = 0; b < len; b++) {
                    System.out.println(i+","+j);
                    choice(count % 4);
                    if(i==0&&j==0){
                        bl=false;
                    }
                }
                count++;
            }
            len++;
        }
    }

    void choice(int a){
        switch (a) {
            case 0 -> j--;
            case 1 -> i++;
            case 2 -> j++;
            case 3 -> i--;
        }
    }

}

public class Cleaning2 {
    public static void main(String[] args) throws IOException {
        Clean2 cl2 = new Clean2();
        cl2.start();

    }
}
