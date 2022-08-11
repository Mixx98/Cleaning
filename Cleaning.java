/* �̵� ��ġ�� %

 			5
        10  a  10
     2  7       7  2
        1   ��   1

*/

import java.util.Scanner;
class Clean{
    static int n,i,j; //n�Է�, ��ǥ i,j
    static int a = 0; //a�� ������
    static int sum=0; //������ ���� ����
    static int[] value = new int[5]; //%��갪
    static int[][] table; //ǥ
    static Scanner sc = new Scanner(System.in); //BuffredReader

    Clean() { //�ʱ�ȭ
        this.n=sc.nextInt(); //n�� �Է�
        table = new int[n][n]; //n*n��� //n+1 로 수정
        i = ((n/2)); //��ǥ(��)�� ����� ����
        j = ((n/2)); //��ǥ(��)�� ����� ����
    }

    static void setTable() { //��� �� �Է�
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

    static void up() { //���� �̵��Ҷ�
        i--; //��ǥ ���� �̵�
        cal();
        try {table[i-1][j+1]+=value[0];a+=value[0];}catch(ArrayIndexOutOfBoundsException e){sum+=value[0];a+=value[0];} //10%
        try {table[i-1][j-1]+=value[0];a+=value[0];}catch(ArrayIndexOutOfBoundsException e){sum+=value[0];a+=value[0];} //10%
        try {table[i][j+1]+=value[1];a+=value[1]; //7%
            try{table[i][j+2]+=value[3];a+=value[3];}catch(ArrayIndexOutOfBoundsException e){sum+=value[3];a+=value[3];} //2%
        }catch(ArrayIndexOutOfBoundsException e){sum+=value[1];a+=value[1];}
        try {table[i][j-1]+=value[1];a+=value[1]; //7%
            try{table[i][j-2]+=value[3];a+=value[3];}catch(ArrayIndexOutOfBoundsException e){sum+=value[3];a+=value[3];} //2%
        }catch(ArrayIndexOutOfBoundsException e){sum+=value[1];a+=value[1];}
        try {table[i+1][j+1]+=value[4];a+=value[4];}catch(ArrayIndexOutOfBoundsException e){sum+=value[4];a+=value[4];} //1%
        try {table[i+1][j-1]+=value[4];a+=value[4];}catch(ArrayIndexOutOfBoundsException e){sum+=value[4];a+=value[4];} //1%
        a=table[i][j]-a; //a���
        try {table[i-1][j]=a; //a�Է�
            try {table[i-2][j]+=value[2];table[i-1][j]-=value[2];}
            catch(ArrayIndexOutOfBoundsException e){sum+=value[2];table[i-1][j]-=value[2];} //5%
        }catch(ArrayIndexOutOfBoundsException e){sum+=a;}
        a=0; //a �ʱ�ȭ
        table[i][j]=0;	//��ǥ�� �ʱ�ȭ
    }

    static void down() { //�Ʒ��� �̵��Ҷ�
        i++; //��ǥ �Ʒ��� �̵�
        cal();
        try {table[i+1][j+1]+=value[0];a+=value[0];}catch(ArrayIndexOutOfBoundsException e){sum+=value[0];a+=value[0];} //10%
        try {table[i+1][j-1]+=value[0];a+=value[0];}catch(ArrayIndexOutOfBoundsException e){sum+=value[0];a+=value[0];} //10%
        try {table[i][j+1]+=value[1];a+=value[1]; //7%
            try{table[i][j+2]+=value[3];a+=value[3];}catch(ArrayIndexOutOfBoundsException e){sum+=value[3];a+=value[3];} //2%
        }catch(ArrayIndexOutOfBoundsException e){sum+=value[1];a+=value[1];}
        try {table[i][j-1]+=value[1];a+=value[1]; //7%
            try{table[i][j-2]+=value[3];a+=value[3];}catch(ArrayIndexOutOfBoundsException e){sum+=value[3];a+=value[3];} //2%
        }catch(ArrayIndexOutOfBoundsException e){sum+=value[1];a+=value[1];}
        try {table[i-1][j+1]+=value[4];a+=value[4];}catch(ArrayIndexOutOfBoundsException e){sum+=value[4];a+=value[4];} //1%
        try {table[i-1][j-1]+=value[4];a+=value[4];}catch(ArrayIndexOutOfBoundsException e){sum+=value[4];a+=value[4];} //1%
        a=table[i][j]-a; //a���
        try {table[i+1][j]=a; //a�Է�
            try {table[i+2][j]+=value[2];table[i+1][j]-=value[2];}
            catch(ArrayIndexOutOfBoundsException e){sum+=value[2];table[i+1][j]-=value[2];} //5%
        }catch(ArrayIndexOutOfBoundsException e){sum+=a;}
        a=0; //a �ʱ�ȭ
        table[i][j]=0;	//��ǥ�� �ʱ�ȭ
    }

    static void left() { //�������� �̵��Ҷ�
        j--; //��ǥ �������� �̵�
        cal();
        try {table[i-1][j-1]+=value[0];a+=value[0];}catch(ArrayIndexOutOfBoundsException e){sum+=value[0];a+=value[0];} //10%
        try {table[i+1][j-1]+=value[0];a+=value[0];}catch(ArrayIndexOutOfBoundsException e){sum+=value[0];a+=value[0];} //10%
        try {table[i+1][j]+=value[1];a+=value[1]; //7%
            try{table[i+2][j]+=value[3];a+=value[3];}catch(ArrayIndexOutOfBoundsException e){sum+=value[3];a+=value[3];} //2%
        }catch(ArrayIndexOutOfBoundsException e){sum+=value[1];a+=value[1];}
        try {table[i-1][j]+=value[1];a+=value[1]; //7%
            try{table[i-2][j]+=value[3];a+=value[3];}catch(ArrayIndexOutOfBoundsException e){sum+=value[3];a+=value[3];} //2%
        }catch(ArrayIndexOutOfBoundsException e){sum+=value[1];a+=value[1];}
        try {table[i-1][j+1]+=value[4];a+=value[4];}catch(ArrayIndexOutOfBoundsException e){sum+=value[4];a+=value[4];} //1%
        try {table[i+1][j+1]+=value[4];a+=value[4];}catch(ArrayIndexOutOfBoundsException e){sum+=value[4];a+=value[4];} //1%
        a=table[i][j]-a; //a���
        try {table[i][j-1]=a; //a�Է�
            try {table[i][j-2]+=value[2];table[i][j-1]-=value[2];}
            catch(ArrayIndexOutOfBoundsException e){sum+=value[2];table[i][j-1]-=value[2];} //5%
        }catch(ArrayIndexOutOfBoundsException e){sum+=a;}
        a=0; //a �ʱ�ȭ
        table[i][j]=0;	//��ǥ�� �ʱ�ȭ
    }

    static void right() { //���������� �̵��Ҷ�
        j++; //��ǥ ���������� �̵�
        cal();
        try {table[i-1][j+1]+=value[0];a+=value[0];}catch(ArrayIndexOutOfBoundsException e){sum+=value[0];a+=value[0];} //10%
        try {table[i+1][j+1]+=value[0];a+=value[0];}catch(ArrayIndexOutOfBoundsException e){sum+=value[0];a+=value[0];} //10%
        try {table[i+1][j]+=value[1];a+=value[1]; //7%
            try{table[i+2][j]+=value[3];a+=value[3];}catch(ArrayIndexOutOfBoundsException e){sum+=value[3];a+=value[3];} //2%
        }catch(ArrayIndexOutOfBoundsException e){sum+=value[1];a+=value[1];}
        try {table[i-1][j]+=value[1];a+=value[1]; //7%
            try{table[i-2][j]+=value[3];a+=value[3];}catch(ArrayIndexOutOfBoundsException e){sum+=value[3];a+=value[3];} //2%
        }catch(ArrayIndexOutOfBoundsException e){sum+=value[1];a+=value[1];}
        try {table[i-1][j-1]+=value[4];a+=value[4];}catch(ArrayIndexOutOfBoundsException e){sum+=value[4];a+=value[4];} //1%
        try {table[i+1][j-1]+=value[4];a+=value[4];}catch(ArrayIndexOutOfBoundsException e){sum+=value[4];a+=value[4];} //1%
        a=table[i][j]-a; //a���
        try {table[i][j+1]=a; //a�Է�
            try {table[i][j+2]+=value[2];table[i][j+1]-=value[2];}
            catch(ArrayIndexOutOfBoundsException e){sum+=value[2];table[i][j+1]-=value[2];} //5%
        }catch(ArrayIndexOutOfBoundsException e){sum+=a;}
        a=0; //a �ʱ�ȭ
        table[i][j]=0;	//��ǥ�� �ʱ�ȭ
    }

    static void choice(int i){
        switch (i) {
            case 0 -> left();
            case 1 -> down();
            case 2 -> right();
            case 3 -> up();
        }
    }

    static void start(){
        int count = 0;
        int len = 1;
        boolean bl = true;

        while(bl) {
            for (int a = 0; a < 2; a++) {
                for (int b = 0; b < len; b++) {
                    choice(count % 4);
                    System.out.println(i+","+j);
                    if(i==0&&j==0){
                        bl=false;
                    }
                }
                count++;
            }
            len++;
        }
        System.out.println(sum);
    }
}
public class Cleaning {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Clean cl = new Clean();
        cl.setTable();
        try{cl.start();}
            catch(ArrayIndexOutOfBoundsException e){System.out.println(cl.sum);}
    }

}