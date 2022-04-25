import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        processar();
    }

    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


    public static int menu(Scanner sc) {
        limparTela();
        System.out.println("Agenda de Compromisso");
        System.out.println("==========================");
        System.out.println("1 - Add Compromisso");
        System.out.println("2 - Add Compromissos Periodicos");
        System.out.println("3 - Relatorio por um periodo");
        System.out.println("4 - Buscar por um compromisso");
        System.out.println("5 - Listar todos Compromisso");
        System.out.println("0 - Sair");
        int opcao = sc.nextInt();
        sc.nextLine();
        return opcao;
    }

    static void pausa(Scanner sc) {
        System.out.println("Enter para continuar.");
        sc.nextLine();
    }

    public static Compromisso criandoCompromisso(Scanner sc) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Qual é a descrição do compromisso ?");
        String description = sc.nextLine();
        System.out.println("Qual é a data ?");
        String date = sc.nextLine();
        return new Compromisso(description, formato.parse(date));
    }


    public static void processar() throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        int opcao = -1;
        Scanner sc = new Scanner(System.in);
        Compromisso compromisso = null;
        do {
            opcao = menu(sc);
            limparTela();
            switch (opcao) {
                case 1:
                    compromisso = criandoCompromisso(sc);
                    Agenda.addCompromisso(new Compromisso(compromisso));
                    System.out.println("Compromisso Agendado com Sucesso!!");
                    break;
                case 2:
                    compromisso = criandoCompromisso(sc);
                    System.out.println("Favor digitar o intervalo entre as datas");
                    int periodo = sc.nextInt();
                    System.out.println("Favor digitar quantidade de vezes");
                    int quantidade = sc.nextInt();
                    Agenda.periodicos(compromisso, periodo, quantidade);
                    System.out.println("Compromissos Agendados com Sucesso!!");
                    break;
                case 3:
                    System.out.println("Data inicio");
                    String dateInicio = sc.nextLine();
                    System.out.println("Data Final");
                    String dateFinal = sc.nextLine();
                    System.out.println(Agenda.relatorioPerido(formato.parse(dateInicio), formato.parse(dateFinal)));
                    break;
                case 4:
                    System.out.println("Digite a data que deseja saber");
                    String date = sc.nextLine();
                    System.out.println(Agenda.buscarCompromisso(formato.parse(date)));
                    break;
                case 5:
                    System.out.println(Agenda.pecorrerList());
                    break;
                case 6:
                    limparTela();
            }
            pausa(sc);
        } while (opcao != 0);

    }


}
