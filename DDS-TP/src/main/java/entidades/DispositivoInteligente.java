package entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;

import estadosDispositivos.EstadoDispositivo;

public class DispositivoInteligente extends Dispositivo{

	private Double consumoPorHora;
	private Double consumoPorHoraEnAhorro;
	private List<EstadoDispositivo> estados = new ArrayList<>();
	
	public DispositivoInteligente(String nombre, Integer idFab, EstadoDispositivo estado, Double consumoPorHora, Double consumoEnAhorro) {
		super(nombre, idFab);
		this.setConsumoPorHora(consumoPorHora);
		this.setConsumoPorHoraEnAhorro(consumoEnAhorro);
		this.estados.add(estado);
	}
	
	public boolean estaEncendido(){
		return this.ultimoEstado().estaEncendido();
	}
	
	public void apagarDispositivo(){
		this.ultimoEstado().apagarDispositivo(this);
	}
	
	public void encenderDispositivo(){
		this.ultimoEstado().encenderDispositivo(this);
	}
	
	public void ponerEnModoAhorro(){
		this.ultimoEstado().ponerEnModoAhorro(this);
	}
	
	public void addEstado(EstadoDispositivo estadoDispositivo) {
        this.estados.add(estadoDispositivo);
    }
	
	private EstadoDispositivo ultimoEstado(){
        return this.estados.get(estados.size()-1);
    }
	
	public Double getConsumoPorHora() {
		return consumoPorHora;
	}

	public void setConsumoPorHora(Double consumoPorHora) {
		this.consumoPorHora = consumoPorHora;
	}

	public Double getConsumoPorHoraEnAhorro() {
		return consumoPorHoraEnAhorro;
	}

	public void setConsumoPorHoraEnAhorro(Double consumoPorHoraEnAhorro) {
		this.consumoPorHoraEnAhorro = consumoPorHoraEnAhorro;
	}	
	
//Calcular el consumo del periodo del dispositivo Inteligente
	@Override
	public Double consumoPeriodo(DateTime fechaDesde, DateTime fechaHasta) {
		
		return null;
	}


}
