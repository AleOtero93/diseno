package utilidades;

import org.apache.commons.math3.exception.TooManyIterationsException;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.linear.Relationship;

public abstract class Simplex {
	private PointValuePair solucion;

	abstract public PointValuePair getSolucion();
	abstract public void funcionEconomica(double ... cantidad);
	abstract public void restriccion(Relationship unComparador, double valorAcomprar, double ... consumoDispositivos);
	abstract public void resolver() throws TooManyIterationsException;
}
