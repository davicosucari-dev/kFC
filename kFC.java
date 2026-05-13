import java.util.Scanner;

public class kFC {

    static Scanner sc = new Scanner(System.in);

    static String cliente;
    static double total = 0;
    static String direccion = "";
    static String metodoPago = "";

    public static void main(String[] args) {

        bienvenida();
        iniciarSesion();
        menuPrincipal();
        aplicarDescuento();
        seleccionarMetodoPago();
        generarBoleta();
        despedida();

    }

    public static void bienvenida() {

        System.out.println("======================================");
        System.out.println("           BIENVENIDO A KFC           ");
        System.out.println("======================================");

    }

    public static void iniciarSesion() {

        int opcion;

        System.out.println("1. Iniciar Sesion");
        System.out.println("2. Ingresar como Invitado");

        opcion = sc.nextInt();
        sc.nextLine();

        if (opcion == 1) {

            System.out.println("INGRESE SU CORREO:");
            String correo = sc.nextLine();

            System.out.println("INGRESE SU CONTRASEÑA:");
            String clave = sc.nextLine();

            System.out.println("INICIO DE SESION EXITOSO");

            System.out.println("INGRESE SU NOMBRE:");
            cliente = sc.nextLine();

        } else {

            System.out.println("INGRESE SU NOMBRE:");
            cliente = sc.nextLine();

            System.out.println("INGRESO COMO INVITADO");

        }

    }

    public static void menuPrincipal() {

        int opcion;

        do {

            System.out.println("\n=================================");
            System.out.println("             MENU KFC            ");
            System.out.println("=================================");
            System.out.println("1. Carta");
            System.out.println("2. Promociones");
            System.out.println("3. Delivery");
            System.out.println("4. Cupones");
            System.out.println("5. Cliente VIP");
            System.out.println("6. Ver Total");
            System.out.println("7. Finalizar Compra");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    menuCarta();
                    break;

                case 2:
                    menuPromociones();
                    break;

                case 3:
                    delivery();
                    break;

                case 4:
                    cupones();
                    break;

                case 5:
                    clienteVIP();
                    break;

                case 6:
                    mostrarTotal();
                    break;

                case 7:
                    System.out.println("FINALIZANDO PEDIDO...");
                    break;

                default:
                    System.out.println("OPCION INVALIDA");

            }

        } while (opcion != 7);

    }

    public static void menuCarta() {

        int opcion;

        do {

            System.out.println("\n============= CARTA =============");
            System.out.println("1. Combos");
            System.out.println("2. Hamburguesas");
            System.out.println("3. Pollo Broaster");
            System.out.println("4. Complementos");
            System.out.println("5. Bebidas");
            System.out.println("6. Postres");
            System.out.println("7. Menu Infantil");
            System.out.println("8. Salsas");
            System.out.println("9. Volver");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    menuCombos();
                    break;

                case 2:
                    menuHamburguesas();
                    break;

                case 3:
                    menuPollo();
                    break;

                case 4:
                    menuComplementos();
                    break;

                case 5:
                    menuBebidas();
                    break;

                case 6:
                    menuPostres();
                    break;

                case 7:
                    menuInfantil();
                    break;

                case 8:
                    menuSalsas();
                    break;

                case 9:
                    System.out.println("VOLVIENDO...");
                    break;

                default:
                    System.out.println("OPCION INVALIDA");

            }

        } while (opcion != 9);

    }

    public static void menuCombos() {

        int opcion, cantidad;

        System.out.println("\n=========== COMBOS ===========");
        System.out.println("1. Mega Familiar - 65");
        System.out.println("2. Bucket 12 Piezas - 80");
        System.out.println("3. Duo Box - 40");
        System.out.println("4. Combo Broaster - 35");

        opcion = sc.nextInt();

        System.out.println("INGRESE CANTIDAD:");
        cantidad = sc.nextInt();

        switch (opcion) {

            case 1:
                total += 65 * cantidad;
                break;

            case 2:
                total += 80 * cantidad;
                break;

            case 3:
                total += 40 * cantidad;
                break;

            case 4:
                total += 35 * cantidad;
                break;

            default:
                System.out.println("OPCION INVALIDA");

        }

    }

    public static void menuHamburguesas() {

        int opcion, cantidad;

        System.out.println("\n======= HAMBURGUESAS =======");
        System.out.println("1. Chicken Burger - 18");
        System.out.println("2. Cheese Burger - 22");
        System.out.println("3. BBQ Burger - 24");
        System.out.println("4. Burger XL - 28");

        opcion = sc.nextInt();

        System.out.println("CANTIDAD:");
        cantidad = sc.nextInt();

        switch (opcion) {

            case 1:
                total += 18 * cantidad;
                break;

            case 2:
                total += 22 * cantidad;
                break;

            case 3:
                total += 24 * cantidad;
                break;

            case 4:
                total += 28 * cantidad;
                break;

            default:
                System.out.println("OPCION INVALIDA");

        }

    }

    public static void menuPollo() {

        int opcion, cantidad;

        System.out.println("\n========= POLLO =========");
        System.out.println("1. 2 Piezas - 15");
        System.out.println("2. 4 Piezas - 28");
        System.out.println("3. 6 Piezas - 40");
        System.out.println("4. 12 Piezas - 75");

        opcion = sc.nextInt();

        System.out.println("CANTIDAD:");
        cantidad = sc.nextInt();

        switch (opcion) {

            case 1:
                total += 15 * cantidad;
                break;

            case 2:
                total += 28 * cantidad;
                break;

            case 3:
                total += 40 * cantidad;
                break;

            case 4:
                total += 75 * cantidad;
                break;

            default:
                System.out.println("OPCION INVALIDA");

        }

    }

    public static void menuComplementos() {

        int opcion, cantidad;

        System.out.println("\n======= COMPLEMENTOS =======");
        System.out.println("1. Papas Fritas - 10");
        System.out.println("2. Nuggets - 15");
        System.out.println("3. Aros de Cebolla - 12");
        System.out.println("4. Ensalada - 8");

        opcion = sc.nextInt();

        System.out.println("CANTIDAD:");
        cantidad = sc.nextInt();

        switch (opcion) {

            case 1:
                total += 10 * cantidad;
                break;

            case 2:
                total += 15 * cantidad;
                break;

            case 3:
                total += 12 * cantidad;
                break;

            case 4:
                total += 8 * cantidad;
                break;

            default:
                System.out.println("OPCION INVALIDA");

        }

    }

    public static void menuBebidas() {

        int opcion, cantidad;

        System.out.println("\n========= BEBIDAS =========");
        System.out.println("1. Pepsi - 8");
        System.out.println("2. Inca Kola - 8");
        System.out.println("3. Agua - 5");
        System.out.println("4. Sprite - 7");

        opcion = sc.nextInt();

        System.out.println("CANTIDAD:");
        cantidad = sc.nextInt();

        switch (opcion) {

            case 1:
                total += 8 * cantidad;
                break;

            case 2:
                total += 8 * cantidad;
                break;

            case 3:
                total += 5 * cantidad;
                break;

            case 4:
                total += 7 * cantidad;
                break;

            default:
                System.out.println("OPCION INVALIDA");

        }

    }

    public static void menuPostres() {

        int opcion, cantidad;

        System.out.println("\n========= POSTRES =========");
        System.out.println("1. Sundae - 8");
        System.out.println("2. Brownie - 10");
        System.out.println("3. Pie de Manzana - 7");
        System.out.println("4. Helado - 6");

        opcion = sc.nextInt();

        System.out.println("CANTIDAD:");
        cantidad = sc.nextInt();

        switch (opcion) {

            case 1:
                total += 8 * cantidad;
                break;

            case 2:
                total += 10 * cantidad;
                break;

            case 3:
                total += 7 * cantidad;
                break;

            case 4:
                total += 6 * cantidad;
                break;

            default:
                System.out.println("OPCION INVALIDA");

        }

    }

    public static void menuInfantil() {

        int opcion;

        System.out.println("\n======= MENU INFANTIL =======");
        System.out.println("1. Nuggets Kids - 18");
        System.out.println("2. Mini Burger Kids - 20");
        System.out.println("3. Cajita Feliz KFC - 25");

        opcion = sc.nextInt();

        switch (opcion) {

            case 1:
                total += 18;
                break;

            case 2:
                total += 20;
                break;

            case 3:
                total += 25;
                break;

            default:
                System.out.println("OPCION INVALIDA");

        }

    }

    public static void menuSalsas() {

        int opcion;

        System.out.println("\n=========== SALSAS ===========");
        System.out.println("1. BBQ - 2");
        System.out.println("2. Mostaza - 2");
        System.out.println("3. Ají - 2");
        System.out.println("4. Mayonesa - 2");

        opcion = sc.nextInt();

        switch (opcion) {

            case 1:
            case 2:
            case 3:
            case 4:
                total += 2;
                break;

            default:
                System.out.println("OPCION INVALIDA");

        }

    }

    public static void menuPromociones() {

        int opcion;

        do {

            System.out.println("\n======= PROMOCIONES =======");
            System.out.println("1. Promos Familiares");
            System.out.println("2. Promos Hamburguesas");
            System.out.println("3. Volver");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    promosFamiliares();
                    break;

                case 2:
                    promosHamburguesas();
                    break;

                case 3:
                    System.out.println("VOLVIENDO...");
                    break;

                default:
                    System.out.println("OPCION INVALIDA");

            }

        } while (opcion != 3);

    }

    public static void promosFamiliares() {

        int opcion;

        System.out.println("\n===== PROMOS FAMILIARES =====");
        System.out.println("1. Familiar XL - 99");
        System.out.println("2. Bucket + Pepsi - 85");
        System.out.println("3. Combo Familiar - 70");

        opcion = sc.nextInt();

        switch (opcion) {

            case 1:
                total += 99;
                break;

            case 2:
                total += 85;
                break;

            case 3:
                total += 70;
                break;

            default:
                System.out.println("OPCION INVALIDA");

        }

    }

    public static void promosHamburguesas() {

        int opcion;

        System.out.println("\n===== PROMOS HAMBURGUESAS =====");
        System.out.println("1. 2 Chicken Burger - 35");
        System.out.println("2. Burger XL Combo - 30");
        System.out.println("3. Cheese Burger + Papas - 28");

        opcion = sc.nextInt();

        switch (opcion) {

            case 1:
                total += 35;
                break;

            case 2:
                total += 30;
                break;

            case 3:
                total += 28;
                break;

            default:
                System.out.println("OPCION INVALIDA");

        }

    }

    public static void delivery() {

        int opcion;
        String distrito;
        String referencia;

        System.out.println("\n=========== DELIVERY ===========");
        System.out.println("1. Solicitar Delivery");
        System.out.println("2. Cancelar");

        opcion = sc.nextInt();
        sc.nextLine();

        if (opcion == 1) {

            System.out.println("INGRESE SU DIRECCION:");
            direccion = sc.nextLine();

            System.out.println("INGRESE SU DISTRITO:");
            distrito = sc.nextLine();

            System.out.println("INGRESE UNA REFERENCIA:");
            referencia = sc.nextLine();

            total += 8;

            System.out.println("\nDELIVERY AGREGADO");
            System.out.println("UBICACION DEL PEDIDO:");
            System.out.println("DIRECCION: " + direccion);
            System.out.println("DISTRITO: " + distrito);
            System.out.println("REFERENCIA: " + referencia);
            System.out.println("COSTO DELIVERY: S/ 8");

        } else {

            System.out.println("DELIVERY CANCELADO");

        }

    }

    public static void cupones() {

        String cupon;

        sc.nextLine();

        System.out.println("INGRESE CUPON:");
        cupon = sc.nextLine();

        if (cupon.equalsIgnoreCase("KFC10")) {

            total = total - 10;
            System.out.println("CUPON APLICADO");

        } else {

            System.out.println("CUPON INVALIDO");

        }

    }

    public static void clienteVIP() {

        int puntos;

        System.out.println("INGRESE SUS PUNTOS VIP:");
        puntos = sc.nextInt();

        if (puntos >= 100) {

            total = total - 20;
            System.out.println("DESCUENTO VIP APLICADO");

        } else {

            System.out.println("NO TIENE PUNTOS SUFICIENTES");

        }

    }

    public static void mostrarTotal() {

        System.out.println("TOTAL ACTUAL: " + total);

    }

    public static void aplicarDescuento() {

        double descuento;

        if (total >= 200) {

            descuento = total * 0.20;
            total = total - descuento;

            System.out.println("SE APLICO 20% DE DESCUENTO");

        } else if (total >= 100) {

            descuento = total * 0.10;
            total = total - descuento;

            System.out.println("SE APLICO 10% DE DESCUENTO");

        } else {

            System.out.println("NO HAY DESCUENTO");

        }

    }

    public static void seleccionarMetodoPago() {

        int opcion;

        System.out.println("\n======= METODO DE PAGO =======");
        System.out.println("1. Efectivo");
        System.out.println("2. Tarjeta");
        System.out.println("3. Yape");

        opcion = sc.nextInt();

        switch (opcion) {

            case 1:
                metodoPago = "EFECTIVO";
                pagoEfectivo();
                break;

            case 2:
                metodoPago = "TARJETA";
                pagoTarjeta();
                break;

            case 3:
                metodoPago = "YAPE";
                pagoYape();
                break;

            default:
                System.out.println("OPCION INVALIDA");

        }

    }

    public static void pagoEfectivo() {

        double monto;

        do {

            System.out.println("INGRESE MONTO:");
            monto = sc.nextDouble();

        } while (monto < total);

        System.out.println("VUELTO: " + (monto - total));

    }

    public static void pagoTarjeta() {

        long tarjeta;

        System.out.println("INGRESE NUMERO DE TARJETA:");
        tarjeta = sc.nextLong();

        System.out.println("PAGO EXITOSO");

    }

    public static void pagoYape() {

        int celular;

        System.out.println("INGRESE NUMERO YAPE:");
        celular = sc.nextInt();

        System.out.println("PAGO EXITOSO");

    }

    public static void generarBoleta() {

        double igv;
        double subtotal;

        igv = total * 0.18;
        subtotal = total - igv;

        System.out.println("\n====================================");
        System.out.println("              BOLETA KFC            ");
        System.out.println("====================================");
        System.out.println("CLIENTE: " + cliente);
        System.out.println("DIRECCION: " + direccion);
        System.out.println("METODO DE PAGO: " + metodoPago);
        System.out.println("SUBTOTAL: S/ " + subtotal);
        System.out.println("IGV: S/ " + igv);
        System.out.println("TOTAL: S/ " + total);
        System.out.println("====================================");

    }

    public static void despedida() {

        System.out.println("GRACIAS POR SU COMPRA");
        System.out.println("VUELVA PRONTO A KFC");

    }

}