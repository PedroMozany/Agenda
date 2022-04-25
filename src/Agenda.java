import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Agenda {

    private static List<Compromisso> listCompromisso = new LinkedList<>();
    private static Calendar calendar = Calendar.getInstance();

    /**
     * Metado para Add um obtjeto do tipo compromisso em uma lista sem retorno
     * @param compromisso
     */
    public static void addCompromisso(Compromisso compromisso) {
        listCompromisso.add(compromisso);
    }

    /**
     * Metodo para add comprimissos periodicos conforme intervalo e quantidade de dias.
     * @param compromisso objeto do tipo compromisso
     * @param periodo intervalo entre as datas
     * @param quant quantidade de vez que vai ser add
     */
    public static void periodicos(Compromisso compromisso, int periodo, int quant) {
        calendar.setTime(compromisso.getData());
        addCompromisso(new Compromisso(compromisso));
        for (int i = 0; i < quant; ++i) {
            calendar.add(Calendar.DAY_OF_MONTH, periodo);
            compromisso.setData(calendar.getTime());
            System.out.println(compromisso);
            addCompromisso(new Compromisso(compromisso));
        }
    }

    /**
     * Metodo que vai gerar um relatorio entre duas datas.
     * @param dataIncio
     * @param dataFinal
     * @return vai returna uma string dentro do periodo
     */
    public static String relatorioPerido(Date dataIncio, Date dataFinal) {
        StringBuilder sb = new StringBuilder();
        calendar.setTime(listCompromisso.get(0).getData());
        for (Compromisso compromisso : listCompromisso) {
            if (compromisso.getData().equals(dataIncio)) {
                sb.append(compromisso);
            } else if (compromisso.getData().equals(dataFinal)) {
                sb.append(compromisso);
                return sb.toString();
            } else {
                if (!calendar.getTime().before(dataIncio)) {
                    sb.append(compromisso);
                }
            }
            calendar.setTime(compromisso.getData());
        }
        return sb.toString();
    }


    /**
     * Vai percorrer toda a lista
     * @return vai returna todos os compromisso add na lista
     */
    public static String pecorrerList() {
        StringBuilder sb = new StringBuilder();
        for (Compromisso compromisso : listCompromisso) {
            sb.append(compromisso);
        }
        return sb.toString();
    }

    /**
     * Vai pecorrer a lista buscanco um comprimisso pela data
     * @param date
     * @return vai returna o comprimisso que foi solicitado
     */
    public static String buscarCompromisso(Date date) {
        StringBuilder sb = new StringBuilder();
        for (Compromisso compromisso : listCompromisso) {
            if(compromisso.getData().equals(date)) {
                sb.append(compromisso);
            }
        }
        return sb.toString();
    }

}
