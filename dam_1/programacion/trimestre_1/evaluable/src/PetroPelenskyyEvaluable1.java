/*
 * CALCULAR EL ÁREA Y EL PERÍMETRO
 * Crea una aplicación que permite calcular el área y el perímetro de un círculo, cuadrado,
 * rectángulo y triángulo. El usuario puede elegir qué figura quiere e introducir los valores
 * necesarios para que se muestren los resultados. La aplicación termina cuando el usuario lo
 * indique.
 */

import java.util.Scanner;

public class PetroPelenskyyEvaluable1 {

    public static void main(String[] args) {

        // Declarar Scanner para leer la entrada por teclado.
        Scanner sc = new Scanner(System.in);

        // Declaración de variables y constantes.
        int opcionPrincipal;
        int opcionSecundario;
        double area;
        double perimetro;
        double num1, num2, num3;
        final double PI = Math.PI;

        // Bucle principal del menú se repite hasta que el usuario elija 0 (salir).
        do {
            System.out.println("=== MENÚ PRINCIPAL ===");
            System.out.println("1-. Calcular el Área.");
            System.out.println("2-. Calcular el Perímetro.");
            System.out.println("0-. Salir.");
            System.out.print("Entrada: ");

            // Comprobar la entrada, se repite el bucle hasta que se introduzca un número entero.
            while (!sc.hasNextInt()) {
                System.out.print("¡Tiene que ser un número entero!: ");
                sc.next();
            }

            // Guardar el número introducido.
            opcionPrincipal = sc.nextInt();

            // Línea en blanco para separar visualmente en consola.
            System.out.println();

            // Switch principal según la opción elegida se accede al cálculo del Área, Perímetro o Salir.
            switch (opcionPrincipal) {

                // === OPCIÓN 1: CÁLCULO DEL ÁREA ===
                case 1:
                    // Bucle del submenú de áreas se repite hasta que el usuario elija 0 (atrás).
                    do {
                        System.out.println("=== CÁLCULO DEL ÁREA ===");
                        System.out.println("1-. Círculo.");
                        System.out.println("2-. Cuadrado.");
                        System.out.println("3-. Rectángulo.");
                        System.out.println("4-. Triángulo.");
                        System.out.println("0-. Atrás.");
                        System.out.print("Entrada: ");

                        // Comprobar la entrada, se repite el bucle hasta que se introduzca un número entero.
                        while (!sc.hasNextInt()) {
                            System.out.print("¡Tiene que ser un número entero!: ");
                            sc.next();
                        }

                        // Guardar el número introducido.
                        opcionSecundario = sc.nextInt();

                        // Línea en blanco para separar visualmente en consola.
                        System.out.println();

                        // Switch de las figuras.
                        switch (opcionSecundario) {
                            // OPCIÓN 1: CÁLCULO DEL ÁREA DEL CÍRCULO.
                            case 1:
                                System.out.println("--- Área del Círculo ---");
                                System.out.print("Introducir el radio: ");

                                // Comprobar la entrada, se repite el bucle hasta que se introduzca un número.
                                while (!sc.hasNextDouble()) {
                                    System.out.print("¡Tiene que ser un número!: ");
                                    sc.next();
                                }

                                // Guardar el número introducido.
                                num1 = sc.nextDouble();

                                // Comprobación adicional: el radio debe ser mayor que 0.
                                while (num1 <= 0) {
                                    System.out.print("¡El radio debe ser mayor que 0!: ");

                                    // Comprobar la entrada, se repite el bucle hasta que se introduzca un número.
                                    while (!sc.hasNextDouble()) {
                                        System.out.print("¡Tiene que ser un número!: ");
                                        sc.next();
                                    }

                                    // Guardar el número introducido.
                                    num1 = sc.nextDouble();
                                }

                                // Cálculo.
                                area = PI * num1 * num1;

                                // Mostrar el resultado.
                                System.out.println("Área del Círculo: " + area + " cm²");

                                // Línea en blanco para separar visualmente en consola.
                                System.out.println();
                                break;

                            // OPCIÓN 2: CÁLCULO DEL ÁREA DEL CUADRADO.
                            case 2:
                                System.out.println("--- Área del Cuadrado ---");
                                System.out.print("Introducir la medida de un lado: ");

                                // Comprobar la entrada, se repite el bucle hasta que se introduzca un número.
                                while (!sc.hasNextDouble()) {
                                    System.out.print("¡Tiene que ser un número!: ");
                                    sc.next();
                                }

                                // Guardar el número introducido.
                                num1 = sc.nextDouble();

                                // Comprobación adicional: el lado debe ser mayor que 0.
                                while (num1 <= 0) {
                                    System.out.print("¡El lado debe ser mayor que 0!: ");

                                    // Comprobar la entrada, se repite el bucle hasta que se introduzca un número.
                                    while (!sc.hasNextDouble()) {
                                        System.out.print("¡Tiene que ser un número!: ");
                                        sc.next();
                                    }

                                    // Guardar el número introducido.
                                    num1 = sc.nextDouble();
                                }

                                // Cálculo.
                                area = num1 * num1;

                                // Mostrar el resultado.
                                System.out.println("Área del Cuadrado: " + area + " cm²");

                                // Línea en blanco para separar visualmente en consola.
                                System.out.println();
                                break;

                            // OPCIÓN 3: CÁLCULO DEL ÁREA DEL RECTÁNGULO.
                            case 3:
                                System.out.println("--- Área del Rectángulo ---");
                                System.out.print("Introducir la base: ");

                                // Comprobar la entrada, se repite el bucle hasta que se introduzca un número.
                                while (!sc.hasNextDouble()) {
                                    System.out.print("¡Tiene que ser un número!: ");
                                    sc.next();
                                }

                                // Guardar el número introducido.
                                num1 = sc.nextDouble();

                                // Comprobación adicional: la base debe ser mayor que 0.
                                while (num1 <= 0) {
                                    System.out.print("¡La base debe ser mayor que 0!: ");

                                    // Comprobar la entrada, se repite el bucle hasta que se introduzca un número.
                                    while (!sc.hasNextDouble()) {
                                        System.out.print("¡Tiene que ser un número!: ");
                                        sc.next();
                                    }

                                    // Guardar el número introducido.
                                    num1 = sc.nextDouble();
                                }

                                System.out.print("Introducir la altura: ");

                                // Comprobar la entrada, se repite el bucle hasta que se introduzca un número.
                                while (!sc.hasNextDouble()) {
                                    System.out.print("¡Tiene que ser un número!: ");
                                    sc.next();
                                }

                                // Guardar el número introducido.
                                num2 = sc.nextDouble();

                                // Comprobación adicional: la altura debe ser mayor que 0.
                                while (num2 <= 0) {
                                    System.out.print("¡La altura debe ser mayor que 0!: ");

                                    // Comprobar la entrada, se repite el bucle hasta que se introduzca un número.
                                    while (!sc.hasNextDouble()) {
                                        System.out.print("¡Tiene que ser un número!: ");
                                        sc.next();
                                    }

                                    // Guardar el número introducido.
                                    num2 = sc.nextDouble();
                                }

                                // Cálculo.
                                area = num1 * num2;

                                // Mostrar el resultado.
                                System.out.println("Área del Rectángulo: " + area + " cm²");

                                // Línea en blanco para separar visualmente en consola.
                                System.out.println();
                                break;

                            // OPCIÓN 4: CÁLCULO DEL ÁREA DEL TRIÁNGULO.
                            case 4:
                                System.out.println("--- Área del Triángulo ---");
                                System.out.print("Introducir la base: ");

                                // Comprobar la entrada, se repite el bucle hasta que se introduzca un número.
                                while (!sc.hasNextDouble()) {
                                    System.out.print("¡Tiene que ser un número!: ");
                                    sc.next();
                                }

                                // Guardar el número introducido.
                                num1 = sc.nextDouble();

                                // Comprobación adicional: la base debe ser mayor que 0.
                                while (num1 <= 0) {
                                    System.out.print("¡La base debe ser mayor que 0!: ");

                                    // Comprobar la entrada, se repite el bucle hasta que se introduzca un número.
                                    while (!sc.hasNextDouble()) {
                                        System.out.print("¡Tiene que ser un número!: ");
                                        sc.next();
                                    }

                                    // Guardar el número introducido.
                                    num1 = sc.nextDouble();
                                }

                                System.out.print("Introducir la altura: ");

                                // Comprobar la entrada, se repite el bucle hasta que se introduzca un número.
                                while (!sc.hasNextDouble()) {
                                    System.out.print("¡Tiene que ser un número!: ");
                                    sc.next();
                                }

                                // Guardar el número introducido.
                                num2 = sc.nextDouble();

                                // Comprobación adicional: la altura debe ser mayor que 0.
                                while (num2 <= 0) {
                                    System.out.print("¡La altura debe ser mayor que 0!: ");

                                    // Comprobar la entrada, se repite el bucle hasta que se introduzca un número.
                                    while (!sc.hasNextDouble()) {
                                        System.out.print("¡Tiene que ser un número!: ");
                                        sc.next();
                                    }

                                    // Guardar el número introducido.
                                    num2 = sc.nextDouble();
                                }

                                // Cálculo.
                                area = (num1 * num2) / 2;

                                // Mostrar el resultado.
                                System.out.println("Área del Triángulo: " + area + " cm²");

                                // Línea en blanco para separar visualmente en consola.
                                System.out.println();
                                break;

                            // OPCIÓN 0: VOLVER AL MENÚ PRINCIPAL.
                            case 0:
                                break;

                            // CUANDO SE INTRODUCE UN NÚMERO FUERA DEL RANGO PERMITIDO.
                            default:
                                System.out.println("Opción inválida. Debe ser 0 - 4.");
                                
                                // Línea en blanco para separar visualmente en consola.
                                System.out.println();
                                break;
                        }
                    } while (opcionSecundario != 0);
                    break;

                // === OPCIÓN 2: CÁLCULO DEL PERÍMETRO ===
                case 2:
                    // Bucle del submenú de perímetros.
                    do {
                        System.out.println("=== CÁLCULO DEL PERÍMETRO ===");
                        System.out.println("1-. Círculo.");
                        System.out.println("2-. Cuadrado.");
                        System.out.println("3-. Rectángulo.");
                        System.out.println("4-. Triángulo.");
                        System.out.println("0-. Atrás.");
                        System.out.print("Entrada: ");

                        // Comprobar la entrada, se repite el bucle hasta que se introduzca un número entero.
                        while (!sc.hasNextInt()) {
                            System.out.print("¡Tiene que ser un número entero!: ");
                            sc.next();
                        }

                        // Guardar el número introducido.
                        opcionSecundario = sc.nextInt();

                        // Línea en blanco para separar visualmente en consola.
                        System.out.println();

                        // Switch para elegir figura y calcular perímetro.
                        switch (opcionSecundario) {

                            // OPCIÓN 1: PERÍMETRO DEL CÍRCULO.
                            case 1:
                                System.out.println("--- Perímetro del Círculo ---");
                                System.out.print("Introducir el radio: ");

                                // Comprobar la entrada, se repite el bucle hasta que se introduzca un número.
                                while (!sc.hasNextDouble()) {
                                    System.out.print("¡Tiene que ser un número!: ");
                                    sc.next();
                                }

                                // Guardar el número introducido.
                                num1 = sc.nextDouble();

                                // Comprobación adicional: el radio debe ser mayor que 0.
                                while (num1 <= 0) {
                                    System.out.print("¡El radio debe ser mayor que 0!: ");

                                    // Comprobar la entrada, se repite el bucle hasta que se introduzca un número.
                                    while (!sc.hasNextDouble()) {
                                        System.out.print("¡Tiene que ser un número!: ");
                                        sc.next();
                                    }

                                    // Guardar el número introducido.
                                    num1 = sc.nextDouble();
                                }

                                // Cálculo.
                                perimetro = 2 * PI * num1;

                                // Mostrar el resultado.
                                System.out.println("Perímetro del Círculo: " + perimetro + " cm");

                                // Línea en blanco para separar visualmente en consola.
                                System.out.println();
                                break;

                            // OPCIÓN 2: PERÍMETRO DEL CUADRADO.
                            case 2:
                                System.out.println("--- Perímetro del Cuadrado ---");
                                System.out.print("Introducir la medida de un lado: ");

                                // Comprobar la entrada, se repite el bucle hasta que se introduzca un número.
                                while (!sc.hasNextDouble()) {
                                    System.out.print("¡Tiene que ser un número!: ");
                                    sc.next();
                                }

                                // Guardar el número introducido.
                                num1 = sc.nextDouble();

                                // Comprobación adicional: el lado debe ser mayor que 0.
                                while (num1 <= 0) {
                                    System.out.print("¡El lado debe ser mayor que 0!: ");

                                    // Comprobar la entrada, se repite el bucle hasta que se introduzca un número.
                                    while (!sc.hasNextDouble()) {
                                        System.out.print("¡Tiene que ser un número!: ");
                                        sc.next();
                                    }

                                    // Guardar el número introducido.
                                    num1 = sc.nextDouble();
                                }

                                // Cálculo.
                                perimetro = num1 * 4;

                                // Mostrar el resultado.
                                System.out.println("Perímetro del Cuadrado: " + perimetro + " cm");

                                // Línea en blanco para separar visualmente en consola.
                                System.out.println();
                                break;

                            // OPCIÓN 3: PERÍMETRO DEL RECTÁNGULO.
                            case 3:
                                System.out.println("--- Perímetro del Rectángulo ---");
                                System.out.print("Introducir la base: ");

                                // Comprobar la entrada, se repite el bucle hasta que se introduzca un número.
                                while (!sc.hasNextDouble()) {
                                    System.out.print("¡Tiene que ser un número!: ");
                                    sc.next();
                                }

                                // Guardar el número introducido.
                                num1 = sc.nextDouble();

                                // Comprobación adicional: la base debe ser mayor que 0.
                                while (num1 <= 0) {
                                    System.out.print("¡La base debe ser mayor que 0!: ");

                                    // Comprobar la entrada, se repite el bucle hasta que se introduzca un número.
                                    while (!sc.hasNextDouble()) {
                                        System.out.print("¡Tiene que ser un número!: ");
                                        sc.next();
                                    }

                                    // Guardar el número introducido.
                                    num1 = sc.nextDouble();
                                }

                                System.out.print("Introducir la altura: ");

                                // Comprobar la entrada, se repite el bucle hasta que se introduzca un número.
                                while (!sc.hasNextDouble()) {
                                    System.out.print("¡Tiene que ser un número!: ");
                                    sc.next();
                                }

                                // Guardar el número introducido.
                                num2 = sc.nextDouble();

                                // Comprobación adicional: la altura debe ser mayor que 0.
                                while (num2 <= 0) {
                                    System.out.print("¡La altura debe ser mayor que 0!: ");

                                    // Comprobar la entrada, se repite el bucle hasta que se introduzca un número.
                                    while (!sc.hasNextDouble()) {
                                        System.out.print("¡Tiene que ser un número!: ");
                                        sc.next();
                                    }

                                    // Guardar el número introducido.
                                    num2 = sc.nextDouble();
                                }

                                // Cálculo.
                                perimetro = 2 * (num1 + num2);

                                // Mostrar el resultado.
                                System.out.println("Perímetro del Rectángulo: " + perimetro + " cm");

                                // Línea en blanco para separar visualmente en consola.
                                System.out.println();
                                break;

                            // OPCIÓN 4: PERÍMETRO DEL TRIÁNGULO.
                            case 4:
                                System.out.println("--- Perímetro del Triángulo ---");
                                System.out.print("Introducir lado 1 (base): ");

                                // Comprobar la entrada, se repite el bucle hasta que se introduzca un número.
                                while (!sc.hasNextDouble()) {
                                    System.out.print("¡Tiene que ser un número!: ");
                                    sc.next();
                                }

                                // Guardar el número introducido.
                                num1 = sc.nextDouble();

                                // Comprobación adicional: el lado debe ser mayor que 0.
                                while (num1 <= 0) {
                                    System.out.print("¡El lado debe ser mayor que 0!: ");

                                    // Comprobar la entrada, se repite el bucle hasta que se introduzca un número.
                                    while (!sc.hasNextDouble()) {
                                        System.out.print("¡Tiene que ser un número!: ");
                                        sc.next();
                                    }

                                    // Guardar el número introducido.
                                    num1 = sc.nextDouble();
                                }

                                System.out.print("Introducir lado 2: ");

                                // Comprobar la entrada, se repite el bucle hasta que se introduzca un número.
                                while (!sc.hasNextDouble()) {
                                    System.out.print("¡Tiene que ser un número!: ");
                                    sc.next();
                                }

                                // Guardar el número introducido.
                                num2 = sc.nextDouble();

                                // Comprobación adicional: el lado debe ser mayor que 0.
                                while (num2 <= 0) {
                                    System.out.print("¡El lado debe ser mayor que 0!: ");

                                    // Comprobar la entrada, se repite el bucle hasta que se introduzca un número.
                                    while (!sc.hasNextDouble()) {
                                        System.out.print("¡Tiene que ser un número!: ");
                                        sc.next();
                                    }

                                    // Guardar el número introducido.
                                    num2 = sc.nextDouble();
                                }

                                System.out.print("Introducir lado 3: ");

                                // Comprobar la entrada, se repite el bucle hasta que se introduzca un número.
                                while (!sc.hasNextDouble()) {
                                    System.out.print("¡Tiene que ser un número!: ");
                                    sc.next();
                                }

                                // Guardar el número introducido.
                                num3 = sc.nextDouble();

                                // Comprobación adicional: el lado debe ser mayor que 0.
                                while (num3 <= 0) {
                                    System.out.print("¡El lado debe ser mayor que 0!: ");

                                    // Comprobar la entrada, se repite el bucle hasta que se introduzca un número.
                                    while (!sc.hasNextDouble()) {
                                        System.out.print("¡Tiene que ser un número!: ");
                                        sc.next();
                                    }

                                    // Guardar el número introducido.
                                    num3 = sc.nextDouble();
                                }

                                // Cálculo: perímetro = lado1 + lado2 + lado3
                                perimetro = num1 + num2 + num3;

                                // Mostrar el resultado.
                                System.out.println("Perímetro del Triángulo: " + perimetro + " cm");

                                // Línea en blanco para separar visualmente en consola.
                                System.out.println();
                                break;
                               
                            // OPCIÓN 0: VOLVER AL MENÚ PRINCIPAL.
                            case 0:
                                break;

                            // CUANDO SE INTRODUCE UN NÚMERO FUERA DEL RANGO PERMITIDO.
                            default:
                                System.out.println("Opción inválida. Debe ser 0 - 4.");
                                
                                // Línea en blanco para separar visualmente en consola.
                                System.out.println();
                                break;
                        }
                    } while (opcionSecundario != 0);
                    break;
                
                // === OPCIÓN 0: SALIR DEL MENÚ PRINCIPAL (TERMINAR EL PROGRAMA) ===
                case 0:
                    break;
                    
                // === CUANDO SE INTRODUCE UN NÚMERO FUERA DEL RANGO PERMITIDO ===
                default:
                    System.out.println("Opción inválida. Debe ser 0 - 2.");
            }
        } while (opcionPrincipal != 0);
        // Mensaje de despedida y cierre del Scanner.
        System.out.println("¡Hasta pronto!");
        sc.close();
    }
}
