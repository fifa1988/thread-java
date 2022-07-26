import java.time.LocalDateTime;
import java.util.List;

public class ThreadSearch extends Thread {
    LocalDateTime dataHoraInicio;
    LocalDateTime dataHoraFm;
    List<String> lista;
    boolean finished = false;
    public ThreadSearch(LocalDateTime dataHoraInicio, LocalDateTime dataHoraFm, List<String> lista) {
	    this.dataHoraInicio = dataHoraInicio;
	    this.dataHoraFm = dataHoraFm;
	    this.lista = lista;
    }
    @Override
    public void run(){
    	String data = dataHoraInicio.toString() + " - " + dataHoraFm.toString();
    	System.out.println(data + " - Chamando consulta");
    	System.out.println(data + " - Query Executando");
    	lista.add(dataHoraInicio.toString() + " - " + dataHoraFm.toString());
    	System.out.println(data + " - Fim query");
    	finished = true;
    }
    
    
}
