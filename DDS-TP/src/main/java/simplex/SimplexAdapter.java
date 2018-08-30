package simplex;

import org.apache.commons.math3.exception.TooManyIterationsException;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.linear.Relationship;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;

import simplex.facade.SimplexFacade;
import utilidades.Simplex;

public class SimplexAdapter extends Simplex {

	private SimplexFacade simplex;
	private PointValuePair solucion;
	
	public SimplexAdapter(GoalType objetivo){
		SimplexFacade simplexFacade = new SimplexFacade(objetivo, true);
		this.simplex = simplexFacade;
	}
	
	@Override
	public PointValuePair getSolucion() {
		return this.solucion;
	}

	@Override
	public void funcionEconomica(double... cantidad) {
		this.simplex.crearFuncionEconomica(cantidad);
		
	}

	@Override
	public void restriccion(Relationship unComparador, double valorAcomprar, double... consumoDispositivos) {
		this.simplex.agregarRestriccion(unComparador, valorAcomprar, consumoDispositivos);
		
	}

	@Override
	public void resolver() throws TooManyIterationsException {
		solucion = this.simplex.resolver();
		
	}

}
