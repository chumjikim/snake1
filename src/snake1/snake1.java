package snake1;

import java.util.Scanner;

public class snake1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int s[]; 
		char d[];

		int head = 1;


		boolean flag = true;
		boolean isfull = false; // 충돌여부

		Scanner sc = new Scanner(System.in);

		int l = sc.nextInt(); //가로세로 크기
		int n = sc.nextInt(); //회전수
		int a = l;
		int b = l;

		s = new int[n]; //w 초 후 
		d = new char[n]; //d 방향으로 회전

		for(int i=0; i<n; i++) {
			s[i] = sc.nextInt();
			d[i] = sc.next().charAt(0);
		}

		int result = 0; // 총 이동거리

		int map[][] = new int[(2*l)+1][(2*l)+1];

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				map[i][j]=0;				
			}
		}

		map[a][b]=1; //뱀의 초기위치


		for(int i=0; i<n ; i++) {
			for(int j=0; j<s[i]; j++) {
				//이동
				//조건1
				if(head==0) {
					if(map[a-1][b]==1 || a-1>=map.length || a-1<=0 || b>=map.length || b<=0) {
						break;
					}
					else if(map[a-1][b]==0) {
						map[a-1][b]=1;
						a = a-1;
						b = b;
						result++;
						
					}
				}
				if(head==1) {
					if(map[a][b+1]==1 || a>=map.length || a<=0 || b+1>=map.length || b+1<=0) {
						break;
					}
					else if(map[a][b+1]==0) {
						map[a][b+1]=1;
						a = a;
						b = b+1;
						result++;
					}
				}
				if(head==2) {
					if(map[a+1][b]==1 || a+1>=map.length || a+1<=0 || b>=map.length || b<=0) {
						break;
					}
					else if(map[a+1][b]==0) {
						map[a+1][b]=1;
						a = a+1;
						b = b;
						result++;
					}
				}
				if(head==3) {
					if(map[a][b-1]==1 || a>=map.length || a<=0 || b-1>=map.length || b-1<=0) {
						break;
					}
					else if(map[a][b-1]==0) {
						map[a][b-1]=1;
						a = a;
						b = b-1;
						result++;
					}
				}
			}

			//방향바꾸기
			if (d[i]=='L') {
				if(head==1) {
					head=0;
				}
				else if(head==2) {
					head=1;
				}
				else if(head==3) {
					head=2;
				}
				else if(head==0) {
					head=3;
				}
			}
			else if(d[i]=='R') {
				if(head==1) {
					head=2;
				}
				else if(head==2) {
					head=3;
				}
				else if(head==3) {
					head=0;
				}
				else if(head==0) {
					head=1;
				}
			}
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j]+" ");
			}System.out.println("");
		}
//		System.out.println(result);
	}

}



