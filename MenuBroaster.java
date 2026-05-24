

public static void menuPolloBroaster() {
    int opcion, cantidad;

    do {
        System.out.println("=========== POLLO BROASTER KFC ===========");
        System.out.println("1. 2 Presas de Pollo ............ S/ 12.90");
        System.out.println("2. 4 Presas de Pollo ............ S/ 24.90");
        System.out.println("3. 6 Presas de Pollo ............ S/ 35.90");
        System.out.println("4. 8 Presas de Pollo ............ S/ 45.90");
        System.out.println("5. 1/4 Pollo Entero ............ S/ 18.90");
        System.out.println("6. 1/2 Pollo Entero ............ S/ 34.90");
        System.out.println("7. Pollo Entero Completo ....... S/ 65.90");
        System.out.println("8. Alitas Broaster (6 uds) ..... S/ 16.90");
        System.out.println("9. Alitas Broaster (12 uds) .... S/ 31.90");
        System.out.println("10. Tiras de Pechuga ........... S/ 19.90");
        System.out.println("11. Volver");
        System.out.println("=========================================");

        System.out.print("SELECCIONE UNA OPCION: ");
        opcion = escaner.nextInt();

        if (opcion >= 1 && opcion <= 10) {
            System.out.print("INGRESE CANTIDAD: ");
            cantidad = escaner.nextInt();

            switch (opcion) {
                case 1:
                    total = total + (12.90 * cantidad);
                    System.out.println("2 Presas de Pollo agregado(s)");
                    break;
                case 2:
                    total = total + (24.90 * cantidad);
                    System.out.println("4 Presas de Pollo agregado(s)");
                    break;
                case 3:
                    total = total + (35.90 * cantidad);
                    System.out.println("6 Presas de Pollo agregado(s)");
                    break;
                case 4:
                    total = total + (45.90 * cantidad);
                    System.out.println("8 Presas de Pollo agregado(s)");
                    break;
                case 5:
                    total = total + (18.90 * cantidad);
                    System.out.println("1/4 Pollo Entero agregado");
                    break;
                case 6:
                    total = total + (34.90 * cantidad);
                    System.out.println("1/2 Pollo Entero agregado");
                    break;
                case 7:
                    total = total + (65.90 * cantidad);
                    System.out.println("Pollo Entero Completo agregado");
                    break;
                case 8:
                    total = total + (16.90 * cantidad);
                    System.out.println("Alitas Broaster (6 uds) agregado(s)");
                    break;
                case 9:
                    total = total + (31.90 * cantidad);
                    System.out.println("Alitas Broaster (12 uds) agregado(s)");
                    break;
                case 10:
                    total = total + (19.90 * cantidad);
                    System.out.println("Tiras de Pechuga agregado(s)");
                    break;
            }

            System.out.println("TOTAL ACTUAL: S/ " + total);

        } else if (opcion == 11) {
            System.out.println("VOLVIENDO AL MENU PRINCIPAL...");
        } else {
            System.out.println("OPCION INVALIDA, INTENTE DE NUEVO");
        }

    } while (opcion != 11);
}
