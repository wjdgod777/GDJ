package ex02_loop;

public class Ex05_nested_for {

	public static void main(String[] args) {
		
		// 1일차 1교시
		// 1일차 2교시
		// ...
		// 1일차 8교시
		// 2일차 1교시
		// ...
		// 3일차 8교시
		
		
		for(int day = 1; day <= 3; day++) {
			for(int hour = 1; hour <= 8; hour++) {
				System.out.println(day + "일차 " + hour + "교시");
			} System.out.println();
		}
		
		// 연습
		// 2 x 1 = 2
		// ...
		// 9 x 9 = 81
		
		for(int a = 2; a <= 9; a++) {
			System.out.println("\n★★★ " + a + " 단 ★★★");
			for(int b = 1; b <= 9; b++) {
				System.out.println(a + "x " + b + " = " + a*b);
			}
			
		}
		
		// 연습
		// 2x1=2
		// ...
		// 5x5=25
		
		for(int c = 2; c <= 9; c++) {
			if(c > 5) {
				break;
			}	System.out.println("\n★★★ " + c + " 단 ★★★");
			
			for(int d = 1; d <= 9; d++) {
				System.out.println(c + " x " + d + " = " + c*d);
				if(c == 5 && d == 5) {
					break;
					
				}
			}
		}
		
		// 라벨(label)을 이용한 풀이
		outer : for(int e = 2; e <= 9; e++) {
			if(e > 5) {
				break;
			}	System.out.println("\n★★★ " + e + " 단 ★★★");
			
			for(int f = 1; f <= 9; f++) {
				System.out.println(e + " x " + f + " = " + e*f);
				if(e == 5 && f == 5) {
					break outer;
					
				}
			}
		}

		// 2x1=2	9x1=9
		// ...
		// 2x9=18	9x9=81
		for(int a = 1; a <= 9; a++) {
			System.out.println("");
				for(int b = 2; b <= 9; b++) {
				System.out.print(b + "x" + a + "=" + a*b + " ");
			} System.out.println();
		}
		
		for (int i = 1; i <= 9; i++) {
			System.out.println();

	         for (int j = 2; j <= 9; j++) {
	            
	             
	            //System.out.printf(j + "x" + i + "=" + "%3d" , j*i + "   ");
	            System.out.printf("  " + j + "x"  + i + "=" + "%2d" , j*i  );
	            //System.out.printf("%3d", i * j);
	            
	         }
	         
	      }
		
		
	}

}
