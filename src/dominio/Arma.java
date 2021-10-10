package dominio;

public class Arma {
	
	private String nombre;
	private Integer sumaAtaque;
	private Integer sumaDefensa;
	
	public Arma(String nombre, Integer sumaAtaque, Integer sumaDefensa) {
		this.nombre = nombre;
		this.sumaAtaque=sumaAtaque;
		this.sumaDefensa=sumaDefensa;
	}

	public Integer getSumaAtaque() {
		return sumaAtaque;
	}

	public void setSumaAtaque(Integer sumaAtaque) {
		this.sumaAtaque = sumaAtaque;
	}

	public Integer getSumaDefensa() {
		return sumaDefensa;
	}

	public void setSumaDefensa(Integer sumaDefensa) {
		this.sumaDefensa = sumaDefensa;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((sumaAtaque == null) ? 0 : sumaAtaque.hashCode());
		result = prime * result + ((sumaDefensa == null) ? 0 : sumaDefensa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arma other = (Arma) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (sumaAtaque == null) {
			if (other.sumaAtaque != null)
				return false;
		} else if (!sumaAtaque.equals(other.sumaAtaque))
			return false;
		if (sumaDefensa == null) {
			if (other.sumaDefensa != null)
				return false;
		} else if (!sumaDefensa.equals(other.sumaDefensa))
			return false;
		return true;
	}
	
	

}
