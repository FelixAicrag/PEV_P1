package Gen;

public abstract class Gen<T> {
	
	protected T info;
	protected int longitud;
	public abstract T getInfo();
	public abstract int getLongitud();
}
