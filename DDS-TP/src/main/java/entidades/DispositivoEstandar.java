package entidades;

public class DispositivoEstandar extends Dispositivo{
	private Integer usoAproximado;
	
	public DispositivoEstandar(String nom, Integer idFab) {
		super(nom,idFab,0);
	}
	public DispositivoEstandar(Dispositivo disp) {
		super(disp.getNombre(),disp.getIdFabrica(),disp.getTipo());
	}
	
	public Integer getUsoAproximado() {
		return usoAproximado;
	}
	public void setUsoAproximado(Integer usoAproximado) {
		this.usoAproximado = usoAproximado;
	}
	
	public DispositivoInteligente ConvertirInteligente() {
		DispositivoInteligente nuevoDispInteligente = new DispositivoInteligente(this);
		return nuevoDispInteligente;
	}
}
