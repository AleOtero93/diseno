package utilidades;

import java.util.Arrays;
import java.util.List;

import simplex.facade.*;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.linear.Relationship;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;

import entidades.DispositivoInteligente;

public class Simplex {
	private PointValuePair solucion;
	
	public Simplex(List<DispositivoInteligente> dispositivosInteligentes) {
		double[] cantDispositivos = new double[dispositivosInteligentes.size()];
		double[] consumoDispositivos = new double[dispositivosInteligentes.size()];
		double[] dispositivoFill = new double[dispositivosInteligentes.size()];
		
		for (int i=0;i<dispositivosInteligentes.size();i++) {
		    cantDispositivos[i] = 1;
		    consumoDispositivos[i] = dispositivosInteligentes.get(i).getConsumoPorHora();
		}
		
		SimplexFacade simplexFacade = new SimplexFacade(GoalType.MAXIMIZE, true);
		simplexFacade.crearFuncionEconomica(cantDispositivos);
		
		simplexFacade.agregarRestriccion(Relationship.LEQ, 440640, 	consumoDispositivos);
		
		int usoMaximo = 0;
		int usoMinimo = 0;
		for (int i=0;i<dispositivosInteligentes.size();i++) {
			Arrays.fill(dispositivoFill, 0);
			dispositivoFill[i] = 1;
			usoMaximo = dispositivosInteligentes.get(i).getUsoMaximo();
			usoMinimo = dispositivosInteligentes.get(i).getUsoMinimo();
			simplexFacade.agregarRestriccion(Relationship.GEQ, usoMinimo, dispositivoFill);
			simplexFacade.agregarRestriccion(Relationship.LEQ, usoMaximo, dispositivoFill);
		}
		
		PointValuePair solucion = simplexFacade.resolver();
		this.solucion = solucion;
	}
	
	public PointValuePair getSolucion() {
		return this.solucion;
	}
}
