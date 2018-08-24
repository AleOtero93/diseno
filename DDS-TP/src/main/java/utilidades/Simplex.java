package utilidades;

import java.util.Arrays;
import java.util.List;

import simplex.facade.*;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.linear.Relationship;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;

import entidades.DispositivoInteligente;

public abstract class Simplex {
	private PointValuePair solucion;

	abstract public PointValuePair getSolucion();
	abstract public void funcionEconomica(double ... cantidad);
	abstract public void restriccion(Relationship unComparador, double valorAcomprar, double ... consumoDispositivos);
	abstract public PointValuePair resolver() throws TooManyIterationsException;
}
