package utilidades;

import java.util.Arrays;
import java.util.List;

import simplex.facade.*;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.linear.Relationship;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;

import entidades.DispositivoInteligente;

public class SimplexAdapater extends Simplex{
	private SimplexFacade simplex;
	
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
		this = this.simplex;
		solucion = this.simplex.optimize(
			new MaxIter(100),
			this.funcionEconomica,
			new LinearConstraintSet(this.restricciones),
			this.objetivo,
			new NonNegativeConstraint(this.variablesPositivas)
		);
	}

	public PointValuePair getSolucion() {
		return this.solucion;
	}
}
