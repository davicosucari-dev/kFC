import java.util.Scanner;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

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
        System.out.println("              KFC PERU              ");
        System.out.println("====================================");
        System.out.println("       PROMOCIONES Y OFERTAS        ");
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

        boolean datosCorrectos = false;

        System.out.println("\n=========== REGISTRO ===========");

        do {

            System.out.print("Ingrese su nombre: ");
            nombreUsuario = escaner.nextLine();

            System.out.print("Ingrese su correo: ");
            correoUsuario = escaner.nextLine();

            System.out.print("Cree una contraseña: ");
            contraseñaUsuario = escaner.nextLine();

            boolean correoOk =
                    correoUsuario.contains("@")
                            && correoUsuario.endsWith(".com");

            boolean passOk =
                    contraseñaUsuario.length() >= 8
                            && (contraseñaUsuario.contains("@")
                            || contraseñaUsuario.contains("#"));

            if (correoOk && passOk) {

                datosCorrectos = true;

                System.out.println("REGISTRO EXITOSO");
                System.out.println("BIENVENIDO " + nombreUsuario);

            } else {

                System.out.println("ERROR EN EL REGISTRO");

                if (!correoOk) {

                    System.out.println("El correo debe contener @ y .com");

                }

                if (!passOk) {

                    System.out.println("La contraseña debe tener minimo 8 caracteres");
                    System.out.println("y contener @ o #");

                }

            }

        } while (!datosCorrectos);

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
                continue;

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
            System.out.println("4. Postres");
            System.out.println("5. Finalizar Compra");
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

                    menuPostres();
                    break;

                case 5:

                    double montoPagado;

                    montoPagado = metodoPago();

                    generarBoleta(montoPagado);

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

            System.out.println("\n=========== POLLO BROASTER ===========");
            System.out.println("1. 2 Presas ............ S/ 12.90");
            System.out.println("2. 4 Presas ............ S/ 24.90");
            System.out.println("3. 6 Presas ............ S/ 35.90");
            System.out.println("4. 8 Presas ............ S/ 45.90");
            System.out.println("5. Alitas BBQ .......... S/ 16.90");
            System.out.println("6. Nuggets ............. S/ 15.90");
            System.out.println("7. Combo Familiar ...... S/ 55.90");
            System.out.println("8. Big Box ............. S/ 28.90");
            System.out.println("9. Twister ............. S/ 18.90");
            System.out.println("10. Volver");

            System.out.print("Seleccione opcion: ");
            opcion = escaner.nextInt();

            if (opcion >= 1 && opcion <= 9) {

                System.out.print("Ingrese cantidad: ");
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

                    case 5:
                        total += 16.90 * cantidad;
                        break;

                    case 6:
                        total += 15.90 * cantidad;
                        break;

                    case 7:
                        total += 55.90 * cantidad;
                        break;

                    case 8:
                        total += 28.90 * cantidad;
                        break;

                    case 9:
                        total += 18.90 * cantidad;
                        break;

                }

                System.out.println("PRODUCTO AGREGADO");
                System.out.println("TOTAL ACTUAL: S/ " + total);

            }

        } while (opcion != 10);

    }

    public static double menuBebidas(double total) {

        int opcion;
        int cantidad;
        double subtotal = 0;

        do {

            System.out.println("\n=========== BEBIDAS ===========");
            System.out.println("1. Inca Kola 500ml ........ S/ 4.90");
            System.out.println("2. Inca Kola 1L ........... S/ 7.00");
            System.out.println("3. Coca Cola 500ml ........ S/ 4.90");
            System.out.println("4. Coca Cola 1L ........... S/ 7.00");
            System.out.println("5. Fanta 500ml ............ S/ 4.90");
            System.out.println("6. Sprite 500ml ........... S/ 4.90");
            System.out.println("7. Agua San Luis .......... S/ 4.50");
            System.out.println("8. Inca Kola 1.5L ......... S/ 10.00");
            System.out.println("9. Coca Cola 1.5L ......... S/ 10.00");
            System.out.println("10. Volver");

            System.out.print("Seleccione opcion: ");
            opcion = escaner.nextInt();

            if (opcion >= 1 && opcion <= 9) {

                System.out.print("Ingrese cantidad: ");
                cantidad = escaner.nextInt();

                switch (opcion) {

                    case 1:
                        subtotal = 4.90 * cantidad;
                        break;

                    case 2:
                        subtotal = 7.00 * cantidad;
                        break;

                    case 3:
                        subtotal = 4.90 * cantidad;
                        break;

                    case 4:
                        subtotal = 7.00 * cantidad;
                        break;

                    case 5:
                        subtotal = 4.90 * cantidad;
                        break;

                    case 6:
                        subtotal = 4.90 * cantidad;
                        break;

                    case 7:
                        subtotal = 4.50 * cantidad;
                        break;

                    case 8:
                        subtotal = 10.00 * cantidad;
                        break;

                    case 9:
                        subtotal = 10.00 * cantidad;
                        break;

                }

                total += subtotal;

                System.out.println("BEBIDA AGREGADA");
                System.out.println("TOTAL ACTUAL: S/ " + total);

            }

        } while (opcion != 10);

        return total;

    }

    public static void menuComplementos() {

        int opcion;
        int cantidad;

        do {

            System.out.println("\n=========== COMPLEMENTOS ===========");
            System.out.println("1. Nuggets ............ S/ 16.90");
            System.out.println("2. Hot Wings .......... S/ 17.90");
            System.out.println("3. Papa Familiar ...... S/ 11.90");
            System.out.println("4. Papa Personal ...... S/ 6.90");
            System.out.println("5. Ensalada ........... S/ 5.90");
            System.out.println("6. Salsa BBQ .......... S/ 2.50");
            System.out.println("7. Salsa Golf ......... S/ 2.50");
            System.out.println("8. Volver");

            System.out.print("Seleccione opcion: ");
            opcion = escaner.nextInt();

            if (opcion >= 1 && opcion <= 7) {

                System.out.print("Ingrese cantidad: ");
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
                        total += 6.90 * cantidad;
                        break;

                    case 5:
                        total += 5.90 * cantidad;
                        break;

                    case 6:
                        total += 2.50 * cantidad;
                        break;

                    case 7:
                        total += 2.50 * cantidad;
                        break;

                }

                System.out.println("COMPLEMENTO AGREGADO");
                System.out.println("TOTAL ACTUAL: S/ " + total);

            }

        } while (opcion != 8);

    }

    public static void menuPostres() {

        int opcion;
        int cantidad;

        do {

            System.out.println("\n=========== POSTRES ===========");
            System.out.println("1. Sundae Chocolate ..... S/ 6.90");
            System.out.println("2. Sundae Fresa ......... S/ 6.90");
            System.out.println("3. Pie de Manzana ....... S/ 5.90");
            System.out.println("4. Helado Vainilla ...... S/ 4.90");
            System.out.println("5. Volver");

            System.out.print("Seleccione opcion: ");
            opcion = escaner.nextInt();

            if (opcion >= 1 && opcion <= 4) {

                System.out.print("Ingrese cantidad: ");
                cantidad = escaner.nextInt();

                switch (opcion) {

                    case 1:
                        total += 6.90 * cantidad;
                        break;

                    case 2:
                        total += 6.90 * cantidad;
                        break;

                    case 3:
                        total += 5.90 * cantidad;
                        break;

                    case 4:
                        total += 4.90 * cantidad;
                        break;

                }

                System.out.println("POSTRE AGREGADO");
                System.out.println("TOTAL ACTUAL: S/ " + total);

            }

        } while (opcion != 5);

    }

    public static double metodoPago() {

        int opcionPago;
        double montoPagado = 0;

        System.out.println("\n=========== METODO DE PAGO ===========");
        System.out.println("1. Efectivo");
        System.out.println("2. Tarjeta");
        System.out.println("3. Yape");

        System.out.print("Seleccione metodo de pago: ");
        opcionPago = escaner.nextInt();
        escaner.nextLine();

        switch (opcionPago) {

            case 1:

                montoPagado = validarPagoEfectivo(total);
                break;

            case 2:

                validaPagoTarjeta(escaner, total);
                montoPagado = total;
                break;

            case 3:

                pagoYape();
                montoPagado = total;
                break;

            default:

                System.out.println("OPCION INVALIDA");

        }

        return montoPagado;

    }

    public static double validarPagoEfectivo(double total) {

        double montoPagado;

        do {

            System.out.println("TOTAL A PAGAR: S/ " + total);

            System.out.print("Ingrese monto a pagar: ");
            montoPagado = escaner.nextDouble();

            if (montoPagado < total) {

                System.out.println("MONTO INSUFICIENTE");
                System.out.println("FALTA: S/ " + (total - montoPagado));

            }

        } while (montoPagado < total);

        return montoPagado;

    }

    public static void validaPagoTarjeta(Scanner escaner, double total) {

        String nroTarjeta;
        String fechaVencimiento;
        String cvv;

        boolean pagoAprobado = false;

        System.out.println("Monto total a pagar con tarjeta es: S/ " + total);

        do {

            System.out.println("Ingrese los 16 digitos de la tarjeta");
            nroTarjeta = escaner.nextLine();

            System.out.println("Ingrese la fecha de caducidad (MM/AA)");
            fechaVencimiento = escaner.nextLine();

            System.out.println("Ingrese el codigo de seguridad CVV");
            cvv = escaner.nextLine();

            boolean tarjetaOk = (nroTarjeta.length() == 16);

            boolean cvvOk = (cvv.length() == 3);

            boolean fechaEstructuraOk =
                    (fechaVencimiento.length() == 5
                            && fechaVencimiento.contains("/"));

            boolean fechaNoVencida = false;

            if (fechaEstructuraOk) {

                try {

                    DateTimeFormatter formateador =
                            DateTimeFormatter.ofPattern("MM/yy");

                    YearMonth fechaTarjeta =
                            YearMonth.parse(fechaVencimiento, formateador);

                    YearMonth fechaActual = YearMonth.now();

                    if (fechaTarjeta.isAfter(fechaActual)
                            || fechaTarjeta.equals(fechaActual)) {

                        fechaNoVencida = true;

                    }

                } catch (DateTimeParseException e) {

                    fechaEstructuraOk = false;

                }

            }

            if (tarjetaOk && fechaEstructuraOk
                    && fechaNoVencida && cvvOk) {

                System.out.println("AUTORIZANDO FONDOS...");
                System.out.println("TRANSACCION EXITOSA");

                pagoAprobado = true;

            } else {

                System.out.println("OPERACION DENEGADA");

                if (!tarjetaOk) {

                    System.out.println("La tarjeta debe tener 16 digitos");

                }

                if (!cvvOk) {

                    System.out.println("El CVV debe tener 3 digitos");

                }

                if (!fechaEstructuraOk) {

                    System.out.println("Formato de fecha incorrecto");

                }

                if (fechaEstructuraOk && !fechaNoVencida) {

                    System.out.println("Tarjeta vencida");

                }

            }

        } while (!pagoAprobado);

    }

    public static void pagoYape() {

        String numero;
        boolean pagoCorrecto = false;

        do {

            System.out.print("Ingrese numero Yape: ");
            numero = escaner.nextLine();

            if (numero.length() == 9) {

                System.out.println("PAGO REALIZADO CON YAPE");
                pagoCorrecto = true;

            } else {

                System.out.println("Numero incorrecto");

            }

        } while (!pagoCorrecto);

    }

    public static void generarBoleta(double montoPagado) {

        double igv = total * 0.18;
        double subtotal = total - igv;
        double vuelto = montoPagado - total;

        System.out.println("\n========================================");
        System.out.println("               KFC PERU                 ");
        System.out.println("========================================");
        System.out.println("             BOLETA DE VENTA            ");
        System.out.println("========================================");

        System.out.println("CLIENTE: " + nombreUsuario);
        System.out.println("TIPO: RECOJO EN TIENDA");

        System.out.println("----------------------------------------");

        System.out.println("SUBTOTAL:            S/ " + subtotal);
        System.out.println("IGV (18%):           S/ " + igv);
        System.out.println("TOTAL:               S/ " + total);

        System.out.println("----------------------------------------");

        System.out.println("PAGO:                S/ " + montoPagado);
        System.out.println("VUELTO:              S/ " + vuelto);

        System.out.println("----------------------------------------");

        System.out.println("GRACIAS POR SU COMPRA");
        System.out.println("VUELVA PRONTO A KFC");

        System.out.println("========================================");

    }

    public static void salirSistema() {

        System.out.println("\nGRACIAS POR VISITAR KFC");
        System.out.println("VUELVA PRONTO");

    }

}