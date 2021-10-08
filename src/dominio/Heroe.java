package dominio;

public class Heroe extends Personaje {

	private String nombre;
	private Arma[] inventario;
	private ClaseDeHeroe clase;
	private Integer contadorDeAtaques;
	private final Integer BONUSATAQUECRITICO;

	public Heroe(String nombre, int eleccionClase) {
		this.nombre = nombre;
		inventario = new Arma[10];
		this.contadorDeAtaques=0;
		switch (eleccionClase) {
		case 1: { // MAGO
			this.setPuntosDeAtaque(20);
			this.setPuntosDeVida(50);
			this.setCadaTantosAtaquesNormalesLanzaUnAtaqueCritico(4);
			this.setPuntosDeDefensa(20);
			this.BONUSATAQUECRITICO = 5;
			clase = ClaseDeHeroe.MAGO;
			break;
		}
		case 2: { // PALADIN
			this.setPuntosDeAtaque(15);
			this.setPuntosDeVida(60);
			this.setCadaTantosAtaquesNormalesLanzaUnAtaqueCritico(6);
			this.setPuntosDeDefensa(25);
			this.BONUSATAQUECRITICO = 3;
			clase = ClaseDeHeroe.PALADIN;
			break;
		}
		case 3: { // ASESINO
			this.setPuntosDeAtaque(25);
			this.setPuntosDeVida(40);
			this.setCadaTantosAtaquesNormalesLanzaUnAtaqueCritico(5);
			this.setPuntosDeDefensa(5);
			this.BONUSATAQUECRITICO = 2;
			clase = ClaseDeHeroe.ASESINO;
			break;
		}
		case 4: { // CABALLERO
			this.setPuntosDeAtaque(20);
			this.setPuntosDeVida(50);
			this.setCadaTantosAtaquesNormalesLanzaUnAtaqueCritico(3);
			this.setPuntosDeDefensa(20);
			this.BONUSATAQUECRITICO = 4;
			clase = ClaseDeHeroe.CABALLERO;
			break;
		}
		default:
			this.setPuntosDeAtaque(20);
			this.setPuntosDeVida(50);
			this.setCadaTantosAtaquesNormalesLanzaUnAtaqueCritico(3);
			this.setPuntosDeDefensa(20);
			this.BONUSATAQUECRITICO = 4;
			clase = ClaseDeHeroe.CABALLERO;
			break;
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ClaseDeHeroe getClase() {
		return clase;
	}

	public void setClase(ClaseDeHeroe clase) {
		this.clase = clase;
	}

	public Integer getContadorDeAtaques() {
		return contadorDeAtaques;
	}

	public void setContadorDeAtaques(Integer contadorDeAtaques) {
		this.contadorDeAtaques = contadorDeAtaques;
	}

	public Arma[] getInventario() {
		return this.inventario;
	}

	public void setInventario(Arma inventario) {
		if(!elInventarioEstaLLeno()) {
			for( int i = 0; i < this.inventario.length; i++) {
				if(this.inventario[i]==null) {
					this.inventario[i]= inventario;
					i = 10;
				}
			}
		}
	}
	
	public boolean elInventarioEstaLLeno() {
		boolean estaLLeno = false;
		int contadorObjetosInventario = 0;
		int i;
		for( i=0 ; i < this.inventario.length; i++) {
			if(this.inventario[i]!=null) {
				contadorObjetosInventario++;
			}
		}
		if(contadorObjetosInventario == this.inventario.length) {
			estaLLeno = true;
		}else {
			estaLLeno = false;
		}
		return estaLLeno;
	}
	
	private Integer sumaDeDañoDeArmasEnInventario() {
		Integer suma=0;
		for (int i = 0; i < this.inventario.length; i++) {
			if(this.inventario[i]!=null) {
				suma += this.inventario[i].getSumaAtaque();
			}
		}
		return suma;
	}

	@Override
	public void atacar(Personaje objetivo) {
		Integer dañoRealizado = 0;
		if ( ( ++this.contadorDeAtaques ) == this.getCadaTantosAtaquesNormalesLanzaUnAtaqueCritico() ) {
			dañoRealizado = ( ( this.BONUSATAQUECRITICO * this.getPuntosDeAtaque() ) + sumaDeDañoDeArmasEnInventario() ) - objetivo.getPuntosDeDefensa(); 
			this.contadorDeAtaques = 0;
		}else {
			dañoRealizado = ( this.getPuntosDeAtaque() + sumaDeDañoDeArmasEnInventario() ) - objetivo.getPuntosDeDefensa(); 
			this.contadorDeAtaques++;
		}
		if(dañoRealizado > 0) {
			objetivo.setPuntosDeVida(objetivo.getPuntosDeVida() - dañoRealizado);
		}else {
			if(dañoRealizado < 0) {
				this.setPuntosDeVida(getPuntosDeVida() - ( objetivo.getPuntosDeDefensa() - dañoRealizado ));
			}
		}
		
	}

	
}
