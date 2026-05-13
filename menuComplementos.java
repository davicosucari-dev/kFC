public static void menuComplementos() {

    int opcion, cantidad;

    do {

        System.out.println("\n=========== COMPLEMENTOS KFC ===========");
        System.out.println("1. Paquete 6 Nuggets ............ S/ 16.90");
        System.out.println("2. Paquete 6 Hot Wings .......... S/ 17.90");
        System.out.println("3. Paquete 6 Tenders ............ S/ 33.90");
        System.out.println("4. Paquete 3 Tenders ............ S/ 17.90");
        System.out.println("5. PopCorn Chicken .............. S/ 15.90");
        System.out.println("6. Papa Super Familiar .......... S/ 15.90");
        System.out.println("7. Papa Familiar ................ S/ 11.90");
        System.out.println("8. Papa Personal ................ S/ 6.90");
        System.out.println("9. Ensalada Familiar ............ S/ 11.00");
        System.out.println("10. Ensalada Regular ............ S/ 5.90");
        System.out.println("11. Volver");
        System.out.println("========================================");

        System.out.print("SELECCIONE UNA OPCION: ");
        opcion = sc.nextInt();

        if (opcion >= 1 && opcion <= 10) {

            System.out.print("INGRESE CANTIDAD: ");
            cantidad = sc.nextInt();

            switch (opcion) {

                case 1:
                    total = total + (16.90 * cantidad);
                    System.out.println("6 Nuggets agregado(s)");
                    break;

                case 2:
                    total = total + (17.90 * cantidad);
                    System.out.println("6 Hot Wings agregado(s)");
                    break;

                case 3:
                    total = total + (33.90 * cantidad);
                    System.out.println("6 Tenders agregado(s)");
                    break;

                case 4:
                    total = total + (17.90 * cantidad);
                    System.out.println("3 Tenders agregado(s)");
                    break;

                case 5:
                    total = total + (15.90 * cantidad);
                    System.out.println("PopCorn Chicken agregado");
                    break;

                case 6:
                    total = total + (15.90 * cantidad);
                    System.out.println("Papa Super Familiar agregada");
                    break;

                case 7:
                    total = total + (11.90 * cantidad);
                    System.out.println("Papa Familiar agregada");
                    break;

                case 8:
                    total = total + (6.90 * cantidad);
                    System.out.println("Papa Personal agregada");
                    break;

                case 9:
                    total = total + (11.00 * cantidad);
                    System.out.println("Ensalada Familiar agregada");
                    break;

                case 10:
                    total = total + (5.90 * cantidad);
                    System.out.println("Ensalada Regular agregada");
                    break;

            }

            System.out.println("TOTAL ACTUAL: S/ " + total);

        } else if (opcion == 11) {

            System.out.println("VOLVIENDO AL MENU...");

        } else {

            System.out.println("OPCION INVALIDA");

        }

    } while (opcion != 11);

}
