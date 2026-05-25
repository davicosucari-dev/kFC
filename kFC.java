import java.util.Scanner;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class kFC {

    public static void main(String[] args) {
        Scanner escaner = new Scanner(System.in);
        String nombreUsuario = "";
        String correoUsuario = "";
        String contraseñaUsuario = "";
        boolean sesionIniciada = false;
        double total = 0;

        Bienvenida();
        menuInicio(escaner, nombreUsuario, correoUsuario, contraseñaUsuario, sesionIniciada, total);
    }

    public static void Bienvenida() {
        System.out.println("================================================");
        System.out.println("           SEA UD BIENVENIDO A KFC              ");
        System.out.println("================================================");
    }

    public static void menuInicio(Scanner escaner, String nombreUsuario, String correoUsuario, String contraseñaUsuario, boolean sesionIniciada, double total) {
        int opcion;
        do {
            System.out.println("=========== MENU INICIO ===========");
            System.out.println("1. Iniciar Sesion");
            System.out.println("2. Registrarse");
            System.out.println("3. Ingresar como Invitado");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = escaner.nextInt();
            escaner.nextLine();
            switch (opcion) {
                case 1:
                    if (correoUsuario.isEmpty()) {
                        System.out.println("ERROR: Debe registrarse primero");
                        break;
                    }
                    if (loginUsuario(escaner, correoUsuario, contraseñaUsuario)) {
                        sesionIniciada = true;
                        total = menuPrincipal(escaner, nombreUsuario, total);
                    }
                    break;
                case 2:
                    String datos = registrarse(escaner);
                    String[] partes = datos.split(",");
                    nombreUsuario = partes[0];
                    correoUsuario = partes[1];
                    contraseñaUsuario = partes[2];
                    break;
                case 3:
                    nombreUsuario = ingresarInvitado(escaner);
                    total = menuPrincipal(escaner, nombreUsuario, total);
                    break;
                case 4:
                    salirSistema();
                    break;
                default:
                    System.out.println("OPCION INVALIDA");
            }
        } while (opcion != 4);
    }
    public static String registrarse(Scanner escaner) {
        boolean datosCorrectos = false;
        String nombre, correo, contraseña;

        System.out.println("=========== REGISTRO ===========");
        do {
            System.out.print("Ingrese su nombre: ");
            nombre = escaner.nextLine();
            System.out.print("Ingrese su correo: ");
            correo = escaner.nextLine();
            System.out.print("Cree una contraseña (min. 8 caracteres): ");
            contraseña = escaner.nextLine();

            boolean correoOk = correo.contains("@") && correo.endsWith(".com");
            boolean passOk = contraseña.length() >= 8;

            if (correoOk && passOk) {
                datosCorrectos = true;
                System.out.println("REGISTRO EXITOSO. BIENVENIDO " + nombre);
            } else {
                System.out.println("ERROR EN EL REGISTRO");
                if (!correoOk)
                    System.out.println("El correo debe contener @ y .com");
                if (!passOk)
                    System.out.println("La contraseña debe tener minimo 8 caracteres");
            }
        } while (!datosCorrectos);

        return nombre + "," + correo + "," + contraseña;
    }

    public static boolean loginUsuario(Scanner escaner, String correoUsuario, String contraseñaUsuario) {
        String correoIn, passIn;
        boolean ingresoExitoso = false;

        System.out.println("======= INICIAR SESION =======");
        do {
            System.out.print("Ingrese su correo: ");
            correoIn = escaner.nextLine();
            System.out.print("Ingrese su contraseña: ");
            passIn = escaner.nextLine();

            if (correoIn.equals(correoUsuario) && passIn.equals(contraseñaUsuario)) {
                ingresoExitoso = true;
                System.out.println("INICIO DE SESION EXITOSO");
                return true;
            } else {
                System.out.println("CREDENCIALES INCORRECTAS. Intente nuevamente.");
            }
        } while (!ingresoExitoso);

        return false;
    }

    public static String ingresarInvitado(Scanner escaner) {
        System.out.println("======= MODO INVITADO =======");
        System.out.print("Ingrese su nombre: ");
        String nombre = escaner.nextLine();
        System.out.println("BIENVENIDO " + nombre);
        return nombre;
    }

    public static double menuPrincipal(Scanner escaner, String nombreUsuario, double total) {
        int opcion;
        do {
            System.out.println("============ MENU KFC =============");
            System.out.println("1. Pollo Broaster");
            System.out.println("2. Bebidas");
            System.out.println("3. Complementos");
            System.out.println("4. Postres");
            System.out.println("5. Finalizar Compra");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = escaner.nextInt();
            escaner.nextLine();

            switch (opcion) {
                case 1:
                    total = menuPolloBroaster(escaner, total);
                    break;
                case 2:
                    total = menuBebidas(escaner, total);
                    break;
                case 3:
                    total = menuComplementos(escaner, total);
                    break;
                case 4:
                    total = menuPostres(escaner, total);
                    break;
                case 5:
                    if (total > 0) {
                        double montoPagado = metodoPago(escaner, total);
                        generarBoleta(nombreUsuario, total, montoPagado);
                        total = 0;
                    } else {
                        System.out.println("Su carrito está vacío.");
                    }
                    break;
                case 6:
                    System.out.println("Cerrando menú...");
                    break;
                default: System.out.println("OPCION INVALIDA");
            }
        } while (opcion != 6);

        return total;
    }

    public static double menuPolloBroaster(Scanner escaner, double total) {
        int opcion, cantidad;
        do {
            System.out.println("=========== POLLO BROASTER ===========");
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
                System.out.println("TOTAL ACTUAL: S/ " + total);
            }
        } while (opcion != 10);
        return total;
    }

    public static double menuBebidas(Scanner escaner, double total) {
        int opcion, cantidad;
        double subtotal = 0;

        do {
            System.out.println("=========== BEBIDAS ===========");
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

    public static double menuComplementos(Scanner escaner, double total) {
        int opcion, cantidad;
        do {
            System.out.println("=========== COMPLEMENTOS ===========");
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
                System.out.println("TOTAL ACTUAL: S/ " + total);
            }
        } while (opcion != 8);
        return total;
    }

    public static double menuPostres(Scanner escaner, double total) {
        int opcion, cantidad;
        do {
            System.out.println("=========== POSTRES ===========");
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
        return total;
    }

    public static double metodoPago(Scanner escaner, double total) {
        int opcionPago;
        double montoPagado = 0;

        System.out.println("=========== METODO DE PAGO ===========");
        System.out.println("1. Efectivo");
        System.out.println("2. Tarjeta");
        System.out.println("3. Yape");
        System.out.print("Seleccione metodo de pago: ");

        opcionPago = escaner.nextInt();
        escaner.nextLine();

        switch (opcionPago) {
            case 1:
                montoPagado = validarPagoEfectivo(escaner, total);
                break;
            case 2:
                montoPagado = validaPagoTarjeta(escaner, total);
                break;
            case 3:
                montoPagado = pagoYape(escaner, total);
                break;
            default: System.out.println("OPCION INVALIDA"); montoPagado = total;
        }
        return montoPagado;
    }

    public static double validarPagoEfectivo(Scanner escaner, double total) {
        double montoPagado;
        System.out.println("TOTAL A PAGAR: S/ " + total);
        do {
            System.out.print("Ingrese monto a pagar en efectivo: ");
            montoPagado = escaner.nextDouble();
            escaner.nextLine();
            if (montoPagado < total) {
                System.out.println("MONTO INSUFICIENTE. FALTA: S/ " + (total - montoPagado));
            }
        } while (montoPagado < total);
        return montoPagado;
    }
    public static double validaPagoTarjeta(Scanner escaner, double total) {

        String nroTarjeta, fechaVencimiento, cvv;
        boolean pagoAprobado = false;
        double montoPagado;

        System.out.println("TOTAL A PAGAR CON TARJETA: S/ " + total);

        do {
            System.out.print("Ingrese monto a debitar de la tarjeta: ");
            montoPagado = escaner.nextDouble();
            escaner.nextLine();

            if (montoPagado < total) {
                System.out.println("MONTO INSUFICIENTE. FALTA: S/ " + (total - montoPagado));
            }

        } while (montoPagado < total);

        do {

            System.out.println("Ingrese los 16 digitos de la tarjeta:");
            nroTarjeta = escaner.nextLine();

            System.out.println("Ingrese la fecha de caducidad (MM/AA):");
            fechaVencimiento = escaner.nextLine();

            System.out.println("Ingrese el codigo de seguridad CVV:");
            cvv = escaner.nextLine();

            boolean tarjetaOk = (nroTarjeta.length() == 16);
            boolean cvvOk = (cvv.length() == 3);

            boolean fechaEstructuraOk = false;
            boolean fechaNoVencida = false;

            try {

                DateTimeFormatter formateador = DateTimeFormatter.ofPattern("MM/yy");
                YearMonth fechaTarjeta = YearMonth.parse(fechaVencimiento, formateador);
                int mes = fechaTarjeta.getMonthValue();

                if (mes >= 1 && mes <= 12) {

                    fechaEstructuraOk = true;

                    YearMonth fechaActual = YearMonth.now();
                    if (!fechaTarjeta.isBefore(fechaActual)) {
                        fechaNoVencida = true;
                    }
                }

            } catch (DateTimeParseException e) {

                fechaEstructuraOk = false;
            }

            if (tarjetaOk && fechaEstructuraOk && fechaNoVencida && cvvOk) {

                System.out.println("TRANSACCION EXITOSA");
                pagoAprobado = true;

            } else {

                System.out.println("OPERACION DENEGADA - DATOS INCORRECTOS");
            }

        } while (!pagoAprobado);

        return montoPagado;
    }
    public static double pagoYape(Scanner escaner, double total) {

        String numero, codV;
        boolean pagoCorrecto = false;
        double montoPagado;

        System.out.println("TOTAL A PAGAR CON YAPE: S/ " + total);

        do {

            System.out.print("Ingrese monto a Yapear: ");
            montoPagado = escaner.nextDouble();
            escaner.nextLine();

            if (montoPagado < total) {
                System.out.println("MONTO INSUFICIENTE. FALTA: S/ " + (total - montoPagado));
            }

        } while (montoPagado < total);

        do {

            System.out.print("Ingrese numero Yape (9 digitos): ");
            numero = escaner.nextLine();

            System.out.print("Ingrese su codigo de validacion: ");
            codV = escaner.nextLine();

            if (numero.length() == 9 && codV.length() == 3) {

                System.out.println("PAGO REALIZADO CON YAPE");
                pagoCorrecto = true;

            } else {

                System.out.println("Numero o codigo incorrecto, intente nuevamente.");
            }

        } while (!pagoCorrecto);

        return montoPagado;
    }
    public static void generarBoleta(String nombreUsuario, double total, double montoPagado) {
        double igv = (total * 0.18);
        double subtotal = (total - igv);
        double vuelto = (montoPagado - total);

        System.out.println("=======================================");
        System.out.println("                KFC                  ");
        System.out.println("========================================");
        System.out.println("          BOLETA DE VENTA            ");
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
        System.out.println("========================================");
    }

    public static void salirSistema() {
        System.out.println("GRACIAS POR VISITAR KFC. LO ESPERAMOS PRONTO .");
    }
}
