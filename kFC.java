import java.util.Scanner;

public class kFC {

    static Scanner escaner = new Scanner(System.in);

    static String nombreUsuario = "";
    static String correoUsuario = "";
    static String contraseñaUsuario = "";

    static boolean sesionIniciada = false;

    static double total = 0;

    public static void main(String[] args) {

        mostrarBienvenida();
        menuInicio();

    }

    public static void mostrarBienvenida() {

        System.out.println("====================================");
        System.out.println("             KFC PERU               ");
        System.out.println("====================================");
        System.out.println("      PROMOCIONES Y OFERTAS KFC     ");
        System.out.println("====================================");

    }

    public static void menuInicio() {

        int opcion;

        do {

            System.out.println("\n=========== MENU INICIO ===========");
            System.out.println("1. Iniciar Sesion");
            System.out.println("2. Registrarse");
            System.out.println("3. Ingresar como Invitado");
            System.out.println("4. Salir");

            System.out.print("Seleccione una opcion: ");
            opcion = escaner.nextInt();
            escaner.nextLine();

            switch (opcion) {

                case 1:

                    loginUsuario(escaner);

                    if (sesionIniciada) {

                        menuPrincipal();

                    }

                    break;

                case 2:

                    registrarse();
                    break;

                case 3:

                    ingresarInvitado();
                    menuPrincipal();
                    break;

                case 4:

                    salirSistema();
                    break;

                default:

                    System.out.println("OPCION INVALIDA");

            }

        } while (opcion != 4);

    }

    public static void registrarse() {

        System.out.println("\n=========== REGISTRO ===========");

        System.out.print("Ingrese su nombre: ");
        nombreUsuario = escaner.nextLine();

        System.out.print("Ingrese su correo: ");
        correoUsuario = escaner.nextLine();

        System.out.print("Cree una contraseña: ");
        contraseñaUsuario = escaner.nextLine();

        System.out.println("REGISTRO EXITOSO");
        System.out.println("BIENVENIDO " + nombreUsuario);

    }

    public static String loginUsuario(Scanner escaner) {

        String correoIn;
        String passIn;

        boolean ingresoExitoso = false;

        System.out.println("\n======= INICIAR SESION =======");

        do {

            System.out.print("Ingrese su correo: ");
            correoIn = escaner.nextLine();

            System.out.print("Ingrese su contraseña: ");
            passIn = escaner.nextLine();

            boolean correoOk =
                    correoIn.contains("@")
                            && correoIn.endsWith(".com");

            boolean passOk =
                    passIn.length() >= 8
                            && (passIn.contains("@")
                            || passIn.contains("#"));

            if (!correoOk || !passOk) {

                System.out.println("ERROR EN LOS DATOS");

                if (!correoOk) {

                    System.out.println("El correo debe contener @ y .com");

                }

                if (!passOk) {

                    System.out.println("La contraseña debe tener minimo 8 caracteres");
                    System.out.println("y contener @ o #");

                }

                System.out.println("¿Desea cancelar? (S/N)");
                String cancelar = escaner.nextLine();

                if (cancelar.equalsIgnoreCase("S")) {

                    break;

                } else {

                    continue;

                }

            }

            if (correoIn.equals(correoUsuario)
                    && passIn.equals(contraseñaUsuario)) {

                ingresoExitoso = true;

                sesionIniciada = true;

                System.out.println("INICIO DE SESION EXITOSO");
                System.out.println("BIENVENIDO " + nombreUsuario);

            } else {

                System.out.println("CREDENCIALES INCORRECTAS");

            }

        } while (!ingresoExitoso);

        return nombreUsuario;

    }

    public static void ingresarInvitado() {

        System.out.println("\n======= MODO INVITADO =======");

        System.out.print("Ingrese su nombre: ");
        nombreUsuario = escaner.nextLine();

        System.out.println("BIENVENIDO " + nombreUsuario);

    }

    public static void menuPrincipal() {

        int opcion;

        do {

            System.out.println("\n============= MENU KFC =============");
            System.out.println("1. Pollo Broaster");
            System.out.println("2. Bebidas");
            System.out.println("3. Complementos");
            System.out.println("4. Ver Total");
            System.out.println("5. Generar Boleta");
            System.out.println("6. Salir");

            System.out.print("Seleccione una opcion: ");
            opcion = escaner.nextInt();

            switch (opcion) {

                case 1:

                    menuPolloBroaster();
                    break;

                case 2:

                    total = menuBebidas(total);
                    break;

                case 3:

                    menuComplementos();
                    break;

                case 4:

                    System.out.println("TOTAL ACTUAL: S/ " + total);
                    break;

                case 5:

                    generarBoleta();
                    break;

                case 6:

                    System.out.println("SALIENDO...");
                    break;

                default:

                    System.out.println("OPCION INVALIDA");

            }

        } while (opcion != 6);

    }

    public static void menuPolloBroaster() {

        int opcion;
        int cantidad;

        do {

            System.out.println("\n=========== POLLO BROASTER KFC ===========");
            System.out.println("1. 2 Presas de Pollo ............ S/ 12.90");
            System.out.println("2. 4 Presas de Pollo ............ S/ 24.90");
            System.out.println("3. 6 Presas de Pollo ............ S/ 35.90");
            System.out.println("4. 8 Presas de Pollo ............ S/ 45.90");
            System.out.println("5. Volver");

            System.out.print("SELECCIONE UNA OPCION: ");
            opcion = escaner.nextInt();

            if (opcion >= 1 && opcion <= 4) {

                System.out.print("INGRESE CANTIDAD: ");
                cantidad = escaner.nextInt();

                switch (opcion) {

                    case 1:

                        total += 12.90 * cantidad;
                        break;

                    case 2:

                        total += 24.90 * cantidad;
                        break;

                    case 3:

                        total += 35.90 * cantidad;
                        break;

                    case 4:

                        total += 45.90 * cantidad;
                        break;

                }

                System.out.println("PRODUCTO AGREGADO");
                System.out.println("TOTAL ACTUAL: S/ " + total);

            }

        } while (opcion != 5);

    }

    public static double menuBebidas(double total) {

        int opcion;
        int cantidad;
        double subtotal = 0;

        do {

            System.out.println("\n=========== BEBIDAS KFC ===========");
            System.out.println("1. Inca Kola Zero 500ml - S/ 4.90");
            System.out.println("2. Inca Kola Zero 1L - S/ 7.00");
            System.out.println("3. Inca Kola Zero 1.5L - S/ 10.00");
            System.out.println("4. Coca Cola Zero 500ml - S/ 4.90");
            System.out.println("5. Coca Cola Zero 1L - S/ 7.00");
            System.out.println("6. Coca Cola Zero 1.5L - S/ 10.00");
            System.out.println("7. Fanta Naranja 500ml - S/ 4.90");
            System.out.println("8. Sprite 500ml - S/ 4.90");
            System.out.println("9. Agua San Luis 750ml - S/ 4.50");
            System.out.println("10. Volver");

            System.out.print("SELECCIONE UNA OPCION: ");
            opcion = escaner.nextInt();

            if (opcion >= 1 && opcion <= 9) {

                System.out.print("INGRESE CANTIDAD: ");
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
                        subtotal = 4.90 * cantidad;
                        break;

                    case 9:
                        subtotal = 4.50 * cantidad;
                        break;

                }

                total += subtotal;

                System.out.println("BEBIDA AGREGADA");
                System.out.println("TOTAL ACTUAL: S/ " + total);

            } else if (opcion == 10) {

                System.out.println("VOLVIENDO AL MENU...");

            } else {

                System.out.println("OPCION INVALIDA");

            }

        } while (opcion != 10);

        return total;

    }


    public static void menuComplementos() {

        int opcion;
        int cantidad;

        do {

            System.out.println("\n=========== COMPLEMENTOS KFC ===========");
            System.out.println("1. Nuggets ............ S/ 16.90");
            System.out.println("2. Hot Wings .......... S/ 17.90");
            System.out.println("3. Papa Familiar ...... S/ 11.90");
            System.out.println("4. Ensalada ........... S/ 5.90");
            System.out.println("5. Volver");

            System.out.print("SELECCIONE UNA OPCION: ");
            opcion = escaner.nextInt();

            if (opcion >= 1 && opcion <= 4) {

                System.out.print("INGRESE CANTIDAD: ");
                cantidad = escaner.nextInt();

                switch (opcion) {

                    case 1:

                        total += 16.90 * cantidad;
                        break;

                    case 2:

                        total += 17.90 * cantidad;
                        break;

                    case 3:

                        total += 11.90 * cantidad;
                        break;

                    case 4:

                        total += 5.90 * cantidad;
                        break;

                }

                System.out.println("COMPLEMENTO AGREGADO");
                System.out.println("TOTAL ACTUAL: S/ " + total);

            } else if (opcion == 5) {

                System.out.println("VOLVIENDO AL MENU...");

            } else {

                System.out.println("OPCION INVALIDA");

            }

        } while (opcion != 5);

    }

    public static void generarBoleta() {

        double igv;
        double subtotal;

        igv = total * 0.18;
        subtotal = total - igv;

        System.out.println("\n========================================");
        System.out.println("               KFC PERU                 ");
        System.out.println("========================================");
        System.out.println("            BOLETA DE VENTA             ");
        System.out.println("========================================");
        System.out.println("RUC: 20100190797");
        System.out.println("LOCAL: KFC PUNO");
        System.out.println("DIRECCION: JR. LIMA 456");
        System.out.println("----------------------------------------");
        System.out.println("CLIENTE: " + nombreUsuario);
        System.out.println("FECHA: 19/05/2026");
        System.out.println("HORA: 07:45 PM");
        System.out.println("----------------------------------------");
        System.out.println("DETALLE DEL PEDIDO");
        System.out.println("----------------------------------------");
        System.out.println("Consumo KFC");
        System.out.println("Subtotal:              S/ " + subtotal);
        System.out.println("IGV (18%):             S/ " + igv);
        System.out.println("TOTAL:                 S/ " + total);
        System.out.println("----------------------------------------");
        System.out.println("METODO DE PAGO: EFECTIVO");
        System.out.println("----------------------------------------");
        System.out.println("        GRACIAS POR SU COMPRA           ");
        System.out.println("        VUELVA PRONTO A KFC             ");
        System.out.println("========================================");

    }

    public static void salirSistema() {

        System.out.println("\nGRACIAS POR VISITAR KFC");
        System.out.println("VUELVA PRONTO");

    }

}