package entidades;

import org.joda.time.DateTime;

import estadosDispositivos.EstadoDispositivo;

public class AdapterDispIntFabA extends DispositivoInteligente{
	private FabricanteA fabric;
	
	 
    public AdapterDispIntFabA(String nom, Integer fab,EstadoDispositivo estado, Double consumoPorHora, Double consumoEnAhorro){ 
    	super(nom,fab,estado,consumoPorHora,consumoEnAhorro);  
        this.fabric = new FabricanteA();      
    }
    
    @Override
    public boolean estaEncendido(){
    	boolean estado = (fabric.status == 1);
    	return estado;
    }
    
    @Override
    public void apagarDispositivo(){
    	fabric.status = 0;
    }
    
    @Override
    public void encenderDispositivo(){
    	fabric.status = 1;
	}
    
    @Override
    public void ponerEnModoAhorro(){
    	fabric.status = 2;
	}
    
    @Override
	public Double consumoPeriodo(DateTime fechaDesde, DateTime fechaHasta) {
		
		return fabric.consumoPeriodo(fechaDesde,fechaHasta);
	}
}
