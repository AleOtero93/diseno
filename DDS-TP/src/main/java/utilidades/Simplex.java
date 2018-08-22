package utilidades;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.linear.Relationship;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;

import entidades.DispositivoInteligente;

public class Simplex {
	private PointValuePair solucion;
	
	public Simplex(List<DispositivoInteligente> dispositivosInteligentes) {
		int[] cantDispositivos = new int[dispositivosInteligentes.size()];
		double[] consumoDispositivos = new double[dispositivosInteligentes.size()];
		int[] dispositivoFill = new int[dispositivosInteligentes.size()];
		
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
			simplexFacade.agregarRestriccion(Relationship.GEQ, usoMinimo, dispositivosFill);
			simplexFacade.agregarRestriccion(Relationship.LEQ, usoMaximo, dispositivosFill);
		}
		
		PointValuePair solucion = simplexFacade.resolver();
		this.solucion = solucion;
	}
}
