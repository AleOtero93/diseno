package estadosDispositivos;

import org.joda.time.LocalDateTime;
import entidades.DispositivoInteligente;

public interface EstadoDispositivo {

	public void apagarDispositivo(DispositivoInteligente dispositivo);
    public void encenderDispositivo(DispositivoInteligente dispositivo);
    public void ponerEnModoAhorro(DispositivoInteligente dispositivo);
    
    public void setFechaFin(LocalDateTime fecha);

    public double obtenerConsumo(DispositivoInteligente dispositivo);

    boolean estaEncendido();
    Double consumoPeriodo(LocalDateTime fechaDesde, LocalDateTime fechaHasta, DispositivoInteligente dispositivo);	
}
