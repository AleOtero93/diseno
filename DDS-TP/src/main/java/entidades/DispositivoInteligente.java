package entidades;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDateTime;

import estadosDispositivos.EstadoDispositivo;

public class DispositivoInteligente extends Dispositivo{

	private Integer usoMinimo;
	private Integer usoMaximo;
	private Double consumoPorHora;
	private Double consumoPorHoraEnAhorro;
	private List<EstadoDispositivo> estados = new ArrayList<>();
	
	public DispositivoInteligente(String nombre, Integer idFab, EstadoDispositivo estado, Double consumoPorHora, Double consumoEnAhorro, Integer usoMinimo, Integer usoMaximo) {
		super(nombre, idFab);
		this.setConsumoPorHora(consumoPorHora);
		this.setConsumoPorHoraEnAhorro(consumoEnAhorro);
		this.estados.add(estado);
		this.usoMinimo = usoMinimo;
		this.usoMaximo = usoMaximo;
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
	
	public EstadoDispositivo ultimoEstado(){
        return this.estados.get(estados.size()-1);
    }

    public Integer getUsoMinimo() {
		return usoMinimo;
	}

	public void setUsoMinimo(Integer usoMinimo) {
		this.usoMinimo = usoMinimo;
	}

	public Integer getUsoMaximo() {
		return usoMaximo;
	}

	public void setUsoMaximo(Integer usoMaximo) {
		this.usoMaximo = usoMaximo;
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
	public Double consumoPeriodo(LocalDateTime fechaDesde, LocalDateTime fechaHasta) {
		return this.estados.stream().mapToDouble(estado -> estado.consumoPeriodo(fechaDesde, fechaHasta, this)).sum();

	}



}
