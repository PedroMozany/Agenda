import java.text.SimpleDateFormat;
import java.util.Date;

public class Compromisso {

    private String description;
    private Date data;
    private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");


    public Compromisso(Compromisso compromisso) {
        this.description = compromisso.description;
        this.data = compromisso.data;
    }

    public Compromisso(String description, Date data) {
        this.description = description;
        this.data = data;
    }

    public Date getData() {
        return this.data;
    }

    public void setData(Date data) {
        this.data = data;
    }


    public String toString() {
        return "Data: " + formato.format(this.data) + "\n" +
                "Descrição: " + this.description + "\n" +
                "=========================================== \n";
    }


}




