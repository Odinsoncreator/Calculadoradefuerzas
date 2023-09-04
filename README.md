# Calculadoradefuerzas
Calculadora Java de fuerzas vectoriales: ingresa vectores, calcula componentes, ángulos y resultante, opcionalmente guarda resultados en archivo.

una calculadora de fuerzas vectoriales en Java. La calculadora permite al usuario ingresar datos sobre vectores en los cuatro cuadrantes del plano cartesiano y calcular la resultante de todas las fuerzas ingresadas. Aquí está una descripción detallada del programa:
Inicio del programa: El programa comienza ejecutándose en el método main. Se crea un objeto Scanner para tomar la entrada del usuario y se inicializan las variables para almacenar los resultados.
Bucle Principal: El programa está diseñado como un bucle principal que permite al usuario calcular múltiples ejercicios o guardar los resultados en un archivo antes de salir.
Solicitud del número de vectores por cuadrante: El programa solicita al usuario ingresar el número de vectores que se ingresarán en cada cuadrante.
Ingreso de datos de vectores: El programa solicita al usuario ingresar los datos de los vectores en cada cuadrante. Para cada vector, el usuario puede proporcionar la magnitud y el ángulo o las componentes x e y. Los datos ingresados se utilizan para calcular las componentes x e y, así como el ángulo en grados del vector.
Cálculo de componentes y ángulos: Durante el ingreso de datos, el programa calcula las componentes x e y de cada vector y acumula los valores para cada cuadrante. También calcula el ángulo resultante de cada vector en grados.
Impresión de resultados: Después de ingresar todos los vectores, el programa imprime los resultados en forma de tabla en la consola. Los resultados incluyen las componentes x e y de cada cuadrante, el ángulo en grados y la componente total en cada dirección (x e y) para cada cuadrante y la componente total en dirección x e y en general.
Cálculo de la resultante: El programa calcula la magnitud y el ángulo de la resultante de todas las fuerzas ingresadas utilizando el teorema de Pitágoras y la función atan2.
Opciones para el usuario: Luego de mostrar los resultados, el programa le pregunta al usuario si desea calcular otro ejercicio o guardar los resultados en un archivo. Si el usuario decide guardar los resultados, se le solicita ingresar la ruta del archivo de texto donde se guardarán los resultados.
Guardado en archivo: Si el usuario elige guardar los resultados, el programa utiliza la función FileWriter y PrintWriter para escribir los resultados en un archivo de texto con formato similar al mostrado en la consola.
Fin del programa: El programa permite al usuario repetir el proceso o salir del programa por completo.
Este programa proporciona una herramienta interactiva para calcular y almacenar los resultados de ejercicios de fuerzas vectoriales en física.

FB: @aztecbyte

![Resultado](https://github.com/Odinsoncreator/Calculadoradefuerzas/assets/111935651/ed1bb30e-f9aa-4a99-b75b-68743b7fa8ae)
