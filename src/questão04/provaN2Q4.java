package quest�o04;

import java.util.Scanner;

public class provaN2Q4 {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);

		int n, x, y, z;
		int controle = 0;

		System.out.print("Quantas naves s�o? Escolha de 2 a 10 naves:");
		n = leia.nextInt();
		if (n < 2 || n > 10) { // verificar se quantidade de naves � v�lida

			do {
				System.out.println("Quantidade informada � inv�lida. ");
				System.out.println("Quantas naves s�o? Escolha de 2 a 10 naves:");
				n = leia.nextInt();

			} while (n < 2 || n > 10);

		} // fim if

		int[][] m = new int[n][3]; // quantidade de linhas vai depender da qtd de naves.

		while (controle < n) {

			System.out.printf("Informe as coordenadas da %d� nave (valores v�lidos de 0 a 100):\n", controle + 1);
			System.out.print("x");
			x = leia.nextInt();
			System.out.print("y");
			y = leia.nextInt();
			System.out.print("z");
			z = leia.nextInt();

			for (int i = 0; i < m.length; i++) { // verificar se n�o existe nave na coordenada informada.
				for (int j = 0; j < m[i].length; j++) {
					if (m[i][0] == x && m[i][1] == y && m[i][2] == z) {
						do {
							i = 0;
							System.out.println("J� existe nave na coordenada informada.");
							System.out.println("Informe outra coordenada.");
							System.out.printf("Informe as coordenadas da %d� nave (valores v�lidos de 0 a 100):\n",
									controle + 1);
							System.out.print("x");
							x = leia.nextInt();
							System.out.print("y");
							y = leia.nextInt();
							System.out.print("z");
							z = leia.nextInt();
						} while (m[i][0] == x && m[i][1] == y && m[i][2] == z);
					}
				}
			}

			if (x > 100 || x < 0 || y > 100 || y < 0 || z > 100 || z < 0) { // validar coordenadas

				do {
					System.out.println("Alguma coordenada informada � inv�lida. ");
					System.out.printf("Informe as coordenadas da %d� nave (valores v�lidos de 0 a 100):\n",
							controle + 1);
					System.out.print("x");
					x = leia.nextInt();
					System.out.print("y");
					y = leia.nextInt();
					System.out.print("z");
					z = leia.nextInt();
				} while (x > 100 || x < 0 || y > 100 || y < 0 || z > 100 || z < 0);

			} // fim do if valor coordenadas entre 0 e 100

			// quando as coordenadas s�o v�lidas
			m[controle][0] = x;
			m[controle][1] = y;
			m[controle][2] = z;
			controle++;

		} // fim while

		String[] v = new String[n - 1]; // esse -1 � pq a primeira nave n�o entra, ou seja, ela ir� comparar apenas com
										// as outras.

		// calcular intensidade
		controle = 1;
		double dist = 0.0;
		double v1 = 0.0;
		double v2 = 0.0;
		double v3 = 0.0;
		double[] distancias = new double[n];
		distancias[0] = 0.0;
		double compararDist = 0.0;
		int melhorOpcao = 0;
		for (int i = 0; i < n - 1; i++) {

			v1 = Math.pow(m[0][0] - m[controle][0], 2);
			v2 = Math.pow(m[0][1] - m[controle][1], 2);
			v3 = Math.pow(m[0][2] - m[controle][2], 2);

			dist = Math.sqrt(v1 + v2 + v3);

			if (dist <= 20) {

				v[i] = "A - Alta intensidade";

			} else if (dist > 20 && dist < 51) {

				v[i] = "M - M�dia intensidade";

			} else {

				v[i] = "B - Baixa intensidade";

			}

			distancias[controle] = dist;
			if (compararDist == 0.0) {
				compararDist = dist;
			} else {
				if (compararDist > dist) {
					compararDist = dist;
					melhorOpcao = controle + 1;
				}
			}

			controle++;

		} // fim for

		// imprimir matriz
		System.out.println();
		System.out.println("Coordenadas informadas:");
		for (int i = 0; i < m.length; i++) {

			for (int j = 0; j < 3; j++) {

				System.out.printf("[%3d] ", m[i][j]);

			} // fim for coluna
			System.out.println();

		} // fim for linha

		System.out.println();
		System.out.printf("Compara��o da intesidade de sinal da 1� nave com as outras %d naves.\n", n - 1);
		System.out.println("===Intensidade sinal e dist�ncia:===");
		int posicaoNave = 2;
		for (int linha = 0; linha < v.length; linha++) {

			System.out.printf("Sinal entre a 1� nave e a %d� nave: %s   \tDist�ncia: [%10.4f]\n", posicaoNave, v[linha],
					distancias[linha + 1]);
			posicaoNave++;
		} // fim for
		System.out.println();
		System.out.println("===Nave mais pr�xima para fazer contato===");
		System.out.printf("A %d� nave � a que est� mais pr�xima da 1� nave.\n", melhorOpcao);

		leia.close();

	}// fim main

}// fim class