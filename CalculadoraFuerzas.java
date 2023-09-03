import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.lang.Math;

public class CalculadoraFuerzas {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean salir = false;

            while (!salir) {
                double totalFuerzaX = 0.0;
                double totalFuerzaY = 0.0;
                double[] fuerzaXPorCuadrante = new double[4];
                double[] fuerzaYPorCuadrante = new double[4];
                double[] anguloPorCuadrante = new double[4];

                System.out.print("Ingrese el número de vectores por cuadrante: ");
                int numVectoresPorCuadrante = scanner.nextInt();

                // Solicitar al usuario ingresar los datos de los vectores en cada cuadrante
                for (int cuadrante = 1; cuadrante <= 4; cuadrante++) {
                    double fuerzaX = 0.0;
                    double fuerzaY = 0.0;

                    System.out.println("Cuadrante " + cuadrante + ":");
                    for (int i = 1; i <= numVectoresPorCuadrante; i++) {
                        System.out.println("Vector " + i + ":");
                        System.out.print("Ingrese la magnitud (N): ");
                        double magnitud = scanner.nextDouble();
                        System.out.print("¿Tiene el ángulo en grados (s/n)? ");
                        String respuesta = scanner.next();
                        double anguloRadianes;

                        if (respuesta.equalsIgnoreCase("s")) {
                            System.out.print("Ingrese el ángulo (grados): ");
                            double angulo = scanner.nextDouble();
                            // Convertir el ángulo de grados a radianes
                            anguloRadianes = Math.toRadians(angulo);
                        } else {
                            System.out.print("Ingrese la componente x: ");
                            double componenteX = scanner.nextDouble();
                            System.out.print("Ingrese la componente y: ");
                            double componenteY = scanner.nextDouble();
                            // Calcular el ángulo utilizando atan2
                            anguloRadianes = Math.atan2(componenteY, componenteX);
                        }

                        // Calcular las componentes x e y utilizando la magnitud y el ángulo
                        double componenteX = magnitud * Math.cos(anguloRadianes);
                        double componenteY = magnitud * Math.sin(anguloRadianes);

                        fuerzaX += componenteX;
                        fuerzaY += componenteY;

                        // Calcular el ángulo del vector en grados
                        double anguloGrados = Math.toDegrees(anguloRadianes);
                        anguloPorCuadrante[cuadrante - 1] += anguloGrados;
                    }

                    // Guardar las componentes x e y resultantes de cada cuadrante
                    fuerzaXPorCuadrante[cuadrante - 1] = fuerzaX;
                    fuerzaYPorCuadrante[cuadrante - 1] = fuerzaY;

                    // Agregar al total
                    totalFuerzaX += fuerzaX;
                    totalFuerzaY += fuerzaY;
                }

                // Imprimir los resultados en forma de tabla con dos decimales
                System.out.println("Resultados:");
                System.out.println("Cuadrante | Fuerza X (N) | Fuerza Y (N) | Ángulo (grados)");
                System.out.println("---------------------------------------------------------");
                for (int cuadrante = 1; cuadrante <= 4; cuadrante++) {
                    System.out.printf("%9d | %12.2f | %12.2f | %15.2f%n", cuadrante,
                            fuerzaXPorCuadrante[cuadrante - 1], fuerzaYPorCuadrante[cuadrante - 1], anguloPorCuadrante[cuadrante - 1]);
                }
                System.out.println("---------------------------------------------------------");
                System.out.printf("Total     | %12.2f | %12.2f%n", totalFuerzaX, totalFuerzaY);

                // Calcular la magnitud de la resultante utilizando el teorema de Pitágoras
                double magnitudResultante = Math.sqrt(totalFuerzaX * totalFuerzaX + totalFuerzaY * totalFuerzaY);

                // Calcular el ángulo de la resultante respecto al eje x en grados
                double anguloResultante = Math.toDegrees(Math.atan2(totalFuerzaY, totalFuerzaX));

                // Imprimir el resultado de la resultante con dos decimales
                System.out.println("---------------------------------------------------------");
                System.out.println("La resultante de las fuerzas es:");
                System.out.printf("Magnitud: %.2f N%n", magnitudResultante);
                System.out.printf("Ángulo respecto al eje x: %.2f grados%n", anguloResultante);

                // Preguntar al usuario si desea calcular otro ejercicio o guardar en un archivo
                System.out.print("¿Desea calcular otro ejercicio (s/n)? ");
                String respuesta = scanner.next();

                if (respuesta.equalsIgnoreCase("n")) {
                    // Salir del bucle y guardar en archivo si es necesario
                    salir = true;

                    System.out.print("¿Desea guardar los resultados en un archivo (s/n)? ");
                    respuesta = scanner.next();

                    if (respuesta.equalsIgnoreCase("s")) {
                        System.out.print("Ingrese la ruta del archivo de texto: ");
                        String rutaArchivo = scanner.next();
                        guardarResultadosEnArchivo(rutaArchivo, fuerzaXPorCuadrante, fuerzaYPorCuadrante, anguloPorCuadrante, totalFuerzaX, totalFuerzaY, magnitudResultante, anguloResultante);
                        System.out.println("Resultados guardados en el archivo " + rutaArchivo);
                    }
                }
            }
        }
    }

    private static void guardarResultadosEnArchivo(String rutaArchivo, double[] fuerzaXPorCuadrante, double[] fuerzaYPorCuadrante, double[] anguloPorCuadrante, double totalFuerzaX, double totalFuerzaY, double magnitudResultante, double anguloResultante) {
        try {
            FileWriter archivo = new FileWriter(rutaArchivo);
            PrintWriter escritor = new PrintWriter(archivo);

            escritor.println("Resultados:");
            escritor.println("Cuadrante | Fuerza X (N) | Fuerza Y (N) | Ángulo (grados)");
            escritor.println("---------------------------------------------------------");
            for (int cuadrante = 1; cuadrante <= 4; cuadrante++) {
                escritor.printf("%9d | %12.2f | %12.2f | %15.2f%n", cuadrante,
                        fuerzaXPorCuadrante[cuadrante - 1], fuerzaYPorCuadrante[cuadrante - 1], anguloPorCuadrante[cuadrante - 1]);
            }
            escritor.println("---------------------------------------------------------");
            escritor.printf("Total     | %12.2f | %12.2f%n", totalFuerzaX, totalFuerzaY);

            escritor.println("---------------------------------------------------------");
            escritor.println("La resultante de las fuerzas es:");
            escritor.printf("Magnitud: %.2f N%n", magnitudResultante);
            escritor.printf("Ángulo respecto al eje x: %.2f grados%n", anguloResultante);

            escritor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
