package simplex;

import java.util.Arrays;
import java.util.List;

import simplex.facade.*;
import utilidades.Simplex;

import org.apache.commons.math3.exception.TooManyIterationsException;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.linear.Relationship;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;

import entidades.DispositivoInteligente;

public class SimplexAdapter extends Simplex{
	private SimplexFacade simplex;
	private PointValuePair solucion;
	
	public SimplexAdapter(GoalType objetivo) {	
		SimplexFacade simplexFacade = new SimplexFacade(objetivo, true);
		this.simplex = simplexFacade;
	}

	public void funcionEconomica(double ... cantidad){
		this.simplex.crearFuncionEconomica(cantidad);
	}

	public void restriccion(Relationship unComparador, double valorAcomprar, double ... consumoDispositivos){
		this.simplex.agregarRestriccion(unComparador, valorAcomprar, consumoDispositivos);
	}

	public void resolver() throws TooManyIterationsException{
		solucion = this.simplex.resolver();
	}

	public PointValuePair getSolucion() {
		return this.solucion;
	}
}
