package model;

public class Huespedes {
	
    private Integer id;

    private String nombre;

    private String apellido;

    private String fechaNacimiento;
    
    private String nacionalidad;
    
    private String telefono;
    
    private Integer reservas_id;

	public Huespedes(
			String nombre, 
			String apellido, 
			String fechaNacimiento, 
			String nacionalidad, 
			String telefono,
			Integer reservas_id
			) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.reservas_id = reservas_id;
	}

	public Huespedes(
			String nombre, 
			String apellido, 
			String fechaNacimiento,
			String nacionalidad,
			String telefono
			) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
	}
	
	public Huespedes(
			int id,
			String nombre, 
			String apellido, 
			String fechaNacimiento,
			String nacionalidad,
			String telefono
			) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
	}
	
	public Huespedes(
			Integer id,
			String nombre, 
			String apellido, 
			String fechaNacimiento,
			String nacionalidad,
			String telefono,
			Integer reservas_id
			) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.reservas_id = reservas_id;
	}
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Integer getReservas_id() {
		return reservas_id;
	}

	public void setReservas_id(Integer reservas_id) {
		this.reservas_id = reservas_id;
	}

	@Override
	public String toString() {
		return String.format(
				"nombre: %s, apellido: %s,fechaNacimiento: %s, telefono: %s, nacionalidad: %s, reservas_id: %d",
				this.nombre,
				this.apellido,
				this.telefono,
				this.nacionalidad,
				this.reservas_id
				);

	}
}
