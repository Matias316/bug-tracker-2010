package unlp.edu.core;


public class Estado {
	
	private Long id;
	private String descripcion;
	private TipoItem tipoItem;
	
	public Estado(){
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	/**
	 * Metodos
	 */


	public void setTipoItem(TipoItem tipoItem) {
		this.tipoItem = tipoItem;
	}

	public TipoItem getTipoItem() {
		return tipoItem;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estado other = (Estado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
