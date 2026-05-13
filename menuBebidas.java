

public static double menuBebidas(double total) {

    int opcion;
    int cantidad;
    double subtotal = 0;

    do {

        System.out.println("=========== BEBIDAS KFC ===========");
        System.out.println("1. Inca Kola Zero 500ml - S/ 4.90");
        System.out.println("2. Inca Kola Zero 1L - S/ 7.00");
        System.out.println("3. Inca Kola Zero 1.5L - S/ 10.00");
        System.out.println("4. Coca Cola Zero 500ml - S/ 4.90");
        System.out.println("5. Coca Cola Zero 1L - S/ 7.00");
        System.out.println("6. Coca Cola Zero 1.5L - S/ 10.00");
        System.out.println("7. Fanta Naranja 500ml - S/ 4.90");
        System.out.println("8. Fanta 2.25L - S/ 13.00");
        System.out.println("9. Sprite 500ml - S/ 4.90");
        System.out.println("10. Agua San Luis 750ml - S/ 4.50");
        System.out.println("11. Volver");

        System.out.println("SELECCIONE UNA OPCION:");
        opcion = escaner.nextInt();

        if (opcion >= 1 && opcion <= 10) {

            System.out.println("INGRESE CANTIDAD:");
            cantidad = escaner.nextInt();

            switch (opcion) {

                case 1:
                    subtotal = 4.90 * cantidad;
                    break;

                case 2:
                    subtotal = 7.00 * cantidad;
                    break;

                case 3:
                    subtotal = 10.00 * cantidad;
                    break;

                case 4:
                    subtotal = 4.90 * cantidad;
                    break;

                case 5:
                    subtotal = 7.00 * cantidad;
                    break;

                case 6:
                    subtotal = 10.00 * cantidad;
                    break;

                case 7:
                    subtotal = 4.90 * cantidad;
                    break;

                case 8:
                    subtotal = 13.00 * cantidad;
                    break;

                case 9:
                    subtotal = 4.90 * cantidad;
                    break;

                case 10:
                    subtotal = 4.50 * cantidad;
                    break;

            }

            System.out.println("BEBIDA AGREGADA CORRECTAMENTE");
            total += subtotal;

        } else if (opcion == 11) {

            System.out.println("VOLVIENDO AL MENU...");

        } else {

            System.out.println("OPCION INVALIDA");

        }

    } while (opcion != 11);

    return total;

}