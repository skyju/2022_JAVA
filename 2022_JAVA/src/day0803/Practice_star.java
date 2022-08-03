import java.util.Scanner;

public class Practice_star {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int tmp = i;
			if (i > n / 2) tmp = -i + n - 1;
			for (int j = n / 2; j > tmp ; j--)
				System.out.print(" ");
			for (int j = 0; j <= tmp * 2; j++)
				System.out.print("*");
			System.out.println();
		}
		sc.close();
	}
}
