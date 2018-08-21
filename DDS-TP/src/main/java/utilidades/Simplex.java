package utilidades;

import java.util.Arrays;
import java.util.List;

import entidades.DispositivoInteligente;

public class Simplex {
	private List<DispositivoInteligente> dispositivosInteligentes;
	
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
		
		int maximo = 0;
		int minimo = 0;
		for (int i=0;i<dispositivosInteligentes.size();i++) {
			Arrays.fill(dispositivoFill, 0);
			dispositivoFill[i] = 1;
			maximo = dispositivosInteligentes.get(i).getConsumoMaximo();
			minimo = dispositivosInteligentes.get(i).getConsumoMinimo();
			simplexFacade.agregarRestriccion(Relationship.GEQ, minimo, dispositivosFill);
			simplexFacade.agregarRestriccion(Relationship.LEQ, maximo, dispositivosFill);
		}
		
		PointValuePair solucion = simplexFacade.resolver();
	}
}
